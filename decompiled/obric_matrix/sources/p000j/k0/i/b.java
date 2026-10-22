package p000j.k0.i;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f17926g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f17927h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f17928i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f17929j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f17930k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f17931l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    public static final b p = null;
    public static final b q = null;
    private static final /* synthetic */ b[] r = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17932f;

    static {
        b r0 = new b("NO_ERROR", 0, 0);
        f17926g = r0;
        b r1 = new b("PROTOCOL_ERROR", 1, 1);
        f17927h = r1;
        b r3 = new b("INTERNAL_ERROR", 2, 2);
        f17928i = r3;
        b r5 = new b("FLOW_CONTROL_ERROR", 3, 3);
        f17929j = r5;
        b r7 = new b("REFUSED_STREAM", 4, 7);
        f17930k = r7;
        b r9 = new b("CANCEL", 5, 8);
        f17931l = r9;
        b r12 = new b("COMPRESSION_ERROR", 6, 9);
        m = r12;
        b r15 = new b("CONNECT_ERROR", 7, 10);
        n = r15;
        b r13 = new b("ENHANCE_YOUR_CALM", 8, 11);
        o = r13;
        b r11 = new b("INADEQUATE_SECURITY", 9, 12);
        p = r11;
        b r4 = new b("HTTP_1_1_REQUIRED", 10, 13);
        q = r4;
        r = new b[]{r0, r1, r3, r5, r7, r9, r12, r15, r13, r11, r4};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.f17932f = r3;
    }

    public static b a(int r5) {
        b[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        b r3 = r0[r2];
        if (r3.f17932f == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) r.clone();
    }
}
