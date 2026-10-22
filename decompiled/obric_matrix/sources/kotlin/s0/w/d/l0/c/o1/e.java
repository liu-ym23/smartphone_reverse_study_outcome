package kotlin.s0.w.d.l0.c.o1;

/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f18906g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f18907h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f18908i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f18909j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f18910k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f18911l = null;
    public static final e m = null;
    public static final e n = null;
    public static final e o = null;
    private static final /* synthetic */ e[] p = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f18912f;

    static {
        f18906g = new e("FIELD", 0, null, 1, null);
        f18907h = new e("FILE", 1, null, 1, null);
        f18908i = new e("PROPERTY", 2, null, 1, null);
        f18909j = new e("PROPERTY_GETTER", 3, "get");
        f18910k = new e("PROPERTY_SETTER", 4, "set");
        f18911l = new e("RECEIVER", 5, null, 1, null);
        m = new e("CONSTRUCTOR_PARAMETER", 6, "param");
        n = new e("SETTER_PARAMETER", 7, "setparam");
        o = new e("PROPERTY_DELEGATE_FIELD", 8, "delegate");
        p = a();
    }

    private e(String r1, int r2, String r3) {
        super(r1, r2);
        if (r3 != null) goto L5;
        r3 = kotlin.s0.w.d.l0.o.u.a.f(name());
    L5:
        this.f18912f = r3;
    }

    /* synthetic */ e(String r1, int r2, String r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 1) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    private static final /* synthetic */ e[] a() {
        return new e[]{f18906g, f18907h, f18908i, f18909j, f18910k, f18911l, m, n, o};
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) p.clone();
    }

    public final String b() {
        return this.f18912f;
    }
}
