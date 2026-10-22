package com.android.settingslib.wifi;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class WifiPermissionChecker {
    private static final String TAG = "WifiPermChecker";
    private IActivityManager mActivityManager;
    private String mLaunchedPackage;
    private PackageManager mPackageManager;

    public WifiPermissionChecker(Activity r2) {
        this(r2, ActivityManager.getService());
    }

    public WifiPermissionChecker(Activity r1, IActivityManager r2) {
        this.mActivityManager = r2;
        this.mPackageManager = r1.getPackageManager();
        this.mLaunchedPackage = getLaunchedFromPackage(r1);
    }

    public String getLaunchedPackage() {
        return this.mLaunchedPackage;
    }

    public boolean canAccessWifiState() {
        return checkPermission("android.permission.ACCESS_WIFI_STATE");
    }

    public boolean canAccessFineLocation() {
        return checkPermission("android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean checkPermission(String r6) {
        if (this.mPackageManager != null) goto L5;
    L13:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Failed to check package permission! {PackageManager:" + this.mPackageManager + ", LaunchedPackage:" + this.mLaunchedPackage + VectorFormat.DEFAULT_SUFFIX);
        return false;
    L5:
        if (TextUtils.isEmpty(this.mLaunchedPackage) == true) goto L13;
        if (this.mPackageManager.checkPermission(r6, this.mLaunchedPackage) != 0) goto L11;
        return true;
    L11:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "The launched package does not have the required permission! {LaunchedPackage:" + this.mLaunchedPackage + ", Permission:" + r6 + VectorFormat.DEFAULT_SUFFIX);
        return false;
    }

    private String getLaunchedFromPackage(Activity r1) {
        return this.mActivityManager.getLaunchedFromPackage(r1.getActivityToken());
    L4:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Can not get the launched package from activity manager!");
        return null;
    }
}
