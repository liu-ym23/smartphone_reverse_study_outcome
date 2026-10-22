package l.b.g.b.h;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class v {
    static u a(k r8, n r9, i r10) {
        Objects.requireNonNull(r9, "publicKey == null");
        Objects.requireNonNull(r10, "address == null");
        int r0 = r8.d().a();
        byte[][] r11 = r9.a();
        u[] r1 = new u[r11.length];
        int r3 = 0;
    L4:
        if (r3 >= r11.length) goto L6;
        r1[r3] = new u(0, r11[r3]);
        r3 = r3 + 1;
        goto L4
    L6:
        i.b r12 = new i.b().g(r10.b()).h(r10.c());
        r12.n(r10.e());
        r12.o(0);
        r12.p(r10.g());
        i.b r13 = r12.f(r10.a());
    L7:
        i r14 = (i) r13.l();
        if (r0 <= 1) goto L18;
        int r4 = 0;
    L10:
        double r5 = r0 / 2;
        if (r4 >= ((int) Math.floor(r5))) goto L14;
        i.b r6 = new i.b().g(r14.b()).h(r14.c());
        r6.n(r14.e());
        r6.o(r14.f());
        r6.p(r4);
        r14 = (i) r6.f(r14.a()).l();
        int r7 = r4 * 2;
        r1[r4] = b(r8, r1[r7], r1[r7 + 1], r14);
        r4 = r4 + 1;
        goto L10
    L14:
        if ((r0 % 2) != 1) goto L16;
        r1[(int) Math.floor(r5)] = r1[r0 - 1];
    L16:
        r0 = (int) Math.ceil(((double) r0) / 2.0d);
        i.b r15 = new i.b().g(r14.b()).h(r14.c());
        r15.n(r14.e());
        r15.o(r14.f() + 1);
        r15.p(r14.g());
        r13 = r15.f(r14.a());
        goto L7
    L18:
        return r1[0];
    }

    static u b(k r8, u r9, u r10, o r11) {
        Objects.requireNonNull(r9, "left == null");
        Objects.requireNonNull(r10, "right == null");
        if (r9.a() != r10.a()) goto L30;
        Objects.requireNonNull(r11, "address == null");
        byte[] r0 = r8.f();
        int r2 = 0;
        if ((r11 instanceof i) == false) goto L8;
        i r12 = (i) r11;
        i.b r1 = new i.b().g(r12.b()).h(r12.c());
        r1.n(r12.e());
        r1.o(r12.f());
        r1.p(r12.g());
        r11 = (i) r1.f(0).l();
    L10:
        byte[] r3 = r8.c().c(r0, r11.d());
        if ((r11 instanceof i) == false) goto L14;
        i r13 = (i) r11;
        i.b r4 = new i.b().g(r13.b()).h(r13.c());
        r4.n(r13.e());
        r4.o(r13.f());
        r4.p(r13.g());
        r11 = (i) r4.f(1).l();
    L16:
        byte[] r5 = r8.c().c(r0, r11.d());
        if ((r11 instanceof i) == false) goto L20;
        i r14 = (i) r11;
        i.b r6 = new i.b().g(r14.b()).h(r14.c());
        r6.n(r14.e());
        r6.o(r14.f());
        r6.p(r14.g());
        r11 = (i) r6.f(2).l();
    L22:
        byte[] r15 = r8.c().c(r0, r11.d());
        int r7 = r8.d().c();
        byte[] r16 = new byte[r7 * 2];
        int r17 = 0;
    L23:
        if (r17 >= r7) goto L25;
        r16[r17] = (byte) (r9.b()[r17] ^ r5[r17]);
        r17 = r17 + 1;
    L25:
        if (r2 >= r7) goto L28;
        r16[r2 + r7] = (byte) (r10.b()[r2] ^ r15[r2]);
        r2 = r2 + 1;
        goto L25
    L28:
        return new u(r9.a(), r8.c().b(r3, r16));
    L20:
        if ((r11 instanceof g) == false) goto L22;
        g r18 = (g) r11;
        g.b r19 = new g.b().g(r18.b()).h(r18.c());
        r19.m(r18.e());
        r19.n(r18.f());
        r11 = (g) r19.f(2).k();
        goto L22
    L14:
        if ((r11 instanceof g) == false) goto L16;
        g r110 = (g) r11;
        g.b r20 = new g.b().g(r110.b()).h(r110.c());
        r20.m(r110.e());
        r20.n(r110.f());
        r11 = (g) r20.f(1).k();
        goto L16
    L8:
        if ((r11 instanceof g) == false) goto L10;
        g r111 = (g) r11;
        g.b r21 = new g.b().g(r111.b()).h(r111.c());
        r21.m(r111.e());
        r21.n(r111.f());
        r11 = (g) r21.f(0).k();
        goto L10
    L30:
        throw new IllegalStateException("height of both nodes must be equal");
    }
}
