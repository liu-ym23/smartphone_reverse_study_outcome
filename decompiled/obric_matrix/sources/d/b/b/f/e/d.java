package d.b.b.f.e;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.b.n.g.a f12816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.w.a.a.c f12817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f12818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.b.b.f.d.c f12819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g f12820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private g f12821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f12822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g f12823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g f12824l;

    public d(d.b.b.n.g.a r2) {
        this.f12813a = false;
        this.f12814b = false;
        this.f12816d = r2;
    }

    private void a(g r3) {
        if (this.f12813a == true) goto L5;
        return;
    L5:
        if (this.f12814b == false) goto L17;
        this.f12818f = r3;
        d.b.b.f.d.c r0 = this.f12819g;
        d.b.b.n.g.a r1 = this.f12816d;
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        r3.a(r0, r2);
        d();
        return;
    L10:
        if (r1.isForeground() == false) goto L13;
        r2 = false;
        goto L14
    }

    private void d() {
        if (d.b.b.o.a.c() == false) goto L6;
        d.b.b.o.m.b.d("APM-CPU", "change cpu exception detect state: " + this.f12818f);
        return;
    }

    @Nullable
    public d.b.w.a.a.c b() {
        return this.f12817e;
    }

    public void c(g r2, g r3, g r4, g r5, g r6) {
        if (this.f12814b == false) goto L5;
        return;
    L5:
        this.f12820h = r2;
        this.f12821i = r3;
        this.f12822j = r4;
        this.f12823k = r5;
        this.f12824l = r6;
        this.f12817e = d.b.w.a.a.b.a(com.bytedance.apm.d.h());     // Catch: Throwable -> L9
    L7:
        this.f12814b = true;
    }

    public synchronized void e() {
        monitor-enter(this);
        a(this.f12823k);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void f() {
        monitor-enter(this);
        a(this.f12824l);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void g(boolean r3) {
        monitor-enter(this);
        g r0 = this.f12818f;     // Catch: Throwable -> L17
        if (r0 != null) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.f12813a == false) goto L15;
        if (this.f12815c != r3) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f12815c = r3;     // Catch: Throwable -> L17
        r0.b(r3);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized void h() {
        monitor-enter(this);
        a(this.f12820h);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void i() {
        monitor-enter(this);
        a(this.f12821i);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void j() {
        monitor-enter(this);
        a(this.f12822j);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void k(d.b.b.f.d.c r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f12813a == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.f12814b == false) goto L15;
        this.f12819g = r2;     // Catch: Throwable -> L17
        boolean r3 = true;
        this.f12813a = true;     // Catch: Throwable -> L17
        b.b(d.b.b.f.a.c().b());     // Catch: Throwable -> L17
        if (this.f12816d.isForeground() == false) goto L12;
        r3 = false;
    L12:
        this.f12815c = r3;     // Catch: Throwable -> L17
        h();     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public synchronized void l() {
        monitor-enter(this);
        g r0 = this.f12818f;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f12813a == false) goto L11;
        r0.d();     // Catch: Throwable -> L13
        this.f12813a = false;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
