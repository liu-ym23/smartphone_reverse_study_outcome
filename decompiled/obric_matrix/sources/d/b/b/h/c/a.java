package d.b.b.h.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12949c;

    public a(long r1, long r3, boolean r5) {
        this.f12947a = r1;
        this.f12948b = r3;
        this.f12949c = r5;
    }

    public long a() {
        return this.f12948b;
    }

    public long b() {
        return this.f12947a;
    }

    public boolean c() {
        return this.f12949c;
    }

    public String toString() {
        return "FdConfig{fdCountThreshold=" + this.f12947a + ", collectIntervalMs=" + this.f12948b + ", isSampled=" + this.f12949c + '}';
    }
}
