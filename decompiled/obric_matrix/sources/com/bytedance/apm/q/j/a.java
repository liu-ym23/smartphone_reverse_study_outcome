package com.bytedance.apm.q.j;

import android.os.SystemClock;
import com.bytedance.apm.q.j.m.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends com.bytedance.apm.q.j.m.b> extends c<T> implements l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f1764j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f1765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f1766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1768i;

    /* JADX INFO: renamed from: com.bytedance.apm.q.j.a$a, reason: collision with other inner class name */
    class RunnableC0056a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f1770g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f1771h;

        RunnableC0056a(a r1, long r2, boolean r4) {
            this.f1771h = r1;
            this.f1769f = r2;
            this.f1770g = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.j(this.f1771h, this.f1769f, this.f1770g, com.bytedance.apm.q.a.F().E());
        }
    }

    static {
        f1764j = new Object();
    }

    a(String r1) {
        super(r1);
        this.f1765f = 0;
    }

    static /* synthetic */ void j(a r0, long r1, boolean r3, String r4) {
        r0.m(r1, r3, r4);
    }

    private void l(boolean r7) {
        Object r0 = f1764j;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f1765f > 0) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.f1766g <= 0) goto L12;
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (r7 == false) goto L11;
        m(r1 - this.f1766g, this.f1778c, com.bytedance.apm.q.a.F().E());     // Catch: Throwable -> L14
    L11:
        this.f1766g = r1;     // Catch: Throwable -> L14
        goto L12
    }

    private void m(long r11, boolean r13, String r14) {
        com.bytedance.apm.u.a r9 = new com.bytedance.apm.u.a(r13, System.currentTimeMillis(), h(), this.f1779d, r11, r14);
        com.bytedance.apm.q.i.a.h().l(r9);
    }

    @Override // com.bytedance.apm.q.j.c, com.bytedance.apm.q.j.l
    public void b(boolean r1) {
        l(r1);
        super.b(r1);
    }

    @Override // com.bytedance.apm.q.j.l
    public void d(boolean r1, boolean r2) {
        l(r2);
        this.f1779d = r1;
    }

    @Override // com.bytedance.apm.q.j.c, com.bytedance.apm.q.j.l
    public void f(boolean r1) {
        l(r1);
        super.f(r1);
    }

    @Override // com.bytedance.apm.q.j.c
    protected void g(T r8, long r9, long r11) {
        this.f1768i++;
        long r0 = r8.f1805a;
        if (r0 < r9) goto L6;
        r9 = r0;
    L6:
        long r2 = r8.f1806b;
        if (r2 > 0) goto L9;
    L12:
        p(r8, r11 - r0);
        long r12 = r11 - r9;
        if (r12 <= 0) goto L16;
        this.f1767h += r12;
        return;
    L16:
        return;
    L9:
        if (r11 < r2) goto L12;
        r11 = r2;
        goto L12
    }

    @Override // com.bytedance.apm.q.j.c
    protected void i(long r9, long r11, boolean r13) {
        this.f1768i = 0;
        this.f1767h = 0;
        l(r13);
        super.i(r9, r11, r13);
        long r10 = System.currentTimeMillis();
        o(((this.f1767h / (r10 - this.f1777b)) * 60000.0d) * 10.0d, ((((double) this.f1768i) / (r10 - this.f1777b)) * 60000.0d) * 10.0d);
    }

    void k() {
        Object r0 = f1764j;
        monitor-enter(r0);
        com.bytedance.apm.x.a.d("APM-Battery", "addHolderCount:" + this.f1765f + " type:" + h());     // Catch: Throwable -> L9
        this.f1765f = this.f1765f + 1;     // Catch: Throwable -> L9
        if (this.f1765f != 1) goto L7;
        this.f1766g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void n() {
        Object r0 = f1764j;
        monitor-enter(r0);
        com.bytedance.apm.x.a.d("APM-Battery", "reduceHolderCount:" + this.f1765f + " type:" + h());     // Catch: Throwable -> L13
        if (this.f1765f != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.f1765f--;     // Catch: Throwable -> L13
        if (this.f1765f != 0) goto L11;
        boolean r1 = this.f1778c;     // Catch: Throwable -> L13
        com.bytedance.apm.f0.b.f().i(new RunnableC0056a(this, SystemClock.elapsedRealtime() - this.f1766g, r1));     // Catch: Throwable -> L13
        this.f1766g = -1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    abstract void o(double r1, double r3);

    protected abstract void p(T r1, long r2);
}
