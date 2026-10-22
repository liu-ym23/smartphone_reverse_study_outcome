package kotlin.s0.w.d.l0.e.a.l0.m;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f19492f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f19493g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f19494h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ b[] f19495i = null;

    static {
        f19492f = new b("INFLEXIBLE", 0);
        f19493g = new b("FLEXIBLE_UPPER_BOUND", 1);
        f19494h = new b("FLEXIBLE_LOWER_BOUND", 2);
        f19495i = a();
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f19492f, f19493g, f19494h};
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f19495i.clone();
    }
}
