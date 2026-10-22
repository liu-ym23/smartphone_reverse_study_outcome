package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IAccountActionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback";

    public static class Default implements IAccountActionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(boolean r1, Bundle r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IAccountActionCallback {
        static final int TRANSACTION_onResult = 1;

        private static class Proxy implements IAccountActionCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IAccountActionCallback.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
            public void onResult(boolean r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAccountActionCallback.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                _Parcel.access$100(r0, r5, 0);     // Catch: Throwable -> L10
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IAccountActionCallback.DESCRIPTOR);
        }

        public static IAccountActionCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAccountActionCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAccountActionCallback) == false) goto L12;
            return (IAccountActionCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IAccountActionCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IAccountActionCallback.DESCRIPTOR);
            return true;
        L11:
            if (r4 == 1) goto L15;
            return super.onTransact(r4, r5, r6, r7);
        L15:
            if (r5.readInt() == 0) goto L17;
            boolean r8 = true;
        L18:
            onResult(r8, (Bundle) _Parcel.access$000(r5, Bundle.CREATOR));
            return true;
        L17:
            r8 = false;
            goto L18
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        static /* synthetic */ Object access$000(Parcel r0, Parcelable.Creator r1) {
            return readTypedObject(r0, r1);
        }

        static /* synthetic */ void access$100(Parcel r0, Parcelable r1, int r2) {
            writeTypedObject(r0, r1, r2);
        }

        private static <T> T readTypedObject(Parcel r1, Parcelable.Creator<T> r2) {
            if (r1.readInt() != 0) goto L5;
            return null;
        L5:
            return r2.createFromParcel(r1);
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel r1, T r2, int r3) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, r3);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    void onResult(boolean r1, Bundle r2) throws RemoteException;
}
