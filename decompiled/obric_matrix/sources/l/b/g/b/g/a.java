package l.b.g.b.g;

import java.io.IOException;
import l.b.a.o;
import l.b.a.p;
import l.b.g.a.h;
import l.b.g.a.i;
import l.b.g.a.j;
import l.b.g.a.k;
import l.b.g.a.m;
import l.b.g.b.h.a0;
import l.b.g.b.h.r;
import l.b.g.b.h.s;
import l.b.g.b.h.x;
import l.b.g.b.h.y;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static short[] a(byte[] r4) {
        int r0 = r4.length / 2;
        short[] r1 = new short[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = l.b.h.e.g(r4, r2 * 2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static l.b.b.d.a b(l.b.a.r2.e r7) {
        o r0 = r7.p().n();
        if (r0.F(l.b.a.d2.a.D) == false) goto L7;
        return new l.b.g.b.d.a(e.c(r7.p()), p.w(r7.s()).y());
    L7:
        if (r0.r(l.b.a.d2.a.f21536h) == false) goto L11;
        return new l.b.g.b.f.b(p.w(r7.s()).y(), e.e(h.n(r7.p().q())));
    L11:
        if (r0.r(l.b.a.d2.a.H) == false) goto L15;
        return new l.b.g.b.c.a(a(p.w(r7.s()).y()));
    L15:
        if (r0.r(l.b.a.r2.d.G) == false) goto L29;
        byte[] r1 = p.w(r7.s()).y();
        l.b.a.b r8 = r7.q();
        if (l.b.h.e.a(r1, 0) != 1) goto L23;
        if (r8 == null) goto L22;
        byte[] r9 = r8.y();
        return l.b.g.b.a.h.f(l.b.h.a.g(r1, 4, r1.length), l.b.h.a.g(r9, 4, r9.length));
    L22:
        return l.b.g.b.a.h.e(l.b.h.a.g(r1, 4, r1.length));
    L23:
        if (r8 == null) goto L27;
        return l.b.g.b.a.c.b(l.b.h.a.g(r1, 4, r1.length), r8.y());
    L27:
        return l.b.g.b.a.c.a(l.b.h.a.g(r1, 4, r1.length));
    L29:
        if (r0.r(l.b.a.d2.a.f21540l) == false) goto L43;
        i r2 = i.o(r7.p().q());
        o r3 = r2.p().n();
        m r10 = m.p(r7.s());
        y.b r4 = new y.b(new x(r2.n(), e.a(r3)));     // Catch: ClassNotFoundException -> L39
        r4.l(r10.o());     // Catch: ClassNotFoundException -> L39
        r4.q(r10.u());     // Catch: ClassNotFoundException -> L39
        r4.p(r10.t());     // Catch: ClassNotFoundException -> L39
        r4.n(r10.r());     // Catch: ClassNotFoundException -> L39
        r4.o(r10.s());     // Catch: ClassNotFoundException -> L39
        if (r10.v() == 0) goto L35;
        r4.m(r10.q());     // Catch: ClassNotFoundException -> L39
    L35:
        if (r10.n() == null) goto L37;
        r4.k(((l.b.g.b.h.a) a0.f(r10.n(), l.b.g.b.h.a.class)).h(r3));     // Catch: ClassNotFoundException -> L39
    L37:
        return r4.j();
    L39:
        e = move-exception;
        throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
    L43:
        if (r0.r(l.b.g.a.e.f21940l) == false) goto L57;
        j r5 = j.o(r7.p().q());
        o r6 = r5.q().n();
        k r11 = k.p(r7.s());     // Catch: ClassNotFoundException -> L53
        s.b r12 = new s.b(new r(r5.n(), r5.p(), e.a(r6)));     // Catch: ClassNotFoundException -> L53
        r12.m(r11.o());     // Catch: ClassNotFoundException -> L53
        r12.r(r11.u());     // Catch: ClassNotFoundException -> L53
        r12.q(r11.t());     // Catch: ClassNotFoundException -> L53
        r12.o(r11.r());     // Catch: ClassNotFoundException -> L53
        r12.p(r11.s());     // Catch: ClassNotFoundException -> L53
        if (r11.v() == 0) goto L49;
        r12.n(r11.q());     // Catch: ClassNotFoundException -> L53
    L49:
        if (r11.n() == null) goto L51;
        r12.l(((l.b.g.b.h.b) a0.f(r11.n(), l.b.g.b.h.b.class)).f(r6));     // Catch: ClassNotFoundException -> L53
    L51:
        return r12.k();
    L53:
        e = move-exception;
        throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
    L57:
        throw new RuntimeException("algorithm identifier in private key not recognised");
    }
}
