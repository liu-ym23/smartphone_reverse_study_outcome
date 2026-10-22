package com.bytedance.bdlocation.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class SystemBaseLocationImpl extends BaseLocate {
    public static final String LBS_GEOCODE_NAME = "LBS";
    private final Handler mHandler;
    private LocationManager mManager;

    private class SystemLocationListener implements LocationListener {
        private BDLocationCallback mCallback;
        private boolean mGpsDisabled;
        private long mLocationStartTime;
        private boolean mNetworkDisabled;
        private LocationOption mOption;
        private TimeOutRunnable mTimeOutRunnable;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        public SystemLocationListener(SystemBaseLocationImpl r3, LocationOption r4, BDLocationCallback r5) {
            this.this$0 = r3;
            this.mOption = r4;
            this.mCallback = r5;
            this.mTimeOutRunnable = new TimeOutRunnable(r3, this, r4, r5);
            SystemBaseLocationImpl.access$000(r3).postDelayed(this.mTimeOutRunnable, r4.getLocationTimeOutMs());
            this.mLocationStartTime = SystemClock.elapsedRealtime();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r10) {
            this.this$0.removeListener(this);     // Catch: Exception -> L17
            if (this.mTimeOutRunnable == null) goto L6;
            SystemBaseLocationImpl.access$000(this.this$0).removeCallbacks(this.mTimeOutRunnable);     // Catch: Exception -> L17
        L6:
            if (this.mOption.isLocationChanged() == false) goto L9;
            Logger.d("Network Location Changed!");     // Catch: Exception -> L17
            return;
        L9:
            this.mOption.setLocationChanged(true);     // Catch: Exception -> L17
            String r0 = r10.getProvider();     // Catch: Exception -> L17
            Logger.d("SystemBaseLocationImpl onLocationChanged provider:" + r0);     // Catch: Exception -> L17
            BDLocation r2 = null;
            if (r0.equals("gps") == false) goto L13;
            r2 = SystemBaseLocationImpl.access$100(this.this$0, r10, 1);     // Catch: Exception -> L17
        L15:
            BDLocation r11 = r2;
            SystemBaseLocationImpl.access$200(this.this$0, r11, this.mOption, this.mCallback, this.mLocationStartTime);     // Catch: Exception -> L17
            LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, BDLocationException.SUCCESS, "success", null, this.mOption.isChineseRegion(), SystemBaseLocationImpl.access$300(this.this$0, r11));     // Catch: Exception -> L17
            return;
        L13:
            if (r0.equals("network") == false) goto L15;
            r2 = SystemBaseLocationImpl.access$100(this.this$0, r10, 4);     // Catch: Exception -> L17
        L17:
            e = move-exception;
            Logger.e("SystemBaseLocationImpl:network listener error", e);
            SystemBaseLocationImpl.access$400(this.this$0, this, e.getMessage(), BDLocationException.ERROR_UNKNOWN, this.mCallback, this.mLocationStartTime, this.mOption);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r9) {
            if (this.mTimeOutRunnable == null) goto L5;
            SystemBaseLocationImpl.access$000(this.this$0).removeCallbacks(this.mTimeOutRunnable);
        L5:
            Logger.i("SystemBaseLocationImpl:onProviderDisabled:" + r9);
            if ("gps".equals(r9) == false) goto L8;
            this.mGpsDisabled = true;
        L10:
            if (SystemBaseLocationImpl.access$500(this.this$0, this.mOption.getMode(), this.mGpsDisabled, this.mNetworkDisabled) == false) goto L13;
            SystemBaseLocationImpl.access$400(this.this$0, this, "provider disabled", BDLocationException.ERROR_PROVIDER_DISABLED, this.mCallback, this.mLocationStartTime, this.mOption);
            return;
        L13:
            return;
        L8:
            this.mNetworkDisabled = true;
            goto L10
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r3) {
            Logger.i("SystemBaseLocationImpl:onProviderEnabled:" + r3);
            this.mNetworkDisabled = false;
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
        }
    }

    private class TimeOutRunnable implements Runnable {
        private BDLocationCallback mCallback;
        private LocationListener mListener;
        private LocationOption mOption;
        private long mTimeoutStartTime;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        public TimeOutRunnable(SystemBaseLocationImpl r1, LocationListener r2, LocationOption r3, BDLocationCallback r4) {
            this.this$0 = r1;
            this.mListener = r2;
            this.mCallback = r4;
            this.mOption = r3;
            this.mTimeoutStartTime = SystemClock.elapsedRealtime();
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemBaseLocationImpl.access$400(this.this$0, this.mListener, LocationMonitorConst.TIMEOUT, BDLocationException.ERROR_TIMEOUT, this.mCallback, this.mTimeoutStartTime, this.mOption);
        }
    }

    @Keep
    public SystemBaseLocationImpl(Context r3) {
        super(r3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mManager = (LocationManager) r3.getSystemService(LocationMonitorConst.LOCATION);
    }

    static /* synthetic */ Handler access$000(SystemBaseLocationImpl r0) {
        return r0.mHandler;
    }

    static /* synthetic */ BDLocation access$100(SystemBaseLocationImpl r0, Location r1, int r2) {
        return r0.transform(r1, r2);
    }

    static /* synthetic */ void access$200(SystemBaseLocationImpl r0, BDLocation r1, LocationOption r2, BDLocationCallback r3, long r4) {
        r0.geocodeAndCallback(r1, r2, r3, r4);
    }

    static /* synthetic */ int access$300(SystemBaseLocationImpl r0, BDLocation r1) {
        return r0.getLocationType(r1);
    }

    static /* synthetic */ void access$400(SystemBaseLocationImpl r0, LocationListener r1, String r2, String r3, BDLocationCallback r4, long r5, LocationOption r7) {
        r0.onError(r1, r2, r3, r4, r5, r7);
    }

    static /* synthetic */ boolean access$500(SystemBaseLocationImpl r0, int r1, boolean r2, boolean r3) {
        return r0.checkProviderDisabled(r1, r2, r3);
    }

    private boolean checkProviderDisabled(int r1, boolean r2, boolean r3) {
        if (r1 != 2) goto L9;
        if (r2 == false) goto L7;
        if (r3 == false) goto L7;
        return true;
    L7:
        return false;
    L9:
        if (r1 != 0) goto L11;
        return r3;
    L11:
        return r2;
    }

    private void geocodeAndCallback(BDLocation r9, LocationOption r10, BDLocationCallback r11, long r12) {
        if (r9 != null) goto L4;
        onError(null, "location is null", BDLocationException.ERROR_UNKNOWN, r11, r12, r10);
    L4:
        BDLocation r13 = null;
        if (LocationUtil.isNeedAddress(r10) == false) goto L7;
        r13 = geocode(new BDPoint(r9.getLatitude(), r9.getLongitude(), r9.getProvider()));
    L7:
        if (r13 == null) goto L9;
        r9 = LocationUtil.composeGeocodeLocation(r9, r13);
    L9:
        r11.onLocationChanged(r9);
    }

    @SuppressLint({"MissingPermission"})
    public static Location getLastKnownLocation(LocationManager r3, String r4, LocationOption r5) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return null;
    L8:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r3, r4, r5.getBpeaCert());
    }

    private int getLocationType(BDLocation r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.getLocationType();
    }

    private void onError(LocationListener r12, String r13, String r14, BDLocationCallback r15, long r16, LocationOption r18) {
        Logger.e("SystemBaseLocationImpl location errorCode:" + r14 + "--message:" + r13);
        LocationMonitor.doDesiredLocationDuration(getLocateName(), SystemClock.elapsedRealtime() - r16, r14, r13, null, r18.isChineseRegion(), 0);
        removeListener(r12);
        if (r15 == null) goto L6;
        r15.onError(new BDLocationException(r13, LocationInfoConst.SYSTEM, r14));
        return;
    }

    @SuppressLint({"MissingPermission"})
    private void singleLocation(@NonNull LocationOption r9, @NonNull Looper r10, BDLocationCallback r11) {
        SystemLocationListener r6 = new SystemLocationListener(this, r9, r11);
        int r12 = r9.getMode();
        Logger.d("SystemBaseLocationImpl singleLocation mode:" + r12 + "--isOverSeas:" + BDLocationConfig.isOverSeas());
        if (BDLocationConfig.isOverSeas() == true) goto L18;
        if (r12 == 0) goto L18;
        if (r12 != 1) goto L12;
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L22;
    L10:
        IBPEALocal r0 = BDLocationExtrasService.getBPEAManager();
        LocationManager r1 = this.mManager;
        Object r5 = r9.getBpeaCert();
        String r2 = "gps";
    L20:
        r0.requestSingleUpdate(r1, r2, r6, r10, r5);
        return;
    L22:
        return;
    L12:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L15;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.mManager, "network", r6, r10, r9.getBpeaCert());
    L15:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L10;
        return;
    L18:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L24;
        r0 = BDLocationExtrasService.getBPEAManager();
        r1 = this.mManager;
        r5 = r9.getBpeaCert();
        r2 = "network";
        goto L20
    }

    @Nullable
    private BDLocation transform(Location r2, int r3) {
        if (r2 == null) goto L5;
        BDLocation r0 = new BDLocation(r2, getLocateName());
        r0.setLocationType(r3);
        r0.setLocationMs(System.currentTimeMillis());
        return r0;
    L5:
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    @Nullable
    public BDPoint convertGCJ02(@NonNull BDPoint r1) {
        return null;
    }

    public BDLocation geocode(@NonNull BDPoint r4) {
        BDLocation r0 = new BDLocation(r4.getProvider(), getLocateName());
        r0.setLatitude(r4.getLatitude());
        r0.setLongitude(r4.getLongitude());
        return LocationUtil.geocode(this.mContext, r0);
    L5:
        e = move-exception;
        Logger.e("SystemBaseLocationImpl:geocode error", e);
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return LocationInfoConst.SYSTEM;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r1, double r3) {
        return false;
    }

    public void removeListener(LocationListener r1) {
        if (r1 != null) goto L9;
    L4:
        Logger.d("SystemBaseLocationImpl:Android stopLocation");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Logger.e("SystemBaseLocationImpl:android stop location error", e);
        return;
    L9:
        this.mManager.removeUpdates(r1);     // Catch: Exception -> L6
        goto L4
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    @SuppressLint({"MissingPermission"})
    public void startLocation(@NonNull BDLocationCallback r9, @NonNull LocationOption r10, @NonNull Looper r11) {
        long r6 = SystemClock.elapsedRealtime();
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        r9.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (BDLocationConfig.isBackground() == false) goto L29;
        return;
    L29:
        Location r0 = getLastKnownLocation(this.mManager, "gps", r10);     // Catch: Exception -> L26
        Location r1 = getLastKnownLocation(this.mManager, "network", r10);     // Catch: Exception -> L26
        if (r1 != null) goto L12;
    L17:
        if (r0 != null) goto L19;
    L24:
        singleLocation(r10, r11, r9);     // Catch: Exception -> L26
        onLocateStart(getLocateName());     // Catch: Exception -> L26
        Logger.d("SystemBaseLocationImpl:Android startLocation");     // Catch: Exception -> L26
        return;
    L19:
        if (LocationUtil.checkCacheTime(r0.getTime(), r10.getMaxCacheTime()) == false) goto L24;
        if (LocationUtil.isEmpty(r0) == true) goto L24;
        geocodeAndCallback(transform(r0, 1), r10, r9, r6);     // Catch: Exception -> L26
        return;
    L12:
        if (LocationUtil.checkCacheTime(r1.getTime(), r10.getMaxCacheTime()) == false) goto L17;
        if (LocationUtil.isEmpty(r1) == true) goto L17;
        geocodeAndCallback(transform(r1, 4), r10, r9, r6);     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        Logger.i("start location error");
        onError(null, e.getMessage(), BDLocationException.ERROR_UNKNOWN, r9, r6, r10);
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
    }
}
