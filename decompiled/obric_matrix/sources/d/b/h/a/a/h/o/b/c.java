package d.b.h.a.a.h.o.b;

/* JADX INFO: loaded from: classes.dex */
final enum c extends Enum<c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f13474g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f13475h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f13476i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f13477j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f13478k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f13479l = null;
    private static final /* synthetic */ c[] m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f13480f;

    static {
        c r0 = new c("CONNECTION_INFO_UNKNOWN", 0, 0);
        f13474g = r0;
        c r1 = new c("CONNECTION_INFO_HTTP1_1", 1, 1);
        f13475h = r1;
        c r3 = new c("CONNECTION_INFO_DEPRECATED_SPDY3", 2, 3);
        f13476i = r3;
        c r5 = new c("CONNECTION_INFO_HTTP2", 3, 4);
        f13477j = r5;
        c r8 = new c("CONNECTION_INFO_QUIC_UNKNOWN_VERSION", 4, 5);
        f13478k = r8;
        c r10 = new c("CONNECTION_INFO_HTTP1_0", 5, 9);
        f13479l = r10;
        m = new c[]{r0, r1, r3, r5, r8, r10};
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
        this.f13480f = r3;
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) m.clone();
    }
}
