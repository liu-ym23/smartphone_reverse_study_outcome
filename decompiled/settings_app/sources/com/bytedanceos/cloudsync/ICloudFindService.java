package com.bytedanceos.cloudsync;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICloudFindService extends IInterface {
    public static final String DESCRIPTOR = "com.bytedanceos.cloudsync.ICloudFindService";

    public static class Default implements ICloudFindService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedanceos.cloudsync.ICloudFindService
        public void closeFindPhone(String r1, ICloudServerCallBack r2) throws RemoteException {
        }

        @Override // com.bytedanceos.cloudsync.ICloudFindService
        public boolean isBytedanceAccoutLogin() throws RemoteException {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ICloudFindService {
        static final int TRANSACTION_closeFindPhone = 1;
        static final int TRANSACTION_isBytedanceAccoutLogin = 2;

        private static class Proxy implements ICloudFindService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return ICloudFindService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedanceos.cloudsync.ICloudFindService
            public void closeFindPhone(String r4, ICloudServerCallBack r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICloudFindService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
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

            @Override // com.bytedanceos.cloudsync.ICloudFindService
            public boolean isBytedanceAccoutLogin() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICloudFindService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
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
            attachInterface(this, ICloudFindService.DESCRIPTOR);
        }

        public static ICloudFindService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICloudFindService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICloudFindService) == false) goto L12;
            return (ICloudFindService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ICloudFindService.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            if (r4 != 1) goto L11;
            closeFindPhone(r5.readString(), ICloudServerCallBack.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
        L16:
            return true;
        L11:
            if (r4 != 2) goto L13;
            boolean r3 = isBytedanceAccoutLogin();
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ICloudFindService.DESCRIPTOR);
            return true;
        }
    }

    void closeFindPhone(String r1, ICloudServerCallBack r2) throws RemoteException;

    boolean isBytedanceAccoutLogin() throws RemoteException;
}
