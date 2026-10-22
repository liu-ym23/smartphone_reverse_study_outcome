package com.android.settings.utils;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class RectUtils {
    public RectUtils() {
    }

    public static boolean detectCollision(Rect r0, Rect r1, int r2, int r3, int r4) {
        if (overlap(r0, r1, r2, r3) < r4) goto L5;
        return true;
    L5:
        return false;
    }

    public static int overlap(Rect r2, Rect r3) {
        return overlap(r2, r3, radius(r2), radius(r3));
    }

    public static int overlap(Rect r1, Rect r2, int r3, int r4) {
        int r0 = Math.min(r3, r4);
        int r5 = Math.max(r3, r4);
        int r6 = centerDistance(r1, r2);
        if (r6 < 0) goto L8;
        if (r6 >= (r5 - r0)) goto L8;
        return r0 * 2;
    L8:
        if ((r5 - r0) > r6) goto L12;
        int r7 = r5 + r0;
        if (r6 > r7) goto L12;
        return r7 - r6;
    L12:
        return 0;
    }

    private static int centerDistance(Rect r2, Rect r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return 0;
    L6:
        return (int) distance(r2.centerX(), r2.centerY(), r3.centerX(), r3.centerY());
    L7:
        return 0;
    }

    public static int radius(Rect r4) {
        if (r4 != null) goto L6;
        return 0;
    L6:
        return (int) (distance(0, 0, r4.width(), r4.height()) / 2.0d);
    }

    public static double distance(int r4, int r5, int r6, int r7) {
        return Math.sqrt(Math.pow(r4 - r6, 2.0d) + Math.pow(r5 - r7, 2.0d));
    }
}
