package d.b.s.a.c0.a;

/* JADX INFO: loaded from: classes.dex */
public interface e {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f14688f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f14689g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f14690h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f14691i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f14692j = null;

        static {
            a r0 = new a("LOW", 0);
            f14688f = r0;
            a r1 = new a("NORMAL", 1);
            f14689g = r1;
            a r3 = new a("HIGH", 2);
            f14690h = r3;
            a r5 = new a("IMMEDIATE", 3);
            f14691i = r5;
            f14692j = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f14692j.clone();
        }
    }

    a b();

    int c();
}
