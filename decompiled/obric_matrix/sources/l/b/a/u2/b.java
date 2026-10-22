package l.b.a.u2;

import l.b.a.c1;
import l.b.a.d1;
import l.b.a.f;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.w;

/* JADX INFO: loaded from: classes2.dex */
public class b extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private w f21739f;

    public b(o r3, l.b.a.e r4) {
        f r0 = new f(2);
        r0.a(r3);
        r0.a(r4);
        this.f21739f = new d1(new c1(r0));
    }

    private b(w r1) {
        this.f21739f = r1;
    }

    public b(a[] r2) {
        this.f21739f = new d1(r2);
    }

    public static b o(Object r1) {
        if ((r1 instanceof b) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new b(w.x(r1));
    L5:
        return (b) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        return this.f21739f;
    }

    public a n() {
        if (this.f21739f.size() != 0) goto L7;
        return null;
    L7:
        return a.n(this.f21739f.z(0));
    }

    public a[] p() {
        int r0 = this.f21739f.size();
        a[] r1 = new a[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = a.n(this.f21739f.z(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public boolean q() {
        if (this.f21739f.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int size() {
        return this.f21739f.size();
    }
}
