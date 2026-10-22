package kotlin.s0.w.d.l0.c.q1;

import kotlin.s0.w.d.l0.c.a1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends j implements kotlin.s0.w.d.l0.c.n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.m f19008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a1 f19009i;

    protected k(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.c.o1.g r3, kotlin.s0.w.d.l0.g.f r4, a1 r5) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L13;
        if (r4 == null) goto L11;
        if (r5 == null) goto L9;
        super(r3, r4);
        this.f19008h = r2;
        this.f19009i = r5;
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
        if (r9 == 4) goto L7;
        if (r9 == 5) goto L7;
        if (r9 == 6) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 4) goto L13;
        if (r9 == 5) goto L13;
        if (r9 == 6) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L17;
            default: goto L16;
        };
    L16:
        r6[0] = "containingDeclaration";
    L22:
        if (r9 == 4) goto L28;
        if (r9 == 5) goto L27;
        if (r9 == 6) goto L26;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
    L29:
        if (r9 == 4) goto L33;
        if (r9 == 5) goto L33;
        if (r9 == 6) goto L33;
        r6[2] = "<init>";
    L33:
        String r4 = String.format(r3, r6);
        if (r9 == 4) goto L39;
        if (r9 == 5) goto L39;
        if (r9 == 6) goto L39;
        throw new IllegalArgumentException(r4);
    L39:
        throw new IllegalStateException(r4);
    L26:
        r6[1] = "getSource";
        goto L29
    L27:
        r6[1] = "getContainingDeclaration";
        goto L29
    L28:
        r6[1] = "getOriginal";
        goto L29
    L17:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        goto L22
    L18:
        r6[0] = "source";
        goto L22
    L19:
        r6[0] = "name";
        goto L22
    L20:
        r6[0] = "annotations";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public kotlin.s0.w.d.l0.c.p A0() {
        super.a();
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return A0();
    }

    public kotlin.s0.w.d.l0.c.m c() {
        kotlin.s0.w.d.l0.c.m r0 = this.f19008h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.p
    public a1 getSource() {
        a1 r0 = this.f19009i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(6);
        throw null;
    }
}
