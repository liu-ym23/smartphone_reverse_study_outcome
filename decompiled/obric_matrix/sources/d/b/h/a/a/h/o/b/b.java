package d.b.h.a.a.h.o.b;

/* JADX INFO: loaded from: classes.dex */
final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f13470f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f13471g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f13472h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ b[] f13473i = null;

    static {
        b r0 = new b("ADDRESS_FAMILY_UNSPECIFIED", 0);
        f13470f = r0;
        b r1 = new b("ADDRESS_FAMILY_IPV4", 1);
        f13471g = r1;
        b r3 = new b("ADDRESS_FAMILY_IPV6", 2);
        f13472h = r3;
        f13473i = new b[]{r0, r1, r3};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f13473i.clone();
    }
}
