package com.bytedance.privacy.pcc.db;

import a.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.privacy.pcc.network.model.CreateChannelResponse;
import com.bytedance.privacy.utils.LogUtils;
import com.google.gson.Gson;
import com.obric.matrix.push.common.CommonConstants;

/* JADX INFO: loaded from: classes.dex */
public class PccChannelDb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteOpenHelper f15a;

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.db.PccChannelDb$1, reason: invalid class name */
    class AnonymousClass1 extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r1) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS pcc_channel (rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, app_id TEXT NOT NULL, svc_id TEXT NOT NULL, access_token TEXT, channel_id TEXT, channel_expiry_time TEXT, service_info TEXT, evidence_info TEXT, payload_json TEXT, response_id TEXT, signature TEXT, protocol_version INTEGER, client_lane_type INTEGER DEFAULT 1, server_lane_type INTEGER DEFAULT 1, final_lane_type INTEGER DEFAULT 1, PRIMARY KEY (rpdid, rpuid, app_id, svc_id))");
            r1.execSQL("CREATE TABLE IF NOT EXISTS key_attestation_history (id INTEGER PRIMARY KEY AUTOINCREMENT, rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, access_token TEXT, service_info TEXT, evidence_info TEXT, created_at INTEGER NOT NULL, app_id TEXT, svc_id TEXT)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r5, int r6, int r7) {
            if (r6 < 2) goto L7;
            if (r7 >= 2) goto L7;
            r5.execSQL("DROP TABLE IF EXISTS key_attestation_history");
            LogUtils.d("PccChannelDb", "onDowngrade: dropped key_attestation_history table (v" + r6 + " -> v" + r7 + ")");
        L7:
            if (r6 < 3) goto L11;
            if (r7 >= 3) goto L12;
            r5.execSQL("DELETE FROM pcc_channel");
            LogUtils.d("PccChannelDb", "onDowngrade: cleared pcc_channel data due to protocol_version removal (v" + r6 + " -> v" + r7 + ")");
            return;
        L12:
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            if (r2 >= 2) goto L6;
            r1.execSQL("CREATE TABLE IF NOT EXISTS key_attestation_history (id INTEGER PRIMARY KEY AUTOINCREMENT, rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, access_token TEXT, service_info TEXT, evidence_info TEXT, created_at INTEGER NOT NULL, app_id TEXT, svc_id TEXT)");
        L6:
            if (r2 >= 3) goto L9;
            r1.execSQL("ALTER TABLE pcc_channel ADD COLUMN protocol_version INTEGER");
            r1.execSQL("ALTER TABLE pcc_channel ADD COLUMN client_lane_type INTEGER DEFAULT 1");
            r1.execSQL("ALTER TABLE pcc_channel ADD COLUMN server_lane_type INTEGER DEFAULT 1");
            r1.execSQL("ALTER TABLE pcc_channel ADD COLUMN final_lane_type INTEGER DEFAULT 1");
            r1.execSQL("UPDATE pcc_channel SET protocol_version = 1");
            LogUtils.d("PccChannelDb", "onUpgrade: added protocol_version, client_lane_type, server_lane_type, final_lane_type columns and marked existing data as V1 (v" + r2 + " -> v" + r3 + ")");
            return;
        }
    }

    public PccChannelDb(Context r5) {
        this.f15a = new AnonymousClass1(r5, "pcc_channel.db", null, 3);
    }

    public final LaneTypeInfo a(String r9, String r10, String r11, String r12) {
        String[] r4 = {r9, r10, r11, r12};
        String[] r2 = {"client_lane_type", "server_lane_type", "final_lane_type"};
        Cursor r8 = this.f15a.getReadableDatabase().query("pcc_channel", r2, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", r4, null, null, null);     // Catch: Exception -> L20
        if (r8 != null) goto L34;
    L28:
        if (r8 == null) goto L39;
        r8.close();     // Catch: Exception -> L20
        return null;
    L39:
        return null;
    L34:
    L22:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Exception -> L20
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L20
        goto L27
    L6:
        if (r8.moveToFirst() == false) goto L28;
        int r13 = r8.getColumnIndex("client_lane_type");     // Catch: Throwable -> L22
        int r14 = r8.getColumnIndex("server_lane_type");     // Catch: Throwable -> L22
        int r15 = r8.getColumnIndex("final_lane_type");     // Catch: Throwable -> L22
        if (r13 == (-1)) goto L28;
        if (r14 == (-1)) goto L28;
        if (r15 == (-1)) goto L28;
        if (r8.isNull(r13) == true) goto L28;
        if (r8.isNull(r14) == true) goto L28;
        if (r8.isNull(r15) == true) goto L28;
        LaneTypeInfo r16 = new LaneTypeInfo(r8.getInt(r13), r8.getInt(r14), r8.getInt(r15));     // Catch: Throwable -> L22
        r8.close();     // Catch: Exception -> L20
        return r16;
    L20:
        e = move-exception;
        a.w(e, new StringBuilder("getLaneTypeInfo exception: "), "PccChannelDb");
        return null;
    }

    public final boolean b(String r10, String r11, String r12, String r13, CreateChannelResponse r14) {
        SQLiteDatabase r9 = this.f15a.getWritableDatabase();     // Catch: Exception -> L7
        if (r14.b() == null) goto L9;
        CreateChannelResponse.ServiceInfo r3 = r14.b();     // Catch: Exception -> L7
        r3.getClass();     // Catch: Exception -> L7
        String r4 = new Gson().toJson(r3);     // Catch: Exception -> L7
    L10:
        CreateChannelResponse.Payload r15 = r14.f18a;
        if (r15 == null) goto L13;
        CreateChannelResponse.EvidenceInfo r5 = r15.b;     // Catch: Exception -> L7
    L14:
        if (r5 == null) goto L19;
        if (r15 == null) goto L17;
        CreateChannelResponse.EvidenceInfo r6 = r15.b;     // Catch: Exception -> L7
    L18:
        r6.getClass();     // Catch: Exception -> L7
        String r7 = new Gson().toJson(r6);     // Catch: Exception -> L7
    L20:
        ContentValues r8 = new ContentValues();     // Catch: Exception -> L7
        r8.put("rpdid", r10);     // Catch: Exception -> L7
        r8.put("rpuid", r11);     // Catch: Exception -> L7
        if (r15 == null) goto L23;
        String r16 = r15.c;     // Catch: Exception -> L7
    L24:
        r8.put("access_token", r16);     // Catch: Exception -> L7
        r8.put("service_info", r4);     // Catch: Exception -> L7
        r8.put("evidence_info", r7);     // Catch: Exception -> L7
        r8.put("created_at", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L7
        r8.put(CommonConstants.APP_ID, r12);     // Catch: Exception -> L7
        r8.put("svc_id", r13);     // Catch: Exception -> L7
        if (r9.insert("key_attestation_history", null, r8) != (-1)) goto L28;
        LogUtils.b("PccChannelDb", "saveKeyAttestationHistory: insert returned -1");     // Catch: Exception -> L7
        return false;
    L28:
        r9.execSQL("DELETE FROM key_attestation_history WHERE id NOT IN (  SELECT id  FROM key_attestation_history  ORDER BY created_at DESC  LIMIT 1000)");     // Catch: Exception -> L7
        LogUtils.d("PccChannelDb", "saveKeyAttestationHistory success: rpdid=" + r10 + " rpuid=" + r11 + " appId=" + r12 + " svcId=" + r13);     // Catch: Exception -> L7
        return true;
    L23:
        r16 = "";
        goto L24
    L17:
        r6 = null;
        goto L18
    L19:
        r7 = null;
        goto L20
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = null;
    L7:
        e = move-exception;
        a.w(e, new StringBuilder("saveKeyAttestationHistory exception: "), "PccChannelDb");
        return false;
    }
}
