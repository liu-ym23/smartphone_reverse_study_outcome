package kotlin.s0.w.d.l0.b;

/* JADX INFO: loaded from: classes2.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f18731h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m f18732i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m f18733j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f18734k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ m[] f18735l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.b f18736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f18737g;

    static {
        kotlin.s0.w.d.l0.g.b r1 = kotlin.s0.w.d.l0.g.b.e("kotlin/UByteArray");
        kotlin.n0.d.o.e(r1, "fromString(\"kotlin/UByteArray\")");
        f18731h = new m("UBYTEARRAY", 0, r1);
        kotlin.s0.w.d.l0.g.b r2 = kotlin.s0.w.d.l0.g.b.e("kotlin/UShortArray");
        kotlin.n0.d.o.e(r2, "fromString(\"kotlin/UShortArray\")");
        f18732i = new m("USHORTARRAY", 1, r2);
        kotlin.s0.w.d.l0.g.b r3 = kotlin.s0.w.d.l0.g.b.e("kotlin/UIntArray");
        kotlin.n0.d.o.e(r3, "fromString(\"kotlin/UIntArray\")");
        f18733j = new m("UINTARRAY", 2, r3);
        kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.g.b.e("kotlin/ULongArray");
        kotlin.n0.d.o.e(r4, "fromString(\"kotlin/ULongArray\")");
        f18734k = new m("ULONGARRAY", 3, r4);
        f18735l = a();
    }

    private m(String r1, int r2, kotlin.s0.w.d.l0.g.b r3) {
        super(r1, r2);
        this.f18736f = r3;
        kotlin.s0.w.d.l0.g.f r4 = r3.j();
        kotlin.n0.d.o.e(r4, "classId.shortClassName");
        this.f18737g = r4;
    }

    private static final /* synthetic */ m[] a() {
        return new m[]{f18731h, f18732i, f18733j, f18734k};
    }

    public static m valueOf(String r1) {
        return (m) Enum.valueOf(m.class, r1);
    }

    public static m[] values() {
        return (m[]) f18735l.clone();
    }

    public final kotlin.s0.w.d.l0.g.f b() {
        return this.f18737g;
    }
}
