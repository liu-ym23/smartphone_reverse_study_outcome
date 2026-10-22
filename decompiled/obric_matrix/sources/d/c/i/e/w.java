package d.c.i.e;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f15985b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<d.c.b.a.d, d.c.i.l.e> f15986a;

    static {
        f15985b = w.class;
    }

    private w() {
        this.f15986a = new HashMap();
    }

    public static w b() {
        return new w();
    }

    private synchronized void c() {
        monitor-enter(this);
        d.c.c.e.a.s(f15985b, "Count = %d", Integer.valueOf(this.f15986a.size()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized d.c.i.l.e a(d.c.b.a.d r7) {
        monitor-enter(this);
        d.c.c.d.i.g(r7);     // Catch: Throwable -> L20
        d.c.i.l.e r0 = this.f15986a.get(r7);     // Catch: Throwable -> L20
        if (r0 == null) goto L18;
        monitor-enter(r0);     // Catch: Throwable -> L20
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L7:
        if (d.c.i.l.e.q0(r0) == true) goto L12;
        this.f15986a.remove(r7);     // Catch: Throwable -> L15
        d.c.c.e.a.A(f15985b, "Found closed reference %d for key %s (%d)", new Object[]{Integer.valueOf(System.identityHashCode(r0)), r7.a(), Integer.valueOf(System.identityHashCode(r7))});     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        monitor-exit(this);
        return null;
    L12:
        d.c.i.l.e r8 = d.c.i.l.e.b(r0);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        r0 = r8;
    L18:
        monitor-exit(this);
        return r0;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized void d(d.c.b.a.d r2, d.c.i.l.e r3) {
        monitor-enter(this);
        d.c.c.d.i.g(r2);     // Catch: Throwable -> L6
        d.c.c.d.i.b(d.c.i.l.e.q0(r3));     // Catch: Throwable -> L6
        d.c.i.l.e.g(this.f15986a.put(r2, d.c.i.l.e.b(r3)));     // Catch: Throwable -> L6
        c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean e(d.c.b.a.d r2) {
        d.c.c.d.i.g(r2);
        monitor-enter(this);
        d.c.i.l.e r3 = this.f15986a.remove(r2);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r3 != null) goto L18;
        return false;
    L18:
        boolean r1 = r3.p0();     // Catch: Throwable -> L12
        r3.close();
        return r1;
    L12:
        th = move-exception;
        r3.close();
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized boolean f(d.c.b.a.d r6, d.c.i.l.e r7) {
        monitor-enter(this);
        d.c.c.d.i.g(r6);     // Catch: Throwable -> L25
        d.c.c.d.i.g(r7);     // Catch: Throwable -> L25
        d.c.c.d.i.b(d.c.i.l.e.q0(r7));     // Catch: Throwable -> L25
        d.c.i.l.e r0 = this.f15986a.get(r6);     // Catch: Throwable -> L25
        if (r0 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        d.c.c.h.a<d.c.c.g.h> r2 = r0.s();     // Catch: Throwable -> L25
        d.c.c.h.a<d.c.c.g.h> r8 = r7.s();     // Catch: Throwable -> L25
        if (r2 == null) goto L22;
        if (r8 == null) goto L22;
    L19:
        th = move-exception;
        d.c.c.h.a.L(r8);     // Catch: Throwable -> L25
        d.c.c.h.a.L(r2);     // Catch: Throwable -> L25
        d.c.i.l.e.g(r0);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L12:
        if (r2.N() != r8.N()) goto L22;
        this.f15986a.remove(r6);     // Catch: Throwable -> L19
        d.c.c.h.a.L(r8);     // Catch: Throwable -> L25
        d.c.c.h.a.L(r2);     // Catch: Throwable -> L25
        d.c.i.l.e.g(r0);     // Catch: Throwable -> L25
        c();     // Catch: Throwable -> L25
        monitor-exit(this);
        return true;
    L22:
        d.c.c.h.a.L(r8);     // Catch: Throwable -> L25
        d.c.c.h.a.L(r2);     // Catch: Throwable -> L25
        d.c.i.l.e.g(r0);     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L25:
        th = move-exception;
        throw th;
    }
}
