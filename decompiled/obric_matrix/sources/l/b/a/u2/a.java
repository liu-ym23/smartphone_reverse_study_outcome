package l.b.a.u2;

import l.b.a.c1;
import l.b.a.f;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.u;

/* JADX INFO: loaded from: classes2.dex */
public class a extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o f21737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l.b.a.e f21738g;

    public a(o r1, l.b.a.e r2) {
        this.f21737f = r1;
        this.f21738g = r2;
    }

    private a(u r2) {
        this.f21737f = (o) r2.y(0);
        this.f21738g = r2.y(1);
    }

    public static a n(Object r1) {
        if ((r1 instanceof a) == true) goto L5;
        if (r1 == null) goto L10;
        return new a(u.w(r1));
    L10:
        throw new IllegalArgumentException("null value in getInstance()");
    L5:
        return (a) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        f r0 = new f(2);
        r0.a(this.f21737f);
        r0.a(this.f21738g);
        return new c1(r0);
    }

    public o o() {
        return this.f21737f;
    }

    public l.b.a.e p() {
        return this.f21738g;
    }
}
