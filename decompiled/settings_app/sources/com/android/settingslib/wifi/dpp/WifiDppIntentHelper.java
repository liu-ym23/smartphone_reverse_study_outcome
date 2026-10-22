package com.android.settingslib.wifi.dpp;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WifiDppIntentHelper {
    public static final String ACTION_CONFIGURATOR_AUTH_QR_CODE_GENERATOR = "android.settings.WIFI_DPP_CONFIGURATOR_AUTH_QR_CODE_GENERATOR";
    static final String EXTRA_WIFI_HIDDEN_SSID = "hiddenSsid";
    static final String EXTRA_WIFI_PRE_SHARED_KEY = "preSharedKey";
    static final String EXTRA_WIFI_SECURITY = "security";
    static final String EXTRA_WIFI_SSID = "ssid";
    static final String SECURITY_NO_PASSWORD = "nopass";
    static final String SECURITY_SAE = "SAE";
    static final String SECURITY_WEP = "WEP";
    static final String SECURITY_WPA_PSK = "WPA";

    public WifiDppIntentHelper() {
    }

    public static void setConfiguratorIntentExtra(Intent r3, WifiManager r4, WifiConfiguration r5) {
        String r0 = removeFirstAndLastDoubleQuotes(r5.SSID);
        String r1 = getSecurityString(r5);
        String r6 = removeFirstAndLastDoubleQuotes(getPresharedKey(r4, r5));
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r3.putExtra("ssid", r0);
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        r3.putExtra(EXTRA_WIFI_SECURITY, r1);
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L11;
        r3.putExtra(EXTRA_WIFI_PRE_SHARED_KEY, r6);
    L11:
        r3.putExtra(EXTRA_WIFI_HIDDEN_SSID, r5.hiddenSSID);
    }

    private static String getSecurityString(WifiConfiguration r3) {
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

    private static String removeFirstAndLastDoubleQuotes(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r5;
    L5:
        int r0 = r5.length() - 1;
        int r2 = 0;
        if (r5.charAt(0) != '\"') goto L9;
        r2 = 1;
    L9:
        if (r5.charAt(r0) != '\"') goto L12;
        r0 = r0 - 1;
    L12:
        return r5.substring(r2, r0 + 1);
    }

    private static String getPresharedKey(WifiManager r3, WifiConfiguration r4) {
        Iterator r5 = r3.getPrivilegedConfiguredNetworks().iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        WifiConfiguration r0 = (WifiConfiguration) r5.next();
        if (r0.networkId != r4.networkId) goto L4;
        if (r4.allowedKeyManagement.get(0) == false) goto L14;
        if (r4.allowedAuthAlgorithms.get(1) == false) goto L14;
        return r0.wepKeys[r0.wepTxKeyIndex];
    L14:
        return r0.preSharedKey;
    L16:
        return r4.preSharedKey;
    }
}
