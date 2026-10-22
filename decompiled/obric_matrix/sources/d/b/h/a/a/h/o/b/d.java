package d.b.h.a.a.h.o.b;

/* JADX INFO: loaded from: classes.dex */
final enum d extends Enum<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f13481f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f13482g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f13483h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ d[] f13484i = null;

    static {
        d r0 = new d("HANDSHAKE_UNKNOWN", 0);
        f13481f = r0;
        d r1 = new d("HANDSHAKE_RESUME", 1);
        f13482g = r1;
        d r3 = new d("HANDSHAKE_FULL", 2);
        f13483h = r3;
        f13484i = new d[]{r0, r1, r3};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f13484i.clone();
    }
}
