package kotlin.s0.w.d.l0.j;

/* JADX INFO: loaded from: classes2.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f20491f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f20492g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j f20493h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ j[] f20494i = null;

    static {
        f20491f = new j("RENDER_OVERRIDE", 0);
        f20492g = new j("RENDER_OPEN", 1);
        f20493h = new j("RENDER_OPEN_OVERRIDE", 2);
        f20494i = a();
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ j[] a() {
        return new j[]{f20491f, f20492g, f20493h};
    }

    public static j valueOf(String r1) {
        return (j) Enum.valueOf(j.class, r1);
    }

    public static j[] values() {
        return (j[]) f20494i.clone();
    }
}
