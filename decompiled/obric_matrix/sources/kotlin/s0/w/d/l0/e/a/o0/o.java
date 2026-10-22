package kotlin.s0.w.d.l0.e.a.o0;

/* JADX INFO: loaded from: classes2.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f19623f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o f19624g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o f19625h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ o[] f19626i = null;

    static {
        f19623f = new o("FLEXIBLE_LOWER", 0);
        f19624g = new o("FLEXIBLE_UPPER", 1);
        f19625h = new o("INFLEXIBLE", 2);
        f19626i = a();
    }

    private o(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ o[] a() {
        return new o[]{f19623f, f19624g, f19625h};
    }

    public static o valueOf(String r1) {
        return (o) Enum.valueOf(o.class, r1);
    }

    public static o[] values() {
        return (o[]) f19626i.clone();
    }
}
