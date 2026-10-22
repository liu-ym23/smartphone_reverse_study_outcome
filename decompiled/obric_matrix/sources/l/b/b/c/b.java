package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class b implements l.b.b.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long[] f21823g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long[] f21824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected byte[] f21825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f21826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f21827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f21828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f21829f;

    static {
        f21823g = new long[]{1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
    }

    public b(int r2) {
        this.f21824a = new long[25];
        this.f21825b = new byte[192];
        n(r2);
    }

    private void g(byte[] r8, int r9) {
        int r0 = this.f21826c >>> 6;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        long[] r2 = this.f21824a;
        r2[r1] = r2[r1] ^ l.b.h.e.f(r8, r9);
        r9 = r9 + 8;
        r1 = r1 + 1;
        goto L3
    L5:
        l.b.h.h.f.d(m()).toLowerCase();
        i();
    }

    private void h() {
        i();
        m();
        l.b.h.e.j(this.f21824a, 0, this.f21826c >>> 6, this.f21825b, 0);
        this.f21827d = this.f21826c;
    }

    private void i() {
        long[] r0 = this.f21824a;
        int r1 = 0;
        long r2 = r0[0];
        char r4 = 1;
        long r5 = r0[1];
        long r8 = r0[2];
        char r10 = 3;
        long r11 = r0[3];
        long r14 = r0[4];
        long r17 = r0[5];
        long r20 = r0[6];
        long r23 = r0[7];
        long r26 = r0[8];
        long r29 = r0[9];
        long r32 = r0[10];
        long r35 = r0[11];
        long r38 = r0[12];
        long r40 = r0[13];
        long r43 = r0[14];
        long r46 = r0[15];
        long r48 = r0[16];
        long r50 = r0[17];
        long r53 = r0[18];
        long r56 = r0[19];
        long r59 = r0[20];
        long r62 = r0[21];
        long r64 = r0[22];
        long r67 = r0[23];
        int r13 = 24;
        long r69 = r0[24];
    L3:
        if (r1 >= r13) goto L5;
        long r71 = (((r2 ^ r17) ^ r32) ^ r46) ^ r59;
        long r73 = (((r5 ^ r20) ^ r35) ^ r48) ^ r62;
        long r75 = (((r8 ^ r23) ^ r38) ^ r50) ^ r64;
        long r77 = (((r11 ^ r26) ^ r40) ^ r53) ^ r67;
        long r79 = (((r14 ^ r29) ^ r43) ^ r56) ^ r69;
        long r81 = ((r73 << r4) | (r73 >>> (-1))) ^ r79;
        long r84 = ((r75 << r4) | (r75 >>> (-1))) ^ r71;
        long r74 = ((r77 << r4) | (r77 >>> (-1))) ^ r73;
        long r76 = ((r79 << r4) | (r79 >>> (-1))) ^ r75;
        long r72 = ((r71 << r4) | (r71 >>> (-1))) ^ r77;
        long r3 = r2 ^ r81;
        long r18 = r17 ^ r81;
        long r33 = r32 ^ r81;
        long r47 = r46 ^ r81;
        long r510 = r59 ^ r81;
        long r6 = r5 ^ r84;
        long r21 = r20 ^ r84;
        long r36 = r35 ^ r84;
        long r49 = r48 ^ r84;
        long r63 = r62 ^ r84;
        long r9 = r8 ^ r74;
        long r24 = r23 ^ r74;
        long r39 = r38 ^ r74;
        long r51 = r50 ^ r74;
        long r65 = r64 ^ r74;
        long r12 = r11 ^ r76;
        long r27 = r26 ^ r76;
        long r41 = r40 ^ r76;
        long r54 = r53 ^ r76;
        long r68 = r67 ^ r76;
        long r15 = r14 ^ r72;
        long r210 = r29 ^ r72;
        long r44 = r43 ^ r72;
        long r57 = r56 ^ r72;
        long r610 = r69 ^ r72;
        long r7 = (r6 << r4) | (r6 >>> 63);
        long r16 = (r21 << 44) | (r21 >>> 20);
        long r19 = (r210 << 20) | (r210 >>> 44);
        long r110 = (r65 << 61) | (r65 >>> r10);
        long r22 = (r44 << 39) | (r44 >>> 25);
        long[] r82 = r0;
        int r83 = r1;
        long r25 = (r510 << 18) | (r510 >>> 46);
        long r28 = (r9 << 62) | (r9 >>> 2);
        long r30 = (r39 << 43) | (r39 >>> 21);
        long r31 = (r41 << 25) | (r41 >>> 39);
        long r34 = (r57 << 8) | (r57 >>> 56);
        long r37 = (r68 << 56) | (r68 >>> 8);
        long r42 = (r47 << 41) | (r47 >>> 23);
        long r45 = (r15 << 27) | (r15 >>> 37);
        long r52 = (r610 << 14) | (r610 >>> 50);
        long r55 = (r63 << 2) | (r63 >>> 62);
        long r58 = (r27 << 55) | (r27 >>> 9);
        long r60 = (r49 << 45) | (r49 >>> 19);
        long r111 = (r18 << 36) | (r18 >>> 28);
        long r112 = (r12 << 28) | (r12 >>> 36);
        long r61 = (r54 << 21) | (r54 >>> 43);
        long r113 = (r51 << 15) | (r51 >>> 49);
        long r114 = (r36 << 10) | (r36 >>> 54);
        long r115 = (r24 << 6) | (r24 >>> 58);
        long r116 = (r33 << 3) | (r33 >>> 61);
        long r117 = ((~r16) & r30) ^ r3;
        long r118 = ((~r30) & r61) ^ r16;
        r8 = r30 ^ ((~r61) & r52);
        r11 = r61 ^ ((~r52) & r3);
        long r66 = r52 ^ ((~r3) & r16);
        long r70 = r112 ^ ((~r19) & r116);
        long r78 = ((~r116) & r60) ^ r19;
        long r80 = ((~r60) & r110) ^ r116;
        long r85 = r60 ^ ((~r110) & r112);
        long r86 = ((~r112) & r19) ^ r110;
        r32 = r7 ^ ((~r115) & r31);
        long r87 = ((~r31) & r34) ^ r115;
        long r88 = ((~r34) & r25) ^ r31;
        long r89 = r34 ^ ((~r25) & r7);
        long r90 = ((~r7) & r115) ^ r25;
        long r119 = r45 ^ ((~r111) & r114);
        long r91 = ((~r114) & r113) ^ r111;
        long r92 = r114 ^ ((~r113) & r37);
        long r93 = ((~r37) & r45) ^ r113;
        long r94 = ((~r45) & r111) ^ r37;
        long r95 = r28 ^ ((~r58) & r22);
        long r96 = ((~r22) & r42) ^ r58;
        r59 = r95;
        long r97 = r22 ^ ((~r42) & r55);
        long r98 = ((~r55) & r28) ^ r42;
        long r99 = ((~r28) & r58) ^ r55;
        long r100 = r117 ^ f21823g[r83];
        r20 = r78;
        r38 = r88;
        r35 = r87;
        r40 = r89;
        r62 = r96;
        r10 = 3;
        r67 = r98;
        r1 = r83 + 1;
        r64 = r97;
        r29 = r86;
        r0 = r82;
        r56 = r94;
        r43 = r90;
        r23 = r80;
        r26 = r85;
        r50 = r92;
        r46 = r119;
        r14 = r66;
        r17 = r70;
        r13 = 24;
        r53 = r93;
        r48 = r91;
        r4 = 1;
        r5 = r118;
        r69 = r99;
        r2 = r100;
        goto L3
    L5:
        long[] r810 = r0;
        r810[0] = r2;
        r810[1] = r5;
        r810[2] = r8;
        r810[3] = r11;
        r810[4] = r14;
        r810[5] = r17;
        r810[6] = r20;
        r810[7] = r23;
        r810[8] = r26;
        r810[9] = r29;
        r810[10] = r32;
        r810[11] = r35;
        r810[12] = r38;
        r810[13] = r40;
        r810[14] = r43;
        r810[15] = r46;
        r810[16] = r48;
        r810[17] = r50;
        r810[18] = r53;
        r810[19] = r56;
        r810[20] = r59;
        r810[21] = r62;
        r810[22] = r64;
        r810[23] = r67;
        r810[24] = r69;
    }

    private void n(int r2) {
        if (r2 != 128) goto L5;
    L17:
        o(1600 - (r2 << 1));
        return;
    L5:
        if (r2 == 224) goto L17;
        if (r2 == 256) goto L17;
        if (r2 == 288) goto L17;
        if (r2 == 384) goto L17;
        if (r2 == 512) goto L17;
        throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }

    private void o(int r7) {
        if (r7 <= 0) goto L14;
        if (r7 >= 1600) goto L14;
        if ((r7 % 64) != 0) goto L14;
        this.f21826c = r7;
        int r2 = 0;
    L8:
        long[] r3 = this.f21824a;
        if (r2 >= r3.length) goto L11;
        r3[r2] = 0;
        r2 = r2 + 1;
        goto L8
    L11:
        l.b.h.a.h(this.f21825b, (byte) 0);
        this.f21827d = 0;
        this.f21829f = false;
        this.f21828e = (1600 - r7) / 2;
        return;
    L14:
        throw new IllegalStateException("invalid rate value");
    }

    private void p() {
        byte[] r0 = this.f21825b;
        int r1 = this.f21827d;
        int r2 = r1 >>> 3;
        r0[r2] = (byte) (r0[r2] | ((byte) (1 << (r1 & 7))));
        int r3 = r1 + 1;
        this.f21827d = r3;
        if (r3 != this.f21826c) goto L5;
        g(r0, 0);
    L11:
        long[] r4 = this.f21824a;
        int r5 = (this.f21826c - 1) >>> 6;
        r4[r5] = r4[r5] ^ Long.MIN_VALUE;
        this.f21827d = 0;
        this.f21829f = true;
        return;
    L5:
        int r6 = r3 >>> 6;
        int r7 = r3 & 63;
        int r8 = 0;
        int r9 = 0;
    L6:
        if (r8 >= r6) goto L8;
        long[] r10 = this.f21824a;
        r10[r8] = r10[r8] ^ l.b.h.e.f(this.f21825b, r9);
        r9 = r9 + 8;
        r8 = r8 + 1;
        goto L6
    L8:
        m();
        if (r7 <= 0) goto L11;
        long[] r11 = this.f21824a;
        r11[r6] = (((1 << r7) - 1) & l.b.h.e.f(this.f21825b, r9)) ^ r11[r6];
        goto L11
    }

    @Override // l.b.b.a
    public void b(byte[] r1, int r2, int r3) {
        k(r1, r2, r3);
    }

    @Override // l.b.b.a
    public void c(byte r1) {
        j(r1);
    }

    @Override // l.b.b.a
    public int f() {
        return this.f21828e / 8;
    }

    protected void j(byte r4) {
        int r0 = this.f21827d;
        if ((r0 % 8) != 0) goto L13;
        if (this.f21829f == true) goto L11;
        byte[] r1 = this.f21825b;
        r1[r0 >>> 3] = r4;
        int r2 = r0 + 8;
        this.f21827d = r2;
        if (r2 != this.f21826c) goto L14;
        g(r1, 0);
        this.f21827d = 0;
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("attempt to absorb while squeezing");
    L13:
        throw new IllegalStateException("attempt to absorb with odd length queue");
    }

    protected void k(byte[] r6, int r7, int r8) {
        int r0 = this.f21827d;
        if ((r0 % 8) != 0) goto L22;
        if (this.f21829f == true) goto L20;
        int r1 = r0 >>> 3;
        int r2 = this.f21826c >>> 3;
        int r3 = r2 - r1;
        if (r8 >= r3) goto L12;
        System.arraycopy(r6, r7, this.f21825b, r1, r8);
        int r9 = this.f21827d + (r8 << 3);
    L9:
        this.f21827d = r9;
        return;
    L12:
        if (r1 <= 0) goto L14;
        System.arraycopy(r6, r7, this.f21825b, r1, r3);
        int r4 = r3 + 0;
        g(this.f21825b, 0);
    L15:
        int r5 = r8 - r4;
        if (r5 < r2) goto L18;
        g(r6, r7 + r4);
        r4 = r4 + r2;
        goto L15
    L18:
        System.arraycopy(r6, r7 + r4, this.f21825b, 0, r5);
        r9 = r5 << 3;
        goto L9
    L14:
        r4 = 0;
        goto L15
    L20:
        throw new IllegalStateException("attempt to absorb while squeezing");
    L22:
        throw new IllegalStateException("attempt to absorb with odd length queue");
    }

    protected void l(int r5, int r6) {
        if (r6 < 1) goto L17;
        if (r6 > 7) goto L17;
        int r1 = this.f21827d;
        if ((r1 % 8) != 0) goto L15;
        if (this.f21829f == true) goto L13;
        this.f21825b[r1 >>> 3] = (byte) (r5 & ((1 << r6) - 1));
        this.f21827d = r1 + r6;
        return;
    L13:
        throw new IllegalStateException("attempt to absorb while squeezing");
    L15:
        throw new IllegalStateException("attempt to absorb with odd length queue");
    L17:
        throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
    }

    protected byte[] m() {
        byte[] r0 = new byte[this.f21824a.length * 8];
        int r1 = 0;
        int r2 = 0;
    L3:
        long[] r3 = this.f21824a;
        if (r1 == r3.length) goto L6;
        l.b.h.e.i(r3[r1], r0, r2);
        r2 = r2 + 8;
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public void q() {
        n(this.f21828e);
    }

    protected void r(byte[] r10, int r11, long r12) {
        if (this.f21829f == true) goto L5;
        p();
    L5:
        m();
        long r4 = 0;
        if ((r12 % 8) != 0) goto L16;
    L8:
        if (r4 >= r12) goto L13;
        if (this.f21827d != 0) goto L12;
        h();
    L12:
        int r2 = (int) Math.min(this.f21827d, r12 - r4);
        System.arraycopy(this.f21825b, (this.f21826c - this.f21827d) / 8, r10, ((int) (r4 / 8)) + r11, r2 / 8);
        this.f21827d -= r2;
        r4 = r4 + ((long) r2);
        goto L8
    L13:
        m();
        return;
    L16:
        throw new IllegalStateException("outputLength not a multiple of 8");
    }
}
