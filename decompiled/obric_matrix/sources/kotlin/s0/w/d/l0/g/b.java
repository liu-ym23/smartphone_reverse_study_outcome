package kotlin.s0.w.d.l0.g;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f20257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f20258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20259c;

    static {
    }

    public b(c r2, c r3, boolean r4) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this.f20257a = r2;
        this.f20258b = r3;
        this.f20259c = r4;
        return;
    L7:
        a(2);
        throw null;
    L9:
        a(1);
        throw null;
    }

    public b(c r2, f r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this(r2, c.k(r3), false);
        return;
    L7:
        a(4);
        throw null;
    L9:
        a(3);
        throw null;
    }

    private static /* synthetic */ void a(int r10) {
        if (r10 == 5) goto L9;
        if (r10 == 6) goto L9;
        if (r10 == 7) goto L9;
        if (r10 == 9) goto L9;
        switch(r10) {
            case 13: goto L9;
            case 14: goto L9;
            case 15: goto L9;
            case 16: goto L9;
            default: goto L8;
        };
    L8:
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L11:
        if (r10 == 5) goto L17;
        if (r10 == 6) goto L56;
        if (r10 == 7) goto L57;
        if (r10 == 9) goto L58;
        switch(r10) {
            case 13: goto L59;
            case 14: goto L59;
            case 15: goto L59;
            case 16: goto L59;
            default: goto L16;
        };
    L16:
        int r6 = 3;
    L18:
        Object[] r7 = new Object[r6];
        switch(r10) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L24;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L21;
            case 13: goto L24;
            case 14: goto L24;
            case 15: goto L24;
            case 16: goto L24;
            default: goto L20;
        };
    L20:
        r7[0] = "topLevelFqName";
    L29:
        if (r10 == 5) goto L40;
        if (r10 == 6) goto L39;
        if (r10 == 7) goto L38;
        if (r10 == 9) goto L37;
        switch(r10) {
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L35;
            default: goto L34;
        };
    L34:
        r7[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
    L41:
        switch(r10) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L46;
            case 4: goto L46;
            case 5: goto L47;
            case 6: goto L47;
            case 7: goto L47;
            case 8: goto L45;
            case 9: goto L47;
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L47;
            case 14: goto L47;
            case 15: goto L47;
            case 16: goto L47;
            default: goto L42;
        };
    L42:
        r7[2] = "topLevel";
        goto L47
    L43:
        r7[2] = "fromString";
        goto L47
    L44:
        r7[2] = "startsWith";
        goto L47
    L45:
        r7[2] = "createNestedClassId";
        goto L47
    L46:
        r7[2] = "<init>";
    L47:
        String r5 = String.format(r4, r7);
        if (r10 == 5) goto L55;
        if (r10 == 6) goto L55;
        if (r10 == 7) goto L55;
        if (r10 == 9) goto L55;
        switch(r10) {
            case 13: goto L55;
            case 14: goto L55;
            case 15: goto L55;
            case 16: goto L55;
            default: goto L60;
        };
    L60:
        throw new IllegalArgumentException(r5);
    L55:
        throw new IllegalStateException(r5);
    L35:
        r7[1] = "asFqNameString";
        goto L41
    L36:
        r7[1] = "asString";
        goto L41
    L37:
        r7[1] = "asSingleFqName";
        goto L41
    L38:
        r7[1] = "getShortClassName";
        goto L41
    L39:
        r7[1] = "getRelativeClassName";
        goto L41
    L40:
        r7[1] = "getPackageFqName";
        goto L41
    L21:
        r7[0] = TypedValues.Custom.S_STRING;
        goto L29
    L22:
        r7[0] = "segment";
        goto L29
    L23:
        r7[0] = "name";
        goto L29
    L24:
        r7[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        goto L29
    L25:
        r7[0] = "topLevelName";
        goto L29
    L26:
        r7[0] = "relativeClassName";
        goto L29
    L27:
        r7[0] = "packageFqName";
        goto L29
    L59:
        r6 = 2;
        goto L18
    L58:
        r6 = 2;
        goto L18
    L57:
        r6 = 2;
        goto L18
    L56:
        r6 = 2;
        goto L18
    L17:
        r6 = 2;
    L9:
        r4 = "@NotNull method %s.%s must not return null";
        goto L11
    }

    public static b e(String r1) {
        if (r1 != null) goto L4;
        a(11);
        throw null;
    L4:
        return f(r1, false);
    }

    public static b f(String r4, boolean r5) {
        if (r4 == null) goto L9;
        int r0 = r4.lastIndexOf("/");
        if (r0 != (-1)) goto L6;
        String r1 = "";
    L8:
        return new b(new c(r1), new c(r4), r5);
    L6:
        String r2 = r4.substring(0, r0).replace('/', '.');
        r4 = r4.substring(r0 + 1);
        r1 = r2;
        goto L8
    L9:
        a(12);
        throw null;
    }

    public static b m(c r2) {
        if (r2 != null) goto L4;
        a(0);
        throw null;
    L4:
        return new b(r2.e(), r2.g());
    }

    public c b() {
        if (this.f20257a.d() == false) goto L10;
        c r3 = this.f20258b;
        if (r3 == null) goto L7;
        return r3;
    L7:
        a(9);
        throw null;
    L10:
        return new c(this.f20257a.b() + "." + this.f20258b.b());
    }

    public String c() {
        if (this.f20257a.d() == false) goto L9;
        String r5 = this.f20258b.b();
        if (r5 == null) goto L7;
        return r5;
    L7:
        a(13);
        throw null;
    L9:
        String r6 = this.f20257a.b().replace('.', '/') + "/" + this.f20258b.b();
        if (r6 == null) goto L12;
        return r6;
    L12:
        a(14);
        throw null;
    }

    public b d(f r4) {
        if (r4 != null) goto L4;
        a(8);
        throw null;
    L4:
        return new b(h(), this.f20258b.c(r4), this.f20259c);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (b.class != r5.getClass()) goto L19;
        b r6 = (b) r5;
        if (this.f20257a.equals(r6.f20257a) == false) goto L18;
        if (this.f20258b.equals(r6.f20258b) == false) goto L18;
        if (this.f20259c != r6.f20259c) goto L18;
        return true;
    L18:
        return false;
    }

    public b g() {
        c r0 = this.f20258b.e();
        if (r0.d() == false) goto L6;
        return null;
    L6:
        return new b(h(), r0, this.f20259c);
    }

    public c h() {
        c r0 = this.f20257a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(5);
        throw null;
    }

    public int hashCode() {
        return (((this.f20257a.hashCode() * 31) + this.f20258b.hashCode()) * 31) + Boolean.valueOf(this.f20259c).hashCode();
    }

    public c i() {
        c r0 = this.f20258b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(6);
        throw null;
    }

    public f j() {
        f r0 = this.f20258b.g();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(7);
        throw null;
    }

    public boolean k() {
        return this.f20259c;
    }

    public boolean l() {
        return !this.f20258b.e().d();
    }

    public String toString() {
        if (this.f20257a.d() == false) goto L6;
        return "/" + c();
    L6:
        return c();
    }
}
