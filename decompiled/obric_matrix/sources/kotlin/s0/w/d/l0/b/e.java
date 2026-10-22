package kotlin.s0.w.d.l0.b;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f18673g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final e f18674h = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final e a() {
            return e.E0();
        }
    }

    static {
        kotlin.n0.d.g r1 = null;
        f18673g = new a(r1);
        f18674h = new e(false, 1, r1);
    }

    public e(boolean r3) {
        super(new kotlin.s0.w.d.l0.m.f("DefaultBuiltIns"));
        if (r3 == false) goto L6;
        f(false);
        return;
    }

    public /* synthetic */ e(boolean r1, int r2, kotlin.n0.d.g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }

    public static final /* synthetic */ e E0() {
        return f18674h;
    }
}
