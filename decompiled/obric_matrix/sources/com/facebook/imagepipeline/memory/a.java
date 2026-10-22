package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<V> implements d.c.c.g.f<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f6662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final d.c.c.g.d f6663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final f0 f6664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final SparseArray<f<V>> f6665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<V> f6666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final C0205a f6668l;
    final C0205a m;
    private final g0 n;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.memory.a$a, reason: collision with other inner class name */
    static class C0205a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6670b;

        C0205a() {
        }

        public void a(int r4) {
            int r0 = this.f6670b;
            if (r0 < r4) goto L7;
            int r2 = this.f6669a;
            if (r2 <= 0) goto L7;
            this.f6669a = r2 - 1;
            this.f6670b = r0 - r4;
            return;
        L7:
            d.c.c.e.a.G("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(this.f6670b), Integer.valueOf(this.f6669a)});
        }

        public void b(int r2) {
            this.f6669a++;
            this.f6670b += r2;
        }

        public void c() {
            this.f6669a = 0;
            this.f6670b = 0;
        }
    }

    public static class b extends RuntimeException {
        public b(Object r3) {
            super("Invalid size: " + r3.toString());
        }
    }

    public static class c extends RuntimeException {
        public c(int r3, int r4, int r5, int r6) {
            super("Pool hard cap violation? Hard cap = " + r3 + " Used size = " + r4 + " Free size = " + r5 + " Request size = " + r6);
        }
    }

    public a(d.c.c.g.d r2, f0 r3, g0 r4) {
        this.f6662f = getClass();
        d.c.c.d.i.g(r2);
        this.f6663g = r2;
        d.c.c.d.i.g(r3);
        f0 r5 = r3;
        this.f6664h = r5;
        d.c.c.d.i.g(r4);
        this.n = r4;
        this.f6665i = new SparseArray();
        if (r5.f6720d == false) goto L5;
        m();
    L6:
        this.f6666j = d.c.c.d.k.b();
        this.m = new C0205a();
        this.f6668l = new C0205a();
        return;
    L5:
        q(new SparseIntArray(0));
        goto L6
    }

    private synchronized void d() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (o() == true) goto L6;
    L9:
        boolean r0 = true;
    L10:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        if (this.m.f6670b == 0) goto L9;
        r0 = false;
        goto L10
    }

    private void e(SparseIntArray r9) {
        this.f6665i.clear();
        int r1 = 0;
    L4:
        if (r1 >= r9.size()) goto L6;
        int r2 = r9.keyAt(r1);
        this.f6665i.put(r2, new f(k(r2), r9.valueAt(r1), 0, this.f6664h.f6720d));
        r1 = r1 + 1;
        goto L4
    }

    private synchronized f<V> h(int r2) {
        monitor-enter(this);
        f<V> r3 = this.f6665i.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void m() {
        monitor-enter(this);
        SparseIntArray r0 = this.f6664h.f6719c;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        e(r0);     // Catch: Throwable -> L9
        this.f6667k = false;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        this.f6667k = true;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private synchronized void q(SparseIntArray r11) {
        monitor-enter(this);
        d.c.c.d.i.g(r11);     // Catch: Throwable -> L13
        this.f6665i.clear();     // Catch: Throwable -> L13
        SparseIntArray r0 = this.f6664h.f6719c;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= r0.size()) goto L9;
        int r3 = r0.keyAt(r2);     // Catch: Throwable -> L13
        this.f6665i.put(r3, new f(k(r3), r0.valueAt(r2), r11.get(r3, 0), this.f6664h.f6720d));     // Catch: Throwable -> L13
        r2 = r2 + 1;     // Catch: Throwable -> L13
        goto L7
    L9:
        this.f6667k = false;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L10:
        this.f6667k = true;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void r() {
        if (d.c.c.e.a.p(2) == false) goto L6;
        d.c.c.e.a.v(this.f6662f, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.f6668l.f6669a), Integer.valueOf(this.f6668l.f6670b), Integer.valueOf(this.m.f6669a), Integer.valueOf(this.m.f6670b));
        return;
    }

    private List<f<V>> u() {
        ArrayList r0 = new ArrayList(this.f6665i.size());
        int r1 = this.f6665i.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        f<V> r3 = this.f6665i.valueAt(r2);
        int r4 = r3.f6712a;
        int r5 = r3.f6713b;
        int r6 = r3.e();
        if (r3.d() <= 0) goto L7;
        r0.add(r3);
    L7:
        this.f6665i.setValueAt(r2, new f(k(r4), r5, r6, this.f6664h.f6720d));
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    @Override // d.c.c.g.c
    public void a(d.c.c.g.b r1) {
        v();
    }

    protected abstract V b(int r1);

    synchronized boolean c(int r6) {
        monitor-enter(this);
        f0 r0 = this.f6664h;     // Catch: Throwable -> L19
        int r1 = r0.f6717a;     // Catch: Throwable -> L19
        int r2 = this.f6668l.f6670b;     // Catch: Throwable -> L19
        if (r6 <= (r1 - r2)) goto L8;
        this.n.f();     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L8:
        int r3 = r0.f6718b;     // Catch: Throwable -> L19
        if (r6 <= (r3 - (r2 + this.m.f6670b))) goto L12;
        w(r3 - r6);     // Catch: Throwable -> L19
    L12:
        if (r6 <= (r1 - (this.f6668l.f6670b + this.m.f6670b))) goto L17;
        this.n.f();     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L17:
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        throw th;
    }

    protected abstract void f(V r1);

    synchronized f<V> g(int r4) {
        monitor-enter(this);
        f<V> r0 = this.f6665i.get(r4);     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
    L14:
        monitor-exit(this);
        return r0;
    L6:
        if (this.f6667k == false) goto L14;
        if (d.c.c.e.a.p(2) == false) goto L11;
        d.c.c.e.a.s(this.f6662f, "creating new bucket %s", Integer.valueOf(r4));     // Catch: Throwable -> L16
    L11:
        f<V> r1 = s(r4);     // Catch: Throwable -> L16
        this.f6665i.put(r4, r1);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.f
    public V get(int r6) {
        d();
        int r7 = i(r6);
        monitor-enter(this);
        f<V> r0 = g(r7);     // Catch: Throwable -> L43
        if (r0 == null) goto L13;
        V r2 = l(r0);     // Catch: Throwable -> L43
        if (r2 == null) goto L13;
        d.c.c.d.i.i(this.f6666j.add(r2));     // Catch: Throwable -> L43
        int r8 = j(r2);     // Catch: Throwable -> L43
        int r1 = k(r8);     // Catch: Throwable -> L43
        this.f6668l.b(r1);     // Catch: Throwable -> L43
        this.m.a(r1);     // Catch: Throwable -> L43
        this.n.b(r1);     // Catch: Throwable -> L43
        r();     // Catch: Throwable -> L43
        if (d.c.c.e.a.p(2) == false) goto L11;
        d.c.c.e.a.t(this.f6662f, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r2)), Integer.valueOf(r8));     // Catch: Throwable -> L43
    L11:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r2;
    L13:
        int r3 = k(r7);     // Catch: Throwable -> L43
        if (c(r3) == false) goto L42;
        this.f6668l.b(r3);     // Catch: Throwable -> L43
        if (r0 == null) goto L18;
        r0.f();     // Catch: Throwable -> L43
    L18:
        monitor-exit(this);     // Catch: Throwable -> L43
        V r4 = null;
        r4 = b(r7);     // Catch: Throwable -> L22
    L29:
        monitor-enter(this);
        d.c.c.d.i.i(this.f6666j.add(r4));     // Catch: Throwable -> L35
        x();     // Catch: Throwable -> L35
        this.n.a(r3);     // Catch: Throwable -> L35
        r();     // Catch: Throwable -> L35
        if (d.c.c.e.a.p(2) == false) goto L33;
        d.c.c.e.a.t(this.f6662f, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r4)), Integer.valueOf(r7));     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);     // Catch: Throwable -> L35
        return r4;
    L35:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        monitor-enter(this);
        this.f6668l.a(r3);     // Catch: Throwable -> L38
        f<V> r5 = g(r7);     // Catch: Throwable -> L38
        if (r5 == null) goto L27;
        r5.b();     // Catch: Throwable -> L38
    L27:
        d.c.c.d.n.c(th);
    L38:
        th = move-exception;
        throw th;
    L42:
        throw new c(this.f6664h.f6717a, this.f6668l.f6670b, this.m.f6670b, r3);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    protected abstract int i(int r1);

    protected abstract int j(V r1);

    protected abstract int k(int r1);

    protected synchronized V l(f<V> r1) {
        monitor-enter(this);
        V r2 = r1.c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    protected void n() {
        this.f6663g.a(this);
        this.n.c(this);
    }

    synchronized boolean o() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if ((this.f6668l.f6670b + this.m.f6670b) <= this.f6664h.f6718b) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        this.n.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
        goto L7
    }

    protected boolean p(V r1) {
        d.c.c.d.i.g(r1);
        return true;
    }

    @Override // d.c.c.g.f, d.c.c.h.c
    public void release(V r8) {
        d.c.c.d.i.g(r8);
        int r0 = j(r8);
        int r1 = k(r0);
        monitor-enter(this);
        f<V> r2 = h(r0);     // Catch: Throwable -> L28
        if (this.f6666j.remove(r8) == true) goto L8;
        d.c.c.e.a.h(this.f6662f, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[]{Integer.valueOf(System.identityHashCode(r8)), Integer.valueOf(r0)});     // Catch: Throwable -> L28
        f(r8);     // Catch: Throwable -> L28
        g0 r9 = this.n;     // Catch: Throwable -> L28
    L7:
        r9.e(r1);     // Catch: Throwable -> L28
    L25:
        r();     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L8:
        if (r2 != null) goto L10;
    L19:
        if (r2 == null) goto L22;
        r2.b();     // Catch: Throwable -> L28
    L22:
        if (d.c.c.e.a.p(2) == false) goto L24;
        d.c.c.e.a.t(this.f6662f, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r8)), Integer.valueOf(r0));     // Catch: Throwable -> L28
    L24:
        f(r8);     // Catch: Throwable -> L28
        this.f6668l.a(r1);     // Catch: Throwable -> L28
        r9 = this.n;     // Catch: Throwable -> L28
        goto L7
    L10:
        if (r2.g() == true) goto L19;
        if (o() == true) goto L19;
        if (p(r8) == false) goto L19;
        r2.i(r8);     // Catch: Throwable -> L28
        this.m.b(r1);     // Catch: Throwable -> L28
        this.f6668l.a(r1);     // Catch: Throwable -> L28
        this.n.g(r1);     // Catch: Throwable -> L28
        if (d.c.c.e.a.p(2) == false) goto L25;
        d.c.c.e.a.t(this.f6662f, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r8)), Integer.valueOf(r0));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    f<V> s(int r4) {
        return new f(k(r4), Integer.MAX_VALUE, 0, this.f6664h.f6720d);
    }

    protected void t() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    void v() {
        monitor-enter(this);
        int r1 = 0;
        if (this.f6664h.f6720d == false) goto L6;
        List r0 = u();     // Catch: Throwable -> L25
    L14:
        this.m.c();     // Catch: Throwable -> L25
        r();     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        t();
    L18:
        if (r1 >= r0.size()) goto L24;
        f r2 = (f) r0.get(r1);
    L20:
        Object r3 = r2.h();
        if (r3 == null) goto L22;
        f(r3);
        goto L20
    L22:
        r1 = r1 + 1;
        goto L18
    L24:
        return;
    L6:
        r0 = new ArrayList(this.f6665i.size());     // Catch: Throwable -> L25
        SparseIntArray r4 = new SparseIntArray();     // Catch: Throwable -> L25
        int r5 = 0;
    L8:
        if (r5 >= this.f6665i.size()) goto L13;
        f<V> r6 = this.f6665i.valueAt(r5);     // Catch: Throwable -> L25
        if (r6.d() <= 0) goto L12;
        r0.add(r6);     // Catch: Throwable -> L25
    L12:
        r4.put(this.f6665i.keyAt(r5), r6.e());     // Catch: Throwable -> L25
        r5 = r5 + 1;     // Catch: Throwable -> L25
        goto L8
    L13:
        q(r4);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    synchronized void w(int r8) {
        monitor-enter(this);
        int r0 = this.f6668l.f6670b;     // Catch: Throwable -> L28
        int r1 = this.m.f6670b;     // Catch: Throwable -> L28
        int r2 = Math.min((r0 + r1) - r8, r1);     // Catch: Throwable -> L28
        if (r2 > 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (d.c.c.e.a.p(2) == false) goto L11;
        d.c.c.e.a.u(this.f6662f, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(r8), Integer.valueOf(this.f6668l.f6670b + this.m.f6670b), Integer.valueOf(r2));     // Catch: Throwable -> L28
    L11:
        r();     // Catch: Throwable -> L28
        int r3 = 0;
    L13:
        if (r3 >= this.f6665i.size()) goto L23;
        if (r2 <= 0) goto L23;
        f<V> r4 = this.f6665i.valueAt(r3);     // Catch: Throwable -> L28
    L17:
        if (r2 <= 0) goto L22;
        V r5 = r4.h();     // Catch: Throwable -> L28
        if (r5 == null) goto L22;
        f(r5);     // Catch: Throwable -> L28
        int r6 = r4.f6712a;     // Catch: Throwable -> L28
        r2 = r2 - r6;     // Catch: Throwable -> L28
        this.m.a(r6);     // Catch: Throwable -> L28
    L22:
        r3 = r3 + 1;     // Catch: Throwable -> L28
    L23:
        r();     // Catch: Throwable -> L28
        if (d.c.c.e.a.p(2) == false) goto L26;
        d.c.c.e.a.t(this.f6662f, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(r8), Integer.valueOf(this.f6668l.f6670b + this.m.f6670b));     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    synchronized void x() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (o() == false) goto L6;
        w(this.f6664h.f6718b);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
