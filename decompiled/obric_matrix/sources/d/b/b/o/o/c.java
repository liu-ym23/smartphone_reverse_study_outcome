package d.b.b.o.o;

/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f13066f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f13067g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f13068h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f13069i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ c[] f13070j = null;

    static {
        c r0 = new c("IO", 0);
        f13066f = r0;
        c r1 = new c("LIGHT_WEIGHT", 1);
        f13067g = r1;
        c r3 = new c("TIME_SENSITIVE", 2);
        f13068h = r3;
        c r5 = new c("CPU", 3);
        f13069i = r5;
        f13070j = new c[]{r0, r1, r3, r5};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) f13070j.clone();
    }
}
