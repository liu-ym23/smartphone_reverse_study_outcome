package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ICaeUserAware extends IInterface {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int LEVEL1_MODEL_RESULT = 1;
    public static final int LEVEL2_MODEL_RESULT = 2;
    public static final int MASK_SCAN_AUDIO = 16;
    public static final int MASK_SCAN_BT = 2;
    public static final int MASK_SCAN_CELL = 4;
    public static final int MASK_SCAN_LOCATION = 8;
    public static final int MASK_SCAN_WIFI = 1;
    public static final int MASK_SENSOR_ACCELEROMETER = 32;
    public static final int MASK_SENSOR_GYROSCOPE = 128;
    public static final int MASK_SENSOR_LIGHT = 1024;
    public static final int MASK_SENSOR_LINEAR_ACCELERATION = 64;
    public static final int MASK_SENSOR_MAGNETIC_FIELD = 256;
    public static final int MASK_SENSOR_ORIENTATION = 8192;
    public static final int MASK_SENSOR_OUT_ELEVATOR = 4096;
    public static final int MASK_SENSOR_PRESSURE = 2048;
    public static final int MASK_SENSOR_PROXIMITY = 16384;
    public static final int MASK_SENSOR_ROTATION_MATRIX = 32768;
    public static final int MASK_SENSOR_STEP_COUNTER = 512;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    public static final String USER_AWARE_REPORT_HAR_FEEDBACK_INFO = "useraware_HAR_feedback_info";
    public static final String USER_AWARE_REPORT_HAR_STATE_INFO = "useraware_HAR_state_info";
    public static final String USER_AWARE_REPORT_NEAR_ELEVATOR_INFO = "useraware_near_elevator_info";
    public static final String USER_AWARE_REPORT_STAR_GEOFENCE_INFO = "useraware_star_geofence_info";
    public static final String USER_AWARE_REPORT_STAR_ZPP_INFO = "useraware_star_zpp_info";
    public static final String USER_AWARE_REPORT_USER_FEEDBACK_INFO = "useraware_user_feedback_info";
    public static final String USER_AWARE_REPORT_WIFI_CONNECT_INFO = "useraware_wifi_conn_info";
    public static final String USER_AWARE_REPORT_WIFI_PNO_STATS = "useraware_wifi_pno_stats";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_COUNT = "useraware_wifi_scan_count";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_INFO = "useraware_wifi_scan_info";

    public static class Default implements ICaeUserAware {
        public Default() {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addBssidsToAvoidRomingScan(List<String> r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addHomeWifiBssids(List<String> r1) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void clearHomeWifiBssids() throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public HarMonitorParams getHarMonitorParams() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyGeofenceChanged(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyHarEvent(HarEventData r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyLearningSuccess(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyRoomChangedPredicted(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerCallback(ICaeUserAwareCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarMonitorParams(HarMonitorParams r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarState(int r1, long r2, int r4) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setLevel2DataCollection(List<HarLevel2DataReq> r1, int r2, HarLevel2DataResp r3) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setWifiRssiTriggerThresholds(int r1, int r2, int r3, int r4, int r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterCallback(ICaeUserAwareCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAware {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAware";
        static final int TRANSACTION_addBssidsToAvoidRomingScan = 7;
        static final int TRANSACTION_addHomeWifiBssids = 3;
        static final int TRANSACTION_clearHomeWifiBssids = 4;
        static final int TRANSACTION_getHarMonitorParams = 13;
        static final int TRANSACTION_notifyGeofenceChanged = 6;
        static final int TRANSACTION_notifyHarEvent = 14;
        static final int TRANSACTION_notifyLearningSuccess = 16;
        static final int TRANSACTION_notifyRoomChangedPredicted = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerSmartBluetoothEvent = 10;
        static final int TRANSACTION_setHarMonitorParams = 12;
        static final int TRANSACTION_setHarState = 8;
        static final int TRANSACTION_setLevel2DataCollection = 9;
        static final int TRANSACTION_setWifiRssiTriggerThresholds = 15;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_unregisterSmartBluetoothEvent = 11;

        public static class Proxy implements ICaeUserAware {
            public static ICaeUserAware sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addBssidsToAvoidRomingScan(List<String> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addBssidsToAvoidRomingScan(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addHomeWifiBssids(List<String> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addHomeWifiBssids(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void clearHomeWifiBssids() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearHomeWifiBssids();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public HarMonitorParams getHarMonitorParams() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                HarMonitorParams r4 = HarMonitorParams.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                HarMonitorParams r5 = Stub.getDefaultImpl().getHarMonitorParams();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyGeofenceChanged(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyGeofenceChanged(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyHarEvent(HarEventData r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyHarEvent(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyLearningSuccess(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyLearningSuccess(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyRoomChangedPredicted(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyRoomChangedPredicted(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerCallback(ICaeUserAwareCallback r5) throws RemoteException {
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
                Stub.getDefaultImpl().registerCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r5) throws RemoteException {
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
                Stub.getDefaultImpl().registerSmartBluetoothEvent(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarMonitorParams(HarMonitorParams r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setHarMonitorParams(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarState(int r5, long r6, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                r0.writeInt(r8);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHarState(r5, r6, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setLevel2DataCollection(List<HarLevel2DataReq> r5, int r6, HarLevel2DataResp r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeTypedList(r5);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
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
                Stub.getDefaultImpl().setLevel2DataCollection(r5, r6, r7);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setWifiRssiTriggerThresholds(int r9, int r10, int r11, int r12, int r13) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r9);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeInt(r13);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setWifiRssiTriggerThresholds(r9, r10, r11, r12, r13);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterCallback(ICaeUserAwareCallback r5) throws RemoteException {
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
                Stub.getDefaultImpl().unregisterCallback(r5);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r5) throws RemoteException {
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
                Stub.getDefaultImpl().unregisterSmartBluetoothEvent(r5);     // Catch: Throwable -> L17
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

        public static ICaeUserAware asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeUserAware) == false) goto L12;
            return (ICaeUserAware) r0;
        L12:
            return new Proxy(r2);
        }

        public static ICaeUserAware getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeUserAware r1) {
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
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 == 1598968902) goto L52;
            boolean r0 = false;
            HarMonitorParams r3 = null;
            HarEventData r4 = null;
            switch(r9) {
                case 1: goto L50;
                case 2: goto L48;
                case 3: goto L46;
                case 4: goto L44;
                case 5: goto L42;
                case 6: goto L40;
                case 7: goto L38;
                case 8: goto L36;
                case 9: goto L34;
                case 10: goto L32;
                case 11: goto L30;
                case 12: goto L25;
                case 13: goto L20;
                case 14: goto L15;
                case 15: goto L13;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L11;
            r0 = true;
        L11:
            notifyLearningSuccess(r0);
            r11.writeNoException();
            return true;
        L13:
            r10.enforceInterface(DESCRIPTOR);
            setWifiRssiTriggerThresholds(r10.readInt(), r10.readInt(), r10.readInt(), r10.readInt(), r10.readInt());
            r11.writeNoException();
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L18;
            r4 = HarEventData.CREATOR.createFromParcel(r10);
        L18:
            notifyHarEvent(r4);
            r11.writeNoException();
            return true;
        L20:
            r10.enforceInterface(DESCRIPTOR);
            HarMonitorParams r8 = getHarMonitorParams();
            r11.writeNoException();
            if (r8 == null) goto L23;
            r11.writeInt(1);
            r8.writeToParcel(r11, 1);
        L24:
            return true;
        L23:
            r11.writeInt(0);
            goto L24
        L25:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L28;
            r3 = HarMonitorParams.CREATOR.createFromParcel(r10);
        L28:
            setHarMonitorParams(r3);
            r11.writeNoException();
            return true;
        L30:
            r10.enforceInterface(DESCRIPTOR);
            unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L32:
            r10.enforceInterface(DESCRIPTOR);
            registerSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L34:
            r10.enforceInterface(DESCRIPTOR);
            setLevel2DataCollection(r10.createTypedArrayList(HarLevel2DataReq.CREATOR), r10.readInt(), HarLevel2DataResp.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L36:
            r10.enforceInterface(DESCRIPTOR);
            setHarState(r10.readInt(), r10.readLong(), r10.readInt());
            r11.writeNoException();
            return true;
        L38:
            r10.enforceInterface(DESCRIPTOR);
            addBssidsToAvoidRomingScan(r10.createStringArrayList());
            r11.writeNoException();
            return true;
        L40:
            r10.enforceInterface(DESCRIPTOR);
            notifyGeofenceChanged(r10.readInt());
            r11.writeNoException();
            return true;
        L42:
            r10.enforceInterface(DESCRIPTOR);
            notifyRoomChangedPredicted(r10.readInt());
            r11.writeNoException();
            return true;
        L44:
            r10.enforceInterface(DESCRIPTOR);
            clearHomeWifiBssids();
            r11.writeNoException();
            return true;
        L46:
            r10.enforceInterface(DESCRIPTOR);
            addHomeWifiBssids(r10.createStringArrayList());
            r11.writeNoException();
            return true;
        L48:
            r10.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICaeUserAwareCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L50:
            r10.enforceInterface(DESCRIPTOR);
            registerCallback(ICaeUserAwareCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L7:
            return super.onTransact(r9, r10, r11, r12);
        L52:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addBssidsToAvoidRomingScan(List<String> r1) throws RemoteException;

    void addHomeWifiBssids(List<String> r1) throws RemoteException;

    void clearHomeWifiBssids() throws RemoteException;

    HarMonitorParams getHarMonitorParams() throws RemoteException;

    void notifyGeofenceChanged(int r1) throws RemoteException;

    void notifyHarEvent(HarEventData r1) throws RemoteException;

    void notifyLearningSuccess(boolean r1) throws RemoteException;

    void notifyRoomChangedPredicted(int r1) throws RemoteException;

    void registerCallback(ICaeUserAwareCallback r1) throws RemoteException;

    void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException;

    void setHarMonitorParams(HarMonitorParams r1) throws RemoteException;

    void setHarState(int r1, long r2, int r4) throws RemoteException;

    void setLevel2DataCollection(List<HarLevel2DataReq> r1, int r2, HarLevel2DataResp r3) throws RemoteException;

    void setWifiRssiTriggerThresholds(int r1, int r2, int r3, int r4, int r5) throws RemoteException;

    void unregisterCallback(ICaeUserAwareCallback r1) throws RemoteException;

    void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException;
}
