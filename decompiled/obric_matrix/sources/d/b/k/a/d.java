package d.b.k.a;

/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f13979f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f13980g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ d[] f13981h = null;

    static {
        d r0 = new d("SMALL", 0);
        f13979f = r0;
        d r1 = new d("DEFAULT", 1);
        f13980g = r1;
        f13981h = new d[]{r0, r1};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f13981h.clone();
    }
}
