package com.android.settings.fuelgauge;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryChangeReceiver extends BroadcastReceiver {
    public static final String ACTION_BATTERY_LEVEL_DRAIN = "android.intent.action.BATTERY_LEVEL_DRAIN";
    private static final long AC_MIN_TIME_SECOND = 60;
    public static final String FAST_DRAIN_MSG_REPORT_ACTION = "fast_drain_msg_report";
    private static final int MAX_POWER_SECONDS = 10800;
    private static final String POWER_MESSAGE = "power_message";
    public static final String POWER_RESET_ACTION = "power_drain_collect_before_reset";
    private static final long USB_MIN_TIME_SECOND = 300;
    private static final long WIRELESS_MIN_TIME_SECOND = 300;

    private void startPhoneTraceServices(String r1, Context r2, Intent r3) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_fuelgauge_BatteryChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public BatteryChangeReceiver() {
    }

    static /* synthetic */ void access$000(BatteryChangeReceiver r0, String r1, Context r2, Intent r3) {
        r0.startPhoneTraceServices(r1, r2, r3);
    }

    static /* synthetic */ void access$100(Context r0) {
        reportPowerMessage(r0);
    }

    static /* synthetic */ void access$200(Context r0) {
        saveOnPowerConnected(r0);
    }

    public void com_android_settings_fuelgauge_BatteryChangeReceiver__onReceive$___twin___(final Context r2, final Intent r3) {
        AsyncTask.execute(new AnonymousClass1(this, r3, r2));
    }

    private static void reportPowerMessage(final Context r1) {
        AsyncTask.execute(new AnonymousClass2(r1));
    }

    private static void saveOnPowerConnected(final Context r1) {
        AsyncTask.execute(new AnonymousClass3(r1));
    }

    @Insert("onReceive")
    public static void com_android_settings_fuelgauge_BatteryChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(BatteryChangeReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        BatteryChangeReceiver r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_android_settings_fuelgauge_BatteryChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_fuelgauge_BatteryChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_fuelgauge_BatteryChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_fuelgauge_BatteryChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
