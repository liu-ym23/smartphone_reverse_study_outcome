package com.android.settings;

import android.net.wifi.WifiConfiguration;
import com.obric.olog.OLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class WifiConfigurationSmtOnly {
    private static final String AUTO_CONNECT_FIELD = "autoConnect";
    private static final String IS_TRUSTED_AP_FIELD = "isTrustedAp";
    private static final String NEED_LOGIN_FIELD = "needLogin";
    private static final String TAG = "WifiConfigurationSmtOnly";
    private static final String WIFI_CONFIGURATION_CLASS = "android.net.wifi.WifiConfiguration";

    public WifiConfigurationSmtOnly() {
    }

    public static boolean get_isTrustedAp(WifiConfiguration r4) {
        if (r4 != null) goto L15;
        OLog.e(TAG, "WifiConfiguration object is null");
        return false;
    L15:
        Field r2 = WifiConfiguration.class.getDeclaredField(IS_TRUSTED_AP_FIELD);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r2.setAccessible(true);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        return r2.getBoolean(r4);
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to access isTrustedAp field: " + e.getMessage());
    L14:
        return false;
    L12:
        e = move-exception;
        OLog.e(TAG, "isTrustedAp field not found in WifiConfiguration: " + e.getMessage());
    L8:
        e = move-exception;
        OLog.e(TAG, "Error getting isTrustedAp: " + e.getMessage());
        goto L14
    }

    public static void set_isTrustedAp(WifiConfiguration r3, boolean r4) {
        if (r3 != null) goto L15;
        OLog.e(TAG, "WifiConfiguration object is null");
        return;
    L15:
        Field r1 = WifiConfiguration.class.getDeclaredField(IS_TRUSTED_AP_FIELD);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r1.setAccessible(true);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r1.setBoolean(r3, r4);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
    L19:
        return;
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to access isTrustedAp field: " + e.getMessage());
        return;
    L12:
        e = move-exception;
        OLog.e(TAG, "isTrustedAp field not found in WifiConfiguration: " + e.getMessage());
        return;
    L8:
        e = move-exception;
        OLog.e(TAG, "Error setting isTrustedAp: " + e.getMessage());
    }

    public static boolean get_needLogin(WifiConfiguration r4) {
        if (r4 != null) goto L15;
        OLog.e(TAG, "WifiConfiguration object is null");
        return false;
    L15:
        Field r2 = WifiConfiguration.class.getDeclaredField(NEED_LOGIN_FIELD);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r2.setAccessible(true);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        return r2.getBoolean(r4);
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to access needLogin field: " + e.getMessage());
    L14:
        return false;
    L12:
        e = move-exception;
        OLog.e(TAG, "needLogin field not found in WifiConfiguration: " + e.getMessage());
    L8:
        e = move-exception;
        OLog.e(TAG, "Error getting needLogin: " + e.getMessage());
        goto L14
    }

    public static void set_needLogin(WifiConfiguration r3, boolean r4) {
        if (r3 != null) goto L15;
        OLog.e(TAG, "WifiConfiguration object is null");
        return;
    L15:
        Field r1 = WifiConfiguration.class.getDeclaredField(NEED_LOGIN_FIELD);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r1.setAccessible(true);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r1.setBoolean(r3, r4);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
    L19:
        return;
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to access needLogin field: " + e.getMessage());
        return;
    L12:
        e = move-exception;
        OLog.e(TAG, "needLogin field not found in WifiConfiguration: " + e.getMessage());
        return;
    L8:
        e = move-exception;
        OLog.e(TAG, "Error setting needLogin: " + e.getMessage());
    }

    public static boolean get_autoConnect(WifiConfiguration r4) {
        if (r4 != null) goto L15;
        OLog.e(TAG, "WifiConfiguration object is null");
        return false;
    L15:
        Field r2 = WifiConfiguration.class.getDeclaredField(AUTO_CONNECT_FIELD);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r2.setAccessible(true);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        return r2.getBoolean(r4);
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to access autoConnect field: " + e.getMessage());
    L14:
        return false;
    L12:
        e = move-exception;
        OLog.e(TAG, "autoConnect field not found in WifiConfiguration: " + e.getMessage());
    L8:
        e = move-exception;
        OLog.e(TAG, "Error getting autoConnect: " + e.getMessage());
        goto L14
    }

    public static void set_autoConnect(WifiConfiguration r3, boolean r4) {
        if (r3 != null) goto L15;
        OLog.e(TAG, "WifiConfiguration object is null");
        return;
    L15:
        Field r1 = WifiConfiguration.class.getDeclaredField(AUTO_CONNECT_FIELD);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r1.setAccessible(true);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
        r1.setBoolean(r3, r4);     // Catch: Exception -> L8 IllegalAccessException -> L10 NoSuchFieldException -> L12
    L19:
        return;
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to access autoConnect field: " + e.getMessage());
        return;
    L12:
        e = move-exception;
        OLog.e(TAG, "autoConnect field not found in WifiConfiguration: " + e.getMessage());
        return;
    L8:
        e = move-exception;
        OLog.e(TAG, "Error setting autoConnect: " + e.getMessage());
    }
}
