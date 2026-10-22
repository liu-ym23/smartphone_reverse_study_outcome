package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IDataService extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService";

    public static class Default implements IDataService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public String getDeviceId() throws RemoteException {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public String getInstallId() throws RemoteException {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void onEvent(String r1, String r2) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void registerDeviceInfoListener(IDeviceInfoCallback r1) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void unregisterDeviceInfoListener(IDeviceInfoCallback r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IDataService {
        static final int TRANSACTION_getDeviceId = 1;
        static final int TRANSACTION_getInstallId = 2;
        static final int TRANSACTION_onEvent = 5;
        static final int TRANSACTION_registerDeviceInfoListener = 3;
        static final int TRANSACTION_unregisterDeviceInfoListener = 4;

        private static class Proxy implements IDataService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IDataService.DESCRIPTOR;
            }

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getDeviceId() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getInstallId() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void registerDeviceInfoListener(IDeviceInfoCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void unregisterDeviceInfoListener(IDeviceInfoCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void onEvent(String r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, IDataService.DESCRIPTOR);
        }

        public static IDataService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IDataService.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDataService) == false) goto L12;
            return (IDataService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IDataService.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IDataService.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            String r3 = getDeviceId();
            r6.writeNoException();
            r6.writeString(r3);
        L27:
            return true;
        L13:
            if (r4 != 2) goto L15;
            String r8 = getInstallId();
            r6.writeNoException();
            r6.writeString(r8);
            goto L27
        L15:
            if (r4 != 3) goto L17;
            registerDeviceInfoListener(IDeviceInfoCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L27
        L17:
            if (r4 != 4) goto L19;
            unregisterDeviceInfoListener(IDeviceInfoCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L27
        L19:
            if (r4 != 5) goto L21;
            onEvent(r5.readString(), r5.readString());
            r6.writeNoException();
            goto L27
        L21:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    String getDeviceId() throws RemoteException;

    String getInstallId() throws RemoteException;

    void onEvent(String r1, String r2) throws RemoteException;

    void registerDeviceInfoListener(IDeviceInfoCallback r1) throws RemoteException;

    void unregisterDeviceInfoListener(IDeviceInfoCallback r1) throws RemoteException;
}
