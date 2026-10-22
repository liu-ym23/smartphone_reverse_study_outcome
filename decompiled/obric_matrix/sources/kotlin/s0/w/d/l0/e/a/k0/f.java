package kotlin.s0.w.d.l0.e.a.k0;

import java.util.List;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.q1.c0;
import kotlin.s0.w.d.l0.c.q1.d0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.w0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.m.j;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c0 implements a {
    private final boolean H;
    private final u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> I;

    protected f(m r18, kotlin.s0.w.d.l0.c.o1.g r19, e0 r20, kotlin.s0.w.d.l0.c.u r21, boolean r22, kotlin.s0.w.d.l0.g.f r23, a1 r24, u0 r25, kotlin.s0.w.d.l0.c.b.a r26, boolean r27, u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r28) {
        if (r18 == null) goto L24;
        if (r19 == null) goto L22;
        if (r20 == null) goto L20;
        if (r21 == null) goto L18;
        if (r23 == null) goto L16;
        if (r24 == null) goto L14;
        if (r26 == null) goto L12;
        super(r18, r25, r19, r20, r21, r22, r23, r26, r24, false, false, false, false, false, false);
        this.H = r27;
        this.I = r28;
        return;
    L12:
        F(6);
        throw null;
    L14:
        F(5);
        throw null;
    L16:
        F(4);
        throw null;
    L18:
        F(3);
        throw null;
    L20:
        F(2);
        throw null;
    L22:
        F(1);
        throw null;
    L24:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r7) {
        if (r7 == 21) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 21) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        switch(r7) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L12;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L24;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L21;
            case 17: goto L17;
            case 18: goto L22;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L14;
            case 22: goto L13;
            default: goto L12;
        };
    L12:
        r4[0] = "containingDeclaration";
    L28:
        if (r7 == 21) goto L30;
        r4[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
    L31:
        switch(r7) {
            case 7: goto L36;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L35;
            case 16: goto L35;
            case 17: goto L35;
            case 18: goto L35;
            case 19: goto L34;
            case 20: goto L34;
            case 21: goto L37;
            case 22: goto L33;
            default: goto L32;
        };
    L32:
        r4[2] = "<init>";
        goto L37
    L33:
        r4[2] = "setInType";
        goto L37
    L34:
        r4[2] = "enhance";
        goto L37
    L35:
        r4[2] = "createSubstitutedCopy";
        goto L37
    L36:
        r4[2] = "create";
    L37:
        String r2 = String.format(r1, r4);
        if (r7 == 21) goto L41;
        throw new IllegalArgumentException(r2);
    L41:
        throw new IllegalStateException(r2);
    L30:
        r4[1] = "enhance";
        goto L31
    L13:
        r4[0] = "inType";
        goto L28
    L14:
        r4[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        goto L28
    L15:
        r4[0] = "enhancedReturnType";
        goto L28
    L16:
        r4[0] = "enhancedValueParameterTypes";
        goto L28
    L17:
        r4[0] = "newName";
        goto L28
    L18:
        r4[0] = "newVisibility";
        goto L28
    L19:
        r4[0] = "newModality";
        goto L28
    L20:
        r4[0] = "newOwner";
        goto L28
    L21:
        r4[0] = "kind";
        goto L28
    L22:
        r4[0] = "source";
        goto L28
    L23:
        r4[0] = "name";
        goto L28
    L24:
        r4[0] = "visibility";
        goto L28
    L25:
        r4[0] = "modality";
        goto L28
    L26:
        r4[0] = "annotations";
        goto L28
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static f g1(m r13, kotlin.s0.w.d.l0.c.o1.g r14, e0 r15, kotlin.s0.w.d.l0.c.u r16, boolean r17, kotlin.s0.w.d.l0.g.f r18, a1 r19, boolean r20) {
        if (r13 == null) goto L21;
        if (r14 == null) goto L19;
        if (r15 == null) goto L17;
        if (r16 == null) goto L15;
        if (r18 == null) goto L13;
        if (r19 != null) goto L10;
        F(12);
        throw null;
    L10:
        return new f(r13, r14, r15, r16, r17, r18, r19, null, kotlin.s0.w.d.l0.c.b.a.f18848f, r20, null);
    L13:
        F(11);
        throw null;
    L15:
        F(10);
        throw null;
    L17:
        F(9);
        throw null;
    L19:
        F(8);
        throw null;
    L21:
        F(7);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.m0, kotlin.s0.w.d.l0.c.a
    public boolean E() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.c0
    protected c0 Q0(m r15, e0 r16, kotlin.s0.w.d.l0.c.u r17, u0 r18, kotlin.s0.w.d.l0.c.b.a r19, kotlin.s0.w.d.l0.g.f r20, a1 r21) {
        if (r15 == null) goto L21;
        if (r16 == null) goto L19;
        if (r17 == null) goto L17;
        if (r19 == null) goto L15;
        if (r20 == null) goto L13;
        if (r21 != null) goto L10;
        F(18);
        throw null;
    L10:
        return new f(r15, getAnnotations(), r16, r17, j0(), r20, r21, r18, r19, this.H, this.I);
    L13:
        F(17);
        throw null;
    L15:
        F(16);
        throw null;
    L17:
        F(15);
        throw null;
    L19:
        F(14);
        throw null;
    L21:
        F(13);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.c0
    public void a1(kotlin.s0.w.d.l0.n.e0 r1) {
        if (r1 == null) goto L4;
        return;
    L4:
        F(22);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.c0, kotlin.s0.w.d.l0.c.a
    public <V> V i0(kotlin.s0.w.d.l0.c.a.InterfaceC0500a<V> r2) {
        u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r0 = this.I;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.c().equals(r2) == true) goto L7;
        return null;
    L7:
        return (V) this.I.d();
    }

    @Override // kotlin.s0.w.d.l0.e.a.k0.a
    public a w(kotlin.s0.w.d.l0.n.e0 r19, List<kotlin.s0.w.d.l0.n.e0> r20, kotlin.s0.w.d.l0.n.e0 r21, u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r22) {
        if (r20 == null) goto L36;
        if (r21 != null) goto L6;
        F(20);
        throw null;
    L6:
        if (a() != this) goto L8;
        u0 r4 = null;
    L9:
        u0 r13 = r4;
        f r15 = new f(c(), getAnnotations(), l(), getVisibility(), j0(), getName(), getSource(), r13, i(), this.H, r22);
        d0 r16 = S0();
        if (r16 == null) goto L16;
        kotlin.s0.w.d.l0.c.o1.g r7 = r16.getAnnotations();
        e0 r8 = r16.l();
        kotlin.s0.w.d.l0.c.u r9 = r16.getVisibility();
        boolean r10 = r16.U();
        boolean r11 = r16.isExternal();
        boolean r12 = r16.isInline();
        kotlin.s0.w.d.l0.c.b.a r14 = i();
        if (r4 != null) goto L14;
        v0 r17 = null;
    L15:
        d0 r3 = r15;
        d0 r18 = new d0(r15, r7, r8, r9, r10, r11, r12, r14, r17, r16.getSource());
        r3.O0(r16.d0());
        r3.R0(r21);
    L17:
        w0 r110 = Y();
        if (r110 == null) goto L24;
        kotlin.s0.w.d.l0.c.o1.g r23 = r110.getAnnotations();
        e0 r24 = r110.l();
        kotlin.s0.w.d.l0.c.u r25 = r110.getVisibility();
        boolean r111 = r110.U();
        boolean r112 = r110.isExternal();
        boolean r113 = r110.isInline();
        kotlin.s0.w.d.l0.c.b.a r114 = i();
        if (r4 != null) goto L22;
        w0 r115 = null;
    L23:
        kotlin.s0.w.d.l0.c.q1.e0 r116 = new kotlin.s0.w.d.l0.c.q1.e0(r15, r23, r24, r25, r111, r112, r113, r114, r115, r110.getSource());
        r116.O0(r116.d0());
        r116.S0(r110.h().get(0));
        kotlin.s0.w.d.l0.c.q1.e0 r117 = r116;
    L25:
        r15.W0(r3, r117, q0(), n0());
        r15.b1(X0());
        kotlin.n0.c.a<j<kotlin.s0.w.d.l0.k.r.g<?>>> r5 = this.m;
        if (r5 == null) goto L28;
        r15.L0(this.f19023l, r5);
    L28:
        r15.x0(f());
        if (r19 != null) goto L31;
        x0 r6 = null;
    L32:
        r15.c1(r21, getTypeParameters(), f0(), r6, r.g());
        return r15;
    L31:
        r6 = kotlin.s0.w.d.l0.k.c.h(this, r19, kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        goto L32
    L22:
        r115 = r4.Y();
        goto L23
    L24:
        r117 = null;
        goto L25
    L14:
        r17 = r4.g();
        goto L15
    L16:
        r3 = null;
        goto L17
    L8:
        r4 = a();
        goto L9
    L36:
        F(19);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.c0, kotlin.s0.w.d.l0.c.k1
    public boolean y() {
        kotlin.s0.w.d.l0.n.e0 r0 = b();
        if (this.H == true) goto L5;
    L11:
        return false;
    L5:
        if (kotlin.s0.w.d.l0.c.j.a(r0) == false) goto L11;
        if (kotlin.s0.w.d.l0.e.a.o0.r.i(r0) == true) goto L9;
    L10:
        return true;
    L9:
        if (kotlin.s0.w.d.l0.b.h.u0(r0) == false) goto L11;
        goto L10
    }
}
