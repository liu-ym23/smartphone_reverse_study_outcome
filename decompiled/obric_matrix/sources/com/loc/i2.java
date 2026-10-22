package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public final class i2 extends e5 {
    private static int a(d5 r0) {
        return r0.n();
    }

    public static int b(d5 r1, int r2, byte r3, int r4, int r5) {
        r1.q(4);
        h(r1, r5);
        g(r1, r4);
        e(r1, r2);
        d(r1, r3);
        return a(r1);
    }

    public static int c(d5 r2, int[] r3) {
        r2.h(4, r3.length, 4);
        int r0 = r3.length - 1;
    L3:
        if (r0 < 0) goto L6;
        r2.e(r3[r0]);
        r0 = r0 - 1;
        goto L3
    L6:
        return r2.a();
    }

    private static void d(d5 r1, byte r2) {
        r1.f(1, r2);
    }

    private static void e(d5 r1, int r2) {
        r1.r(0, r2);
    }

    public static int f(d5 r2, int[] r3) {
        r2.h(4, r3.length, 4);
        int r0 = r3.length - 1;
    L3:
        if (r0 < 0) goto L6;
        r2.e(r3[r0]);
        r0 = r0 - 1;
        goto L3
    L6:
        return r2.a();
    }

    private static void g(d5 r1, int r2) {
        r1.r(2, r2);
    }

    private static void h(d5 r1, int r2) {
        r1.r(3, r2);
    }
}
