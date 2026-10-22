package kotlin.s0.w.d.l0.c.q1;

import kotlin.s0.w.d.l0.c.a1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n0 extends m0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f19022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>> f19023l;
    protected kotlin.n0.c.a<kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>>> m;

    static {
    }

    public n0(kotlin.s0.w.d.l0.c.m r7, kotlin.s0.w.d.l0.c.o1.g r8, kotlin.s0.w.d.l0.g.f r9, kotlin.s0.w.d.l0.n.e0 r10, boolean r11, a1 r12) {
        if (r7 == null) goto L15;
        if (r8 == null) goto L13;
        if (r9 == null) goto L11;
        if (r12 == null) goto L9;
        super(r7, r8, r9, r10, r12);
        this.f19022k = r11;
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

    private static /* synthetic */ void F(int r7) {
        Object[] r1 = new Object[3];
        if (r7 == 1) goto L12;
        if (r7 == 2) goto L11;
        if (r7 == 3) goto L10;
        if (r7 == 4) goto L9;
        if (r7 == 5) goto L9;
        r1[0] = "containingDeclaration";
    L13:
        r1[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (r7 == 4) goto L18;
        if (r7 == 5) goto L17;
        r1[2] = "<init>";
    L20:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
    L17:
        r1[2] = "setCompileTimeInitializer";
        goto L20
    L18:
        r1[2] = "setCompileTimeInitializerFactory";
    L9:
        r1[0] = "compileTimeInitializerFactory";
        goto L13
    L10:
        r1[0] = "source";
        goto L13
    L11:
        r1[0] = "name";
        goto L13
    L12:
        r1[0] = "annotations";
        goto L13
    }

    public void L0(kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>> r1, kotlin.n0.c.a<kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>>> r2) {
        if (r2 == null) goto L9;
        this.m = r2;
        if (r1 != null) goto L7;
        r1 = r2.invoke();
    L7:
        this.f19023l = r1;
        return;
    L9:
        F(5);
        throw null;
    }

    public void M0(kotlin.n0.c.a<kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>>> r2) {
        if (r2 == null) goto L6;
        L0(null, r2);
        return;
    L6:
        F(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.k1
    public kotlin.s0.w.d.l0.k.r.g<?> W() {
        kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>> r0 = this.f19023l;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.invoke();
    }

    @Override // kotlin.s0.w.d.l0.c.k1
    public boolean j0() {
        return this.f19022k;
    }
}
