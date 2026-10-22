package d.b.b.f.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0334a f12732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f12733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f12734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f12735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f12736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12739h;

    /* JADX INFO: renamed from: d.b.b.f.c.a$a, reason: collision with other inner class name */
    public static final enum EnumC0334a extends Enum<EnumC0334a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0334a f12740f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0334a f12741g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0334a f12742h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumC0334a[] f12743i = null;

        static {
            EnumC0334a r0 = new EnumC0334a("MIX", 0);
            f12740f = r0;
            EnumC0334a r1 = new EnumC0334a("FRONT", 1);
            f12741g = r1;
            EnumC0334a r3 = new EnumC0334a("BACK", 2);
            f12742h = r3;
            f12743i = new EnumC0334a[]{r0, r1, r3};
        }

        private EnumC0334a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0334a valueOf(String r1) {
            return (EnumC0334a) Enum.valueOf(EnumC0334a.class, r1);
        }

        public static EnumC0334a[] values() {
            return (EnumC0334a[]) f12743i.clone();
        }
    }

    public a(EnumC0334a r2, long r3) {
        this.f12739h = 0;
        this.f12732a = r2;
        this.f12738g = r3;
        this.f12739h = 0;
    }

    public void a(double r3) {
        if (r3 >= 0.0d) goto L5;
        return;
    L5:
        this.f12733b += r3;
    }

    public void b(double r3) {
        if (r3 >= 0.0d) goto L5;
        return;
    L5:
        this.f12735d += r3;
    }

    public void c() {
        this.f12739h++;
    }

    public long d() {
        return this.f12738g;
    }

    public double e() {
        return this.f12735d;
    }

    public double f() {
        return this.f12736e;
    }

    public double g() {
        return this.f12734c;
    }

    public double h() {
        return this.f12733b;
    }

    public String i() {
        return this.f12737f;
    }

    public int j() {
        return this.f12739h;
    }

    public a k(String r1) {
        this.f12737f = r1;
        return this;
    }

    public void l(double r3) {
        if (this.f12734c >= r3) goto L6;
        this.f12734c = r3;
        return;
    }

    public void m(double r3) {
        if (this.f12736e >= r3) goto L6;
        this.f12736e = r3;
        return;
    }

    public String toString() {
        return "CpuCacheItem{type=" + this.f12732a + ", metricRate=" + this.f12733b + ", metricMaxRate=" + this.f12734c + ", metricCpuStats=" + this.f12735d + ", metricMaxCpuStats=" + this.f12736e + ", sceneString='" + this.f12737f + "', firstTs=" + this.f12738g + ", times=" + this.f12739h + '}';
    }
}
