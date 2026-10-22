package com.bytedance.bdlocation.scan.gps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class GpsInfoManager {
    private static volatile GpsInfoManager sInstance;
    private IBPEALocal mBPEAManager;
    private GpsCollectCallback mCallback;
    private Context mContext;
    private GnssStatusCallback mGnssStatusCallback;
    private volatile BDGpsInfo mGpsInfo;
    private GpsStatusListener mGpsStatusListener;
    private Handler mHandler;
    private volatile boolean mIsGpsStatusReady;
    private volatile boolean mIsLocationInfoReady;
    private LocationInfoListener mLocationInfoListener;
    private LocationManager mLocationManager;
    private TimeOutTask mTimeOutTask;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.gps.GpsInfoManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @RequiresApi(api = 24)
    private class GnssStatusCallback extends GnssStatus.Callback {
        final /* synthetic */ GpsInfoManager this$0;

        private GnssStatusCallback(GpsInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ GnssStatusCallback(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r5) {
            int r0 = r5.getSatelliteCount();
            ArrayList r1 = new ArrayList();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L6;
            r1.add(Float.valueOf(r5.getCn0DbHz(r2)));
            r2 = r2 + 1;
            goto L3
        L6:
            if (GpsInfoManager.access$900(this.this$0) != null) goto L8;
            GpsInfoManager.access$902(this.this$0, new BDGpsInfo());
        L8:
            GpsInfoManager.access$900(this.this$0).satelliteNum = r0;
            GpsInfoManager.access$900(this.this$0).snr = r1;
            GpsInfoManager.access$900(this.this$0).timestamp = System.currentTimeMillis();
            Logger.i("GnssStatusCallback: onSatelliteStatusChanged, maxSatelliteCount:" + r0);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            super.onStarted();
            Logger.i("GnssStatusCallback: onStarted");
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            super.onStopped();
            Logger.i("GnssStatusCallback: onStopped");
            GpsInfoManager.access$1000(this.this$0);
            GpsInfoManager.access$1102(this.this$0, true);
            GpsInfoManager.access$700(this.this$0);
        }
    }

    private class GpsStatusListener implements GpsStatus.Listener {
        final /* synthetic */ GpsInfoManager this$0;

        private GpsStatusListener(GpsInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ GpsStatusListener(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.location.GpsStatus.Listener
        @SuppressLint({"MissingPermission"})
        public void onGpsStatusChanged(int r5) {
            Logger.i("GpsStatusListener: onGpsStatusChanged");
            if (r5 != 1) goto L5;
            String r4 = "GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_STARTED";
        L31:
            Logger.i(r4);
            return;
        L5:
            if (r5 != 2) goto L7;
            Logger.i("GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_STOPPED");
            GpsInfoManager.access$1000(this.this$0);
            GpsInfoManager.access$1102(this.this$0, true);
            GpsInfoManager.access$700(this.this$0);
            return;
        L7:
            if (r5 != 3) goto L9;
            r4 = "GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_FIRST_FIX";
            goto L31
        L9:
            if (r5 == 4) goto L12;
            return;
        L12:
            if (GpsInfoManager.access$800(this.this$0) != null) goto L16;
            String r6 = "GpsStatusListener: location manager is null";
        L14:
            Logger.i(r6);
            return;
        L16:
            GpsStatus r7 = GpsInfoManager.access$800(this.this$0).getGpsStatus(null);
            if (r7 != null) goto L19;
            r6 = "GpsStatusListener: gpsStatus is null";
            goto L14
        L19:
            int r0 = r7.getMaxSatellites();
            int r1 = 0;
            ArrayList r2 = new ArrayList();
            Iterator<GpsSatellite> r8 = r7.getSatellites().iterator();
        L21:
            if (r8.hasNext() == false) goto L25;
            if (r1 >= r0) goto L25;
            r2.add(Float.valueOf(r8.next().getSnr()));
            r1 = r1 + 1;
        L25:
            if (GpsInfoManager.access$900(this.this$0) != null) goto L27;
            GpsInfoManager.access$902(this.this$0, new BDGpsInfo());
        L27:
            GpsInfoManager.access$900(this.this$0).satelliteNum = r0;
            GpsInfoManager.access$900(this.this$0).snr = r2;
            GpsInfoManager.access$900(this.this$0).timestamp = System.currentTimeMillis();
            r4 = "GpsStatusListener: onGpsStatusChanged GPS_EVENT_SATELLITE_STATUS, satellite count:" + r1;
            goto L31
        }
    }

    private class LocationInfoListener implements LocationListener {
        final /* synthetic */ GpsInfoManager this$0;

        private LocationInfoListener(GpsInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LocationInfoListener(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r2) {
            Logger.i("LocationInfoListener: onLocationChanged");
            GpsInfoManager.access$400(this.this$0);
            GpsInfoManager.access$500(this.this$0, r2);
            GpsInfoManager.access$602(this.this$0, true);
            GpsInfoManager.access$700(this.this$0);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r2) {
            Logger.i("LocationInfoListener: onProviderDisabled, provider:" + r2);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r2) {
            Logger.i("LocationInfoListener: onProviderEnabled, provider:" + r2);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
            Logger.i("LocationInfoListener: onStatusChanged, provider:" + r1);
        }
    }

    private class TimeOutTask implements Runnable {
        final /* synthetic */ GpsInfoManager this$0;

        private TimeOutTask(GpsInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TimeOutTask(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.i("GpsInfoManager: collect timeout");
            this.this$0.stopGpsCollect();
            GpsInfoManager.access$1200(this.this$0);
        }
    }

    static {
    }

    private GpsInfoManager(Context r2) {
        this.mIsLocationInfoReady = false;
        this.mIsGpsStatusReady = false;
        this.mContext = r2;
        if (r2 != null) goto L6;
        Logger.i("mContext is null");
        return;
    L6:
        this.mLocationManager = (LocationManager) r2.getSystemService(LocationMonitorConst.LOCATION);
        this.mHandler = new Handler(ThreadLooperManager.getLocationWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    static /* synthetic */ void access$1000(GpsInfoManager r0) {
        r0.unregisterGnssCallback();
    }

    static /* synthetic */ boolean access$1102(GpsInfoManager r0, boolean r1) {
        r0.mIsGpsStatusReady = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(GpsInfoManager r0) {
        r0.callbackGpsInfo();
    }

    static /* synthetic */ void access$400(GpsInfoManager r0) {
        r0.removeLocationListener();
    }

    static /* synthetic */ void access$500(GpsInfoManager r0, Location r1) {
        r0.updateGPSInfo(r1);
    }

    static /* synthetic */ boolean access$602(GpsInfoManager r0, boolean r1) {
        r0.mIsLocationInfoReady = r1;
        return r1;
    }

    static /* synthetic */ void access$700(GpsInfoManager r0) {
        r0.callbackAndRemoveTimeOutTask();
    }

    static /* synthetic */ LocationManager access$800(GpsInfoManager r0) {
        return r0.mLocationManager;
    }

    static /* synthetic */ BDGpsInfo access$900(GpsInfoManager r0) {
        return r0.mGpsInfo;
    }

    static /* synthetic */ BDGpsInfo access$902(GpsInfoManager r0, BDGpsInfo r1) {
        r0.mGpsInfo = r1;
        return r1;
    }

    private void addLocationListener(Object r7) {
    L11:
        e = move-exception;
        Logger.e("GpsInfoManager: addLocationListener error", e);
        return;
    L3:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L5;
        return;
    L5:
        if (this.mLocationManager == null) goto L17;
        Logger.i("GpsInfoManager: addLocationListener");     // Catch: Exception -> L11
        if (this.mLocationInfoListener != null) goto L9;
        this.mLocationInfoListener = new LocationInfoListener(this, null);     // Catch: Exception -> L11
    L9:
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, "gps", this.mLocationInfoListener, this.mHandler.getLooper(), r7);     // Catch: Exception -> L11
        return;
    }

    private synchronized void callbackAndRemoveTimeOutTask() {
        monitor-enter(this);
        Logger.i("GpsInfoManager: mIsLocationInfoReady:" + this.mIsLocationInfoReady + ", mIsGpsStatusReady:" + this.mIsGpsStatusReady);     // Catch: Throwable -> L13
        if (this.mIsLocationInfoReady == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.mIsGpsStatusReady == false) goto L11;
        Logger.i("GpsInfoManager: callbackAndRemoveTimeOutTask");     // Catch: Throwable -> L13
        TimeOutTask r0 = this.mTimeOutTask;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        this.mHandler.removeCallbacks(r0);     // Catch: Throwable -> L13
    L10:
        callbackGpsInfo();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private synchronized void callbackGpsInfo() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mCallback != null) goto L6;
    L11:
        this.mIsLocationInfoReady = false;     // Catch: Throwable -> L14
        this.mIsGpsStatusReady = false;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        if (this.mGpsInfo != null) goto L10;
        this.mCallback.onFail(2);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        this.mCallback.onSuccess(this.mGpsInfo);     // Catch: Throwable -> L14
        goto L11
    }

    public static GpsInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(GpsInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new GpsInfoManager(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(GpsInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    private void registerGnssCallback(Object r4) {
    L17:
        e = move-exception;
        Logger.e("GpsInfoManager: registerGnssCallback error:" + e);
        return;
    L3:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L5;
        return;
    L5:
        if (this.mLocationManager == null) goto L22;
        Logger.i("GpsInfoManager: registerGnssCallback");     // Catch: Exception -> L17
        AnonymousClass1 r2 = null;
        if (Build.VERSION.SDK_INT < 24) goto L13;
        if (this.mGnssStatusCallback != null) goto L11;
        this.mGnssStatusCallback = new GnssStatusCallback(this, r2);     // Catch: Exception -> L17
    L11:
        this.mLocationManager.registerGnssStatusCallback(this.mGnssStatusCallback);     // Catch: Exception -> L17
        return;
    L13:
        if (this.mGpsStatusListener != null) goto L15;
        this.mGpsStatusListener = new GpsStatusListener(this, r2);     // Catch: Exception -> L17
    L15:
        this.mBPEAManager.addGpsStatusListener(this.mLocationManager, this.mGpsStatusListener, r4);     // Catch: Exception -> L17
        return;
    }

    @SuppressLint({"MissingPermission"})
    private void removeLocationListener() {
        LocationManager r0 = this.mLocationManager;     // Catch: Exception -> L8
        if (r0 == null) goto L13;
        LocationInfoListener r1 = this.mLocationInfoListener;     // Catch: Exception -> L8
        if (r1 == null) goto L14;
        r0.removeUpdates(r1);     // Catch: Exception -> L8
        this.mLocationInfoListener = null;     // Catch: Exception -> L8
        Logger.i("GpsInfoManager: removeLocationListener");     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        Logger.e("GpsInfoManager: removeLocationListener error:" + e);
    }

    private void unregisterGnssCallback() {
    L13:
        e = move-exception;
        Logger.e("GpsInfoManager: unregisterGnssCallback error:" + e);
        return;
    L3:
        if (this.mLocationManager == null) goto L16;
        Logger.i("GpsInfoManager: unregisterGnssCallback");     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 24) goto L9;
        GnssStatusCallback r0 = this.mGnssStatusCallback;     // Catch: Exception -> L13
        if (r0 == null) goto L16;
        this.mLocationManager.unregisterGnssStatusCallback(r0);     // Catch: Exception -> L13
        this.mGnssStatusCallback = null;     // Catch: Exception -> L13
        goto L16
    L9:
        GpsStatusListener r1 = this.mGpsStatusListener;     // Catch: Exception -> L13
        if (r1 == null) goto L16;
        this.mLocationManager.removeGpsStatusListener(r1);     // Catch: Exception -> L13
        this.mGpsStatusListener = null;     // Catch: Exception -> L13
    L16:
    }

    private void updateGPSInfo(Location r8) {
        if (r8 != null) goto L5;
        Logger.i("GpsInfoManager: updateGPSInfo and location is null");
        return;
    L5:
        BDPoint r0 = LocationUtil.convertGCJ02(new BDPoint(r8.getLatitude(), r8.getLongitude(), r8.getProvider()));
        if (r0 != null) goto L10;
        Logger.i("GpsInfoManager: updateGPSInfo and gcj02Point is null");
        return;
    L10:
        if (this.mGpsInfo != null) goto L12;
        this.mGpsInfo = new BDGpsInfo();
    L12:
        BDGpsInfo r1 = this.mGpsInfo;
        r1.latitude = r0.getLatitude();
        BDGpsInfo r2 = this.mGpsInfo;
        r2.longitude = r0.getLongitude();
        BDGpsInfo r3 = this.mGpsInfo;
        r3.altitude = r8.getAltitude();
        BDGpsInfo r4 = this.mGpsInfo;
        r4.accuracy = r8.getAccuracy();
        this.mGpsInfo.coordinateSystem = LocationInfoConst.GCJ_O2;
        BDGpsInfo r5 = this.mGpsInfo;
        r5.provider = r8.getProvider();
        Bundle r6 = r8.getExtras();
        if (r6 != null) goto L15;
    L17:
        BDGpsInfo r7 = this.mGpsInfo;
        r7.speed = r8.getSpeed();
        BDGpsInfo r9 = this.mGpsInfo;
        r9.orientation = r8.getBearing();
        BDGpsInfo r10 = this.mGpsInfo;
        r10.timestamp = System.currentTimeMillis();
        return;
    L15:
        if (r6.getBoolean("QUICKGPS", false) == false) goto L17;
        Logger.i("GpsInfoManager: updateGPSInfo and provider is network");
        this.mGpsInfo.provider = "network";
        goto L17
    }

    public void startGpsCollect(GpsCollectCallback r6, Object r7) {
        if (r6 != null) goto L6;
        Logger.i("GpsInfoManager: startGpsCollect and callback is null");
        return;
    L6:
        if (r7 != null) goto L10;
        Logger.i("GpsInfoManager: startGpsCollect and bpeaCert is null");
        r6.onFail(1);
        return;
    L10:
        if (BDLocationConfig.isEnableGpsScan() == true) goto L12;
    L23:
        Logger.i("GpsInfoManager: startGpsCollect and gps scan is not enabled");
        r6.onFail(1);
        return;
    L12:
        if (BDLocationConfig.getGpsScanInterval() <= 0) goto L23;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(LocationUtil.allowUseLocation(true)) == true) goto L18;
        Logger.i("GpsInfoManager: startGpsCollect and location is not allowed");
        r6.onFail(1);
        return;
    L18:
        this.mCallback = r6;
        this.mIsLocationInfoReady = false;
        this.mIsGpsStatusReady = false;
        AnonymousClass1 r8 = null;
        this.mGpsInfo = null;
        registerGnssCallback(r7);
        addLocationListener(r7);
        if (this.mTimeOutTask != null) goto L21;
        this.mTimeOutTask = new TimeOutTask(this, r8);
    L21:
        this.mHandler.postDelayed(this.mTimeOutTask, BDLocationConfig.getGpsScanInterval());
    }

    public void stopGpsCollect() {
        Logger.i("GpsInfoManager: stopGpsCollect");
        removeLocationListener();
        unregisterGnssCallback();
    }
}
