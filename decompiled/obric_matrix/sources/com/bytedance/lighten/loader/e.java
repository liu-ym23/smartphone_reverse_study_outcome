package com.bytedance.lighten.loader;

/* JADX INFO: loaded from: classes.dex */
class e implements d.c.g.a.b.e.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Class<?> f4933d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f4936c;

    static {
        f4933d = d.c.g.a.b.e.d.class;
    }

    public e(int r1, int[] r2, f r3) {
        this.f4934a = r1;
        this.f4935b = r2;
        this.f4936c = r3;
    }

    public e(int[] r2, f r3) {
        this(3, r2, r3);
    }

    @Override // d.c.g.a.b.e.a
    public void a(d.c.g.a.b.e.b r8, d.c.g.a.b.b r9, d.c.g.a.a.a r10, int r11) {
        int r1 = 1;
    L4:
        if (r1 > this.f4934a) goto L16;
        int r2 = this.f4936c.h() + r1;
        int[] r3 = this.f4935b;
        int r4 = r3[r2 % r3.length];
        if (r4 >= this.f4936c.i()) goto L7;
        if (d.c.c.e.a.p(2) == false) goto L13;
        d.c.c.e.a.t(f4933d, "Preparing frame %d, last drawn: %d", Integer.valueOf(r4), Integer.valueOf(r11));
    L13:
        if (r8.a(r9, r10, r4) == false) goto L14;
        r1 = r1 + 1;
        goto L4
    L14:
        return;
    L7:
        d.c.c.e.a.h(f4933d, "Preparing frame %d, last drawn: %d, but preparing frame is out of bounds", new Object[]{Integer.valueOf(r4), Integer.valueOf(r11)});
        return;
    }
}
