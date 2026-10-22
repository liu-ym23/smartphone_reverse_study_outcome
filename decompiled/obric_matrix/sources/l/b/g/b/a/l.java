package l.b.g.b.a;

/* JADX INFO: loaded from: classes2.dex */
class l {
    static byte[] a(e r10, byte[] r11, int r12, byte[] r13) {
        l.b.b.a r0 = b.a(r10.b());
        a r1 = a.f();
        r1.d(r11);
        r1.i(r12);
        r1.h(-32640);
        r1.g(0, 22);
        byte[] r2 = r1.b();
        r0.b(r2, 0, r2.length);
        l.b.b.a r3 = b.a(r10.b());
        a r4 = a.f();
        r4.d(r11);
        r4.i(r12);
        r4.g(0, r3.f() + 23);
        byte[] r5 = r4.b();
        n r6 = new n(r11, r13, b.a(r10.b()));
        r6.d(r12);
        r6.c(0);
        int r14 = r10.d();
        int r15 = r10.c();
        int r16 = (1 << r10.g()) - 1;
        int r7 = 0;
    L3:
        if (r7 >= r14) goto L12;
        if (r7 >= (r14 - 1)) goto L7;
        boolean r8 = true;
    L8:
        r6.a(r5, r8, 23);
        l.b.h.e.k((short) r7, r5, 20);
        int r9 = 0;
    L9:
        if (r9 >= r16) goto L11;
        r5[22] = (byte) r9;
        r3.b(r5, 0, r5.length);
        r3.a(r5, 23);
        r9 = r9 + 1;
        goto L9
    L11:
        r0.b(r5, 23, r15);
        r7 = r7 + 1;
        goto L3
    L7:
        r8 = false;
        goto L8
    L12:
        byte[] r17 = new byte[r0.f()];
        r0.a(r17, 0);
        return r17;
    }
}
