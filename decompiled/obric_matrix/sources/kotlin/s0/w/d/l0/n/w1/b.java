package kotlin.s0.w.d.l0.n.w1;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f21182f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f21183g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f21184h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ b[] f21185i = null;

    static {
        f21182f = new b("FOR_SUBTYPING", 0);
        f21183g = new b("FOR_INCORPORATION", 1);
        f21184h = new b("FROM_EXPRESSION", 2);
        f21185i = a();
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f21182f, f21183g, f21184h};
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f21185i.clone();
    }
}
