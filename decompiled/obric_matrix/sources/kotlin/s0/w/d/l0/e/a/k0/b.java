package kotlin.s0.w.d.l0.e.a.k0;

import java.util.List;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.q1.p;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public class b extends kotlin.s0.w.d.l0.c.q1.f implements a {
    private Boolean K;
    private Boolean L;

    static {
    }

    protected b(kotlin.s0.w.d.l0.c.e r2, b r3, kotlin.s0.w.d.l0.c.o1.g r4, boolean r5, kotlin.s0.w.d.l0.c.b.a r6, a1 r7) {
        if (r2 == null) goto L15;
        if (r4 == null) goto L13;
        if (r6 == null) goto L11;
        if (r7 == null) goto L9;
        super(r2, r3, r4, r5, r6, r7);
        this.K = null;
        this.L = null;
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

    private static /* synthetic */ void F(int r9) {
        if (r9 == 11) goto L6;
        if (r9 == 18) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 11) goto L11;
        if (r9 == 18) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        switch(r9) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L14;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L21;
            case 9: goto L22;
            case 10: goto L20;
            case 11: goto L18;
            case 12: goto L19;
            case 13: goto L21;
            case 14: goto L17;
            case 15: goto L22;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L18;
            default: goto L14;
        };
    L14:
        r5[0] = "containingDeclaration";
    L24:
        if (r9 == 11) goto L28;
        if (r9 == 18) goto L27;
        r5[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
    L29:
        switch(r9) {
            case 4: goto L34;
            case 5: goto L34;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L35;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L32;
            case 15: goto L32;
            case 16: goto L31;
            case 17: goto L31;
            case 18: goto L35;
            default: goto L30;
        };
    L30:
        r5[2] = "<init>";
        goto L35
    L31:
        r5[2] = "enhance";
        goto L35
    L32:
        r5[2] = "createDescriptor";
        goto L35
    L33:
        r5[2] = "createSubstitutedCopy";
        goto L35
    L34:
        r5[2] = "createJavaConstructor";
    L35:
        String r3 = String.format(r2, r5);
        if (r9 == 11) goto L40;
        if (r9 == 18) goto L40;
        throw new IllegalArgumentException(r3);
    L40:
        throw new IllegalStateException(r3);
    L27:
        r5[1] = "enhance";
        goto L29
    L28:
        r5[1] = "createSubstitutedCopy";
        goto L29
    L15:
        r5[0] = "enhancedReturnType";
        goto L24
    L16:
        r5[0] = "enhancedValueParameterTypes";
        goto L24
    L17:
        r5[0] = "sourceElement";
        goto L24
    L18:
        r5[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        goto L24
    L19:
        r5[0] = "newOwner";
        goto L24
    L20:
        r5[0] = "source";
        goto L24
    L21:
        r5[0] = "kind";
        goto L24
    L22:
        r5[0] = "annotations";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public static b u1(kotlin.s0.w.d.l0.c.e r8, kotlin.s0.w.d.l0.c.o1.g r9, boolean r10, a1 r11) {
        if (r8 == null) goto L12;
        if (r9 == null) goto L10;
        if (r11 != null) goto L7;
        F(6);
        throw null;
    L7:
        return new b(r8, null, r9, r10, kotlin.s0.w.d.l0.c.b.a.f18848f, r11);
    L10:
        F(5);
        throw null;
    L12:
        F(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.a
    public boolean E() {
        return this.L.booleanValue();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.f, kotlin.s0.w.d.l0.c.q1.p
    protected /* bridge */ /* synthetic */ p M0(m r1, y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        return v1(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public boolean R0() {
        return this.K.booleanValue();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public void Z0(boolean r1) {
        this.K = Boolean.valueOf(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public void a1(boolean r1) {
        this.L = Boolean.valueOf(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.f
    protected /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.q1.f p1(m r1, y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        return v1(r1, r2, r3, r4, r5, r6);
    }

    protected b t1(kotlin.s0.w.d.l0.c.e r9, b r10, kotlin.s0.w.d.l0.c.b.a r11, a1 r12, kotlin.s0.w.d.l0.c.o1.g r13) {
        if (r9 == null) goto L15;
        if (r11 == null) goto L13;
        if (r12 == null) goto L11;
        if (r13 != null) goto L8;
        F(15);
        throw null;
    L8:
        return new b(r9, r10, r13, this.f18995J, r11, r12);
    L11:
        F(14);
        throw null;
    L13:
        F(13);
        throw null;
    L15:
        F(12);
        throw null;
    }

    protected b v1(m r7, y r8, kotlin.s0.w.d.l0.c.b.a r9, kotlin.s0.w.d.l0.g.f r10, kotlin.s0.w.d.l0.c.o1.g r11, a1 r12) {
        if (r7 == null) goto L25;
        if (r9 == null) goto L23;
        if (r11 == null) goto L21;
        if (r12 != null) goto L8;
        F(10);
        throw null;
    L8:
        if (r9 != kotlin.s0.w.d.l0.c.b.a.f18848f) goto L10;
    L14:
        b r13 = t1((kotlin.s0.w.d.l0.c.e) r7, (b) r8, r9, r12, r11);
        r13.Z0(R0());
        r13.a1(E());
        if (r13 == null) goto L17;
        return r13;
    L17:
        F(11);
        throw null;
    L10:
        if (r9 == kotlin.s0.w.d.l0.c.b.a.f18851i) goto L14;
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + r7 + "\nkind: " + r9);
    L21:
        F(9);
        throw null;
    L23:
        F(8);
        throw null;
    L25:
        F(7);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.e.a.k0.a
    public /* bridge */ /* synthetic */ a w(e0 r1, List r2, e0 r3, u r4) {
        return w1(r1, r2, r3, r4);
    }

    public b w1(e0 r14, List<e0> r15, e0 r16, u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r17) {
        if (r15 == null) goto L18;
        if (r16 == null) goto L16;
        b r12 = v1(q1(), null, i(), null, getAnnotations(), getSource());
        if (r14 != null) goto L8;
        x0 r4 = null;
    L9:
        r12.S0(r4, f0(), r.g(), getTypeParameters(), h.a(r15, h(), r12), r16, l(), getVisibility());
        if (r17 == null) goto L12;
        r12.V0(r17.c(), r17.d());
    L12:
        if (r12 == null) goto L14;
        return r12;
    L14:
        F(18);
        throw null;
    L8:
        r4 = kotlin.s0.w.d.l0.k.c.h(r12, r14, kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        goto L9
    L16:
        F(17);
        throw null;
    L18:
        F(16);
        throw null;
    }
}
