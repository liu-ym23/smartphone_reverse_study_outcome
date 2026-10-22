package d.b.l.a.h;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f14112f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f14113g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f14114h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ b[] f14115i = null;

    static {
        b r0 = new b("IO", 0);
        f14112f = r0;
        b r1 = new b("TIME_SENSITIVE", 1);
        f14113g = r1;
        b r3 = new b("LIGHT_WEIGHT", 2);
        f14114h = r3;
        f14115i = new b[]{r0, r1, r3};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f14115i.clone();
    }
}
