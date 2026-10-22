package com.android.settings.riskcontrol;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes2.dex */
public final class RiskControlSettingsSnapshotStore {
    private static final String KEY_PREFIX = "security_risk_control";
    private static final String TAG = "RiskControlSnapshot";

    private RiskControlSettingsSnapshotStore() {
    }

    public static int getControlFlags(Context r3, String r4, int r5) {
        if (r3 != null) goto L5;
    L15:
        return 0;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        String r6 = Settings.Secure.getString(r3.getApplicationContext().getContentResolver(), settingsKey(r4, r5));     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r6) == false) goto L16;
        return 0;
    L16:
        return Integer.parseInt(r6);
    L12:
        return 0;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "getControlFlags failed, pkg=" + r4 + ", userId=" + r5, e);
        goto L15
    }

    public static boolean isFlagControlled(Context r0, String r1, int r2, int r3) {
        return RiskControlFlags.hasFlag(getControlFlags(r0, r1, r2), r3);
    }

    private static String settingsKey(String r2, int r3) {
        return "security_risk_control_" + r2 + "_" + r3;
    }
}
