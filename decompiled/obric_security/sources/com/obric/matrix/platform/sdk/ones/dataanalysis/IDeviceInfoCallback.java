package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IDeviceInfoCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback";

    public static class Default implements IDeviceInfoCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
        public void onDeviceId(String r1) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
        public void onInstallId(String r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IDeviceInfoCallback {
        static final int TRANSACTION_onDeviceId = 1;
        static final int TRANSACTION_onInstallId = 2;

        private static class Proxy implements IDeviceInfoCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IDeviceInfoCallback.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
            public void onDeviceId(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IDeviceInfoCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
            public void onInstallId(String r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IDeviceInfoCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDeviceInfoCallback.DESCRIPTOR);
        }

        public static IDeviceInfoCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IDeviceInfoCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDeviceInfoCallback) == false) goto L12;
            return (IDeviceInfoCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IDeviceInfoCallback.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IDeviceInfoCallback.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            onDeviceId(r5.readString());
            r6.writeNoException();
        L18:
            return true;
        L13:
            if (r4 != 2) goto L15;
            onInstallId(r5.readString());
            r6.writeNoException();
            goto L18
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onDeviceId(String r1) throws RemoteException;

    void onInstallId(String r1) throws RemoteException;
}
