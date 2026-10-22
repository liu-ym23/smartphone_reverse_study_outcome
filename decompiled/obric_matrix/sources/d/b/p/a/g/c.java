package d.b.p.a.g;

/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f14298f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f14299g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f14300h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f14301i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ c[] f14302j = null;

    static {
        c r0 = new c("INITIALIZED", 0);
        f14298f = r0;
        c r1 = new c("STARTED", 1);
        f14299g = r1;
        c r3 = new c("STOPPED", 2);
        f14300h = r3;
        c r5 = new c("DESTROYED", 3);
        f14301i = r5;
        f14302j = new c[]{r0, r1, r3, r5};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) f14302j.clone();
    }
}
