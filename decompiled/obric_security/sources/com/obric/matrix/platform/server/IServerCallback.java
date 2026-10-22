package com.obric.matrix.platform.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IServerCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.server.IServerCallback";

    public static class Default implements IServerCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerCallback
        public void onResult(int r1, byte[] r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IServerCallback {
        static final int TRANSACTION_onResult = 1;

        private static class Proxy implements IServerCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IServerCallback.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.server.IServerCallback
            public void onResult(int r4, byte[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IServerCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeByteArray(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IServerCallback.DESCRIPTOR);
        }

        public static IServerCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IServerCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IServerCallback) == false) goto L12;
            return (IServerCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IServerCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IServerCallback.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            onResult(r5.readInt(), r5.createByteArray());
            r6.writeNoException();
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onResult(int r1, byte[] r2) throws RemoteException;
}
