package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final enum r1 extends Enum<r1> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r1 f21065h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final r1 f21066i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final r1 f21067j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ r1[] f21068k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f21070g;

    static {
        f21065h = new r1("INVARIANT", 0, "", true, true, 0);
        f21066i = new r1("IN_VARIANCE", 1, "in", true, false, -1);
        f21067j = new r1("OUT_VARIANCE", 2, "out", false, true, 1);
        f21068k = a();
    }

    private r1(String r1, int r2, String r3, boolean r4, boolean r5, int r6) {
        super(r1, r2);
        this.f21069f = r3;
        this.f21070g = r5;
    }

    private static final /* synthetic */ r1[] a() {
        return new r1[]{f21065h, f21066i, f21067j};
    }

    public static r1 valueOf(String r1) {
        return (r1) Enum.valueOf(r1.class, r1);
    }

    public static r1[] values() {
        return (r1[]) f21068k.clone();
    }

    public final boolean b() {
        return this.f21070g;
    }

    public final String c() {
        return this.f21069f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f21069f;
    }
}
