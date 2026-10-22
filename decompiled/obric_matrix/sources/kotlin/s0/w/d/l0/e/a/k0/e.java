package kotlin.s0.w.d.l0.e.a.k0;

import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.q1.g0;
import kotlin.s0.w.d.l0.c.q1.p;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g0 implements kotlin.s0.w.d.l0.e.a.k0.a {
    public static final kotlin.s0.w.d.l0.c.a.InterfaceC0500a<j1> L = null;
    public static final kotlin.s0.w.d.l0.c.a.InterfaceC0500a<Boolean> M = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private c f19336J;
    private final boolean K;

    static class a implements kotlin.s0.w.d.l0.c.a.InterfaceC0500a<j1> {
        a() {
        }
    }

    static class b implements kotlin.s0.w.d.l0.c.a.InterfaceC0500a<Boolean> {
        b() {
        }
    }

    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f19337h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f19338i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f19339j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final c f19340k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ c[] f19341l = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f19342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f19343g;

        static {
            c r0 = new c("NON_STABLE_DECLARED", 0, false, false);
            f19337h = r0;
            c r1 = new c("STABLE_DECLARED", 1, true, false);
            f19338i = r1;
            c r3 = new c("NON_STABLE_SYNTHESIZED", 2, false, true);
            f19339j = r3;
            c r5 = new c("STABLE_SYNTHESIZED", 3, true, true);
            f19340k = r5;
            f19341l = new c[]{r0, r1, r3, r5};
        }

        private c(String r1, int r2, boolean r3, boolean r4) {
            super(r1, r2);
            this.f19342f = r3;
            this.f19343g = r4;
        }

        private static /* synthetic */ void a(int r2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"}));
        }

        public static c b(boolean r0, boolean r1) {
            if (r0 == false) goto L6;
            if (r1 == false) goto L5;
            c r2 = f19340k;
        L9:
            if (r2 == null) goto L11;
            return r2;
        L11:
            a(0);
            throw null;
        L5:
            r2 = f19338i;
            goto L9
        L6:
            if (r1 == false) goto L8;
            r2 = f19339j;
            goto L9
        L8:
            r2 = f19337h;
            goto L9
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f19341l.clone();
        }
    }

    static {
        L = new a();
        M = new b();
    }

    protected e(m r2, z0 r3, kotlin.s0.w.d.l0.c.o1.g r4, kotlin.s0.w.d.l0.g.f r5, kotlin.s0.w.d.l0.c.b.a r6, a1 r7, boolean r8) {
        if (r2 == null) goto L18;
        if (r4 == null) goto L16;
        if (r5 == null) goto L14;
        if (r6 == null) goto L12;
        if (r7 == null) goto L10;
        super(r2, r3, r4, r5, r6, r7);
        this.f19336J = null;
        this.K = r8;
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

    private static /* synthetic */ void F(int r11) {
        if (r11 == 13) goto L7;
        if (r11 == 18) goto L7;
        if (r11 == 21) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r11 == 13) goto L13;
        if (r11 == 18) goto L13;
        if (r11 == 21) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        switch(r11) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L16;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L26;
            case 16: goto L28;
            case 17: goto L25;
            case 18: goto L20;
            case 19: goto L18;
            case 20: goto L17;
            case 21: goto L20;
            default: goto L16;
        };
    L16:
        r6[0] = "containingDeclaration";
    L30:
        if (r11 == 13) goto L36;
        if (r11 == 18) goto L35;
        if (r11 == 21) goto L34;
        r6[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
    L37:
        switch(r11) {
            case 5: goto L42;
            case 6: goto L42;
            case 7: goto L42;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L41;
            case 11: goto L41;
            case 12: goto L41;
            case 13: goto L43;
            case 14: goto L40;
            case 15: goto L40;
            case 16: goto L40;
            case 17: goto L40;
            case 18: goto L43;
            case 19: goto L39;
            case 20: goto L39;
            case 21: goto L43;
            default: goto L38;
        };
    L38:
        r6[2] = "<init>";
        goto L43
    L39:
        r6[2] = "enhance";
        goto L43
    L40:
        r6[2] = "createSubstitutedCopy";
        goto L43
    L41:
        r6[2] = "initialize";
        goto L43
    L42:
        r6[2] = "createJavaMethod";
    L43:
        String r4 = String.format(r3, r6);
        if (r11 == 13) goto L49;
        if (r11 == 18) goto L49;
        if (r11 == 21) goto L49;
        throw new IllegalArgumentException(r4);
    L49:
        throw new IllegalStateException(r4);
    L34:
        r6[1] = "enhance";
        goto L37
    L35:
        r6[1] = "createSubstitutedCopy";
        goto L37
    L36:
        r6[1] = "initialize";
        goto L37
    L17:
        r6[0] = "enhancedReturnType";
        goto L30
    L18:
        r6[0] = "enhancedValueParameterTypes";
        goto L30
    L19:
        r6[0] = "newOwner";
        goto L30
    L20:
        r6[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        goto L30
    L21:
        r6[0] = "visibility";
        goto L30
    L22:
        r6[0] = "unsubstitutedValueParameters";
        goto L30
    L23:
        r6[0] = "typeParameters";
        goto L30
    L24:
        r6[0] = "contextReceiverParameters";
        goto L30
    L25:
        r6[0] = "source";
        goto L30
    L26:
        r6[0] = "kind";
        goto L30
    L27:
        r6[0] = "name";
        goto L30
    L28:
        r6[0] = "annotations";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public static e q1(m r9, kotlin.s0.w.d.l0.c.o1.g r10, kotlin.s0.w.d.l0.g.f r11, a1 r12, boolean r13) {
        if (r9 == null) goto L15;
        if (r10 == null) goto L13;
        if (r11 == null) goto L11;
        if (r12 != null) goto L8;
        F(8);
        throw null;
    L8:
        return new e(r9, null, r10, r11, kotlin.s0.w.d.l0.c.b.a.f18848f, r12, r13);
    L11:
        F(7);
        throw null;
    L13:
        F(6);
        throw null;
    L15:
        F(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.a
    public boolean E() {
        return this.f19336J.f19343g;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.g0, kotlin.s0.w.d.l0.c.q1.p
    protected /* bridge */ /* synthetic */ p M0(m r1, y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        return r1(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p
    public boolean R0() {
        return this.f19336J.f19342f;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.g0
    public g0 p1(x0 r2, x0 r3, List<x0> r4, List<? extends f1> r5, List<j1> r6, e0 r7, kotlin.s0.w.d.l0.c.e0 r8, u r9, Map<? extends kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r10) {
        if (r4 == null) goto L15;
        if (r5 == null) goto L13;
        if (r6 == null) goto L11;
        if (r9 == null) goto L9;
        super.p1(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        g1(kotlin.s0.w.d.l0.o.p.f21237a.a(this).a());
        return this;
    L9:
        F(12);
        throw null;
    L11:
        F(11);
        throw null;
    L13:
        F(10);
        throw null;
    L15:
        F(9);
        throw null;
    }

    protected e r1(m r10, y r11, kotlin.s0.w.d.l0.c.b.a r12, kotlin.s0.w.d.l0.g.f r13, kotlin.s0.w.d.l0.c.o1.g r14, a1 r15) {
        if (r10 == null) goto L19;
        if (r12 == null) goto L17;
        if (r14 == null) goto L15;
        if (r15 == null) goto L13;
        z0 r3 = (z0) r11;
        if (r13 != null) goto L11;
        r13 = getName();
    L11:
        e r0 = new e(r10, r3, r14, r13, r12, r15, this.K);
        r0.t1(R0(), E());
        return r0;
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
    }

    public e s1(e0 r3, List<e0> r4, e0 r5, kotlin.u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r6) {
        if (r4 == null) goto L18;
        if (r5 == null) goto L16;
        List<j1> r7 = h.a(r4, h(), this);
        if (r3 != null) goto L8;
        x0 r8 = null;
    L9:
        e r2 = (e) t().b(r7).f(r5).j(r8).a().e().build();
        if (r6 == null) goto L12;
        r2.V0(r6.c(), r6.d());
    L12:
        if (r2 == null) goto L14;
        return r2;
    L14:
        F(21);
        throw null;
    L8:
        r8 = kotlin.s0.w.d.l0.k.c.h(this, r3, kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        goto L9
    L16:
        F(20);
        throw null;
    L18:
        F(19);
        throw null;
    }

    public void t1(boolean r1, boolean r2) {
        this.f19336J = c.b(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.k0.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.k0.a w(e0 r1, List r2, e0 r3, kotlin.u r4) {
        return s1(r1, r2, r3, r4);
    }
}
