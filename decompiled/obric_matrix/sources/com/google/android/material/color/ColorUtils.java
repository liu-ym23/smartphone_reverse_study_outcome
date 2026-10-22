package com.google.android.material.color;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class ColorUtils {
    private static final float[] WHITE_POINT_D65 = null;

    static {
        WHITE_POINT_D65 = new float[]{95.047f, 100.0f, 108.883f};
    }

    private ColorUtils() {
    }

    public static int blueFromInt(int r0) {
        return r0 & 255;
    }

    public static float delinearized(float r5) {
        if (r5 > 0.0031308f) goto L7;
        return r5 * 12.92f;
    L7:
        return (((float) Math.pow(r5, 0.4166666567325592d)) * 1.055f) - 0.055f;
    }

    public static int greenFromInt(int r1) {
        return (r1 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static String hexFromInt(int r4) {
        int r0 = redFromInt(r4);
        int r1 = blueFromInt(r4);
        return String.format("#%02x%02x%02x", new Object[]{Integer.valueOf(r0), Integer.valueOf(greenFromInt(r4)), Integer.valueOf(r1)});
    }

    public static int intFromLab(double r17, double r19, double r21) {
        double r2 = (r17 + 16.0d) / 116.0d;
        double r6 = (r19 / 500.0d) + r2;
        double r8 = r2 - (r21 / 200.0d);
        double r10 = (r6 * r6) * r6;
        if (r10 > 0.008856451679035631d) goto L7;
        r10 = ((r6 * 116.0d) - 16.0d) / 903.2962962962963d;
    L7:
        if (r17 <= 8.0d) goto L9;
        double r7 = (r2 * r2) * r2;
    L10:
        double r3 = (r8 * r8) * r8;
        if (r3 > 0.008856451679035631d) goto L14;
        r3 = ((r8 * 116.0d) - 16.0d) / 903.2962962962963d;
    L14:
        float[] r0 = WHITE_POINT_D65;
        double r11 = r10 * ((double) r0[0]);
        double r9 = r7 * ((double) r0[1]);
        double r4 = r3 * ((double) r0[2]);
        return intFromXyzComponents((float) r11, (float) r9, (float) r4);
    L9:
        r7 = r17 / 903.2962962962963d;
        goto L10
    }

    public static int intFromLstar(float r9) {
        float r1 = (r9 + 16.0f) / 116.0f;
        float r3 = (r1 * r1) * r1;
        if (r3 <= 0.008856452f) goto L5;
        boolean r4 = true;
    L7:
        if (r9 <= 8.0f) goto L9;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        float r10 = r3;
    L14:
        if (r4 == false) goto L16;
        float r8 = r3;
    L17:
        if (r4 == true) goto L20;
        r3 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
    L20:
        float[] r2 = WHITE_POINT_D65;
        return intFromXyz(new float[]{r8 * r2[0], r10 * r2[1], r3 * r2[2]});
    L16:
        r8 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
        goto L17
    L13:
        r10 = r9 / 903.2963f;
        goto L14
    L9:
        r7 = false;
        goto L11
    L5:
        r4 = false;
        goto L7
    }

    public static int intFromRgb(int r1, int r2, int r3) {
        return (((((r1 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK) | ((r2 & 255) << 8)) | (r3 & 255)) >>> 0;
    }

    public static int intFromXyz(float[] r3) {
        return intFromXyzComponents(r3[0], r3[1], r3[2]);
    }

    public static int intFromXyzComponents(float r3, float r4, float r5) {
        float r6 = r3 / 100.0f;
        float r7 = r4 / 100.0f;
        float r8 = r5 / 100.0f;
        float r0 = ((3.2406f * r6) + ((-1.5372f) * r7)) + ((-0.4986f) * r8);
        float r1 = (((-0.9689f) * r6) + (1.8758f * r7)) + (0.0415f * r8);
        float r9 = ((r6 * 0.0557f) + (r7 * (-0.204f))) + (r8 * 1.057f);
        float r10 = delinearized(r0);
        float r11 = delinearized(r1);
        float r12 = delinearized(r9);
        return intFromRgb(Math.max(Math.min(255, Math.round(r10 * 255.0f)), 0), Math.max(Math.min(255, Math.round(r11 * 255.0f)), 0), Math.max(Math.min(255, Math.round(r12 * 255.0f)), 0));
    }

    public static double[] labFromInt(int r17) {
        float[] r0 = xyzFromInt(r17);
        float r2 = r0[1];
        float[] r3 = WHITE_POINT_D65;
        double r4 = r2 / r3[1];
        if (r4 <= 0.008856451679035631d) goto L5;
        double r5 = Math.cbrt(r4);
    L6:
        double r14 = r0[0] / r3[0];
        if (r14 <= 0.008856451679035631d) goto L9;
        double r15 = Math.cbrt(r14);
    L10:
        double r1 = r0[2] / r3[2];
        if (r1 <= 0.008856451679035631d) goto L13;
        double r6 = Math.cbrt(r1);
    L15:
        return new double[]{(116.0d * r5) - 16.0d, (r15 - r5) * 500.0d, (r5 - r6) * 200.0d};
    L13:
        r6 = ((r1 * 903.2962962962963d) + 16.0d) / 116.0d;
        goto L15
    L9:
        r15 = ((r14 * 903.2962962962963d) + 16.0d) / 116.0d;
        goto L10
    L5:
        r5 = ((r4 * 903.2962962962963d) + 16.0d) / 116.0d;
        goto L6
    }

    public static float linearized(float r4) {
        if (r4 > 0.04045f) goto L7;
        return r4 / 12.92f;
    L7:
        return (float) Math.pow((r4 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float lstarFromInt(int r2) {
        return (float) labFromInt(r2)[0];
    }

    public static int redFromInt(int r1) {
        return (r1 & 16711680) >> 16;
    }

    public static final float[] whitePointD65() {
        return Arrays.copyOf(WHITE_POINT_D65, 3);
    }

    public static float[] xyzFromInt(int r5) {
        float r0 = linearized(redFromInt(r5) / 255.0f) * 100.0f;
        float r3 = linearized(greenFromInt(r5) / 255.0f) * 100.0f;
        float r6 = linearized(blueFromInt(r5) / 255.0f) * 100.0f;
        return new float[]{((0.41233894f * r0) + (0.35762063f * r3)) + (0.18051042f * r6), ((0.2126f * r0) + (0.7152f * r3)) + (0.0722f * r6), ((r0 * 0.01932141f) + (r3 * 0.11916382f)) + (r6 * 0.9503448f)};
    }

    public static float yFromLstar(float r6) {
        if (r6 <= 8.0f) goto L7;
        float r7 = (float) Math.pow((((double) r6) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r7 * 100.0f;
    L7:
        r7 = r6 / 903.2963f;
        goto L6
    }
}
