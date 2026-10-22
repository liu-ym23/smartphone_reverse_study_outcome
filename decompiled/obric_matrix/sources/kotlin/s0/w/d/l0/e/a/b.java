package kotlin.s0.w.d.l0.e.a;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f19216g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f19217h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f19218i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f19219j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f19220k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f19221l = null;
    private static final /* synthetic */ b[] m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19222f;

    static {
        f19216g = new b("METHOD_RETURN_TYPE", 0, "METHOD");
        f19217h = new b("VALUE_PARAMETER", 1, "PARAMETER");
        f19218i = new b("FIELD", 2, "FIELD");
        f19219j = new b("TYPE_USE", 3, "TYPE_USE");
        f19220k = new b("TYPE_PARAMETER_BOUNDS", 4, "TYPE_USE");
        f19221l = new b("TYPE_PARAMETER", 5, "TYPE_PARAMETER");
        m = a();
    }

    private b(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19222f = r3;
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f19216g, f19217h, f19218i, f19219j, f19220k, f19221l};
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) m.clone();
    }

    public final String b() {
        return this.f19222f;
    }
}
