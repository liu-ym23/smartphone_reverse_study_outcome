package com.bytedance.privacy.pcc.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class PccChannelDb {
    private static final String COL_ACCESS_TOKEN = "access_token";
    private static final String COL_APP_ID = "app_id";
    private static final String COL_CHANNEL_EXPIRY_TIME = "channel_expiry_time";
    private static final String COL_CHANNEL_ID = "channel_id";
    private static final String COL_EVIDENCE_INFO = "evidence_info";
    private static final String COL_HIST_ACCESS_TOKEN = "access_token";
    private static final String COL_HIST_APP_ID = "app_id";
    private static final String COL_HIST_CREATED_AT = "created_at";
    private static final String COL_HIST_EVIDENCE_INFO = "evidence_info";
    private static final String COL_HIST_ID = "id";
    private static final String COL_HIST_RPDID = "rpdid";
    private static final String COL_HIST_RPUID = "rpuid";
    private static final String COL_HIST_SERVICE_INFO = "service_info";
    private static final String COL_HIST_SVC_ID = "svc_id";
    private static final String COL_PAYLOAD_JSON = "payload_json";
    private static final String COL_RESPONSE_ID = "response_id";
    private static final String COL_RPDID = "rpdid";
    private static final String COL_RPUID = "rpuid";
    private static final String COL_SERVICE_INFO = "service_info";
    private static final String COL_SIGNATURE = "signature";
    private static final String COL_SVC_ID = "svc_id";
    private static final String CREATE_KEY_HISTORY_TABLE = "CREATE TABLE IF NOT EXISTS key_attestation_history (id INTEGER PRIMARY KEY AUTOINCREMENT, rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, access_token TEXT, service_info TEXT, evidence_info TEXT, created_at INTEGER NOT NULL, app_id TEXT, svc_id TEXT)";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS pcc_channel (rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, app_id TEXT NOT NULL, svc_id TEXT NOT NULL, access_token TEXT, channel_id TEXT, channel_expiry_time TEXT, service_info TEXT, evidence_info TEXT, payload_json TEXT, response_id TEXT, signature TEXT, PRIMARY KEY (rpdid, rpuid, app_id, svc_id))";
    private static final String DB_NAME = "pcc_channel.db";
    private static final int DB_VERSION = 2;
    private static final int MAX_KEY_HISTORY_RECORDS = 1000;
    private static final String TABLE = "pcc_channel";
    private static final String TABLE_KEY_HISTORY = "key_attestation_history";
    private static final String TAG = "PccChannelDb";
    private final SQLiteOpenHelper helper;

    static {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    public PccChannelDb(final Context r8) {
        final String r3 = DB_NAME;
        final SQLiteDatabase.CursorFactory r4 = null;
        final int r5 = 2;
        this.helper = new AnonymousClass1(this, r8, r3, r4, r5);
    }

    public boolean save(String r7, String r8, String r9, String r10, CreateChannelResponse r11) {
    L18:
        e = move-exception;
        LogUtils.e(TAG, "save exception: " + e.getMessage());
        return false;
    L4:
        String r3 = "";
        if (r11.getServiceInfo() == null) goto L7;
        String r2 = r11.getServiceInfo().toJsonString();     // Catch: Exception -> L18
    L9:
        if (r11.getEvidenceInfo() == null) goto L11;
        r3 = r11.getEvidenceInfo().toJsonString();     // Catch: Exception -> L18
    L11:
        ContentValues r4 = new ContentValues();     // Catch: Exception -> L18
        r4.put("rpdid", r7);     // Catch: Exception -> L18
        r4.put("rpuid", r8);     // Catch: Exception -> L18
        r4.put("app_id", r9);     // Catch: Exception -> L18
        r4.put("svc_id", r10);     // Catch: Exception -> L18
        r4.put("access_token", r11.getAccessToken());     // Catch: Exception -> L18
        r4.put("channel_id", r11.getChannelId());     // Catch: Exception -> L18
        r4.put(COL_CHANNEL_EXPIRY_TIME, r11.getChannelExpiryTime());     // Catch: Exception -> L18
        r4.put("service_info", r2);     // Catch: Exception -> L18
        r4.put("evidence_info", r3);     // Catch: Exception -> L18
        r4.put(COL_PAYLOAD_JSON, r11.getPayloadJson());     // Catch: Exception -> L18
        r4.put(COL_RESPONSE_ID, r11.getResponseId());     // Catch: Exception -> L18
        r4.put(COL_SIGNATURE, r11.getSignature());     // Catch: Exception -> L18
        if (this.helper.getWritableDatabase().insertWithOnConflict(TABLE, null, r4, 5) != (-1)) goto L15;
        LogUtils.e(TAG, "save: insertWithOnConflict returned -1");     // Catch: Exception -> L18
        return false;
    L15:
        LogUtils.i(TAG, "save success: rpdid=" + r7 + " appId=" + r9 + " svcId=" + r10);     // Catch: Exception -> L18
        return true;
    L7:
        r2 = "";
        goto L9
    }

    public CreateChannelResponse query(String r9, String r10, String r11, String r12) {
        Cursor r8 = this.helper.getReadableDatabase().query(TABLE, null, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r9, r10, r11, r12}, null, null, null);     // Catch: Exception -> L21
        if (r8 != null) goto L25;
    L18:
        if (r8 == null) goto L30;
        r8.close();     // Catch: Exception -> L21
        return null;
    L30:
        return null;
    L25:
    L11:
        th = move-exception;
        if (r8 != null) goto L28;
    L17:
        throw th;     // Catch: Exception -> L21
    L28:
        r8.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L21
        goto L17
    L6:
        if (r8.moveToFirst() == false) goto L18;
        CreateChannelResponse r13 = CreateChannelResponse.fromDb(r8.getString(r8.getColumnIndexOrThrow("service_info")), r8.getString(r8.getColumnIndexOrThrow("evidence_info")), r8.getString(r8.getColumnIndexOrThrow("access_token")), r8.getString(r8.getColumnIndexOrThrow("channel_id")), r8.getString(r8.getColumnIndexOrThrow(COL_CHANNEL_EXPIRY_TIME)), r8.getString(r8.getColumnIndexOrThrow(COL_PAYLOAD_JSON)), r8.getString(r8.getColumnIndexOrThrow(COL_RESPONSE_ID)), r8.getString(r8.getColumnIndexOrThrow(COL_SIGNATURE)));     // Catch: Throwable -> L11
        if (r8 == null) goto L10;
        r8.close();     // Catch: Exception -> L21
    L10:
        return r13;
    L21:
        e = move-exception;
        LogUtils.e(TAG, "query exception: " + e.getMessage());
        return null;
    }

    public int deleteOtherRpuidChannels(String r6, String r7, String r8, String r9) {
        int r5 = this.helper.getWritableDatabase().delete(TABLE, "app_id=? AND svc_id=? AND (rpdid!=? OR rpuid!=?)", new String[]{r8, r9, r6, r7});     // Catch: Exception -> L5
        LogUtils.i(TAG, "deleteOtherRpuidChannels: deleted " + r5 + " rows for appId=" + r8 + " svcId=" + r9 + " (keeping rpdid=" + r6 + " rpuid=" + r7 + ")");     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "deleteOtherRpuidChannels exception: " + e.getMessage());
        return 0;
    }

    public boolean saveKeyAttestationHistory(String r9, String r10, String r11, String r12, CreateChannelResponse r13) {
        SQLiteDatabase r8 = this.helper.getWritableDatabase();     // Catch: Exception -> L18
        if (r13.getServiceInfo() == null) goto L6;
        String r2 = r13.getServiceInfo().toJsonString();     // Catch: Exception -> L18
    L8:
        if (r13.getEvidenceInfo() == null) goto L10;
        String r4 = r13.getEvidenceInfo().toJsonString();     // Catch: Exception -> L18
    L11:
        ContentValues r5 = new ContentValues();     // Catch: Exception -> L18
        r5.put("rpdid", r9);     // Catch: Exception -> L18
        r5.put("rpuid", r10);     // Catch: Exception -> L18
        r5.put("access_token", r13.getAccessToken());     // Catch: Exception -> L18
        r5.put("service_info", r2);     // Catch: Exception -> L18
        r5.put("evidence_info", r4);     // Catch: Exception -> L18
        r5.put(COL_HIST_CREATED_AT, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L18
        r5.put("app_id", r11);     // Catch: Exception -> L18
        r5.put("svc_id", r12);     // Catch: Exception -> L18
        if (r8.insert(TABLE_KEY_HISTORY, null, r5) != (-1)) goto L15;
        LogUtils.e(TAG, "saveKeyAttestationHistory: insert returned -1");     // Catch: Exception -> L18
        return false;
    L15:
        r8.execSQL("DELETE FROM key_attestation_history WHERE id NOT IN (  SELECT id  FROM key_attestation_history  ORDER BY created_at DESC  LIMIT 1000)");     // Catch: Exception -> L18
        LogUtils.i(TAG, "saveKeyAttestationHistory success: rpdid=" + r9 + " rpuid=" + r10 + " appId=" + r11 + " svcId=" + r12);     // Catch: Exception -> L18
        return true;
    L10:
        r4 = null;
        goto L11
    L6:
        r2 = null;
    L18:
        e = move-exception;
        LogUtils.e(TAG, "saveKeyAttestationHistory exception: " + e.getMessage());
        return false;
    }
}
