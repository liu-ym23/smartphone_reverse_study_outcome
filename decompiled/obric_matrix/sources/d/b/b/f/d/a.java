package d.b.b.f.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12791g;

    public a() {
        this.f12785a = false;
        this.f12786b = false;
        this.f12787c = 120;
        this.f12788d = 600;
        this.f12789e = 1200;
        this.f12790f = 120;
        this.f12791g = 600;
    }

    public long a() {
        return this.f12788d * 1000;
    }

    public long b() {
        return this.f12791g * 1000;
    }

    public long c() {
        return this.f12787c * 1000;
    }

    public long d() {
        return this.f12790f * 1000;
    }

    public long e() {
        return this.f12789e * 1000;
    }

    public boolean f() {
        return this.f12786b;
    }

    public boolean g() {
        return this.f12785a;
    }

    public void h(long r1) {
        this.f12788d = r1;
    }

    public void i(long r1) {
        this.f12791g = r1;
    }

    public void j(boolean r1) {
        this.f12786b = r1;
    }

    public void k(boolean r1) {
        this.f12785a = r1;
    }

    public void l(long r1) {
        this.f12787c = r1;
    }

    public void m(long r1) {
        this.f12790f = r1;
    }

    public void n(long r1) {
        this.f12789e = r1;
    }

    public String toString() {
        return "CpuConfig{mEnableUpload=" + this.f12785a + ", mCollectAllProcess=" + this.f12786b + ", mFrontCollectInterval=" + this.f12787c + ", mBackCollectInterval=" + this.f12788d + ", mMonitorInterval=" + this.f12789e + ", mFrontThreadCollectInterval=" + this.f12790f + ", mBackThreadCollectInterval=" + this.f12791g + '}';
    }
}
