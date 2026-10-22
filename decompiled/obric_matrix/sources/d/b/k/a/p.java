package d.b.k.a;

/* JADX INFO: loaded from: classes.dex */
public final enum p extends Enum<p> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f14015f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p f14016g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p f14017h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ p[] f14018i = null;

    static {
        p r0 = new p("LOW", 0);
        f14015f = r0;
        p r1 = new p("MEDIUM", 1);
        f14016g = r1;
        p r3 = new p("HIGH", 2);
        f14017h = r3;
        f14018i = new p[]{r0, r1, r3};
    }

    private p(String r1, int r2) {
        super(r1, r2);
    }

    public static p valueOf(String r1) {
        return (p) Enum.valueOf(p.class, r1);
    }

    public static p[] values() {
        return (p[]) f14018i.clone();
    }
}
