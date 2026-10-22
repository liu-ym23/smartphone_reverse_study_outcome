package l.b.a.v2;

import l.b.a.a0;
import l.b.a.c1;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.u;

/* JADX INFO: loaded from: classes2.dex */
public class a extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o f21769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l.b.a.e f21770g;

    public a(o r1) {
        this.f21769f = r1;
    }

    public a(o r1, l.b.a.e r2) {
        this.f21769f = r1;
        this.f21770g = r2;
    }

    private a(u r4) {
        if (r4.size() < 1) goto L13;
        if (r4.size() > 2) goto L13;
        this.f21769f = o.B(r4.y(0));
        if (r4.size() != 2) goto L9;
        l.b.a.e r5 = r4.y(1);
    L10:
        this.f21770g = r5;
        return;
    L9:
        r5 = null;
    L13:
        throw new IllegalArgumentException("Bad sequence size: " + r4.size());
    }

    public static a o(Object r1) {
        if ((r1 instanceof a) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new a(u.w(r1));
    L5:
        return (a) r1;
    }

    public static a p(a0 r0, boolean r1) {
        return o(u.x(r0, r1));
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(2);
        r0.a(this.f21769f);
        l.b.a.e r2 = this.f21770g;
        if (r2 == null) goto L6;
        r0.a(r2);
    L6:
        return new c1(r0);
    }

    public o n() {
        return this.f21769f;
    }

    public l.b.a.e q() {
        return this.f21770g;
    }
}
