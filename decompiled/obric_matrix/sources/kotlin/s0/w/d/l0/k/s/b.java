package kotlin.s0.w.d.l0.k.s;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f20591f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f20592g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f20593h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ b[] f20594i = null;

    static {
        f20591f = new b("WARNING", 0);
        f20592g = new b("ERROR", 1);
        f20593h = new b("HIDDEN", 2);
        f20594i = a();
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f20591f, f20592g, f20593h};
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f20594i.clone();
    }
}
