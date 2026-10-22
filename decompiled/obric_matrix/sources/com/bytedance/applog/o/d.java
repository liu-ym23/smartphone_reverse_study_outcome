package com.bytedance.applog.o;

import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.m0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class d extends c {
    d(e r3) {
        super(r3, r3.q().l());
    }

    @Override // com.bytedance.applog.o.c
    public boolean c(int r13) {
        if (this.f2264f != 0) goto L5;
        this.f2264f = System.currentTimeMillis();
    L5:
        long r0 = System.currentTimeMillis();
        com.bytedance.applog.q.c r14 = this.f2259a.t();
        if (r14.l() == false) goto L16;
        JSONObject r4 = new JSONObject();
        r4.put("magic_tag", "ss_app_log");
        r4.put("header", r14.d());
        r4.put("_gen_time", System.currentTimeMillis());
        com.bytedance.applog.q.b r15 = this.f2259a.q();
        com.bytedance.applog.v.a.e(r4, false, r15);
        JSONObject r5 = com.bytedance.applog.v.a.d(com.bytedance.applog.v.a.f(com.bytedance.applog.a.b(this.f2259a.r(), this.f2259a.z().g(), true, m0.f2843g), com.bytedance.applog.v.a.f2438d), r4);
        com.bytedance.applog.util.a.g().c(!p.j(r5, r15.j()), r5);
        if (r5 != null) goto L10;
    L17:
        return false;
    L10:
        if (this.f2264f == 0) goto L12;
        b.l(com.bytedance.applog.r.b.a.r, com.bytedance.applog.r.b.d.P, System.currentTimeMillis() - this.f2264f);
        this.f2264f = 0;
    L12:
        b.l(com.bytedance.applog.r.b.a.r, com.bytedance.applog.r.b.d.o, System.currentTimeMillis() - r0);
        r15.N(r5);
        this.f2259a.g();
        if (this.f2259a.q().t().M() == false) goto L15;
        e r12 = this.f2259a;
        r12.L(com.bytedance.applog.p.a.g(r12.r(), r5));
    L15:
        return true;
    L16:
        b.d(com.bytedance.applog.r.b.a.r, com.bytedance.applog.r.b.d.z);
        goto L17
    }

    @Override // com.bytedance.applog.o.c
    protected String e() {
        return "configer";
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
        return this.f2259a.q().k();
    }
}
