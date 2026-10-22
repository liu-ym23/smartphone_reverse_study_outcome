package d.b.h.a.a.j;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13771d;

    a() {
        this.f13768a = false;
        this.f13769b = -1;
        this.f13770c = -1;
        this.f13771d = -1;
    }

    public int a() {
        return this.f13769b;
    }

    public long b() {
        long r0 = this.f13770c;
        if (r0 < 0) goto L11;
        long r4 = this.f13771d;
        if (r4 >= 0) goto L7;
        return -1;
    L7:
        if (r0 <= r4) goto L10;
        return -1;
    L10:
        return r4 - r0;
    L11:
        return -1;
    }

    public boolean c() {
        return this.f13768a;
    }

    public void d(long r1) {
        this.f13771d = r1;
    }

    public void e(boolean r1) {
        this.f13768a = r1;
    }

    public void f(int r1) {
        this.f13769b = r1;
    }

    public void g(long r1) {
        this.f13770c = r1;
    }
}
