package com.obric.olog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.UserManager;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigHandler extends Handler {
    private static final String TAG = "olog ConfigHandler";
    private Context mContext;

    public ConfigHandler(Context r1) {
        this.mContext = r1;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r12) {
        if (r12.what == 1011) goto L6;
        return;
    L6:
        if (r12.sendingUid == 1000) goto L8;
        return;
    L8:
        Bundle r6 = r12.getData();
        if (r6 != null) goto L12;
        Log.e(TAG, "receive null data");
        return;
    L12:
        Log.i(TAG, "receive config data");
        String r7 = r6.getString("data");     // Catch: JSONException -> L50
        Log.i(TAG, r7);     // Catch: JSONException -> L50
        JSONObject r8 = new JSONObject(r7);     // Catch: JSONException -> L50
        Context r9 = this.mContext;     // Catch: JSONException -> L50
        if (r9 != null) goto L17;
        Log.e(TAG, "context is null");     // Catch: JSONException -> L50
        return;
    L17:
        UserManager r10 = (UserManager) r9.getSystemService("user");     // Catch: JSONException -> L50
        if (r10 != null) goto L21;
    L23:
        SharedPreferences.Editor r11 = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences(Constants.CONFIG_FIELD, 0).edit();     // Catch: JSONException -> L50
    L25:
        if (r8.has(Constants.REPORT_FIELD) == false) goto L30;
        boolean r13 = r8.getBoolean(Constants.REPORT_FIELD);     // Catch: JSONException -> L50
        r11.putBoolean(Constants.REPORT_FIELD, r13);     // Catch: JSONException -> L50
        if (OLog.isInited() == false) goto L30;
        OLog.setReport(r13);     // Catch: JSONException -> L50
    L30:
        if (r8.has(Constants.OUTPUT_TO_LOGD_FIELD) == false) goto L35;
        boolean r5 = r8.getBoolean(Constants.OUTPUT_TO_LOGD_FIELD);     // Catch: JSONException -> L50
        r11.putBoolean(Constants.OUTPUT_TO_LOGD_FIELD, r5);     // Catch: JSONException -> L50
        if (OLog.isInited() == false) goto L35;
        OLog.setOutputToLogd(r5);     // Catch: JSONException -> L50
    L35:
        if (r8.has(Constants.LOG_LEVEL_FIELD) == false) goto L40;
        int r4 = r8.getInt(Constants.LOG_LEVEL_FIELD);     // Catch: JSONException -> L50
        r11.putInt(Constants.LOG_LEVEL_FIELD, r4);     // Catch: JSONException -> L50
        if (OLog.isInited() == false) goto L40;
        OLog.setLogLevel(r4);     // Catch: JSONException -> L50
    L40:
        if (r8.has(Constants.SAVE_TO_DISK_FIELD) == false) goto L43;
        r11.putBoolean(Constants.SAVE_TO_DISK_FIELD, r8.getBoolean(Constants.SAVE_TO_DISK_FIELD));     // Catch: JSONException -> L50
    L43:
        if (r8.has(Constants.MAX_DIR_SIZE_FIELD) == false) goto L46;
        r11.putInt(Constants.MAX_DIR_SIZE_FIELD, r8.getInt(Constants.MAX_DIR_SIZE_FIELD));     // Catch: JSONException -> L50
    L46:
        if (r8.has(Constants.LOG_EXPIRED_DAYS_FIELD) == false) goto L48;
        r11.putInt(Constants.LOG_EXPIRED_DAYS_FIELD, r8.getInt(Constants.LOG_EXPIRED_DAYS_FIELD));     // Catch: JSONException -> L50
    L48:
        r11.apply();     // Catch: JSONException -> L50
    L52:
        super.handleMessage(r12);
        return;
    L21:
        if (r10.isUserUnlocked() == false) goto L23;
        r11 = this.mContext.getSharedPreferences(Constants.CONFIG_FIELD, 0).edit();     // Catch: JSONException -> L50
    L50:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        goto L52
    }
}
