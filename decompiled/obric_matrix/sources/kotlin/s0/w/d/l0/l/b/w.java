package kotlin.s0.w.d.l0.l.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f20865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.b.e f20866b;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.o1.c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f20867f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.i.q f20868g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.l.b.b f20869h;

        a(w r1, kotlin.s0.w.d.l0.i.q r2, kotlin.s0.w.d.l0.l.b.b r3) {
            this.f20867f = r1;
            this.f20868g = r2;
            this.f20869h = r3;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.o1.c> a() {
            w r0 = this.f20867f;
            z r1 = w.a(r0, w.b(r0).e());
            if (r1 == null) goto L5;
            w r2 = this.f20867f;
            kotlin.s0.w.d.l0.i.q r3 = this.f20868g;
            kotlin.s0.w.d.l0.l.b.b r4 = this.f20869h;
            List<kotlin.s0.w.d.l0.c.o1.c> r5 = kotlin.i0.r.z0(w.b(r2).c().d().j(r1, r3, r4));
        L6:
            if (r5 == null) goto L8;
            return r5;
        L8:
            return kotlin.i0.r.g();
        L5:
            r5 = null;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.o1.c> invoke() {
            return a();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.o1.c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f20870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f20871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.f.n f20872h;

        b(w r1, boolean r2, kotlin.s0.w.d.l0.f.n r3) {
            this.f20870f = r1;
            this.f20871g = r2;
            this.f20872h = r3;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.o1.c> a() {
            w r0 = this.f20870f;
            z r1 = w.a(r0, w.b(r0).e());
            if (r1 == null) goto L9;
            boolean r2 = this.f20871g;
            w r3 = this.f20870f;
            kotlin.s0.w.d.l0.f.n r4 = this.f20872h;
            if (r2 == false) goto L7;
            List<kotlin.s0.w.d.l0.c.o1.c> r5 = w.b(r3).c().d().i(r1, r4);
        L8:
            List<kotlin.s0.w.d.l0.c.o1.c> r6 = kotlin.i0.r.z0(r5);
        L10:
            if (r6 == null) goto L12;
            return r6;
        L12:
            return kotlin.i0.r.g();
        L7:
            r5 = w.b(r3).c().d().g(r1, r4);
            goto L8
        L9:
            r6 = null;
            goto L10
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.o1.c> invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.o1.c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f20873f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.i.q f20874g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.l.b.b f20875h;

        c(w r1, kotlin.s0.w.d.l0.i.q r2, kotlin.s0.w.d.l0.l.b.b r3) {
            this.f20873f = r1;
            this.f20874g = r2;
            this.f20875h = r3;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.o1.c> a() {
            w r0 = this.f20873f;
            z r1 = w.a(r0, w.b(r0).e());
            if (r1 == null) goto L5;
            w r2 = this.f20873f;
            kotlin.s0.w.d.l0.i.q r3 = this.f20874g;
            kotlin.s0.w.d.l0.l.b.b r4 = this.f20875h;
            List<kotlin.s0.w.d.l0.c.o1.c> r5 = w.b(r2).c().d().h(r1, r3, r4);
        L6:
            if (r5 == null) goto L8;
            return r5;
        L8:
            return kotlin.i0.r.g();
        L5:
            r5 = null;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.o1.c> invoke() {
            return a();
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.m.j<? extends kotlin.s0.w.d.l0.k.r.g<?>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f20876f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.f.n f20877g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.l.b.g0.j f20878h;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.r.g<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ w f20879f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.f.n f20880g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.l.b.g0.j f20881h;

            a(w r1, kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.l.b.g0.j r3) {
                this.f20879f = r1;
                this.f20880g = r2;
                this.f20881h = r3;
                super(0);
            }

            public final kotlin.s0.w.d.l0.k.r.g<?> a() {
                w r0 = this.f20879f;
                z r1 = w.a(r0, w.b(r0).e());
                kotlin.n0.d.o.c(r1);
                kotlin.s0.w.d.l0.l.b.c<kotlin.s0.w.d.l0.c.o1.c, kotlin.s0.w.d.l0.k.r.g<?>> r2 = w.b(this.f20879f).c().d();
                kotlin.s0.w.d.l0.f.n r3 = this.f20880g;
                kotlin.s0.w.d.l0.n.e0 r4 = this.f20881h.getReturnType();
                kotlin.n0.d.o.e(r4, "property.returnType");
                return r2.e(r1, r3, r4);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g<?> invoke() {
                return a();
            }
        }

        d(w r1, kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.l.b.g0.j r3) {
            this.f20876f = r1;
            this.f20877g = r2;
            this.f20878h = r3;
            super(0);
        }

        public final kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>> a() {
            return w.b(this.f20876f).h().f(new a(this.f20876f, this.f20877g, this.f20878h));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.m.j<? extends kotlin.s0.w.d.l0.k.r.g<?>> invoke() {
            return a();
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.m.j<? extends kotlin.s0.w.d.l0.k.r.g<?>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f20882f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.f.n f20883g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.l.b.g0.j f20884h;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.r.g<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ w f20885f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.f.n f20886g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.l.b.g0.j f20887h;

            a(w r1, kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.l.b.g0.j r3) {
                this.f20885f = r1;
                this.f20886g = r2;
                this.f20887h = r3;
                super(0);
            }

            public final kotlin.s0.w.d.l0.k.r.g<?> a() {
                w r0 = this.f20885f;
                z r1 = w.a(r0, w.b(r0).e());
                kotlin.n0.d.o.c(r1);
                kotlin.s0.w.d.l0.l.b.c<kotlin.s0.w.d.l0.c.o1.c, kotlin.s0.w.d.l0.k.r.g<?>> r2 = w.b(this.f20885f).c().d();
                kotlin.s0.w.d.l0.f.n r3 = this.f20886g;
                kotlin.s0.w.d.l0.n.e0 r4 = this.f20887h.getReturnType();
                kotlin.n0.d.o.e(r4, "property.returnType");
                return r2.k(r1, r3, r4);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g<?> invoke() {
                return a();
            }
        }

        e(w r1, kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.l.b.g0.j r3) {
            this.f20882f = r1;
            this.f20883g = r2;
            this.f20884h = r3;
            super(0);
        }

        public final kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>> a() {
            return w.b(this.f20882f).h().f(new a(this.f20882f, this.f20883g, this.f20884h));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.m.j<? extends kotlin.s0.w.d.l0.k.r.g<?>> invoke() {
            return a();
        }
    }

    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.o1.c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f20888f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ z f20889g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.i.q f20890h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.l.b.b f20891i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f20892j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.f.u f20893k;

        f(w r1, z r2, kotlin.s0.w.d.l0.i.q r3, kotlin.s0.w.d.l0.l.b.b r4, int r5, kotlin.s0.w.d.l0.f.u r6) {
            this.f20888f = r1;
            this.f20889g = r2;
            this.f20890h = r3;
            this.f20891i = r4;
            this.f20892j = r5;
            this.f20893k = r6;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.o1.c> a() {
            return kotlin.i0.r.z0(w.b(this.f20888f).c().d().b(this.f20889g, this.f20890h, this.f20891i, this.f20892j, this.f20893k));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.o1.c> invoke() {
            return a();
        }
    }

    public w(m r3) {
        kotlin.n0.d.o.f(r3, "c");
        this.f20865a = r3;
        this.f20866b = new kotlin.s0.w.d.l0.l.b.e(r3.c().p(), r3.c().q());
    }

    public static final /* synthetic */ z a(w r0, kotlin.s0.w.d.l0.c.m r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ m b(w r0) {
        return r0.f20865a;
    }

    private final z c(kotlin.s0.w.d.l0.c.m r4) {
        if ((r4 instanceof l0) == false) goto L6;
        return new z.b(((l0) r4).e(), this.f20865a.g(), this.f20865a.j(), this.f20865a.d());
    L6:
        if ((r4 instanceof kotlin.s0.w.d.l0.l.b.g0.d) == true) goto L11;
        return null;
    L11:
        return ((kotlin.s0.w.d.l0.l.b.g0.d) r4).g1();
    }

    private final kotlin.s0.w.d.l0.c.o1.g d(kotlin.s0.w.d.l0.i.q r3, int r4, kotlin.s0.w.d.l0.l.b.b r5) {
        if (kotlin.s0.w.d.l0.f.z.b.f20232c.g(r4).booleanValue() == true) goto L7;
        return kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
    L7:
        return new kotlin.s0.w.d.l0.l.b.g0.n(this.f20865a.h(), new a(this, r3, r5));
    }

    private final x0 e() {
        kotlin.s0.w.d.l0.c.m r2 = this.f20865a.e();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L5;
        kotlin.s0.w.d.l0.c.e r3 = (kotlin.s0.w.d.l0.c.e) r2;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.K0();
    L5:
        r3 = null;
        goto L6
    }

    private final kotlin.s0.w.d.l0.c.o1.g f(kotlin.s0.w.d.l0.f.n r4, boolean r5) {
        if (kotlin.s0.w.d.l0.f.z.b.f20232c.g(r4.a0()).booleanValue() == true) goto L7;
        return kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
    L7:
        return new kotlin.s0.w.d.l0.l.b.g0.n(this.f20865a.h(), new b(this, r5, r4));
    }

    private final kotlin.s0.w.d.l0.c.o1.g g(kotlin.s0.w.d.l0.i.q r4, kotlin.s0.w.d.l0.l.b.b r5) {
        return new kotlin.s0.w.d.l0.l.b.g0.a(this.f20865a.h(), new c(this, r4, r5));
    }

    private final void h(kotlin.s0.w.d.l0.l.b.g0.k r1, x0 r2, x0 r3, List<? extends x0> r4, List<? extends f1> r5, List<? extends j1> r6, kotlin.s0.w.d.l0.n.e0 r7, kotlin.s0.w.d.l0.c.e0 r8, kotlin.s0.w.d.l0.c.u r9, Map<? extends kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r10) {
        r1.p1(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    private final int k(int r1) {
        return (r1 & 63) + ((r1 >> 8) << 6);
    }

    private final x0 n(kotlin.s0.w.d.l0.f.q r1, m r2, kotlin.s0.w.d.l0.c.a r3) {
        return kotlin.s0.w.d.l0.k.c.b(r3, r2.i().q(r1), kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
    }

    private final List<j1> o(List<kotlin.s0.w.d.l0.f.u> r26, kotlin.s0.w.d.l0.i.q r27, kotlin.s0.w.d.l0.l.b.b r28) {
        kotlin.s0.w.d.l0.c.m r0 = this.f20865a.e();
        kotlin.n0.d.o.d(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        kotlin.s0.w.d.l0.c.a r20 = (kotlin.s0.w.d.l0.c.a) r0;
        kotlin.s0.w.d.l0.c.m r1 = r20.c();
        kotlin.n0.d.o.e(r1, "callableDescriptor.containingDeclaration");
        z r21 = c(r1);
        ArrayList r15 = new ArrayList(kotlin.i0.r.q(r26, 10));
        Iterator<T> r22 = r26.iterator();
        int r11 = 0;
    L4:
        if (r22.hasNext() == false) goto L24;
        Object r2 = r22.next();
        int r24 = r11 + 1;
        if (r11 < 0) goto L21;
        kotlin.s0.w.d.l0.f.u r9 = (kotlin.s0.w.d.l0.f.u) r2;
        if (r9.Q() == false) goto L10;
        int r10 = r9.K();
    L11:
        if (r21 == null) goto L15;
        Boolean r3 = kotlin.s0.w.d.l0.f.z.b.f20232c.g(r10);
        kotlin.n0.d.o.e(r3, "HAS_ANNOTATIONS.get(flags)");
        if (r3.booleanValue() == false) goto L15;
        kotlin.s0.w.d.l0.c.o1.g r12 = new kotlin.s0.w.d.l0.l.b.g0.n(this.f20865a.h(), new f(this, r21, r27, r28, r11, r9));
    L16:
        kotlin.s0.w.d.l0.g.f r13 = x.b(this.f20865a.g(), r9.L());
        kotlin.s0.w.d.l0.n.e0 r14 = this.f20865a.i().q(kotlin.s0.w.d.l0.f.z.f.n(r9, this.f20865a.j()));
        Boolean r4 = kotlin.s0.w.d.l0.f.z.b.G.g(r10);
        kotlin.n0.d.o.e(r4, "DECLARES_DEFAULT_VALUE.get(flags)");
        boolean r5 = r4.booleanValue();
        Boolean r6 = kotlin.s0.w.d.l0.f.z.b.H.g(r10);
        kotlin.n0.d.o.e(r6, "IS_CROSSINLINE.get(flags)");
        boolean r16 = r6.booleanValue();
        Boolean r7 = kotlin.s0.w.d.l0.f.z.b.I.g(r10);
        kotlin.n0.d.o.e(r7, "IS_NOINLINE.get(flags)");
        boolean r17 = r7.booleanValue();
        kotlin.s0.w.d.l0.f.q r8 = kotlin.s0.w.d.l0.f.z.f.q(r9, this.f20865a.j());
        if (r8 == null) goto L19;
        kotlin.s0.w.d.l0.n.e0 r18 = this.f20865a.i().q(r8);
    L20:
        a1 r19 = a1.f18847a;
        kotlin.n0.d.o.e(r19, "NO_SOURCE");
        ArrayList r23 = r15;
        r23.add(new kotlin.s0.w.d.l0.c.q1.l0(r20, null, r11, r12, r13, r14, r5, r16, r17, r18, r19));
        r15 = r23;
        r11 = r24;
        goto L4
    L19:
        r18 = null;
    L15:
        r12 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
        goto L16
    L10:
        r10 = 0;
        goto L11
    L21:
        kotlin.i0.r.p();
        throw null;
    L24:
        return kotlin.i0.r.z0(r15);
    }

    public final kotlin.s0.w.d.l0.c.d i(kotlin.s0.w.d.l0.f.d r21, boolean r22) {
        kotlin.n0.d.o.f(r21, "proto");
        kotlin.s0.w.d.l0.c.m r1 = this.f20865a.e();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.s0.w.d.l0.c.e r16 = (kotlin.s0.w.d.l0.c.e) r1;
        int r2 = r21.J();
        kotlin.s0.w.d.l0.l.b.b r13 = kotlin.s0.w.d.l0.l.b.b.f20695f;
        kotlin.s0.w.d.l0.l.b.g0.c r14 = new kotlin.s0.w.d.l0.l.b.g0.c(r16, null, d(r21, r2, r13), r22, kotlin.s0.w.d.l0.c.b.a.f18848f, r21, this.f20865a.g(), this.f20865a.j(), this.f20865a.k(), this.f20865a.d(), null, 1024, null);
        w r0 = m.b(this.f20865a, r14, kotlin.i0.r.g(), null, null, null, null, 60, null).f();
        List<kotlin.s0.w.d.l0.f.u> r3 = r21.M();
        kotlin.n0.d.o.e(r3, "proto.valueParameterList");
        r14.r1(r0.o(r3, r21, r13), b0.a(a0.f20690a, kotlin.s0.w.d.l0.f.z.b.f20233d.d(r21.J())));
        r14.h1(r16.s());
        r14.X0(r16.L());
        r14.Z0(!kotlin.s0.w.d.l0.f.z.b.n.g(r21.J()).booleanValue());
        return r14;
    }

    public final z0 j(kotlin.s0.w.d.l0.f.i r32) {
        kotlin.n0.d.o.f(r32, "proto");
        if (r32.s0() == false) goto L5;
        int r0 = r32.c0();
    L6:
        int r9 = r0;
        kotlin.s0.w.d.l0.l.b.b r1 = kotlin.s0.w.d.l0.l.b.b.f20695f;
        kotlin.s0.w.d.l0.c.o1.g r15 = d(r32, r9, r1);
        if (kotlin.s0.w.d.l0.f.z.f.d(r32) == false) goto L9;
        kotlin.s0.w.d.l0.c.o1.g r2 = g(r32, r1);
    L11:
        if (kotlin.n0.d.o.a(kotlin.s0.w.d.l0.k.t.a.h(this.f20865a.e()).c(x.b(this.f20865a.g(), r32.d0())), c0.f20702a) == false) goto L13;
        kotlin.s0.w.d.l0.f.z.h r3 = kotlin.s0.w.d.l0.f.z.h.f20249b.b();
    L14:
        kotlin.s0.w.d.l0.l.b.g0.k r8 = new kotlin.s0.w.d.l0.l.b.g0.k(this.f20865a.e(), null, r15, x.b(this.f20865a.g(), r32.d0()), b0.b(a0.f20690a, kotlin.s0.w.d.l0.f.z.b.o.d(r9)), r32, this.f20865a.g(), this.f20865a.j(), r3, this.f20865a.d(), null, 1024, null);
        m r4 = this.f20865a;
        List<kotlin.s0.w.d.l0.f.s> r5 = r32.l0();
        kotlin.n0.d.o.e(r5, "proto.typeParameterList");
        m r12 = m.b(r4, r8, r5, null, null, null, null, 60, null);
        kotlin.s0.w.d.l0.f.q r6 = kotlin.s0.w.d.l0.f.z.f.h(r32, this.f20865a.j());
        if (r6 == null) goto L19;
        kotlin.s0.w.d.l0.n.e0 r7 = r12.i().q(r6);
        if (r7 == null) goto L19;
        x0 r10 = kotlin.s0.w.d.l0.k.c.h(r8, r7, r2);
    L20:
        x0 r11 = r10;
        x0 r13 = e();
        List<kotlin.s0.w.d.l0.f.q> r14 = r32.Y();
        kotlin.n0.d.o.e(r14, "proto.contextReceiverTypeList");
        List<? extends x0> r16 = new ArrayList();
        Iterator<T> r17 = r14.iterator();
    L22:
        if (r17.hasNext() == false) goto L26;
        kotlin.s0.w.d.l0.f.q r18 = (kotlin.s0.w.d.l0.f.q) r17.next();
        kotlin.n0.d.o.e(r18, "it");
        x0 r19 = n(r18, r12, r8);
        if (r19 == null) goto L22;
        r16.add(r19);
        goto L22
    L26:
        List<f1> r20 = r12.i().j();
        w r21 = r12.f();
        List<kotlin.s0.w.d.l0.f.u> r22 = r32.p0();
        kotlin.n0.d.o.e(r22, "proto.valueParameterList");
        List<j1> r23 = r21.o(r22, r32, kotlin.s0.w.d.l0.l.b.b.f20695f);
        kotlin.s0.w.d.l0.n.e0 r24 = r12.i().q(kotlin.s0.w.d.l0.f.z.f.j(r32, this.f20865a.j()));
        a0 r25 = a0.f20690a;
        h(r8, r11, r13, r16, r20, r23, r24, r25.b(kotlin.s0.w.d.l0.f.z.b.f20234e.d(r9)), b0.a(r25, kotlin.s0.w.d.l0.f.z.b.f20233d.d(r9)), m0.h());
        Boolean r26 = kotlin.s0.w.d.l0.f.z.b.p.g(r9);
        kotlin.n0.d.o.e(r26, "IS_OPERATOR.get(flags)");
        r8.g1(r26.booleanValue());
        Boolean r27 = kotlin.s0.w.d.l0.f.z.b.q.g(r9);
        kotlin.n0.d.o.e(r27, "IS_INFIX.get(flags)");
        r8.d1(r27.booleanValue());
        Boolean r28 = kotlin.s0.w.d.l0.f.z.b.t.g(r9);
        kotlin.n0.d.o.e(r28, "IS_EXTERNAL_FUNCTION.get(flags)");
        r8.Y0(r28.booleanValue());
        Boolean r29 = kotlin.s0.w.d.l0.f.z.b.r.g(r9);
        kotlin.n0.d.o.e(r29, "IS_INLINE.get(flags)");
        r8.f1(r29.booleanValue());
        Boolean r30 = kotlin.s0.w.d.l0.f.z.b.s.g(r9);
        kotlin.n0.d.o.e(r30, "IS_TAILREC.get(flags)");
        r8.j1(r30.booleanValue());
        Boolean r31 = kotlin.s0.w.d.l0.f.z.b.u.g(r9);
        kotlin.n0.d.o.e(r31, "IS_SUSPEND.get(flags)");
        r8.i1(r31.booleanValue());
        Boolean r33 = kotlin.s0.w.d.l0.f.z.b.v.g(r9);
        kotlin.n0.d.o.e(r33, "IS_EXPECT_FUNCTION.get(flags)");
        r8.X0(r33.booleanValue());
        r8.Z0(!kotlin.s0.w.d.l0.f.z.b.w.g(r9).booleanValue());
        kotlin.u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object> r34 = this.f20865a.c().h().a(r32, r8, this.f20865a.j(), r12.i());
        if (r34 == null) goto L29;
        r8.V0(r34.c(), r34.d());
    L29:
        return r8;
    L19:
        r10 = null;
        goto L20
    L13:
        r3 = this.f20865a.k();
        goto L14
    L9:
        r2 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
        goto L11
    L5:
        r0 = k(r32.e0());
        goto L6
    }

    public final u0 l(kotlin.s0.w.d.l0.f.n r30) {
        kotlin.n0.d.o.f(r30, "proto");
        if (r30.o0() == false) goto L5;
        int r1 = r30.a0();
    L6:
        int r14 = r1;
        kotlin.s0.w.d.l0.c.m r2 = this.f20865a.e();
        kotlin.s0.w.d.l0.c.o1.g r4 = d(r30, r14, kotlin.s0.w.d.l0.l.b.b.f20696g);
        a0 r9 = a0.f20690a;
        kotlin.s0.w.d.l0.c.e0 r5 = r9.b(kotlin.s0.w.d.l0.f.z.b.f20234e.d(r14));
        kotlin.s0.w.d.l0.c.u r6 = b0.a(r9, kotlin.s0.w.d.l0.f.z.b.f20233d.d(r14));
        Boolean r7 = kotlin.s0.w.d.l0.f.z.b.x.g(r14);
        kotlin.n0.d.o.e(r7, "IS_VAR.get(flags)");
        boolean r8 = r7.booleanValue();
        kotlin.s0.w.d.l0.g.f r10 = x.b(this.f20865a.g(), r30.c0());
        kotlin.s0.w.d.l0.c.b.a r11 = b0.b(r9, kotlin.s0.w.d.l0.f.z.b.o.d(r14));
        Boolean r12 = kotlin.s0.w.d.l0.f.z.b.B.g(r14);
        kotlin.n0.d.o.e(r12, "IS_LATEINIT.get(flags)");
        boolean r13 = r12.booleanValue();
        Boolean r15 = kotlin.s0.w.d.l0.f.z.b.A.g(r14);
        kotlin.n0.d.o.e(r15, "IS_CONST.get(flags)");
        boolean r16 = r15.booleanValue();
        Boolean r17 = kotlin.s0.w.d.l0.f.z.b.D.g(r14);
        kotlin.n0.d.o.e(r17, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean r18 = r17.booleanValue();
        Boolean r3 = kotlin.s0.w.d.l0.f.z.b.E.g(r14);
        kotlin.n0.d.o.e(r3, "IS_DELEGATED.get(flags)");
        boolean r19 = r3.booleanValue();
        Boolean r20 = kotlin.s0.w.d.l0.f.z.b.F.g(r14);
        kotlin.n0.d.o.e(r20, "IS_EXPECT_PROPERTY.get(flags)");
        kotlin.s0.w.d.l0.l.b.g0.j r110 = new kotlin.s0.w.d.l0.l.b.g0.j(r2, null, r4, r5, r6, r8, r10, r11, r13, r16, r18, r19, r20.booleanValue(), r30, this.f20865a.g(), this.f20865a.j(), this.f20865a.k(), this.f20865a.d());
        m r21 = this.f20865a;
        List<kotlin.s0.w.d.l0.f.s> r22 = r30.m0();
        kotlin.n0.d.o.e(r22, "proto.typeParameterList");
        m r111 = m.b(r21, r110, r22, null, null, null, null, 60, null);
        Boolean r23 = kotlin.s0.w.d.l0.f.z.b.y.g(r14);
        kotlin.n0.d.o.e(r23, "HAS_GETTER.get(flags)");
        boolean r24 = r23.booleanValue();
        if (r24 == true) goto L9;
    L11:
        kotlin.s0.w.d.l0.f.n r112 = r30;
        kotlin.s0.w.d.l0.c.o1.g r25 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
    L12:
        kotlin.s0.w.d.l0.n.e0 r26 = r111.i().q(kotlin.s0.w.d.l0.f.z.f.k(r112, this.f20865a.j()));
        List<f1> r27 = r111.i().j();
        x0 r28 = e();
        kotlin.s0.w.d.l0.f.q r29 = kotlin.s0.w.d.l0.f.z.f.i(r112, this.f20865a.j());
        kotlin.s0.w.d.l0.c.f r113 = null;
        if (r29 == null) goto L17;
        kotlin.s0.w.d.l0.n.e0 r31 = r111.i().q(r29);
        if (r31 == null) goto L17;
        kotlin.s0.w.d.l0.l.b.g0.j r114 = r110;
        x0 r32 = kotlin.s0.w.d.l0.k.c.h(r114, r31, r25);
    L18:
        List<kotlin.s0.w.d.l0.f.q> r33 = r30.X();
        kotlin.n0.d.o.e(r33, "proto.contextReceiverTypeList");
        ArrayList r34 = new ArrayList(kotlin.i0.r.q(r33, 10));
        Iterator<T> r35 = r33.iterator();
    L20:
        if (r35.hasNext() == false) goto L22;
        kotlin.s0.w.d.l0.f.q r36 = (kotlin.s0.w.d.l0.f.q) r35.next();
        kotlin.n0.d.o.e(r36, "it");
        r34.add(n(r36, r111, r114));
        goto L20
    L22:
        r114.c1(r26, r27, r28, r32, r34);
        Boolean r37 = kotlin.s0.w.d.l0.f.z.b.f20232c.g(r14);
        kotlin.n0.d.o.e(r37, "HAS_ANNOTATIONS.get(flags)");
        boolean r210 = r37.booleanValue();
        kotlin.s0.w.d.l0.f.z.b.d<kotlin.s0.w.d.l0.f.x> r115 = kotlin.s0.w.d.l0.f.z.b.f20233d;
        kotlin.s0.w.d.l0.f.x r211 = r115.d(r14);
        kotlin.s0.w.d.l0.f.z.b.d<kotlin.s0.w.d.l0.f.k> r116 = kotlin.s0.w.d.l0.f.z.b.f20234e;
        int r117 = kotlin.s0.w.d.l0.f.z.b.b(r210, r211, r116.d(r14), false, false, false);
        if (r24 == true) goto L25;
        r115 = r115;
        r111 = r111;
        r116 = r116;
        kotlin.s0.w.d.l0.c.q1.d0 r118 = null;
    L34:
        Boolean r38 = kotlin.s0.w.d.l0.f.z.b.z.g(r14);
        kotlin.n0.d.o.e(r38, "HAS_SETTER.get(flags)");
        if (r38.booleanValue() == true) goto L37;
        kotlin.s0.w.d.l0.l.b.g0.j r39 = r114;
        kotlin.s0.w.d.l0.f.n r40 = r112;
        boolean r41 = true;
        kotlin.s0.w.d.l0.c.q1.e0 r42 = null;
    L44:
        Boolean r43 = kotlin.s0.w.d.l0.f.z.b.C.g(r14);
        kotlin.n0.d.o.e(r43, "HAS_CONSTANT.get(flags)");
        if (r43.booleanValue() == false) goto L47;
        r39.M0(new d(this, r40, r39));
    L47:
        kotlin.s0.w.d.l0.c.m r44 = this.f20865a.e();
        if ((r44 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L50;
        kotlin.s0.w.d.l0.c.e r45 = (kotlin.s0.w.d.l0.c.e) r44;
    L51:
        if (r45 == null) goto L54;
        r113 = r45.i();
    L54:
        if (r113 != kotlin.s0.w.d.l0.c.f.f18869j) goto L56;
        r39.M0(new e(this, r40, r39));
    L56:
        r39.W0(r118, r42, new kotlin.s0.w.d.l0.c.q1.o(f(r40, false), r39), new kotlin.s0.w.d.l0.c.q1.o(f(r40, r41), r39));
        return r39;
    L50:
        r45 = null;
        goto L51
    L37:
        if (r30.w0() == false) goto L39;
        r117 = r30.i0();
    L39:
        int r46 = r117;
        Boolean r47 = kotlin.s0.w.d.l0.f.z.b.f20229J.g(r46);
        kotlin.n0.d.o.e(r47, "IS_NOT_DEFAULT.get(setterFlags)");
        boolean r48 = r47.booleanValue();
        Boolean r49 = kotlin.s0.w.d.l0.f.z.b.K.g(r46);
        kotlin.n0.d.o.e(r49, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
        boolean r50 = r49.booleanValue();
        Boolean r51 = kotlin.s0.w.d.l0.f.z.b.L.g(r46);
        kotlin.n0.d.o.e(r51, "IS_INLINE_ACCESSOR.get(setterFlags)");
        boolean r52 = r51.booleanValue();
        kotlin.s0.w.d.l0.l.b.b r119 = kotlin.s0.w.d.l0.l.b.b.f20698i;
        kotlin.s0.w.d.l0.c.o1.g r53 = d(r112, r46, r119);
        if (r48 == false) goto L42;
        a0 r54 = a0.f20690a;
        kotlin.s0.w.d.l0.c.q1.e0 r55 = new kotlin.s0.w.d.l0.c.q1.e0(r114, r53, r54.b(r116.d(r46)), b0.a(r54, r115.d(r46)), !r48, r50, r52, r114.i(), null, a1.f18847a);
        r41 = true;
        r39 = r114;
        r40 = r112;
        r55.S0((j1) kotlin.i0.r.o0(m.b(r111, r55, kotlin.i0.r.g(), null, null, null, null, 60, null).f().o(kotlin.i0.r.d(r30.j0()), r40, r119)));
        r42 = r55;
        goto L44
    L42:
        r39 = r114;
        r40 = r112;
        r41 = true;
        r42 = kotlin.s0.w.d.l0.k.c.e(r39, r53, kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        kotlin.n0.d.o.e(r42, "{\n                Descri…          )\n            }");
        goto L44
    L25:
        if (r30.p0() == false) goto L27;
        int r56 = r30.b0();
    L28:
        Boolean r57 = kotlin.s0.w.d.l0.f.z.b.f20229J.g(r56);
        kotlin.n0.d.o.e(r57, "IS_NOT_DEFAULT.get(getterFlags)");
        boolean r58 = r57.booleanValue();
        Boolean r59 = kotlin.s0.w.d.l0.f.z.b.K.g(r56);
        kotlin.n0.d.o.e(r59, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
        boolean r60 = r59.booleanValue();
        Boolean r61 = kotlin.s0.w.d.l0.f.z.b.L.g(r56);
        kotlin.n0.d.o.e(r61, "IS_INLINE_ACCESSOR.get(getterFlags)");
        boolean r62 = r61.booleanValue();
        kotlin.s0.w.d.l0.c.o1.g r63 = d(r112, r56, kotlin.s0.w.d.l0.l.b.b.f20697h);
        if (r58 == false) goto L31;
        a0 r64 = a0.f20690a;
        kotlin.s0.w.d.l0.c.q1.d0 r65 = new kotlin.s0.w.d.l0.c.q1.d0(r114, r63, r64.b(r116.d(r56)), b0.a(r64, r115.d(r56)), !r58, r60, r62, r114.i(), null, a1.f18847a);
    L32:
        r65.R0(r114.getReturnType());
        r118 = r65;
        goto L34
    L31:
        r65 = kotlin.s0.w.d.l0.k.c.d(r114, r63);
        kotlin.n0.d.o.e(r65, "{\n                Descri…nnotations)\n            }");
        goto L32
    L27:
        r56 = r117;
    L17:
        r114 = r110;
        r32 = null;
        goto L18
    L9:
        if (kotlin.s0.w.d.l0.f.z.f.e(r30) == false) goto L11;
        r112 = r30;
        r25 = g(r112, kotlin.s0.w.d.l0.l.b.b.f20697h);
        goto L12
    L5:
        r1 = k(r30.d0());
        goto L6
    }

    public final e1 m(kotlin.s0.w.d.l0.f.r r23) {
        kotlin.n0.d.o.f(r23, "proto");
        kotlin.s0.w.d.l0.c.o1.g.a r1 = kotlin.s0.w.d.l0.c.o1.g.f18919b;
        List<kotlin.s0.w.d.l0.f.b> r2 = r23.Q();
        kotlin.n0.d.o.e(r2, "proto.annotationList");
        ArrayList r3 = new ArrayList(kotlin.i0.r.q(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        kotlin.s0.w.d.l0.f.b r5 = (kotlin.s0.w.d.l0.f.b) r4.next();
        kotlin.s0.w.d.l0.l.b.e r6 = this.f20866b;
        kotlin.n0.d.o.e(r5, "it");
        r3.add(r6.a(r5, this.f20865a.g()));
        goto L4
    L6:
        kotlin.s0.w.d.l0.c.o1.g r7 = r1.a(r3);
        kotlin.s0.w.d.l0.c.u r8 = b0.a(a0.f20690a, kotlin.s0.w.d.l0.f.z.b.f20233d.d(r23.V()));
        kotlin.s0.w.d.l0.l.b.g0.l r15 = new kotlin.s0.w.d.l0.l.b.g0.l(this.f20865a.h(), this.f20865a.e(), r7, x.b(this.f20865a.g(), r23.W()), r8, r23, this.f20865a.g(), this.f20865a.j(), this.f20865a.k(), this.f20865a.d());
        m r13 = this.f20865a;
        List<kotlin.s0.w.d.l0.f.s> r9 = r23.Z();
        kotlin.n0.d.o.e(r9, "proto.typeParameterList");
        m r10 = m.b(r13, r15, r9, null, null, null, null, 60, null);
        r15.R0(r10.i().j(), r10.i().l(kotlin.s0.w.d.l0.f.z.f.o(r23, this.f20865a.j()), false), r10.i().l(kotlin.s0.w.d.l0.f.z.f.b(r23, this.f20865a.j()), false));
        return r15;
    }
}
