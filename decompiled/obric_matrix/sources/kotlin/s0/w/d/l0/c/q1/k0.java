package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.d1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public class k0 extends e {
    private final kotlin.n0.c.l<kotlin.s0.w.d.l0.n.e0, Void> p;
    private final List<kotlin.s0.w.d.l0.n.e0> q;
    private boolean r;

    private k0(kotlin.s0.w.d.l0.c.m r12, kotlin.s0.w.d.l0.c.o1.g r13, boolean r14, r1 r15, kotlin.s0.w.d.l0.g.f r16, int r17, a1 r18, kotlin.n0.c.l<kotlin.s0.w.d.l0.n.e0, Void> r19, d1 r20, kotlin.s0.w.d.l0.m.n r21) {
        if (r12 == null) goto L24;
        if (r13 == null) goto L22;
        if (r15 == null) goto L20;
        if (r16 == null) goto L18;
        if (r18 == null) goto L16;
        if (r20 == null) goto L14;
        if (r21 == null) goto L12;
        super(r21, r12, r13, r16, r15, r14, r17, r18, r20);
        this.q = new ArrayList(1);
        this.r = false;
        this.p = r19;
        return;
    L12:
        F(25);
        throw null;
    L14:
        F(24);
        throw null;
    L16:
        F(23);
        throw null;
    L18:
        F(22);
        throw null;
    L20:
        F(21);
        throw null;
    L22:
        F(20);
        throw null;
    L24:
        F(19);
        throw null;
    }

    private static /* synthetic */ void F(int r8) {
        if (r8 == 5) goto L6;
        if (r8 == 28) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 5) goto L11;
        if (r8 == 28) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        switch(r8) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L14;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L19;
            case 11: goto L21;
            case 12: goto L14;
            case 13: goto L24;
            case 14: goto L23;
            case 15: goto L22;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L21;
            case 19: goto L14;
            case 20: goto L24;
            case 21: goto L23;
            case 22: goto L22;
            case 23: goto L19;
            case 24: goto L17;
            case 25: goto L21;
            case 26: goto L16;
            case 27: goto L15;
            case 28: goto L20;
            default: goto L14;
        };
    L14:
        r5[0] = "containingDeclaration";
    L26:
        if (r8 == 5) goto L30;
        if (r8 == 28) goto L29;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
    L31:
        switch(r8) {
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L36;
            case 16: goto L36;
            case 17: goto L36;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L35;
            case 21: goto L35;
            case 22: goto L35;
            case 23: goto L35;
            case 24: goto L35;
            case 25: goto L35;
            case 26: goto L34;
            case 27: goto L33;
            case 28: goto L37;
            default: goto L32;
        };
    L32:
        r5[2] = "createWithDefaultBound";
        goto L37
    L33:
        r5[2] = "reportSupertypeLoopError";
        goto L37
    L34:
        r5[2] = "addUpperBound";
        goto L37
    L35:
        r5[2] = "<init>";
        goto L37
    L36:
        r5[2] = "createForFurtherModification";
    L37:
        String r3 = String.format(r2, r5);
        if (r8 == 5) goto L42;
        if (r8 == 28) goto L42;
        throw new IllegalArgumentException(r3);
    L42:
        throw new IllegalStateException(r3);
    L29:
        r5[1] = "resolveUpperBounds";
        goto L31
    L30:
        r5[1] = "createWithDefaultBound";
        goto L31
    L15:
        r5[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L26
    L16:
        r5[0] = "bound";
        goto L26
    L17:
        r5[0] = "supertypeLoopsChecker";
        goto L26
    L18:
        r5[0] = "supertypeLoopsResolver";
        goto L26
    L19:
        r5[0] = "source";
        goto L26
    L20:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        goto L26
    L21:
        r5[0] = "storageManager";
        goto L26
    L22:
        r5[0] = "name";
        goto L26
    L23:
        r5[0] = "variance";
        goto L26
    L24:
        r5[0] = "annotations";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    private void O0() {
        if (this.r == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + V0());
    }

    private void P0() {
        if (this.r == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Type parameter descriptor is already initialized: " + V0());
    }

    public static k0 Q0(kotlin.s0.w.d.l0.c.m r12, kotlin.s0.w.d.l0.c.o1.g r13, boolean r14, r1 r15, kotlin.s0.w.d.l0.g.f r16, int r17, a1 r18, kotlin.n0.c.l<kotlin.s0.w.d.l0.n.e0, Void> r19, d1 r20, kotlin.s0.w.d.l0.m.n r21) {
        if (r12 == null) goto L24;
        if (r13 == null) goto L22;
        if (r15 == null) goto L20;
        if (r16 == null) goto L18;
        if (r18 == null) goto L16;
        if (r20 == null) goto L14;
        if (r21 != null) goto L11;
        F(18);
        throw null;
    L11:
        return new k0(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L14:
        F(17);
        throw null;
    L16:
        F(16);
        throw null;
    L18:
        F(15);
        throw null;
    L20:
        F(14);
        throw null;
    L22:
        F(13);
        throw null;
    L24:
        F(12);
        throw null;
    }

    public static k0 R0(kotlin.s0.w.d.l0.c.m r11, kotlin.s0.w.d.l0.c.o1.g r12, boolean r13, r1 r14, kotlin.s0.w.d.l0.g.f r15, int r16, a1 r17, kotlin.s0.w.d.l0.m.n r18) {
        if (r11 == null) goto L21;
        if (r12 == null) goto L19;
        if (r14 == null) goto L17;
        if (r15 == null) goto L15;
        if (r17 == null) goto L13;
        if (r18 != null) goto L10;
        F(11);
        throw null;
    L10:
        return Q0(r11, r12, r13, r14, r15, r16, r17, null, d1.a.f18858a, r18);
    L13:
        F(10);
        throw null;
    L15:
        F(9);
        throw null;
    L17:
        F(8);
        throw null;
    L19:
        F(7);
        throw null;
    L21:
        F(6);
        throw null;
    }

    public static f1 S0(kotlin.s0.w.d.l0.c.m r9, kotlin.s0.w.d.l0.c.o1.g r10, boolean r11, r1 r12, kotlin.s0.w.d.l0.g.f r13, int r14, kotlin.s0.w.d.l0.m.n r15) {
        if (r9 == null) goto L21;
        if (r10 == null) goto L19;
        if (r12 == null) goto L17;
        if (r13 == null) goto L15;
        if (r15 == null) goto L13;
        k0 r16 = R0(r9, r10, r11, r12, r13, r14, a1.f18847a, r15);
        r16.N0(kotlin.s0.w.d.l0.k.t.a.f(r9).y());
        r16.W0();
        if (r16 == null) goto L11;
        return r16;
    L11:
        F(5);
        throw null;
    L13:
        F(4);
        throw null;
    L15:
        F(3);
        throw null;
    L17:
        F(2);
        throw null;
    L19:
        F(1);
        throw null;
    L21:
        F(0);
        throw null;
    }

    private void T0(kotlin.s0.w.d.l0.n.e0 r2) {
        if (kotlin.s0.w.d.l0.n.g0.a(r2) == false) goto L5;
        return;
    L5:
        this.q.add(r2);
    }

    private String V0() {
        return getName() + " declared in " + kotlin.s0.w.d.l0.k.d.m(c());
    }

    @Override // kotlin.s0.w.d.l0.c.q1.e
    protected void L0(kotlin.s0.w.d.l0.n.e0 r1) {
        if (r1 == null) goto L8;
        kotlin.n0.c.l<kotlin.s0.w.d.l0.n.e0, Void> r0 = this.p;
        if (r0 != null) goto L6;
        return;
    L6:
        r0.invoke(r1);
        return;
    L8:
        F(27);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.e
    protected List<kotlin.s0.w.d.l0.n.e0> M0() {
        O0();
        List<kotlin.s0.w.d.l0.n.e0> r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(28);
        throw null;
    }

    public void N0(kotlin.s0.w.d.l0.n.e0 r1) {
        if (r1 == null) goto L5;
        P0();
        T0(r1);
        return;
    L5:
        F(26);
        throw null;
    }

    public boolean U0() {
        return this.r;
    }

    public void W0() {
        P0();
        this.r = true;
    }
}
