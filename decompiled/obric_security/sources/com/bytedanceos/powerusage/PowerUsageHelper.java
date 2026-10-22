package com.bytedanceos.powerusage;

import android.app.AppOpsManager;
import android.content.Context;
import android.provider.Settings;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.reflect.ReflectHelper;
import com.bytedanceos.utils.Task;

/* JADX INFO: loaded from: classes2.dex */
public class PowerUsageHelper {
    private static final String BG_BATTERY_RESET_STATUS = "bg_battery_reset_status";

    public PowerUsageHelper() {
    }

    static /* synthetic */ void access$000(AppOpsManager r0, int r1, String r2, int r3) {
        setAppBgMode(r0, r1, r2, r3);
    }

    public static void resetLowPowerModeTriggerLevel(Context context) {
        if (context != null) goto L4;
        return;
    L4:
        if (MultiSdkAdapter.isBeforeP() == true) goto L7;
        return;
    L7:
        if (Settings.Global.getInt(context.getContentResolver(), "low_power_trigger_level", 0) <= 0) goto L11;
        Settings.Global.putInt(context.getContentResolver(), "low_power_trigger_level", 0);
        return;
    }

    public static void resetBgBatteryControllerStatus(final Context context) {
        if (PreferenceMgr.getInstance(context).getBoolean(BG_BATTERY_RESET_STATUS, false) == false) goto L5;
        return;
    L5:
        Task.execute(new AnonymousClass1(context), null, "resetBgBatteryControllerStatus");
    }

    private static void setAppBgMode(AppOpsManager appOpsManager, int uid, String packageName, int mode) {
        if (appOpsManager != null) goto L4;
        return;
    L4:
        Object r0 = ReflectHelper.getStaticVariable("android.app.AppOpsManager", "OP_RUN_ANY_IN_BACKGROUND");
        if (r0 == null) goto L7;
        appOpsManager.setMode(((Integer) r0).intValue(), uid, packageName, mode);
        return;
    L7:
        appOpsManager.setMode(63, uid, packageName, mode);
    }
}
