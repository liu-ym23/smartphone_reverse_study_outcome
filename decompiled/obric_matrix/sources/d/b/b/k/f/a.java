package d.b.b.k.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f13008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f13009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13013f;

    public a(long r3, double r5, boolean r7, boolean r8, boolean r9, boolean r10) {
        if (r3 > 0) goto L5;
        r3 = 120;
    L5:
        this.f13008a = r3;
        this.f13009b = r5;
        this.f13013f = r10;
        this.f13010c = r7;
        this.f13011d = r8;
        this.f13012e = r9;
    }

    public boolean a() {
        return this.f13013f;
    }

    public boolean b() {
        return this.f13011d;
    }

    public boolean c() {
        return this.f13010c;
    }

    public boolean d() {
        return this.f13012e;
    }

    public long e() {
        return this.f13008a;
    }

    public double f() {
        double r0 = this.f13009b;
        if (r0 <= 0.5d) goto L5;
        return r0;
    L5:
        return 0.8d;
    }

    public void g(boolean r1) {
        this.f13011d = r1;
    }

    public void h(boolean r1) {
        this.f13010c = r1;
    }

    public String toString() {
        return "MemoryConfig{memoryCollectionInterval=" + this.f13008a + ", memoryTopCheckThreshold=" + this.f13009b + ", isStopWhenBackground=" + this.f13010c + ", isRealTimeMemEnable=" + this.f13011d + ", isUploadEnable=" + this.f13012e + ", isApm6SampleEnable=" + this.f13013f + '}';
    }
}
