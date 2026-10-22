package d.a.a;

/* JADX INFO: loaded from: classes.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f12377f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f12378g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f12379h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f12380i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ g[] f12381j = null;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12382a = null;

        static {
            int[] r0 = new int[g.values().length];
            f12382a = r0;
            r0[g.f12379h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f12382a[g.f12380i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f12382a[g.f12378g.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f12382a[g.f12377f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        g r0 = new g("CamelCase", 0);
        f12377f = r0;
        g r1 = new g("PascalCase", 1);
        f12378g = r1;
        g r3 = new g("SnakeCase", 2);
        f12379h = r3;
        g r5 = new g("KebabCase", 3);
        f12380i = r5;
        f12381j = new g[]{r0, r1, r3, r5};
    }

    private g(String r1, int r2) {
        super(r1, r2);
    }

    public static g valueOf(String r1) {
        return (g) Enum.valueOf(g.class, r1);
    }

    public static g[] values() {
        return (g[]) f12381j.clone();
    }

    public String a(String r6) {
        int r5 = a.f12382a[ordinal()];
        int r3 = 0;
        if (r5 != 1) goto L5;
        StringBuilder r7 = new StringBuilder();
    L36:
        if (r3 >= r6.length()) goto L45;
        char r2 = r6.charAt(r3);
        if (r2 < 'A') goto L43;
        if (r2 > 'Z') goto L43;
        r2 = (char) (r2 + ' ');
        if (r3 <= 0) goto L43;
        r7.append('_');
    L43:
        r7.append(r2);
        r3 = r3 + 1;
        goto L36
    L45:
        return r7.toString();
    L5:
        if (r5 != 2) goto L7;
        StringBuilder r8 = new StringBuilder();
    L24:
        if (r3 >= r6.length()) goto L33;
        char r4 = r6.charAt(r3);
        if (r4 < 'A') goto L31;
        if (r4 > 'Z') goto L31;
        r4 = (char) (r4 + ' ');
        if (r3 <= 0) goto L31;
        r8.append('-');
    L31:
        r8.append(r4);
        r3 = r3 + 1;
        goto L24
    L33:
        return r8.toString();
    L7:
        if (r5 != 3) goto L9;
        char r9 = r6.charAt(0);
        if (r9 >= 'a') goto L19;
        return r6;
    L19:
        if (r9 > 'z') goto L59;
        char[] r10 = r6.toCharArray();
        r10[0] = (char) (r10[0] - ' ');
        return new String(r10);
    L59:
        return r6;
    L9:
        if (r5 == 4) goto L11;
        return r6;
    L11:
        char r11 = r6.charAt(0);
        if (r11 < 'A') goto L56;
        if (r11 > 'Z') goto L57;
        char[] r12 = r6.toCharArray();
        r12[0] = (char) (r12[0] + ' ');
        return new String(r12);
    L57:
        return r6;
    L56:
        return r6;
    }
}
