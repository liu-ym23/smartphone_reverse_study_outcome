package kotlin.s0.w.d.l0.k;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f20515f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f20516g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f20517h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f20518i = null;

        static {
            a r0 = new a("CONFLICTS_ONLY", 0);
            f20515f = r0;
            a r1 = new a("SUCCESS_ONLY", 1);
            f20516g = r1;
            a r3 = new a("BOTH", 2);
            f20517h = r3;
            f20518i = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f20518i.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f20519f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f20520g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f20521h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f20522i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ b[] f20523j = null;

        static {
            b r0 = new b("OVERRIDABLE", 0);
            f20519f = r0;
            b r1 = new b("CONFLICT", 1);
            f20520g = r1;
            b r3 = new b("INCOMPATIBLE", 2);
            f20521h = r3;
            b r5 = new b("UNKNOWN", 3);
            f20522i = r5;
            f20523j = new b[]{r0, r1, r3, r5};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f20523j.clone();
        }
    }

    a a();

    b b(kotlin.s0.w.d.l0.c.a r1, kotlin.s0.w.d.l0.c.a r2, kotlin.s0.w.d.l0.c.e r3);
}
