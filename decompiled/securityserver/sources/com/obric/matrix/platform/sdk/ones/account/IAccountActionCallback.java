package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IAccountActionCallback extends IInterface {

    public static class Default implements IAccountActionCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(boolean r1, Bundle r2) {
        }
    }

    public static abstract class Stub extends Binder implements IAccountActionCallback {
        private static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback";
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IAccountActionCallback {
            public static IAccountActionCallback sDefaultImpl;
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

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
            public void onResult(boolean r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L12;
            L16:
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onResult(r4, r5);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAccountActionCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAccountActionCallback) == false) goto L12;
            return (IAccountActionCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static IAccountActionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAccountActionCallback r1) {
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
            if (r5.readInt() == 0) goto L13;
            boolean r8 = true;
        L15:
            if (r5.readInt() == 0) goto L17;
            Bundle r9 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L18:
            onResult(r8, r9);
            return true;
        L17:
            r9 = null;
            goto L18
        L13:
            r8 = false;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onResult(boolean r1, Bundle r2);
}
