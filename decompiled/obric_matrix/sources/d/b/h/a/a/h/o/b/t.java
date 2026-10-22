package d.b.h.a.a.h.o.b;

/* JADX INFO: loaded from: classes.dex */
final enum t extends Enum<t> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t f13541f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f13542g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final t f13543h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final t f13544i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final t f13545j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ t[] f13546k = null;

    static {
        t r0 = new t("UNKNOWN", 0);
        f13541f = r0;
        t r1 = new t("SUCCESS", 1);
        f13542g = r1;
        t r3 = new t("IO_PENDING", 2);
        f13543h = r3;
        t r5 = new t("CANCELED", 3);
        f13544i = r5;
        t r7 = new t("FAILED", 4);
        f13545j = r7;
        f13546k = new t[]{r0, r1, r3, r5, r7};
    }

    private t(String r1, int r2) {
        super(r1, r2);
    }

    public static t valueOf(String r1) {
        return (t) Enum.valueOf(t.class, r1);
    }

    public static t[] values() {
        return (t[]) f13546k.clone();
    }
}
