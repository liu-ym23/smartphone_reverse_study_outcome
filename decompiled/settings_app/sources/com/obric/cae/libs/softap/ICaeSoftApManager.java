package com.obric.cae.libs.softap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeSoftApManager extends IInterface {

    public static class Default implements ICaeSoftApManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public long getSoftApCapabilityBits() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int getSoftApInterfaceVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public CaeSoftApStatus getStatus() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public void registerCallback(ICaeSoftApCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int startSoftAp(CaeSoftApConfig r1, ICaeSoftApCallback r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public int stopSoftAp() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.softap.ICaeSoftApManager
        public void unregisterCallback(ICaeSoftApCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSoftApManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.softap.ICaeSoftApManager";
        static final int TRANSACTION_getSoftApCapabilityBits = 7;
        static final int TRANSACTION_getSoftApInterfaceVersion = 6;
        static final int TRANSACTION_getStatus = 3;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_startSoftAp = 1;
        static final int TRANSACTION_stopSoftAp = 2;
        static final int TRANSACTION_unregisterCallback = 5;

        public static class Proxy implements ICaeSoftApManager {
            public static ICaeSoftApManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public long getSoftApCapabilityBits() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r2 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r3 = Stub.getDefaultImpl().getSoftApCapabilityBits();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int getSoftApInterfaceVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getSoftApInterfaceVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public CaeSoftApStatus getStatus() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                CaeSoftApStatus r4 = CaeSoftApStatus.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                CaeSoftApStatus r5 = Stub.getDefaultImpl().getStatus();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public void registerCallback(ICaeSoftApCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int startSoftAp(CaeSoftApConfig r6, ICaeSoftApCallback r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                IBinder r4 = r7.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                int r5 = r1.readInt();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                int r8 = Stub.getDefaultImpl().startSoftAp(r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public int stopSoftAp() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().stopSoftAp();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.softap.ICaeSoftApManager
            public void unregisterCallback(ICaeSoftApCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r5);     // Catch: Throwable -> L17
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

        public static ICaeSoftApManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeSoftApManager) == false) goto L12;
            return (ICaeSoftApManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeSoftApManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeSoftApManager r1) {
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 == 1598968902) goto L28;
            switch(r4) {
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            long r3 = getSoftApCapabilityBits();
            r6.writeNoException();
            r6.writeLong(r3);
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            int r8 = getSoftApInterfaceVersion();
            r6.writeNoException();
            r6.writeInt(r8);
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICaeSoftApCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            registerCallback(ICaeSoftApCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            CaeSoftApStatus r9 = getStatus();
            r6.writeNoException();
            if (r9 == null) goto L18;
            r6.writeInt(1);
            r9.writeToParcel(r6, 1);
        L19:
            return true;
        L18:
            r6.writeInt(0);
            goto L19
        L20:
            r5.enforceInterface(DESCRIPTOR);
            int r10 = stopSoftAp();
            r6.writeNoException();
            r6.writeInt(r10);
            return true;
        L22:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L25;
            CaeSoftApConfig r11 = CaeSoftApConfig.CREATOR.createFromParcel(r5);
        L26:
            int r12 = startSoftAp(r11, ICaeSoftApCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r12);
            return true;
        L25:
            r11 = null;
            goto L26
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L28:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    long getSoftApCapabilityBits() throws RemoteException;

    int getSoftApInterfaceVersion() throws RemoteException;

    CaeSoftApStatus getStatus() throws RemoteException;

    void registerCallback(ICaeSoftApCallback r1) throws RemoteException;

    int startSoftAp(CaeSoftApConfig r1, ICaeSoftApCallback r2) throws RemoteException;

    int stopSoftAp() throws RemoteException;

    void unregisterCallback(ICaeSoftApCallback r1) throws RemoteException;
}
