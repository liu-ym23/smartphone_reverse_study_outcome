package kotlin.s0.w.d.l0.j;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f20428h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f20429i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f20430j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ a[] f20431k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f20432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f20433g;

    static {
        f20428h = new a("NO_ARGUMENTS", 0, false, false, 3, null);
        f20429i = new a("UNLESS_EMPTY", 1, true, false, 2, null);
        f20430j = new a("ALWAYS_PARENTHESIZED", 2, true, true);
        f20431k = a();
    }

    private a(String r1, int r2, boolean r3, boolean r4) {
        super(r1, r2);
        this.f20432f = r3;
        this.f20433g = r4;
    }

    /* synthetic */ a(String r2, int r3, boolean r4, boolean r5, int r6, kotlin.n0.d.g r7) {
        if ((r6 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r5 = false;
    L8:
        this(r2, r3, r4, r5);
    }

    private static final /* synthetic */ a[] a() {
        return new a[]{f20428h, f20429i, f20430j};
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f20431k.clone();
    }

    public final boolean b() {
        return this.f20432f;
    }

    public final boolean c() {
        return this.f20433g;
    }
}
