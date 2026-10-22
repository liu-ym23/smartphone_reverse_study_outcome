package com.android.settingslib.wifi;

import android.content.Context;
import android.os.UserManager;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class WifiEnterpriseRestrictionUtils {
    private static final String TAG = "WifiEntResUtils";

    private static boolean isAtLeastT() {
        return true;
    }

    public WifiEnterpriseRestrictionUtils() {
    }

    public static boolean isWifiTetheringAllowed(Context r1) {
        if (hasUserRestrictionFromT(r1, "no_wifi_tethering") == true) goto L6;
        return true;
    L6:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Wi-Fi Tethering isn't available due to user restriction.");
        return false;
    }

    public static boolean isWifiDirectAllowed(Context r1) {
        if (hasUserRestrictionFromT(r1, "no_wifi_direct") == true) goto L6;
        return true;
    L6:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Wi-Fi Direct isn't available due to user restriction.");
        return false;
    }

    public static boolean isAddWifiConfigAllowed(Context r1) {
        if (hasUserRestrictionFromT(r1, "no_add_wifi_config") == true) goto L6;
        return true;
    L6:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Wi-Fi Add network isn't available due to user restriction.");
        return false;
    }

    public static boolean isChangeWifiStateAllowed(Context r1) {
        if (hasUserRestrictionFromT(r1, "no_change_wifi_state") == true) goto L6;
        return true;
    L6:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "WI-FI state isn't allowed to change due to user restriction.");
        return false;
    }

    static boolean hasUserRestrictionFromT(Context r2, String r3) {
        if (isAtLeastT() == true) goto L5;
        return false;
    L5:
        UserManager r4 = (UserManager) r2.getSystemService(UserManager.class);
        if (r4 != null) goto L9;
        return false;
    L9:
        return r4.hasUserRestriction(r3);
    }
}
