package kotlin.s0.w.d.l0.l.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.q0;
import kotlin.s0.w.d.l0.n.r0;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.n.s0;
import kotlin.s0.w.d.l0.n.y0;
import kotlin.s0.w.d.l0.n.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f20706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d0 f20707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f20709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.n0.c.l<Integer, kotlin.s0.w.d.l0.c.h> f20710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.n0.c.l<Integer, kotlin.s0.w.d.l0.c.h> f20711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Integer, f1> f20712g;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<Integer, kotlin.s0.w.d.l0.c.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0 f20713f;

        a(d0 r1) {
            this.f20713f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.h a(int r1) {
            return d0.a(this.f20713f, r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h invoke(Integer r1) {
            return a(r1.intValue());
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.o1.c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0 f20714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.f.q f20715g;

        b(d0 r1, kotlin.s0.w.d.l0.f.q r2) {
            this.f20714f = r1;
            this.f20715g = r2;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.o1.c> a() {
            return d0.c(this.f20714f).c().d().d(this.f20715g, d0.c(this.f20714f).g());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.o1.c> invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<Integer, kotlin.s0.w.d.l0.c.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0 f20716f;

        c(d0 r1) {
            this.f20716f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.h a(int r1) {
            return d0.b(this.f20716f, r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h invoke(Integer r1) {
            return a(r1.intValue());
        }
    }

    /* synthetic */ class d extends kotlin.n0.d.l implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f20717f = null;

        static {
            f20717f = new d();
        }

        d() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return kotlin.n0.d.e0.b(kotlin.s0.w.d.l0.g.b.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.b invoke(kotlin.s0.w.d.l0.g.b r1) {
            return m(r1);
        }

        public final kotlin.s0.w.d.l0.g.b m(kotlin.s0.w.d.l0.g.b r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return r1.g();
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.f.q, kotlin.s0.w.d.l0.f.q> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0 f20718f;

        e(d0 r1) {
            this.f20718f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.f.q a(kotlin.s0.w.d.l0.f.q r2) {
            kotlin.n0.d.o.f(r2, "it");
            return kotlin.s0.w.d.l0.f.z.f.g(r2, d0.c(this.f20718f).j());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.f.q invoke(kotlin.s0.w.d.l0.f.q r1) {
            return a(r1);
        }
    }

    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.f.q, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f20719f = null;

        static {
            f20719f = new f();
        }

        f() {
            super(1);
        }

        public final Integer a(kotlin.s0.w.d.l0.f.q r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Integer.valueOf(r1.U());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Integer invoke(kotlin.s0.w.d.l0.f.q r1) {
            return a(r1);
        }
    }

    public d0(m r4, d0 r5, List<kotlin.s0.w.d.l0.f.s> r6, String r7, String r8) {
        kotlin.n0.d.o.f(r4, "c");
        kotlin.n0.d.o.f(r6, "typeParameterProtos");
        kotlin.n0.d.o.f(r7, "debugName");
        kotlin.n0.d.o.f(r8, "containerPresentableName");
        this.f20706a = r4;
        this.f20707b = r5;
        this.f20708c = r7;
        this.f20709d = r8;
        this.f20710e = r4.h().i(new a(this));
        this.f20711f = r4.h().i(new c(this));
        if (r6.isEmpty() == false) goto L5;
        Map<Integer, f1> r9 = m0.h();
    L9:
        this.f20712g = r9;
        return;
    L5:
        r9 = new LinkedHashMap();
        Iterator<kotlin.s0.w.d.l0.f.s> r10 = r6.iterator();
        int r11 = 0;
    L7:
        if (r10.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.f.s r12 = r10.next();
        r9.put(Integer.valueOf(r12.M()), new kotlin.s0.w.d.l0.l.b.g0.m(this.f20706a, r12, r11));
        r11 = r11 + 1;
        goto L7
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.h a(d0 r0, int r1) {
        return r0.d(r1);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.h b(d0 r0, int r1) {
        return r0.f(r1);
    }

    public static final /* synthetic */ m c(d0 r0) {
        return r0.f20706a;
    }

    private final kotlin.s0.w.d.l0.c.h d(int r2) {
        kotlin.s0.w.d.l0.g.b r3 = x.a(this.f20706a.g(), r2);
        boolean r0 = r3.k();
        k r1 = this.f20706a.c();
        if (r0 == false) goto L7;
        return r1.b(r3);
    L7:
        return kotlin.s0.w.d.l0.c.x.b(r1.p(), r3);
    }

    private final kotlin.s0.w.d.l0.n.m0 e(int r2) {
        if (x.a(this.f20706a.g(), r2).k() == true) goto L5;
        return null;
    L5:
        return this.f20706a.c().n().a();
    }

    private final kotlin.s0.w.d.l0.c.h f(int r2) {
        kotlin.s0.w.d.l0.g.b r3 = x.a(this.f20706a.g(), r2);
        if (r3.k() == false) goto L7;
        return null;
    L7:
        return kotlin.s0.w.d.l0.c.x.d(this.f20706a.c().p(), r3);
    }

    private final kotlin.s0.w.d.l0.n.m0 g(kotlin.s0.w.d.l0.n.e0 r9, kotlin.s0.w.d.l0.n.e0 r10) {
        kotlin.s0.w.d.l0.b.h r0 = kotlin.s0.w.d.l0.n.x1.a.h(r9);
        kotlin.s0.w.d.l0.c.o1.g r1 = r9.getAnnotations();
        kotlin.s0.w.d.l0.n.e0 r2 = kotlin.s0.w.d.l0.b.g.j(r9);
        List<kotlin.s0.w.d.l0.n.e0> r3 = kotlin.s0.w.d.l0.b.g.e(r9);
        List r8 = kotlin.i0.r.M(kotlin.s0.w.d.l0.b.g.l(r9), 1);
        ArrayList r4 = new ArrayList(kotlin.i0.r.q(r8, 10));
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r4.add(((g1) r11.next()).b());
        goto L4
    L7:
        return kotlin.s0.w.d.l0.b.g.b(r0, r1, r2, r3, r4, null, r10, true).V0(r9.P0());
    }

    private final kotlin.s0.w.d.l0.n.m0 h(a1 r8, e1 r9, List<? extends g1> r10, boolean r11) {
        int r0 = r9.getParameters().size() - r10.size();
        kotlin.s0.w.d.l0.n.m0 r1 = null;
        if (r0 != 0) goto L5;
        r1 = i(r8, r9, r10, r11);
    L11:
        if (r1 == null) goto L13;
        return r1;
    L13:
        return kotlin.s0.w.d.l0.n.u1.k.f21165a.f(kotlin.s0.w.d.l0.n.u1.j.U, r10, r9, new String[0]);
    L5:
        if (r0 != 1) goto L11;
        int r2 = r10.size() - 1;
        if (r2 < 0) goto L11;
        e1 r3 = r9.o().X(r2).k();
        kotlin.n0.d.o.e(r3, "functionTypeConstructor.…on(arity).typeConstructor");
        r1 = f0.i(r8, r3, r10, r11, null, 16, null);
        goto L11
    }

    private final kotlin.s0.w.d.l0.n.m0 i(a1 r8, e1 r9, List<? extends g1> r10, boolean r11) {
        kotlin.s0.w.d.l0.n.m0 r12 = f0.i(r8, r9, r10, r11, null, 16, null);
        if (kotlin.s0.w.d.l0.b.g.p(r12) == true) goto L6;
        return null;
    L6:
        return p(r12);
    }

    private final f1 k(int r3) {
        f1 r0 = this.f20712g.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        d0 r2 = this.f20707b;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.k(r3);
    L9:
        return r0;
    }

    private static final List<kotlin.s0.w.d.l0.f.q.b> m(kotlin.s0.w.d.l0.f.q r2, d0 r3) {
        List<kotlin.s0.w.d.l0.f.q.b> r0 = r2.V();
        kotlin.n0.d.o.e(r0, "argumentList");
        kotlin.s0.w.d.l0.f.q r4 = kotlin.s0.w.d.l0.f.z.f.g(r2, r3.f20706a.j());
        if (r4 == null) goto L5;
        List<kotlin.s0.w.d.l0.f.q.b> r5 = m(r4, r3);
    L6:
        if (r5 != null) goto L9;
        r5 = kotlin.i0.r.g();
    L9:
        return kotlin.i0.r.k0(r0, r5);
    L5:
        r5 = null;
        goto L6
    }

    public static /* synthetic */ kotlin.s0.w.d.l0.n.m0 n(d0 r0, kotlin.s0.w.d.l0.f.q r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.l(r1, r2);
    }

    private final a1 o(List<? extends z0> r2, kotlin.s0.w.d.l0.c.o1.g r3, e1 r4, kotlin.s0.w.d.l0.c.m r5) {
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r2, 10));
        Iterator<T> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r1.add(((z0) r6.next()).a(r3, r4, r5));
        goto L4
    L6:
        List<? extends y0<?>> r7 = kotlin.i0.r.s(r1);
        return a1.f20943g.g(r7);
    }

    private final kotlin.s0.w.d.l0.n.m0 p(kotlin.s0.w.d.l0.n.e0 r6) {
        g1 r0 = (g1) kotlin.i0.r.d0(kotlin.s0.w.d.l0.b.g.l(r6));
        kotlin.s0.w.d.l0.g.c r1 = null;
        if (r0 == null) goto L28;
        kotlin.s0.w.d.l0.n.e0 r2 = r0.b();
        if (r2 == null) goto L28;
        kotlin.s0.w.d.l0.c.h r3 = r2.O0().d();
        if (r3 == null) goto L10;
        kotlin.s0.w.d.l0.g.c r4 = kotlin.s0.w.d.l0.k.t.a.h(r3);
    L12:
        if (r2.M0().size() != 1) goto L27;
        if (kotlin.n0.d.o.a(r4, kotlin.s0.w.d.l0.b.k.f18710f) == false) goto L16;
    L18:
        kotlin.s0.w.d.l0.n.e0 r5 = ((g1) kotlin.i0.r.o0(r2.M0())).b();
        kotlin.n0.d.o.e(r5, "continuationArgumentType.arguments.single().type");
        kotlin.s0.w.d.l0.c.m r7 = this.f20706a.e();
        if ((r7 instanceof kotlin.s0.w.d.l0.c.a) == true) goto L21;
        r7 = null;
    L21:
        kotlin.s0.w.d.l0.c.a r8 = (kotlin.s0.w.d.l0.c.a) r7;
        if (r8 == null) goto L24;
        r1 = kotlin.s0.w.d.l0.k.t.a.d(r8);
    L24:
        kotlin.n0.d.o.a(r1, c0.f20702a);
        return g(r6, r5);
    L16:
        if (kotlin.n0.d.o.a(r4, e0.a()) == true) goto L18;
    L27:
        return (kotlin.s0.w.d.l0.n.m0) r6;
    L10:
        r4 = null;
    L28:
        return null;
    }

    private final g1 r(f1 r3, kotlin.s0.w.d.l0.f.q.b r4) {
        if (r4.w() != kotlin.s0.w.d.l0.f.q.b.c.f20120j) goto L8;
        if (r3 != null) goto L7;
        return new r0(this.f20706a.c().p().o());
    L7:
        return new s0(r3);
    L8:
        a0 r5 = a0.f20690a;
        kotlin.s0.w.d.l0.f.q.b.c r0 = r4.w();
        kotlin.n0.d.o.e(r0, "typeArgumentProto.projection");
        r1 r6 = r5.c(r0);
        kotlin.s0.w.d.l0.f.q r1 = kotlin.s0.w.d.l0.f.z.f.m(r4, this.f20706a.j());
        if (r1 != null) goto L13;
        return new i1(kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.E0, new String[]{r4.toString()}));
    L13:
        return new i1(r6, q(r1));
    }

    private final e1 s(kotlin.s0.w.d.l0.f.q r7) {
        if (r7.l0() == false) goto L9;
        kotlin.s0.w.d.l0.c.h r0 = this.f20710e.invoke(Integer.valueOf(r7.W()));
        if (r0 != null) goto L32;
        int r1 = r7.W();
    L7:
        r0 = t(this, r7, r1);
    L32:
        e1 r6 = r0.k();
        kotlin.n0.d.o.e(r6, "classifier.typeConstructor");
        return r6;
    L9:
        if (r7.u0() == false) goto L15;
        r0 = k(r7.h0());
        if (r0 != null) goto L32;
        return kotlin.s0.w.d.l0.n.u1.k.f21165a.e(kotlin.s0.w.d.l0.n.u1.j.S, new String[]{String.valueOf(r7.h0()), this.f20709d});
    L15:
        if (r7.v0() == false) goto L28;
        String r8 = this.f20706a.g().b(r7.i0());
        Iterator<T> r2 = j().iterator();
    L18:
        if (r2.hasNext() == false) goto L22;
        Object r4 = r2.next();
        if (kotlin.n0.d.o.a(((f1) r4).getName().b(), r8) == false) goto L18;
    L23:
        r0 = (f1) r4;
        if (r0 != null) goto L32;
        return kotlin.s0.w.d.l0.n.u1.k.f21165a.e(kotlin.s0.w.d.l0.n.u1.j.T, new String[]{r8, this.f20706a.e().toString()});
    L22:
        r4 = null;
        goto L23
    L28:
        if (r7.t0() == false) goto L35;
        r0 = this.f20711f.invoke(Integer.valueOf(r7.g0()));
        if (r0 != null) goto L32;
        r1 = r7.g0();
        goto L7
    L35:
        return kotlin.s0.w.d.l0.n.u1.k.f21165a.e(kotlin.s0.w.d.l0.n.u1.j.W, new String[0]);
    }

    private static final kotlin.s0.w.d.l0.c.e t(d0 r2, kotlin.s0.w.d.l0.f.q r3, int r4) {
        kotlin.s0.w.d.l0.g.b r5 = x.a(r2.f20706a.g(), r4);
        List<Integer> r6 = kotlin.t0.k.A(kotlin.t0.k.t(kotlin.t0.k.h(r3, new e(r2)), f.f20719f));
        int r0 = kotlin.t0.k.l(kotlin.t0.k.h(r5, d.f20717f));
    L4:
        if (r6.size() >= r0) goto L7;
        r6.add(0);
        goto L4
    L7:
        return r2.f20706a.c().q().d(r5, r6);
    }

    public final List<f1> j() {
        return kotlin.i0.r.z0(this.f20712g.values());
    }

    public final kotlin.s0.w.d.l0.n.m0 l(kotlin.s0.w.d.l0.f.q r14, boolean r15) {
        kotlin.n0.d.o.f(r14, "proto");
        if (r14.l0() == false) goto L7;
        int r0 = r14.W();
    L5:
        kotlin.s0.w.d.l0.n.m0 r1 = e(r0);
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        e1 r3 = s(r14);
        boolean r2 = true;
        if (kotlin.s0.w.d.l0.n.u1.k.m(r3.d()) == true) goto L15;
        kotlin.s0.w.d.l0.l.b.g0.a r4 = new kotlin.s0.w.d.l0.l.b.g0.a(this.f20706a.h(), new b(this, r14));
        a1 r5 = o(this.f20706a.c().v(), r4, r3, this.f20706a.e());
        List<kotlin.s0.w.d.l0.f.q.b> r6 = m(r14, this);
        ArrayList r7 = new ArrayList(kotlin.i0.r.q(r6, 10));
        Iterator<T> r8 = r6.iterator();
        int r9 = 0;
    L18:
        if (r8.hasNext() == false) goto L24;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 < 0) goto L22;
        List<f1> r12 = r3.getParameters();
        kotlin.n0.d.o.e(r12, "constructor.parameters");
        r7.add(r((f1) kotlin.i0.r.S(r12, r9), (kotlin.s0.w.d.l0.f.q.b) r10));
        r9 = r11;
        goto L18
    L22:
        kotlin.i0.r.p();
        throw null;
    L24:
        List<? extends g1> r13 = kotlin.i0.r.z0(r7);
        kotlin.s0.w.d.l0.c.h r16 = r3.d();
        if (r15 == true) goto L27;
    L35:
        Boolean r17 = kotlin.s0.w.d.l0.f.z.b.f20230a.g(r14.Z());
        kotlin.n0.d.o.e(r17, "SUSPEND_TYPE.get(proto.flags)");
        if (r17.booleanValue() == false) goto L38;
        kotlin.s0.w.d.l0.n.m0 r18 = h(r5, r3, r13, r14.d0());
    L45:
        kotlin.s0.w.d.l0.f.q r19 = kotlin.s0.w.d.l0.f.z.f.a(r14, this.f20706a.j());
        if (r19 == null) goto L52;
        kotlin.s0.w.d.l0.n.m0 r20 = q0.j(r18, l(r19, false));
        if (r20 == null) goto L52;
        r18 = r20;
    L52:
        if (r14.l0() == true) goto L54;
        return r18;
    L54:
        return this.f20706a.c().t().a(x.a(this.f20706a.g(), r14.W()), r18);
    L38:
        r18 = f0.i(r5, r3, r13, r14.d0(), null, 16, null);
        Boolean r21 = kotlin.s0.w.d.l0.f.z.b.f20231b.g(r14.Z());
        kotlin.n0.d.o.e(r21, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
        if (r21.booleanValue() == false) goto L45;
        kotlin.s0.w.d.l0.n.p r22 = kotlin.s0.w.d.l0.n.p.a.c(kotlin.s0.w.d.l0.n.p.f21058i, r18, false, 2, null);
        if (r22 == null) goto L44;
        r18 = r22;
        goto L45
    L44:
        throw new IllegalStateException(("null DefinitelyNotNullType for '" + r18 + '\'').toString());
    L27:
        if ((r16 instanceof kotlin.s0.w.d.l0.c.e1) == false) goto L35;
        f0 r110 = f0.f20991a;
        kotlin.s0.w.d.l0.n.m0 r111 = f0.b((kotlin.s0.w.d.l0.c.e1) r16, r13);
        a1 r23 = o(this.f20706a.c().v(), kotlin.s0.w.d.l0.c.o1.g.f18919b.a(kotlin.i0.r.i0(r4, r111.getAnnotations())), r3, this.f20706a.e());
        if (g0.b(r111) == false) goto L31;
    L34:
        r18 = r111.V0(r2).W0(r23);
        goto L45
    L31:
        if (r14.d0() == true) goto L34;
        r2 = false;
        goto L34
    L15:
        return kotlin.s0.w.d.l0.n.u1.k.f21165a.c(kotlin.s0.w.d.l0.n.u1.j.z0, r3, new String[]{r3.toString()});
    L7:
        if (r14.t0() == false) goto L9;
        r0 = r14.g0();
        goto L5
    L9:
        r1 = null;
        goto L10
    }

    public final kotlin.s0.w.d.l0.n.e0 q(kotlin.s0.w.d.l0.f.q r7) {
        kotlin.n0.d.o.f(r7, "proto");
        if (r7.n0() == false) goto L7;
        String r0 = this.f20706a.g().b(r7.a0());
        kotlin.s0.w.d.l0.n.m0 r4 = n(this, r7, false, 2, null);
        kotlin.s0.w.d.l0.f.q r5 = kotlin.s0.w.d.l0.f.z.f.c(r7, this.f20706a.j());
        kotlin.n0.d.o.c(r5);
        kotlin.s0.w.d.l0.n.m0 r1 = n(this, r5, false, 2, null);
        return this.f20706a.c().l().a(r7, r0, r4, r1);
    L7:
        return l(r7, true);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f20708c);
        if (this.f20707b != null) goto L5;
        String r3 = "";
    L6:
        r0.append(r3);
        return r0.toString();
    L5:
        r3 = ". Child of " + this.f20707b.f20708c;
        goto L6
    }
}
