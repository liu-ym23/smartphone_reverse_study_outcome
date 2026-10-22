package com.bytedance.bdlocation.permission;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.store.LocationCache;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PermissionManager {
    public static int BLUETOOTH_PERMISSION_NO = 71;
    public static int BLUETOOTH_PERMISSION_OK = 1;
    public static int LOCATION_PERMISSION_NO = 71;
    public static int LOCATION_PERMISSION_OK = 1;
    private static final int LOCATION_REQUEST_PERMISSIONS_CODE = 4104;

    static {
    }

    public PermissionManager() {
    }

    public static boolean canRequestLocationPermission() {
        LocationCache r0 = LocationCache.getInstance();
        if ((System.currentTimeMillis() - r0.getLocationDenyTime()) <= 172800000) goto L6;
        return true;
    L6:
        return false;
    }

    public static int checkBluetoothPermissions(Context r3) {
        if (hasAnyPermission(r3, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"}) == false) goto L7;
        return BLUETOOTH_PERMISSION_OK;
    L7:
        return BLUETOOTH_PERMISSION_NO;
    L9:
        return BLUETOOTH_PERMISSION_NO;
    }

    public static int checkLocationPermissions(Context r2) {
        if (hasAnyPermission(r2, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L7;
        return LOCATION_PERMISSION_OK;
    L7:
        return LOCATION_PERMISSION_NO;
    L9:
        return LOCATION_PERMISSION_NO;
    }

    private static boolean checkPermissions(Context r6, String... r7) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L14:
        int r0 = r7.length;
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L22;
        String r4 = r7[r3];
        if (TextUtils.isEmpty(r4) == true) goto L21;
        if (ContextCompat.checkSelfPermission(r6, r4) != 0) goto L21;
        return true;
    L21:
        r3 = r3 + 1;
        goto L15
    L22:
        return false;
    L5:
        if (BDLocationConfig.isOverSeas() == true) goto L14;
        List<String> r8 = getDeniedPermissions(r6, r7);
        if (r8 != null) goto L10;
        return true;
    L10:
        if (r8.isEmpty() == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Nullable
    private static List<String> getDeniedPermissions(Context r6, String... r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        if (ContextCompat.checkSelfPermission(r6, r3) != (-1)) goto L10;
        r0.add(r3);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        return r0;
    }

    public static boolean hasAnyPermission(Context r0, String... r1) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return checkPermissions(r0, r1);
    }

    public static boolean hasAnyPermission(String... r1) {
        Context r0 = BDLocationConfig.getContext();
        if (r0 != null) goto L7;
        return false;
    L7:
        return checkPermissions(r0, r1);
    }

    public static boolean hasBluetoothPermissions(Context r1) {
        if (checkBluetoothPermissions(r1) != BLUETOOTH_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasLocationPermissions(Context r1) {
        if (checkLocationPermissions(r1) != LOCATION_PERMISSION_OK) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isApproximateLocation(Context r3) {
        boolean r0 = hasAnyPermission(r3, new String[]{"android.permission.ACCESS_FINE_LOCATION"});
        boolean r4 = hasAnyPermission(r3, new String[]{"android.permission.ACCESS_COARSE_LOCATION"});
        Logger.i("PermissionManager isApproximateLocation coarseLocationPermission:" + r4 + "--fineLocationPermission:" + r0);
        if (r4 == false) goto L7;
        if (r0 == true) goto L9;
        return true;
    L9:
        return false;
    L7:
        return false;
    }
}
