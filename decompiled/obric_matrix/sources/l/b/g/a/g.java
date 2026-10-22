package l.b.g.a;

import l.b.a.c1;
import l.b.a.o;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class g extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b.a.l f21948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private o f21949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l.b.a.l f21950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[][] f21951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[][] f21952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f21953k;

    public g(int r4, short[][] r5, short[][] r6, short[] r7) {
        this.f21948f = new l.b.a.l(0);
        this.f21950h = new l.b.a.l(r4);
        this.f21951i = l.b.g.b.e.b.a.c(r5);
        this.f21952j = l.b.g.b.e.b.a.c(r6);
        this.f21953k = l.b.g.b.e.b.a.a(r7);
    }

    private g(u r6) {
        if ((r6.y(0) instanceof l.b.a.l) == false) goto L5;
        this.f21948f = l.b.a.l.w(r6.y(0));
    L6:
        this.f21950h = l.b.a.l.w(r6.y(1));
        u r1 = u.w(r6.y(2));
        this.f21951i = new byte[r1.size()][];
        int r2 = 0;
    L8:
        if (r2 >= r1.size()) goto L10;
        this.f21951i[r2] = p.w(r1.y(r2)).y();
        r2 = r2 + 1;
        goto L8
    L10:
        u r3 = (u) r6.y(3);
        this.f21952j = new byte[r3.size()][];
        int r4 = 0;
    L12:
        if (r4 >= r3.size()) goto L14;
        this.f21952j[r4] = p.w(r3.y(r4)).y();
        r4 = r4 + 1;
        goto L12
    L14:
        this.f21953k = p.w(((u) r6.y(4)).y(0)).y();
        return;
    L5:
        this.f21949g = o.B(r6.y(0));
        goto L6
    }

    public static g r(Object r1) {
        if ((r1 instanceof g) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new g(u.w(r1));
    L5:
        return (g) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        l.b.a.e r1 = this.f21948f;
        if (r1 != null) goto L6;
        r1 = this.f21949g;
    L6:
        r0.a(r1);
        r0.a(this.f21950h);
        l.b.a.f r2 = new l.b.a.f();
        int r3 = 0;
        int r4 = 0;
    L7:
        byte[][] r5 = this.f21951i;
        if (r4 >= r5.length) goto L10;
        r2.a(new y0(r5[r4]));
        r4 = r4 + 1;
        goto L7
    L10:
        r0.a(new c1(r2));
        l.b.a.f r6 = new l.b.a.f();
    L11:
        byte[][] r7 = this.f21952j;
        if (r3 >= r7.length) goto L14;
        r6.a(new y0(r7[r3]));
        r3 = r3 + 1;
        goto L11
    L14:
        r0.a(new c1(r6));
        l.b.a.f r8 = new l.b.a.f();
        r8.a(new y0(this.f21953k));
        r0.a(new c1(r8));
        return new c1(r0);
    }

    public short[][] n() {
        return l.b.g.b.e.b.a.d(this.f21951i);
    }

    public short[] o() {
        return l.b.g.b.e.b.a.b(this.f21953k);
    }

    public short[][] p() {
        return l.b.g.b.e.b.a.d(this.f21952j);
    }

    public int q() {
        return this.f21950h.B();
    }
}
