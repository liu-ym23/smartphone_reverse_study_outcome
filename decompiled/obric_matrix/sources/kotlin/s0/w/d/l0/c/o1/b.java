package kotlin.s0.w.d.l0.c.o1;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f18902f;

    public b(g r1) {
        if (r1 == null) goto L5;
        this.f18902f = r1;
        return;
    L5:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r7) {
        if (r7 == 1) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 1) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        if (r7 == 1) goto L13;
        r4[0] = "annotations";
    L14:
        if (r7 == 1) goto L16;
        r4[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
    L17:
        if (r7 == 1) goto L19;
        r4[2] = "<init>";
    L19:
        String r2 = String.format(r1, r4);
        if (r7 == 1) goto L23;
        throw new IllegalArgumentException(r2);
    L23:
        throw new IllegalStateException(r2);
    L16:
        r4[1] = "getAnnotations";
        goto L17
    L13:
        r4[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        goto L14
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public g getAnnotations() {
        g r0 = this.f18902f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(1);
        throw null;
    }
}
