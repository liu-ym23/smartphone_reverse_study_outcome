package kotlin.s0.w.d.l0.e.a.n0;

/* JADX INFO: loaded from: classes2.dex */
public final enum d0 extends Enum<d0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d0 f19527f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d0 f19528g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ d0[] f19529h = null;

    static {
        f19527f = new d0("SOURCE", 0);
        f19528g = new d0("BINARY", 1);
        f19529h = a();
    }

    private d0(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ d0[] a() {
        return new d0[]{f19527f, f19528g};
    }

    public static d0 valueOf(String r1) {
        return (d0) Enum.valueOf(d0.class, r1);
    }

    public static d0[] values() {
        return (d0[]) f19529h.clone();
    }
}
