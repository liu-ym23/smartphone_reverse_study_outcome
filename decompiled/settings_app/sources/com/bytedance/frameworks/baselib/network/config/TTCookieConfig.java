package com.bytedance.frameworks.baselib.network.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTCookieConfig {
    private static final String COOKIE_BACKUP_ASYNC_SAVE_ENABLED_KEY = "cookie_backup_async_save_enabled";
    private static final String COOKIE_BACKUP_DISABLED_KEY = "cookie_backup_disabled";
    private static final String COOKIE_SAVE_V2_ENABLED_KEY = "cookie_save_v2_enabled";
    private static final String DISABLE_COOKIE_SHARE_HOST_MATCH_FIX = "disable_cookie_share_host_match_fix";
    private static volatile boolean sCookieBackupAsyncSaveEnabled = false;
    private static volatile boolean sCookieBackupDisabled = false;
    private static volatile boolean sCookieSaveV2Enabled = false;
    private static volatile boolean sDisableCookieShareHostMatchFix = false;

    static {
    }

    public TTCookieConfig() {
    }

    public static boolean isCookieSaveV2Enabled() {
        return sCookieSaveV2Enabled;
    }

    public static boolean isCookieBackupAsyncSaveEnabled() {
        return sCookieBackupAsyncSaveEnabled;
    }

    public static boolean isCookieBackupDisabled() {
        return sCookieBackupDisabled;
    }

    public static boolean isDisableCookieHostMatchFix() {
        return sDisableCookieShareHostMatchFix;
    }

    public static void onServerConfigChanged(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        resetTncConfig();
        boolean r1 = false;
        if (r3.optInt(COOKIE_SAVE_V2_ENABLED_KEY, 0) <= 0) goto L7;
        boolean r0 = true;
    L8:
        sCookieSaveV2Enabled = r0;
        if (r3.optInt(COOKIE_BACKUP_ASYNC_SAVE_ENABLED_KEY, 0) <= 0) goto L11;
        boolean r2 = true;
    L12:
        sCookieBackupAsyncSaveEnabled = r2;
        if (r3.optInt(COOKIE_BACKUP_DISABLED_KEY, 0) <= 0) goto L15;
        boolean r4 = true;
    L16:
        sCookieBackupDisabled = r4;
        if (r3.optInt(DISABLE_COOKIE_SHARE_HOST_MATCH_FIX, 0) <= 0) goto L19;
        r1 = true;
    L19:
        sDisableCookieShareHostMatchFix = r1;
        return;
    L15:
        r4 = false;
        goto L16
    L11:
        r2 = false;
        goto L12
    L7:
        r0 = false;
        goto L8
    }

    private static void resetTncConfig() {
        sCookieSaveV2Enabled = false;
        sCookieBackupAsyncSaveEnabled = false;
        sCookieBackupDisabled = false;
        sDisableCookieShareHostMatchFix = false;
    }
}
