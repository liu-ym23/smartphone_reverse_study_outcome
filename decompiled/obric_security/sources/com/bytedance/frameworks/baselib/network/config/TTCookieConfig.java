package com.bytedance.frameworks.baselib.network.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTCookieConfig {
    private static final String COOKIE_BACKUP_ASYNC_SAVE_ENABLED_KEY = "cookie_backup_async_save_enabled";
    private static final String COOKIE_BACKUP_DISABLED_KEY = "cookie_backup_disabled";
    private static final String COOKIE_BATCH_ENABLED_KEY = "cookie_batch";
    private static final String COOKIE_SAVE_V2_ENABLED_KEY = "cookie_save_v2_enabled";
    private static final String DISABLE_COOKIE_SHARE_HOST_MATCH_FIX = "disable_cookie_share_host_match_fix";
    private static final String ENABLE_COOKIE_FLUSH_FOR_REGION = "enable_flush_cookie_for_region";
    private static volatile boolean sCookieBackupAsyncSaveEnabled = false;
    private static volatile boolean sCookieBackupDisabled = false;
    private static volatile boolean sCookieBatchSaveEnabled = false;
    private static volatile boolean sCookieSaveV2Enabled = false;
    private static volatile boolean sDisableCookieShareHostMatchFix = false;
    private static volatile boolean sEnableFlushCookieForRegion = false;

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

    public static boolean isCookieBatchSaveEnabled() {
        return sCookieBatchSaveEnabled;
    }

    public static boolean isDisableCookieHostMatchFix() {
        return sDisableCookieShareHostMatchFix;
    }

    public static boolean isEnableFlushCookieForRegion() {
        return sEnableFlushCookieForRegion;
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
        if (r3.optInt(COOKIE_BATCH_ENABLED_KEY, 0) <= 0) goto L19;
        boolean r5 = true;
    L20:
        sCookieBatchSaveEnabled = r5;
        if (r3.optInt(DISABLE_COOKIE_SHARE_HOST_MATCH_FIX, 0) <= 0) goto L23;
        boolean r6 = true;
    L24:
        sDisableCookieShareHostMatchFix = r6;
        if (r3.optInt(ENABLE_COOKIE_FLUSH_FOR_REGION, 0) <= 0) goto L27;
        r1 = true;
    L27:
        sEnableFlushCookieForRegion = r1;
        return;
    L23:
        r6 = false;
        goto L24
    L19:
        r5 = false;
        goto L20
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
        sCookieBatchSaveEnabled = false;
        sDisableCookieShareHostMatchFix = false;
        sEnableFlushCookieForRegion = false;
    }
}
