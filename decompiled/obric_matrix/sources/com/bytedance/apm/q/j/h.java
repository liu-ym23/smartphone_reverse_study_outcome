package com.bytedance.apm.q.j;

import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes.dex */
public class h extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f1792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f1793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.bytedance.apm.a0.k.h f1794g;

    public h() {
        super("traffic_packets");
        this.f1792e = -1;
        this.f1793f = -1;
        this.f1794g = com.bytedance.apm.a0.k.h.e();
    }

    private void i(boolean r9) {
        long r0 = this.f1794g.d();
        long r2 = this.f1794g.b();
        if (this.f1793f > (-1)) goto L5;
    L8:
        this.f1792e = r0;
        this.f1793f = r2;
        return;
    L5:
        if (this.f1792e <= (-1)) goto L8;
        if (r9 == false) goto L8;
        String r10 = com.bytedance.apm.q.a.F().E();
        h(true, r0 - this.f1792e, r10);
        h(false, r2 - this.f1793f, r10);
        goto L8
    }

    @Override // com.bytedance.apm.q.j.b
    protected void c(boolean r4, boolean r5) {
        if (g() == false) goto L14;
        i(r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.d.C() == false) goto L10;
        com.bytedance.apm.x.e.d(com.bytedance.apm.x.b.f2126b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        EnsureManager.ensureNotReachHere(th, "BatteryPacketsStatsImpl");
        return;
    }

    @Override // com.bytedance.apm.q.j.l
    public void e(com.bytedance.apm.q.i.b r3, com.bytedance.apm.u.a r4) {
        boolean r2 = r4.k();
        long r0 = r4.a();
        if (r2 == false) goto L5;
        r3.q(r0);
        return;
    L5:
        r3.g(r0);
    }
}
