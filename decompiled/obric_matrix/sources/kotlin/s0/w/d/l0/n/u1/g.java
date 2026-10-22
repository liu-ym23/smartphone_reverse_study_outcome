package kotlin.s0.w.d.l0.n.u1;

/* JADX INFO: loaded from: classes2.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f21141g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f21142h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f21143i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f21144j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g f21145k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g f21146l = null;
    public static final g m = null;
    public static final g n = null;
    public static final g o = null;
    public static final g p = null;
    private static final /* synthetic */ g[] q = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21147f;

    static {
        f21141g = new g("CAPTURED_TYPE_SCOPE", 0, "No member resolution should be done on captured type, it used only during constraint system resolution");
        f21142h = new g("INTEGER_LITERAL_TYPE_SCOPE", 1, "Scope for integer literal type (%s)");
        f21143i = new g("ERASED_RECEIVER_TYPE_SCOPE", 2, "Error scope for erased receiver type");
        f21144j = new g("SCOPE_FOR_ABBREVIATION_TYPE", 3, "Scope for abbreviation %s");
        f21145k = new g("STUB_TYPE_SCOPE", 4, "Scope for stub type %s");
        f21146l = new g("NON_CLASSIFIER_SUPER_TYPE_SCOPE", 5, "A scope for common supertype which is not a normal classifier");
        m = new g("ERROR_TYPE_SCOPE", 6, "Scope for error type %s");
        n = new g("UNSUPPORTED_TYPE_SCOPE", 7, "Scope for unsupported type %s");
        o = new g("SCOPE_FOR_ERROR_CLASS", 8, "Error scope for class %s with arguments: %s");
        p = new g("SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE", 9, "Error resolution candidate for call %s");
        q = a();
    }

    private g(String r1, int r2, String r3) {
        super(r1, r2);
        this.f21147f = r3;
    }

    private static final /* synthetic */ g[] a() {
        return new g[]{f21141g, f21142h, f21143i, f21144j, f21145k, f21146l, m, n, o, p};
    }

    public static g valueOf(String r1) {
        return (g) Enum.valueOf(g.class, r1);
    }

    public static g[] values() {
        return (g[]) q.clone();
    }

    public final String b() {
        return this.f21147f;
    }
}
