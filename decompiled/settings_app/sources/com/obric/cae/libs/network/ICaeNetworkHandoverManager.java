package com.obric.cae.libs.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeNetworkHandoverManager extends IInterface {

    public static class Default implements ICaeNetworkHandoverManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNetworkHandoverManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.network.ICaeNetworkHandoverManager";
        static final int TRANSACTION_registerNetworkHandoverListener = 1;
        static final int TRANSACTION_unregisterNetworkHandoverListener = 2;

        public static class Proxy implements ICaeNetworkHandoverManager {
            public static ICaeNetworkHandoverManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
            public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerNetworkHandoverListener(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
            public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterNetworkHandoverListener(r5);     // Catch: Throwable -> L17
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

        public static ICaeNetworkHandoverManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNetworkHandoverManager) == false) goto L12;
            return (ICaeNetworkHandoverManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeNetworkHandoverManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNetworkHandoverManager r1) {
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
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            registerNetworkHandoverListener(ICaeNetworkHandoverListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            unregisterNetworkHandoverListener(ICaeNetworkHandoverListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void registerNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException;

    void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException;
}
