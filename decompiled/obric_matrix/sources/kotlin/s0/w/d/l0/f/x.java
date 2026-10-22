package kotlin.s0.w.d.l0.f;

/* JADX INFO: loaded from: classes2.dex */
public final enum x extends Enum<x> implements kotlin.s0.w.d.l0.i.j.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x f20203g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f20204h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f20205i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final x f20206j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x f20207k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final x f20208l = null;
    private static final /* synthetic */ x[] m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20209f;

    static {
        x r0 = new x("INTERNAL", 0, 0, 0);
        f20203g = r0;
        x r1 = new x("PRIVATE", 1, 1, 1);
        f20204h = r1;
        x r3 = new x("PROTECTED", 2, 2, 2);
        f20205i = r3;
        x r5 = new x("PUBLIC", 3, 3, 3);
        f20206j = r5;
        x r7 = new x("PRIVATE_TO_THIS", 4, 4, 4);
        f20207k = r7;
        x r9 = new x("LOCAL", 5, 5, 5);
        f20208l = r9;
        m = new x[]{r0, r1, r3, r5, r7, r9};
    }

    private x(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.f20209f = r4;
    }

    public static x valueOf(String r1) {
        return (x) Enum.valueOf(x.class, r1);
    }

    public static x[] values() {
        return (x[]) m.clone();
    }

    @Override // kotlin.s0.w.d.l0.i.j.a
    public final int d() {
        return this.f20209f;
    }
}
