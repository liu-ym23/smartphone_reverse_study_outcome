package kotlin.s0.w.d.l0.b;

/* JADX INFO: loaded from: classes2.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n f18738i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n f18739j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n f18740k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n f18741l = null;
    private static final /* synthetic */ n[] m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.b f18742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f18743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.b f18744h;

    static {
        kotlin.s0.w.d.l0.g.b r1 = kotlin.s0.w.d.l0.g.b.e("kotlin/UByte");
        kotlin.n0.d.o.e(r1, "fromString(\"kotlin/UByte\")");
        f18738i = new n("UBYTE", 0, r1);
        kotlin.s0.w.d.l0.g.b r2 = kotlin.s0.w.d.l0.g.b.e("kotlin/UShort");
        kotlin.n0.d.o.e(r2, "fromString(\"kotlin/UShort\")");
        f18739j = new n("USHORT", 1, r2);
        kotlin.s0.w.d.l0.g.b r3 = kotlin.s0.w.d.l0.g.b.e("kotlin/UInt");
        kotlin.n0.d.o.e(r3, "fromString(\"kotlin/UInt\")");
        f18740k = new n("UINT", 2, r3);
        kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.g.b.e("kotlin/ULong");
        kotlin.n0.d.o.e(r4, "fromString(\"kotlin/ULong\")");
        f18741l = new n("ULONG", 3, r4);
        m = a();
    }

    private n(String r2, int r3, kotlin.s0.w.d.l0.g.b r4) {
        super(r2, r3);
        this.f18742f = r4;
        kotlin.s0.w.d.l0.g.f r5 = r4.j();
        kotlin.n0.d.o.e(r5, "classId.shortClassName");
        this.f18743g = r5;
        this.f18744h = new kotlin.s0.w.d.l0.g.b(r4.h(), kotlin.s0.w.d.l0.g.f.k(r5.b() + "Array"));
    }

    private static final /* synthetic */ n[] a() {
        return new n[]{f18738i, f18739j, f18740k, f18741l};
    }

    public static n valueOf(String r1) {
        return (n) Enum.valueOf(n.class, r1);
    }

    public static n[] values() {
        return (n[]) m.clone();
    }

    public final kotlin.s0.w.d.l0.g.b b() {
        return this.f18744h;
    }

    public final kotlin.s0.w.d.l0.g.b c() {
        return this.f18742f;
    }

    public final kotlin.s0.w.d.l0.g.f g() {
        return this.f18743g;
    }
}
