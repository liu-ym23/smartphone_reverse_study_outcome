package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class d1 extends JceStruct {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f140J;
    public String K;
    public String L;
    public String M;
    public boolean N;
    public boolean O;
    public String P;
    public int Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f141a;
    public long a0;
    public String b;
    public String b0;
    public String c;
    public String c0;
    public String d;
    public int d0;
    public String e;
    public String e0;
    public int f;
    public String f0;
    public String g;
    public String g0;
    public int h;
    public int h0;
    public String i;
    public String i0;
    public int j;
    public String j0;
    public int k;
    public String k0;
    public boolean l;
    public String l0;
    public String m;
    public String m0;
    public String n;
    public String n0;
    public int o;
    public String o0;
    public String p;
    public String p0;
    public short q;
    public String q0;
    public int r;
    public String r0;
    public String s;
    public String s0;
    public String t;
    public int u;
    public String v;
    public long w;
    public long x;
    public long y;
    public String z;

    public d1() {
        this.f141a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = 1;
        this.g = "";
        this.h = 0;
        this.i = "";
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = "";
        this.n = "";
        this.o = 0;
        this.p = "";
        this.q = 0;
        this.r = 0;
        this.s = "";
        this.t = "";
        this.u = 0;
        this.v = "";
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = 0;
        this.I = 0;
        this.f140J = false;
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = false;
        this.O = false;
        this.P = "";
        this.Q = 1;
        this.R = "";
        this.S = "";
        this.T = "";
        this.U = "";
        this.V = "";
        this.W = "";
        this.X = "";
        this.Y = "";
        this.Z = "";
        this.a0 = 0;
        this.b0 = "";
        this.c0 = "";
        this.d0 = 0;
        this.e0 = "";
        this.f0 = "";
        this.g0 = "";
        this.h0 = 1;
        this.i0 = "";
        this.j0 = "";
        this.k0 = "";
        this.l0 = "";
        this.m0 = "";
        this.n0 = "";
        this.o0 = "";
        this.p0 = "";
        this.q0 = "";
        this.r0 = "";
        this.s0 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new d1();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f141a = r5.readString(0, true);
        this.b = r5.readString(1, false);
        this.c = r5.readString(2, false);
        this.d = r5.readString(3, false);
        this.e = r5.readString(4, false);
        this.f = r5.read(this.f, 5, false);
        this.g = r5.readString(6, false);
        this.h = r5.read(this.h, 7, false);
        this.i = r5.readString(8, false);
        this.j = r5.read(this.j, 9, false);
        this.k = r5.read(this.k, 10, false);
        this.l = r5.read(this.l, 11, false);
        this.m = r5.readString(12, false);
        this.n = r5.readString(13, false);
        this.o = r5.read(this.o, 14, false);
        this.p = r5.readString(15, false);
        this.q = r5.read(this.q, 16, false);
        this.r = r5.read(this.r, 17, false);
        this.s = r5.readString(18, false);
        this.t = r5.readString(19, false);
        this.u = r5.read(this.u, 20, false);
        this.v = r5.readString(21, false);
        this.w = r5.read(this.w, 22, false);
        this.x = r5.read(this.x, 23, false);
        this.y = r5.read(this.y, 24, false);
        this.z = r5.readString(25, false);
        this.A = r5.readString(26, false);
        this.B = r5.readString(27, false);
        this.C = r5.readString(28, false);
        this.D = r5.readString(29, false);
        this.E = r5.readString(30, false);
        this.F = r5.readString(31, false);
        this.G = r5.readString(32, false);
        this.H = r5.read(this.H, 33, false);
        this.I = r5.read(this.I, 34, false);
        this.f140J = r5.read(this.f140J, 35, false);
        this.K = r5.readString(36, false);
        this.L = r5.readString(37, false);
        this.M = r5.readString(38, false);
        this.N = r5.read(this.N, 39, false);
        this.O = r5.read(this.O, 40, false);
        this.P = r5.readString(41, false);
        this.Q = r5.read(this.Q, 42, false);
        this.R = r5.readString(43, false);
        this.S = r5.readString(44, false);
        this.T = r5.readString(45, false);
        this.U = r5.readString(46, false);
        this.V = r5.readString(47, false);
        this.W = r5.readString(48, false);
        this.X = r5.readString(49, false);
        this.Y = r5.readString(50, false);
        this.Z = r5.readString(51, false);
        this.a0 = r5.read(this.a0, 52, false);
        this.b0 = r5.readString(53, false);
        this.c0 = r5.readString(54, false);
        this.d0 = r5.read(this.d0, 55, false);
        this.e0 = r5.readString(56, false);
        this.f0 = r5.readString(57, false);
        this.g0 = r5.readString(58, false);
        this.h0 = r5.read(this.h0, 59, false);
        this.i0 = r5.readString(60, false);
        this.j0 = r5.readString(61, false);
        this.k0 = r5.readString(62, false);
        this.l0 = r5.readString(63, false);
        this.m0 = r5.readString(64, false);
        this.n0 = r5.readString(65, false);
        this.o0 = r5.readString(66, false);
        this.p0 = r5.readString(67, false);
        this.q0 = r5.readString(68, false);
        this.r0 = r5.readString(69, false);
        this.s0 = r5.readString(70, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r7) {
        r7.write(this.f141a, 0);
        String r0 = this.b;
        if (r0 == null) goto L5;
        r7.write(r0, 1);
    L5:
        String r1 = this.c;
        if (r1 == null) goto L8;
        r7.write(r1, 2);
    L8:
        String r2 = this.d;
        if (r2 == null) goto L11;
        r7.write(r2, 3);
    L11:
        String r3 = this.e;
        if (r3 == null) goto L14;
        r7.write(r3, 4);
    L14:
        int r4 = this.f;
        if (1 == r4) goto L17;
        r7.write(r4, 5);
    L17:
        String r5 = this.g;
        if (r5 == null) goto L20;
        r7.write(r5, 6);
    L20:
        int r6 = this.h;
        if (r6 == 0) goto L23;
        r7.write(r6, 7);
    L23:
        String r8 = this.i;
        if (r8 == null) goto L26;
        r7.write(r8, 8);
    L26:
        int r9 = this.j;
        if (r9 == 0) goto L29;
        r7.write(r9, 9);
    L29:
        int r10 = this.k;
        if (r10 == 0) goto L32;
        r7.write(r10, 10);
    L32:
        r7.write(this.l, 11);
        String r11 = this.m;
        if (r11 == null) goto L35;
        r7.write(r11, 12);
    L35:
        String r12 = this.n;
        if (r12 == null) goto L38;
        r7.write(r12, 13);
    L38:
        int r13 = this.o;
        if (r13 == 0) goto L41;
        r7.write(r13, 14);
    L41:
        String r14 = this.p;
        if (r14 == null) goto L44;
        r7.write(r14, 15);
    L44:
        short r15 = this.q;
        if (r15 == 0) goto L47;
        r7.write(r15, 16);
    L47:
        int r16 = this.r;
        if (r16 == 0) goto L50;
        r7.write(r16, 17);
    L50:
        String r17 = this.s;
        if (r17 == null) goto L53;
        r7.write(r17, 18);
    L53:
        String r18 = this.t;
        if (r18 == null) goto L56;
        r7.write(r18, 19);
    L56:
        int r19 = this.u;
        if (r19 == 0) goto L59;
        r7.write(r19, 20);
    L59:
        String r20 = this.v;
        if (r20 == null) goto L62;
        r7.write(r20, 21);
    L62:
        long r21 = this.w;
        if (r21 == 0) goto L65;
        r7.write(r21, 22);
    L65:
        long r22 = this.x;
        if (r22 == 0) goto L68;
        r7.write(r22, 23);
    L68:
        long r23 = this.y;
        if (r23 == 0) goto L71;
        r7.write(r23, 24);
    L71:
        String r24 = this.z;
        if (r24 == null) goto L74;
        r7.write(r24, 25);
    L74:
        String r25 = this.A;
        if (r25 == null) goto L77;
        r7.write(r25, 26);
    L77:
        String r26 = this.B;
        if (r26 == null) goto L80;
        r7.write(r26, 27);
    L80:
        String r27 = this.C;
        if (r27 == null) goto L83;
        r7.write(r27, 28);
    L83:
        String r28 = this.D;
        if (r28 == null) goto L86;
        r7.write(r28, 29);
    L86:
        String r29 = this.E;
        if (r29 == null) goto L89;
        r7.write(r29, 30);
    L89:
        String r30 = this.F;
        if (r30 == null) goto L92;
        r7.write(r30, 31);
    L92:
        String r31 = this.G;
        if (r31 == null) goto L95;
        r7.write(r31, 32);
    L95:
        int r32 = this.H;
        if (r32 == 0) goto L98;
        r7.write(r32, 33);
    L98:
        int r33 = this.I;
        if (r33 == 0) goto L101;
        r7.write(r33, 34);
    L101:
        r7.write(this.f140J, 35);
        String r34 = this.K;
        if (r34 == null) goto L104;
        r7.write(r34, 36);
    L104:
        String r35 = this.L;
        if (r35 == null) goto L107;
        r7.write(r35, 37);
    L107:
        String r36 = this.M;
        if (r36 == null) goto L110;
        r7.write(r36, 38);
    L110:
        r7.write(this.N, 39);
        r7.write(this.O, 40);
        String r37 = this.P;
        if (r37 == null) goto L113;
        r7.write(r37, 41);
    L113:
        int r38 = this.Q;
        if (r38 == 1) goto L116;
        r7.write(r38, 42);
    L116:
        String r39 = this.R;
        if (r39 == null) goto L119;
        r7.write(r39, 43);
    L119:
        String r40 = this.S;
        if (r40 == null) goto L122;
        r7.write(r40, 44);
    L122:
        String r41 = this.T;
        if (r41 == null) goto L125;
        r7.write(r41, 45);
    L125:
        String r42 = this.U;
        if (r42 == null) goto L128;
        r7.write(r42, 46);
    L128:
        String r43 = this.V;
        if (r43 == null) goto L131;
        r7.write(r43, 47);
    L131:
        String r44 = this.W;
        if (r44 == null) goto L134;
        r7.write(r44, 48);
    L134:
        String r45 = this.X;
        if (r45 == null) goto L137;
        r7.write(r45, 49);
    L137:
        String r46 = this.Y;
        if (r46 == null) goto L140;
        r7.write(r46, 50);
    L140:
        String r47 = this.Z;
        if (r47 == null) goto L143;
        r7.write(r47, 51);
    L143:
        long r48 = this.a0;
        if (r48 == 0) goto L146;
        r7.write(r48, 52);
    L146:
        String r49 = this.b0;
        if (r49 == null) goto L149;
        r7.write(r49, 53);
    L149:
        String r50 = this.c0;
        if (r50 == null) goto L152;
        r7.write(r50, 54);
    L152:
        int r51 = this.d0;
        if (r51 == 0) goto L155;
        r7.write(r51, 55);
    L155:
        String r52 = this.e0;
        if (r52 == null) goto L158;
        r7.write(r52, 56);
    L158:
        String r53 = this.f0;
        if (r53 == null) goto L161;
        r7.write(r53, 57);
    L161:
        String r54 = this.g0;
        if (r54 == null) goto L164;
        r7.write(r54, 58);
    L164:
        int r55 = this.h0;
        if (r55 == 1) goto L167;
        r7.write(r55, 59);
    L167:
        String r56 = this.i0;
        if (r56 == null) goto L170;
        r7.write(r56, 60);
    L170:
        String r57 = this.j0;
        if (r57 == null) goto L173;
        r7.write(r57, 61);
    L173:
        String r58 = this.k0;
        if (r58 == null) goto L176;
        r7.write(r58, 62);
    L176:
        String r59 = this.l0;
        if (r59 == null) goto L179;
        r7.write(r59, 63);
    L179:
        String r60 = this.m0;
        if (r60 == null) goto L182;
        r7.write(r60, 64);
    L182:
        String r61 = this.n0;
        if (r61 == null) goto L185;
        r7.write(r61, 65);
    L185:
        String r62 = this.o0;
        if (r62 == null) goto L188;
        r7.write(r62, 66);
    L188:
        String r63 = this.p0;
        if (r63 == null) goto L191;
        r7.write(r63, 67);
    L191:
        String r64 = this.q0;
        if (r64 == null) goto L194;
        r7.write(r64, 68);
    L194:
        String r65 = this.r0;
        if (r65 == null) goto L197;
        r7.write(r65, 69);
    L197:
        String r66 = this.s0;
        if (r66 == null) goto L201;
        r7.write(r66, 70);
        return;
    }
}
