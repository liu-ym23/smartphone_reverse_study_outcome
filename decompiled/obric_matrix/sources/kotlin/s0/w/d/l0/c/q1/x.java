package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.s0.w.d.l0.c.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends j implements kotlin.s0.w.d.l0.c.h0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.n f19064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.b.h f19065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.c.g0<?>, Object> f19066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a0 f19067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private v f19068l;
    private kotlin.s0.w.d.l0.c.m0 m;
    private boolean n;
    private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.c, q0> o;
    private final kotlin.h p;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<i> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f19069f;

        a(x r1) {
            this.f19069f = r1;
            super(0);
        }

        public final i a() {
            v r0 = x.A0(this.f19069f);
            x r1 = this.f19069f;
            if (r0 == null) goto L15;
            List<x> r2 = r0.a();
            this.f19069f.P0();
            r2.contains(this.f19069f);
            Iterator<T> r3 = r2.iterator();
        L6:
            if (r3.hasNext() == false) goto L8;
            x.O0((x) r3.next());
            goto L6
        L8:
            ArrayList r4 = new ArrayList(kotlin.i0.r.q(r2, 10));
            Iterator<T> r5 = r2.iterator();
        L10:
            if (r5.hasNext() == false) goto L13;
            kotlin.s0.w.d.l0.c.m0 r6 = x.L0((x) r5.next());
            kotlin.n0.d.o.c(r6);
            r4.add(r6);
            goto L10
        L13:
            return new i(r4, "CompositeProvider@ModuleDescriptor for " + this.f19069f.getName());
        L15:
            throw new AssertionError("Dependencies of module " + x.F0(r1) + " were not set before querying module content");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ i invoke() {
            return a();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, q0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f19070f;

        b(x r1) {
            this.f19070f = r1;
            super(1);
        }

        public final q0 a(kotlin.s0.w.d.l0.g.c r3) {
            kotlin.n0.d.o.f(r3, "fqName");
            a0 r0 = x.M0(this.f19070f);
            x r2 = this.f19070f;
            return r0.a(r2, r3, x.N0(r2));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ q0 invoke(kotlin.s0.w.d.l0.g.c r1) {
            return a(r1);
        }
    }

    public x(kotlin.s0.w.d.l0.g.f r11, kotlin.s0.w.d.l0.m.n r12, kotlin.s0.w.d.l0.b.h r13, kotlin.s0.w.d.l0.h.a r14) {
        kotlin.n0.d.o.f(r11, "moduleName");
        kotlin.n0.d.o.f(r12, "storageManager");
        kotlin.n0.d.o.f(r13, "builtIns");
        this(r11, r12, r13, r14, null, null, 48, null);
    }

    public x(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.m.n r2, kotlin.s0.w.d.l0.b.h r3, kotlin.s0.w.d.l0.h.a r4, Map<kotlin.s0.w.d.l0.c.g0<?>, ? extends Object> r5, kotlin.s0.w.d.l0.g.f r6) {
        kotlin.n0.d.o.f(r1, "moduleName");
        kotlin.n0.d.o.f(r2, "storageManager");
        kotlin.n0.d.o.f(r3, "builtIns");
        kotlin.n0.d.o.f(r5, "capabilities");
        super(kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), r1);
        this.f19064h = r2;
        this.f19065i = r3;
        if (r1.l() == false) goto L10;
        this.f19066j = r5;
        a0 r7 = (a0) I0(a0.f18959a.a());
        if (r7 != null) goto L7;
        r7 = a0.b.f18962b;
    L7:
        this.f19067k = r7;
        this.n = true;
        this.o = r2.h(new b(this));
        this.p = kotlin.i.b(new a(this));
        return;
    L10:
        throw new IllegalArgumentException("Module name must be special: " + r1);
    }

    public /* synthetic */ x(kotlin.s0.w.d.l0.g.f r10, kotlin.s0.w.d.l0.m.n r11, kotlin.s0.w.d.l0.b.h r12, kotlin.s0.w.d.l0.h.a r13, Map r14, kotlin.s0.w.d.l0.g.f r15, int r16, kotlin.n0.d.g r17) {
        if ((r16 & 8) == 0) goto L5;
        kotlin.s0.w.d.l0.h.a r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        Map r7 = kotlin.i0.m0.h();
    L11:
        if ((r16 & 32) == 0) goto L13;
        kotlin.s0.w.d.l0.g.f r8 = null;
    L14:
        this(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    public static final /* synthetic */ v A0(x r0) {
        return r0.f19068l;
    }

    public static final /* synthetic */ String F0(x r0) {
        return r0.Q0();
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.m0 L0(x r0) {
        return r0.m;
    }

    public static final /* synthetic */ a0 M0(x r0) {
        return r0.f19067k;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.m.n N0(x r0) {
        return r0.f19064h;
    }

    public static final /* synthetic */ boolean O0(x r0) {
        return r0.U0();
    }

    private final String Q0() {
        String r1 = getName().toString();
        kotlin.n0.d.o.e(r1, "name.toString()");
        return r1;
    }

    private final i S0() {
        return (i) this.p.getValue();
    }

    private final boolean U0() {
        if (this.m == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public <T> T I0(kotlin.s0.w.d.l0.c.g0<T> r2) {
        kotlin.n0.d.o.f(r2, "capability");
        T r1 = (T) this.f19066j.get(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return (R) kotlin.s0.w.d.l0.c.h0.a.a(this, r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public q0 N(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        P0();
        return this.o.invoke(r2);
    }

    public void P0() {
        if (V0() == true) goto L6;
        kotlin.s0.w.d.l0.c.b0.a(this);
        return;
    }

    public final kotlin.s0.w.d.l0.c.m0 R0() {
        P0();
        return S0();
    }

    public final void T0(kotlin.s0.w.d.l0.c.m0 r2) {
        kotlin.n0.d.o.f(r2, "providerForModuleContent");
        U0();
        this.m = r2;
    }

    public boolean V0() {
        return this.n;
    }

    public final void W0(List<x> r2) {
        kotlin.n0.d.o.f(r2, "descriptors");
        X0(r2, t0.b());
    }

    public final void X0(List<x> r4, Set<x> r5) {
        kotlin.n0.d.o.f(r4, "descriptors");
        kotlin.n0.d.o.f(r5, "friends");
        Y0(new w(r4, r5, kotlin.i0.r.g(), t0.b()));
    }

    public final void Y0(v r2) {
        kotlin.n0.d.o.f(r2, "dependencies");
        v r0 = this.f19068l;
        this.f19068l = r2;
    }

    public final void Z0(x... r2) {
        kotlin.n0.d.o.f(r2, "descriptors");
        W0(kotlin.i0.i.e0(r2));
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.m c() {
        return kotlin.s0.w.d.l0.c.h0.a.b(this);
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public boolean e0(kotlin.s0.w.d.l0.c.h0 r3) {
        kotlin.n0.d.o.f(r3, "targetModule");
        if (kotlin.n0.d.o.a(this, r3) == false) goto L5;
        return true;
    L5:
        v r0 = this.f19068l;
        kotlin.n0.d.o.c(r0);
        if (kotlin.i0.r.J(r0.b(), r3) == false) goto L9;
        return true;
    L9:
        if (t0().contains(r3) == false) goto L12;
        return true;
    L12:
        if (r3.t0().contains(this) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public kotlin.s0.w.d.l0.b.h o() {
        return this.f19065i;
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public Collection<kotlin.s0.w.d.l0.g.c> p(kotlin.s0.w.d.l0.g.c r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        kotlin.n0.d.o.f(r2, "fqName");
        kotlin.n0.d.o.f(r3, "nameFilter");
        P0();
        return R0().p(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public List<kotlin.s0.w.d.l0.c.h0> t0() {
        v r0 = this.f19068l;
        if (r0 == null) goto L7;
        return r0.c();
    L7:
        throw new AssertionError("Dependencies of module " + Q0() + " were not set");
    }
}
