package d.b.h.a.a.h.o.b;

/* JADX INFO: loaded from: classes.dex */
final enum v extends Enum<v> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f13554g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v f13555h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f13556i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v f13557j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v f13558k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v f13559l = null;
    public static final v m = null;
    public static final v n = null;
    private static final /* synthetic */ v[] o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f13560f;

    static {
        v r0 = new v("NOT_SET", 0, 0);
        f13554g = r0;
        v r1 = new v("SERVE_FROM_CACHE", 1, 2);
        f13555h = r1;
        v r3 = new v("SERVE_FROM_PREFER_ADDR", 2, 5);
        f13556i = r3;
        v r6 = new v("SERVE_FROM_HTTP_DNS_JOB", 3, 6);
        f13557j = r6;
        v r8 = new v("SERVE_FROM_PROC_DNS_JOB", 4, 8);
        f13558k = r8;
        v r11 = new v("SERVE_FROM_HARDCODE_HOSTS", 5, 9);
        f13559l = r11;
        v r14 = new v("SERVE_FROM_BATCH_PRELOAD", 6, 19);
        m = r14;
        v r7 = new v("SERVE_FROM_ASYNC_BATCH_PRELOAD", 7, 20);
        n = r7;
        o = new v[]{r0, r1, r3, r6, r8, r11, r14, r7};
    }

    private v(String r1, int r2, int r3) {
        super(r1, r2);
        this.f13560f = r3;
    }

    public static v valueOf(String r1) {
        return (v) Enum.valueOf(v.class, r1);
    }

    public static v[] values() {
        return (v[]) o.clone();
    }
}
