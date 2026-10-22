package d.b.h.a.a.g;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f13306f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f13307g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f13308h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f13309i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f13310j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ a[] f13311k = null;

        static {
            a r0 = new a("LOWEST", 0);
            f13306f = r0;
            a r1 = new a("LOW", 1);
            f13307g = r1;
            a r3 = new a("NORMAL", 2);
            f13308h = r3;
            a r5 = new a("HIGH", 3);
            f13309i = r5;
            a r7 = new a("IMMEDIATE", 4);
            f13310j = r7;
            f13311k = new a[]{r0, r1, r3, r5, r7};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f13311k.clone();
        }
    }

    a b();

    int c();
}
