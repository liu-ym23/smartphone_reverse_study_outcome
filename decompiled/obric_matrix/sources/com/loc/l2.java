package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 extends e5 {
    private static int a(d5 r0) {
        return r0.n();
    }

    public static int b(d5 r1, byte r2, int r3) {
        r1.q(2);
        e(r1, r3);
        d(r1, r2);
        return a(r1);
    }

    public static int c(d5 r2, byte[] r3) {
        r2.h(1, r3.length, 1);
        int r0 = r3.length - 1;
    L3:
        if (r0 < 0) goto L6;
        r2.d(r3[r0]);
        r0 = r0 - 1;
        goto L3
    L6:
        return r2.a();
    }

    private static void d(d5 r1, byte r2) {
        r1.f(0, r2);
    }

    private static void e(d5 r1, int r2) {
        r1.r(1, r2);
    }
}
