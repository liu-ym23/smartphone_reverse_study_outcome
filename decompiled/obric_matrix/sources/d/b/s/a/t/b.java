package d.b.s.a.t;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f14913f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ b[] f14914g = null;

    static {
        b r1 = new b("NORMAL", 0);
        f14913f = r1;
        f14914g = new b[]{r1, new b("WEAK", 1), new b("BOLD", 2), new b("HIGHLIGHT", 3)};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f14914g.clone();
    }
}
