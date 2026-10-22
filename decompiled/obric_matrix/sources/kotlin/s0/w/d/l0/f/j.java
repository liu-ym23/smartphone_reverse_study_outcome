package kotlin.s0.w.d.l0.f;

/* JADX INFO: loaded from: classes2.dex */
public final enum j extends Enum<j> implements kotlin.s0.w.d.l0.i.j.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f20026g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j f20027h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j f20028i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j f20029j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ j[] f20030k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20031f;

    static {
        j r0 = new j("DECLARATION", 0, 0, 0);
        f20026g = r0;
        j r1 = new j("FAKE_OVERRIDE", 1, 1, 1);
        f20027h = r1;
        j r3 = new j("DELEGATION", 2, 2, 2);
        f20028i = r3;
        j r5 = new j("SYNTHESIZED", 3, 3, 3);
        f20029j = r5;
        f20030k = new j[]{r0, r1, r3, r5};
    }

    private j(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.f20031f = r4;
    }

    public static j valueOf(String r1) {
        return (j) Enum.valueOf(j.class, r1);
    }

    public static j[] values() {
        return (j[]) f20030k.clone();
    }

    @Override // kotlin.s0.w.d.l0.i.j.a
    public final int d() {
        return this.f20031f;
    }
}
