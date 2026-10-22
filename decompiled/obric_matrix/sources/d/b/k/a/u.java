package d.b.k.a;

/* JADX INFO: loaded from: classes.dex */
public final enum u extends Enum<u> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f14073f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f14074g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f14075h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f14076i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u f14077j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u f14078k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u f14079l = null;
    public static final u m = null;
    public static final u n = null;
    private static final /* synthetic */ u[] o = null;

    static {
        u r0 = new u("FIT_XY", 0);
        f14073f = r0;
        u r1 = new u("FIT_START", 1);
        f14074g = r1;
        u r3 = new u("FIT_CENTER", 2);
        f14075h = r3;
        u r5 = new u("FIT_END", 3);
        f14076i = r5;
        u r7 = new u("CENTER", 4);
        f14077j = r7;
        u r9 = new u("CENTER_INSIDE", 5);
        f14078k = r9;
        u r11 = new u("CENTER_CROP", 6);
        f14079l = r11;
        u r13 = new u("FOCUS_CROP", 7);
        m = r13;
        u r15 = new u("FIT_BOTTOM_START", 8);
        n = r15;
        o = new u[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    private u(String r1, int r2) {
        super(r1, r2);
    }

    public static u valueOf(String r1) {
        return (u) Enum.valueOf(u.class, r1);
    }

    public static u[] values() {
        return (u[]) o.clone();
    }
}
