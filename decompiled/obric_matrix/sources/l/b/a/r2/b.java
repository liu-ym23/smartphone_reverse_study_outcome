package l.b.a.r2;

import l.b.a.c1;
import l.b.a.n;
import l.b.a.p0;
import l.b.a.t;

/* JADX INFO: loaded from: classes2.dex */
public class b extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected c f21673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected l.b.a.v2.a f21674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected p0 f21675h;

    public b(c r2, l.b.a.v2.a r3, p0 r4) {
        this.f21673f = null;
        this.f21674g = null;
        this.f21675h = null;
        this.f21673f = r2;
        this.f21674g = r3;
        this.f21675h = r4;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(3);
        r0.a(this.f21673f);
        r0.a(this.f21674g);
        r0.a(this.f21675h);
        return new c1(r0);
    }
}
