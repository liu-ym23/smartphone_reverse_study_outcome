package f.a.g;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b, f.a.j.a.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    f.a.j.e.b<b> f17044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f17045g;

    public a() {
    }

    @Override // f.a.j.a.b
    public boolean a(b r1) {
        if (c(r1) == false) goto L6;
        r1.dispose();
        return true;
    L6:
        return false;
    }

    @Override // f.a.j.a.b
    public boolean b(b r2) {
        f.a.j.b.b.c(r2, "disposable is null");
        if (this.f17045g == true) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f17045g == true) goto L13;
        f.a.j.e.b<b> r0 = this.f17044f;     // Catch: Throwable -> L15
        if (r0 != null) goto L10;
        r0 = new f.a.j.e.b();     // Catch: Throwable -> L15
        this.f17044f = r0;     // Catch: Throwable -> L15
    L10:
        r0.a(r2);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L18:
        r2.dispose();
        return false;
    }

    @Override // f.a.j.a.b
    public boolean c(b r3) {
        f.a.j.b.b.c(r3, "disposables is null");
        if (this.f17045g == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f17045g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        f.a.j.e.b<b> r0 = this.f17044f;     // Catch: Throwable -> L20
        if (r0 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r0.e(r3) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    void d(f.a.j.e.b<b> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ArrayList r5 = null;
        Object[] r7 = r6.b();
        int r0 = r7.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L16;
        Object r3 = r7[r2];
        if ((r3 instanceof b) == false) goto L15;
        ((b) r3).dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        f.a.h.b.a(th);
        if (r5 != null) goto L14;
        r5 = new ArrayList();
    L14:
        r5.add(th);
    L15:
        r2 = r2 + 1;
        goto L5
    L16:
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.size() != 1) goto L22;
        throw f.a.j.e.a.a((Throwable) r5.get(0));
    L22:
        throw new f.a.h.a(r5);
    }

    @Override // f.a.g.b
    public void dispose() {
        if (this.f17045g == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f17045g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.f17045g = true;     // Catch: Throwable -> L14
        f.a.j.e.b<b> r0 = this.f17044f;     // Catch: Throwable -> L14
        this.f17044f = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        d(r0);
    }

    public boolean e() {
        return this.f17045g;
    }
}
