package l.b.g.b.g;

import java.io.IOException;
import l.b.a.w;
import l.b.a.y0;
import l.b.g.a.h;
import l.b.g.a.i;
import l.b.g.a.j;
import l.b.g.a.k;
import l.b.g.a.m;
import l.b.g.b.h.a0;
import l.b.g.b.h.s;
import l.b.g.b.h.y;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static l.b.a.r2.e a(l.b.b.d.a r6, w r7) {
        if ((r6 instanceof l.b.g.b.d.a) == false) goto L7;
        l.b.g.b.d.a r8 = (l.b.g.b.d.a) r6;
        return new l.b.a.r2.e(e.b(r8.b()), new y0(r8.a()), r7);
    L7:
        if ((r6 instanceof l.b.g.b.f.b) == false) goto L11;
        l.b.g.b.f.b r9 = (l.b.g.b.f.b) r6;
        return new l.b.a.r2.e(new l.b.a.v2.a(l.b.g.a.e.f21933e, new h(e.d(r9.a()))), new y0(r9.b()));
    L11:
        if ((r6 instanceof l.b.g.b.c.a) == false) goto L19;
        l.b.a.v2.a r10 = new l.b.a.v2.a(l.b.g.a.e.f21934f);
        short[] r11 = ((l.b.g.b.c.a) r6).a();
        byte[] r0 = new byte[r11.length * 2];
        int r1 = 0;
    L14:
        if (r1 == r11.length) goto L17;
        l.b.h.e.l(r11[r1], r0, r1 * 2);
        r1 = r1 + 1;
        goto L14
    L17:
        return new l.b.a.r2.e(r10, new y0(r0));
    L19:
        if ((r6 instanceof l.b.g.b.a.h) == false) goto L23;
        l.b.g.b.a.h r12 = (l.b.g.b.a.h) r6;
        l.b.g.b.a.a r2 = l.b.g.b.a.a.f();
        r2.i(1);
        r2.c(r12);
        byte[] r3 = r2.b();
        l.b.g.b.a.a r4 = l.b.g.b.a.a.f();
        r4.i(1);
        r4.c(r12.i());
        byte[] r13 = r4.b();
        return new l.b.a.r2.e(new l.b.a.v2.a(l.b.a.r2.d.G), new y0(r3), r7, r13);
    L23:
        if ((r6 instanceof l.b.g.b.a.c) == false) goto L27;
        l.b.g.b.a.c r14 = (l.b.g.b.a.c) r6;
        l.b.g.b.a.a r5 = l.b.g.b.a.a.f();
        r5.i(r14.c());
        r5.c(r14);
        byte[] r15 = r5.b();
        l.b.g.b.a.a r16 = l.b.g.b.a.a.f();
        r16.i(r14.c());
        r16.c(r14.d().c());
        byte[] r17 = r16.b();
        return new l.b.a.r2.e(new l.b.a.v2.a(l.b.a.r2.d.G), new y0(r15), r7, r17);
    L27:
        if ((r6 instanceof y) == false) goto L31;
        y r18 = (y) r6;
        return new l.b.a.r2.e(new l.b.a.v2.a(l.b.g.a.e.f21935g, new i(r18.b().b(), e.f(r18.a()))), b(r18), r7);
    L31:
        if ((r6 instanceof s) == false) goto L35;
        s r19 = (s) r6;
        return new l.b.a.r2.e(new l.b.a.v2.a(l.b.g.a.e.f21940l, new j(r19.b().a(), r19.b().b(), e.f(r19.a()))), c(r19), r7);
    L35:
        throw new IOException("key parameters not recognized");
    }

    private static m b(y r14) {
        byte[] r0 = r14.getEncoded();
        int r1 = r14.b().h();
        int r15 = r14.b().b();
        int r7 = (int) a0.a(r0, 0, 4);
        if (a0.l(r15, r7) == false) goto L16;
        byte[] r8 = a0.g(r0, 4, r1);
        int r3 = 4 + r1;
        byte[] r9 = a0.g(r0, r3, r1);
        int r4 = r3 + r1;
        byte[] r10 = a0.g(r0, r4, r1);
        int r5 = r4 + r1;
        byte[] r11 = a0.g(r0, r5, r1);
        int r6 = r5 + r1;
        byte[] r12 = a0.g(r0, r6, r0.length - r6);
        l.b.g.b.h.a r2 = (l.b.g.b.h.a) a0.f(r12, l.b.g.b.h.a.class);     // Catch: ClassNotFoundException -> L12
        if (r2.c() == ((1 << r15) - 1)) goto L11;
        return new m(r7, r8, r9, r10, r11, r12, r2.c());
    L11:
        return new m(r7, r8, r9, r10, r11, r12);
    L12:
        e = move-exception;
        throw new IOException("cannot parse BDS: " + e.getMessage());
    L16:
        throw new IllegalArgumentException("index out of bounds");
    }

    private static k c(s r15) {
        byte[] r0 = r15.getEncoded();
        int r1 = r15.b().f();
        int r16 = r15.b().a();
        int r2 = (r16 + 7) / 8;
        long r6 = (int) a0.a(r0, 0, r2);
        if (a0.l(r16, r6) == false) goto L16;
        int r3 = r2 + 0;
        byte[] r8 = a0.g(r0, r3, r1);
        int r4 = r3 + r1;
        byte[] r9 = a0.g(r0, r4, r1);
        int r5 = r4 + r1;
        byte[] r10 = a0.g(r0, r5, r1);
        int r7 = r5 + r1;
        byte[] r11 = a0.g(r0, r7, r1);
        int r12 = r7 + r1;
        byte[] r13 = a0.g(r0, r12, r0.length - r12);
        l.b.g.b.h.b r14 = (l.b.g.b.h.b) a0.f(r13, l.b.g.b.h.b.class);     // Catch: ClassNotFoundException -> L12
        if (r14.b() == ((1 << r16) - 1)) goto L11;
        return new k(r6, r8, r9, r10, r11, r13, r14.b());
    L11:
        return new k(r6, r8, r9, r10, r11, r13);
    L12:
        e = move-exception;
        throw new IOException("cannot parse BDSStateMap: " + e.getMessage());
    L16:
        throw new IllegalArgumentException("index out of bounds");
    }
}
