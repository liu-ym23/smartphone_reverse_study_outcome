package d.b.h.a.a.h.o.b;

/* JADX INFO: loaded from: classes.dex */
final enum u extends Enum<u> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f13547g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f13548h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f13549i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u f13550j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u f13551k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ u[] f13552l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f13553f;

    static {
        u r0 = new u("UNKNOWN", 0, -1);
        f13547g = r0;
        u r1 = new u("SOURCE_HTTPDNS", 1, 3);
        f13548h = r1;
        u r3 = new u("SOURCE_PROC", 2, 6);
        f13549i = r3;
        u r6 = new u("SOURCE_PRELOAD_BATCH_HTTPDNS", 3, 7);
        f13550j = r6;
        u r8 = new u("SOURCE_ASYNC_BATCH_HTTPDNS", 4, 8);
        f13551k = r8;
        f13552l = new u[]{r0, r1, r3, r6, r8};
    }

    private u(String r1, int r2, int r3) {
        super(r1, r2);
        this.f13553f = r3;
    }

    public static u valueOf(String r1) {
        return (u) Enum.valueOf(u.class, r1);
    }

    public static u[] values() {
        return (u[]) f13552l.clone();
    }
}
