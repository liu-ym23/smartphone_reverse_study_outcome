package com.obric.securitycenter.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ISecurityCenterService extends IInterface {

    public static class Default implements ISecurityCenterService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.securitycenter.api.ISecurityCenterService
        public Bundle getExtraInfo(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.securitycenter.api.ISecurityCenterService
        public void pauseScanTrashAndMem() throws RemoteException {
        }

        @Override // com.obric.securitycenter.api.ISecurityCenterService
        public void resumeScanTrashAndMem() throws RemoteException {
        }

        @Override // com.obric.securitycenter.api.ISecurityCenterService
        public void startClearTrashAndMem() throws RemoteException {
        }

        @Override // com.obric.securitycenter.api.ISecurityCenterService
        public void startScanTrashAndMem() throws RemoteException {
        }

        @Override // com.obric.securitycenter.api.ISecurityCenterService
        public void stopScanTrashAndMem() throws RemoteException {
        }

        @Override // com.obric.securitycenter.api.ISecurityCenterService
        public void subscribe(IEventCallback r1) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISecurityCenterService {
        private static final String DESCRIPTOR = "com.obric.securitycenter.api.ISecurityCenterService";
        static final int TRANSACTION_getExtraInfo = 6;
        static final int TRANSACTION_pauseScanTrashAndMem = 4;
        static final int TRANSACTION_resumeScanTrashAndMem = 3;
        static final int TRANSACTION_startClearTrashAndMem = 5;
        static final int TRANSACTION_startScanTrashAndMem = 1;
        static final int TRANSACTION_stopScanTrashAndMem = 2;
        static final int TRANSACTION_subscribe = 7;

        private static class Proxy implements ISecurityCenterService {
            public static ISecurityCenterService sDefaultImpl;
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

            @Override // com.obric.securitycenter.api.ISecurityCenterService
            public void startScanTrashAndMem() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().startScanTrashAndMem();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.securitycenter.api.ISecurityCenterService
            public void stopScanTrashAndMem() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopScanTrashAndMem();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.securitycenter.api.ISecurityCenterService
            public void resumeScanTrashAndMem() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().resumeScanTrashAndMem();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.securitycenter.api.ISecurityCenterService
            public void pauseScanTrashAndMem() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().pauseScanTrashAndMem();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.securitycenter.api.ISecurityCenterService
            public void startClearTrashAndMem() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().startClearTrashAndMem();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.securitycenter.api.ISecurityCenterService
            public Bundle getExtraInfo(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Bundle r4 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r6 = Stub.getDefaultImpl().getExtraInfo(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.securitycenter.api.ISecurityCenterService
            public void subscribe(IEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().subscribe(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
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

        public static ISecurityCenterService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISecurityCenterService) == false) goto L12;
            return (ISecurityCenterService) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 == 1598968902) goto L24;
            switch(r4) {
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            subscribe(IEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            Bundle r3 = getExtraInfo(r5.readString());
            r6.writeNoException();
            if (r3 == null) goto L12;
            r6.writeInt(1);
            r3.writeToParcel(r6, 1);
        L13:
            return true;
        L12:
            r6.writeInt(0);
            goto L13
        L14:
            r5.enforceInterface(DESCRIPTOR);
            startClearTrashAndMem();
            return true;
        L16:
            r5.enforceInterface(DESCRIPTOR);
            pauseScanTrashAndMem();
            return true;
        L18:
            r5.enforceInterface(DESCRIPTOR);
            resumeScanTrashAndMem();
            return true;
        L20:
            r5.enforceInterface(DESCRIPTOR);
            stopScanTrashAndMem();
            return true;
        L22:
            r5.enforceInterface(DESCRIPTOR);
            startScanTrashAndMem();
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L24:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(ISecurityCenterService r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ISecurityCenterService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    Bundle getExtraInfo(String r1) throws RemoteException;

    void pauseScanTrashAndMem() throws RemoteException;

    void resumeScanTrashAndMem() throws RemoteException;

    void startClearTrashAndMem() throws RemoteException;

    void startScanTrashAndMem() throws RemoteException;

    void stopScanTrashAndMem() throws RemoteException;

    void subscribe(IEventCallback r1) throws RemoteException;
}
