package d.c.c.g;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f15395g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f15396h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f15397i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f15398j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f15399k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ b[] f15400l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f15401f;

    static {
        b r0 = new b("OnCloseToDalvikHeapLimit", 0, 0.5d);
        f15395g = r0;
        b r1 = new b("OnSystemMemoryCriticallyLowWhileAppInForeground", 1, 1.0d);
        f15396h = r1;
        b r5 = new b("OnSystemLowMemoryWhileAppInForeground", 2, 0.5d);
        f15397i = r5;
        b r3 = new b("OnSystemLowMemoryWhileAppInBackground", 3, 1.0d);
        f15398j = r3;
        b r4 = new b("OnAppBackgrounded", 4, 1.0d);
        f15399k = r4;
        f15400l = new b[]{r0, r1, r5, r3, r4};
    }

    private b(String r1, int r2, double r3) {
        super(r1, r2);
        this.f15401f = r3;
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f15400l.clone();
    }

    public double a() {
        return this.f15401f;
    }
}
