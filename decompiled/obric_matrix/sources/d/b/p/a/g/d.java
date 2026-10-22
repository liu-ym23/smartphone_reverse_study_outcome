package d.b.p.a.g;

/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f14303f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f14304g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ d[] f14305h = null;

    static {
        d r0 = new d("IMMEDIATE", 0);
        f14303f = r0;
        d r1 = new d("REGISTER_EXCEPTION", 1);
        f14304g = r1;
        f14305h = new d[]{r0, r1};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f14305h.clone();
    }
}
