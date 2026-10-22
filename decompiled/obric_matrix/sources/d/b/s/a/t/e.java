package d.b.s.a.t;

/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f14935f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ e[] f14936g = null;

    static {
        e r1 = new e("CENTER", 0);
        f14935f = r1;
        f14936g = new e[]{r1, new e("BOTTOM", 1)};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) f14936g.clone();
    }
}
