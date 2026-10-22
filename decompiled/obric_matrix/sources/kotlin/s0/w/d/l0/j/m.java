package kotlin.s0.w.d.l0.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum m extends Enum<m> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f20503f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f20504g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ m[] f20505h = null;

    static {
        final String r1 = "PLAIN";
        final int r2 = 0;
        f20503f = new b(r1, r2);
        final String r3 = "HTML";
        final int r4 = 1;
        f20504g = new a(r3, r4);
        f20505h = a();
    }

    private m(String r1, int r2) {
        super(r1, r2);
    }

    public /* synthetic */ m(String r1, int r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    private static final /* synthetic */ m[] a() {
        return new m[]{f20503f, f20504g};
    }

    public static m valueOf(String r1) {
        return (m) Enum.valueOf(m.class, r1);
    }

    public static m[] values() {
        return (m[]) f20505h.clone();
    }

    public abstract String b(String r1);
}
