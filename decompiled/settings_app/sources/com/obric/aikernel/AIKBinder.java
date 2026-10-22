package com.obric.aikernel;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface AIKBinder extends IInterface {

    public static class Default implements AIKBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aikernel.AIKBinder
        public void autoTest(Bundle r1, AIKListener r2) throws RemoteException {
        }

        @Override // com.obric.aikernel.AIKBinder
        public void callModel(Bundle r1, AIKListener r2) throws RemoteException {
        }

        @Override // com.obric.aikernel.AIKBinder
        public Bundle callModelSync(Bundle r1) throws RemoteException {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements AIKBinder {
        private static final String DESCRIPTOR = "com.obric.aikernel.AIKBinder";
        static final int TRANSACTION_autoTest = 3;
        static final int TRANSACTION_callModel = 2;
        static final int TRANSACTION_callModelSync = 1;

        private static class Proxy implements AIKBinder {
            public static AIKBinder sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.aikernel.AIKBinder
            public Bundle callModelSync(Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                Bundle r4 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r6 = Stub.getDefaultImpl().callModelSync(r5);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.AIKBinder
            public void callModel(Bundle r5, AIKListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                IBinder r3 = r6.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().callModel(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.aikernel.AIKBinder
            public void autoTest(Bundle r5, AIKListener r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                IBinder r3 = r6.asBinder();     // Catch: Throwable -> L20
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().autoTest(r5, r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
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
            attachInterface(this, DESCRIPTOR);
        }

        public static AIKBinder asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof AIKBinder) == false) goto L12;
            return (AIKBinder) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Bundle r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L27;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L27:
            Bundle r4 = callModelSync(r0);
            r7.writeNoException();
            if (r4 == null) goto L30;
            r7.writeInt(1);
            r4.writeToParcel(r7, 1);
        L31:
            return true;
        L30:
            r7.writeInt(0);
            goto L31
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L22;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L22:
            callModel(r0, AIKListener.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L17;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L17:
            autoTest(r0, AIKListener.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r7.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r5, r6, r7, r8);
        }

        public static boolean setDefaultImpl(AIKBinder r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static AIKBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void autoTest(Bundle r1, AIKListener r2) throws RemoteException;

    void callModel(Bundle r1, AIKListener r2) throws RemoteException;

    Bundle callModelSync(Bundle r1) throws RemoteException;
}
