package kotlin.s0.w.d.l0.c.q1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public class g0 extends p implements z0 {
    protected g0(kotlin.s0.w.d.l0.c.m r2, z0 r3, kotlin.s0.w.d.l0.c.o1.g r4, kotlin.s0.w.d.l0.g.f r5, kotlin.s0.w.d.l0.c.b.a r6, a1 r7) {
        if (r2 == null) goto L18;
        if (r4 == null) goto L16;
        if (r5 == null) goto L14;
        if (r6 == null) goto L12;
        if (r7 == null) goto L10;
        super(r2, r3, r4, r5, r6, r7);
        return;
    L10:
        F(4);
        throw null;
    L12:
        F(3);
        throw null;
    L14:
        F(2);
        throw null;
    L16:
        F(1);
        throw null;
    L18:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r12) {
        if (r12 == 13) goto L10;
        if (r12 == 18) goto L10;
        if (r12 == 23) goto L10;
        if (r12 == 24) goto L10;
        if (r12 == 29) goto L10;
        if (r12 == 30) goto L10;
        String r6 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L12:
        if (r12 == 13) goto L19;
        if (r12 == 18) goto L19;
        if (r12 == 23) goto L19;
        if (r12 == 24) goto L19;
        if (r12 == 29) goto L19;
        if (r12 == 30) goto L19;
        int r8 = 3;
    L20:
        Object[] r9 = new Object[r8];
        switch(r12) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L22;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L28;
            case 16: goto L27;
            case 17: goto L26;
            case 18: goto L25;
            case 19: goto L24;
            case 20: goto L28;
            case 21: goto L27;
            case 22: goto L26;
            case 23: goto L25;
            case 24: goto L25;
            case 25: goto L23;
            case 26: goto L30;
            case 27: goto L32;
            case 28: goto L29;
            case 29: goto L25;
            case 30: goto L25;
            default: goto L22;
        };
    L22:
        r9[0] = "containingDeclaration";
    L34:
        if (r12 == 13) goto L44;
        if (r12 == 18) goto L44;
        if (r12 == 23) goto L44;
        if (r12 == 24) goto L43;
        if (r12 == 29) goto L42;
        if (r12 == 30) goto L41;
        r9[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
    L45:
        switch(r12) {
            case 5: goto L49;
            case 6: goto L49;
            case 7: goto L49;
            case 8: goto L49;
            case 9: goto L49;
            case 10: goto L48;
            case 11: goto L48;
            case 12: goto L48;
            case 13: goto L50;
            case 14: goto L48;
            case 15: goto L48;
            case 16: goto L48;
            case 17: goto L48;
            case 18: goto L50;
            case 19: goto L48;
            case 20: goto L48;
            case 21: goto L48;
            case 22: goto L48;
            case 23: goto L50;
            case 24: goto L50;
            case 25: goto L47;
            case 26: goto L47;
            case 27: goto L47;
            case 28: goto L47;
            case 29: goto L50;
            case 30: goto L50;
            default: goto L46;
        };
    L46:
        r9[2] = "<init>";
        goto L50
    L47:
        r9[2] = "createSubstitutedCopy";
        goto L50
    L48:
        r9[2] = "initialize";
        goto L50
    L49:
        r9[2] = "create";
    L50:
        String r7 = String.format(r6, r9);
        if (r12 == 13) goto L59;
        if (r12 == 18) goto L59;
        if (r12 == 23) goto L59;
        if (r12 == 24) goto L59;
        if (r12 == 29) goto L59;
        if (r12 == 30) goto L59;
        throw new IllegalArgumentException(r7);
    L59:
        throw new IllegalStateException(r7);
    L41:
        r9[1] = "newCopyBuilder";
        goto L45
    L42:
        r9[1] = "copy";
        goto L45
    L43:
        r9[1] = "getOriginal";
    L44:
        r9[1] = "initialize";
        goto L45
    L23:
        r9[0] = "newOwner";
        goto L34
    L24:
        r9[0] = "contextReceiverParameters";
        goto L34
    L25:
        r9[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        goto L34
    L26:
        r9[0] = "visibility";
        goto L34
    L27:
        r9[0] = "unsubstitutedValueParameters";
        goto L34
    L28:
        r9[0] = "typeParameters";
        goto L34
    L29:
        r9[0] = "source";
        goto L34
    L30:
        r9[0] = "kind";
        goto L34
    L31:
        r9[0] = "name";
        goto L34
    L32:
        r9[0] = "annotations";
    L19:
        r8 = 2;
    L10:
        r6 = "@NotNull method %s.%s must not return null";
        goto L12
    }

    public static g0 m1(kotlin.s0.w.d.l0.c.m r8, kotlin.s0.w.d.l0.c.o1.g r9, kotlin.s0.w.d.l0.g.f r10, kotlin.s0.w.d.l0.c.b.a r11, a1 r12) {
        if (r8 == null) goto L18;
        if (r9 == null) goto L16;
        if (r10 == null) goto L14;
        if (r11 == null) goto L12;
        if (r12 != null) goto L9;
        F(9);
        throw null;
    L9:
        return new g0(r8, null, r9, r10, r11, r12);
    L12:
        F(8);
        throw null;
    L14:
        F(7);
        throw null;
    L16:
        F(6);
        throw null;
    L18:
        F(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return n1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y L0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return l1(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    protected p M0(kotlin.s0.w.d.l0.c.m r9, kotlin.s0.w.d.l0.c.y r10, kotlin.s0.w.d.l0.c.b.a r11, kotlin.s0.w.d.l0.g.f r12, kotlin.s0.w.d.l0.c.o1.g r13, a1 r14) {
        if (r9 == null) goto L19;
        if (r11 == null) goto L17;
        if (r13 == null) goto L15;
        if (r14 == null) goto L13;
        z0 r3 = (z0) r10;
        if (r12 != null) goto L12;
        r12 = getName();
    L12:
        return new g0(r9, r3, r13, r12, r11, r14);
    L13:
        F(28);
        throw null;
    L15:
        F(27);
        throw null;
    L17:
        F(26);
        throw null;
    L19:
        F(25);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public /* bridge */ /* synthetic */ p S0(x0 r1, x0 r2, List r3, List r4, List r5, kotlin.s0.w.d.l0.n.e0 r6, kotlin.s0.w.d.l0.c.e0 r7, kotlin.s0.w.d.l0.c.u r8) {
        return o1(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return n1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b a() {
        return n1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return n1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y a() {
        return n1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.b
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b k0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return l1(r1, r2, r3, r4, r5);
    }

    public z0 l1(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        z0 r0 = (z0) super.L0(r1, r2, r3, r4, r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(29);
        throw null;
    }

    public z0 n1() {
        z0 r0 = (z0) super.a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(24);
        throw null;
    }

    public g0 o1(x0 r12, x0 r13, List<x0> r14, List<? extends f1> r15, List<j1> r16, kotlin.s0.w.d.l0.n.e0 r17, kotlin.s0.w.d.l0.c.e0 r18, kotlin.s0.w.d.l0.c.u r19) {
        if (r14 == null) goto L18;
        if (r15 == null) goto L16;
        if (r16 == null) goto L14;
        if (r19 == null) goto L12;
        g0 r1 = p1(r12, r13, r14, r15, r16, r17, r18, r19, null);
        if (r1 == null) goto L10;
        return r1;
    L10:
        F(18);
        throw null;
    L12:
        F(17);
        throw null;
    L14:
        F(16);
        throw null;
    L16:
        F(15);
        throw null;
    L18:
        F(14);
        throw null;
    }

    public g0 p1(x0 r2, x0 r3, List<x0> r4, List<? extends f1> r5, List<j1> r6, kotlin.s0.w.d.l0.n.e0 r7, kotlin.s0.w.d.l0.c.e0 r8, kotlin.s0.w.d.l0.c.u r9, Map<? extends kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r10) {
        if (r4 == null) goto L19;
        if (r5 == null) goto L17;
        if (r6 == null) goto L15;
        if (r9 == null) goto L13;
        super.S0(r2, r3, r4, r5, r6, r7, r8, r9);
        if (r10 != null) goto L10;
    L12:
        return this;
    L10:
        if (r10.isEmpty() == true) goto L12;
        this.I = new LinkedHashMap(r10);
        goto L12
    L13:
        F(22);
        throw null;
    L15:
        F(21);
        throw null;
    L17:
        F(20);
        throw null;
    L19:
        F(19);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.z0
    public kotlin.s0.w.d.l0.c.y.a<? extends z0> t() {
        kotlin.s0.w.d.l0.c.y.a r0 = super.t();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(30);
        throw null;
    }
}
