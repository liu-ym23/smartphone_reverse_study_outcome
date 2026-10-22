package kotlin.s0.w.d.l0.e.a.o0;

/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f19555f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f19556g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ f[] f19557h = null;

    static {
        f19555f = new f("READ_ONLY", 0);
        f19556g = new f("MUTABLE", 1);
        f19557h = a();
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ f[] a() {
        return new f[]{f19555f, f19556g};
    }

    public static f valueOf(String r1) {
        return (f) Enum.valueOf(f.class, r1);
    }

    public static f[] values() {
        return (f[]) f19557h.clone();
    }
}
