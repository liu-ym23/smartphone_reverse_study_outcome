package com.bytedance.lighten.loader;

/* JADX INFO: loaded from: classes.dex */
class f implements d.c.g.a.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g.a.a.a f4937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f4943g;

    public f(d.c.g.a.a.a r4, int[] r5) {
        this.f4938b = -1;
        this.f4939c = 0;
        this.f4940d = -1;
        this.f4941e = -1;
        this.f4942f = -1;
        this.f4937a = r4;
        this.f4943g = r5;
    }

    private int e(int r2) {
        int r0 = this.f4937a.a();
        d.c.g.a.a.a r1 = this.f4937a;
        if (r2 < r0) goto L7;
        return r1.i(0);
    L7:
        return r1.i(r2);
    }

    @Override // d.c.g.a.c.b
    public long a(long r5) {
        if (g() != 0) goto L6;
        return -1;
    L6:
        if (j() == false) goto L8;
    L10:
        long r0 = e(this.f4943g[this.f4940d]);
        long r2 = this.f4941e + r0;
        if (r2 < r5) goto L14;
        return r2;
    L14:
        return r5 + r0;
    L8:
        if (this.f4939c < this.f4937a.b()) goto L10;
        return -1;
    }

    @Override // d.c.g.a.c.b
    public d.c.g.a.c.b b(d.c.g.a.c.b r1) {
        return null;
    }

    @Override // d.c.g.a.c.b
    public int c(long r7, long r9) {
        if (j() == false) goto L5;
    L7:
        int r0 = f(r7 % g());
        int r2 = this.f4940d;
        if (r2 != (-1)) goto L10;
    L25:
        this.f4941e = r7;
        this.f4942f = r7;
        this.f4940d = r0;
        return this.f4943g[r0];
    L10:
        if (r9 != this.f4942f) goto L25;
        this.f4942f = r7;
        if ((this.f4941e + e(this.f4943g[r2])) > r7) goto L15;
        this.f4941e = r7;
        int r8 = this.f4940d + 1;
        int[] r10 = this.f4943g;
        if (r8 < r10.length) goto L20;
        this.f4939c++;
        r8 = 0;
    L20:
        if (this.f4937a.f(r10[r8]) == false) goto L24;
        this.f4940d = r8;
        return this.f4943g[r8];
    L24:
        return this.f4943g[this.f4940d];
    L15:
        return this.f4943g[this.f4940d];
    L5:
        if ((r7 / g()) < this.f4937a.b()) goto L7;
        return -1;
    }

    @Override // d.c.g.a.c.b
    public void d(long r1) {
    }

    int f(long r6) {
        int r0 = 0;
        long r1 = 0;
    L3:
        r1 = r1 + ((long) e(this.f4943g[r0]));
        r0 = r0 + 1;
        if (r6 >= r1) goto L3;
        return r0 - 1;
    }

    public long g() {
        long r0 = this.f4938b;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        this.f4938b = 0;
        int r1 = this.f4943g.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        this.f4938b += (long) e(this.f4943g[r2]);
        r2 = r2 + 1;
        goto L6
    L9:
        return this.f4938b;
    }

    public int h() {
        return this.f4940d;
    }

    public int i() {
        return this.f4937a.a();
    }

    public boolean j() {
        if (this.f4937a.b() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
