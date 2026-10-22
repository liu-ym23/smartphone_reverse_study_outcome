package kotlin.s0.w.d.l0.k.u;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20605a;

    private d(String r1) {
        if (r1 == null) goto L5;
        this.f20605a = r1;
        return;
    L5:
        a(5);
        throw null;
    }

    private static /* synthetic */ void a(int r10) {
        if (r10 == 3) goto L8;
        if (r10 == 6) goto L8;
        if (r10 == 7) goto L8;
        if (r10 == 8) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 3) goto L15;
        if (r10 == 6) goto L15;
        if (r10 == 7) goto L15;
        if (r10 == 8) goto L15;
        int r6 = 3;
    L16:
        Object[] r7 = new Object[r6];
        switch(r10) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L19;
            default: goto L18;
        };
    L18:
        r7[0] = "internalName";
    L23:
        if (r10 == 3) goto L31;
        if (r10 == 6) goto L30;
        if (r10 == 7) goto L29;
        if (r10 == 8) goto L28;
        r7[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
    L32:
        switch(r10) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L37;
            default: goto L33;
        };
    L33:
        r7[2] = "byInternalName";
        goto L37
    L34:
        r7[2] = "<init>";
        goto L37
    L35:
        r7[2] = "byFqNameWithoutInnerClasses";
        goto L37
    L36:
        r7[2] = "byClassId";
    L37:
        String r5 = String.format(r4, r7);
        if (r10 == 3) goto L44;
        if (r10 == 6) goto L44;
        if (r10 == 7) goto L44;
        if (r10 == 8) goto L44;
        throw new IllegalArgumentException(r5);
    L44:
        throw new IllegalStateException(r5);
    L28:
        r7[1] = "getInternalName";
        goto L32
    L29:
        r7[1] = "getPackageFqName";
        goto L32
    L30:
        r7[1] = "getFqNameForClassNameWithoutDollars";
        goto L32
    L31:
        r7[1] = "byFqNameWithoutInnerClasses";
        goto L32
    L19:
        r7[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        goto L23
    L20:
        r7[0] = "fqName";
        goto L23
    L21:
        r7[0] = "classId";
    L15:
        r6 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    public static d b(kotlin.s0.w.d.l0.g.b r5) {
        if (r5 == null) goto L8;
        kotlin.s0.w.d.l0.g.c r0 = r5.h();
        String r6 = r5.i().b().replace('.', '$');
        if (r0.d() == false) goto L7;
        return new d(r6);
    L7:
        return new d(r0.b().replace('.', '/') + "/" + r6);
    L8:
        a(1);
        throw null;
    }

    public static d c(kotlin.s0.w.d.l0.g.c r3) {
        if (r3 != null) goto L4;
        a(2);
        throw null;
    L4:
        return new d(r3.b().replace('.', '/'));
    }

    public static d d(String r1) {
        if (r1 != null) goto L4;
        a(0);
        throw null;
    L4:
        return new d(r1);
    }

    public kotlin.s0.w.d.l0.g.c e() {
        return new kotlin.s0.w.d.l0.g.c(this.f20605a.replace('/', '.'));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (d.class == r3.getClass()) goto L10;
        return false;
    L10:
        return this.f20605a.equals(((d) r3).f20605a);
    }

    public String f() {
        String r0 = this.f20605a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(8);
        throw null;
    }

    public kotlin.s0.w.d.l0.g.c g() {
        int r0 = this.f20605a.lastIndexOf("/");
        if (r0 != (-1)) goto L10;
        kotlin.s0.w.d.l0.g.c r3 = kotlin.s0.w.d.l0.g.c.f20260c;
        if (r3 == null) goto L7;
        return r3;
    L7:
        a(7);
        throw null;
    L10:
        return new kotlin.s0.w.d.l0.g.c(this.f20605a.substring(0, r0).replace('/', '.'));
    }

    public int hashCode() {
        return this.f20605a.hashCode();
    }

    public String toString() {
        return this.f20605a;
    }
}
