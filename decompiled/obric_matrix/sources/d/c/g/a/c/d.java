package d.c.g.a.c;

/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g.a.a.a f15800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15806g;

    public d(d.c.g.a.a.a r4, int r5) {
        this.f15801b = -1;
        this.f15802c = 0;
        this.f15803d = -1;
        this.f15804e = -1;
        this.f15805f = -1;
        this.f15800a = r4;
        this.f15806g = r5;
    }

    @Override // d.c.g.a.c.b
    public long a(long r5) {
        if (f() != 0) goto L6;
        return -1;
    L6:
        if (g() == false) goto L8;
    L10:
        long r0 = this.f15800a.i(this.f15803d);
        long r2 = this.f15804e + r0;
        if (r2 < r5) goto L14;
        return r2;
    L14:
        return r5 + r0;
    L8:
        if (this.f15802c < this.f15800a.b()) goto L10;
        return -1;
    }

    @Override // d.c.g.a.c.b
    public b b(b r5) {
        if ((r5 instanceof d) == false) goto L6;
        d r6 = (d) r5;
        d r1 = new d(r6.f15800a, r6.f15806g);
        r1.f15803d = this.f15803d;
        r1.f15805f = this.f15805f;
        r1.f15802c = this.f15802c;
        r1.f15804e = this.f15804e;
        return r1;
    L6:
        return null;
    }

    @Override // d.c.g.a.c.b
    public int c(long r9, long r11) {
        long r0 = f();
        if (r0 != 0) goto L6;
        return -1;
    L6:
        if (g() == false) goto L8;
    L10:
        int r1 = e(r9 % r0);
        int r2 = this.f15803d;
        int r3 = 0;
        if (r2 != (-1)) goto L13;
    L35:
        this.f15804e = r9;
        this.f15805f = r9;
        this.f15803d = r1;
        this.f15802c = 0;
        return r1;
    L13:
        if (r11 != this.f15805f) goto L35;
        this.f15805f = r9;
        if ((this.f15804e + this.f15800a.i(r2)) > r9) goto L18;
        this.f15804e = r9;
        int r10 = this.f15803d + 1;
        if (r10 < this.f15800a.a()) goto L28;
        int r12 = this.f15806g;
        if (r12 != 0) goto L24;
    L27:
        this.f15802c++;
    L30:
        if (this.f15800a.f(r3) == false) goto L34;
        this.f15803d = r3;
        return r3;
    L34:
        return this.f15803d;
    L24:
        if (r12 == 3) goto L27;
        r3 = r10 - 1;
        goto L30
    L28:
        r3 = r10;
        goto L30
    L18:
        return this.f15803d;
    L8:
        if ((r9 / r0) < this.f15800a.b()) goto L10;
        return -1;
    }

    @Override // d.c.g.a.c.b
    public void d(long r1) {
    }

    int e(long r6) {
        int r0 = 0;
        long r1 = 0;
    L3:
        r1 = r1 + ((long) this.f15800a.i(r0));
        r0 = r0 + 1;
        if (r6 >= r1) goto L3;
        return r0 - 1;
    }

    public long f() {
        long r0 = this.f15801b;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        this.f15801b = 0;
        int r1 = this.f15800a.a();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        this.f15801b += (long) this.f15800a.i(r2);
        r2 = r2 + 1;
        goto L6
    L9:
        return this.f15801b;
    }

    public boolean g() {
        if (this.f15800a.b() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
