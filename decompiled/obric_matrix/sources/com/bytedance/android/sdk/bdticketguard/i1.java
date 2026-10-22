package com.bytedance.android.sdk.bdticketguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f815e;

    public static final class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, kotlin.u<String, kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0>>> f816a;

        public a(Handler r2) {
            kotlin.n0.d.o.g(r2, "handler");
            super(r2);
            this.f816a = new LinkedHashMap();
        }

        public final void a(String r2, String r3, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r4) {
            kotlin.n0.d.o.g(r2, "id");
            kotlin.n0.d.o.g(r3, WsConstants.KEY_CONNECTION_TYPE);
            if (r4 == null) goto L6;
            this.f816a.put(r2, kotlin.a0.a(r3, r4));
            return;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r5, Uri r6) {
            super.onChange(r5, r6);
            if (r5 == false) goto L5;
            return;
        L5:
            if (r6 != null) goto L8;
            return;
        L8:
            if (kotlin.n0.d.o.a(r6.getPath(), "/load_result") == false) goto L29;
            String r7 = r6.getQueryParameter("id");
            if (r7 == null) goto L30;
            kotlin.n0.d.o.b(r7, "uri.getQueryParameter(PARAM_ID) ?: return");
            String r8 = r6.getQueryParameter("result");
            if (r8 == null) goto L31;
            com.bytedance.android.sdk.bdticketguard.n1.c r9 = com.bytedance.android.sdk.bdticketguard.n1.c.f875a.a(Integer.parseInt(r8));
            if ((r9 instanceof com.bytedance.android.sdk.bdticketguard.n1.c.f) == true) goto L16;
            r9 = null;
        L16:
            com.bytedance.android.sdk.bdticketguard.n1.c.f r10 = (com.bytedance.android.sdk.bdticketguard.n1.c.f) r9;
            if (r10 != null) goto L20;
            r10 = com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b;
        L20:
            kotlin.u<String, kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0>> r0 = this.f816a.get(r7);
            if (r0 == null) goto L27;
            kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r2 = r0.d();
            com.bytedance.android.sdk.bdticketguard.n1.b r1 = com.bytedance.android.sdk.bdticketguard.n1.b.f873l.a(r0.c());
            if (r1 == null) goto L25;
            r2.invoke(r1, r10);
            goto L27
        L25:
            kotlin.n0.d.o.p();
            throw null;
        L27:
            this.f816a.remove(r7);
            return;
        L31:
            return;
        L30:
            return;
        }
    }

    public i1(Context r5) {
        kotlin.n0.d.o.g(r5, "context");
        this.f815e = r5;
        String r0 = j1.a(r5);
        this.f811a = r0;
        String r1 = "content://" + r0;
        this.f812b = r1;
        a r2 = new a(new Handler(Looper.getMainLooper()));
        this.f813c = r2;
        this.f814d = true;
        r5.getContentResolver().registerContentObserver(Uri.parse(r1 + "/load_result"), false, r2);     // Catch: Throwable -> L5
        return;
    L5:
        this.f814d = false;
    }

    private final Uri a(String r2, Map<String, String> r3) {
        Uri r1 = Uri.parse(this.f812b + '/' + r2);
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L15;
        Uri.Builder r5 = r1.buildUpon();
        Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, String> r7 = r6.next();
        r5.appendQueryParameter(r7.getKey(), r7.getValue());
        goto L12
    L14:
        r1 = r5.build();
    L15:
        kotlin.n0.d.o.b(r1, "result");
        return r1;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Uri b(i1 r0, String r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    private final Cursor s(Uri r7) {
        return this.f815e.getContentResolver().query(r7, null, null, null, null);
    }

    private final boolean t(String r6, String r7) {
        boolean r1 = false;
        Cursor r2 = null;
        r2 = s(b(this, r6, null, 2, null));     // Catch: Throwable -> L12 Exception -> L14
        if (r2 != null) goto L6;
    L10:
        if (r2 == null) goto L18;
    L11:
        r2.close();
    L18:
        return r1;
    L6:
        if (r2.moveToFirst() != true) goto L10;
        if (r2.getInt(r2.getColumnIndexOrThrow(r7)) != 1) goto L10;
        r1 = true;
        goto L10
    L12:
        th = move-exception;
        if (r2 == null) goto L21;
        r2.close();
    L21:
        throw th;
    L14:
        e = move-exception;
        s0.f1065a.c("TicketGuardProvider", "get " + r7 + " from provider failed", e);     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        goto L18
    }

    private final void u(String r3, String r4, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r5) {
        if (this.f814d == true) goto L11;
        if (r5 == null) goto L10;
        com.bytedance.android.sdk.bdticketguard.n1.b r2 = com.bytedance.android.sdk.bdticketguard.n1.b.f873l.a(r3);
        if (r2 == null) goto L8;
        kotlin.f0 r6 = r5.invoke(r2, com.bytedance.android.sdk.bdticketguard.n1.c.b.f879b);
        return;
    L8:
        kotlin.n0.d.o.p();
        throw null;
    L10:
        return;
    L11:
        String r0 = UUID.randomUUID().toString();
        kotlin.n0.d.o.b(r0, "UUID.randomUUID().toString()");
        this.f813c.a(r0, r3, r5);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put(WsConstants.KEY_CONNECTION_TYPE, r3);
        r7.put("scene", r4);
        r7.put("id", r0);
        s(a("query_load", r7));
    }

    private final String v(String r6, String r7) {
        Cursor r1 = null;
        String r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        Cursor r5 = s(b(this, r6, null, 2, null));     // Catch: Throwable -> L13 Exception -> L15
        if (r5 != null) goto L26;
    L11:
        if (r5 == null) goto L20;
    L12:
        r5.close();
    L20:
        return r2;
    L26:
    L9:
        e = e;
    L17:
        s0.f1065a.c("TicketGuardProvider", "get " + r7 + " from provider failed", e);     // Catch: Throwable -> L21
        if (r5 == null) goto L20;
    L21:
        th = th;
        r1 = r5;
    L23:
        if (r1 == null) goto L25;
        r1.close();
    L25:
        throw th;
    L6:
        if (r5.moveToFirst() != true) goto L11;
        r2 = r5.getString(r5.getColumnIndexOrThrow(r7));     // Catch: Exception -> L9 Throwable -> L21
        goto L11
    L15:
        e = e;
        r5 = null;
    L13:
        th = th;
        goto L23
    }

    private final int x(Uri r3) {
        return this.f815e.getContentResolver().update(r3, new ContentValues(), null, null);
    }

    public final void A(w0 r4) {
        kotlin.n0.d.o.g(r4, "ticketData");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(WsConstants.KEY_CONNECTION_TYPE, r4.e());
        r0.put("ticket", r4.b());
        String r1 = r4.c();
        if (r1 == null) goto L5;
        String r2 = r0.put("ts_sign", r1);
    L5:
        String r3 = r4.d();
        if (r3 == null) goto L8;
        String r5 = r0.put("ts_sign_ree", r3);
    L8:
        String r6 = r4.a();
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        r0.put("cert", r6);
        x(a("update_ticket_data", r0));
    }

    public final String c() {
        String r1 = v("attest_pub_key", "attest_pub_key");
        if (r1 != null) goto L7;
        return "";
    L7:
        return r1;
    }

    public final com.bytedance.android.sdk.bdticketguard.m1.c d() {
        Cursor r5 = s(a("get_attest_sign_cache", null));
        if (r5 == null) goto L20;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        kotlin.m0.b.a(r5, th);
        throw th;
    L5:
        if (r5.moveToFirst() == false) goto L10;
        com.bytedance.android.sdk.bdticketguard.m1.c.a r2 = com.bytedance.android.sdk.bdticketguard.m1.c.f855a;     // Catch: Throwable -> L14
        String r3 = r5.getString(r5.getColumnIndexOrThrow("attest_sign_result"));     // Catch: Throwable -> L14
        kotlin.n0.d.o.b(r3, "it.getString(it.getColum…(COL_ATTEST_SIGN_RESULT))");     // Catch: Throwable -> L14
        com.bytedance.android.sdk.bdticketguard.m1.c r4 = r2.a(r3);     // Catch: Throwable -> L14
        if (r4 != null) goto L11;
        r4 = new com.bytedance.android.sdk.bdticketguard.m1.c.b("", new IOException("IPC deserialisation Failed"));     // Catch: Throwable -> L14
    L11:
        kotlin.m0.b.a(r5, null);
        if (r4 == null) goto L20;
        return r4;
    L10:
        r4 = new com.bytedance.android.sdk.bdticketguard.m1.c.b("", new IOException("IPC Failed: cursor empty"));     // Catch: Throwable -> L14
    L20:
        return new com.bytedance.android.sdk.bdticketguard.m1.c.b("", new IOException("IPC Failed: cursor null"));
    }

    public final String e(String r7, String r8) {
        kotlin.n0.d.o.g(r7, "content");
        kotlin.n0.d.o.g(r8, "path");
        boolean r2 = true;
        Cursor r3 = null;
        String r4 = null;
        String r5 = null;
        r5 = null;
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L17 Exception -> L21
        r6.put("content", r7);     // Catch: Throwable -> L17 Exception -> L21
        r6.put("path", r8);     // Catch: Throwable -> L17 Exception -> L21
        Cursor r9 = s(a("ree_hmac", r6));     // Catch: Throwable -> L17 Exception -> L21
        if (r9 != null) goto L36;
    L13:
        String r10 = null;
    L14:
        if (r9 == null) goto L16;
        r9.close();
    L16:
        String r11 = r4;
        r5 = r10;
    L24:
        if (r5 != null) goto L26;
    L29:
        if (r2 == false) goto L32;
        return r11;
    L32:
        throw new RuntimeException(r5);
    L26:
        if (r5.length() == 0) goto L29;
        r2 = false;
        goto L29
    L36:
    L12:
        r11 = null;
    L22:
        if (r9 == null) goto L24;
        r9.close();
    L10:
        th = th;
        r3 = r9;
    L18:
        if (r3 == null) goto L20;
        r3.close();
    L20:
        throw th;
    L6:
        if (r9.moveToFirst() != true) goto L13;
        r11 = r9.getString(r9.getColumnIndexOrThrow("ree_hmac_result"));     // Catch: Throwable -> L10 Exception -> L12
        r10 = r9.getString(r9.getColumnIndex("exception_message"));     // Catch: Throwable -> L10 Exception -> L33
        r4 = r11;
        goto L14
        goto L22
    L21:
        r9 = null;
        r11 = null;
    L17:
        th = th;
        goto L18
    }

    public final String f() {
        return v("query_ree_public_key", "ree_public_key");
    }

    public final String g(String r6, String r7, String r8) {
        kotlin.n0.d.o.g(r6, "unsigned");
        kotlin.n0.d.o.g(r7, "path");
        kotlin.n0.d.o.g(r8, "signType");
        Cursor r2 = null;
        String r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L13 Exception -> L15
        r4.put("unsigned", r6);     // Catch: Throwable -> L13 Exception -> L15
        r4.put("path", r7);     // Catch: Throwable -> L13 Exception -> L15
        r4.put("sign_type", r8);     // Catch: Throwable -> L13 Exception -> L15
        Cursor r5 = s(a("sign", r4));     // Catch: Throwable -> L13 Exception -> L15
        if (r5 != null) goto L26;
    L11:
        if (r5 == null) goto L20;
    L12:
        r5.close();
    L20:
        return r3;
    L26:
    L9:
        e = e;
    L17:
        s0.f1065a.c("TicketGuardProvider", "sign from provider failed", e);     // Catch: Throwable -> L21
        if (r5 == null) goto L20;
    L21:
        th = th;
        r2 = r5;
    L23:
        if (r2 == null) goto L25;
        r2.close();
    L25:
        throw th;
    L6:
        if (r5.moveToFirst() != true) goto L11;
        r3 = r5.getString(r5.getColumnIndexOrThrow("encoded_signed"));     // Catch: Exception -> L9 Throwable -> L21
        goto L11
    L15:
        e = e;
        r5 = null;
    L13:
        th = th;
        goto L23
    }

    public final String h() {
        return v("query_client_cert", "client_cert");
    }

    public final String i() {
        return v("query_csr", "csr");
    }

    public final String j() {
        String r2 = v("query_ree_create_log", "ree_create_log");
        if (r2 != null) goto L7;
        return "";
    L7:
        return r2;
    }

    public final l0 k() {
        l0 r0 = null;
        Cursor r8 = s(b(this, "query_server_cert", null, 2, null));     // Catch: Throwable -> L34 Exception -> L36
        if (r8 != null) goto L46;
    L32:
        if (r8 == null) goto L41;
    L33:
        r8.close();
    L41:
        return r0;
    L46:
        boolean r2 = true;
        if (r8.moveToFirst() != true) goto L32;
        String r1 = r8.getString(r8.getColumnIndexOrThrow("server_cert_string"));     // Catch: Exception -> L30 Throwable -> L42
        String r3 = r8.getString(r8.getColumnIndexOrThrow("serial_number"));     // Catch: Exception -> L30 Throwable -> L42
        String r4 = r8.getString(r8.getColumnIndexOrThrow("public_key"));     // Catch: Exception -> L30 Throwable -> L42
        if (r1 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L32;
        if (r3 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L32;
        if (r4 != null) goto L24;
    L27:
        if (r2 == true) goto L32;
        r0 = new l0(r1, r3, r4);     // Catch: Exception -> L30 Throwable -> L42
        goto L32
    L24:
        if (r4.length() == 0) goto L27;
        r2 = false;
        goto L27
    L17:
        if (r3.length() == 0) goto L20;
        r7 = false;
        goto L21
    L10:
        if (r1.length() == 0) goto L13;
        r6 = false;
    L30:
        e = e;
    L38:
        s0.f1065a.c("TicketGuardProvider", "get server cert from provider failed", e);     // Catch: Throwable -> L42
        if (r8 == null) goto L41;
    L42:
        Throwable th = th;
    L43:
        if (r8 == null) goto L45;
        r8.close();
    L45:
        throw th;
    L36:
        e = e;
        r8 = null;
    L34:
        th = move-exception;
        th = th;
        r8 = null;
        goto L43
    }

    public final String l() {
        String r2 = v("query_tee_create_log", "tee_create_log");
        if (r2 != null) goto L7;
        return "";
    L7:
        return r2;
    }

    public final boolean m() {
        return t("QUERY_TEE_EVER_FAIL", "TEE_EVER_FAIL");
    }

    public final String n() {
        String r2 = v("QUERY_TEE_PUB", "TEE_PUB");
        if (r2 != null) goto L7;
        return "";
    L7:
        return r2;
    }

    public final w0 o(String r10) {
        kotlin.n0.d.o.g(r10, "ticket");
        Cursor r2 = null;
        w0 r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L13 Exception -> L15
        r4.put("ticket", r10);     // Catch: Throwable -> L13 Exception -> L15
        Cursor r9 = s(a("ticket_data", r4));     // Catch: Throwable -> L13 Exception -> L15
        if (r9 != null) goto L26;
    L11:
        if (r9 == null) goto L20;
    L12:
        r9.close();
    L20:
        return r3;
    L26:
    L9:
        e = e;
    L17:
        s0.f1065a.c("TicketGuardProvider", "get ticket data from provider failed", e);     // Catch: Throwable -> L21
        if (r9 == null) goto L20;
    L21:
        th = th;
        r2 = r9;
    L23:
        if (r2 == null) goto L25;
        r2.close();
    L25:
        throw th;
    L6:
        if (r9.moveToFirst() != true) goto L11;
        String r5 = r9.getString(r9.getColumnIndexOrThrow(WsConstants.KEY_CONNECTION_TYPE));     // Catch: Exception -> L9 Throwable -> L21
        String r6 = r9.getString(r9.getColumnIndexOrThrow("ts_sign"));     // Catch: Exception -> L9 Throwable -> L21
        String r7 = r9.getString(r9.getColumnIndexOrThrow("ts_sign_ree"));     // Catch: Exception -> L9 Throwable -> L21
        String r8 = r9.getString(r9.getColumnIndexOrThrow("cert"));     // Catch: Exception -> L9 Throwable -> L21
        kotlin.n0.d.o.b(r5, WsConstants.KEY_CONNECTION_TYPE);     // Catch: Exception -> L9 Throwable -> L21
        r3 = new w0(r5, r10, r6, r7, r8);     // Catch: Exception -> L9 Throwable -> L21
        goto L11
    L15:
        e = e;
        r9 = null;
    L13:
        th = th;
        goto L23
    }

    public final void p(String r2, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r3) {
        kotlin.n0.d.o.g(r2, "scene");
        u("encryption", r2, r3);
    }

    public final void q(String r2, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r3) {
        kotlin.n0.d.o.g(r2, "scene");
        u("ree", r2, r3);
    }

    public final void r(String r2, kotlin.n0.c.p<? super com.bytedance.android.sdk.bdticketguard.n1.b, ? super com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> r3) {
        kotlin.n0.d.o.g(r2, "scene");
        u("tee", r2, r3);
    }

    public final void w(String r3) {
        kotlin.n0.d.o.g(r3, "reason");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("tee_fail_reason", r3);
        x(a("update_tee_ever_fail", r0));
    }

    public final void y(String r5, String r6) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L18;
        if (r6 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        return;
    L12:
        if (r6.length() == 0) goto L15;
        r3 = false;
    L18:
        LinkedHashMap r4 = new LinkedHashMap();
        if (r5 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L27;
        r4.put("client_cert", r5);
    L27:
        if (r6 != null) goto L29;
    L30:
        r0 = true;
    L31:
        if (r0 == true) goto L33;
        r4.put("server_cert", r6);
    L33:
        x(a("update_cert", r4));
        return;
    L29:
        if (r6.length() != 0) goto L31;
    L21:
        if (r5.length() == 0) goto L24;
        r7 = false;
        goto L25
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void z(String r3) {
        kotlin.n0.d.o.g(r3, "secTs");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("sec_ts", r3);
        x(a("update_sec_ts", r0));
    }
}
