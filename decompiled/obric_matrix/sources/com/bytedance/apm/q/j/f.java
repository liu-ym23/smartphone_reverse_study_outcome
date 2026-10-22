package com.bytedance.apm.q.j;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f1790e;

    public f() {
        super("cpu_active_time");
        this.f1790e = 0;
    }

    private long i() {
        return com.bytedance.apm.util.b.j(100);
    }

    @Override // com.bytedance.apm.q.j.b
    protected void c(boolean r8, boolean r9) {
        long r0 = com.bytedance.apm.util.b.b();
        long r2 = this.f1790e;
        if (r2 <= 0) goto L9;
        if (r9 == false) goto L9;
        long r3 = r0 - r2;
        if (r3 <= 0) goto L8;
        h(r8, r3, com.bytedance.apm.q.a.F().E());
        goto L9
    L8:
        com.bytedance.apm.x.a.d("APM-Battery", "CPU Value:" + r3);
    L9:
        this.f1790e = r0;
    }

    @Override // com.bytedance.apm.q.j.l
    public void e(com.bytedance.apm.q.i.b r8, com.bytedance.apm.u.a r9) {
        boolean r0 = r9.k();
        double r3 = (r9.a() / i()) * 1000.0d;
        if (r0 == false) goto L5;
        r8.l((long) r3);
        return;
    L5:
        r8.b((long) r3);
    }
}
