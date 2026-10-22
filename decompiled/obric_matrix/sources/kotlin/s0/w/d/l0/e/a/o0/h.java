package kotlin.s0.w.d.l0.e.a.o0;

/* JADX INFO: loaded from: classes2.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f19559f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f19560g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f19561h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ h[] f19562i = null;

    static {
        f19559f = new h("FORCE_FLEXIBILITY", 0);
        f19560g = new h("NULLABLE", 1);
        f19561h = new h("NOT_NULL", 2);
        f19562i = a();
    }

    private h(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ h[] a() {
        return new h[]{f19559f, f19560g, f19561h};
    }

    public static h valueOf(String r1) {
        return (h) Enum.valueOf(h.class, r1);
    }

    public static h[] values() {
        return (h[]) f19562i.clone();
    }
}
