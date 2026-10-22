package d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f15263f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f15264g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f15265h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f15266i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f15267j = null;

        static {
            a r0 = new a("CACHE_FULL", 0);
            f15263f = r0;
            a r1 = new a("CONTENT_STALE", 1);
            f15264g = r1;
            a r3 = new a("USER_FORCED", 2);
            f15265h = r3;
            a r5 = new a("CACHE_MANAGER_TRIMMED", 3);
            f15266i = r5;
            f15267j = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f15267j.clone();
        }
    }

    void a(b r1);

    void b(b r1);

    void c();

    void d(b r1);

    void e(b r1);

    void f(b r1);

    void g(b r1);

    void h(b r1);
}
