package kotlin.s0.w.d.l0.j;

/* JADX INFO: loaded from: classes2.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f20495f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f20496g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f20497h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ k[] f20498i = null;

    static {
        f20495f = new k("ALL", 0);
        f20496g = new k("ONLY_NON_SYNTHESIZED", 1);
        f20497h = new k("NONE", 2);
        f20498i = a();
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ k[] a() {
        return new k[]{f20495f, f20496g, f20497h};
    }

    public static k valueOf(String r1) {
        return (k) Enum.valueOf(k.class, r1);
    }

    public static k[] values() {
        return (k[]) f20498i.clone();
    }
}
