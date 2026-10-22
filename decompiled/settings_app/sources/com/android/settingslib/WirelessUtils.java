package com.android.settingslib;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class WirelessUtils {
    public WirelessUtils() {
    }

    public static boolean isRadioAllowed(Context r2, String r3) {
        if (isAirplaneModeOn(r2) == true) goto L5;
        return true;
    L5:
        String r4 = Settings.Global.getString(r2.getContentResolver(), "airplane_mode_toggleable_radios");
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.contains(r3) == false) goto L10;
        return true;
    }

    public static boolean isAirplaneModeOn(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }
}
