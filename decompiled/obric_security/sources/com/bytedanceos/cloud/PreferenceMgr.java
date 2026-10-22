package com.bytedanceos.cloud;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class PreferenceMgr {
    private static final int CLEAR_SDK_UPDATE_DIFF_TIME = 10080000;
    public static final String CLEAR_SDK_UPDATE_TIME = "clear_sdk_update_time";
    public static final String CLOUD_DATA_SYNC_SUCCES_TIME = "cloud_data_sync_success_time";
    public static final String LAST_CLEAN_TIME = "last_clean_time";
    public static final String SETTINGS_HAS_BG_ALLOWED = "all_bg_allowed";
    public static final String SETTINGS_PREFERENCES_PERMISSION_ALLOWED = "permission_has_allowed";
    private static volatile PreferenceMgr sInstance;
    private int isAllowedInt;
    private SharedPreferences mPrefs;

    private PreferenceMgr(Context context) {
        this.isAllowedInt = -1;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static synchronized PreferenceMgr getInstance(Context context) {
        monitor-enter(PreferenceMgr.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new PreferenceMgr(context.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        PreferenceMgr r2 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(PreferenceMgr.class);
        return r2;
    }

    public void putBoolean(String key, boolean value) {
        OLog.e("PreferenceMgr", "putBoolean:key:" + key + ",value:" + value);
        if (SETTINGS_PREFERENCES_PERMISSION_ALLOWED.equals(key) == false) goto L7;
        if (value == false) goto L6;
        this.isAllowedInt = 1;
        goto L7
    L6:
        this.isAllowedInt = 0;
    L7:
        SharedPreferUtil.commitAsynchronously(this.mPrefs.edit().putBoolean(key, value));
    }

    public void putString(String key, String value) {
        SharedPreferUtil.commitAsynchronously(this.mPrefs.edit().putString(key, value));
    }

    public void putLong(String key, long value) {
        SharedPreferUtil.commitAsynchronously(this.mPrefs.edit().putLong(key, value));
    }

    public void putInt(String key, int value) {
        SharedPreferUtil.commitAsynchronously(this.mPrefs.edit().putInt(key, value));
    }

    public boolean getBoolean(String key, boolean def) {
        return this.mPrefs.getBoolean(key, def);
    }

    public boolean getIsAllowedFromUid(String packageName) {
        return this.mPrefs.getBoolean(packageName + GrantUtil.INSTANCE.getAppUid(packageName), false);
    }

    public boolean isAllowedFrom(String from) {
        if (isAllowed() == true) goto L7;
        return false;
    L7:
        return getIsAllowedFromUid(from);
    }

    public boolean isAllowed() {
        if (this.isAllowedInt == 1) goto L9;
        boolean r0 = this.mPrefs.getBoolean(SETTINGS_PREFERENCES_PERMISSION_ALLOWED, false);
        if (r0 == false) goto L7;
        this.isAllowedInt = 1;
    L8:
        return r0;
    L7:
        this.isAllowedInt = 0;
        goto L8
    L9:
        return true;
    }

    public String getString(String key, String def) {
        return this.mPrefs.getString(key, def);
    }

    public long getLong(String key, long def) {
        return this.mPrefs.getLong(key, def);
    }

    public int getInt(String key, int def) {
        return this.mPrefs.getInt(key, def);
    }

    public void remove(String key) {
        SharedPreferUtil.commitAsynchronously(this.mPrefs.edit().remove(key));
    }

    public static boolean canUpdateClearSdk(Context context) {
        long r0 = getInstance(context).getLong(CLEAR_SDK_UPDATE_TIME, 0);
        if ((System.currentTimeMillis() - r0) <= 10080000) goto L6;
        return true;
    L6:
        return false;
    }

    public static void updateClearSdkUpdateTime(Context context) {
        getInstance(context).putLong(CLEAR_SDK_UPDATE_TIME, System.currentTimeMillis());
    }
}
