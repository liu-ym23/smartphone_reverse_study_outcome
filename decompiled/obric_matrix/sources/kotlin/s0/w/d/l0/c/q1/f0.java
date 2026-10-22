package kotlin.s0.w.d.l0.c.q1;

/* JADX INFO: loaded from: classes2.dex */
public class f0 extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.m f18996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private kotlin.s0.w.d.l0.k.w.o.f f18997i;

    static {
    }

    public f0(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.k.w.o.f r3, kotlin.s0.w.d.l0.c.o1.g r4) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        super(r4);
        this.f18996h = r2;
        this.f18997i = r3;
        return;
    L8:
        F(2);
        throw null;
    L10:
        F(1);
        throw null;
    L12:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r8) {
        if (r8 == 3) goto L6;
        if (r8 == 4) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 3) goto L11;
        if (r8 == 4) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        switch(r8) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r5[0] = "containingDeclaration";
    L21:
        if (r8 == 3) goto L25;
        if (r8 == 4) goto L24;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
    L26:
        if (r8 == 3) goto L35;
        if (r8 == 4) goto L35;
        if (r8 != 5) goto L31;
        r5[2] = "copy";
        goto L35
    L31:
        if (r8 == 6) goto L33;
        r5[2] = "<init>";
        goto L35
    L33:
        r5[2] = "setOutType";
    L35:
        String r3 = String.format(r2, r5);
        if (r8 == 3) goto L40;
        if (r8 == 4) goto L40;
        throw new IllegalArgumentException(r3);
    L40:
        throw new IllegalStateException(r3);
    L24:
        r5[1] = "getContainingDeclaration";
        goto L26
    L25:
        r5[1] = "getValue";
        goto L26
    L15:
        r5[0] = "outType";
        goto L21
    L16:
        r5[0] = "newOwner";
        goto L21
    L17:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        goto L21
    L18:
        r5[0] = "annotations";
        goto L21
    L19:
        r5[0] = "value";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.m c() {
        kotlin.s0.w.d.l0.c.m r0 = this.f18996h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.x0
    public kotlin.s0.w.d.l0.k.w.o.f getValue() {
        kotlin.s0.w.d.l0.k.w.o.f r0 = this.f18997i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(3);
        throw null;
    }
}
