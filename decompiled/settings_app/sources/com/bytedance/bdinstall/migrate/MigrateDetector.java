package com.bytedance.bdinstall.migrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes3.dex */
public final class MigrateDetector {
    public static final String KEY_COMPONENT_STATE = "component_state";
    private static final int STATE_DEFAULT = 0;
    private static final int STATE_DISABLED = 2;
    private static final int STATE_ENABLED = 1;
    private static final int STATE_FLAG = 1;
    private final ComponentName component;
    private final boolean migrate;
    private final PackageManager pm;
    private final SharedPreferences sp;

    private static String getComponentState(int r1) {
        if (r1 != 0) goto L4;
        return "STATE_DEFAULT";
    L4:
        if (r1 != 1) goto L6;
        return "STATE_ENABLED";
    L6:
        if (r1 == 2) goto L9;
        return NetworkStackConstant.UNKNOWN_TYPE;
    L9:
        return "STATE_DISABLED";
    }

    public MigrateDetector(Context r3) {
        Context r0 = r3.getApplicationContext();
        this.sp = LocalConstants.getCommonSp(r3);
        this.pm = r0.getPackageManager();
        this.component = new ComponentName(r3, MigrateDetectorActivity.class);
        boolean r4 = isMigrateInternal();
        this.migrate = r4;
        DrLog.d("MigrateDetector#constructor migrate=" + r4);
    }

    public void disableComponent() {
        DrLog.d("MigrateDetector#disableComponent");
        this.pm.setComponentEnabledSetting(this.component, 2, 1);     // Catch: Exception -> L5
        this.sp.edit().putInt(KEY_COMPONENT_STATE, 2).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        DrLog.e("MigrateDetector#disableComponent error", e);
    }

    public boolean isMigrate() {
        return this.migrate;
    }

    private int getComponentEnabledSetting() {
        return this.pm.getComponentEnabledSetting(this.component);
    }

    private boolean isMigrateInternal() {
        int r1 = getComponentEnabledSetting();     // Catch: Exception -> L11
        int r4 = this.sp.getInt(KEY_COMPONENT_STATE, 0);
        DrLog.d("MigrateDetector#isMigrateInternal cs=" + getComponentState(r1) + " ss=" + getComponentState(r4));
        if (r1 != 0) goto L10;
        if (r4 != 2) goto L10;
        return true;
    L10:
        return false;
    }

    public static void saveOldDid(Context r1, String r2, boolean r3) {
        SharedPreferences.Editor r4 = LocalConstants.getCommonSp(r1).edit();
        r4.putString(Api.KEY_OLD_DID, r2);
        if (r3 == false) goto L5;
        r4.putBoolean("is_migrate", true);
    L6:
        r4.apply();
        return;
    L5:
        r4.remove("is_migrate");
        goto L6
    }

    public static String getOldDid(Context r2) {
        return LocalConstants.getCommonSp(r2).getString(Api.KEY_OLD_DID, null);
    }

    public static boolean isThisDeviceMigrate(Context r2) {
        return LocalConstants.getCommonSp(r2).getBoolean("is_migrate", false);
    }
}
