package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface ICapabilityManager extends IInterface {

    public static class Default implements ICapabilityManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public int getVersion() {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerFunction(String r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerResultCallback(IErrorCodeCallback r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendActionExecuteResult(String r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterFunction(String r1) {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterResultCallback(IErrorCodeCallback r1) {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityManager {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityManager";
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_registerFunction = 2;
        static final int TRANSACTION_registerResultCallback = 5;
        static final int TRANSACTION_sendActionExecuteResult = 4;
        static final int TRANSACTION_unregisterFunction = 3;
        static final int TRANSACTION_unregisterResultCallback = 6;

        private static class Proxy implements ICapabilityManager {
            public static ICapabilityManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public int getVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerFunction(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerFunction(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerResultCallback(IErrorCodeCallback r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerResultCallback(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendActionExecuteResult(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendActionExecuteResult(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterFunction(String r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterFunction(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterResultCallback(IErrorCodeCallback r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterResultCallback(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICapabilityManager) == false) goto L12;
            return (ICapabilityManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICapabilityManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityManager r1) {
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
            if (r4 == 1598968902) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            unregisterResultCallback(IErrorCodeCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            registerResultCallback(IErrorCodeCallback.Stub.asInterface(r5.readStrongBinder()));
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            sendActionExecuteResult(r5.readString());
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            unregisterFunction(r5.readString());
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            registerFunction(r5.readString());
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            int r3 = getVersion();
            r6.writeNoException();
            r6.writeInt(r3);
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L19:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getVersion();

    void registerFunction(String r1);

    void registerResultCallback(IErrorCodeCallback r1);

    void sendActionExecuteResult(String r1);

    void unregisterFunction(String r1);

    void unregisterResultCallback(IErrorCodeCallback r1);
}
