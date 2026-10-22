package kotlin.s0.w.d.l0.n.u1;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f21125g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f21126h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f21127i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f21128j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f21129k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f21130l = null;
    public static final b m = null;
    private static final /* synthetic */ b[] n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21131f;

    static {
        f21125g = new b("ERROR_CLASS", 0, "<Error class: %s>");
        f21126h = new b("ERROR_FUNCTION", 1, "<Error function>");
        f21127i = new b("ERROR_SCOPE", 2, "<Error scope>");
        f21128j = new b("ERROR_MODULE", 3, "<Error module>");
        f21129k = new b("ERROR_PROPERTY", 4, "<Error property>");
        f21130l = new b("ERROR_TYPE", 5, "[Error type: %s]");
        m = new b("PARENT_OF_ERROR_SCOPE", 6, "<Fake parent for error lexical scope>");
        n = a();
    }

    private b(String r1, int r2, String r3) {
        super(r1, r2);
        this.f21131f = r3;
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f21125g, f21126h, f21127i, f21128j, f21129k, f21130l, m};
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) n.clone();
    }

    public final String b() {
        return this.f21131f;
    }
}
