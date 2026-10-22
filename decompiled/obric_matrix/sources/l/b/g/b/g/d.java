package l.b.g.b.g;

import java.io.IOException;
import l.b.a.v2.f;
import l.b.a.y0;
import l.b.g.a.h;
import l.b.g.a.j;
import l.b.g.a.l;
import l.b.g.a.n;
import l.b.g.b.a.i;
import l.b.g.b.h.t;
import l.b.g.b.h.z;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static f a(l.b.b.d.a r6) {
        if ((r6 instanceof l.b.g.b.d.b) == false) goto L7;
        l.b.g.b.d.b r7 = (l.b.g.b.d.b) r6;
        return new f(e.b(r7.b()), r7.a());
    L7:
        if ((r6 instanceof l.b.g.b.f.c) == false) goto L11;
        l.b.g.b.f.c r8 = (l.b.g.b.f.c) r6;
        return new f(new l.b.a.v2.a(l.b.g.a.e.f21933e, new h(e.d(r8.a()))), r8.b());
    L11:
        if ((r6 instanceof l.b.g.b.c.b) == false) goto L15;
        return new f(new l.b.a.v2.a(l.b.g.a.e.f21934f), ((l.b.g.b.c.b) r6).a());
    L15:
        if ((r6 instanceof i) == false) goto L19;
        l.b.g.b.a.a r0 = l.b.g.b.a.a.f();
        r0.i(1);
        r0.c((i) r6);
        byte[] r9 = r0.b();
        return new f(new l.b.a.v2.a(l.b.a.r2.d.G), new y0(r9));
    L19:
        if ((r6 instanceof l.b.g.b.a.d) == false) goto L23;
        l.b.g.b.a.d r10 = (l.b.g.b.a.d) r6;
        l.b.g.b.a.a r1 = l.b.g.b.a.a.f();
        r1.i(r10.b());
        r1.c(r10.c());
        byte[] r11 = r1.b();
        return new f(new l.b.a.v2.a(l.b.a.r2.d.G), new y0(r11));
    L23:
        if ((r6 instanceof z) == false) goto L31;
        z r12 = (z) r6;
        byte[] r2 = r12.c();
        byte[] r3 = r12.d();
        byte[] r4 = r12.getEncoded();
        if (r4.length <= (r2.length + r3.length)) goto L29;
        return new f(new l.b.a.v2.a(l.b.a.k2.a.f21613a), new y0(r4));
    L29:
        return new f(new l.b.a.v2.a(l.b.g.a.e.f21935g, new l.b.g.a.i(r12.b().b(), e.f(r12.a()))), new n(r2, r3));
    L31:
        if ((r6 instanceof t) == false) goto L39;
        t r13 = (t) r6;
        byte[] r5 = r13.c();
        byte[] r14 = r13.d();
        byte[] r15 = r13.getEncoded();
        if (r15.length <= (r5.length + r14.length)) goto L37;
        return new f(new l.b.a.v2.a(l.b.a.k2.a.f21614b), new y0(r15));
    L37:
        return new f(new l.b.a.v2.a(l.b.g.a.e.f21940l, new j(r13.b().a(), r13.b().b(), e.f(r13.a()))), new l(r13.c(), r13.d()));
    L39:
        throw new IOException("key parameters not recognized");
    }
}
