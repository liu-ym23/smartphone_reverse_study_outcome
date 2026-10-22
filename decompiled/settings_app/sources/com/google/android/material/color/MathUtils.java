package com.google.android.material.color;

/* JADX INFO: loaded from: classes3.dex */
final class MathUtils {
    public static float lerp(float r1, float r2, float r3) {
        return ((1.0f - r3) * r1) + (r3 * r2);
    }

    public static float sanitizeDegrees(float r2) {
        if (r2 >= 0.0f) goto L7;
        return (r2 % 360.0f) + 360.0f;
    L7:
        if (r2 >= 360.0f) goto L9;
        return r2;
    L9:
        return r2 % 360.0f;
    }

    static float toDegrees(float r1) {
        return (r1 * 180.0f) / 3.1415927f;
    }

    static float toRadians(float r1) {
        return (r1 / 180.0f) * 3.1415927f;
    }

    private MathUtils() {
    }

    static float clamp(float r0, float r1, float r2) {
        return Math.min(Math.max(r2, r0), r1);
    }

    public static float differenceDegrees(float r0, float r1) {
        return 180.0f - Math.abs(Math.abs(r0 - r1) - 180.0f);
    }

    public static int sanitizeDegrees(int r1) {
        if (r1 < 0) goto L5;
        if (r1 >= 360) goto L8;
        return r1;
    L8:
        return r1 % 360;
    L5:
        return (r1 % 360) + 360;
    }
}
