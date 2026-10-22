package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.j1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public class s extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t f19053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l1 f19054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l1 f19055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<f1> f19056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<f1> f19057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private e1 f19058l;

    class a implements kotlin.n0.c.l<f1, Boolean> {
        a(s r1) {
        }

        public Boolean a(f1 r1) {
            return Boolean.valueOf(!r1.o0());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(f1 r1) {
            return a(r1);
        }
    }

    class b implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ s f19059f;

        b(s r1) {
            this.f19059f = r1;
        }

        public kotlin.s0.w.d.l0.n.m0 a(kotlin.s0.w.d.l0.n.m0 r1) {
            return s.F0(this.f19059f, r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.m0 invoke(kotlin.s0.w.d.l0.n.m0 r1) {
            return a(r1);
        }
    }

    static {
    }

    public s(t r1, l1 r2) {
        this.f19053g = r1;
        this.f19054h = r2;
    }

    private static /* synthetic */ void A0(int r15) {
        if (r15 == 2) goto L12;
        if (r15 == 3) goto L12;
        if (r15 == 5) goto L12;
        if (r15 == 6) goto L12;
        if (r15 == 8) goto L12;
        if (r15 == 10) goto L12;
        if (r15 == 13) goto L12;
        if (r15 == 23) goto L12;
        String r8 = "@NotNull method %s.%s must not return null";
    L13:
        if (r15 == 2) goto L22;
        if (r15 == 3) goto L22;
        if (r15 == 5) goto L22;
        if (r15 == 6) goto L22;
        if (r15 == 8) goto L22;
        if (r15 == 10) goto L22;
        if (r15 == 13) goto L22;
        if (r15 == 23) goto L22;
        int r9 = 2;
    L23:
        Object[] r10 = new Object[r9];
        if (r15 == 2) goto L36;
        if (r15 == 3) goto L35;
        if (r15 == 5) goto L34;
        if (r15 == 6) goto L35;
        if (r15 == 8) goto L36;
        if (r15 == 10) goto L34;
        if (r15 == 13) goto L35;
        if (r15 == 23) goto L33;
        r10[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
    L38:
        switch(r15) {
            case 2: goto L58;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L58;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L58;
            case 11: goto L57;
            case 12: goto L56;
            case 13: goto L58;
            case 14: goto L56;
            case 15: goto L55;
            case 16: goto L54;
            case 17: goto L53;
            case 18: goto L52;
            case 19: goto L51;
            case 20: goto L50;
            case 21: goto L49;
            case 22: goto L48;
            case 23: goto L58;
            case 24: goto L47;
            case 25: goto L46;
            case 26: goto L45;
            case 27: goto L44;
            case 28: goto L43;
            case 29: goto L42;
            case 30: goto L41;
            case 31: goto L40;
            default: goto L39;
        };
    L39:
        r10[1] = "getTypeConstructor";
    L59:
        if (r15 == 2) goto L70;
        if (r15 == 3) goto L70;
        if (r15 == 5) goto L70;
        if (r15 == 6) goto L70;
        if (r15 == 8) goto L70;
        if (r15 == 10) goto L70;
        if (r15 == 13) goto L69;
        if (r15 != 23) goto L71;
        r10[2] = "substitute";
    L71:
        String r11 = String.format(r8, r10);
        if (r15 == 2) goto L82;
        if (r15 == 3) goto L82;
        if (r15 == 5) goto L82;
        if (r15 == 6) goto L82;
        if (r15 == 8) goto L82;
        if (r15 == 10) goto L82;
        if (r15 == 13) goto L82;
        if (r15 == 23) goto L82;
        throw new IllegalStateException(r11);
    L82:
        throw new IllegalArgumentException(r11);
    L69:
        r10[2] = "getUnsubstitutedMemberScope";
    L70:
        r10[2] = "getMemberScope";
        goto L71
    L40:
        r10[1] = "getSealedSubclasses";
        goto L59
    L41:
        r10[1] = "getDeclaredTypeParameters";
        goto L59
    L42:
        r10[1] = "getSource";
        goto L59
    L43:
        r10[1] = "getUnsubstitutedInnerClassesScope";
        goto L59
    L44:
        r10[1] = "getVisibility";
        goto L59
    L45:
        r10[1] = "getModality";
        goto L59
    L46:
        r10[1] = "getKind";
        goto L59
    L47:
        r10[1] = "substitute";
        goto L59
    L48:
        r10[1] = "getContainingDeclaration";
        goto L59
    L49:
        r10[1] = "getOriginal";
        goto L59
    L50:
        r10[1] = "getName";
        goto L59
    L51:
        r10[1] = "getAnnotations";
        goto L59
    L52:
        r10[1] = "getConstructors";
        goto L59
    L53:
        r10[1] = "getContextReceivers";
        goto L59
    L54:
        r10[1] = "getDefaultType";
        goto L59
    L55:
        r10[1] = "getStaticScope";
        goto L59
    L56:
        r10[1] = "getUnsubstitutedMemberScope";
        goto L59
    L57:
        r10[1] = "getMemberScope";
        goto L59
    L58:
        r10[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        goto L59
    L33:
        r10[0] = "substitutor";
    L34:
        r10[0] = "typeSubstitution";
    L35:
        r10[0] = "kotlinTypeRefiner";
    L36:
        r10[0] = "typeArguments";
    L22:
        r9 = 3;
    L12:
        r8 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        goto L13
    }

    static /* synthetic */ kotlin.s0.w.d.l0.n.m0 F0(s r0, kotlin.s0.w.d.l0.n.m0 r1) {
        return r0.N0(r1);
    }

    private l1 L0() {
        if (this.f19055i != null) goto L9;
        if (this.f19054h.k() == false) goto L7;
        this.f19055i = this.f19054h;
        goto L9
    L7:
        List<f1> r0 = this.f19053g.k().getParameters();
        this.f19056j = new ArrayList(r0.size());
        this.f19055i = kotlin.s0.w.d.l0.n.t.b(r0, this.f19054h.j(), this, this.f19056j);
        this.f19057k = kotlin.i0.r.N(this.f19056j, new a(this));
    L9:
        return this.f19055i;
    }

    private kotlin.s0.w.d.l0.n.m0 N0(kotlin.s0.w.d.l0.n.m0 r2) {
        if (r2 != null) goto L4;
    L8:
        return r2;
    L4:
        if (this.f19054h.k() == true) goto L8;
        return (kotlin.s0.w.d.l0.n.m0) L0().p(r2, r1.f21065h);
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean B() {
        return this.f19053g.B();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h D0() {
        kotlin.s0.w.d.l0.k.w.h r1 = J(kotlin.s0.w.d.l0.k.t.a.k(kotlin.s0.w.d.l0.k.d.g(this.f19053g)));
        if (r1 == null) goto L5;
        return r1;
    L5:
        A0(12);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return this.f19053g.E0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t
    public kotlin.s0.w.d.l0.k.w.h F(j1 r3, kotlin.s0.w.d.l0.n.t1.g r4) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L13;
        kotlin.s0.w.d.l0.k.w.h r5 = this.f19053g.F(r3, r4);
        if (this.f19054h.k() == false) goto L12;
        if (r5 == null) goto L9;
        return r5;
    L9:
        A0(7);
        throw null;
    L12:
        return new kotlin.s0.w.d.l0.k.w.m(r5, L0());
    L13:
        A0(6);
        throw null;
    L15:
        A0(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public List<x0> G0() {
        List<x0> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(17);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public Collection<kotlin.s0.w.d.l0.c.e> H() {
        Collection<kotlin.s0.w.d.l0.c.e> r0 = this.f19053g.H();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(31);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean I() {
        return this.f19053g.I();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t
    public kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r3) {
        if (r3 == null) goto L12;
        kotlin.s0.w.d.l0.k.w.h r4 = this.f19053g.J(r3);
        if (this.f19054h.k() == false) goto L11;
        if (r4 == null) goto L8;
        return r4;
    L8:
        A0(14);
        throw null;
    L11:
        return new kotlin.s0.w.d.l0.k.w.m(r4, L0());
    L12:
        A0(13);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean J0() {
        return this.f19053g.J0();
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.a(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public x0 K0() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return this.f19053g.L();
    }

    @Override // kotlin.s0.w.d.l0.c.i
    public boolean M() {
        return this.f19053g.M();
    }

    public kotlin.s0.w.d.l0.c.e M0(l1 r3) {
        if (r3 != null) goto L4;
        A0(23);
        throw null;
    L4:
        if (r3.k() == false) goto L7;
        return this;
    L7:
        return new s(this, l1.h(r3.j(), L0().j()));
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.d Q() {
        return this.f19053g.Q();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h R() {
        kotlin.s0.w.d.l0.k.w.h r0 = this.f19053g.R();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(15);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.e T() {
        return this.f19053g.T();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t, kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.e a() {
        kotlin.s0.w.d.l0.c.e r0 = this.f19053g.a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(21);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h a0(j1 r3) {
        if (r3 == null) goto L9;
        kotlin.s0.w.d.l0.k.w.h r2 = F(r3, kotlin.s0.w.d.l0.k.t.a.k(kotlin.s0.w.d.l0.k.d.g(this)));
        if (r2 == null) goto L7;
        return r2;
    L7:
        A0(11);
        throw null;
    L9:
        A0(10);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.n, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.m c() {
        kotlin.s0.w.d.l0.c.m r0 = this.f19053g.c();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(22);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return M0(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        kotlin.s0.w.d.l0.c.o1.g r0 = this.f19053g.getAnnotations();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(19);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.j0
    public kotlin.s0.w.d.l0.g.f getName() {
        kotlin.s0.w.d.l0.g.f r0 = this.f19053g.getName();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(20);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.p
    public a1 getSource() {
        a1 r0 = a1.f18847a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(29);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = this.f19053g.getVisibility();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(27);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.f i() {
        kotlin.s0.w.d.l0.c.f r0 = this.f19053g.i();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(25);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        return this.f19053g.isExternal();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean isInline() {
        return this.f19053g.isInline();
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public e1 k() {
        e1 r0 = this.f19053g.k();
        if (this.f19054h.k() == false) goto L9;
        if (r0 == null) goto L6;
        return r0;
    L6:
        A0(0);
        throw null;
    L9:
        if (this.f19058l != null) goto L15;
        l1 r1 = L0();
        Collection<kotlin.s0.w.d.l0.n.e0> r2 = r0.a();
        ArrayList r3 = new ArrayList(r2.size());
        Iterator<kotlin.s0.w.d.l0.n.e0> r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.add(r1.p(r4.next(), r1.f21065h));
        goto L12
    L14:
        this.f19058l = new kotlin.s0.w.d.l0.n.l(this, this.f19056j, r3, kotlin.s0.w.d.l0.m.f.f20912e);
    L15:
        e1 r6 = this.f19058l;
        if (r6 == null) goto L18;
        return r6;
    L18:
        A0(1);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        kotlin.s0.w.d.l0.c.e0 r0 = this.f19053g.l();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(26);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public Collection<kotlin.s0.w.d.l0.c.d> m() {
        Collection<kotlin.s0.w.d.l0.c.d> r0 = this.f19053g.m();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<kotlin.s0.w.d.l0.c.d> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        kotlin.s0.w.d.l0.c.d r3 = r2.next();
        r1.add(((kotlin.s0.w.d.l0.c.d) r3.t().g(r3.a()).c(r3.l()).n(r3.getVisibility()).q(r3.i()).i(false).build()).d(L0()));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.h
    public kotlin.s0.w.d.l0.n.m0 s() {
        List<g1> r0 = n1.g(k().getParameters());
        kotlin.s0.w.d.l0.n.m0 r5 = kotlin.s0.w.d.l0.n.f0.j(kotlin.s0.w.d.l0.n.o.f21056a.a(getAnnotations(), null, null), k(), r0, false, D0());
        if (r5 == null) goto L5;
        return r5;
    L5:
        A0(16);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.i
    public List<f1> u() {
        L0();
        List<f1> r0 = this.f19057k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(30);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean x() {
        return this.f19053g.x();
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h y0() {
        kotlin.s0.w.d.l0.k.w.h r0 = this.f19053g.y0();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(28);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public h1<kotlin.s0.w.d.l0.n.m0> z0() {
        h1<kotlin.s0.w.d.l0.n.m0> r0 = this.f19053g.z0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(new b(this));
    }
}
