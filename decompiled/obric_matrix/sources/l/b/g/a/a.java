package l.b.g.a;

import l.b.a.c1;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f21911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f21912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f21913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private l.b.a.v2.a f21914k;

    public a(int r1, int r2, l.b.g.d.a.b r3, l.b.g.d.a.i r4, l.b.g.d.a.h r5, l.b.a.v2.a r6) {
        this.f21909f = r1;
        this.f21910g = r2;
        this.f21911h = r3.e();
        this.f21912i = r4.h();
        this.f21913j = r5.a();
        this.f21914k = r6;
    }

    private a(u r2) {
        this.f21909f = ((l.b.a.l) r2.y(0)).B();
        this.f21910g = ((l.b.a.l) r2.y(1)).B();
        this.f21911h = ((p) r2.y(2)).y();
        this.f21912i = ((p) r2.y(3)).y();
        this.f21913j = ((p) r2.y(4)).y();
        this.f21914k = l.b.a.v2.a.o(r2.y(5));
    }

    public static a q(Object r1) {
        if ((r1 instanceof a) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new a(u.w(r1));
    L5:
        return (a) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(new l.b.a.l(this.f21909f));
        r0.a(new l.b.a.l(this.f21910g));
        r0.a(new y0(this.f21911h));
        r0.a(new y0(this.f21912i));
        r0.a(new y0(this.f21913j));
        r0.a(this.f21914k);
        return new c1(r0);
    }

    public l.b.a.v2.a n() {
        return this.f21914k;
    }

    public l.b.g.d.a.b o() {
        return new l.b.g.d.a.b(this.f21911h);
    }

    public l.b.g.d.a.i p() {
        return new l.b.g.d.a.i(o(), this.f21912i);
    }

    public int r() {
        return this.f21910g;
    }

    public int s() {
        return this.f21909f;
    }

    public l.b.g.d.a.h t() {
        return new l.b.g.d.a.h(this.f21913j);
    }
}
