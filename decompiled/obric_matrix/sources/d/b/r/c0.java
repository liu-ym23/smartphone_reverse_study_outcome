package d.b.r;

import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes.dex */
public class c0<T> implements d.b.r.b<T>, n {
    private static d.b.r.l0.b m;
    private static b n;
    private static c o;
    private static d p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.b.r.h0.c f14331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u<T> f14332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object[] f14333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d.b.r.h0.c f14334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.b.r.d f14335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final y f14336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f14337l;

    class a implements e0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f14338f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f14339g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f14340h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c0 f14341i;

        a(c0 r1, y r2, k r3, e r4) {
            this.f14341i = r1;
            this.f14338f = r2;
            this.f14339g = r3;
            this.f14340h = r4;
        }

        private void a(Throwable r2) {
            this.f14340h.b(this.f14341i, r2);     // Catch: Throwable -> L4
            return;
        }

        private void b(d0<T> r3) {
            this.f14340h.a(this.f14341i, r3);     // Catch: Throwable -> L6
            k r0 = this.f14339g;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.d(this.f14341i, r3);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // d.b.r.e0
        public y E() {
            return this.f14341i.r();
        }

        @Override // d.b.r.e0
        public int F() {
            return 0;
        }

        @Override // d.b.r.e0
        public int O() {
            if (c0.m() != null) goto L5;
        L8:
            d.b.r.h0.c r0 = c0.a(this.f14341i);
            c0 r2 = this.f14341i;
            if (r0 == null) goto L13;
            return c0.a(r2).B();
        L13:
            return c0.f(r2).f14565e;
        L5:
            if (c0.a(this.f14341i) == null) goto L8;
            return c0.m().a(c0.a(this.f14341i).A(), c0.f(this.f14341i).f14565e);
        }

        @Override // d.b.r.e0
        public boolean V() {
            return c0.f(this.f14341i).f14568h;
        }

        @Override // java.lang.Runnable
        public void run() {
        L14:
            th = move-exception;
            y r2 = this.f14338f;     // Catch: Throwable -> L20
            r2.p0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
            a(th);     // Catch: Throwable -> L20
            y r3 = this.f14338f;     // Catch: Throwable -> L20
            r3.q0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
            c0.h(this.f14341i, th, true);     // Catch: Throwable -> L20
            if (c0.i() == null) goto L30;
            c0.i().c(c0.j(this.f14341i));
            return;
        L30:
            return;
        L20:
            th = move-exception;
            if (c0.i() == null) goto L24;
            c0.i().c(c0.j(this.f14341i));
        L24:
            throw th;
        L4:
            if (c0.a(this.f14341i) != null) goto L6;
            y r1 = this.f14338f;     // Catch: Throwable -> L14
            r1.K = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
            c0 r4 = this.f14341i;     // Catch: Throwable -> L14
            c0.d(r4, c0.f(r4).d(this.f14339g, c0.e(this.f14341i)));     // Catch: Throwable -> L14
            y r5 = this.f14338f;     // Catch: Throwable -> L14
            r5.L = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        L6:
            d0 r6 = this.f14341i.q();     // Catch: Throwable -> L14
            if (c0.i() == null) goto L10;
            c0.i().c(c0.j(this.f14341i));
        L10:
            y r7 = this.f14338f;
            r7.p0 = SystemClock.uptimeMillis();
            b(r6);
            y r8 = this.f14338f;
            r8.q0 = SystemClock.uptimeMillis();
            if (V() == true) goto L29;
            c0.k(this.f14341i, r6, true);
            return;
        }
    }

    public interface b {
        boolean a();

        void b(long r1, long r3, String r5, String r6, Object r7);

        void c(long r1, long r3, String r5, String r6, Object r7, Throwable r8);
    }

    public interface c {
        int a(String r1, int r2);
    }

    public interface d {
        boolean a(d.b.r.h0.c r1);

        d.b.r.h0.c b(d.b.r.h0.c r1);
    }

    c0(u<T> r2, Object[] r3) {
        this.f14331f = null;
        this.f14332g = r2;
        this.f14333h = r3;
        this.f14335j = new d.b.r.d(r2);
        this.f14336k = r2.a().a();
    }

    static /* synthetic */ d.b.r.h0.c a(c0 r0) {
        return r0.f14334i;
    }

    static /* synthetic */ d.b.r.h0.c d(c0 r0, d.b.r.h0.c r1) {
        r0.f14334i = r1;
        return r1;
    }

    static /* synthetic */ Object[] e(c0 r0) {
        return r0.f14333h;
    }

