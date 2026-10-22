package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeNfcEventManager extends IInterface {

    public static class Default implements ICaeNfcEventManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventAllowedAidTypes() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventSource() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean isTransitEventFilterEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void notifyTransitEvent(Bundle r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventAllowedAidTypes(int r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventFilterEnabled(boolean r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventSource(int r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcEventManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcEventManager";
        static final int TRANSACTION_getTransitEventAllowedAidTypes = 19;
        static final int TRANSACTION_getTransitEventSource = 15;
        static final int TRANSACTION_isTransitEventFilterEnabled = 17;
        static final int TRANSACTION_notifyTransitEvent = 13;
        static final int TRANSACTION_registerCloudConfigCallback = 1;
        static final int TRANSACTION_registerDndConfigCallback = 3;
        static final int TRANSACTION_registerForceFwEventCallback = 5;
        static final int TRANSACTION_registerPaymentChangeCallback = 11;
        static final int TRANSACTION_registerTransitEventCallback = 7;
        static final int TRANSACTION_registerVendorNciEventCallback = 9;
        static final int TRANSACTION_setTransitEventAllowedAidTypes = 18;
        static final int TRANSACTION_setTransitEventFilterEnabled = 16;
        static final int TRANSACTION_setTransitEventSource = 14;
        static final int TRANSACTION_unregisterCloudConfigCallback = 2;
        static final int TRANSACTION_unregisterDndConfigCallback = 4;
        static final int TRANSACTION_unregisterForceFwEventCallback = 6;
        static final int TRANSACTION_unregisterPaymentChangeCallback = 12;
        static final int TRANSACTION_unregisterTransitEventCallback = 8;
        static final int TRANSACTION_unregisterVendorNciEventCallback = 10;

        public static class Proxy implements ICaeNfcEventManager {
            public static ICaeNfcEventManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventAllowedAidTypes() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getTransitEventAllowedAidTypes();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventSource() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getTransitEventSource();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean isTransitEventFilterEnabled() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isTransitEventFilterEnabled();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void notifyTransitEvent(Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(13, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyTransitEvent(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCloudConfigCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerDndConfigCallback(ICaeNfcDndConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDndConfigCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerForceFwEventCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerPaymentChangeCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerTransitEventCallback(ICaeNfcTransitEventCallback r5) throws RemoteException {
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
                Stub.getDefaultImpl().registerTransitEventCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerVendorNciEventCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventAllowedAidTypes(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().setTransitEventAllowedAidTypes(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventFilterEnabled(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().setTransitEventFilterEnabled(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventSource(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().setTransitEventSource(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCloudConfigCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterDndConfigCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterForceFwEventCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterPaymentChangeCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTransitEventCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r2 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterVendorNciEventCallback(r5);     // Catch: Throwable -> L17
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNfcEventManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNfcEventManager) == false) goto L12;
            return (ICaeNfcEventManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeNfcEventManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNfcEventManager r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 == 1598968902) goto L53;
            switch(r4) {
                case 1: goto L51;
                case 2: goto L49;
                case 3: goto L47;
                case 4: goto L45;
                case 5: goto L43;
                case 6: goto L41;
                case 7: goto L39;
                case 8: goto L37;
                case 9: goto L35;
                case 10: goto L33;
                case 11: goto L31;
                case 12: goto L29;
                case 13: goto L23;
                case 14: goto L21;
                case 15: goto L19;
                case 16: goto L13;
                case 17: goto L11;
                case 18: goto L9;
                case 19: goto L7;
                default: goto L6;
            };
        L7:
            r5.enforceInterface(DESCRIPTOR);
            int r3 = getTransitEventAllowedAidTypes();
            r6.writeNoException();
            r6.writeInt(r3);
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = setTransitEventAllowedAidTypes(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = isTransitEventFilterEnabled();
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L16;
            boolean r10 = true;
        L17:
            boolean r11 = setTransitEventFilterEnabled(r10);
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            return true;
        L16:
            r10 = false;
            goto L17
        L19:
            r5.enforceInterface(DESCRIPTOR);
            int r12 = getTransitEventSource();
            r6.writeNoException();
            r6.writeInt(r12);
            return true;
        L21:
            r5.enforceInterface(DESCRIPTOR);
            boolean r13 = setTransitEventSource(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r13 ? 1 : 0);
            return true;
        L23:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L26;
            Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L27:
            notifyTransitEvent(r14);
            return true;
        L26:
            r14 = null;
            goto L27
        L29:
            r5.enforceInterface(DESCRIPTOR);
            unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L31:
            r5.enforceInterface(DESCRIPTOR);
            registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L33:
            r5.enforceInterface(DESCRIPTOR);
            unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L37:
            r5.enforceInterface(DESCRIPTOR);
            unregisterTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L39:
            r5.enforceInterface(DESCRIPTOR);
            registerTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L41:
            r5.enforceInterface(DESCRIPTOR);
            unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L43:
            r5.enforceInterface(DESCRIPTOR);
            registerForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L45:
            r5.enforceInterface(DESCRIPTOR);
            unregisterDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L47:
            r5.enforceInterface(DESCRIPTOR);
            registerDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L49:
            r5.enforceInterface(DESCRIPTOR);
            unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L51:
            r5.enforceInterface(DESCRIPTOR);
            registerCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L53:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getTransitEventAllowedAidTypes() throws RemoteException;

    int getTransitEventSource() throws RemoteException;

    boolean isTransitEventFilterEnabled() throws RemoteException;

    void notifyTransitEvent(Bundle r1) throws RemoteException;

    void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException;

    void registerDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException;

    void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException;

    void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException;

    void registerTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException;

    void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException;

    boolean setTransitEventAllowedAidTypes(int r1) throws RemoteException;

    boolean setTransitEventFilterEnabled(boolean r1) throws RemoteException;

    boolean setTransitEventSource(int r1) throws RemoteException;

    void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException;

    void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException;

    void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException;

    void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException;

    void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException;

    void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException;
}
