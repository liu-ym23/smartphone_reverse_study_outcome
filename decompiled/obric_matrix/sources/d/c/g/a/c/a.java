package d.c.g.a.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g.a.a.a f15793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15799g;

    public a(d.c.g.a.a.a r4, int r5) {
        this.f15794b = -1;
        this.f15795c = 0;
        this.f15796d = -1;
        this.f15797e = -1;
        this.f15798f = -1;
        this.f15793a = r4;
        this.f15799g = r5;
    }

    @Override // d.c.g.a.c.b
    public long a(long r5) {
        if (e() != 0) goto L6;
        return -1;
    L6:
        if (f() == false) goto L8;
    L10:
        long r0 = this.f15793a.i(this.f15796d);
        long r2 = this.f15797e + r0;
        if (r2 < r5) goto L14;
        return r2;
    L14:
        return r5 + r0;
    L8:
        if (this.f15795c < this.f15793a.b()) goto L10;
        return -1;
    }

    @Override // d.c.g.a.c.b
    public b b(b r5) {
        if ((r5 instanceof a) == false) goto L6;
        a r6 = (a) r5;
        a r1 = new a(r6.f15793a, r6.f15799g);
        r1.f15796d = this.f15796d;
        r1.f15798f = this.f15798f;
        r1.f15795c = this.f15795c;
        r1.f15797e = this.f15797e;
        return r1;
    L6:
        return null;
    }

    @Override // d.c.g.a.c.b
    public int c(long r4, long r6) {
        if (e() != 0) goto L6;
        return -1;
    L6:
        if (f() == false) goto L8;
    L10:
        int r7 = this.f15796d;
        int r0 = 0;
        if (r7 != (-1)) goto L14;
        this.f15797e = r4;
        this.f15798f = r4;
        this.f15796d = 0;
        this.f15795c = 0;
        return 0;
    L14:
        this.f15798f = r4;
        if ((this.f15797e + this.f15793a.i(r7)) > r4) goto L17;
        this.f15797e = r4;
        int r5 = this.f15796d + 1;
        if (r5 < this.f15793a.a()) goto L27;
        int r8 = this.f15799g;
        if (r8 != 0) goto L23;
    L26:
        this.f15795c++;
    L28:
        this.f15796d = r0;
        return r0;
    L23:
        if (r8 == 3) goto L26;
        r0 = r5 - 1;
        goto L28
    L27:
        r0 = r5;
        goto L28
    L17:
        return this.f15796d;
    L8:
        if (this.f15795c < this.f15793a.b()) goto L10;
        return -1;
    }

    @Override // d.c.g.a.c.b
    public void d(long r1) {
    }

    public long e() {
        long r0 = this.f15794b;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        this.f15794b = 0;
        int r1 = this.f15793a.a();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        this.f15794b += (long) this.f15793a.i(r2);
        r2 = r2 + 1;
        goto L6
    L9:
        return this.f15794b;
    }

    public boolean f() {
        if (this.f15793a.b() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
