package com.android.settings.utils;

import android.net.wifi.WifiConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class WifiDppUtils {
    static final String SECURITY_NO_PASSWORD = "nopass";
    static final String SECURITY_SAE = "SAE";
    static final String SECURITY_WEP = "WEP";
    static final String SECURITY_WPA_PSK = "WPA";

    public WifiDppUtils() {
    }

    public static String getSecurityString(WifiConfiguration r3) {
        if (r3.allowedKeyManagement.get(8) == false) goto L7;
        return SECURITY_SAE;
    L7:
        if (r3.allowedKeyManagement.get(9) == false) goto L10;
        return SECURITY_NO_PASSWORD;
    L10:
        if (r3.allowedKeyManagement.get(1) == false) goto L12;
        return SECURITY_WPA_PSK;
    L12:
        if (r3.allowedKeyManagement.get(4) == false) goto L15;
        return SECURITY_WPA_PSK;
    L15:
        if (r3.wepKeys[0] == null) goto L21;
        return SECURITY_WEP;
    L21:
        return SECURITY_NO_PASSWORD;
    }
}
