package kotlin.s0.w.d.l0.e.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.j0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.d1;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.g1;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.c.n1;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.y0;
import kotlin.s0.w.d.l0.e.a.a0;
import kotlin.s0.w.d.l0.e.a.i0;
import kotlin.s0.w.d.l0.e.a.n0.x;
import kotlin.s0.w.d.l0.e.a.n0.y;
import kotlin.s0.w.d.l0.k.r.v;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends kotlin.s0.w.d.l0.c.q1.g implements kotlin.s0.w.d.l0.e.a.k0.c {
    private final k A;
    private final kotlin.s0.w.d.l0.c.o1.g B;
    private final kotlin.s0.w.d.l0.m.i<List<f1>> C;
    private final kotlin.s0.w.d.l0.e.a.l0.g n;
    private final kotlin.s0.w.d.l0.e.a.n0.g o;
    private final kotlin.s0.w.d.l0.c.e p;
    private final kotlin.s0.w.d.l0.e.a.l0.g q;
    private final kotlin.h r;
    private final kotlin.s0.w.d.l0.c.f s;
    private final e0 t;
    private final n1 u;
    private final boolean v;
    private final a w;
    private final g x;
    private final y0<g> y;
    private final kotlin.s0.w.d.l0.k.w.f z;

    private final class a extends kotlin.s0.w.d.l0.n.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i<List<f1>> f19412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f19413e;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.l0.l.f$a$a, reason: collision with other inner class name */
        static final class C0513a extends q implements kotlin.n0.c.a<List<? extends f1>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f19414f;

            C0513a(f r1) {
                this.f19414f = r1;
                super(0);
            }

            public final List<f1> a() {
                return g1.d(this.f19414f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends f1> invoke() {
                return a();
            }
        }

        public a(f r3) {
            this.f19413e = r3;
            super(f.M0(r3).e());
            this.f19412d = f.M0(r3).e().d(new C0513a(r3));
        }

        private final kotlin.s0.w.d.l0.n.e0 x() {
            kotlin.s0.w.d.l0.g.c r0 = y();
            if (r0 != null) goto L5;
        L12:
            r0 = null;
        L13:
            if (r0 != null) goto L17;
            kotlin.s0.w.d.l0.g.c r3 = kotlin.s0.w.d.l0.e.a.m.f19524a.b(kotlin.s0.w.d.l0.k.t.a.h(this.f19413e));
            if (r3 != null) goto L18;
            return null;
        L18:
            kotlin.s0.w.d.l0.c.e r4 = kotlin.s0.w.d.l0.k.t.a.r(f.M0(this.f19413e).d(), r3, kotlin.s0.w.d.l0.d.b.d.x);
            if (r4 != null) goto L21;
            return null;
        L21:
            int r5 = r4.k().getParameters().size();
            List<f1> r7 = this.f19413e.k().getParameters();
            o.e(r7, "getTypeConstructor().parameters");
            int r6 = r7.size();
            if (r6 != r5) goto L27;
            ArrayList r1 = new ArrayList(r.q(r7, 10));
            Iterator<T> r8 = r7.iterator();
        L25:
            if (r8.hasNext() == false) goto L36;
            r1.add(new i1(r1.f21065h, ((f1) r8.next()).s()));
        L36:
            return f0.g(a1.f20943g.h(), r4, r1);
        L27:
            if (r6 != 1) goto L37;
            if (r5 <= 1) goto L37;
            if (r0 != null) goto L37;
            i1 r2 = new i1(r1.f21065h, ((f1) r.o0(r7)).s());
            kotlin.r0.d r9 = new kotlin.r0.d(1, r5);
            ArrayList r10 = new ArrayList(r.q(r9, 10));
            Iterator<Integer> r11 = r9.iterator();
        L32:
            if (r11.hasNext() == false) goto L34;
            ((j0) r11).nextInt();
            r10.add(r2);
            goto L32
        L34:
            r1 = r10;
        L37:
            return null;
        L17:
            r3 = r0;
            goto L18
        L5:
            if (r0.d() == false) goto L7;
        L9:
            boolean r12 = false;
        L10:
            if (r12 == false) goto L12;
        L7:
            if (r0.i(kotlin.s0.w.d.l0.b.k.f18714j) == false) goto L9;
            r12 = true;
            goto L10
        }

        private final kotlin.s0.w.d.l0.g.c y() {
            kotlin.s0.w.d.l0.c.o1.g r2 = this.f19413e.getAnnotations();
            kotlin.s0.w.d.l0.g.c r0 = a0.n;
            o.e(r0, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.s0.w.d.l0.c.o1.c r3 = r2.i(r0);
            if (r3 != null) goto L5;
            return null;
        L5:
            Object r4 = r.p0(r3.a().values());
            if ((r4 instanceof v) == false) goto L8;
            v r5 = (v) r4;
        L9:
            if (r5 == null) goto L18;
            String r6 = r5.b();
            if (r6 != null) goto L14;
            return null;
        L14:
            if (kotlin.s0.w.d.l0.g.e.e(r6) == true) goto L17;
            return null;
        L17:
            return new kotlin.s0.w.d.l0.g.c(r6);
        L18:
            return null;
        L8:
            r5 = null;
            goto L9
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public List<f1> getParameters() {
            return this.f19412d.invoke();
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected Collection<kotlin.s0.w.d.l0.n.e0> l() {
            Collection<kotlin.s0.w.d.l0.e.a.n0.j> r0 = this.f19413e.Q0().a();
            ArrayList r1 = new ArrayList(r0.size());
            ArrayList r2 = new ArrayList(0);
            kotlin.s0.w.d.l0.n.e0 r4 = x();
            Iterator<kotlin.s0.w.d.l0.e.a.n0.j> r3 = r0.iterator();
        L3:
            Object r6 = null;
            if (r3.hasNext() == false) goto L17;
            kotlin.s0.w.d.l0.e.a.n0.j r5 = r3.next();
            kotlin.s0.w.d.l0.n.e0 r7 = f.M0(this.f19413e).a().r().h(f.M0(this.f19413e).g().o(r5, kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19332f, false, null, 3, null)), f.M0(this.f19413e));
            if ((r7.O0().d() instanceof k0.b) == false) goto L8;
            r2.add(r5);
        L8:
            e1 r8 = r7.O0();
            if (r4 == null) goto L12;
            r6 = r4.O0();
        L12:
            if (o.a(r8, r6) == true) goto L3;
            if (kotlin.s0.w.d.l0.b.h.b0(r7) == true) goto L3;
            r1.add(r7);
            goto L3
        L17:
            kotlin.s0.w.d.l0.c.e r9 = f.L0(this.f19413e);
            if (r9 == null) goto L20;
            r6 = kotlin.s0.w.d.l0.b.q.j.a(r9, this.f19413e).c().p(r9.s(), r1.f21065h);
        L20:
            kotlin.s0.w.d.l0.p.a.a(r1, r6);
            kotlin.s0.w.d.l0.p.a.a(r1, r4);
            if ((!r2.isEmpty()) == false) goto L28;
            kotlin.s0.w.d.l0.l.b.r r10 = f.M0(this.f19413e).a().c();
            kotlin.s0.w.d.l0.c.e r11 = w();
            ArrayList r12 = new ArrayList(r.q(r2, 10));
            Iterator r13 = r2.iterator();
        L24:
            if (r13.hasNext() == false) goto L26;
            x r14 = (x) r13.next();
            o.d(r14, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
            r12.add(((kotlin.s0.w.d.l0.e.a.n0.j) r14).o());
            goto L24
        L26:
            r10.b(r11, r12);
        L28:
            if ((!r1.isEmpty()) == false) goto L31;
            return r.z0(r1);
        L31:
            return r.d(f.M0(this.f19413e).d().o().i());
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected d1 q() {
            return f.M0(this.f19413e).a().v();
        }

        public String toString() {
            String r1 = this.f19413e.getName().b();
            o.e(r1, "name.asString()");
            return r1;
        }

        @Override // kotlin.s0.w.d.l0.n.b
        public kotlin.s0.w.d.l0.c.e w() {
            return this.f19413e;
        }
    }

    static final class b extends q implements kotlin.n0.c.a<List<? extends f1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f19415f;

        b(f r1) {
            this.f19415f = r1;
            super(0);
        }

        public final List<f1> a() {
            List<y> r0 = this.f19415f.Q0().getTypeParameters();
            f r4 = this.f19415f;
            ArrayList r1 = new ArrayList(r.q(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            y r3 = (y) r2.next();
            f1 r5 = f.M0(r4).f().a(r3);
            if (r5 == null) goto L9;
            r1.add(r5);
            goto L4
        L9:
            throw new AssertionError("Parameter " + r3 + " surely belongs to class " + r4.Q0() + ", so it must be resolved");
        L10:
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends f1> invoke() {
            return a();
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(kotlin.s0.w.d.l0.k.t.a.h((kotlin.s0.w.d.l0.c.e) r1).b(), kotlin.s0.w.d.l0.k.t.a.h((kotlin.s0.w.d.l0.c.e) r2).b());
        }
    }

    static final class d extends q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.e.a.n0.a>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f19416f;

        d(f r1) {
            this.f19416f = r1;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.e.a.n0.a> a() {
            kotlin.s0.w.d.l0.g.b r0 = kotlin.s0.w.d.l0.k.t.a.g(this.f19416f);
            if (r0 != null) goto L7;
            return null;
        L7:
            return this.f19416f.S0().a().f().a(r0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.e.a.n0.a> invoke() {
            return a();
        }
    }

    static final class e extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f19417f;

        e(f r1) {
            this.f19417f = r1;
            super(1);
        }

        public final g a(kotlin.s0.w.d.l0.n.t1.g r8) {
            o.f(r8, "it");
            kotlin.s0.w.d.l0.e.a.l0.g r2 = f.M0(this.f19417f);
            f r3 = this.f19417f;
            kotlin.s0.w.d.l0.e.a.n0.g r4 = r3.Q0();
            if (f.L0(this.f19417f) == null) goto L5;
            boolean r0 = true;
        L7:
            return new g(r2, r3, r4, r0, f.N0(this.f19417f));
        L5:
            r0 = false;
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ g invoke(kotlin.s0.w.d.l0.n.t1.g r1) {
            return a(r1);
        }
    }

    static {
        t0.e(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public f(kotlin.s0.w.d.l0.e.a.l0.g r13, kotlin.s0.w.d.l0.c.m r14, kotlin.s0.w.d.l0.e.a.n0.g r15, kotlin.s0.w.d.l0.c.e r16) {
        o.f(r13, "outerContext");
        o.f(r14, "containingDeclaration");
        o.f(r15, "jClass");
        super(r13.e(), r14, r15.getName(), r13.a().t().a(r15), false);
        this.n = r13;
        this.o = r15;
        this.p = r16;
        kotlin.s0.w.d.l0.e.a.l0.g r10 = kotlin.s0.w.d.l0.e.a.l0.a.d(r13, this, r15, 0, 4, null);
        this.q = r10;
        r10.a().h().c(r15, this);
        r15.I();
        this.r = kotlin.i.b(new d(this));
        if (r15.q() == false) goto L6;
        kotlin.s0.w.d.l0.c.f r0 = kotlin.s0.w.d.l0.c.f.f18869j;
    L12:
        this.s = r0;
        if (r15.q() == false) goto L15;
    L27:
        e0 r1 = e0.f18860g;
    L28:
        this.t = r1;
        this.u = r15.getVisibility();
        if (r15.j() != null) goto L31;
    L33:
        boolean r2 = false;
    L34:
        this.v = r2;
        this.w = new a(this);
        if (r16 == null) goto L37;
        boolean r4 = true;
    L38:
        g r11 = new g(r10, this, r15, r4, null, 16, null);
        this.x = r11;
        this.y = y0.f19174e.a(this, r10.e(), r10.a().k().c(), new e(this));
        this.z = new kotlin.s0.w.d.l0.k.w.f(r11);
        this.A = new k(r10, r15, this);
        this.B = kotlin.s0.w.d.l0.e.a.l0.e.a(r10, r15);
        this.C = r10.e().d(new b(this));
        return;
    L37:
        r4 = false;
        goto L38
    L31:
        if (r15.Q() == true) goto L33;
        r2 = true;
        goto L34
    L15:
        if (r15.A() == true) goto L27;
        e0.a r3 = e0.f18859f;
        boolean r5 = r15.E();
        if (r15.E() == false) goto L20;
    L25:
        boolean r6 = true;
    L26:
        r1 = r3.a(r5, r6, !r15.isFinal());
        goto L28
    L20:
        if (r15.isAbstract() == true) goto L25;
        if (r15.H() == true) goto L25;
        r6 = false;
        goto L26
    L6:
        if (r15.H() == false) goto L9;
        r0 = kotlin.s0.w.d.l0.c.f.f18866g;
        goto L12
    L9:
        if (r15.A() == false) goto L11;
        r0 = kotlin.s0.w.d.l0.c.f.f18867h;
        goto L12
    L11:
        r0 = kotlin.s0.w.d.l0.c.f.f18865f;
        goto L12
    }

    public /* synthetic */ f(kotlin.s0.w.d.l0.e.a.l0.g r1, kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.e.a.n0.g r3, kotlin.s0.w.d.l0.c.e r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.e L0(f r0) {
        return r0.p;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g M0(f r0) {
        return r0.q;
    }

    public static final /* synthetic */ g N0(f r0) {
        return r0.x;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean B() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.a, kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h D0() {
        return T0();
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public Collection<kotlin.s0.w.d.l0.c.e> H() {
        if (this.t != e0.f18861h) goto L15;
        kotlin.s0.w.d.l0.e.a.l0.m.a r0 = kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, null, 3, null);
        Collection<kotlin.s0.w.d.l0.e.a.n0.j> r1 = this.o.N();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L21;
        kotlin.s0.w.d.l0.c.h r4 = this.q.g().o((kotlin.s0.w.d.l0.e.a.n0.j) r3.next(), r0).O0().d();
        if ((r4 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L10;
        kotlin.s0.w.d.l0.c.e r5 = (kotlin.s0.w.d.l0.c.e) r4;
    L11:
        if (r5 == null) goto L6;
        r2.add(r5);
        goto L6
    L10:
        r5 = null;
        goto L11
    L21:
        return r.s0(r2, new c());
    L15:
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean I() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r1) {
        return U0(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean J0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.i
    public boolean M() {
        return this.v;
    }

    public final f O0(kotlin.s0.w.d.l0.e.a.j0.g r4, kotlin.s0.w.d.l0.c.e r5) {
        o.f(r4, "javaResolverCache");
        kotlin.s0.w.d.l0.e.a.l0.g r1 = this.q;
        kotlin.s0.w.d.l0.e.a.l0.g r6 = kotlin.s0.w.d.l0.e.a.l0.a.i(r1, r1.a().x(r4));
        kotlin.s0.w.d.l0.c.m r2 = c();
        o.e(r2, "containingDeclaration");
        return new f(r6, r2, this.o, r5);
    }

    public List<kotlin.s0.w.d.l0.c.d> P0() {
        return this.x.w0().invoke();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.d Q() {
        return null;
    }

    public final kotlin.s0.w.d.l0.e.a.n0.g Q0() {
        return this.o;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h R() {
        return this.A;
    }

    public final List<kotlin.s0.w.d.l0.e.a.n0.a> R0() {
        return (List) this.r.getValue();
    }

    public final kotlin.s0.w.d.l0.e.a.l0.g S0() {
        return this.n;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.e T() {
        return null;
    }

    public g T0() {
        kotlin.s0.w.d.l0.k.w.h r1 = super.D0();
        o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (g) r1;
    }

    protected g U0(kotlin.s0.w.d.l0.n.t1.g r2) {
        o.f(r2, "kotlinTypeRefiner");
        return (g) this.y.c(r2);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        return this.B;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public u getVisibility() {
        if (o.a(this.u, t.f19159a) == false) goto L8;
        if (this.o.j() != null) goto L8;
        u r2 = kotlin.s0.w.d.l0.e.a.r.f19635a;
        o.e(r2, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return r2;
    L8:
        return i0.c(this.u);
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.f i() {
        return this.s;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public e1 k() {
        return this.w;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.d0
    public e0 l() {
        return this.t;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ Collection m() {
        return P0();
    }

    public String toString() {
        return "Lazy Java class " + kotlin.s0.w.d.l0.k.t.a.i(this);
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.i
    public List<f1> u() {
        return this.C.invoke();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean x() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.a, kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h y0() {
        return this.z;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public h1<m0> z0() {
        return null;
    }
}