    static /* synthetic */ u f(c0 r0) {
        return r0.f14332g;
    }

    static /* synthetic */ void h(c0 r0, Throwable r1, boolean r2) {
        r0.t(r1, r2);
    }

    static /* synthetic */ d.b.r.l0.b i() {
        return m;
    }

    static /* synthetic */ d.b.r.h0.c j(c0 r0) {
        return r0.f14331f;
    }

    static /* synthetic */ void k(c0 r0, d0 r1, boolean r2) {
        r0.u(r1, r2);
    }

    static /* synthetic */ c m() {
        return o;
    }

    private d.b.r.h0.c n(d.b.r.h0.c r5, y r6) {
        if (r6.E < 0) goto L6;
        d.b.r.h0.c.a r4 = r5.O();
        ArrayList r0 = new ArrayList();
        r0.addAll(r5.v());
        r0.add(new d.b.r.h0.b("state-delay", String.valueOf(r6.E)));
        r4.b(r0);
        return r4.a();
    L6:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(Throwable r14, boolean r15) {
        if (n != null) goto L5;
        return;
    L5:
        if (r15 == false) goto L7;
        long r0 = this.f14336k.w;
    L8:
        long r1 = SystemClock.uptimeMillis() - r0;
        if ((r14 instanceof d.b.r.l0.d) == false) goto L18;
        d.b.r.l0.d r16 = (d.b.r.l0.d) r14;
        if (r16.f14469f == true) goto L13;
        return;
    L13:
        if (r16.f14470g == false) goto L16;
        n.b(r1, this.f14337l, r16.f14472i, r16.f14473j, r16.f14474k);
    L16:
        if (r16.f14471h == false) goto L32;
        n.c(r1, this.f14337l, r16.f14472i, r16.f14473j, r16.f14474k, r14);
        return;
    L32:
        return;
    L18:
        y r17 = this.f14336k;
        if (r17.Q == false) goto L23;
        r17.R = r14;
        Throwable r18 = null;
    L21:
        o(false, r18, false);
        return;
    L23:
        if ((r14 instanceof d.b.r.l0.a) == false) goto L28;
        boolean r19 = ((d.b.r.l0.a) r14).a();
        r18 = r14;
        if (r19 == true) goto L21;
        return;
    L28:
        if (n.a() == false) goto L36;
        o(false, r14, true);
        return;
    L36:
        return;
    L7:
        r0 = this.f14336k.y;
        goto L8
    }

    private void u(d0<T> r13, boolean r14) {
        Logger.debug();
        if (n != null) goto L5;
        return;
    L5:
        if (g() == true) goto L12;
        if (r14 == false) goto L8;
        long r0 = this.f14336k.w;
    L9:
        long r5 = SystemClock.uptimeMillis() - r0;
        n.b(r5, this.f14337l, r13.g().g(), r13.g().f(), r13.g().b());
        return;
    L8:
        r0 = this.f14336k.y;
        goto L9
    }

    public static void v(b r0) {
        n = r0;
    }

    public static void w(d r0) {
        p = r0;
    }

    public static void y(d.b.r.l0.b r0) {
        m = r0;
    }

    private boolean z(d.b.r.h0.c r3) {
        if (r3.L() == false) goto L5;
        return false;
    L5:
        d r2 = p;
        if (r2 == null) goto L10;
        if (r2.a(r3) == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // d.b.r.b
    public /* bridge */ /* synthetic */ d.b.r.b A() {
        return p();
    }

    @Override // d.b.r.b
    public d.b.r.h0.c b() {
        d.b.r.d r0 = this.f14335j;
        if (r0 == null) goto L8;
        d.b.r.h0.c r1 = r0.j();
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (this.f14334i != null) goto L17;
        y r2 = this.f14336k;     // Catch: IOException -> L11 RuntimeException -> L14
        r2.K = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L14
        this.f14334i = this.f14332g.d(null, this.f14333h);     // Catch: IOException -> L11 RuntimeException -> L14
        r2.L = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L14
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);
    L14:
        e = move-exception;
        throw e;
    L17:
        return this.f14334i;
    }

    @Override // d.b.r.n
    public void c() {
        d.b.r.d r0 = this.f14335j;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // d.b.r.b
    public void cancel() {
        d.b.r.d r0 = this.f14335j;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return p();
    }

    @Override // d.b.r.b
    public d0<T> execute() {
        y r0 = this.f14336k;
        r0.y = SystemClock.uptimeMillis();
        r0.z = System.nanoTime();
        this.f14337l = System.currentTimeMillis();
        r0.K = SystemClock.uptimeMillis();
        this.f14334i = this.f14332g.d(null, this.f14333h);     // Catch: Exception -> L23
        r0.L = SystemClock.uptimeMillis();
        Logger.debug();
        d.b.r.l0.b r2 = m;     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        d.b.r.h0.c r3 = r2.d(this.f14334i);     // Catch: Throwable -> L15
        this.f14334i = r3;     // Catch: Throwable -> L15
        this.f14331f = r3;     // Catch: Throwable -> L15
        m.a(r3, r0);     // Catch: Throwable -> L15
    L8:
        d0<T> r4 = q();     // Catch: Throwable -> L15
        r0.r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        if (this.f14332g.f14568h == true) goto L11;
        u(r4, false);     // Catch: Throwable -> L15
    L11:
        d.b.r.l0.b r1 = m;
        if (r1 == null) goto L14;
        r1.c(this.f14331f);
    L14:
        return r4;
    L15:
        th = move-exception;
        r0.r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L18
        t(th, false);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        d.b.r.l0.b r5 = m;
        if (r5 == null) goto L22;
        r5.c(this.f14331f);
    L22:
        throw th;
    L23:
        e = move-exception;
        throw e;
    }

    @Override // d.b.r.b
    public boolean g() {
        d.b.r.d r0 = this.f14335j;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.g() == false) goto L7;
        return true;
    }

    @Override // d.b.r.b
    public void l(e<T> r7) {
        y r0 = this.f14336k;
        r0.w = SystemClock.uptimeMillis();
        r0.x = System.nanoTime();
        this.f14337l = System.currentTimeMillis();
        Objects.requireNonNull(r7, "callback == null");
        d.b.r.d r1 = this.f14335j;
        if (r1 != null) goto L5;
    L9:
        Executor r2 = this.f14332g.f14564d;
        if ((r7 instanceof k) == false) goto L12;
        k r3 = (k) r7;
    L13:
        a r4 = new a(this, r0, r3, r7);
        r0.K = SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        this.f14334i = this.f14332g.d(r3, this.f14333h);     // Catch: Throwable -> L21
        Logger.debug();     // Catch: Throwable -> L21
        r0.L = SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        d.b.r.l0.b r5 = m;     // Catch: Throwable -> L21
        if (r5 == null) goto L19;
        d.b.r.h0.c r6 = r5.d(this.f14334i);     // Catch: Throwable -> L21
        this.f14334i = r6;     // Catch: Throwable -> L21
        this.f14331f = r6;     // Catch: Throwable -> L21
        if (m.b(r6, r0, r2, r4) == false) goto L19;
        return;
    L19:
        r2.execute(r4);
        return;
    L21:
        th = move-exception;
        r7.b(this, th);
        t(th, true);
        d.b.r.l0.b r8 = m;
        if (r8 == null) goto L28;
        r8.c(this.f14331f);
        return;
    L28:
        return;
    L12:
        r3 = null;
        goto L13
    L5:
        if (r1.h() == false) goto L9;
        throw new IllegalStateException("Already executed.");
    }

    public void o(boolean r1, Throwable r2, boolean r3) {
        d.b.r.d r0 = this.f14335j;
        if (r0 == null) goto L6;
        r0.d(r1, r2, r3);
        return;
    }

    public c0<T> p() {
        return new c0(this.f14332g, this.f14333h);
    }

    d0 q() {
        y r6 = this.f14336k;
        r6.f14613J = SystemClock.uptimeMillis();
        Logger.debug();
        LinkedList r1 = new LinkedList();
        d r0 = p;
        if (r0 == null) goto L6;
        this.f14334i = r0.b(this.f14334i);
    L6:
        if (z(this.f14334i) == false) goto L8;
        r1.addAll(this.f14332g.f14563c);
    L8:
        r1.add(this.f14335j);
        if (Logger.debug() == false) goto L11;
        this.f14334i = n(this.f14334i, r6);
    L11:
        r6.p = this.f14337l;
        r6.q = System.currentTimeMillis();
        this.f14334i.S(r6);
        d.b.r.j0.b r7 = new d.b.r.j0.b(r1, 0, this.f14334i, this, r6);
        boolean r2 = d.b.r.j0.b.e();
        d.b.r.h0.c r8 = this.f14334i;
        if (r2 == false) goto L14;
        d0 r9 = r7.d(r8);
    L15:
        r9.h(r6);
        return r9;
    L14:
        r9 = r7.c(r8);
        goto L15
    }

    public y r() {
        return this.f14336k;
    }
}
