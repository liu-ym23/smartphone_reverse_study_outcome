package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface IDataService extends IInterface {

    public static class Default implements IDataService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public String getDeviceId() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public String getInstallId() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void onEvent(String r1, String r2) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void registerDeviceInfoListener(IDeviceInfoCallback r1) {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void unregisterDeviceInfoListener(IDeviceInfoCallback r1) {
        }
    }

    public static abstract class Stub extends Binder implements IDataService {
        private static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService";
        static final int TRANSACTION_getDeviceId = 1;
        static final int TRANSACTION_getInstallId = 2;
        static final int TRANSACTION_onEvent = 5;
        static final int TRANSACTION_registerDeviceInfoListener = 3;
        static final int TRANSACTION_unregisterDeviceInfoListener = 4;

        public static class Proxy implements IDataService {
            public static IDataService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getDeviceId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L12:
                r1.readException();     // Catch: Throwable -> L10
                String r4 = r1.readString();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                String r5 = Stub.getDefaultImpl().getDeviceId();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r5;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getInstallId() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L12:
                r1.readException();     // Catch: Throwable -> L10
                String r4 = r1.readString();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                String r5 = Stub.getDefaultImpl().getInstallId();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return r5;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void onEvent(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r5);     // Catch: Throwable -> L10
                r0.writeString(r6);     // Catch: Throwable -> L10
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L12:
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onEvent(r5, r6);     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void registerDeviceInfoListener(IDeviceInfoCallback r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L6
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
                Stub.getDefaultImpl().registerDeviceInfoListener(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void unregisterDeviceInfoListener(IDeviceInfoCallback r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L6
            L9:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L6
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L12;
            L16:
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().unregisterDeviceInfoListener(r5);     // Catch: Throwable -> L6
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

        public static IDataService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDataService) == false) goto L12;
            return (IDataService) r0;
        L12:
            return new Proxy(r2);
        }

        public static IDataService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDataService r1) {
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
            String r3 = getDeviceId();
            r6.writeNoException();
            r6.writeString(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            String r8 = getInstallId();
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            registerDeviceInfoListener(IDeviceInfoCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            unregisterDeviceInfoListener(IDeviceInfoCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface(DESCRIPTOR);
            onEvent(r5.readString(), r5.readString());
            r6.writeNoException();
            return true;
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    String getDeviceId();

    String getInstallId();

    void onEvent(String r1, String r2);

    void registerDeviceInfoListener(IDeviceInfoCallback r1);

    void unregisterDeviceInfoListener(IDeviceInfoCallback r1);
}
