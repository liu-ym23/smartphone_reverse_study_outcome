package kotlin.s0.w.d.l0.d.b;

/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f19197f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f19198g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ f[] f19199h = null;

    static {
        f19197f = new f("PACKAGE", 0);
        f19198g = new f("CLASSIFIER", 1);
        f19199h = a();
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ f[] a() {
        return new f[]{f19197f, f19198g};
    }

    public static f valueOf(String r1) {
        return (f) Enum.valueOf(f.class, r1);
    }

    public static f[] values() {
        return (f[]) f19199h.clone();
    }
}
