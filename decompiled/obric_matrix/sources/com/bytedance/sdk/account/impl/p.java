package com.bytedance.sdk.account.impl;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile p f5629d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f5630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private q f5632c;

    class a extends d.b.s.a.q.k.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f5633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f5634d;

        a(p r1, String r2) {
            this.f5634d = r1;
            this.f5633c = r2;
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void j(d.b.s.a.q.j.b r1, int r2) {
            m((d.b.s.a.q.m.h) r1, r2);
        }

        @Override // d.b.s.a.d
        public /* bridge */ /* synthetic */ void l(d.b.s.a.q.j.b r1) {
            n((d.b.s.a.q.m.h) r1);
        }

        public void m(d.b.s.a.q.m.h r3, int r4) {
            if (r3 != null) goto L4;
        L13:
            if (r3 == null) goto L15;
            String r5 = r3.f14894j;
        L16:
            com.ss.android.token.o.r("tt_token_beat", null, r4, r5);
            this.f5634d.i(false, this.f5633c, null);
            return;
        L15:
            r5 = "";
            goto L16
        L4:
            if ("session_expired".equalsIgnoreCase(r3.p) == false) goto L13;
            ArrayList r6 = new ArrayList();
            JSONObject r0 = r3.m;
            if (r0 != null) goto L8;
        L12:
            this.f5634d.i(true, this.f5633c, r6);
            return;
        L8:
            if (r0.optJSONObject("data") == null) goto L12;
            String r7 = r3.m.optJSONObject("data").optString("log_id");
            if (TextUtils.isEmpty(r7) == true) goto L12;
            r6.add(new com.ss.android.token.m("X-TT-LOGID", r7));
            goto L12
        }

        public void n(d.b.s.a.q.m.h r3) {
            if (p.a(this.f5634d) == null) goto L5;
            p r4 = this.f5634d;
            r4.f(p.a(r4).c());
        L5:
            this.f5634d.i(false, this.f5633c, null);
        }
    }

    private p(i r1) {
        this.f5630a = r1;
    }

    static /* synthetic */ q a(p r0) {
        return r0.f5632c;
    }

    public static p b() {
        return f5629d;
    }

    static p c(i r2) {
        if (f5629d != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5629d != null) goto L9;
        f5629d = new p(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return f5629d;
    }

    private void j() {
        String r0 = com.ss.android.token.n.h(false, false, "frontier");
        a r1 = new a(this, r0);
        d.b.s.a.y.g.O(this.f5630a.j0, r0, r1).D();
    }

    public q d() {
        q r0 = this.f5632c;
        this.f5632c = null;
        return r0;
    }

    public q e() {
        return this.f5632c;
    }

    void f(int r2) {
        JSONObject r1 = new JSONObject();
        r1.put("protocol_type", r2);     // Catch: JSONException -> L5
        com.bytedance.sdk.account.monitor.c.k("passport_frontier_message_error", r1);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    void g(q r4) {
        if (r4 == null) goto L11;
        JSONObject r0 = new JSONObject();
        r0.put("logId", r4.a());     // Catch: JSONException -> L6
        r0.put("protocol_type", r4.c());     // Catch: JSONException -> L6
        r0.put("is_login", this.f5630a.m());     // Catch: JSONException -> L6
        r0.put("user_id", this.f5630a.getUserId());     // Catch: JSONException -> L6
        com.bytedance.sdk.account.monitor.c.k("passport_receive_frontier_message", r0);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    synchronized void h(String r5) {
        monitor-enter(this);
        q r6 = q.g(r5);     // Catch: Throwable -> L28
        g(r6);     // Catch: Throwable -> L28
        if (this.f5631b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f5630a.m() == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (r6 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        if (r6.e() == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        if (com.ss.android.i.j.k().h() == true) goto L22;
    L25:
        this.f5632c = r6;     // Catch: Throwable -> L28
        com.ss.android.token.n.x();     // Catch: Throwable -> L28
        this.f5631b = true;     // Catch: Throwable -> L28
        j();     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L22:
        if (r6.d() == this.f5630a.getUserId()) goto L25;
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    void i(boolean r1, String r2, List<com.ss.android.token.m> r3) {
        if (r1 == false) goto L4;
        com.ss.android.token.n.p(r2, r3, true);
    L5:
        com.ss.android.token.n.v();
        this.f5631b = false;
        return;
    L4:
        this.f5632c = null;
        goto L5
    }
}
