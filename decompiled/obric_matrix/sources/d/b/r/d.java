package d.b.r;

import android.os.SystemClock;
import java.io.IOException;
import java.util.List;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes.dex */
public class d<T> implements d.b.r.j0.a, n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u<T> f14342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile d.b.r.h0.e f14343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.b.r.h0.c f14344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f14345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Throwable f14346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f14347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f14348l;

    public d(u<T> r1) {
        this.f14342f = r1;
    }

    private d.b.r.h0.e e(d.b.r.h0.c r1) {
        return this.f14342f.f14562b.get().a(r1);
    }

    private d.b.r.h0.d f(d.b.r.h0.e r3, y r4) {
        if (r4 == null) goto L5;
        r4.M = SystemClock.uptimeMillis();
    L5:
        return r3.execute();
    }

    @Override // d.b.r.j0.a
    public d0 a(d.b.r.j0.a.InterfaceC0391a r10) {
        y r0 = r10.a();
        if (r0 == null) goto L5;
        r0.r = System.currentTimeMillis();
    L5:
        long r1 = SystemClock.uptimeMillis();
        d.b.r.h0.c r11 = r10.b();
        this.f14344h = r11;
        if (r0 == null) goto L8;
        r0.s0 = r11.B();
        r0.t0 = this.f14344h.E();
    L8:
        monitor-enter(this);
    L75:
        th = move-exception;
        throw th;
    L10:
        if (this.f14347k == true) goto L74;
        this.f14347k = true;     // Catch: Throwable -> L75
        monitor-exit(this);     // Catch: Throwable -> L75
        Throwable r3 = this.f14346j;
        if (r3 != null) goto L16;
        d.b.r.h0.c r4 = this.f14344h;
        if (r4 == null) goto L24;
        r4.S(r0);
    L24:
        d.b.r.h0.d r5 = null;
        if (this.f14342f.n == null) goto L30;
        if (r0 == null) goto L28;
        r0.S.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1));
    L28:
        r5 = this.f14342f.n.b(this.f14344h);
    L30:
        if (r5 == null) goto L79;
    L64:
        if (r0 == null) goto L69;
        List<d.b.r.h0.b> r12 = r5.h("content-encoding");
        if (r12 == null) goto L68;
        r0.u0 = r12.get(0).b();
    L68:
        r0.j(this);
    L69:
        long r2 = SystemClock.uptimeMillis();
        d0<T> r9 = i(r5, r0);
        if (r0 == null) goto L72;
        r0.T.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r2));
    L72:
        return r9;
    L79:
        this.f14343g = e(this.f14344h);     // Catch: Throwable -> L54 Throwable -> L61
        if (this.f14348l <= 0) goto L37;
        long r6 = SystemClock.uptimeMillis();     // Catch: Throwable -> L54 Throwable -> L61
        this.f14343g.d(this.f14348l);     // Catch: Throwable -> L54 Throwable -> L61
        if (r0 == null) goto L37;
        r0.z0 = SystemClock.uptimeMillis() - r6;     // Catch: Throwable -> L54 Throwable -> L61
    L37:
        if (this.f14345i == false) goto L39;
        this.f14343g.cancel();
    L39:
        if (r0 == null) goto L46;
        r0.S.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1));
        List<d.b.r.h0.b> r7 = this.f14344h.H("content-encoding");
        if (r7 != null) goto L43;
    L45:
        r0.g();
        goto L46
    L43:
        if (r7.size() <= 0) goto L45;
        r0.v0 = this.f14344h.H("content-encoding").get(0).b();
    L46:
        r5 = f(this.f14343g, r0);
        if (r0 == null) goto L49;
        r0.Q = true;
    L49:
        d.b.r.g0.a r13 = this.f14342f.n;
        if (r13 == null) goto L64;
        d.b.r.h0.d r14 = r13.a(this.f14344h, r5);
        if (r14 == null) goto L64;
        r5 = r14;
    L61:
        e = move-exception;
        this.f14346j = e;
        throw e;
    L54:
        th = move-exception;
        this.f14346j = th;
        if ((th instanceof Exception) == false) goto L60;
        throw th;
    L60:
        throw new Exception(th);
    L16:
        if ((r3 instanceof IOException) == false) goto L20;
        throw ((IOException) r3);
    L20:
        throw new Exception(this.f14346j);
    L74:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L75
    }

    public void b() {
        this.f14345i = true;
        if (this.f14343g == null) goto L6;
        this.f14343g.cancel();
        return;
    }

    @Override // d.b.r.n
    public void c() {
        if ((this.f14343g instanceof n) == false) goto L6;
        ((n) this.f14343g).c();
        return;
    }

    public void d(boolean r1, Throwable r2, boolean r3) {
        this.f14345i = r1;
        if (this.f14343g != null) goto L5;
        return;
    L5:
        if ((this.f14343g instanceof d.b.r.l0.c) == false) goto L9;
        ((d.b.r.l0.c) this.f14343g).a(r2, r3);
        return;
    }

    public boolean g() {
        return this.f14345i;
    }

    public synchronized boolean h() {
        monitor-enter(this);
        boolean r0 = this.f14347k;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    d0<T> i(d.b.r.h0.d r4, y r5) {
        if (r4 == null) goto L29;
        d.b.r.k0.i r0 = r4.a();
        int r1 = r4.e();
        if (r1 < 200) goto L27;
        if (r1 >= 300) goto L27;
        if (r1 == 204) goto L25;
        if (r1 == 205) goto L25;
        if (r5 != null) goto L30;
    L15:
        T r3 = this.f14342f.e(r0);     // Catch: Throwable -> L20
        if (r5 == null) goto L18;
        r5.P = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
    L18:
        return d0.i(r3, r4);
    L20:
        th = move-exception;
        if (r5 == null) goto L23;
        r5.o0 = false;
    L23:
        throw th;
    L30:
        r5.O = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
    L25:
        return d0.i(null, r4);
    L27:
        return d0.c(r0, r4);
    L29:
        throw new IOException("SsResponse is null");
    }

    public d.b.r.h0.c j() {
        return this.f14344h;
    }

    public synchronized void k() {
        monitor-enter(this);
        this.f14347k = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
