package kotlin.s0.w.d.l0.j;

/* JADX INFO: loaded from: classes2.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f20499f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f20500g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f20501h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ l[] f20502i = null;

    static {
        f20499f = new l("PRETTY", 0);
        f20500g = new l("DEBUG", 1);
        f20501h = new l("NONE", 2);
        f20502i = a();
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ l[] a() {
        return new l[]{f20499f, f20500g, f20501h};
    }

    public static l valueOf(String r1) {
        return (l) Enum.valueOf(l.class, r1);
    }

    public static l[] values() {
        return (l[]) f20502i.clone();
    }
}
