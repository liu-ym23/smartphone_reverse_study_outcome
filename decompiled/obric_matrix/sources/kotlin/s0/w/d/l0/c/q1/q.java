package kotlin.s0.w.d.l0.c.q1;

/* JADX INFO: loaded from: classes2.dex */
public class q extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e f19043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.w.o.e f19044i;

    public q(kotlin.s0.w.d.l0.c.e r3) {
        if (r3 == null) goto L6;
        super(kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        this.f19043h = r3;
        this.f19044i = new kotlin.s0.w.d.l0.k.w.o.e(r3, null);
        return;
    L6:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r8) {
        if (r8 == 1) goto L6;
        if (r8 == 2) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        if (r8 == 1) goto L18;
        if (r8 == 2) goto L18;
        if (r8 == 3) goto L17;
        r5[0] = "descriptor";
    L19:
        if (r8 == 1) goto L23;
        if (r8 == 2) goto L22;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L24:
        if (r8 == 1) goto L29;
        if (r8 == 2) goto L29;
        if (r8 == 3) goto L28;
        r5[2] = "<init>";
        goto L29
    L28:
        r5[2] = "copy";
    L29:
        String r3 = String.format(r2, r5);
        if (r8 == 1) goto L34;
        if (r8 == 2) goto L34;
        throw new IllegalArgumentException(r3);
    L34:
        throw new IllegalStateException(r3);
    L22:
        r5[1] = "getContainingDeclaration";
        goto L24
    L23:
        r5[1] = "getValue";
        goto L24
    L17:
        r5[0] = "newOwner";
    L18:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.m c() {
        kotlin.s0.w.d.l0.c.e r0 = this.f19043h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(2);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.x0
    public kotlin.s0.w.d.l0.k.w.o.f getValue() {
        kotlin.s0.w.d.l0.k.w.o.e r0 = this.f19044i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(1);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.j
    public String toString() {
        return "class " + this.f19043h.getName() + "::this";
    }
}
