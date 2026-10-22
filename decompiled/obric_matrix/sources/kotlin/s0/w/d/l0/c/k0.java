package kotlin.s0.w.d.l0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.n f18878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f18879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.c, l0> f18880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<a, e> f18881d;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.b f18882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Integer> f18883b;

        public a(kotlin.s0.w.d.l0.g.b r2, List<Integer> r3) {
            kotlin.n0.d.o.f(r2, "classId");
            kotlin.n0.d.o.f(r3, "typeParametersCount");
            this.f18882a = r2;
            this.f18883b = r3;
        }

        public final kotlin.s0.w.d.l0.g.b a() {
            return this.f18882a;
        }

        public final List<Integer> b() {
            return this.f18883b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (kotlin.n0.d.o.a(this.f18882a, r6.f18882a) == true) goto L12;
            return false;
        L12:
            if (kotlin.n0.d.o.a(this.f18883b, r6.f18883b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f18882a.hashCode() * 31) + this.f18883b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.f18882a + ", typeParametersCount=" + this.f18883b + ')';
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.c.q1.g {
        private final boolean n;
        private final List<f1> o;
        private final kotlin.s0.w.d.l0.n.l p;

        public b(kotlin.s0.w.d.l0.m.n r8, m r9, kotlin.s0.w.d.l0.g.f r10, boolean r11, int r12) {
            kotlin.n0.d.o.f(r8, "storageManager");
            kotlin.n0.d.o.f(r9, "container");
            kotlin.n0.d.o.f(r10, "name");
            super(r8, r9, r10, a1.f18847a, false);
            this.n = r11;
            kotlin.r0.d r13 = kotlin.r0.e.m(0, r12);
            ArrayList r14 = new ArrayList(kotlin.i0.r.q(r13, 10));
            Iterator<Integer> r15 = r13.iterator();
        L4:
            if (r15.hasNext() == false) goto L6;
            int r5 = ((kotlin.i0.j0) r15).nextInt();
            kotlin.s0.w.d.l0.c.o1.g r1 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
            r1 r3 = r1.f21065h;
            StringBuilder r16 = new StringBuilder();
            r16.append('T');
            r16.append(r5);
            r14.add(kotlin.s0.w.d.l0.c.q1.k0.S0(this, r1, false, r3, kotlin.s0.w.d.l0.g.f.k(r16.toString()), r5, r8));
            goto L4
        L6:
            this.o = r14;
            this.p = new kotlin.s0.w.d.l0.n.l(this, g1.d(this), kotlin.i0.t0.a(kotlin.s0.w.d.l0.k.t.a.l(this).o().i()), r8);
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public boolean B() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.c.d0
        public boolean E0() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public Collection<e> H() {
            return kotlin.i0.r.g();
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public boolean I() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.c.q1.t
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r1) {
            return N0(r1);
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public boolean J0() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.c.d0
        public boolean L() {
            return false;
        }

        public kotlin.s0.w.d.l0.k.w.h.b L0() {
            return kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        }

        @Override // kotlin.s0.w.d.l0.c.i
        public boolean M() {
            return this.n;
        }

        public kotlin.s0.w.d.l0.n.l M0() {
            return this.p;
        }

        protected kotlin.s0.w.d.l0.k.w.h.b N0(kotlin.s0.w.d.l0.n.t1.g r1) {
            kotlin.n0.d.o.f(r1, "kotlinTypeRefiner");
            return kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public kotlin.s0.w.d.l0.c.d Q() {
            return null;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h R() {
            return L0();
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public e T() {
            return null;
        }

        @Override // kotlin.s0.w.d.l0.c.o1.a
        public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
            return kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
        }

        @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
        public u getVisibility() {
            u r1 = t.f19163e;
            kotlin.n0.d.o.e(r1, "PUBLIC");
            return r1;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public f i() {
            return f.f18865f;
        }

        @Override // kotlin.s0.w.d.l0.c.q1.g, kotlin.s0.w.d.l0.c.d0
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.c.h
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.e1 k() {
            return M0();
        }

        @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.d0
        public e0 l() {
            return e0.f18860g;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public Collection<kotlin.s0.w.d.l0.c.d> m() {
            return kotlin.i0.t0.b();
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.i
        public List<f1> u() {
            return this.o;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public boolean x() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.c.e
        public h1<kotlin.s0.w.d.l0.n.m0> z0() {
            return null;
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<a, e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k0 f18884f;

        c(k0 r1) {
            this.f18884f = r1;
            super(1);
        }

        public final e a(a r9) {
            kotlin.n0.d.o.f(r9, "<name for destructuring parameter 0>");
            kotlin.s0.w.d.l0.g.b r0 = r9.a();
            List<Integer> r10 = r9.b();
            if (r0.k() == true) goto L17;
            kotlin.s0.w.d.l0.g.b r1 = r0.g();
            if (r1 == null) goto L9;
            m r2 = this.f18884f.d(r1, kotlin.i0.r.L(r10, 1));
            if (r2 == null) goto L9;
        L10:
            m r4 = r2;
            boolean r6 = r0.l();
            kotlin.s0.w.d.l0.m.n r3 = k0.c(this.f18884f);
            kotlin.s0.w.d.l0.g.f r5 = r0.j();
            kotlin.n0.d.o.e(r5, "classId.shortClassName");
            Integer r8 = (Integer) kotlin.i0.r.R(r10);
            if (r8 == null) goto L13;
            int r11 = r8.intValue();
        L15:
            return new b(r3, r4, r5, r6, r11);
        L13:
            r11 = 0;
        L9:
            kotlin.s0.w.d.l0.m.g r7 = k0.b(this.f18884f);
            kotlin.s0.w.d.l0.g.c r12 = r0.h();
            kotlin.n0.d.o.e(r12, "classId.packageFqName");
            r2 = (g) r7.invoke(r12);
            goto L10
        L17:
            throw new UnsupportedOperationException("Unresolved local class: " + r0);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e invoke(a r1) {
            return a(r1);
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, l0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k0 f18885f;

        d(k0 r1) {
            this.f18885f = r1;
            super(1);
        }

        public final l0 a(kotlin.s0.w.d.l0.g.c r2) {
            kotlin.n0.d.o.f(r2, "fqName");
            return new kotlin.s0.w.d.l0.c.q1.m(k0.a(this.f18885f), r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ l0 invoke(kotlin.s0.w.d.l0.g.c r1) {
            return a(r1);
        }
    }

    public k0(kotlin.s0.w.d.l0.m.n r2, h0 r3) {
        kotlin.n0.d.o.f(r2, "storageManager");
        kotlin.n0.d.o.f(r3, "module");
        this.f18878a = r2;
        this.f18879b = r3;
        this.f18880c = r2.h(new d(this));
        this.f18881d = r2.h(new c(this));
    }

    public static final /* synthetic */ h0 a(k0 r0) {
        return r0.f18879b;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.m.g b(k0 r0) {
        return r0.f18880c;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.m.n c(k0 r0) {
        return r0.f18878a;
    }

    public final e d(kotlin.s0.w.d.l0.g.b r2, List<Integer> r3) {
        kotlin.n0.d.o.f(r2, "classId");
        kotlin.n0.d.o.f(r3, "typeParametersCount");
        return this.f18881d.invoke(new a(r2, r3));
    }
}
