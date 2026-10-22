package l.b.g.b.g;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import l.b.a.o;
import l.b.a.p;
import l.b.g.a.j;
import l.b.g.a.n;
import l.b.g.b.a.i;
import l.b.g.b.h.r;
import l.b.g.b.h.t;
import l.b.g.b.h.x;
import l.b.g.b.h.z;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map f22073a;

    static /* synthetic */ class a {
    }

    private static class b extends f {
        private b() {
            super(null);
        }

        /* synthetic */ b(a r1) {
            this();
        }

        @Override // l.b.g.b.g.c.f
        l.b.b.d.a a(l.b.a.v2.f r2, Object r3) {
            byte[] r1 = p.w(r2.q()).y();
            if (l.b.h.e.a(r1, 0) != 1) goto L7;
            return i.a(l.b.h.a.g(r1, 4, r1.length));
        L7:
            if (r1.length != 64) goto L10;
            r1 = l.b.h.a.g(r1, 4, r1.length);
        L10:
            return l.b.g.b.a.d.a(r1);
        }
    }

    /* JADX INFO: renamed from: l.b.g.b.g.c$c, reason: collision with other inner class name */
    private static class C0596c extends f {
        private C0596c() {
            super(null);
        }

        /* synthetic */ C0596c(a r1) {
            this();
        }

        @Override // l.b.g.b.g.c.f
        l.b.b.d.a a(l.b.a.v2.f r1, Object r2) {
            return new l.b.g.b.c.b(r1.p().x());
        }
    }

    private static class d extends f {
        private d() {
            super(null);
        }

        /* synthetic */ d(a r1) {
            this();
        }

        @Override // l.b.g.b.g.c.f
        l.b.b.d.a a(l.b.a.v2.f r1, Object r2) {
            return new l.b.g.b.d.b(l.b.g.b.g.e.c(r1.n()), r1.p().y());
        }
    }

    private static class e extends f {
        private e() {
            super(null);
        }

        /* synthetic */ e(a r1) {
            this();
        }

        @Override // l.b.g.b.g.c.f
        l.b.b.d.a a(l.b.a.v2.f r1, Object r2) {
            return new l.b.g.b.f.c(r1.p().x(), l.b.g.b.g.e.e(l.b.g.a.h.n(r1.n().q())));
        }
    }

    private static abstract class f {
        private f() {
        }

        /* synthetic */ f(a r1) {
            this();
        }

        abstract l.b.b.d.a a(l.b.a.v2.f r1, Object r2);
    }

    private static class g extends f {
        private g() {
            super(null);
        }

        /* synthetic */ g(a r1) {
            this();
        }

        @Override // l.b.g.b.g.c.f
        l.b.b.d.a a(l.b.a.v2.f r3, Object r4) {
            l.b.g.a.i r2 = l.b.g.a.i.o(r3.n().q());
            if (r2 == null) goto L6;
            o r5 = r2.p().n();
            n r6 = n.n(r3.q());
            z.b r0 = new z.b(new x(r2.n(), l.b.g.b.g.e.a(r5)));
            r0.g(r6.o());
            r0.h(r6.p());
            return r0.e();
        L6:
            byte[] r7 = p.w(r3.q()).y();
            z.b r8 = new z.b(x.k(l.b.h.e.a(r7, 0)));
            r8.f(r7);
            return r8.e();
        }
    }

    private static class h extends f {
        private h() {
            super(null);
        }

        /* synthetic */ h(a r1) {
            this();
        }

        @Override // l.b.g.b.g.c.f
        l.b.b.d.a a(l.b.a.v2.f r4, Object r5) {
            j r3 = j.o(r4.n().q());
            if (r3 == null) goto L6;
            o r6 = r3.q().n();
            n r7 = n.n(r4.q());
            t.b r0 = new t.b(new r(r3.n(), r3.p(), l.b.g.b.g.e.a(r6)));
            r0.g(r7.o());
            r0.h(r7.p());
            return r0.e();
        L6:
            byte[] r8 = p.w(r4.q()).y();
            t.b r9 = new t.b(r.i(l.b.h.e.a(r8, 0)));
            r9.f(r8);
            return r9.e();
        }
    }

    static {
        HashMap r0 = new HashMap();
        f22073a = r0;
        a r3 = null;
        r0.put(l.b.g.a.e.q, new d(r3));
        f22073a.put(l.b.g.a.e.r, new d(r3));
        f22073a.put(l.b.g.a.e.f21933e, new e(r3));
        f22073a.put(l.b.g.a.e.f21934f, new C0596c(r3));
        f22073a.put(l.b.g.a.e.f21935g, new g(r3));
        f22073a.put(l.b.g.a.e.f21940l, new h(r3));
        f22073a.put(l.b.a.k2.a.f21613a, new g(r3));
        f22073a.put(l.b.a.k2.a.f21614b, new h(r3));
        f22073a.put(l.b.a.r2.d.G, new b(r3));
    }

    public static l.b.b.d.a a(l.b.a.v2.f r1) {
        return b(r1, null);
    }

    public static l.b.b.d.a b(l.b.a.v2.f r3, Object r4) {
        l.b.a.v2.a r0 = r3.n();
        f r1 = (f) f22073a.get(r0.n());
        if (r1 == null) goto L7;
        return r1.a(r3, r4);
    L7:
        throw new IOException("algorithm identifier in public key not recognised: " + r0.n());
    }
}
