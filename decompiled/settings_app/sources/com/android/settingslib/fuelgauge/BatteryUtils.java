package com.android.settingslib.fuelgauge;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemProperties;
import android.os.UserManager;
import android.provider.Settings;
import android.util.ArraySet;
import android.view.accessibility.AccessibilityManager;
import com.GlobalProxyLancet;
import com.android.settings.tts.TTSSettingFragment;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryUtils {
    public static final String GLOBAL_TIME_TO_FULL_MILLIS = "time_to_full_millis";
    public static final String PROPERTY_CHARGING_STRING_V2_KEY = "charging_string.apply_v2";
    private static Boolean sChargingStringV2Enabled;

    static {
    }

    public BatteryUtils() {
    }

    public static Intent getBatteryIntent(Context r2) {
        return GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r2, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static ArraySet<String> getA11yPackageNames(Context r3) {
        Context r4 = r3.getApplicationContext();
        ArraySet<String> r0 = new ArraySet();
        String r1 = Settings.Secure.getString(r4.getContentResolver(), TTSSettingFragment.TTS_DEFAULT_SYNTH);
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        AccessibilityManager r5 = (AccessibilityManager) r4.getSystemService(AccessibilityManager.class);
        if (r5.isEnabled() == true) goto L8;
        return r0;
    L8:
        List<AccessibilityServiceInfo> r6 = r5.getEnabledAccessibilityServiceList(-1);
        if (r6 != null) goto L11;
    L19:
        return r0;
    L11:
        if (r6.isEmpty() == true) goto L19;
        Iterator<AccessibilityServiceInfo> r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        ComponentName r2 = ComponentName.unflattenFromString(r7.next().getId());
        if (r2 == null) goto L15;
        r0.add(r2.getPackageName());
        goto L15
    }

    public static boolean isWorkProfile(Context r1) {
        UserManager r2 = (UserManager) r1.getSystemService(UserManager.class);
        if (r2.isManagedProfile() == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.isSystemUser() == true) goto L7;
        return true;
    }

    public static boolean isChargingStringV2Enabled() {
        if (sChargingStringV2Enabled != null) goto L6;
        sChargingStringV2Enabled = Boolean.valueOf(SystemProperties.getBoolean(PROPERTY_CHARGING_STRING_V2_KEY, false));
    L6:
        return sChargingStringV2Enabled.booleanValue();
    }

    public static void setChargingStringV2Enabled(Boolean r1) {
        setChargingStringV2Enabled(r1, true);
    }

    public static void setChargingStringV2Enabled(Boolean r1, boolean r2) {
        if (r2 == false) goto L7;
        if (r1 != null) goto L5;
        String r3 = "";
    L6:
        SystemProperties.set(PROPERTY_CHARGING_STRING_V2_KEY, r3);
        goto L7
    L5:
        r3 = String.valueOf(r1);
    L7:
        sChargingStringV2Enabled = r1;
    }
}
