package com.android.settings.sensor;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bytedanceos.util.Features;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class SensorsCalibrationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_sensor_SensorsCalibrationReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public SensorsCalibrationReceiver() {
    }

    public void com_android_settings_sensor_SensorsCalibrationReceiver__onReceive$___twin___(Context r4, Intent r5) {
        if ("android.provider.Telephony.SECRET_CODE".equals(r5.getAction()) == false) goto L22;
        boolean r3 = !Features.isUltrasonicSensor(r4).booleanValue();
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (r5.getData() == null) goto L8;
        String r6 = r5.getData().getHost();     // Catch: Exception -> L18
    L11:
        if (r6.equals("667259") == false) goto L14;
        Intent r7 = new Intent("android.intent.action.MAIN");     // Catch: Exception -> L18
        r7.setClass(r4, SensorsCalibrationActivity.class);     // Catch: Exception -> L18
        r7.setFlags(268435456);     // Catch: Exception -> L18
        r4.startActivity(r7);     // Catch: Exception -> L18
        return;
    L14:
        if (r6.equals("667269") == false) goto L24;
        if (r3 == false) goto L25;
        Intent r8 = new Intent("android.intent.action.MAIN");     // Catch: Exception -> L18
        r8.setClass(r4, ProximityCalibrationActivity.class);     // Catch: Exception -> L18
        r8.setFlags(268435456);     // Catch: Exception -> L18
        r4.startActivity(r8);     // Catch: Exception -> L18
        return;
    L25:
        return;
    L24:
        return;
    L8:
        r6 = "xxxx";
        goto L11
    }

    @Insert("onReceive")
    public static void com_android_settings_sensor_SensorsCalibrationReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(SensorsCalibrationReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        SensorsCalibrationReceiver r1 = r7;
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
        r7.com_android_settings_sensor_SensorsCalibrationReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_sensor_SensorsCalibrationReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_sensor_SensorsCalibrationReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_sensor_SensorsCalibrationReceiver__onReceive$___twin___(r8, r9);
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
