package com.obric.matrix.platform.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IServerBroker extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.server.IServerBroker";

    public static class Default implements IServerBroker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public byte[] invoke(int r1, byte[] r2) throws RemoteException {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void invokeAsyn(int r1, byte[] r2, IServerCallback r3) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void registerServerCallback(String r1, IServerCallback r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IServerBroker {
        static final int TRANSACTION_invoke = 1;
        static final int TRANSACTION_invokeAsyn = 2;
        static final int TRANSACTION_registerServerCallback = 3;

        private static class Proxy implements IServerBroker {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IServerBroker.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public byte[] invoke(int r4, byte[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeByteArray(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                byte[] r3 = r1.createByteArray();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void invokeAsyn(int r4, byte[] r5, IServerCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeByteArray(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void registerServerCallback(String r4, IServerCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IServerBroker.DESCRIPTOR);
        }

        public static IServerBroker asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IServerBroker.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IServerBroker) == false) goto L12;
            return (IServerBroker) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IServerBroker.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IServerBroker.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            byte[] r3 = invoke(r5.readInt(), r5.createByteArray());
            r6.writeNoException();
            r6.writeByteArray(r3);
        L21:
            return true;
        L13:
            if (r4 != 2) goto L15;
            invokeAsyn(r5.readInt(), r5.createByteArray(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L21
        L15:
            if (r4 != 3) goto L17;
            registerServerCallback(r5.readString(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L21
        L17:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    byte[] invoke(int r1, byte[] r2) throws RemoteException;

    void invokeAsyn(int r1, byte[] r2, IServerCallback r3) throws RemoteException;

    void registerServerCallback(String r1, IServerCallback r2) throws RemoteException;
}
