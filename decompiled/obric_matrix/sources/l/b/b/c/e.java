package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    static final int[] n = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f21849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f21853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f21854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f21855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f21856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f21857l;
    private int m;

    static {
        n = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    }

    public e() {
        this.f21857l = new int[64];
        k();
    }

    private int l(int r1, int r2, int r3) {
        return (r1 & r2) ^ ((~r1) & r3);
    }

    private int m(int r1, int r2, int r3) {
        return ((r1 & r2) ^ (r1 & r3)) ^ (r2 & r3);
    }

    private int n(int r3) {
        int r2 = ((r3 >>> 2) | (r3 << 30)) ^ ((r3 >>> 13) | (r3 << 19));
        int r0 = r3 >>> 22;
        return r2 ^ ((r3 << 10) | r0);
    }

    private int o(int r3) {
        int r2 = ((r3 >>> 6) | (r3 << 26)) ^ ((r3 >>> 11) | (r3 << 21));
        int r0 = r3 >>> 25;
        return r2 ^ ((r3 << 7) | r0);
    }

    private int p(int r3) {
        return (((r3 >>> 7) | (r3 << 25)) ^ ((r3 >>> 18) | (r3 << 14))) ^ (r3 >>> 3);
    }

    private int q(int r3) {
        return (((r3 >>> 17) | (r3 << 15)) ^ ((r3 >>> 19) | (r3 << 13))) ^ (r3 >>> 10);
    }

    @Override // l.b.b.a
    public int a(byte[] r3, int r4) {
        g();
        l.b.h.e.c(this.f21849d, r3, r4);
        l.b.h.e.c(this.f21850e, r3, r4 + 4);
        l.b.h.e.c(this.f21851f, r3, r4 + 8);
        l.b.h.e.c(this.f21852g, r3, r4 + 12);
        l.b.h.e.c(this.f21853h, r3, r4 + 16);
        l.b.h.e.c(this.f21854i, r3, r4 + 20);
        l.b.h.e.c(this.f21855j, r3, r4 + 24);
        k();
        return 28;
    }

    @Override // l.b.b.a
    public String e() {
        return "SHA-224";
    }

    @Override // l.b.b.a
    public int f() {
        return 28;
    }

    @Override // l.b.b.c.a
    protected void h() {
        int r1 = 16;
    L4:
        if (r1 > 63) goto L6;
        int[] r2 = this.f21857l;
        int r3 = q(r2[r1 - 2]);
        int[] r4 = this.f21857l;
        r2[r1] = ((r3 + r4[r1 - 7]) + p(r4[r1 - 15])) + this.f21857l[r1 - 16];
        r1 = r1 + 1;
        goto L4
    L6:
        int r5 = this.f21849d;
        int r6 = this.f21850e;
        int r7 = this.f21851f;
        int r8 = this.f21852g;
        int r9 = this.f21853h;
        int r10 = this.f21854i;
        int r11 = this.f21855j;
        int r12 = this.f21856k;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r13 >= 8) goto L10;
        int r15 = o(r9) + l(r9, r10, r11);
        int[] r16 = n;
        int r17 = r12 + ((r15 + r16[r14]) + this.f21857l[r14]);
        int r18 = r8 + r17;
        int r19 = r17 + (n(r5) + m(r5, r6, r7));
        int r110 = r14 + 1;
        int r20 = r11 + (((o(r18) + l(r18, r9, r10)) + r16[r110]) + this.f21857l[r110]);
        int r21 = r7 + r20;
        int r22 = r20 + (n(r19) + m(r19, r5, r6));
        int r111 = r110 + 1;
        int r23 = r10 + (((o(r21) + l(r21, r18, r9)) + r16[r111]) + this.f21857l[r111]);
        int r24 = r6 + r23;
        int r25 = r23 + (n(r22) + m(r22, r19, r5));
        int r112 = r111 + 1;
        int r26 = r9 + (((o(r24) + l(r24, r21, r18)) + r16[r112]) + this.f21857l[r112]);
        int r27 = r5 + r26;
        int r28 = r26 + (n(r25) + m(r25, r22, r19));
        int r113 = r112 + 1;
        int r29 = r18 + (((o(r27) + l(r27, r24, r21)) + r16[r113]) + this.f21857l[r113]);
        r12 = r19 + r29;
        r8 = r29 + (n(r28) + m(r28, r25, r22));
        int r114 = r113 + 1;
        int r30 = r21 + (((o(r12) + l(r12, r27, r24)) + r16[r114]) + this.f21857l[r114]);
        r11 = r22 + r30;
        r7 = r30 + (n(r8) + m(r8, r28, r25));
        int r115 = r114 + 1;
        int r31 = r24 + (((o(r11) + l(r11, r12, r27)) + r16[r115]) + this.f21857l[r115]);
        r10 = r25 + r31;
        r6 = r31 + (n(r7) + m(r7, r8, r28));
        int r116 = r115 + 1;
        int r32 = r27 + (((o(r10) + l(r10, r11, r12)) + r16[r116]) + this.f21857l[r116]);
        r9 = r28 + r32;
        r5 = r32 + (n(r6) + m(r6, r7, r8));
        r14 = r116 + 1;
        r13 = r13 + 1;
        goto L8
    L10:
        this.f21849d += r5;
        this.f21850e += r6;
        this.f21851f += r7;
        this.f21852g += r8;
        this.f21853h += r9;
        this.f21854i += r10;
        this.f21855j += r11;
        this.f21856k += r12;
        this.m = 0;
        int r33 = 0;
    L11:
        if (r33 >= 16) goto L13;
        this.f21857l[r33] = 0;
        r33 = r33 + 1;
        goto L11
    }

    @Override // l.b.b.c.a
    protected void i(long r5) {
        if (this.m <= 14) goto L5;
        h();
    L5:
        int[] r4 = this.f21857l;
        r4[14] = (int) (r5 >>> 32);
        r4[15] = (int) (r5 & (-1));
    }

    @Override // l.b.b.c.a
    protected void j(byte[] r4, int r5) {
        int r0 = r4[r5] << 24;
        int r6 = r5 + 1;
        int r1 = r0 | ((r4[r6] & 255) << 16);
        int r7 = r6 + 1;
        int r2 = r1 | ((r4[r7] & 255) << 8);
        int r8 = (r4[r7 + 1] & 255) | r2;
        int[] r9 = this.f21857l;
        int r3 = this.m;
        r9[r3] = r8;
        int r10 = r3 + 1;
        this.m = r10;
        if (r10 != 16) goto L6;
        h();
        return;
    }

    @Override // l.b.b.c.a
    public void k() {
        super.k();
        this.f21849d = -1056596264;
        this.f21850e = 914150663;
        this.f21851f = 812702999;
        this.f21852g = -150054599;
        this.f21853h = -4191439;
        this.f21854i = 1750603025;
        this.f21855j = 1694076839;
        this.f21856k = -1090891868;
        this.m = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.f21857l;
        if (r1 == r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    }
}
