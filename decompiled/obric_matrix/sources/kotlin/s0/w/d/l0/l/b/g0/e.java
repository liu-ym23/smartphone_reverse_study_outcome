package kotlin.s0.w.d.l0.l.b.g0;

/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f20759f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f20760g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f20761h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ e[] f20762i = null;

    static {
        f20759f = new e("STABLE", 0);
        f20760g = new e("FIR_UNSTABLE", 1);
        f20761h = new e("IR_UNSTABLE", 2);
        f20762i = a();
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ e[] a() {
        return new e[]{f20759f, f20760g, f20761h};
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) f20762i.clone();
    }
}
