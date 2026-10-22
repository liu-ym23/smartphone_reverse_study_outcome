package d.b.h.a.a.f;

/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f13282f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f13283g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f13284h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f13285i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f13286j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ c[] f13287k = null;

    static {
        c r0 = new c("POOR", 0);
        f13282f = r0;
        c r1 = new c("MODERATE", 1);
        f13283g = r1;
        c r3 = new c("GOOD", 2);
        f13284h = r3;
        c r5 = new c("EXCELLENT", 3);
        f13285i = r5;
        c r7 = new c("UNKNOWN", 4);
        f13286j = r7;
        f13287k = new c[]{r0, r1, r3, r5, r7};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) f13287k.clone();
    }
}
