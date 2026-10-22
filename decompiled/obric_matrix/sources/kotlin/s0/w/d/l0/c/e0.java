package kotlin.s0.w.d.l0.c;

/* JADX INFO: loaded from: classes2.dex */
public final enum e0 extends Enum<e0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f18859f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e0 f18860g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e0 f18861h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e0 f18862i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e0 f18863j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ e0[] f18864k = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final e0 a(boolean r1, boolean r2, boolean r3) {
            if (r1 == true) goto L10;
            if (r2 == true) goto L11;
            if (r3 == false) goto L9;
            return e0.f18862i;
        L9:
            return e0.f18860g;
        L11:
            return e0.f18863j;
        L10:
            return e0.f18861h;
        }
    }

    static {
        f18860g = new e0("FINAL", 0);
        f18861h = new e0("SEALED", 1);
        f18862i = new e0("OPEN", 2);
        f18863j = new e0("ABSTRACT", 3);
        f18864k = a();
        f18859f = new a(null);
    }

    private e0(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ e0[] a() {
        return new e0[]{f18860g, f18861h, f18862i, f18863j};
    }

    public static e0 valueOf(String r1) {
        return (e0) Enum.valueOf(e0.class, r1);
    }

    public static e0[] values() {
        return (e0[]) f18864k.clone();
    }
}
