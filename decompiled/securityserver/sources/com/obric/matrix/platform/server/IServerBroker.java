package com.obric.matrix.platform.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IServerBroker extends IInterface {

    public static class Default implements IServerBroker {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public byte[] invoke(int r1, byte[] r2) {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void invokeAsyn(int r1, byte[] r2, IServerCallback r3) {
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void registerServerCallback(String r1, IServerCallback r2) {
        }
    }

    public static abstract class Stub extends Binder implements IServerBroker {
        private static final String DESCRIPTOR = "com.obric.matrix.platform.server.IServerBroker";
        static final int TRANSACTION_invoke = 1;
        static final int TRANSACTION_invokeAsyn = 2;
        static final int TRANSACTION_registerServerCallback = 3;

        public static class Proxy implements IServerBroker {
            public static IServerBroker sDefaultImpl;
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

            @Override // com.obric.matrix.platform.server.IServerBroker
            public byte[] invoke(int r5, byte[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeInt(r5);     // Catch: Throwable -> L10
                r0.writeByteArray(r6);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L12:
                r1.readException();     // Catch: Throwable -> L10
                byte[] r4 = r1.createByteArray();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                byte[] r7 = Stub.getDefaultImpl().invoke(r5, r6);     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r7;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void invokeAsyn(int r5, byte[] r6, IServerCallback r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeByteArray(r6);     // Catch: Throwable -> L6
                if (r7 == null) goto L8;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().invokeAsyn(r5, r6, r7);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void registerServerCallback(String r5, IServerCallback r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                if (r6 == null) goto L8;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().registerServerCallback(r5, r6);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r2 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IServerBroker asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IServerBroker) == false) goto L12;
            return (IServerBroker) r0;
        L12:
            return new Proxy(r2);
        }

        public static IServerBroker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IServerBroker r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            byte[] r3 = invoke(r5.readInt(), r5.createByteArray());
            r6.writeNoException();
            r6.writeByteArray(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            invokeAsyn(r5.readInt(), r5.createByteArray(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            registerServerCallback(r5.readString(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    byte[] invoke(int r1, byte[] r2);

    void invokeAsyn(int r1, byte[] r2, IServerCallback r3);

    void registerServerCallback(String r1, IServerCallback r2);
}
