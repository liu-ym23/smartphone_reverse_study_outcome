package l.b.g.a;

import l.b.a.c1;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f21921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f21922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f21923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f21924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f21925l;

    public c(int r1, int r2, l.b.g.d.a.b r3, l.b.g.d.a.i r4, l.b.g.d.a.h r5, l.b.g.d.a.h r6, l.b.g.d.a.a r7) {
        this.f21919f = r1;
        this.f21920g = r2;
        this.f21921h = r3.e();
        this.f21922i = r4.h();
        this.f21923j = r7.c();
        this.f21924k = r5.a();
        this.f21925l = r6.a();
    }

    private c(u r2) {
        this.f21919f = ((l.b.a.l) r2.y(0)).B();
        this.f21920g = ((l.b.a.l) r2.y(1)).B();
        this.f21921h = ((p) r2.y(2)).y();
        this.f21922i = ((p) r2.y(3)).y();
        this.f21924k = ((p) r2.y(4)).y();
        this.f21925l = ((p) r2.y(5)).y();
        this.f21923j = ((p) r2.y(6)).y();
    }

    public static c p(Object r1) {
        if ((r1 instanceof c) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new c(u.w(r1));
    L5:
        return (c) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(new l.b.a.l(this.f21919f));
        r0.a(new l.b.a.l(this.f21920g));
        r0.a(new y0(this.f21921h));
        r0.a(new y0(this.f21922i));
        r0.a(new y0(this.f21924k));
        r0.a(new y0(this.f21925l));
        r0.a(new y0(this.f21923j));
        return new c1(r0);
    }

    public l.b.g.d.a.b n() {
        return new l.b.g.d.a.b(this.f21921h);
    }

    public l.b.g.d.a.i o() {
        return new l.b.g.d.a.i(n(), this.f21922i);
    }

    public int q() {
        return this.f21920g;
    }

    public int r() {
        return this.f21919f;
    }

    public l.b.g.d.a.h s() {
        return new l.b.g.d.a.h(this.f21924k);
    }

    public l.b.g.d.a.h t() {
        return new l.b.g.d.a.h(this.f21925l);
    }

    public l.b.g.d.a.a u() {
        return new l.b.g.d.a.a(this.f21923j);
    }
}
