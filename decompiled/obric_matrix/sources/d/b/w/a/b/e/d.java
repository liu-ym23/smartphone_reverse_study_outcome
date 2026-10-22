package d.b.w.a.b.e;

/* JADX INFO: loaded from: classes.dex */
public class d implements d.b.w.a.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f15216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f15217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f15218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f15219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f15220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected double f15221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected double f15222g;

    public d() {
        this.f15216a = null;
        this.f15217b = -1;
        this.f15218c = 0;
        this.f15219d = 0;
        this.f15220e = 0;
        this.f15221f = 0.0d;
        this.f15222g = 0.0d;
    }

    public void a(d.b.w.a.c.b r7) {
        long r0 = b();
        if (r7 != null) goto L5;
        long r4 = 0;
    L6:
        long r1 = r0 - r4;
        this.f15219d = r1;
        if (this.f15220e != 0) goto L10;
        this.f15220e = r1;
        return;
    L10:
        return;
    L5:
        r4 = ((d) r7).b();
        goto L6
    }

    public long b() {
        return this.f15218c;
    }

    public long c() {
        return this.f15219d;
    }

    public void d(long r5) {
        if (this.f15219d >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.f15222g = c() / r5;
        return;
    }

    public void e(long r1) {
        this.f15218c = r1;
    }

    public void f(long r5) {
        if (this.f15219d >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.f15221f = c() / r5;
        return;
    }

    public void g(int r1) {
        this.f15217b = r1;
    }

    public void h(String r1) {
        this.f15216a = r1;
    }

    public String toString() {
        return "proc_stat:{pid=" + this.f15217b + " process_name:" + this.f15216a + " delta cpu_time:" + c() + " cpu_usage:" + (this.f15221f * 100.0d) + "% cpu_rate:" + this.f15222g + "}";
    }
}
