package d.b.b.f.e;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f12834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12838h;

    public j() {
    }

    public double a() {
        return this.f12834d;
    }

    public int b() {
        return this.f12838h;
    }

    public long c() {
        return this.f12837g;
    }

    public String d() {
        return this.f12836f;
    }

    public long e() {
        return this.f12833c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (f() != r6.f()) goto L14;
        if (g().equals(r6.g()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int f() {
        return this.f12831a;
    }

    public String g() {
        return this.f12832b;
    }

    public String h() {
        return this.f12835e;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(f()), g()});
    }

    public void i(double r1) {
        this.f12834d = r1;
    }

    public void j(int r1) {
        this.f12838h = r1;
    }

    public void k(long r1) {
        this.f12837g = r1;
    }

    public void l(String r1) {
        this.f12836f = r1;
    }

    public void m(long r1) {
        this.f12833c = r1;
    }

    public void n(int r1) {
        this.f12831a = r1;
    }

    public void o(String r1) {
        this.f12832b = r1;
    }

    public void p(String r1) {
        this.f12835e = r1;
    }

    public String toString() {
        return "ThreadExceptionItem{threadId=" + this.f12831a + ", threadName='" + this.f12832b + "', threadCpuTime=" + this.f12833c + ", processCpuTime=" + this.f12837g + ", cpuUsage=" + this.f12834d + ", weight=" + this.f12835e + ", nice=" + this.f12838h + '}';
    }
}
