package l.b.g.a;

import l.b.a.c1;
import l.b.a.t;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class l extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f21971g;

    public l(byte[] r1, byte[] r2) {
        this.f21970f = l.b.h.a.d(r1);
        this.f21971g = l.b.h.a.d(r2);
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(new l.b.a.l(0));
        r0.a(new y0(this.f21970f));
        r0.a(new y0(this.f21971g));
        return new c1(r0);
    }
}
