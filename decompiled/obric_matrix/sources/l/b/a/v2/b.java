package l.b.a.v2;

import l.b.a.c1;
import l.b.a.l;
import l.b.a.n;
import l.b.a.t;

/* JADX INFO: loaded from: classes2.dex */
public class b extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    l.b.a.c f21771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    l f21772g;

    public b(boolean r2) {
        this.f21771f = l.b.a.c.x(false);
        this.f21772g = null;
        if (r2 == false) goto L5;
        this.f21771f = l.b.a.c.x(true);
    L6:
        this.f21772g = null;
        return;
    L5:
        this.f21771f = null;
        goto L6
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(2);
        l.b.a.c r1 = this.f21771f;
        if (r1 == null) goto L5;
        r0.a(r1);
    L5:
        l r2 = this.f21772g;
        if (r2 == null) goto L9;
        r0.a(r2);
    L9:
        return new c1(r0);
    }

    public boolean n() {
        l.b.a.c r0 = this.f21771f;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.y() == false) goto L7;
        return true;
    }

    public String toString() {
        if (this.f21772g != null) goto L7;
        StringBuilder r0 = new StringBuilder();
        r0.append("BasicConstraints: isCa(");
        r0.append(n());
        r0.append(")");
    L6:
        return r0.toString();
    L7:
        r0 = new StringBuilder();
        r0.append("BasicConstraints: isCa(");
        r0.append(n());
        r0.append("), pathLenConstraint = ");
        r0.append(this.f21772g.y());
        goto L6
    }
}
