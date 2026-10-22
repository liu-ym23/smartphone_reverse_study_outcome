package p000j.k0.f;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import p000j.a0;
import p000j.e;
import p000j.h0;
import p000j.k;
import p000j.k0.g.c;
import p000j.k0.i.b;
import p000j.k0.i.n;
import p000j.l0.f;
import p000j.s;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p000j.a f17858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f.a f17859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h0 f17860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f17861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f17862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f17863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f17864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f17865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f17867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f17868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17869l;
    private boolean m;
    private int n;
    private c o;

    public static final class a extends WeakReference<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f17870a;

        a(g r1, Object r2) {
            super(r1);
            this.f17870a = r2;
        }
    }

    static {
    }

    public g(k r2, p000j.a r3, e r4, s r5, Object r6) {
        this.n = f.f18161a;
        this.f17861d = r2;
        this.f17858a = r3;
        this.f17862e = r4;
        this.f17863f = r5;
        this.f17865h = new f(r3, q(), r4, r5);
        this.f17864g = r6;
    }

    private Socket e(boolean r2, boolean r3, boolean r4) {
        if (r4 == false) goto L6;
        this.o = null;
    L6:
        if (r3 == false) goto L8;
        this.f17869l = true;
    L8:
        c r5 = this.f17867j;
        if (r5 == null) goto L26;
        if (r2 == false) goto L13;
        r5.f17839k = true;
    L13:
        if (this.o == null) goto L15;
        return null;
    L15:
        if (this.f17869l == false) goto L17;
    L18:
        l(r5);
        if (this.f17867j.n.isEmpty() == false) goto L23;
        this.f17867j.o = System.nanoTime();
        if (p000j.k0.a.f17790a.e(this.f17861d, this.f17867j) == false) goto L23;
        Socket r6 = this.f17867j.b();
    L24:
        this.f17867j = null;
        return r6;
    L23:
        r6 = null;
        goto L24
    L17:
        if (r5.f17839k == true) goto L18;
        return null;
    L26:
        return null;
    }

    private c f(int r19, int r20, int r21, int r22, boolean r23) {
        k r1 = this.f17861d;
        monitor-enter(r1);
    L102:
        th = move-exception;
        throw th;
    L5:
        if (this.f17869l == true) goto L101;
        if (this.o != null) goto L99;
        if (this.m == true) goto L97;
        c r2 = this.f17867j;     // Catch: Throwable -> L102
        Socket r3 = n();     // Catch: Throwable -> L102
        c r4 = this.f17867j;     // Catch: Throwable -> L102
        Socket r5 = null;
        if (r4 == null) goto L13;
        r2 = null;
    L15:
        if (this.f17868k == true) goto L18;
        r2 = null;
    L18:
        if (r4 != null) goto L23;
        p000j.k0.a.f17790a.h(this.f17861d, this.f17858a, this, null);     // Catch: Throwable -> L102
        c r8 = this.f17867j;     // Catch: Throwable -> L102
        if (r8 == null) goto L22;
        boolean r9 = true;
        r4 = r8;
        h0 r10 = null;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L102
        p000j.k0.c.h(r3);
        if (r2 == null) goto L29;
        this.f17863f.j(this.f17862e, r2);
    L29:
        if (r9 == false) goto L31;
        this.f17863f.i(this.f17862e, r4);
    L31:
        if (r4 == null) goto L34;
        this.f17860c = this.f17867j.a();
        return r4;
    L34:
        if (r10 != null) goto L45;
        f.a r6 = this.f17859b;
        if (r6 != null) goto L38;
    L39:
        this.f17859b = this.f17865h.e();
        if (p000j.l0.a.j().e() > 0) goto L42;
    L43:
        this.f17859b.e(false);
    L44:
        boolean r7 = true;
    L46:
        k r11 = this.f17861d;
        monitor-enter(r11);
    L93:
        th = move-exception;
        throw th;
    L49:
        if (this.m == true) goto L92;
        if (r7 == false) goto L57;
        List<h0> r12 = this.f17859b.a();     // Catch: Throwable -> L93
        int r13 = r12.size();     // Catch: Throwable -> L93
        int r14 = 0;
    L52:
        if (r14 >= r13) goto L57;
        h0 r15 = r12.get(r14);     // Catch: Throwable -> L93
        p000j.k0.a.f17790a.h(this.f17861d, this.f17858a, this, r15);     // Catch: Throwable -> L93
        c r16 = this.f17867j;     // Catch: Throwable -> L93
        if (r16 != null) goto L55;
        r14 = r14 + 1;     // Catch: Throwable -> L93
        goto L52
    L55:
        this.f17860c = r15;     // Catch: Throwable -> L93
        r9 = true;
        r4 = r16;
    L57:
        if (r9 == true) goto L61;
        if (r10 != null) goto L60;
        r10 = this.f17859b.d();     // Catch: Throwable -> L93
    L60:
        this.f17860c = r10;     // Catch: Throwable -> L93
        this.f17866i = 0;     // Catch: Throwable -> L93
        r4 = new c(this.f17861d, r10);     // Catch: Throwable -> L93
        a(r4, false);     // Catch: Throwable -> L93
    L61:
        monitor-exit(r11);     // Catch: Throwable -> L93
        if (r9 == false) goto L65;
        this.f17863f.i(this.f17862e, r4);
        return r4;
    L65:
        f.a r17 = this.f17859b;
        if (r17 != null) goto L68;
    L70:
        int r18 = r19;
    L72:
        if (this.f17859b == null) goto L74;
    L80:
        r4.f(r18, r20, r21, r22, r23, this.f17862e, this.f17863f);
        q().a(r4.a());
        k r24 = this.f17861d;
        monitor-enter(r24);
        this.f17868k = true;     // Catch: Throwable -> L88
        p000j.k0.a.f17790a.j(this.f17861d, r4);     // Catch: Throwable -> L88
        if (r4.p() == false) goto L85;
        r5 = p000j.k0.a.f17790a.f(this.f17861d, this.f17858a, this);     // Catch: Throwable -> L88
        r4 = this.f17867j;     // Catch: Throwable -> L88
    L85:
        monitor-exit(r24);     // Catch: Throwable -> L88
        p000j.k0.c.h(r5);
        this.f17863f.i(this.f17862e, r4);
        return r4;
    L88:
        th = move-exception;
        throw th;
    L74:
        if (this.f17860c == null) goto L80;
        if (p000j.l0.a.j().l() == false) goto L80;
        if (p000j.l0.a.j().e() <= 0) goto L80;
        r18 = p000j.l0.a.j().e();
        goto L80
    L68:
        if (r17.c() == false) goto L70;
        r18 = p000j.l0.a.j().e();
        goto L72
    L92:
        throw new IOException("Canceled#Reason=" + this.n);     // Catch: Throwable -> L93
    L42:
        if (p000j.l0.a.j().l() == true) goto L44;
    L38:
        if (r6.b() == false) goto L39;
    L45:
        r7 = false;
        goto L46
    L22:
        r10 = this.f17860c;     // Catch: Throwable -> L102
    L24:
        r9 = false;
        goto L25
    L23:
        r10 = null;
        goto L24
    L13:
        r4 = null;
        goto L15
    L97:
        throw new IOException("Canceled#Reason=" + this.n);     // Catch: Throwable -> L102
    L99:
        throw new IllegalStateException("codec != null");     // Catch: Throwable -> L102
    L101:
        throw new IllegalStateException("released");     // Catch: Throwable -> L102
    }

    private c g(int r4, int r5, int r6, int r7, boolean r8, boolean r9) {
    L2:
        c r0 = f(r4, r5, r6, r7, r8);
        k r1 = this.f17861d;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r0.f17840l == 0) goto L7;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (r0.o(r9) == true) goto L14;
        j();
        goto L2
    L14:
        return r0;
    L7:
        if (r0.p() == true) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L15
        return r0;
    }

    private void l(c r4) {
        int r0 = r4.n.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        if (r4.n.get(r1).get() == this) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        r4.n.remove(r1);
        return;
    L10:
        throw new IllegalStateException();
    }

    private Socket n() {
        c r0 = this.f17867j;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.f17839k == true) goto L7;
        return null;
    L7:
        return e(false, false, true);
    }

    private d q() {
        return p000j.k0.a.f17790a.k(this.f17861d);
    }

    public void a(c r2, boolean r3) {
        if (this.f17867j != null) goto L7;
        this.f17867j = r2;
        this.f17868k = r3;
        r2.n.add(new a(this, this.f17864g));
        return;
    L7:
        throw new IllegalStateException();
    }

    public void b(int r3) {
        k r0 = this.f17861d;
        monitor-enter(r0);
        this.m = true;     // Catch: Throwable -> L12
        this.n = r3;     // Catch: Throwable -> L12
        c r4 = this.o;     // Catch: Throwable -> L12
        c r2 = this.f17867j;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        r4.cancel();
        return;
    L9:
        if (r2 == null) goto L18;
        r2.e();
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public c c() {
        k r0 = this.f17861d;
        monitor-enter(r0);
        c r1 = this.o;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized c d() {
        monitor-enter(this);
        c r0 = this.f17867j;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean h() {
        if (this.f17860c != null) goto L12;
        f.a r0 = this.f17859b;
        if (r0 == null) goto L9;
        if (r0.b() == true) goto L12;
    L9:
        if (this.f17865h.c() == true) goto L12;
        return false;
    L12:
        return true;
    }

    public c i(a0 r8, x.a r9, boolean r10) {
        int r1 = r9.f();
        int r2 = r9.a();
        int r3 = r9.c();
        int r0 = r8.z();
        e r4 = this.f17862e;
        if (r4 == null) goto L23;
        if (r4.b() == null) goto L23;
        if (this.f17862e.b().k() == null) goto L23;
        if (this.f17862e.b().k().m() == null) goto L23;
        r0 = r8.B(this.f17862e.b().k().m(), this.f17862e.b().k().y());
    L23:
        c r11 = g(r1, r2, r3, r0, r8.H(), r10).q(r8, r9, this);     // Catch: IOException -> L20
        k r12 = this.f17861d;     // Catch: IOException -> L20
        monitor-enter(r12);     // Catch: IOException -> L20
        this.o = r11;     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r11;
    L17:
        th = move-exception;
        throw th;     // Catch: IOException -> L20
    L20:
        e = move-exception;
        throw new e(e);
    }

    public void j() {
        k r0 = this.f17861d;
        monitor-enter(r0);
        c r1 = this.f17867j;     // Catch: Throwable -> L12
        Socket r2 = e(true, false, false);     // Catch: Throwable -> L12
        if (this.f17867j == null) goto L7;
        r1 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        p000j.k0.c.h(r2);
        if (r1 == null) goto L17;
        this.f17863f.j(this.f17862e, r1);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void k() {
        k r0 = this.f17861d;
        monitor-enter(r0);
        c r1 = this.f17867j;     // Catch: Throwable -> L12
        Socket r2 = e(false, true, false);     // Catch: Throwable -> L12
        if (this.f17867j == null) goto L7;
        r1 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        p000j.k0.c.h(r2);
        if (r1 == null) goto L17;
        p000j.k0.a.f17790a.m(this.f17862e, null);
        this.f17863f.j(this.f17862e, r1);
        this.f17863f.a(this.f17862e);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public Socket m(c r4) {
        if (this.o != null) goto L9;
        if (this.f17867j.n.size() != 1) goto L9;
        Reference<g> r0 = this.f17867j.n.get(0);
        Socket r1 = e(true, false, false);
        this.f17867j = r4;
        r4.n.add(r0);
        return r1;
    L9:
        throw new IllegalStateException();
    }

    public void o(int r2) {
        this.f17865h.h(r2);
        this.f17859b = null;
    }

    public h0 p() {
        return this.f17860c;
    }

    public void r(IOException r7) {
        k r0 = this.f17861d;
        monitor-enter(r0);
        c r3 = null;
        if ((r7 instanceof n) == false) goto L14;
        b r8 = ((n) r7).f18077f;     // Catch: Throwable -> L39
        if (r8 != b.f17930k) goto L12;
        int r9 = this.f17866i + 1;     // Catch: Throwable -> L39
        this.f17866i = r9;     // Catch: Throwable -> L39
        if (r9 > 1) goto L13;
    L27:
        boolean r10 = false;
    L28:
        c r1 = this.f17867j;     // Catch: Throwable -> L39
        Socket r11 = e(r10, false, true);     // Catch: Throwable -> L39
        if (this.f17867j == null) goto L31;
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L39
        p000j.k0.c.h(r11);
        if (r3 == null) goto L44;
        this.f17863f.j(this.f17862e, r3);
        return;
    L44:
        return;
    L31:
        if (this.f17868k == false) goto L34;
        r3 = r1;
    L13:
        this.f17860c = null;     // Catch: Throwable -> L39
    L26:
        r10 = true;
        goto L28
    L12:
        if (r8 == b.f17931l) goto L27;
    L14:
        c r2 = this.f17867j;     // Catch: Throwable -> L39
        if (r2 == null) goto L27;
        if (r2.p() == false) goto L21;
        if ((r7 instanceof p000j.k0.i.a) == false) goto L27;
    L21:
        if (this.f17867j.f17840l != 0) goto L26;
        h0 r4 = this.f17860c;     // Catch: Throwable -> L39
        if (r4 == null) goto L13;
        if (r7 == null) goto L13;
        this.f17865h.a(r4, r7);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    public void s(boolean r3, c r4, long r5, IOException r7) {
        this.f17863f.s(this.f17862e, r5);
        k r6 = this.f17861d;
        monitor-enter(r6);
        if (r4 == null) goto L24;
    L25:
        th = move-exception;
        throw th;
    L6:
        if (r4 != this.o) goto L24;
        if (r3 == true) goto L10;
        this.f17867j.f17840l++;     // Catch: Throwable -> L25
    L10:
        c r8 = this.f17867j;     // Catch: Throwable -> L25
        Socket r9 = e(r3, false, true);     // Catch: Throwable -> L25
        if (this.f17867j == null) goto L13;
        r8 = null;
    L13:
        boolean r10 = this.f17869l;     // Catch: Throwable -> L25
        monitor-exit(r6);     // Catch: Throwable -> L25
        p000j.k0.c.h(r9);
        if (r8 == null) goto L18;
        this.f17863f.j(this.f17862e, r8);
    L18:
        if (r7 == null) goto L20;
        this.f17863f.b(this.f17862e, p000j.k0.a.f17790a.m(this.f17862e, r7));
        return;
    L20:
        if (r10 == false) goto L30;
        p000j.k0.a.f17790a.m(this.f17862e, null);
        this.f17863f.a(this.f17862e);
        return;
    L30:
        return;
    L24:
        throw new IllegalStateException("expected " + this.o + " but was " + r4);     // Catch: Throwable -> L25
    }

    public String toString() {
        c r0 = d();
        if (r0 == null) goto L6;
        return r0.toString();
    L6:
        return this.f17858a.toString();
    }
}
