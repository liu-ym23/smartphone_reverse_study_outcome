package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeBluetooth extends IInterface {

    public static class Default implements ICaeBluetooth {
        public Default() {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public BdimPredictEvent getBdimEvent(BluetoothDevice r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public int getProductId(BluetoothDevice r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void registerEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void requestLeConnectionPriority(int r1, AttributionSource r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setAac3mPacketEnabled(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setBqrEventState(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setHARStatusChanged(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setLocationState(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setModelPredictType(BluetoothDevice r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void unregisterEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetooth {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ICaeBluetooth";
        static final int TRANSACTION_addDeviceToDatabase = 3;
        static final int TRANSACTION_addDeviceToStaticExtDatabase = 6;
        static final int TRANSACTION_getBdimEvent = 10;
        static final int TRANSACTION_getProductId = 8;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_removeDeviceFromDatabase = 4;
        static final int TRANSACTION_removeDeviceFromStaticExtDatabase = 7;
        static final int TRANSACTION_requestLeConnectionPriority = 5;
        static final int TRANSACTION_setAac3mPacketEnabled = 14;
        static final int TRANSACTION_setBqrEventState = 13;
        static final int TRANSACTION_setHARStatusChanged = 11;
        static final int TRANSACTION_setLocationState = 12;
        static final int TRANSACTION_setModelPredictType = 9;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetooth {
            public static ICaeBluetooth sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToDatabase(String r5, BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToStaticExtDatabase(String r5, BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToStaticExtDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public BdimPredictEvent getBdimEvent(BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                BdimPredictEvent r4 = BdimPredictEvent.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                BdimPredictEvent r6 = Stub.getDefaultImpl().getBdimEvent(r5);     // Catch: Throwable -> L21
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

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public int getProductId(BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                int r4 = r1.readInt();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r6 = Stub.getDefaultImpl().getProductId(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void registerEventCallback(ICaeBluetoothEventCallback r5) throws RemoteException {
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
                Stub.getDefaultImpl().registerEventCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromDatabase(String r5, BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromStaticExtDatabase(String r5, BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromStaticExtDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void requestLeConnectionPriority(int r5, AttributionSource r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestLeConnectionPriority(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setAac3mPacketEnabled(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setAac3mPacketEnabled(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setBqrEventState(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setBqrEventState(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setHARStatusChanged(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHARStatusChanged(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setLocationState(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLocationState(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setModelPredictType(BluetoothDevice r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L7:
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setModelPredictType(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void unregisterEventCallback(ICaeBluetoothEventCallback r5) throws RemoteException {
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
                Stub.getDefaultImpl().unregisterEventCallback(r5);     // Catch: Throwable -> L17
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

        public static ICaeBluetooth asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeBluetooth) == false) goto L12;
            return (ICaeBluetooth) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeBluetooth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeBluetooth r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L66;
            boolean r0 = false;
            BluetoothDevice r3 = null;
            BluetoothDevice r4 = null;
            BluetoothDevice r9 = null;
            BluetoothDevice r10 = null;
            BluetoothDevice r11 = null;
            BluetoothDevice r12 = null;
            AttributionSource r13 = null;
            BluetoothDevice r14 = null;
            switch(r5) {
                case 1: goto L64;
                case 2: goto L62;
                case 3: goto L57;
                case 4: goto L52;
                case 5: goto L47;
                case 6: goto L42;
                case 7: goto L37;
                case 8: goto L32;
                case 9: goto L27;
                case 10: goto L19;
                case 11: goto L17;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L11;
            r0 = true;
        L11:
            setAac3mPacketEnabled(r0);
            r7.writeNoException();
            return true;
        L13:
            r6.enforceInterface(DESCRIPTOR);
            setBqrEventState(r6.readInt());
            r7.writeNoException();
            return true;
        L15:
            r6.enforceInterface(DESCRIPTOR);
            setLocationState(r6.readString());
            r7.writeNoException();
            return true;
        L17:
            r6.enforceInterface(DESCRIPTOR);
            setHARStatusChanged(r6.readInt());
            r7.writeNoException();
            return true;
        L19:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L22;
            r4 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L22:
            BdimPredictEvent r15 = getBdimEvent(r4);
            r7.writeNoException();
            if (r15 == null) goto L25;
            r7.writeInt(1);
            r15.writeToParcel(r7, 1);
        L26:
            return true;
        L25:
            r7.writeInt(0);
            goto L26
        L27:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L30;
            r9 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L30:
            setModelPredictType(r9, r6.readString());
            r7.writeNoException();
            return true;
        L32:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L35;
            r10 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L35:
            int r16 = getProductId(r10);
            r7.writeNoException();
            r7.writeInt(r16);
            return true;
        L37:
            r6.enforceInterface(DESCRIPTOR);
            String r17 = r6.readString();
            if (r6.readInt() == 0) goto L40;
            r11 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L40:
            removeDeviceFromStaticExtDatabase(r17, r11);
            r7.writeNoException();
            return true;
        L42:
            r6.enforceInterface(DESCRIPTOR);
            String r18 = r6.readString();
            if (r6.readInt() == 0) goto L45;
            r12 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L45:
            addDeviceToStaticExtDatabase(r18, r12);
            r7.writeNoException();
            return true;
        L47:
            r6.enforceInterface(DESCRIPTOR);
            int r19 = r6.readInt();
            if (r6.readInt() == 0) goto L50;
            r13 = (AttributionSource) AttributionSource.CREATOR.createFromParcel(r6);
        L50:
            requestLeConnectionPriority(r19, r13);
            r7.writeNoException();
            return true;
        L52:
            r6.enforceInterface(DESCRIPTOR);
            String r20 = r6.readString();
            if (r6.readInt() == 0) goto L55;
            r14 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L55:
            removeDeviceFromDatabase(r20, r14);
            r7.writeNoException();
            return true;
        L57:
            r6.enforceInterface(DESCRIPTOR);
            String r21 = r6.readString();
            if (r6.readInt() == 0) goto L60;
            r3 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L60:
            addDeviceToDatabase(r21, r3);
            r7.writeNoException();
            return true;
        L62:
            r6.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L64:
            r6.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L66:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDeviceToDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    BdimPredictEvent getBdimEvent(BluetoothDevice r1) throws RemoteException;

    int getProductId(BluetoothDevice r1) throws RemoteException;

    void registerEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException;

    void removeDeviceFromDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void requestLeConnectionPriority(int r1, AttributionSource r2) throws RemoteException;

    void setAac3mPacketEnabled(boolean r1) throws RemoteException;

    void setBqrEventState(int r1) throws RemoteException;

    void setHARStatusChanged(int r1) throws RemoteException;

    void setLocationState(String r1) throws RemoteException;

    void setModelPredictType(BluetoothDevice r1, String r2) throws RemoteException;

    void unregisterEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException;
}
