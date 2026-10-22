package kotlin.s0.w.d.l0.e.a;

/* JADX INFO: loaded from: classes2.dex */
public final enum f0 extends Enum<f0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f0 f19253g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f0 f19254h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f0 f19255i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ f0[] f19256j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19257f;

    static {
        f19253g = new f0("IGNORE", 0, "ignore");
        f19254h = new f0("WARN", 1, "warn");
        f19255i = new f0("STRICT", 2, "strict");
        f19256j = a();
    }

    private f0(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19257f = r3;
    }

    private static final /* synthetic */ f0[] a() {
        return new f0[]{f19253g, f19254h, f19255i};
    }

    public static f0 valueOf(String r1) {
        return (f0) Enum.valueOf(f0.class, r1);
    }

    public static f0[] values() {
        return (f0[]) f19256j.clone();
    }

    public final String b() {
        return this.f19257f;
    }

    public final boolean c() {
        if (this != f19253g) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g() {
        if (this != f19254h) goto L5;
        return true;
    L5:
        return false;
    }
}
