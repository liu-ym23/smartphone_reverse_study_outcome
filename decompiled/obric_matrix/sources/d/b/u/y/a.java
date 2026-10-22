package d.b.u.y;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f15124g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f15125h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ a[] f15126i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15127f;

    static {
        a r0 = new a("ORIGIN", 0, 0);
        f15124g = r0;
        a r1 = new a("FILE_PATH", 1, 1);
        f15125h = r1;
        f15126i = new a[]{r0, r1};
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.f15127f = r3;
    }

    public static a a(int r2) {
        a r0 = f15124g;
        if (r2 != r0.b()) goto L5;
        return r0;
    L5:
        a r1 = f15125h;
        if (r2 != r1.b()) goto L8;
        return r1;
    L8:
        return null;
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f15126i.clone();
    }

    public int b() {
        return this.f15127f;
    }
}
