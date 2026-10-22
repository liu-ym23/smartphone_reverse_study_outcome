package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.q0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends p implements i0 {
    public static final a N = null;
    static final /* synthetic */ kotlin.s0.l<Object>[] O = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.n f19005J;
    private final e1 K;
    private final kotlin.s0.w.d.l0.m.j L;
    private kotlin.s0.w.d.l0.c.d M;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static final /* synthetic */ l1 a(a r0, e1 r1) {
            return r0.c(r1);
        }

        private final l1 c(e1 r1) {
            if (r1.r() != null) goto L7;
            return null;
        L7:
            return l1.f(r1.V());
        }

        public final i0 b(kotlin.s0.w.d.l0.m.n r13, e1 r14, kotlin.s0.w.d.l0.c.d r15) {
            kotlin.n0.d.o.f(r13, "storageManager");
            kotlin.n0.d.o.f(r14, "typeAliasDescriptor");
            kotlin.n0.d.o.f(r15, "constructor");
            l1 r12 = c(r14);
            x0 r0 = null;
            if (r12 != null) goto L5;
            return null;
        L5:
            kotlin.s0.w.d.l0.c.d r10 = r15.d(r12);
            if (r10 != null) goto L8;
            return null;
        L8:
            kotlin.s0.w.d.l0.c.o1.g r6 = r15.getAnnotations();
            kotlin.s0.w.d.l0.c.b.a r7 = r15.i();
            kotlin.n0.d.o.e(r7, "constructor.kind");
            a1 r8 = r14.getSource();
            kotlin.n0.d.o.e(r8, "typeAliasDescriptor.source");
            j0 r11 = new j0(r13, r14, r10, null, r6, r7, r8, null);
            List<j1> r9 = p.P0(r11, r15.h(), r12);
            if (r9 != null) goto L11;
            return null;
        L11:
            kotlin.s0.w.d.l0.n.m0 r16 = kotlin.s0.w.d.l0.n.b0.c(r10.getReturnType().R0());
            kotlin.s0.w.d.l0.n.m0 r1 = r14.s();
            kotlin.n0.d.o.e(r1, "typeAliasDescriptor.defaultType");
            kotlin.s0.w.d.l0.n.m0 r17 = q0.j(r16, r1);
            x0 r18 = r15.f0();
            if (r18 == null) goto L14;
            r0 = kotlin.s0.w.d.l0.k.c.h(r11, r12.n(r18.b(), r1.f21065h), kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        L14:
            x0 r2 = r0;
            kotlin.s0.w.d.l0.c.e r19 = r14.r();
            if (r19 == null) goto L21;
            List<x0> r110 = r15.r0();
            kotlin.n0.d.o.e(r110, "constructor.contextReceiverParameters");
            ArrayList r3 = new ArrayList(kotlin.i0.r.q(r110, 10));
            Iterator<T> r111 = r110.iterator();
        L18:
            if (r111.hasNext() == false) goto L20;
            r3.add(kotlin.s0.w.d.l0.k.c.c(r19, r12.n(((x0) r111.next()).b(), r1.f21065h), kotlin.s0.w.d.l0.c.o1.g.f18919b.b()));
            goto L18
        L20:
            List<x0> r4 = r3;
        L22:
            r11.S0(r2, null, r4, r14.u(), r9, r17, kotlin.s0.w.d.l0.c.e0.f18860g, r14.getVisibility());
            return r11;
        L21:
            r4 = kotlin.i0.r.g();
            goto L22
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<j0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j0 f19006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.d f19007g;

        b(j0 r1, kotlin.s0.w.d.l0.c.d r2) {
            this.f19006f = r1;
            this.f19007g = r2;
            super(0);
        }

        public final j0 a() {
            kotlin.s0.w.d.l0.m.n r1 = this.f19006f.h0();
            e1 r2 = this.f19006f.p1();
            kotlin.s0.w.d.l0.c.d r3 = this.f19007g;
            j0 r4 = this.f19006f;
            kotlin.s0.w.d.l0.c.o1.g r5 = r3.getAnnotations();
            kotlin.s0.w.d.l0.c.b.a r6 = this.f19007g.i();
            kotlin.n0.d.o.e(r6, "underlyingConstructorDescriptor.kind");
            a1 r7 = this.f19006f.p1().getSource();
            kotlin.n0.d.o.e(r7, "typeAliasDescriptor.source");
            j0 r9 = new j0(r1, r2, r3, r4, r5, r6, r7, null);
            j0 r0 = this.f19006f;
            kotlin.s0.w.d.l0.c.d r10 = this.f19007g;
            l1 r8 = a.a(j0.N, r0.p1());
            x0 r11 = null;
            if (r8 != null) goto L5;
            return null;
        L5:
            x0 r12 = r10.f0();
            if (r12 == null) goto L8;
            r11 = r12.d(r8);
        L8:
            List<x0> r13 = r10.r0();
            kotlin.n0.d.o.e(r13, "underlyingConstructorDes…contextReceiverParameters");
            ArrayList r14 = new ArrayList(kotlin.i0.r.q(r13, 10));
            Iterator<T> r15 = r13.iterator();
        L10:
            if (r15.hasNext() == false) goto L12;
            r14.add(((x0) r15.next()).d(r8));
            goto L10
        L12:
            r9.S0(null, r11, r14, r0.p1().u(), r0.h(), r0.getReturnType(), kotlin.s0.w.d.l0.c.e0.f18860g, r0.p1().getVisibility());
            return r9;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ j0 invoke() {
            return a();
        }
    }

    static {
        O = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
        N = new a(null);
    }

    private j0(kotlin.s0.w.d.l0.m.n r8, e1 r9, kotlin.s0.w.d.l0.c.d r10, i0 r11, kotlin.s0.w.d.l0.c.o1.g r12, kotlin.s0.w.d.l0.c.b.a r13, a1 r14) {
        super(r9, r11, r12, kotlin.s0.w.d.l0.g.h.f20279f, r13, r14);
        this.f19005J = r8;
        this.K = r9;
        W0(p1().E0());
        this.L = r8.f(new b(this, r10));
        this.M = r10;
    }

    public /* synthetic */ j0(kotlin.s0.w.d.l0.m.n r1, e1 r2, kotlin.s0.w.d.l0.c.d r3, i0 r4, kotlin.s0.w.d.l0.c.o1.g r5, kotlin.s0.w.d.l0.c.b.a r6, a1 r7, kotlin.n0.d.g r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    @Override // kotlin.s0.w.d.l0.c.l
    public kotlin.s0.w.d.l0.c.e A() {
        kotlin.s0.w.d.l0.c.e r1 = p0().A();
        kotlin.n0.d.o.e(r1, "underlyingConstructorDescriptor.constructedClass");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return o1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y L0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return l1(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public /* bridge */ /* synthetic */ p M0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        return m1(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return o1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b a() {
        return o1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return o1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y a() {
        return o1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.i c() {
        return n1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m c() {
        return n1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.l d(l1 r1) {
        return q1(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return q1(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y d(l1 r1) {
        return q1(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.a
    public kotlin.s0.w.d.l0.n.e0 getReturnType() {
        kotlin.s0.w.d.l0.n.e0 r0 = super.getReturnType();
        kotlin.n0.d.o.c(r0);
        return r0;
    }

    public final kotlin.s0.w.d.l0.m.n h0() {
        return this.f19005J;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.b
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b k0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return l1(r1, r2, r3, r4, r5);
    }

    public i0 l1(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.c.e0 r3, kotlin.s0.w.d.l0.c.u r4, kotlin.s0.w.d.l0.c.b.a r5, boolean r6) {
        kotlin.n0.d.o.f(r2, "newOwner");
        kotlin.n0.d.o.f(r3, "modality");
        kotlin.n0.d.o.f(r4, "visibility");
        kotlin.n0.d.o.f(r5, "kind");
        kotlin.s0.w.d.l0.c.y r1 = t().o(r2).c(r3).n(r4).q(r5).i(r6).build();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) r1;
    }

    protected j0 m1(kotlin.s0.w.d.l0.c.m r9, kotlin.s0.w.d.l0.c.y r10, kotlin.s0.w.d.l0.c.b.a r11, kotlin.s0.w.d.l0.g.f r12, kotlin.s0.w.d.l0.c.o1.g r13, a1 r14) {
        kotlin.n0.d.o.f(r9, "newOwner");
        kotlin.n0.d.o.f(r11, "kind");
        kotlin.n0.d.o.f(r13, "annotations");
        kotlin.n0.d.o.f(r14, "source");
        kotlin.s0.w.d.l0.c.b.a r6 = kotlin.s0.w.d.l0.c.b.a.f18848f;
        if (r11 == r6) goto L6;
        kotlin.s0.w.d.l0.c.b.a r15 = kotlin.s0.w.d.l0.c.b.a.f18851i;
    L6:
        return new j0(this.f19005J, p1(), p0(), this, r13, r6, r14);
    }

    public e1 n1() {
        return p1();
    }

    public i0 o1() {
        kotlin.s0.w.d.l0.c.y r1 = super.a();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.i0
    public kotlin.s0.w.d.l0.c.d p0() {
        return this.M;
    }

    public e1 p1() {
        return this.K;
    }

    public i0 q1(l1 r3) {
        kotlin.n0.d.o.f(r3, "substitutor");
        kotlin.s0.w.d.l0.c.y r4 = super.d(r3);
        kotlin.n0.d.o.d(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        j0 r5 = (j0) r4;
        l1 r0 = l1.f(r5.getReturnType());
        kotlin.n0.d.o.e(r0, "create(substitutedTypeAliasConstructor.returnType)");
        kotlin.s0.w.d.l0.c.d r2 = p0().a().d(r0);
        if (r2 != null) goto L6;
        return null;
    L6:
        r5.M = r2;
        return r5;
    }

    @Override // kotlin.s0.w.d.l0.c.l
    public boolean z() {
        return p0().z();
    }
}
