package com.obric.cae.libs.cloud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICloud extends IInterface {

    public static class Default implements ICloud {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void postToCloud(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallback(ICloudEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallbackWithType(int r1, ICloudEventCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void unregisterCallback(ICloudEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void updateUserConfigData(int r1, String r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICloud {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cloud.ICloud";
        static final int TRANSACTION_postToCloud = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerCallbackWithType = 2;
        static final int TRANSACTION_unregisterCallback = 3;
        static final int TRANSACTION_updateUserConfigData = 5;

        public static class Proxy implements ICloud {
            public static ICloud sDefaultImpl;
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void postToCloud(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().postToCloud(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallback(ICloudEventCallback r5) throws RemoteException {
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallbackWithType(int r5, ICloudEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
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
                Stub.getDefaultImpl().registerCallbackWithType(r5, r6);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void unregisterCallback(ICloudEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void updateUserConfigData(int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateUserConfigData(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
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

        public static ICloud asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICloud) == false) goto L12;
            return (ICloud) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICloud getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICloud r1) {
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
            if (r4 == 1598968902) goto L25;
            if (r4 != 1) goto L6;
            r5.enforceInterface(DESCRIPTOR);
            registerCallback(ICloudEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L6:
            if (r4 != 2) goto L8;
            r5.enforceInterface(DESCRIPTOR);
            registerCallbackWithType(r5.readInt(), ICloudEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L8:
            if (r4 != 3) goto L10;
            r5.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICloudEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L10:
            if (r4 != 4) goto L12;
            r5.enforceInterface(DESCRIPTOR);
            postToCloud(r5.readString());
            r6.writeNoException();
            return true;
        L12:
            if (r4 != 5) goto L14;
            r5.enforceInterface(DESCRIPTOR);
            updateUserConfigData(r5.readInt(), r5.readString());
            r6.writeNoException();
            return true;
        L14:
            return super.onTransact(r4, r5, r6, r7);
        L25:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    void postToCloud(String r1) throws RemoteException;

    void registerCallback(ICloudEventCallback r1) throws RemoteException;

    void registerCallbackWithType(int r1, ICloudEventCallback r2) throws RemoteException;

    void unregisterCallback(ICloudEventCallback r1) throws RemoteException;

    void updateUserConfigData(int r1, String r2) throws RemoteException;
}
