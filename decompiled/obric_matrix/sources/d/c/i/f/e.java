package d.c.i.f;

/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f16015f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f16016g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f16017h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f16018i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ e[] f16019j = null;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16020a = null;

        static {
            int[] r0 = new int[e.values().length];
            f16020a = r0;
            r0[e.f16015f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f16020a[e.f16016g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f16020a[e.f16017h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f16020a[e.f16018i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        e r0 = new e("LOW", 0);
        f16015f = r0;
        e r1 = new e("MEDIUM", 1);
        f16016g = r1;
        e r3 = new e("HIGH", 2);
        f16017h = r3;
        e r5 = new e("IMMEDIATE", 3);
        f16018i = r5;
        f16019j = new e[]{r0, r1, r3, r5};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e a(e r2, e r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r3 != null) goto L7;
        return r2;
    L7:
        if (r2.ordinal() <= r3.ordinal()) goto L9;
        return r2;
    L9:
        return r3;
    }

    public static int b(e r3) {
        int r4 = a.f16020a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return 0;
    L5:
        if (r4 != 3) goto L7;
        return 2;
    L7:
        if (r4 == 4) goto L9;
        return 1;
    L9:
        return 3;
    }

    public static e c(e r2, e r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r3 != null) goto L7;
        return r2;
    L7:
        if (r2.ordinal() >= r3.ordinal()) goto L9;
        return r2;
    L9:
        return r3;
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) f16019j.clone();
    }
}
