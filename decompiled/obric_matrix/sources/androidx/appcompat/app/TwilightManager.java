package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState;

    private static class TwilightState {
        boolean isNight;
        long nextUpdate;

        TwilightState() {
        }
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context r2, @NonNull LocationManager r3) {
        this.mTwilightState = new TwilightState();
        this.mContext = r2;
        this.mLocationManager = r3;
    }

    static TwilightManager getInstance(@NonNull Context r2) {
        if (sInstance != null) goto L6;
        Context r3 = r2.getApplicationContext();
        sInstance = new TwilightManager(r3, (LocationManager) r3.getSystemService(LocationMonitorConst.LOCATION));
    L6:
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        Location r1 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        Location r0 = getLastKnownLocationForProvider("network");
    L7:
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r1 = getLastKnownLocationForProvider("gps");
    L9:
        if (r1 == null) goto L15;
        if (r0 == null) goto L15;
        if (r1.getTime() > r0.getTime()) goto L14;
        return r0;
    L14:
        return r1;
    L15:
        if (r1 != null) goto L17;
        return r0;
    L17:
        return r1;
    L5:
        r0 = null;
        goto L7
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location getLastKnownLocationForProvider(String r2) {
    L6:
        e = move-exception;
        Log.d(TAG, "Failed to get last known location", e);
        return null;
    L3:
        if (this.mLocationManager.isProviderEnabled(r2) == false) goto L12;
        return this.mLocationManager.getLastKnownLocation(r2);
    L12:
        return null;
    }

    private boolean isStateValid() {
        if (this.mTwilightState.nextUpdate <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    static void setInstance(TwilightManager r0) {
        sInstance = r0;
    }

    private void updateState(@NonNull Location r19) {
        TwilightState r0 = this.mTwilightState;
        long r8 = System.currentTimeMillis();
        TwilightCalculator r10 = TwilightCalculator.getInstance();
        r10.calculateTwilight(r8 - 86400000, r19.getLatitude(), r19.getLongitude());
        r10.calculateTwilight(r8, r19.getLatitude(), r19.getLongitude());
        boolean r2 = true;
        if (r10.state == 1) goto L6;
        r2 = false;
    L6:
        boolean r13 = r2;
        long r14 = r10.sunrise;
        long r6 = r10.sunset;
        r10.calculateTwilight(r8 + 86400000, r19.getLatitude(), r19.getLongitude());
        long r1 = r10.sunrise;
        if (r14 != (-1)) goto L9;
    L19:
        long r3 = 43200000 + r8;
    L20:
        r0.isNight = r13;
        r0.nextUpdate = r3;
        return;
    L9:
        if (r6 == (-1)) goto L19;
        if (r8 <= r6) goto L15;
        long r4 = r1 + 0;
    L18:
        r3 = r4 + 60000;
        goto L20
    L15:
        if (r8 <= r14) goto L17;
        r4 = r6 + 0;
        goto L18
    L17:
        r4 = r14 + 0;
        goto L18
    }

    boolean isNight() {
        TwilightState r0 = this.mTwilightState;
        if (isStateValid() == true) goto L5;
        Location r1 = getLastKnownLocation();
        if (r1 == null) goto L10;
        updateState(r1);
        return r0.isNight;
    L10:
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int r2 = Calendar.getInstance().get(11);
        if (r2 >= 6) goto L13;
    L16:
        return true;
    L13:
        if (r2 >= 22) goto L16;
        return false;
    L5:
        return r0.isNight;
    }
}
