package kotlin.s0.w.d.l0.d.b;

/* JADX INFO: loaded from: classes2.dex */
public final enum d extends Enum<d> implements b {
    public static final d A = null;
    public static final d B = null;
    private static final /* synthetic */ d[] C = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f19186f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f19187g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f19188h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f19189i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f19190j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f19191k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f19192l = null;
    public static final d m = null;
    public static final d n = null;
    public static final d o = null;
    public static final d p = null;
    public static final d q = null;
    public static final d r = null;
    public static final d s = null;
    public static final d t = null;
    public static final d u = null;
    public static final d v = null;
    public static final d w = null;
    public static final d x = null;
    public static final d y = null;
    public static final d z = null;

    static {
        f19186f = new d("FROM_IDE", 0);
        f19187g = new d("FROM_BACKEND", 1);
        f19188h = new d("FROM_TEST", 2);
        f19189i = new d("FROM_BUILTINS", 3);
        f19190j = new d("WHEN_CHECK_DECLARATION_CONFLICTS", 4);
        f19191k = new d("WHEN_CHECK_OVERRIDES", 5);
        f19192l = new d("FOR_SCRIPT", 6);
        m = new d("FROM_REFLECTION", 7);
        n = new d("WHEN_RESOLVE_DECLARATION", 8);
        o = new d("WHEN_GET_DECLARATION_SCOPE", 9);
        p = new d("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);
        q = new d("FOR_ALREADY_TRACKED", 11);
        r = new d("WHEN_GET_ALL_DESCRIPTORS", 12);
        s = new d("WHEN_TYPING", 13);
        t = new d("WHEN_GET_SUPER_MEMBERS", 14);
        u = new d("FOR_NON_TRACKED_SCOPE", 15);
        v = new d("FROM_SYNTHETIC_SCOPE", 16);
        w = new d("FROM_DESERIALIZATION", 17);
        x = new d("FROM_JAVA_LOADER", 18);
        y = new d("WHEN_GET_LOCAL_VARIABLE", 19);
        z = new d("WHEN_FIND_BY_FQNAME", 20);
        A = new d("WHEN_GET_COMPANION_OBJECT", 21);
        B = new d("FOR_DEFAULT_IMPORTS", 22);
        C = a();
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ d[] a() {
        return new d[]{f19186f, f19187g, f19188h, f19189i, f19190j, f19191k, f19192l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B};
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) C.clone();
    }

    @Override // kotlin.s0.w.d.l0.d.b.b
    public a getLocation() {
        return null;
    }
}
