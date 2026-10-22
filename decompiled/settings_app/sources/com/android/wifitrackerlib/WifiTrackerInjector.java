package com.android.wifitrackerlib;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.ArraySet;
import com.android.settingslib.R;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class WifiTrackerInjector {
    private static final String DEVICE_CONFIG_NAMESPACE = "wifi";
    private final Context mContext;
    private final DevicePolicyManager mDevicePolicyManager;
    private final boolean mIsDemoMode;
    private boolean mIsUserDebugVerboseLoggingEnabled;
    private final Set<String> mNoAttributionAnnotationPackages;
    private final UserManager mUserManager;
    private boolean mVerboseLoggingDisabledOverride;
    private final WifiManager mWifiManager;

    WifiTrackerInjector(Context r6) {
        boolean r0 = false;
        this.mVerboseLoggingDisabledOverride = false;
        this.mContext = r6;
        this.mWifiManager = (WifiManager) r6.getSystemService(WifiManager.class);
        this.mIsDemoMode = NonSdkApiWrapper.isDemoMode(r6);
        this.mUserManager = (UserManager) r6.getSystemService(UserManager.class);
        this.mDevicePolicyManager = (DevicePolicyManager) r6.getSystemService(DevicePolicyManager.class);
        this.mNoAttributionAnnotationPackages = new ArraySet();
        String[] r1 = r6.getString(R.string.wifitrackerlib_no_attribution_annotation_packages).split(",");
        int r2 = 0;
    L4:
        if (r2 >= r1.length) goto L7;
        this.mNoAttributionAnnotationPackages.add(r1[r2]);
        r2 = r2 + 1;
        goto L4
    L7:
        if (r6.getResources().getBoolean(R.bool.wifitrackerlib_enable_verbose_logging_for_userdebug) == true) goto L9;
    L11:
        this.mIsUserDebugVerboseLoggingEnabled = r0;
        return;
    L9:
        if (Build.TYPE.equals("userdebug") == false) goto L11;
        r0 = true;
        goto L11
    }

    Context getContext() {
        return this.mContext;
    }

    boolean isDemoMode() {
        return this.mIsDemoMode;
    }

    public UserManager getUserManager() {
        return this.mUserManager;
    }

    public DevicePolicyManager getDevicePolicyManager() {
        return this.mDevicePolicyManager;
    }

    Set<String> getNoAttributionAnnotationPackages() {
        return this.mNoAttributionAnnotationPackages;
    }

    public boolean isSharedConnectivityFeatureEnabled() {
        return DeviceConfig.getBoolean("wifi", "shared_connectivity_enabled", false);
    }

    public boolean isVerboseLoggingEnabled() {
        if (this.mVerboseLoggingDisabledOverride == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mWifiManager.isVerboseLoggingEnabled() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mIsUserDebugVerboseLoggingEnabled == false) goto L9;
        goto L8
    }

    public boolean isVerboseSummaryEnabled() {
        if (this.mVerboseLoggingDisabledOverride == false) goto L5;
        return false;
    L5:
        if (this.mWifiManager.isVerboseLoggingEnabled() == true) goto L7;
        return false;
    L7:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "key_show_wifi_verbose_log_settings", 0) == 1) goto L9;
        return false;
    L9:
        return true;
    }

    public void disableVerboseLogging() {
        this.mVerboseLoggingDisabledOverride = true;
    }
}
