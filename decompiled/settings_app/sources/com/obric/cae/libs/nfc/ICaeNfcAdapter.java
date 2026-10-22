package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeNfcAdapter extends IInterface {

    public static class Default implements ICaeNfcAdapter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
        public ICaeNfcEventManager getEventManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
        public ICaeNfcOmapiExecutor getOmapiExecutor() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcAdapter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcAdapter";
        static final int TRANSACTION_getEventManager = 2;
        static final int TRANSACTION_getOmapiExecutor = 1;

        public static class Proxy implements ICaeNfcAdapter {
            public static ICaeNfcAdapter sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
            public ICaeNfcEventManager getEventManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ICaeNfcEventManager r4 = ICaeNfcEventManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ICaeNfcEventManager r5 = Stub.getDefaultImpl().getEventManager();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
            public ICaeNfcOmapiExecutor getOmapiExecutor() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ICaeNfcOmapiExecutor r4 = ICaeNfcOmapiExecutor.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ICaeNfcOmapiExecutor r5 = Stub.getDefaultImpl().getOmapiExecutor();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNfcAdapter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNfcAdapter) == false) goto L12;
            return (ICaeNfcAdapter) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeNfcAdapter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNfcAdapter r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            IBinder r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            ICaeNfcOmapiExecutor r4 = getOmapiExecutor();
            r7.writeNoException();
            if (r4 == null) goto L20;
            r0 = r4.asBinder();
        L20:
            r7.writeStrongBinder(r0);
            return true;
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            ICaeNfcEventManager r9 = getEventManager();
            r7.writeNoException();
            if (r9 == null) goto L15;
            r0 = r9.asBinder();
        L15:
            r7.writeStrongBinder(r0);
            return true;
        L7:
            if (r5 != 1598968902) goto L9;
            r7.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    ICaeNfcEventManager getEventManager() throws RemoteException;

    ICaeNfcOmapiExecutor getOmapiExecutor() throws RemoteException;
}
