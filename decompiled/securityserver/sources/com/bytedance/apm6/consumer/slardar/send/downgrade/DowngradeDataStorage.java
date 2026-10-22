package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DowngradeDataStorage {
    private static final String KEY_RULE = "rule";
    private static final String PREFS_MONITOR_DOWNGRADE = "monitor_downgrade";
    public static final String TAG = "APM-Downgrade";
    private SharedPreferences mPrefs;

    public DowngradeDataStorage(Context r3) {
        if (this.mPrefs != null) goto L14;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.mPrefs != null) goto L10;
        this.mPrefs = r3.getSharedPreferences(PREFS_MONITOR_DOWNGRADE, 0);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    }

    @Nullable
    public DowngradeInfo loadFromSp() {
        String r5 = this.mPrefs.getString(KEY_RULE, null);
        if (r5 != null) goto L15;
    L14:
        return null;
    L15:
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.i(TAG, "DowngradeData-load-".concat(r5));     // Catch: JSONException -> L7
    L9:
        DowngradeInfo r6 = DowngradeInfo.parse(new JSONObject(r5));     // Catch: JSONException -> L7
        if (System.currentTimeMillis() >= r6.expireTime) goto L14;
        return r6;
    }

    public void save(DowngradeInfo r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.mPrefs == null) goto L13;
        JSONObject r5 = r4.toJson();
        if (r5 == null) goto L14;
        String r0 = r5.toString();
        if (ApmBaseContext.isDebugMode() == false) goto L10;
        Logger.i(TAG, "DowngradeData-save-" + r0);
    L10:
        this.mPrefs.edit().putString(KEY_RULE, r5.toString()).apply();
        return;
    L14:
        return;
    }
}
