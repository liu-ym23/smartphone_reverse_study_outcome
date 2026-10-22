package l.b.g.d.a;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f22279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f22280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected i[] f22281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected i[] f22282d;

    public k(b r1, i r2) {
        this.f22279a = r1;
        this.f22280b = r2;
        b();
        a();
    }

    private void a() {
        int r0 = this.f22280b.g();
        i[] r1 = new i[r0];
        int r2 = r0 - 1;
        int r3 = r2;
    L3:
        if (r3 < 0) goto L5;
        r1[r3] = new i(this.f22281c[r3]);
        r3 = r3 - 1;
        goto L3
    L5:
        this.f22282d = new i[r0];
    L6:
        if (r2 < 0) goto L8;
        this.f22282d[r2] = new i(this.f22279a, r2);
        r2 = r2 - 1;
        goto L6
    L8:
        int r4 = 0;
    L9:
        if (r4 >= r0) goto L30;
        if (r1[r4].f(r4) != 0) goto L22;
        int r5 = r4 + 1;
        boolean r6 = false;
    L13:
        if (r5 >= r0) goto L18;
        if (r1[r5].f(r4) == 0) goto L17;
        d(r1, r4, r5);
        d(this.f22282d, r4, r5);
        r5 = r0;
        r6 = true;
    L17:
        r5 = r5 + 1;
        goto L13
    L18:
        if (r6 == true) goto L22;
        throw new ArithmeticException("Squaring matrix is not invertible.");
    L22:
        int r7 = this.f22279a.f(r1[r4].f(r4));
        r1[r4].m(r7);
        this.f22282d[r4].m(r7);
        int r8 = 0;
    L23:
        if (r8 >= r0) goto L29;
        if (r8 == r4) goto L28;
        int r9 = r1[r8].f(r4);
        if (r9 == 0) goto L28;
        i r10 = r1[r4].n(r9);
        i r11 = this.f22282d[r4].n(r9);
        r1[r8].b(r10);
        this.f22282d[r8].b(r11);
    L28:
        r8 = r8 + 1;
        goto L23
    L29:
        r4 = r4 + 1;
        goto L9
    }

    private void b() {
        int r0 = this.f22280b.g();
        this.f22281c = new i[r0];
        int r1 = 0;
    L3:
        int r2 = r0 >> 1;
        if (r1 >= r2) goto L6;
        int r3 = r1 << 1;
        int[] r4 = new int[r3 + 1];
        r4[r3] = 1;
        this.f22281c[r1] = new i(this.f22279a, r4);
        r1 = r1 + 1;
    L6:
        if (r2 >= r0) goto L8;
        int r5 = r2 << 1;
        int[] r6 = new int[r5 + 1];
        r6[r5] = 1;
        i r7 = new i(this.f22279a, r6);
        this.f22281c[r2] = r7.k(this.f22280b);
        r2 = r2 + 1;
        goto L6
    }

    private static void d(i[] r2, int r3, int r4) {
        i r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }

    public i[] c() {
        return this.f22282d;
    }
}
