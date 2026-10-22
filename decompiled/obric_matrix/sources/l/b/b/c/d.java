package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f21842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f21846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f21847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f21848j;

    public d() {
        this.f21847i = new int[80];
        k();
    }

    private int l(int r1, int r2, int r3) {
        return (r1 & r2) | ((~r1) & r3);
    }

    private int m(int r1, int r2, int r3) {
        return ((r1 & r2) | (r1 & r3)) | (r2 & r3);
    }

    private int n(int r1, int r2, int r3) {
        return (r1 ^ r2) ^ r3;
    }

    @Override // l.b.b.a
    public int a(byte[] r3, int r4) {
        g();
        l.b.h.e.c(this.f21842d, r3, r4);
        l.b.h.e.c(this.f21843e, r3, r4 + 4);
        l.b.h.e.c(this.f21844f, r3, r4 + 8);
        l.b.h.e.c(this.f21845g, r3, r4 + 12);
        l.b.h.e.c(this.f21846h, r3, r4 + 16);
        k();
        return 20;
    }

    @Override // l.b.b.a
    public String e() {
        return "SHA-1";
    }

    @Override // l.b.b.a
    public int f() {
        return 20;
    }

    @Override // l.b.b.c.a
    protected void h() {
        int r1 = 16;
    L4:
        if (r1 >= 80) goto L6;
        int[] r2 = this.f21847i;
        int r3 = ((r2[r1 - 3] ^ r2[r1 - 8]) ^ r2[r1 - 14]) ^ r2[r1 - 16];
        r2[r1] = (r3 >>> 31) | (r3 << 1);
        r1 = r1 + 1;
        goto L4
    L6:
        int r4 = this.f21842d;
        int r5 = this.f21843e;
        int r6 = this.f21844f;
        int r7 = this.f21845g;
        int r8 = this.f21846h;
        int r9 = 0;
        int r10 = 0;
    L8:
        if (r9 >= 4) goto L10;
        int r11 = r10 + 1;
        int r12 = r8 + (((((r4 << 5) | (r4 >>> 27)) + l(r5, r6, r7)) + this.f21847i[r10]) + 1518500249);
        int r13 = (r5 >>> 2) | (r5 << 30);
        int r14 = r11 + 1;
        int r15 = r7 + (((((r12 << 5) | (r12 >>> 27)) + l(r4, r13, r6)) + this.f21847i[r11]) + 1518500249);
        int r16 = (r4 >>> 2) | (r4 << 30);
        int r17 = r14 + 1;
        int r18 = r6 + (((((r15 << 5) | (r15 >>> 27)) + l(r12, r16, r13)) + this.f21847i[r14]) + 1518500249);
        r8 = (r12 >>> 2) | (r12 << 30);
        int r19 = r17 + 1;
        r5 = r13 + (((((r18 << 5) | (r18 >>> 27)) + l(r15, r8, r16)) + this.f21847i[r17]) + 1518500249);
        r7 = (r15 >>> 2) | (r15 << 30);
        r4 = r16 + (((((r5 << 5) | (r5 >>> 27)) + l(r18, r7, r8)) + this.f21847i[r19]) + 1518500249);
        r6 = (r18 >>> 2) | (r18 << 30);
        r9 = r9 + 1;
        r10 = r19 + 1;
        goto L8
    L10:
        int r20 = 0;
    L11:
        if (r20 >= 4) goto L13;
        int r110 = r10 + 1;
        int r21 = r8 + (((((r4 << 5) | (r4 >>> 27)) + n(r5, r6, r7)) + this.f21847i[r10]) + 1859775393);
        int r22 = (r5 >>> 2) | (r5 << 30);
        int r111 = r110 + 1;
        int r23 = r7 + (((((r21 << 5) | (r21 >>> 27)) + n(r4, r22, r6)) + this.f21847i[r110]) + 1859775393);
        int r24 = (r4 >>> 2) | (r4 << 30);
        int r112 = r111 + 1;
        int r25 = r6 + (((((r23 << 5) | (r23 >>> 27)) + n(r21, r24, r22)) + this.f21847i[r111]) + 1859775393);
        r8 = (r21 >>> 2) | (r21 << 30);
        int r113 = r112 + 1;
        r5 = r22 + (((((r25 << 5) | (r25 >>> 27)) + n(r23, r8, r24)) + this.f21847i[r112]) + 1859775393);
        r7 = (r23 >>> 2) | (r23 << 30);
        r4 = r24 + (((((r5 << 5) | (r5 >>> 27)) + n(r25, r7, r8)) + this.f21847i[r113]) + 1859775393);
        r6 = (r25 >>> 2) | (r25 << 30);
        r20 = r20 + 1;
        r10 = r113 + 1;
        goto L11
    L13:
        int r26 = 0;
    L14:
        if (r26 >= 4) goto L16;
        int r114 = r10 + 1;
        int r27 = r8 + (((((r4 << 5) | (r4 >>> 27)) + m(r5, r6, r7)) + this.f21847i[r10]) - 1894007588);
        int r28 = (r5 >>> 2) | (r5 << 30);
        int r115 = r114 + 1;
        int r29 = r7 + (((((r27 << 5) | (r27 >>> 27)) + m(r4, r28, r6)) + this.f21847i[r114]) - 1894007588);
        int r30 = (r4 >>> 2) | (r4 << 30);
        int r116 = r115 + 1;
        int r31 = r6 + (((((r29 << 5) | (r29 >>> 27)) + m(r27, r30, r28)) + this.f21847i[r115]) - 1894007588);
        r8 = (r27 >>> 2) | (r27 << 30);
        int r117 = r116 + 1;
        r5 = r28 + (((((r31 << 5) | (r31 >>> 27)) + m(r29, r8, r30)) + this.f21847i[r116]) - 1894007588);
        r7 = (r29 >>> 2) | (r29 << 30);
        r4 = r30 + (((((r5 << 5) | (r5 >>> 27)) + m(r31, r7, r8)) + this.f21847i[r117]) - 1894007588);
        r6 = (r31 >>> 2) | (r31 << 30);
        r26 = r26 + 1;
        r10 = r117 + 1;
        goto L14
    L16:
        int r32 = 0;
    L18:
        if (r32 > 3) goto L20;
        int r118 = r10 + 1;
        int r33 = r8 + (((((r4 << 5) | (r4 >>> 27)) + n(r5, r6, r7)) + this.f21847i[r10]) - 899497514);
        int r34 = (r5 >>> 2) | (r5 << 30);
        int r119 = r118 + 1;
        int r35 = r7 + (((((r33 << 5) | (r33 >>> 27)) + n(r4, r34, r6)) + this.f21847i[r118]) - 899497514);
        int r36 = (r4 >>> 2) | (r4 << 30);
        int r120 = r119 + 1;
        int r37 = r6 + (((((r35 << 5) | (r35 >>> 27)) + n(r33, r36, r34)) + this.f21847i[r119]) - 899497514);
        r8 = (r33 >>> 2) | (r33 << 30);
        int r121 = r120 + 1;
        r5 = r34 + (((((r37 << 5) | (r37 >>> 27)) + n(r35, r8, r36)) + this.f21847i[r120]) - 899497514);
        r7 = (r35 >>> 2) | (r35 << 30);
        r4 = r36 + (((((r5 << 5) | (r5 >>> 27)) + n(r37, r7, r8)) + this.f21847i[r121]) - 899497514);
        r6 = (r37 >>> 2) | (r37 << 30);
        r32 = r32 + 1;
        r10 = r121 + 1;
        goto L18
    L20:
        this.f21842d += r4;
        this.f21843e += r5;
        this.f21844f += r6;
        this.f21845g += r7;
        this.f21846h += r8;
        this.f21848j = 0;
        int r38 = 0;
    L21:
        if (r38 >= 16) goto L23;
        this.f21847i[r38] = 0;
        r38 = r38 + 1;
        goto L21
    }

    @Override // l.b.b.c.a
    protected void i(long r5) {
        if (this.f21848j <= 14) goto L5;
        h();
    L5:
        int[] r4 = this.f21847i;
        r4[14] = (int) (r5 >>> 32);
        r4[15] = (int) r5;
    }

    @Override // l.b.b.c.a
    protected void j(byte[] r4, int r5) {
        int r0 = r4[r5] << 24;
        int r6 = r5 + 1;
        int r1 = r0 | ((r4[r6] & 255) << 16);
        int r7 = r6 + 1;
        int r2 = r1 | ((r4[r7] & 255) << 8);
        int r8 = (r4[r7 + 1] & 255) | r2;
        int[] r9 = this.f21847i;
        int r3 = this.f21848j;
        r9[r3] = r8;
        int r10 = r3 + 1;
        this.f21848j = r10;
        if (r10 != 16) goto L6;
        h();
        return;
    }

    @Override // l.b.b.c.a
    public void k() {
        super.k();
        this.f21842d = 1732584193;
        this.f21843e = -271733879;
        this.f21844f = -1732584194;
        this.f21845g = 271733878;
        this.f21846h = -1009589776;
        this.f21848j = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.f21847i;
        if (r1 == r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    }
}
