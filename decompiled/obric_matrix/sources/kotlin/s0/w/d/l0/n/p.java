package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends r implements n, kotlin.s0.w.d.l0.n.w1.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f21058i = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f21059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f21060h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        private final boolean a(q1 r1) {
            if ((r1.O0() instanceof kotlin.s0.w.d.l0.n.t1.n) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r1.O0().d() instanceof kotlin.s0.w.d.l0.c.f1) == true) goto L12;
            if ((r1 instanceof kotlin.s0.w.d.l0.n.t1.i) == true) goto L12;
            if ((r1 instanceof u0) == true) goto L12;
            return false;
        }

        public static /* synthetic */ p c(a r0, q1 r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.b(r1, r2);
        }

        private final boolean d(q1 r3, boolean r4) {
            boolean r0 = false;
            if (a(r3) == true) goto L6;
            return false;
        L6:
            if ((r3 instanceof u0) == true) goto L8;
            kotlin.s0.w.d.l0.c.h r2 = r3.O0().d();
            if ((r2 instanceof kotlin.s0.w.d.l0.c.q1.k0) == false) goto L12;
            kotlin.s0.w.d.l0.c.q1.k0 r5 = (kotlin.s0.w.d.l0.c.q1.k0) r2;
        L14:
            if (r5 != null) goto L16;
        L18:
            if (r0 == false) goto L20;
            return true;
        L20:
            if (r4 == false) goto L26;
            if ((r3.O0().d() instanceof kotlin.s0.w.d.l0.c.f1) == false) goto L26;
            return n1.l(r3);
        L26:
            return !kotlin.s0.w.d.l0.n.t1.o.f21105a.a(r3);
        L16:
            if (r5.U0() == true) goto L18;
            r0 = true;
            goto L18
        L12:
            r5 = null;
            goto L14
        L8:
            return n1.l(r3);
        }

        public final p b(q1 r3, boolean r4) {
            kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
            kotlin.n0.d.g r1 = null;
            if ((r3 instanceof p) == false) goto L6;
            return (p) r3;
        L6:
            if (d(r3, r4) == true) goto L8;
            return null;
        L8:
            if ((r3 instanceof y) == false) goto L11;
            y r2 = (y) r3;
            kotlin.n0.d.o.a(r2.W0().O0(), r2.X0().O0());
        L11:
            return new p(b0.c(r3).V0(false), r4, r1);
        }
    }

    static {
        f21058i = new a(null);
    }

    private p(m0 r1, boolean r2) {
        this.f21059g = r1;
        this.f21060h = r2;
    }

    public /* synthetic */ p(m0 r1, boolean r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.n.n
    public boolean A0() {
        if ((X0().O0() instanceof kotlin.s0.w.d.l0.n.t1.n) == false) goto L5;
    L8:
        return true;
    L5:
        if ((X0().O0().d() instanceof kotlin.s0.w.d.l0.c.f1) == true) goto L8;
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.n
    public e0 J(e0 r2) {
        kotlin.n0.d.o.f(r2, "replacement");
        return q0.e(r2.R0(), this.f21060h);
    }

    @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 V0(boolean r1) {
        if (r1 == true) goto L4;
        return this;
    L4:
        return X0().V0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r3) {
        kotlin.n0.d.o.f(r3, "newAttributes");
        return new p(X0().W0(r3), this.f21060h);
    }

    @Override // kotlin.s0.w.d.l0.n.r
    protected m0 X0() {
        return this.f21059g;
    }

    @Override // kotlin.s0.w.d.l0.n.r
    public /* bridge */ /* synthetic */ r Z0(m0 r1) {
        return b1(r1);
    }

    public final m0 a1() {
        return this.f21059g;
    }

    public p b1(m0 r2) {
        kotlin.n0.d.o.f(r2, "delegate");
        return new p(r2, this.f21060h);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public String toString() {
        return X0() + " & Any";
    }
}
