package kotlin.s0.w.d.l0.g;

/* JADX INFO: loaded from: classes2.dex */
final enum k extends Enum<k> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f20295f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f20296g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f20297h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ k[] f20298i = null;

    static {
        f20295f = new k("BEGINNING", 0);
        f20296g = new k("MIDDLE", 1);
        f20297h = new k("AFTER_DOT", 2);
        f20298i = a();
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ k[] a() {
        return new k[]{f20295f, f20296g, f20297h};
    }

    public static k valueOf(String r1) {
        return (k) Enum.valueOf(k.class, r1);
    }

    public static k[] values() {
        return (k[]) f20298i.clone();
    }
}
