package com.bytedance.privacy.pcc.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.f.b;
import com.bytedance.privacy.pcc.h.b.c;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5422b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f5423a;

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.g.a$a, reason: collision with other inner class name */
    class C0172a extends SQLiteOpenHelper {
        C0172a(a r1, Context r2, String r3, SQLiteDatabase.CursorFactory r4, int r5) {
            super(r2, r3, r4, r5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r1) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS pcc_channel (rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, app_id TEXT NOT NULL, svc_id TEXT NOT NULL, access_token TEXT, channel_id TEXT, channel_expiry_time TEXT, service_info TEXT, evidence_info TEXT, payload_json TEXT, response_id TEXT, signature TEXT, PRIMARY KEY (rpdid, rpuid, app_id, svc_id))");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            r1.execSQL("DROP TABLE IF EXISTS pcc_channel");
            r1.execSQL("CREATE TABLE IF NOT EXISTS pcc_channel (rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, app_id TEXT NOT NULL, svc_id TEXT NOT NULL, access_token TEXT, channel_id TEXT, channel_expiry_time TEXT, service_info TEXT, evidence_info TEXT, payload_json TEXT, response_id TEXT, signature TEXT, PRIMARY KEY (rpdid, rpuid, app_id, svc_id))");
        }
    }

    static {
    }

    public a(Context r8) {
        this.f5423a = new C0172a(this, r8, "pcc_channel.db", null, 1);
    }

    public c a(String r9, String r10, String r11, String r12) {
        Cursor r8 = this.f5423a.getReadableDatabase().query("pcc_channel", null, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r9, r10, r11, r12}, null, null, null);     // Catch: Exception -> L21
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
        if (r8 != null) goto L27;
    L17:
        throw th;     // Catch: Exception -> L21
    L27:
        r8.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L21
        goto L17
    L6:
        if (r8.moveToFirst() == false) goto L18;
        c r13 = c.a(r8.getString(r8.getColumnIndexOrThrow("service_info")), r8.getString(r8.getColumnIndexOrThrow("evidence_info")), r8.getString(r8.getColumnIndexOrThrow("access_token")), r8.getString(r8.getColumnIndexOrThrow(WsConstants.KEY_CHANNEL_ID)), r8.getString(r8.getColumnIndexOrThrow("channel_expiry_time")), r8.getString(r8.getColumnIndexOrThrow("payload_json")), r8.getString(r8.getColumnIndexOrThrow("response_id")), r8.getString(r8.getColumnIndexOrThrow("signature")));     // Catch: Throwable -> L11
        if (r8 == null) goto L10;
        r8.close();     // Catch: Exception -> L21
    L10:
        return r13;
    L21:
        e = move-exception;
        b.b(f5422b, "query exception: " + e.getMessage());
        return null;
    }

    public boolean b(String r6, String r7, String r8, String r9, c r10) {
    L18:
        e = move-exception;
        b.b(f5422b, "save exception: " + e.getMessage());
        return false;
    L4:
        String r2 = "";
        if (r10.h() == null) goto L7;
        String r1 = r10.h().c();     // Catch: Exception -> L18
    L9:
        if (r10.e() == null) goto L11;
        r2 = r10.e().c();     // Catch: Exception -> L18
    L11:
        ContentValues r3 = new ContentValues();     // Catch: Exception -> L18
        r3.put("rpdid", r6);     // Catch: Exception -> L18
        r3.put("rpuid", r7);     // Catch: Exception -> L18
        r3.put(IBdInstall.PARAM_APP_ID, r8);     // Catch: Exception -> L18
        r3.put("svc_id", r9);     // Catch: Exception -> L18
        r3.put("access_token", r10.b());     // Catch: Exception -> L18
        r3.put(WsConstants.KEY_CHANNEL_ID, r10.d());     // Catch: Exception -> L18
        r3.put("channel_expiry_time", r10.c());     // Catch: Exception -> L18
        r3.put("service_info", r1);     // Catch: Exception -> L18
        r3.put("evidence_info", r2);     // Catch: Exception -> L18
        r3.put("payload_json", r10.f());     // Catch: Exception -> L18
        r3.put("response_id", r10.g());     // Catch: Exception -> L18
        r3.put("signature", r10.i());     // Catch: Exception -> L18
        if (this.f5423a.getWritableDatabase().insertWithOnConflict("pcc_channel", null, r3, 5) != (-1)) goto L15;
        b.b(f5422b, "save: insertWithOnConflict returned -1");     // Catch: Exception -> L18
        return false;
    L15:
        b.a(f5422b, "save success: rpdid=" + r6 + " appId=" + r8 + " svcId=" + r9);     // Catch: Exception -> L18
        return true;
    L7:
        r1 = "";
        goto L9
    }
}
