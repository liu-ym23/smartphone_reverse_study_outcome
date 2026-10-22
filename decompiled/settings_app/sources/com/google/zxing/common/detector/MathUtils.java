package com.google.zxing.common.detector;

/* JADX INFO: loaded from: classes4.dex */
public final class MathUtils {
    public static int round(float r1) {
        if (r1 >= 0.0f) goto L5;
        float r0 = -0.5f;
    L7:
        return (int) (r1 + r0);
    L5:
        r0 = 0.5f;
        goto L7
    }

    private MathUtils() {
    }

    public static float distance(float r0, float r1, float r2, float r3) {
        float r4 = r0 - r2;
        float r5 = r1 - r3;
        return (float) Math.sqrt((r4 * r4) + (r5 * r5));
    }

    public static float distance(int r0, int r1, int r2, int r3) {
        int r4 = r0 - r2;
        int r5 = r1 - r3;
        return (float) Math.sqrt((r4 * r4) + (r5 * r5));
    }

    public static int sum(int[] r4) {
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + r4[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }
}
