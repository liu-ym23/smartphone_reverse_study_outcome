package com.bytedance.applog.x;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.g;
import com.bytedance.applog.o.h;
import com.bytedance.applog.util.l;
import com.bytedance.applog.util.n;
import com.bytedance.applog.w.i;
import com.bytedance.common.wschannel.WsConstants;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.w.b f2462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.applog.q.c f2463c;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f2464f;

        a(b r1) {
            this.f2464f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            d r0 = b.b(this.f2464f);
            if (r0 == null) goto L5;
            this.f2464f.h(r0);
        L5:
            this.f2464f.c();
        }
    }

    b(Context r1, com.bytedance.applog.w.b r2, com.bytedance.applog.q.c r3) {
        this.f2462b = r2;
        this.f2463c = r3;
        f(r1);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ d b(b r0) {
        return r0.d();
    }

    private d d() {
        return d.b(a(this.f2461a, e(), 0).getString("key_task_session", ""));
    }

    private String e() {
        if (com.bytedance.applog.a.s() != null) goto L7;
        return "applog_task";
    L7:
        return com.bytedance.applog.a.s().y();
    }

    private void g(d r14) {
        if (r14 != null) goto L35;
        return;
    L35:
        i r3 = new i();     // Catch: Throwable -> L32
        r3.f2444g = r14.i();     // Catch: Throwable -> L32
        r3.f2446i = r14.g();     // Catch: Throwable -> L32
        r3.C = 1;     // Catch: Throwable -> L32
        if (r14.k() == false) goto L8;
        r3.B = r14.e();     // Catch: Throwable -> L32
    L8:
        if (r14.j() == false) goto L10;
        r3.A = r14.d();     // Catch: Throwable -> L32
    L10:
        r3.v = r14.c();     // Catch: Throwable -> L32
        r3.w = r14.f();     // Catch: Throwable -> L32
        r3.y = Integer.valueOf(r14.h());     // Catch: Throwable -> L32
        r3.z = Boolean.FALSE;     // Catch: Throwable -> L32
        r3.f2449l = com.bytedance.applog.a.w();     // Catch: Throwable -> L32
        r3.f2445h = h.l();     // Catch: Throwable -> L32
        r3.n = com.bytedance.common.utility.i.j(this.f2461a).a();     // Catch: Throwable -> L32
        h.b(r3, h.n);     // Catch: Throwable -> L32
        if (this.f2463c.l() == false) goto L25;
        JSONObject r1 = l.a(this.f2463c.d());     // Catch: Throwable -> L32
        if (this.f2463c.m(r1) == false) goto L19;
        g r2 = com.bytedance.applog.a.q();     // Catch: Throwable -> L32
        if (r2 == null) goto L18;
        r2.a(r1);     // Catch: Throwable -> L32
    L18:
        n.a("[task] save task session to db : " + r14);     // Catch: Throwable -> L32
        com.bytedance.applog.w.g r15 = new com.bytedance.applog.w.g();     // Catch: Throwable -> L32
        r15.N(r1, null, r3, null, new JSONArray[]{null, null, null}, new long[]{-1, -1, -1}, null, null, 9);     // Catch: Throwable -> L32
        this.f2462b.h(r15, true, null, true, null);     // Catch: Throwable -> L32
        return;
    L19:
        if (r1 == null) goto L22;
        String r13 = "[task] saveTaskSession new header without valid did: " + r1.optString(WsConstants.KEY_DEVICE_ID) + ", iid: " + r1.optString("install_id");     // Catch: Throwable -> L32
    L21:
        n.c(r13, null);     // Catch: Throwable -> L32
        com.bytedance.applog.r.b.a r16 = com.bytedance.applog.r.b.a.n;     // Catch: Throwable -> L32
        com.bytedance.applog.r.b.d r17 = com.bytedance.applog.r.b.d.z;     // Catch: Throwable -> L32
    L24:
        com.bytedance.applog.o.b.d(r16, r17);     // Catch: Throwable -> L32
        return;
    L22:
        r13 = "[task] saveTaskSession new header is null";
        goto L21
    L25:
        JSONObject r18 = this.f2463c.d();     // Catch: Throwable -> L32
        if (r18 == null) goto L29;
        String r19 = "[task] saveTaskSession device header without valid did: " + r18.optString(WsConstants.KEY_DEVICE_ID) + ", iid: " + r18.optString("install_id");     // Catch: Throwable -> L32
    L28:
        n.c(r19, null);     // Catch: Throwable -> L32
        r16 = com.bytedance.applog.r.b.a.n;     // Catch: Throwable -> L32
        r17 = com.bytedance.applog.r.b.d.z;     // Catch: Throwable -> L32
        goto L24
    L29:
        r19 = "[task] saveTaskSession device header is null";
    L32:
        th = move-exception;
        n.c("[task] Save task session failed", th);
    }

    private void j(String r3) {
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        SharedPreferences.Editor r2 = a(this.f2461a, e(), 0).edit();     // Catch: Throwable -> L6
        r2.putString("key_task_session", r3);     // Catch: Throwable -> L6
        r2.apply();     // Catch: Throwable -> L6
        return;
    }

    public void c() {
        n.a("[task] clear task session sp");
        j("");
    }

    public void f(Context r2) {
        this.f2461a = r2.getApplicationContext();
        e.d().b(new a(this));
    }

    public void h(d r1) {
        g(r1);
    }

    public void i(d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        n.a("[task] saveTaskSessionToSp : " + r3);
        j(r3.o());
    }
}
