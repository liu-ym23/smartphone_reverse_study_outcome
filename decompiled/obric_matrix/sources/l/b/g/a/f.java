package l.b.g.a;

import l.b.a.c1;
import l.b.a.o;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class f extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b.a.l f21941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private o f21942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[][] f21943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f21944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[][] f21945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f21946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f21947l;
    private l.b.g.b.e.a[] m;

    private f(u r19) {
        int r2 = 0;
        if ((r19.y(0) instanceof l.b.a.l) == false) goto L5;
        this.f21941f = l.b.a.l.w(r19.y(0));
    L6:
        u r4 = (u) r19.y(1);
        this.f21943h = new byte[r4.size()][];
        int r5 = 0;
    L8:
        if (r5 >= r4.size()) goto L10;
        this.f21943h[r5] = ((p) r4.y(r5)).y();
        r5 = r5 + 1;
        goto L8
    L10:
        this.f21944i = ((p) ((u) r19.y(2)).y(0)).y();
        u r6 = (u) r19.y(3);
        this.f21945j = new byte[r6.size()][];
        int r7 = 0;
    L12:
        if (r7 >= r6.size()) goto L14;
        this.f21945j[r7] = ((p) r6.y(r7)).y();
        r7 = r7 + 1;
        goto L12
    L14:
        this.f21946k = ((p) ((u) r19.y(4)).y(0)).y();
        this.f21947l = ((p) ((u) r19.y(5)).y(0)).y();
        u r1 = (u) r19.y(6);
        byte[][][][] r8 = new byte[r1.size()][][][];
        byte[][][][] r9 = new byte[r1.size()][][][];
        byte[][][] r10 = new byte[r1.size()][][];
        byte[][] r11 = new byte[r1.size()][];
        int r12 = 0;
    L16:
        if (r12 >= r1.size()) goto L38;
        u r13 = (u) r1.y(r12);
        u r14 = (u) r13.y(r2);
        r8[r12] = new byte[r14.size()][][];
        int r15 = r2;
    L19:
        if (r15 >= r14.size()) goto L25;
        u r16 = (u) r14.y(r15);
        r8[r12][r15] = new byte[r16.size()][];
        int r3 = 0;
    L22:
        if (r3 >= r16.size()) goto L24;
        r8[r12][r15][r3] = ((p) r16.y(r3)).y();
        r3 = r3 + 1;
        goto L22
    L24:
        r15 = r15 + 1;
        goto L19
    L25:
        u r17 = (u) r13.y(1);
        r9[r12] = new byte[r17.size()][][];
        int r18 = 0;
    L27:
        if (r18 >= r17.size()) goto L33;
        u r110 = (u) r17.y(r18);
        r9[r12][r18] = new byte[r110.size()][];
        int r111 = 0;
    L30:
        if (r111 >= r110.size()) goto L32;
        r9[r12][r18][r111] = ((p) r110.y(r111)).y();
        r111 = r111 + 1;
        goto L30
    L32:
        r18 = r18 + 1;
        goto L27
    L33:
        u r20 = (u) r13.y(2);
        r10[r12] = new byte[r20.size()][];
        int r112 = 0;
    L35:
        if (r112 >= r20.size()) goto L37;
        r10[r12][r112] = ((p) r20.y(r112)).y();
        r112 = r112 + 1;
        goto L35
    L37:
        r11[r12] = ((p) r13.y(3)).y();
        r12 = r12 + 1;
        r2 = 0;
        goto L16
    L38:
        int r21 = this.f21947l.length - 1;
        this.m = new l.b.g.b.e.a[r21];
        int r22 = 0;
    L39:
        if (r22 >= r21) goto L41;
        byte[] r23 = this.f21947l;
        int r24 = r22 + 1;
        this.m[r22] = new l.b.g.b.e.a(r23[r22], r23[r24], l.b.g.b.e.b.a.f(r8[r22]), l.b.g.b.e.b.a.f(r9[r22]), l.b.g.b.e.b.a.d(r10[r22]), l.b.g.b.e.b.a.b(r11[r22]));
        r22 = r24;
        goto L39
    L41:
        return;
    L5:
        this.f21942g = o.B(r19.y(0));
        goto L6
    }

    public f(short[][] r4, short[] r5, short[][] r6, short[] r7, int[] r8, l.b.g.b.e.a[] r9) {
        this.f21941f = new l.b.a.l(1);
        this.f21943h = l.b.g.b.e.b.a.c(r4);
        this.f21944i = l.b.g.b.e.b.a.a(r5);
        this.f21945j = l.b.g.b.e.b.a.c(r6);
        this.f21946k = l.b.g.b.e.b.a.a(r7);
        this.f21947l = l.b.g.b.e.b.a.h(r8);
        this.m = r9;
    }

    public static f p(Object r1) {
        if ((r1 instanceof f) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new f(u.w(r1));
    L5:
        return (f) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        l.b.a.e r1 = this.f21941f;
        if (r1 != null) goto L6;
        r1 = this.f21942g;
    L6:
        r0.a(r1);
        l.b.a.f r2 = new l.b.a.f();
        int r3 = 0;
    L7:
        byte[][] r4 = this.f21943h;
        if (r3 >= r4.length) goto L10;
        r2.a(new y0(r4[r3]));
        r3 = r3 + 1;
        goto L7
    L10:
        r0.a(new c1(r2));
        l.b.a.f r5 = new l.b.a.f();
        r5.a(new y0(this.f21944i));
        r0.a(new c1(r5));
        l.b.a.f r6 = new l.b.a.f();
        int r7 = 0;
    L11:
        byte[][] r8 = this.f21945j;
        if (r7 >= r8.length) goto L14;
        r6.a(new y0(r8[r7]));
        r7 = r7 + 1;
        goto L11
    L14:
        r0.a(new c1(r6));
        l.b.a.f r9 = new l.b.a.f();
        r9.a(new y0(this.f21946k));
        r0.a(new c1(r9));
        l.b.a.f r10 = new l.b.a.f();
        r10.a(new y0(this.f21947l));
        r0.a(new c1(r10));
        l.b.a.f r11 = new l.b.a.f();
        int r12 = 0;
    L16:
        if (r12 >= this.m.length) goto L38;
        l.b.a.f r13 = new l.b.a.f();
        byte[][][] r14 = l.b.g.b.e.b.a.e(this.m[r12].a());
        l.b.a.f r15 = new l.b.a.f();
        int r16 = 0;
    L19:
        if (r16 >= r14.length) goto L25;
        l.b.a.f r17 = new l.b.a.f();
        int r18 = 0;
    L22:
        if (r18 >= r14[r16].length) goto L24;
        r17.a(new y0(r14[r16][r18]));
        r18 = r18 + 1;
        goto L22
    L24:
        r15.a(new c1(r17));
        r16 = r16 + 1;
        goto L19
    L25:
        r13.a(new c1(r15));
        byte[][][] r19 = l.b.g.b.e.b.a.e(this.m[r12].b());
        l.b.a.f r20 = new l.b.a.f();
        int r21 = 0;
    L27:
        if (r21 >= r19.length) goto L33;
        l.b.a.f r22 = new l.b.a.f();
        int r23 = 0;
    L30:
        if (r23 >= r19[r21].length) goto L32;
        r22.a(new y0(r19[r21][r23]));
        r23 = r23 + 1;
        goto L30
    L32:
        r20.a(new c1(r22));
        r21 = r21 + 1;
        goto L27
    L33:
        r13.a(new c1(r20));
        byte[][] r24 = l.b.g.b.e.b.a.c(this.m[r12].d());
        l.b.a.f r25 = new l.b.a.f();
        int r26 = 0;
    L35:
        if (r26 >= r24.length) goto L37;
        r25.a(new y0(r24[r26]));
        r26 = r26 + 1;
        goto L35
    L37:
        r13.a(new c1(r25));
        r13.a(new y0(l.b.g.b.e.b.a.a(this.m[r12].c())));
        r11.a(new c1(r13));
        r12 = r12 + 1;
        goto L16
    L38:
        r0.a(new c1(r11));
        return new c1(r0);
    }

    public short[] n() {
        return l.b.g.b.e.b.a.b(this.f21944i);
    }

    public short[] o() {
        return l.b.g.b.e.b.a.b(this.f21946k);
    }

    public short[][] q() {
        return l.b.g.b.e.b.a.d(this.f21943h);
    }

    public short[][] r() {
        return l.b.g.b.e.b.a.d(this.f21945j);
    }

    public l.b.g.b.e.a[] s() {
        return this.m;
    }

    public int[] t() {
        return l.b.g.b.e.b.a.g(this.f21947l);
    }
}
