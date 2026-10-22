package kotlin.s0.w.d.l0.c.q1;

import kotlin.s0.w.d.l0.c.a1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.m f18998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a1 f18999l;
    private final boolean m;

    protected g(kotlin.s0.w.d.l0.m.n r2, kotlin.s0.w.d.l0.c.m r3, kotlin.s0.w.d.l0.g.f r4, a1 r5, boolean r6) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L13;
        if (r4 == null) goto L11;
        if (r5 == null) goto L9;
        super(r2, r4);
        this.f18998k = r3;
        this.f18999l = r5;
        this.m = r6;
        return;
    L9:
        A0(3);
        throw null;
    L11:
        A0(2);
        throw null;
    L13:
        A0(1);
        throw null;
    L15:
        A0(0);
        throw null;
    }

    private static /* synthetic */ void A0(int r9) {
        if (r9 == 4) goto L6;
        if (r9 == 5) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 4) goto L11;
        if (r9 == 5) goto L11;
        int r5 = 3;
    L12:
        Object[] r6 = new Object[r5];
        if (r9 == 1) goto L22;
        if (r9 == 2) goto L21;
        if (r9 == 3) goto L20;
        if (r9 == 4) goto L19;
        if (r9 == 5) goto L19;
        r6[0] = "storageManager";
    L23:
        if (r9 == 4) goto L27;
        if (r9 == 5) goto L26;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
    L28:
        if (r9 == 4) goto L31;
        if (r9 == 5) goto L31;
        r6[2] = "<init>";
    L31:
        String r3 = String.format(r2, r6);
        if (r9 == 4) goto L36;
        if (r9 == 5) goto L36;
        throw new IllegalArgumentException(r3);
    L36:
        throw new IllegalStateException(r3);
    L26:
        r6[1] = "getSource";
        goto L28
    L27:
        r6[1] = "getContainingDeclaration";
    L19:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        goto L23
    L20:
        r6[0] = "source";
        goto L23
    L21:
        r6[0] = "name";
        goto L23
    L22:
        r6[0] = "containingDeclaration";
    L11:
        r5 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.n, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.m c() {
        kotlin.s0.w.d.l0.c.m r0 = this.f18998k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.p
    public a1 getSource() {
        a1 r0 = this.f18999l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(5);
        throw null;
    }

    public boolean isExternal() {
        return this.m;
    }
}
