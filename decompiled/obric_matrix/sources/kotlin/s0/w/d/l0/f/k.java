package kotlin.s0.w.d.l0.f;

/* JADX INFO: loaded from: classes2.dex */
public final enum k extends Enum<k> implements kotlin.s0.w.d.l0.i.j.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f20032g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f20033h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f20034i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f20035j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ k[] f20036k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20037f;

    static {
        k r0 = new k("FINAL", 0, 0, 0);
        f20032g = r0;
        k r1 = new k("OPEN", 1, 1, 1);
        f20033h = r1;
        k r3 = new k("ABSTRACT", 2, 2, 2);
        f20034i = r3;
        k r5 = new k("SEALED", 3, 3, 3);
        f20035j = r5;
        f20036k = new k[]{r0, r1, r3, r5};
    }

    private k(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.f20037f = r4;
    }

    public static k valueOf(String r1) {
        return (k) Enum.valueOf(k.class, r1);
    }

    public static k[] values() {
        return (k[]) f20036k.clone();
    }

    @Override // kotlin.s0.w.d.l0.i.j.a
    public final int d() {
        return this.f20037f;
    }
}
