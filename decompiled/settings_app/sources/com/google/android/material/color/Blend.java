package com.google.android.material.color;

/* JADX INFO: loaded from: classes3.dex */
final class Blend {
    private static final float HARMONIZE_MAX_DEGREES = 15.0f;
    private static final float HARMONIZE_PERCENTAGE = 0.5f;

    private Blend() {
    }

    public static int harmonize(int r3, int r4) {
        Hct r5 = Hct.fromInt(r3);
        Hct r6 = Hct.fromInt(r4);
        float r0 = Math.min(MathUtils.differenceDegrees(r5.getHue(), r6.getHue()) * 0.5f, HARMONIZE_MAX_DEGREES);
        return Hct.from(MathUtils.sanitizeDegrees(r5.getHue() + (r0 * rotationDirection(r5.getHue(), r6.getHue()))), r5.getChroma(), r5.getTone()).toInt();
    }

    public static int blendHctHue(int r0, int r1, float r2) {
        Cam16 r3 = Cam16.fromInt(blendCam16Ucs(r0, r1, r2));
        Cam16 r4 = Cam16.fromInt(r0);
        return Hct.from(r3.getHue(), r4.getChroma(), ColorUtils.lstarFromInt(r0)).toInt();
    }

    public static int blendCam16Ucs(int r4, int r5, float r6) {
        Cam16 r7 = Cam16.fromInt(r4);
        Cam16 r8 = Cam16.fromInt(r5);
        float r0 = r7.getJStar();
        float r1 = r7.getAStar();
        float r9 = r7.getBStar();
        float r2 = r8.getJStar();
        float r3 = r8.getAStar();
        return Cam16.fromUcs(r0 + ((r2 - r0) * r6), r1 + ((r3 - r1) * r6), r9 + ((r8.getBStar() - r9) * r6)).getInt();
    }

    private static float rotationDirection(float r9, float r10) {
        float r11 = r10 - r9;
        float r0 = r11 + 360.0f;
        float r12 = r11 - 360.0f;
        float r1 = Math.abs(r11);
        float r2 = Math.abs(r0);
        float r3 = Math.abs(r12);
        if (r1 > r2) goto L12;
        if (r1 > r3) goto L12;
        if (r11 < 0.0d) goto L10;
        return 1.0f;
    L10:
        return -1.0f;
    L12:
        if (r2 > r1) goto L21;
        if (r2 > r3) goto L21;
        if (r0 < 0.0d) goto L19;
        return 1.0f;
    L19:
        return -1.0f;
    L21:
        if (r12 < 0.0d) goto L24;
        return 1.0f;
    L24:
        return -1.0f;
    }
}
