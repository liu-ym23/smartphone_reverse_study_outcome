package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class MathUtils {
    public static final float EPSILON = 0.001f;

    private MathUtils() {
    }

    public static boolean areFloatsEqual(float r0, float r1) {
        if (Math.abs(r0 - r1) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public static float clamp(float r2, float r3, float r4) {
        if (r3 <= r4) goto L5;
        float r1 = r4;
    L6:
        if (r3 > r4) goto L10;
        r3 = r4;
    L10:
        if (r2 >= r1) goto L13;
        return r1;
    L13:
        if (r2 > r3) goto L15;
        return r2;
    L15:
        return r3;
    L5:
        r1 = r3;
        goto L6
    }

    public static int compareLongs(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 != r2) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static float distance(float r0, float r1, float r2, float r3) {
        float r4 = r2 - r0;
        float r5 = r3 - r1;
        return (float) Math.sqrt((r5 * r5) + (r4 * r4));
    }

    public static float flipSignIf(float r0, boolean r1) {
        if (r1 == true) goto L4;
        return r0;
    L4:
        return -r0;
    }

    public static float interpolate(float r0, float r1, float r2) {
        return a.a.a(r1, r0, r2, r0);
    }

    public static float map(float r0, float r1, float r2, float r3, float r4) {
        float r5 = (r0 - r1) / (r2 - r1);
        return (r5 * (r4 - r3)) + r3;
    }

    public static int positiveModulo(int r0, int r1) {
        int r2 = r0 % r1;
        if (r2 < 0) goto L6;
        return r2;
    L6:
        return r2 + r1;
    }

    public static double roundTwoDecimalPlaces(double r2) {
        return Math.round(r2 * 100.0d) / 100.0d;
    }

    public static float scaleToFitTargetSize(int[] r4, int r5, int r6) {
        if (r4.length < 2) goto L11;
        int r1 = r4[0];
        if (r1 <= 0) goto L11;
        int r3 = r4[1];
        if (r3 <= 0) goto L11;
        float r7 = Math.max(r5 / r1, r6 / r3);
        r4[0] = (int) (r4[0] * r7);
        r4[1] = (int) (r4[1] * r7);
        return r7;
    L11:
        throw new IllegalArgumentException("Expected dimensions to have length >= 2 && dimensions[0] > 0 && dimensions[1] > 0");
    }

    public static float smoothstep(float r2) {
        float r0 = r2 * r2;
        return (3.0f - (r2 * 2.0f)) * r0;
    }

    public static int clamp(int r1, int r2, int r3) {
        if (r2 <= r3) goto L4;
        int r0 = r3;
    L5:
        if (r2 > r3) goto L8;
        r2 = r3;
    L8:
        if (r1 < r0) goto L13;
        if (r1 > r2) goto L12;
        return r1;
    L12:
        return r2;
    L13:
        return r0;
    L4:
        r0 = r2;
        goto L5
    }

    public static int flipSignIf(int r0, boolean r1) {
        if (r1 == true) goto L4;
        return r0;
    L4:
        return -r0;
    }

    public static long clamp(long r3, long r5, long r7) {
        if (r5 <= r7) goto L5;
        long r1 = r7;
    L6:
        if (r5 > r7) goto L10;
        r5 = r7;
    L10:
        if (r3 >= r1) goto L13;
        return r1;
    L13:
        if (r3 > r5) goto L15;
        return r3;
    L15:
        return r5;
    L5:
        r1 = r5;
        goto L6
    }
}
