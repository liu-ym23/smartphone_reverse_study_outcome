package com.bytedance.privacy.pcc.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.utils.LogUtils;

/* JADX INFO: loaded from: classes3.dex */
public class PccChannelDb {
    private static final String COL_ACCESS_TOKEN = "access_token";
    private static final String COL_APP_ID = "app_id";
    private static final String COL_CHANNEL_EXPIRY_TIME = "channel_expiry_time";
    private static final String COL_CHANNEL_ID = "channel_id";
    private static final String COL_CLIENT_LANE_TYPE = "client_lane_type";
    private static final String COL_EVIDENCE_INFO = "evidence_info";
    private static final String COL_FINAL_LANE_TYPE = "final_lane_type";
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
    private static final String COL_PROTOCOL_VERSION = "protocol_version";
    private static final String COL_RESPONSE_ID = "response_id";
    private static final String COL_RPDID = "rpdid";
    private static final String COL_RPUID = "rpuid";
    private static final String COL_SERVER_LANE_TYPE = "server_lane_type";
    private static final String COL_SERVICE_INFO = "service_info";
    private static final String COL_SIGNATURE = "signature";
    private static final String COL_SVC_ID = "svc_id";
    private static final String CREATE_KEY_HISTORY_TABLE = "CREATE TABLE IF NOT EXISTS key_attestation_history (id INTEGER PRIMARY KEY AUTOINCREMENT, rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, access_token TEXT, service_info TEXT, evidence_info TEXT, created_at INTEGER NOT NULL, app_id TEXT, svc_id TEXT)";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS pcc_channel (rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, app_id TEXT NOT NULL, svc_id TEXT NOT NULL, access_token TEXT, channel_id TEXT, channel_expiry_time TEXT, service_info TEXT, evidence_info TEXT, payload_json TEXT, response_id TEXT, signature TEXT, protocol_version INTEGER, client_lane_type INTEGER DEFAULT 1, server_lane_type INTEGER DEFAULT 1, final_lane_type INTEGER DEFAULT 1, PRIMARY KEY (rpdid, rpuid, app_id, svc_id))";
    private static final String DB_NAME = "pcc_channel.db";
    private static final int DB_VERSION = 3;
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
        final int r5 = 3;
        this.helper = new AnonymousClass1(this, r8, r3, r4, r5);
    }

    public boolean save(String r7, String r8, String r9, String r10, CreateChannelResponse r11, int r12, LaneTypeInfo r13) {
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
        r4.put(COL_PROTOCOL_VERSION, Integer.valueOf(r12));     // Catch: Exception -> L18
        r4.put(COL_CLIENT_LANE_TYPE, Integer.valueOf(r13.clientLaneType));     // Catch: Exception -> L18
        r4.put(COL_SERVER_LANE_TYPE, Integer.valueOf(r13.serverLaneType));     // Catch: Exception -> L18
        r4.put(COL_FINAL_LANE_TYPE, Integer.valueOf(r13.finalLaneType));     // Catch: Exception -> L18
        if (this.helper.getWritableDatabase().insertWithOnConflict(TABLE, null, r4, 5) != (-1)) goto L15;
        LogUtils.e(TAG, "save: insertWithOnConflict returned -1");     // Catch: Exception -> L18
        return false;
    L15:
        LogUtils.i(TAG, "save success: rpdid=" + r7 + " appId=" + r9 + " svcId=" + r10 + " protocolVersion=" + r12 + HanziToPinyin.Token.SEPARATOR + r13);     // Catch: Exception -> L18
        return true;
    L7:
        r2 = "";
        goto L9
    }

    public CreateChannelResponse query(String r10, String r11, String r12, String r13) {
        Cursor r9 = this.helper.getReadableDatabase().query(TABLE, null, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r10, r11, r12, r13}, null, null, null);     // Catch: Exception -> L21
        if (r9 != null) goto L28;
    L18:
        if (r9 == null) goto L30;
        r9.close();     // Catch: Exception -> L21
        return null;
    L30:
        return null;
    L28:
    L11:
        th = move-exception;
        if (r9 != null) goto L26;
    L17:
        throw th;     // Catch: Exception -> L21
    L26:
        r9.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L21
        goto L17
    L6:
        if (r9.moveToFirst() == false) goto L18;
        CreateChannelResponse r14 = CreateChannelResponse.fromDb(r9.getString(r9.getColumnIndexOrThrow("service_info")), r9.getString(r9.getColumnIndexOrThrow("evidence_info")), r9.getString(r9.getColumnIndexOrThrow("access_token")), r9.getString(r9.getColumnIndexOrThrow("channel_id")), r9.getString(r9.getColumnIndexOrThrow(COL_CHANNEL_EXPIRY_TIME)), r9.getString(r9.getColumnIndexOrThrow(COL_PAYLOAD_JSON)), r9.getString(r9.getColumnIndexOrThrow(COL_RESPONSE_ID)), r9.getString(r9.getColumnIndexOrThrow(COL_SIGNATURE)), r9.getInt(r9.getColumnIndexOrThrow(COL_PROTOCOL_VERSION)));     // Catch: Throwable -> L11
        if (r9 == null) goto L10;
        r9.close();     // Catch: Exception -> L21
    L10:
        return r14;
    L21:
        e = move-exception;
        LogUtils.e(TAG, "query exception: " + e.getMessage());
        return null;
    }

    public LaneTypeInfo getLaneTypeInfo(String r9, String r10, String r11, String r12) {
        Cursor r8 = this.helper.getReadableDatabase().query(TABLE, new String[]{COL_CLIENT_LANE_TYPE, COL_SERVER_LANE_TYPE, COL_FINAL_LANE_TYPE}, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r9, r10, r11, r12}, null, null, null);     // Catch: Exception -> L31
        if (r8 != null) goto L38;
    L28:
        if (r8 == null) goto L40;
        r8.close();     // Catch: Exception -> L31
        return null;
    L40:
        return null;
    L38:
    L21:
        th = move-exception;
        if (r8 != null) goto L36;
    L27:
        throw th;     // Catch: Exception -> L31
    L36:
        r8.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31
        goto L27
    L6:
        if (r8.moveToFirst() == false) goto L28;
        int r13 = r8.getColumnIndex(COL_CLIENT_LANE_TYPE);     // Catch: Throwable -> L21
        int r14 = r8.getColumnIndex(COL_SERVER_LANE_TYPE);     // Catch: Throwable -> L21
        int r15 = r8.getColumnIndex(COL_FINAL_LANE_TYPE);     // Catch: Throwable -> L21
        if (r13 == (-1)) goto L28;
        if (r14 == (-1)) goto L28;
        if (r15 == (-1)) goto L28;
        if (r8.isNull(r13) == true) goto L28;
        if (r8.isNull(r14) == true) goto L28;
        if (r8.isNull(r15) == true) goto L28;
        LaneTypeInfo r16 = new LaneTypeInfo(r8.getInt(r13), r8.getInt(r14), r8.getInt(r15));     // Catch: Throwable -> L21
        if (r8 == null) goto L20;
        r8.close();     // Catch: Exception -> L31
    L20:
        return r16;
    L31:
        e = move-exception;
        LogUtils.e(TAG, "getLaneTypeInfo exception: " + e.getMessage());
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

    public int delete(String r6, String r7, String r8, String r9) {
        int r5 = this.helper.getWritableDatabase().delete(TABLE, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r6, r7, r8, r9});     // Catch: Exception -> L5
        LogUtils.i(TAG, "delete: deleted " + r5 + " rows for rpdid=" + r6 + " rpuid=" + r7 + " appId=" + r8 + " svcId=" + r9);     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "delete exception: " + e.getMessage());
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
