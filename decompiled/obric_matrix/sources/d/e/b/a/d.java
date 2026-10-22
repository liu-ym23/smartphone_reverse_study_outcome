package d.e.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f16550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16551g;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f16552f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f16553g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f16554h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f16555i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f16556j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ a[] f16557k = null;

        static {
            f16552f = new a("INVALID_COUNTRY_CODE", 0);
            f16553g = new a("NOT_A_NUMBER", 1);
            f16554h = new a("TOO_SHORT_AFTER_IDD", 2);
            f16555i = new a("TOO_SHORT_NSN", 3);
            f16556j = new a("TOO_LONG", 4);
            f16557k = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ a[] a() {
            return new a[]{f16552f, f16553g, f16554h, f16555i, f16556j};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f16557k.clone();
        }
    }

    public d(a r1, String r2) {
        super(r2);
        this.f16551g = r2;
        this.f16550f = r1;
    }

    public a a() {
        return this.f16550f;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.f16550f + ". " + this.f16551g;
    }
}
