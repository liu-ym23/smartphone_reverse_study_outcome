package kotlin.s0.w.d.l0.c.o1;

/* JADX INFO: loaded from: classes2.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f18934f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f18935g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f18936h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ m[] f18937i = null;

    static {
        f18934f = new m("RUNTIME", 0);
        f18935g = new m("BINARY", 1);
        f18936h = new m("SOURCE", 2);
        f18937i = a();
    }

    private m(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ m[] a() {
        return new m[]{f18934f, f18935g, f18936h};
    }

    public static m valueOf(String r1) {
        return (m) Enum.valueOf(m.class, r1);
    }

    public static m[] values() {
        return (m[]) f18937i.clone();
    }
}
