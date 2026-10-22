package com.bytedance.applog.o;

import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.m0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class a extends c {
    a(e r1) {
        super(r1);
    }

    @Override // com.bytedance.applog.o.c
    protected boolean c(int r15) {
        if (this.f2264f != 0) goto L5;
        this.f2264f = System.currentTimeMillis();
    L5:
        long r0 = System.currentTimeMillis();
        com.bytedance.applog.q.b r16 = this.f2259a.q();
        com.bytedance.applog.q.c r4 = this.f2259a.t();
        if (r4.l() == false) goto L18;
        long r5 = System.currentTimeMillis();
        JSONObject r7 = new JSONObject();
        r7.put("header", r4.d());
        r7.put("magic_tag", "ss_app_log");
        r7.put("_gen_time", r5);
        JSONObject r6 = com.bytedance.applog.v.a.a(com.bytedance.applog.v.a.f(com.bytedance.applog.a.b(this.f2259a.r(), this.f2259a.z().b(), true, m0.f2843g), com.bytedance.applog.v.a.f2438d), r7);
        if (r6 != null) goto L10;
        return false;
    L10:
        if (this.f2264f == 0) goto L12;
        b.l(com.bytedance.applog.r.b.a.s, com.bytedance.applog.r.b.d.P, System.currentTimeMillis() - this.f2264f);
        this.f2264f = 0;
    L12:
        b.l(com.bytedance.applog.r.b.a.s, com.bytedance.applog.r.b.d.o, System.currentTimeMillis() - r0);
        boolean r14 = !p.j(r16.e(), r6);
        if (n.f2430b == false) goto L15;
        StringBuilder r17 = new StringBuilder();
        r17.append("getAbConfig ");
        r17.append(r6);
    L16:
        n.b(r17.toString(), null);
        r4.p(r6);
        com.bytedance.applog.util.a.g().e(r14, r6);
        return true;
    L15:
        r17 = new StringBuilder();
        r17.append("getAbConfig ");
        r17.append(r14);
        goto L16
    L18:
        b.d(com.bytedance.applog.r.b.a.s, com.bytedance.applog.r.b.d.z);
        return false;
    }

    @Override // com.bytedance.applog.o.c
    protected String e() {
        return "abconfiger";
    }

    @Override // com.bytedance.applog.o.c
    protected long[] f() {
        return c.f2258g;
    }

    @Override // com.bytedance.applog.o.c
    protected boolean h() {
        return true;
    }

    @Override // com.bytedance.applog.o.c
    protected long i() {
        long r0 = this.f2259a.q().f();
        if (r0 < 600000) goto L5;
        return r0;
    L5:
        return 600000;
    }
}
