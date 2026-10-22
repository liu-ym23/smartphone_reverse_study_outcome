package l.b.a.r2;

import l.b.a.c1;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.u;
import l.b.a.w;

/* JADX INFO: loaded from: classes2.dex */
public class a extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o f21671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private w f21672g;

    public a(o r1, w r2) {
        this.f21671f = r1;
        this.f21672g = r2;
    }

    public a(u r2) {
        this.f21671f = (o) r2.y(0);
        this.f21672g = (w) r2.y(1);
    }

    public static a p(Object r3) {
        if (r3 == null) goto L13;
        if ((r3 instanceof a) == true) goto L13;
        if ((r3 instanceof u) == false) goto L11;
        return new a((u) r3);
    L11:
        throw new IllegalArgumentException("unknown object in factory: " + r3.getClass().getName());
    L13:
        return (a) r3;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(2);
        r0.a(this.f21671f);
        r0.a(this.f21672g);
        return new c1(r0);
    }

    public o n() {
        return this.f21671f;
    }

    public w o() {
        return this.f21672g;
    }
}
