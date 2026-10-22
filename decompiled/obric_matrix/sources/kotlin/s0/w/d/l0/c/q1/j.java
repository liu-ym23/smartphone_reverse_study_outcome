package kotlin.s0.w.d.l0.c.q1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends kotlin.s0.w.d.l0.c.o1.b implements kotlin.s0.w.d.l0.c.m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f19004g;

    public j(kotlin.s0.w.d.l0.c.o1.g r2, kotlin.s0.w.d.l0.g.f r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        super(r2);
        this.f19004g = r3;
        return;
    L7:
        F(1);
        throw null;
    L9:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r9) {
        if (r9 == 2) goto L8;
        if (r9 == 3) goto L8;
        if (r9 == 5) goto L8;
        if (r9 == 6) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 2) goto L14;
        if (r9 == 3) goto L14;
        if (r9 == 5) goto L14;
        if (r9 == 6) goto L14;
        int r5 = 3;
    L15:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L19;
            case 6: goto L19;
            default: goto L17;
        };
    L17:
        r6[0] = "annotations";
    L22:
        if (r9 == 2) goto L29;
        if (r9 == 3) goto L28;
        if (r9 == 5) goto L27;
        if (r9 == 6) goto L27;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
    L30:
        if (r9 == 2) goto L38;
        if (r9 == 3) goto L38;
        if (r9 == 4) goto L37;
        if (r9 == 5) goto L38;
        if (r9 == 6) goto L38;
        r6[2] = "<init>";
        goto L38
    L37:
        r6[2] = "toString";
    L38:
        String r7 = String.format(r4, r6);
        if (r9 == 2) goto L45;
        if (r9 == 3) goto L45;
        if (r9 == 5) goto L45;
        if (r9 == 6) goto L45;
        throw new IllegalArgumentException(r7);
    L45:
        throw new IllegalStateException(r7);
    L27:
        r6[1] = "toString";
        goto L30
    L28:
        r6[1] = "getOriginal";
        goto L30
    L29:
        r6[1] = "getName";
        goto L30
    L18:
        r6[0] = "descriptor";
        goto L22
    L19:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        goto L22
    L20:
        r6[0] = "name";
    L14:
        r5 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public static String J(kotlin.s0.w.d.l0.c.m r3) {
        if (r3 != null) goto L16;
        F(4);
        throw null;
    L16:
        String r4 = kotlin.s0.w.d.l0.j.c.f20439c.q(r3) + "[" + r3.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(r3)) + "]";     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        return r4;
    L7:
        F(5);
        throw null;
    L9:
        String r5 = r3.getClass().getSimpleName() + " " + r3.getName();
        if (r5 == null) goto L12;
        return r5;
    L12:
        F(6);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.m a() {
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.j0
    public kotlin.s0.w.d.l0.g.f getName() {
        kotlin.s0.w.d.l0.g.f r0 = this.f19004g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(2);
        throw null;
    }

    public String toString() {
        return J(this);
    }
}
