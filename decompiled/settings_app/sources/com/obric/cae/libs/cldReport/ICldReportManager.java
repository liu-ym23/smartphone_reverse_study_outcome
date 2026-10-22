package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICldReportManager extends IInterface {
    public static final int CLD_MODULE_TYPE_BT = 1;
    public static final int CLD_MODULE_TYPE_GNSS = 3;
    public static final int CLD_MODULE_TYPE_LOGCAT = 5;
    public static final int CLD_MODULE_TYPE_NETWORK = 2;
    public static final int CLD_MODULE_TYPE_NFC = 4;
    public static final int CLD_MODULE_TYPE_WIFI = 0;

    public static class Default implements ICldReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void reportErrorEvent(int r1, int r2, int r3, int r4, String r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void startCollect(ICldReportCallback r1, int r2, int r3, int r4, int r5, String r6, boolean r7) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void stopCollect(ICldReportCallback r1, int r2, int r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICldReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportManager";
        static final int TRANSACTION_reportErrorEvent = 1;
        static final int TRANSACTION_startCollect = 2;
        static final int TRANSACTION_stopCollect = 3;

        public static class Proxy implements ICldReportManager {
            public static ICldReportManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void reportErrorEvent(int r9, int r10, int r11, int r12, String r13) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r9);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeString(r13);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportErrorEvent(r9, r10, r11, r12, r13);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void startCollect(ICldReportCallback r12, int r13, int r14, int r15, int r16, String r17, boolean r18) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r12 == null) goto L6;
                IBinder r0 = r12.asBinder();     // Catch: Throwable -> L17
            L7:
                r1.writeStrongBinder(r0);     // Catch: Throwable -> L17
                r1.writeInt(r13);     // Catch: Throwable -> L17
                r1.writeInt(r14);     // Catch: Throwable -> L17
                r1.writeInt(r15);     // Catch: Throwable -> L17
                r1.writeInt(r16);     // Catch: Throwable -> L17
                r1.writeString(r17);     // Catch: Throwable -> L17
                r1.writeInt(r18 ? 1 : 0);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r1, r2, 0) == false) goto L10;
            L14:
                r2.readException();     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().startCollect(r12, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L17
                r2.recycle();
                r1.recycle();
                return;
            L6:
                r0 = null;
            L17:
                th = move-exception;
                r2.recycle();
                r1.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void stopCollect(ICldReportCallback r5, int r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().stopCollect(r5, r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICldReportManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportManager) == false) goto L12;
            return (ICldReportManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICldReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICldReportManager r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r14, Parcel r15, Parcel r16, int r17) throws RemoteException {
            if (r14 != 1) goto L5;
            r15.enforceInterface(DESCRIPTOR);
            reportErrorEvent(r15.readInt(), r15.readInt(), r15.readInt(), r15.readInt(), r15.readString());
            r16.writeNoException();
            return true;
        L5:
            if (r14 != 2) goto L7;
            r15.enforceInterface(DESCRIPTOR);
            ICldReportCallback r6 = ICldReportCallback.Stub.asInterface(r15.readStrongBinder());
            int r7 = r15.readInt();
            int r8 = r15.readInt();
            int r9 = r15.readInt();
            int r10 = r15.readInt();
            String r11 = r15.readString();
            if (r15.readInt() == 0) goto L19;
            boolean r12 = true;
        L20:
            startCollect(r6, r7, r8, r9, r10, r11, r12);
            r16.writeNoException();
            return true;
        L19:
            r12 = false;
            goto L20
        L7:
            if (r14 != 3) goto L9;
            r15.enforceInterface(DESCRIPTOR);
            stopCollect(ICldReportCallback.Stub.asInterface(r15.readStrongBinder()), r15.readInt(), r15.readInt());
            r16.writeNoException();
            return true;
        L9:
            if (r14 != 1598968902) goto L11;
            r16.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r14, r15, r16, r17);
        }
    }

    void reportErrorEvent(int r1, int r2, int r3, int r4, String r5) throws RemoteException;

    void startCollect(ICldReportCallback r1, int r2, int r3, int r4, int r5, String r6, boolean r7) throws RemoteException;

    void stopCollect(ICldReportCallback r1, int r2, int r3) throws RemoteException;
}
