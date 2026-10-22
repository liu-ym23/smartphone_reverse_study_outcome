package d.c.i.c.a;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f15847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EnumC0426b f15848f;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f15849f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f15850g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ a[] f15851h = null;

        static {
            a r0 = new a("BLEND_WITH_PREVIOUS", 0);
            f15849f = r0;
            a r1 = new a("NO_BLEND", 1);
            f15850g = r1;
            f15851h = new a[]{r0, r1};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f15851h.clone();
        }
    }

    /* JADX INFO: renamed from: d.c.i.c.a.b$b, reason: collision with other inner class name */
    public static final enum EnumC0426b extends Enum<EnumC0426b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0426b f15852f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0426b f15853g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0426b f15854h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumC0426b[] f15855i = null;

        static {
            EnumC0426b r0 = new EnumC0426b("DISPOSE_DO_NOT", 0);
            f15852f = r0;
            EnumC0426b r1 = new EnumC0426b("DISPOSE_TO_BACKGROUND", 1);
            f15853g = r1;
            EnumC0426b r3 = new EnumC0426b("DISPOSE_TO_PREVIOUS", 2);
            f15854h = r3;
            f15855i = new EnumC0426b[]{r0, r1, r3};
        }

        private EnumC0426b(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0426b valueOf(String r1) {
            return (EnumC0426b) Enum.valueOf(EnumC0426b.class, r1);
        }

        public static EnumC0426b[] values() {
            return (EnumC0426b[]) f15855i.clone();
        }
    }

    public b(int r1, int r2, int r3, int r4, int r5, a r6, EnumC0426b r7) {
        this.f15843a = r2;
        this.f15844b = r3;
        this.f15845c = r4;
        this.f15846d = r5;
        this.f15847e = r6;
        this.f15848f = r7;
    }
}
