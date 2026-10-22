package kotlin.s0.w.d.l0.c.q1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.l1;

/* JADX INFO: loaded from: classes2.dex */
public class f extends p implements kotlin.s0.w.d.l0.c.d {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected final boolean f18995J;

    static {
    }

    protected f(kotlin.s0.w.d.l0.c.e r9, kotlin.s0.w.d.l0.c.l r10, kotlin.s0.w.d.l0.c.o1.g r11, boolean r12, kotlin.s0.w.d.l0.c.b.a r13, a1 r14) {
        if (r9 == null) goto L15;
        if (r11 == null) goto L13;
        if (r13 == null) goto L11;
        if (r14 == null) goto L9;
        super(r9, r10, r11, kotlin.s0.w.d.l0.g.h.f20279f, r13, r14);
        this.f18995J = r12;
        return;
    L9:
        F(3);
        throw null;
    L11:
        F(2);
        throw null;
    L13:
        F(1);
        throw null;
    L15:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r8) {
        if (r8 == 21) goto L7;
        if (r8 == 27) goto L7;
        switch(r8) {
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L7;
            default: goto L6;
        };
    L6:
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r8 == 21) goto L13;
        if (r8 == 27) goto L53;
        switch(r8) {
            case 15: goto L54;
            case 16: goto L54;
            case 17: goto L54;
            case 18: goto L54;
            case 19: goto L54;
            default: goto L12;
        };
    L12:
        int r4 = 3;
    L14:
        Object[] r5 = new Object[r4];
        switch(r8) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L16;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L16;
            case 8: goto L26;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L23;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L20;
            case 17: goto L20;
            case 18: goto L20;
            case 19: goto L20;
            case 20: goto L19;
            case 21: goto L20;
            case 22: goto L18;
            case 23: goto L17;
            case 24: goto L25;
            case 25: goto L26;
            case 26: goto L24;
            case 27: goto L20;
            default: goto L16;
        };
    L16:
        r5[0] = "containingDeclaration";
    L28:
        if (r8 == 21) goto L37;
        if (r8 == 27) goto L36;
        switch(r8) {
            case 15: goto L35;
            case 16: goto L35;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L32;
            default: goto L31;
        };
    L31:
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
    L38:
        switch(r8) {
            case 4: goto L45;
            case 5: goto L45;
            case 6: goto L45;
            case 7: goto L44;
            case 8: goto L44;
            case 9: goto L44;
            case 10: goto L43;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L43;
            case 14: goto L43;
            case 15: goto L46;
            case 16: goto L46;
            case 17: goto L46;
            case 18: goto L46;
            case 19: goto L46;
            case 20: goto L42;
            case 21: goto L46;
            case 22: goto L41;
            case 23: goto L40;
            case 24: goto L40;
            case 25: goto L40;
            case 26: goto L40;
            case 27: goto L46;
            default: goto L39;
        };
    L39:
        r5[2] = "<init>";
        goto L46
    L40:
        r5[2] = "createSubstitutedCopy";
        goto L46
    L41:
        r5[2] = "setOverriddenDescriptors";
        goto L46
    L42:
        r5[2] = "substitute";
        goto L46
    L43:
        r5[2] = "initialize";
        goto L46
    L44:
        r5[2] = "createSynthesized";
        goto L46
    L45:
        r5[2] = "create";
    L46:
        String r3 = String.format(r2, r5);
        if (r8 == 21) goto L52;
        if (r8 == 27) goto L52;
        switch(r8) {
            case 15: goto L52;
            case 16: goto L52;
            case 17: goto L52;
            case 18: goto L52;
            case 19: goto L52;
            default: goto L55;
        };
    L55:
        throw new IllegalArgumentException(r3);
    L52:
        throw new IllegalStateException(r3);
    L32:
        r5[1] = "getOriginal";
        goto L38
    L33:
        r5[1] = "getConstructedClass";
        goto L38
    L34:
        r5[1] = "getContainingDeclaration";
        goto L38
    L35:
        r5[1] = "calculateContextReceiverParameters";
        goto L38
    L36:
        r5[1] = "copy";
        goto L38
    L37:
        r5[1] = "getOverriddenDescriptors";
        goto L38
    L17:
        r5[0] = "newOwner";
        goto L28
    L18:
        r5[0] = "overriddenDescriptors";
        goto L28
    L19:
        r5[0] = "originalSubstitutor";
        goto L28
    L20:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
        goto L28
    L21:
        r5[0] = "typeParameterDescriptors";
        goto L28
    L22:
        r5[0] = "visibility";
        goto L28
    L23:
        r5[0] = "unsubstitutedValueParameters";
        goto L28
    L24:
        r5[0] = "source";
        goto L28
    L25:
        r5[0] = "kind";
        goto L28
    L26:
        r5[0] = "annotations";
        goto L28
    L54:
        r4 = 2;
        goto L14
    L53:
        r4 = 2;
        goto L14
    L13:
        r4 = 2;
    L7:
        r2 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    private List<x0> l1() {
        kotlin.s0.w.d.l0.c.e r2 = q1();
        if (r2.G0().isEmpty() == true) goto L9;
        List<x0> r3 = r2.G0();
        if (r3 == null) goto L7;
        return r3;
    L7:
        F(15);
        throw null;
    L9:
        List<x0> r4 = Collections.emptyList();
        if (r4 == null) goto L12;
        return r4;
    L12:
        F(16);
        throw null;
    }

    public static f o1(kotlin.s0.w.d.l0.c.e r8, kotlin.s0.w.d.l0.c.o1.g r9, boolean r10, a1 r11) {
        if (r8 == null) goto L12;
        if (r9 == null) goto L10;
        if (r11 != null) goto L7;
        F(6);
        throw null;
    L7:
        return new f(r8, null, r9, r10, kotlin.s0.w.d.l0.c.b.a.f18848f, r11);
    L10:
        F(5);
        throw null;
    L12:
        F(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.l
    public kotlin.s0.w.d.l0.c.e A() {
        kotlin.s0.w.d.l0.c.e r0 = q1();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(18);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.h(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y L0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return n1(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    protected /* bridge */ /* synthetic */ p M0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        return p1(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.d a() {
        kotlin.s0.w.d.l0.c.d r0 = (kotlin.s0.w.d.l0.c.d) super.a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(19);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.i c() {
        return q1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m c() {
        return q1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public kotlin.s0.w.d.l0.c.d d(l1 r1) {
        if (r1 != null) goto L4;
        F(20);
        throw null;
    L4:
        return (kotlin.s0.w.d.l0.c.d) super.d(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.l d(l1 r1) {
        return d(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return d(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y d(l1 r1) {
        return d(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.a
    public Collection<? extends kotlin.s0.w.d.l0.c.y> f() {
        Set r0 = Collections.emptySet();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(21);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.b
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b k0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return n1(r1, r2, r3, r4, r5);
    }

    public x0 m1() {
        kotlin.s0.w.d.l0.c.e r1 = q1();
        if (r1.M() == false) goto L8;
        kotlin.s0.w.d.l0.c.m r2 = r1.c();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L7;
        return null;
    L7:
        return ((kotlin.s0.w.d.l0.c.e) r2).K0();
    L8:
        return null;
    }

    public kotlin.s0.w.d.l0.c.d n1(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        kotlin.s0.w.d.l0.c.d r0 = (kotlin.s0.w.d.l0.c.d) super.L0(r1, r2, r3, r4, r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(27);
        throw null;
    }

    protected f p1(kotlin.s0.w.d.l0.c.m r8, kotlin.s0.w.d.l0.c.y r9, kotlin.s0.w.d.l0.c.b.a r10, kotlin.s0.w.d.l0.g.f r11, kotlin.s0.w.d.l0.c.o1.g r12, a1 r13) {
        if (r8 == null) goto L22;
        if (r10 == null) goto L20;
        if (r12 == null) goto L18;
        if (r13 == null) goto L16;
        kotlin.s0.w.d.l0.c.b.a r5 = kotlin.s0.w.d.l0.c.b.a.f18848f;
        if (r10 == r5) goto L15;
        if (r10 == kotlin.s0.w.d.l0.c.b.a.f18851i) goto L15;
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + r8 + "\nkind: " + r10);
    L15:
        return new f((kotlin.s0.w.d.l0.c.e) r8, this, r12, this.f18995J, r5, r13);
    L16:
        F(26);
        throw null;
    L18:
        F(25);
        throw null;
    L20:
        F(24);
        throw null;
    L22:
        F(23);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e q1() {
        kotlin.s0.w.d.l0.c.e r0 = (kotlin.s0.w.d.l0.c.e) super.c();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(17);
        throw null;
    }

    public f r1(List<j1> r2, kotlin.s0.w.d.l0.c.u r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        s1(r2, r3, q1().u());
        return this;
    L7:
        F(14);
        throw null;
    L9:
        F(13);
        throw null;
    }

    public f s1(List<j1> r11, kotlin.s0.w.d.l0.c.u r12, List<f1> r13) {
        if (r11 == null) goto L12;
        if (r12 == null) goto L10;
        if (r13 == null) goto L8;
        super.S0(null, m1(), l1(), r13, r11, null, kotlin.s0.w.d.l0.c.e0.f18860g, r12);
        return this;
    L8:
        F(12);
        throw null;
    L10:
        F(11);
        throw null;
    L12:
        F(10);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.b
    public void x0(Collection<? extends kotlin.s0.w.d.l0.c.b> r1) {
        if (r1 == null) goto L4;
        return;
    L4:
        F(22);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.l
    public boolean z() {
        return this.f18995J;
    }
}
