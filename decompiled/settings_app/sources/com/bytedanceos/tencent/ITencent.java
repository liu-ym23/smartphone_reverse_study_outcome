package com.bytedanceos.tencent;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ITencent extends IInterface {
    public static final String DESCRIPTOR = "com.bytedanceos.tencent.ITencent";

    public static class Default implements ITencent {
        @Override // com.bytedanceos.tencent.ITencent
        public int analysisSMS(int r1, String r2, String r3, String r4) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public List<SMTCodeName> getAllBrands(String r1) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public List<SMTCodeName> getAllProvinces() throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public List<SMTCodeName> getBrands(String r1) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public List<SMTCodeName> getCarries() throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public List<SMTCodeName> getCities(String r1) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public int[] getTrafficInfo(int r1) throws RemoteException {
            return null;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public void notifySimcardChange() throws RemoteException {
        }

        @Override // com.bytedanceos.tencent.ITencent
        public void registerCallback(ICallback r1) throws RemoteException {
        }

        @Override // com.bytedanceos.tencent.ITencent
        public int setConfig(int r1, String r2, String r3, String r4, String r5, int r6) throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public int startCorrection(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.bytedanceos.tencent.ITencent
        public void unregisterCallback(ICallback r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ITencent {
        static final int TRANSACTION_analysisSMS = 2;
        static final int TRANSACTION_getAllBrands = 7;
        static final int TRANSACTION_getAllProvinces = 3;
        static final int TRANSACTION_getBrands = 6;
        static final int TRANSACTION_getCarries = 5;
        static final int TRANSACTION_getCities = 4;
        static final int TRANSACTION_getTrafficInfo = 11;
        static final int TRANSACTION_notifySimcardChange = 12;
        static final int TRANSACTION_registerCallback = 9;
        static final int TRANSACTION_setConfig = 8;
        static final int TRANSACTION_startCorrection = 1;
        static final int TRANSACTION_unregisterCallback = 10;

        private static class Proxy implements ITencent {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return ITencent.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public int startCorrection(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public int analysisSMS(int r4, String r5, String r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public List<SMTCodeName> getAllProvinces() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r4 = r1.createTypedArrayList(SMTCodeName.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public List<SMTCodeName> getCities(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r3 = r1.createTypedArrayList(SMTCodeName.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public List<SMTCodeName> getCarries() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r4 = r1.createTypedArrayList(SMTCodeName.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public List<SMTCodeName> getBrands(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r3 = r1.createTypedArrayList(SMTCodeName.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public List<SMTCodeName> getAllBrands(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r3 = r1.createTypedArrayList(SMTCodeName.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public int setConfig(int r4, String r5, String r6, String r7, String r8, int r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                r0.writeString(r8);     // Catch: Throwable -> L6
                r0.writeInt(r9);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r3 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public void registerCallback(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public void unregisterCallback(ICallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public int[] getTrafficInfo(int r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int[] r3 = r1.createIntArray();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedanceos.tencent.ITencent
            public void notifySimcardChange() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ITencent.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ITencent.DESCRIPTOR);
        }

        public static ITencent asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ITencent.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ITencent) == false) goto L12;
            return (ITencent) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(ITencent.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L25;
            switch(r10) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                default: goto L11;
            };
        L12:
            notifySimcardChange();
            r12.writeNoException();
        L24:
            return true;
        L13:
            int[] r9 = getTrafficInfo(r11.readInt());
            r12.writeNoException();
            r12.writeIntArray(r9);
            goto L24
        L14:
            unregisterCallback(ICallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            goto L24
        L15:
            registerCallback(ICallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            goto L24
        L16:
            int r14 = setConfig(r11.readInt(), r11.readString(), r11.readString(), r11.readString(), r11.readString(), r11.readInt());
            r12.writeNoException();
            r12.writeInt(r14);
            goto L24
        L17:
            List<SMTCodeName> r15 = getAllBrands(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r15);
            goto L24
        L18:
            List<SMTCodeName> r16 = getBrands(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r16);
            goto L24
        L19:
            List<SMTCodeName> r17 = getCarries();
            r12.writeNoException();
            r12.writeTypedList(r17);
            goto L24
        L20:
            List<SMTCodeName> r18 = getCities(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r18);
            goto L24
        L21:
            List<SMTCodeName> r19 = getAllProvinces();
            r12.writeNoException();
            r12.writeTypedList(r19);
            goto L24
        L22:
            int r20 = analysisSMS(r11.readInt(), r11.readString(), r11.readString(), r11.readString());
            r12.writeNoException();
            r12.writeInt(r20);
            goto L24
        L23:
            int r21 = startCorrection(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r21);
            goto L24
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L25:
            r12.writeString(ITencent.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        private static <T> T readTypedObject(Parcel r1, Parcelable.Creator<T> r2) {
            if (r1.readInt() != 0) goto L5;
            return null;
        L5:
            return r2.createFromParcel(r1);
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel r1, T r2, int r3) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, r3);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    int analysisSMS(int r1, String r2, String r3, String r4) throws RemoteException;

    List<SMTCodeName> getAllBrands(String r1) throws RemoteException;

    List<SMTCodeName> getAllProvinces() throws RemoteException;

    List<SMTCodeName> getBrands(String r1) throws RemoteException;

    List<SMTCodeName> getCarries() throws RemoteException;

    List<SMTCodeName> getCities(String r1) throws RemoteException;

    int[] getTrafficInfo(int r1) throws RemoteException;

    void notifySimcardChange() throws RemoteException;

    void registerCallback(ICallback r1) throws RemoteException;

    int setConfig(int r1, String r2, String r3, String r4, String r5, int r6) throws RemoteException;

    int startCorrection(int r1) throws RemoteException;

    void unregisterCallback(ICallback r1) throws RemoteException;
}
