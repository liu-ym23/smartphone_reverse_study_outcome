package com.facebook.imageutils;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f6779a = null;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f6780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6782c;

        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }
    }

    static {
        f6779a = h.class;
    }

    h() {
    }

    public static int a(int r1) {
        if (r1 != 3) goto L5;
        return 180;
    L5:
        if (r1 != 6) goto L7;
        return 90;
    L7:
        if (r1 == 8) goto L10;
        return 0;
    L10:
        return 270;
    }

    public static int b(int r1) {
        if (r1 != 0) goto L4;
        return 1;
    L4:
        if (r1 != 90) goto L6;
        return 6;
    L6:
        if (r1 != 180) goto L8;
        return 3;
    L8:
        if (r1 == 270) goto L11;
        return 0;
    L11:
        return 8;
    }

    private static int c(InputStream r3, int r4, boolean r5) {
        if (r4 >= 10) goto L6;
        return 0;
    L6:
        if (g.a(r3, 2, r5) == 3) goto L9;
        return 0;
    L9:
        if (g.a(r3, 4, r5) == 1) goto L11;
        return 0;
    L11:
        int r0 = g.a(r3, 2, r5);
        g.a(r3, 2, r5);
        return r0;
    }

    private static int d(InputStream r6, int r7, boolean r8, int r9) {
        if (r7 >= 14) goto L5;
        return 0;
    L5:
        int r2 = g.a(r6, 2, r8);
        int r10 = r7 - 2;
    L6:
        int r3 = r2 - 1;
        if (r2 <= 0) goto L14;
        if (r10 < 12) goto L14;
        int r11 = r10 - 2;
        if (g.a(r6, 2, r8) == r9) goto L12;
        r6.skip(10);
        r10 = r11 - 10;
        r2 = r3;
        goto L6
    L12:
        return r11;
    L14:
        return 0;
    }

    public static int e(InputStream r4, int r5) {
        b r0 = new b(null);
        int r6 = f(r4, r5, r0);
        int r1 = r0.f6782c - 8;
        if (r6 == 0) goto L8;
        if (r1 > r6) goto L10;
        r4.skip(r1);
        return c(r4, d(r4, r6 - r1, r0.f6780a, 274), r0.f6780a);
    L10:
        return 0;
    L8:
        return 0;
    }

    private static int f(InputStream r6, int r7, b r8) {
        if (r7 > 8) goto L5;
        return 0;
    L5:
        int r3 = g.a(r6, 4, false);
        r8.f6781b = r3;
        int r9 = r7 - 4;
        if (r3 != 1229531648) goto L8;
    L12:
        if (r3 != 1229531648) goto L14;
        boolean r4 = true;
    L15:
        r8.f6780a = r4;
        int r10 = g.a(r6, 4, r4);
        r8.f6782c = r10;
        int r11 = r9 - 4;
        if (r10 >= 8) goto L18;
    L21:
        Class<?> r12 = f6779a;
        String r13 = "Invalid offset";
    L10:
        d.c.c.e.a.f(r12, r13);
        return 0;
    L18:
        if ((r10 - 8) > r11) goto L21;
        return r11;
    L14:
        r4 = false;
        goto L15
    L8:
        if (r3 == 1296891946) goto L12;
        r12 = f6779a;
        r13 = "Invalid TIFF header";
        goto L10
    }
}
