package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm6.foundation.context.ApmContext;
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
        if (this.mPrefs != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mPrefs != null) goto L8;
        this.mPrefs = r3.getSharedPreferences(PREFS_MONITOR_DOWNGRADE, 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    public void save(DowngradeInfo r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.mPrefs == null) goto L13;
        JSONObject r5 = r4.toJson();
        if (r5 == null) goto L14;
        String r0 = r5.toString();
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.i(TAG, "DowngradeData-save-" + r0);
    L10:
        this.mPrefs.edit().putString(KEY_RULE, r5.toString()).apply();
        return;
    L14:
        return;
    }

    public DowngradeInfo loadFromSp() {
        String r5 = this.mPrefs.getString(KEY_RULE, null);
        if (r5 != null) goto L14;
    L13:
        return null;
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.i(TAG, "DowngradeData-load-" + r5);     // Catch: JSONException -> L11
    L7:
        DowngradeInfo r6 = DowngradeInfo.parse(new JSONObject(r5));     // Catch: JSONException -> L11
        if (System.currentTimeMillis() >= r6.expireTime) goto L13;
        return r6;
    }
}
