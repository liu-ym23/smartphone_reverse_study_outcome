package d.b.b.f.e;

/* JADX INFO: loaded from: classes.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f12825f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f12826g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f12827h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f12828i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h f12829j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ h[] f12830k = null;

    static {
        h r0 = new h("PROCESS_DETECT", 0);
        f12825f = r0;
        h r1 = new h("PROCESS_DOUBLE_DETECT", 1);
        f12826g = r1;
        h r3 = new h("THREAD_DETECT", 2);
        f12827h = r3;
        h r5 = new h("COOL_DOWN", 3);
        f12828i = r5;
        h r7 = new h("IDLE", 4);
        f12829j = r7;
        f12830k = new h[]{r0, r1, r3, r5, r7};
    }

    private h(String r1, int r2) {
        super(r1, r2);
    }

    public static h valueOf(String r1) {
        return (h) Enum.valueOf(h.class, r1);
    }

    public static h[] values() {
        return (h[]) f12830k.clone();
    }
}
