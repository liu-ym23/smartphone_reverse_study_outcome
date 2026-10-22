package kotlin.s0.w.d.l0.e.a.j0;

/* JADX INFO: loaded from: classes2.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f19332f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f19333g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ k[] f19334h = null;

    static {
        k r0 = new k("SUPERTYPE", 0);
        f19332f = r0;
        k r1 = new k("COMMON", 1);
        f19333g = r1;
        f19334h = new k[]{r0, r1};
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    public static k valueOf(String r1) {
        return (k) Enum.valueOf(k.class, r1);
    }

    public static k[] values() {
        return (k[]) f19334h.clone();
    }
}
