package kotlin.s0.w.d.l0.g;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Comparable<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f20271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f20272g;

    private f(String r1, boolean r2) {
        if (r1 == null) goto L5;
        this.f20271f = r1;
        this.f20272g = r2;
        return;
    L5:
        a(0);
        throw null;
    }

    private static /* synthetic */ void a(int r9) {
        if (r9 == 1) goto L8;
        if (r9 == 2) goto L8;
        if (r9 == 3) goto L8;
        if (r9 == 4) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 1) goto L14;
        if (r9 == 2) goto L14;
        if (r9 == 3) goto L14;
        if (r9 == 4) goto L14;
        int r5 = 3;
    L15:
        Object[] r6 = new Object[r5];
        if (r9 == 1) goto L21;
        if (r9 == 2) goto L21;
        if (r9 == 3) goto L21;
        if (r9 == 4) goto L21;
        r6[0] = "name";
    L22:
        if (r9 == 1) goto L29;
        if (r9 == 2) goto L28;
        if (r9 == 3) goto L27;
        if (r9 == 4) goto L27;
        r6[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L30:
        switch(r9) {
            case 1: goto L36;
            case 2: goto L36;
            case 3: goto L36;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L32;
            default: goto L31;
        };
    L31:
        r6[2] = "<init>";
        goto L36
    L32:
        r6[2] = "guessByFirstCharacter";
        goto L36
    L33:
        r6[2] = "special";
        goto L36
    L34:
        r6[2] = "isValidIdentifier";
        goto L36
    L35:
        r6[2] = "identifier";
    L36:
        String r7 = String.format(r4, r6);
        if (r9 == 1) goto L43;
        if (r9 == 2) goto L43;
        if (r9 == 3) goto L43;
        if (r9 == 4) goto L43;
        throw new IllegalArgumentException(r7);
    L43:
        throw new IllegalStateException(r7);
    L27:
        r6[1] = "asStringStripSpecialMarkers";
        goto L30
    L28:
        r6[1] = "getIdentifier";
        goto L30
    L29:
        r6[1] = "asString";
    L21:
        r6[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L14:
        r5 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public static f j(String r1) {
        if (r1 != null) goto L4;
        a(8);
        throw null;
    L4:
        if (r1.startsWith("<") == false) goto L8;
        return n(r1);
    L8:
        return k(r1);
    }

    public static f k(String r2) {
        if (r2 != null) goto L4;
        a(5);
        throw null;
    L4:
        return new f(r2, false);
    }

    public static boolean m(String r4) {
        if (r4 != null) goto L4;
        a(6);
        throw null;
    L4:
        if (r4.isEmpty() == false) goto L6;
    L22:
        return false;
    L6:
        if (r4.startsWith("<") == true) goto L22;
        int r0 = 0;
    L10:
        if (r0 >= r4.length()) goto L20;
        char r2 = r4.charAt(r0);
        if (r2 == '.') goto L19;
        if (r2 == '/') goto L19;
        if (r2 == '\\') goto L19;
        r0 = r0 + 1;
    L19:
        return false;
    L20:
        return true;
    }

    public static f n(String r3) {
        if (r3 != null) goto L4;
        a(7);
        throw null;
    L4:
        if (r3.startsWith("<") == false) goto L8;
        return new f(r3, true);
    L8:
        throw new IllegalArgumentException("special name must start with '<': " + r3);
    }

    public String b() {
        String r0 = this.f20271f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(1);
        throw null;
    }

    public int c(f r1) {
        return this.f20271f.compareTo(r1.f20271f);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(f r1) {
        return c(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.f20272g == r6.f20272g) goto L12;
        return false;
    L12:
        if (this.f20271f.equals(r6.f20271f) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String g() {
        if (this.f20272g == true) goto L10;
        String r3 = b();
        if (r3 == null) goto L7;
        return r3;
    L7:
        a(2);
        throw null;
    L10:
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.f20271f.hashCode() * 31) + (this.f20272g ? 1 : 0);
    }

    public boolean l() {
        return this.f20272g;
    }

    public String toString() {
        return this.f20271f;
    }
}
