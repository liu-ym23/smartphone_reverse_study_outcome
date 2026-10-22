package kotlin.s0.w.d.l0.e.a.l0.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.g0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.l0.e.a.l0.k;
import kotlin.s0.w.d.l0.e.a.n0.a0;
import kotlin.s0.w.d.l0.e.a.n0.c0;
import kotlin.s0.w.d.l0.e.a.n0.i;
import kotlin.s0.w.d.l0.e.a.n0.j;
import kotlin.s0.w.d.l0.e.a.n0.v;
import kotlin.s0.w.d.l0.e.a.n0.x;
import kotlin.s0.w.d.l0.e.a.n0.y;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.b1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.h0;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.l0.g f19496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f19497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f19498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f19499d;

    static final class a extends q implements kotlin.n0.c.a<e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f19500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f1 f19501g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ j f19502h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.m.a f19503i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e1 f19504j;

        a(c r1, f1 r2, j r3, kotlin.s0.w.d.l0.e.a.l0.m.a r4, e1 r5) {
            this.f19500f = r1;
            this.f19501g = r2;
            this.f19502h = r3;
            this.f19503i = r4;
            this.f19504j = r5;
            super(0);
        }

        public final e0 a() {
            g r0 = c.a(this.f19500f);
            f1 r1 = this.f19501g;
            boolean r2 = this.f19502h.w();
            kotlin.s0.w.d.l0.e.a.l0.m.a r3 = this.f19503i;
            h r4 = this.f19504j.d();
            if (r4 == null) goto L5;
            m0 r5 = r4.s();
        L6:
            e0 r6 = r0.c(r1, r2, r3.h(r5));
            o.e(r6, "typeParameterUpperBoundE…efaultType)\n            )");
            return r6;
        L5:
            r5 = null;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ e0 invoke() {
            return a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(kotlin.s0.w.d.l0.e.a.l0.g r2, k r3) {
        o.f(r2, "c");
        o.f(r3, "typeParameterResolver");
        this.f19496a = r2;
        this.f19497b = r3;
        g r4 = new g(null, 1, 0 == true ? 1 : 0);
        this.f19498c = r4;
        this.f19499d = new e(r4);
    }

    public static final /* synthetic */ g a(c r0) {
        return r0.f19498c;
    }

    private final boolean b(j r1, kotlin.s0.w.d.l0.c.e r2) {
        if (a0.a((x) r.d0(r1.F())) == true) goto L5;
        return false;
    L5:
        List<f1> r0 = kotlin.s0.w.d.l0.b.q.d.f18786a.b(r2).k().getParameters();
        o.e(r0, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        f1 r3 = (f1) r.d0(r0);
        if (r3 == null) goto L14;
        r1 r4 = r3.n();
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4 == r1.f21067j) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    private final List<g1> c(j r7, kotlin.s0.w.d.l0.e.a.l0.m.a r8, e1 r9) {
        if (r7.w() == false) goto L5;
    L10:
        boolean r0 = true;
    L11:
        List<f1> r4 = r9.getParameters();
        o.e(r4, "constructor.parameters");
        if (r0 == false) goto L16;
        return d(r7, r4, r9, r8);
    L16:
        if (r4.size() == r7.F().size()) goto L23;
        ArrayList r6 = new ArrayList(r.q(r4, 10));
        Iterator<T> r10 = r4.iterator();
    L19:
        if (r10.hasNext() == false) goto L22;
        f1 r11 = (f1) r10.next();
        kotlin.s0.w.d.l0.n.u1.j r1 = kotlin.s0.w.d.l0.n.u1.j.b0;
        String r12 = r11.getName().b();
        o.e(r12, "p.name.asString()");
        r6.add(new i1(kotlin.s0.w.d.l0.n.u1.k.d(r1, new String[]{r12})));
        goto L19
    L22:
        return r.z0(r6);
    L23:
        Iterable r13 = r.F0(r7.F());
        ArrayList r14 = new ArrayList(r.q(r13, 10));
        Iterator r15 = r13.iterator();
    L25:
        if (r15.hasNext() == false) goto L28;
        g0 r16 = (g0) r15.next();
        int r2 = r16.a();
        x r17 = (x) r16.b();
        r4.size();
        f1 r3 = r4.get(r2);
        kotlin.s0.w.d.l0.e.a.l0.m.a r5 = d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, null, 3, null);
        o.e(r3, "parameter");
        r14.add(p(r17, r5, r3));
        goto L25
    L28:
        return r.z0(r14);
    L5:
        if (r7.F().isEmpty() == false) goto L9;
        List<f1> r18 = r9.getParameters();
        o.e(r18, "constructor.parameters");
        if ((!r18.isEmpty()) == true) goto L10;
    L9:
        r0 = false;
        goto L11
    }

    private final List<g1> d(j r12, List<? extends f1> r13, e1 r14, kotlin.s0.w.d.l0.e.a.l0.m.a r15) {
        ArrayList r0 = new ArrayList(r.q(r13, 10));
        Iterator<T> r16 = r13.iterator();
    L4:
        if (r16.hasNext() == false) goto L14;
        f1 r1 = (f1) r16.next();
        if (kotlin.s0.w.d.l0.n.x1.a.k(r1, null, r15.f()) == false) goto L8;
        g1 r2 = d.b(r1, r15);
    L13:
        r0.add(r2);
        goto L4
    L8:
        h0 r8 = new h0(this.f19496a.e(), new a(this, r1, r12, r15, r14));
        e r3 = this.f19499d;
        if (r12.w() == false) goto L11;
        kotlin.s0.w.d.l0.e.a.l0.m.a r4 = r15;
    L12:
        r2 = r3.j(r1, r4, r8);
        goto L13
    L11:
        r4 = r15.i(b.f19492f);
        goto L12
    L14:
        return r0;
    }

    private final m0 e(j r9, kotlin.s0.w.d.l0.e.a.l0.m.a r10, m0 r11) {
        if (r11 == null) goto L5;
        a1 r0 = r11.N0();
        if (r0 == null) goto L5;
    L6:
        a1 r1 = r0;
        e1 r2 = f(r9, r10);
        e1 r3 = null;
        if (r2 != null) goto L9;
        return null;
    L9:
        boolean r4 = i(r10);
        if (r11 == null) goto L13;
        r3 = r11.O0();
    L13:
        if (o.a(r3, r2) == false) goto L20;
        if (r9.w() == true) goto L20;
        if (r4 == false) goto L20;
        return r11.V0(true);
    L20:
        return f0.i(r1, r2, c(r9, r10, r2), r4, null, 16, null);
    L5:
        r0 = b1.b(new kotlin.s0.w.d.l0.e.a.l0.d(this.f19496a, r9, false, 4, null));
        goto L6
    }

    private final e1 f(j r4, kotlin.s0.w.d.l0.e.a.l0.m.a r5) {
        i r0 = r4.d();
        if (r0 != null) goto L7;
        return g(r4);
    L7:
        if ((r0 instanceof kotlin.s0.w.d.l0.e.a.n0.g) == false) goto L20;
        kotlin.s0.w.d.l0.e.a.n0.g r1 = (kotlin.s0.w.d.l0.e.a.n0.g) r0;
        kotlin.s0.w.d.l0.g.c r2 = r1.e();
        if (r2 == null) goto L18;
        kotlin.s0.w.d.l0.c.e r6 = j(r4, r5, r2);
        if (r6 != null) goto L13;
        r6 = this.f19496a.a().n().a(r1);
    L13:
        if (r6 == null) goto L29;
        e1 r7 = r6.k();
        if (r7 == null) goto L29;
        return r7;
    L29:
        return g(r4);
    L18:
        throw new AssertionError("Class type should have a FQ name: " + r0);
    L20:
        if ((r0 instanceof y) == false) goto L27;
        f1 r3 = this.f19497b.a((y) r0);
        if (r3 != null) goto L30;
        return null;
    L30:
        return r3.k();
    L27:
        throw new IllegalStateException("Unknown classifier kind: " + r0);
    }

    private final e1 g(j r2) {
        kotlin.s0.w.d.l0.g.b r3 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c(r2.x()));
        o.e(r3, "topLevel(FqName(javaType.classifierQualifiedName))");
        e1 r1 = this.f19496a.a().b().d().q().d(r3, r.d(0)).k();
        o.e(r1, "c.components.deserialize…istOf(0)).typeConstructor");
        return r1;
    }

    private final boolean h(r1 r3, f1 r4) {
        if (r4.n() != r1.f21065h) goto L6;
        return false;
    L6:
        if (r3 == r4.n()) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean i(kotlin.s0.w.d.l0.e.a.l0.m.a r3) {
        if (r3.d() != b.f19494h) goto L6;
        return false;
    L6:
        if (r3.g() == false) goto L8;
        return false;
    L8:
        if (r3.e() == kotlin.s0.w.d.l0.e.a.j0.k.f19332f) goto L12;
        return true;
    L12:
        return false;
    }

    private final kotlin.s0.w.d.l0.c.e j(j r8, kotlin.s0.w.d.l0.e.a.l0.m.a r9, kotlin.s0.w.d.l0.g.c r10) {
        if (r9.g() == true) goto L5;
    L8:
        kotlin.s0.w.d.l0.b.q.d r6 = kotlin.s0.w.d.l0.b.q.d.f18786a;
        kotlin.s0.w.d.l0.c.e r11 = kotlin.s0.w.d.l0.b.q.d.f(r6, r10, this.f19496a.d().o(), null, 4, null);
        if (r11 != null) goto L13;
        return null;
    L13:
        if (r6.d(r11) == true) goto L15;
    L22:
        return r11;
    L15:
        if (r9.d() == b.f19494h) goto L21;
        if (r9.e() == kotlin.s0.w.d.l0.e.a.j0.k.f19332f) goto L21;
        if (b(r8, r11) == false) goto L22;
    L21:
        return r6.b(r11);
    L5:
        if (o.a(r10, d.a()) == false) goto L8;
        return this.f19496a.a().p().c();
    }

    public static /* synthetic */ e0 l(c r0, kotlin.s0.w.d.l0.e.a.n0.f r1, kotlin.s0.w.d.l0.e.a.l0.m.a r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.k(r1, r2, r3);
    }

    private final e0 m(j r4, kotlin.s0.w.d.l0.e.a.l0.m.a r5) {
        if (r5.g() == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean r1 = r4.w();
        if (r1 == true) goto L16;
        if (r0 == true) goto L16;
        m0 r3 = e(r4, r5, null);
        if (r3 == null) goto L15;
        return r3;
    L15:
        return n(r4);
    L16:
        m0 r2 = e(r4, r5.i(b.f19494h), null);
        if (r2 == null) goto L19;
        m0 r6 = e(r4, r5.i(b.f19493g), r2);
        if (r6 == null) goto L23;
        if (r1 == false) goto L27;
        return new f(r2, r6);
    L27:
        return f0.d(r2, r6);
    L23:
        return n(r4);
    L19:
        return n(r4);
    L5:
        if (r5.e() == kotlin.s0.w.d.l0.e.a.j0.k.f19332f) goto L7;
        r0 = true;
        goto L8
    }

    private static final kotlin.s0.w.d.l0.n.u1.h n(j r3) {
        return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.f21161k, new String[]{r3.o()});
    }

    private final g1 p(x r5, kotlin.s0.w.d.l0.e.a.l0.m.a r6, f1 r7) {
        if ((r5 instanceof c0) == false) goto L15;
        c0 r8 = (c0) r5;
        x r0 = r8.B();
        if (r8.J() == false) goto L7;
        r1 r9 = r1.f21067j;
    L8:
        if (r0 == null) goto L17;
        if (h(r9, r7) == true) goto L17;
        return kotlin.s0.w.d.l0.n.x1.a.e(o(r0, d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, null, 3, null)), r9, r7);
    L17:
        return d.b(r7, r6);
    L7:
        r9 = r1.f21066i;
        goto L8
    L15:
        return new i1(r1.f21065h, o(r5, r6));
    }

    public final e0 k(kotlin.s0.w.d.l0.e.a.n0.f r7, kotlin.s0.w.d.l0.e.a.l0.m.a r8, boolean r9) {
        o.f(r7, "arrayType");
        o.f(r8, "attr");
        x r0 = r7.n();
        if ((r0 instanceof v) == false) goto L5;
        v r1 = (v) r0;
    L6:
        if (r1 == null) goto L8;
        kotlin.s0.w.d.l0.b.i r2 = r1.b();
    L9:
        kotlin.s0.w.d.l0.e.a.l0.d r3 = new kotlin.s0.w.d.l0.e.a.l0.d(this.f19496a, r7, true);
        if (r2 == null) goto L16;
        m0 r6 = this.f19496a.d().o().O(r2);
        o.e(r6, "c.module.builtIns.getPri…KotlinType(primitiveType)");
        kotlin.s0.w.d.l0.n.x1.a.u(r6, kotlin.s0.w.d.l0.c.o1.g.f18919b.a(r.i0(r3, r6.getAnnotations())));
        if (r8.g() == false) goto L15;
        return r6;
    L15:
        return f0.d(r6, r6.V0(true));
    L16:
        e0 r10 = o(r0, d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, r8.g(), null, 2, null));
        if (r8.g() == false) goto L23;
        if (r9 == false) goto L20;
        r1 r11 = r1.f21067j;
    L21:
        m0 r12 = this.f19496a.d().o().m(r11, r10, r3);
        o.e(r12, "c.module.builtIns.getArr…mponentType, annotations)");
        return r12;
    L20:
        r11 = r1.f21065h;
        goto L21
    L23:
        m0 r13 = this.f19496a.d().o().m(r1.f21065h, r10, r3);
        o.e(r13, "c.module.builtIns.getArr…mponentType, annotations)");
        return f0.d(r13, this.f19496a.d().o().m(r1.f21067j, r10, r3).V0(true));
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final e0 o(x r8, kotlin.s0.w.d.l0.e.a.l0.m.a r9) {
        o.f(r9, "attr");
        if ((r8 instanceof v) == false) goto L10;
        kotlin.s0.w.d.l0.b.i r10 = ((v) r8).b();
        kotlin.s0.w.d.l0.b.h r7 = this.f19496a.d().o();
        if (r10 == null) goto L7;
        m0 r11 = r7.R(r10);
    L8:
        o.e(r11, "{\n                val pr…ns.unitType\n            }");
        return r11;
    L7:
        r11 = r7.Z();
        goto L8
    L10:
        if ((r8 instanceof j) == false) goto L13;
        return m((j) r8, r9);
    L13:
        if ((r8 instanceof kotlin.s0.w.d.l0.e.a.n0.f) == false) goto L16;
        return l(this, (kotlin.s0.w.d.l0.e.a.n0.f) r8, r9, false, 4, null);
    L16:
        if ((r8 instanceof c0) == false) goto L23;
        x r12 = ((c0) r8).B();
        if (r12 == null) goto L24;
        e0 r13 = o(r12, r9);
        if (r13 == null) goto L24;
        return r13;
    L24:
        m0 r14 = this.f19496a.d().o().y();
        o.e(r14, "c.module.builtIns.defaultBound");
        return r14;
    L23:
        if (r8 == null) goto L24;
        throw new UnsupportedOperationException("Unsupported type: " + r8);
    }
}
