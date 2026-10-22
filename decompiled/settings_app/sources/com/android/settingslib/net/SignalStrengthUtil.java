package com.android.settingslib.net;

import android.content.Context;
import android.os.PersistableBundle;
import android.telephony.CarrierConfigManager;

/* JADX INFO: loaded from: classes.dex */
public class SignalStrengthUtil {
    public SignalStrengthUtil() {
    }

    public static boolean shouldInflateSignalStrength(Context r1, int r2) {
        CarrierConfigManager r3 = (CarrierConfigManager) r1.getSystemService(CarrierConfigManager.class);
        if (r3 == null) goto L5;
        PersistableBundle r4 = r3.getConfigForSubId(r2);
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r4.getBoolean("inflate_signal_strength_bool", false) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        r4 = null;
        goto L7
    }
}
