package f.a.j.a;

/* JADX INFO: loaded from: classes2.dex */
public final enum d extends Enum<d> implements Object<Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f17053f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f17054g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ d[] f17055h = null;

    static {
        d r0 = new d("INSTANCE", 0);
        f17053f = r0;
        d r1 = new d("NEVER", 1);
        f17054g = r1;
        f17055h = new d[]{r0, r1};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f17055h.clone();
    }

    public void dispose() {
    }
}
