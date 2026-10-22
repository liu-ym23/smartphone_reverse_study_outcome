package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/LazyThreadSafetyMode;", "", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f18417f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f18418g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f18419h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ l[] f18420i = null;

    static {
        f18417f = new l("SYNCHRONIZED", 0);
        f18418g = new l("PUBLICATION", 1);
        f18419h = new l("NONE", 2);
        f18420i = a();
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ l[] a() {
        return new l[]{f18417f, f18418g, f18419h};
    }

    public static l valueOf(String r1) {
        return (l) Enum.valueOf(l.class, r1);
    }

    public static l[] values() {
        return (l[]) f18420i.clone();
    }
}
