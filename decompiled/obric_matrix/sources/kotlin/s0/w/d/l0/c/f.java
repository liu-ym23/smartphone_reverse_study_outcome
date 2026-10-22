package kotlin.s0.w.d.l0.c;

/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f18865f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f18866g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f18867h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f18868i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f18869j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f18870k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ f[] f18871l = null;

    static {
        f18865f = new f("CLASS", 0, "class");
        f18866g = new f("INTERFACE", 1, "interface");
        f18867h = new f("ENUM_CLASS", 2, "enum class");
        f18868i = new f("ENUM_ENTRY", 3, null);
        f18869j = new f("ANNOTATION_CLASS", 4, "annotation class");
        f18870k = new f("OBJECT", 5, "object");
        f18871l = a();
    }

    private f(String r1, int r2, String r3) {
        super(r1, r2);
    }

    private static final /* synthetic */ f[] a() {
        return new f[]{f18865f, f18866g, f18867h, f18868i, f18869j, f18870k};
    }

    public static f valueOf(String r1) {
        return (f) Enum.valueOf(f.class, r1);
    }

    public static f[] values() {
        return (f[]) f18871l.clone();
    }

    public final boolean b() {
        if (this != f18870k) goto L5;
    L8:
        return true;
    L5:
        if (this == f18868i) goto L8;
        return false;
    }
}
