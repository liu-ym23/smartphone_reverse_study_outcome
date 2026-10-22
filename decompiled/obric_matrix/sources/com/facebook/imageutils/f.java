package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static int a(int r0) {
        return h.a(r0);
    }

    public static int b(int r0) {
        return h.b(r0);
    }

    public static int c(InputStream r2) {
        int r1 = e(r2);     // Catch: IOException -> L8
        if (r1 != 0) goto L6;
        return 0;
    L6:
        return h.e(r2, r1);
    L8:
        return 0;
    }

    private static boolean d(int r0) {
        switch(r0) {
            case 192: goto L5;
            case 193: goto L5;
            case 194: goto L5;
            case 195: goto L5;
            case 196: goto L3;
            case 197: goto L5;
            case 198: goto L5;
            case 199: goto L5;
            case 200: goto L3;
            case 201: goto L5;
            case 202: goto L5;
            case 203: goto L5;
            case 204: goto L3;
            case 205: goto L5;
            case 206: goto L5;
            case 207: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    private static int e(InputStream r4) {
        if (f(r4, 225) == false) goto L10;
        int r2 = g.a(r4, 2, false) - 2;
        if (r2 <= 6) goto L10;
        int r3 = g.a(r4, 4, false);
        int r5 = g.a(r4, 2, false);
        int r6 = (r2 - 4) - 2;
        if (r3 != 1165519206) goto L10;
        if (r5 != 0) goto L10;
        return r6;
    L10:
        return 0;
    }

    public static boolean f(InputStream r4, int r5) {
        d.c.c.d.i.g(r4);
    L4:
        if (g.a(r4, 1, false) != 255) goto L25;
        int r2 = 255;
    L6:
        if (r2 != 255) goto L9;
        r2 = g.a(r4, 1, false);
        goto L6
    L9:
        if (r5 == 192) goto L11;
    L13:
        if (r2 == r5) goto L14;
        if (r2 == 216) goto L4;
        if (r2 == 1) goto L4;
        if (r2 == 217) goto L25;
        if (r2 == 218) goto L25;
        r4.skip(g.a(r4, 2, false) - 2);
        goto L4
    L14:
        return true;
    L11:
        if (d(r2) == false) goto L13;
        return true;
    L25:
        return false;
    }

    public static int g(int r0) {
        return Math.abs(360 - r0) % 360;
    }

    public static int h(int r2) {
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L6;
        return 8;
    L6:
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L10;
        return 0;
    L10:
        return 6;
    L12:
        return 3;
    L15:
        return 1;
    }
}
