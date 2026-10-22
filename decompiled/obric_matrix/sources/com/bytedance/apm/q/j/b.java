package com.bytedance.apm.q.j;

import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f1772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f1773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1775d;

    b(String r1) {
        this.f1774c = r1;
        this.f1775d = com.bytedance.apm.d.G();
        this.f1772a = ActivityLifeObserver.getInstance().isForeground();
        this.f1773b = com.bytedance.apm.q.k.a.f(com.bytedance.apm.d.h());
    }

    @Override // com.bytedance.apm.q.j.l
    public void a(boolean r2) {
        c(this.f1772a, r2);
    }

    @Override // com.bytedance.apm.q.j.l
    public void b(boolean r2) {
        c(this.f1772a, r2);
        this.f1772a = false;
    }

    protected abstract void c(boolean r1, boolean r2);

    @Override // com.bytedance.apm.q.j.l
    public void d(boolean r2, boolean r3) {
        c(this.f1772a, r3);
        this.f1773b = r2;
    }

    @Override // com.bytedance.apm.q.j.l
    public void f(boolean r2) {
        c(this.f1772a, r2);
        this.f1772a = true;
    }

    protected boolean g() {
        return this.f1775d;
    }

    void h(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        com.bytedance.apm.q.i.a.h().l(new com.bytedance.apm.u.a(r11, System.currentTimeMillis(), this.f1774c, this.f1773b, r12, r14));
        return;
    L5:
        if (com.bytedance.apm.d.C() == false) goto L7;
        com.bytedance.apm.x.e.d(com.bytedance.apm.x.b.f2126b, new String[]{"AbsBatteryValueStats value error: " + r12 + " type:" + this.f1774c});
    L7:
        com.bytedance.apm.x.a.d("APM-Battery", "AbsBatteryValueStats value error: " + r12 + " type:" + this.f1774c);
    }
}
