package d.b.h.a.a.h.o.b;

/* JADX INFO: loaded from: classes.dex */
final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f13485f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f13486g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f13487h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f13488i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f13489j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f13490k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f13491l = null;
    public static final e m = null;
    public static final e n = null;
    public static final e o = null;
    public static final e p = null;
    public static final e q = null;
    public static final e r = null;
    public static final e s = null;
    public static final e t = null;
    public static final e u = null;
    private static final /* synthetic */ e[] v = null;

    static {
        e r0 = new e("IDLE", 0);
        f13485f = r0;
        e r1 = new e("WAITING_FOR_STALLED_SOCKET_POOL", 1);
        f13486g = r1;
        e r3 = new e("WAITING_FOR_AVAILABLE_SOCKET", 2);
        f13487h = r3;
        e r5 = new e("WAITING_FOR_DELEGATE", 3);
        f13488i = r5;
        e r7 = new e("WAITING_FOR_CACHE", 4);
        f13489j = r7;
        e r9 = new e("WAITING_FOR_APPCACHE", 5);
        f13490k = r9;
        e r11 = new e("DOWNLOADING_PAC_FILE", 6);
        f13491l = r11;
        e r13 = new e("RESOLVING_PROXY_FOR_URL", 7);
        m = r13;
        e r15 = new e("RESOLVING_HOST_IN_PAC_FILE", 8);
        n = r15;
        e r14 = new e("ESTABLISHING_PROXY_TUNNEL", 9);
        o = r14;
        e r12 = new e("RESOLVING_HOST", 10);
        p = r12;
        e r10 = new e("CONNECTING", 11);
        q = r10;
        e r8 = new e("SSL_HANDSHAKE", 12);
        r = r8;
        e r6 = new e("SENDING_REQUEST", 13);
        s = r6;
        e r4 = new e("WAITING_FOR_RESPONSE", 14);
        t = r4;
        e r2 = new e("READING_RESPONSE", 15);
        u = r2;
        v = new e[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) v.clone();
    }
}
