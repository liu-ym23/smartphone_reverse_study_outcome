package kotlin.s0.w.d.l0.l.b;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f20695f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f20696g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f20697h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f20698i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ b[] f20699j = null;

    static {
        b r0 = new b("FUNCTION", 0);
        f20695f = r0;
        b r1 = new b("PROPERTY", 1);
        f20696g = r1;
        b r3 = new b("PROPERTY_GETTER", 2);
        f20697h = r3;
        b r5 = new b("PROPERTY_SETTER", 3);
        f20698i = r5;
        f20699j = new b[]{r0, r1, r3, r5};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f20699j.clone();
    }
}
