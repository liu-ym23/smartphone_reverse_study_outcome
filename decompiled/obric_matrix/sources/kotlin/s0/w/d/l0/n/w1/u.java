package kotlin.s0.w.d.l0.n.w1;

/* JADX INFO: loaded from: classes2.dex */
public final enum u extends Enum<u> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f21187g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f21188h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f21189i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ u[] f21190j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21191f;

    static {
        f21187g = new u("IN", 0, "in");
        f21188h = new u("OUT", 1, "out");
        f21189i = new u("INV", 2, "");
        f21190j = a();
    }

    private u(String r1, int r2, String r3) {
        super(r1, r2);
        this.f21191f = r3;
    }

    private static final /* synthetic */ u[] a() {
        return new u[]{f21187g, f21188h, f21189i};
    }

    public static u valueOf(String r1) {
        return (u) Enum.valueOf(u.class, r1);
    }

    public static u[] values() {
        return (u[]) f21190j.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f21191f;
    }
}
