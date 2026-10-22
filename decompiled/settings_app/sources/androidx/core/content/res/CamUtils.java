package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
final class CamUtils {
    static final float[][] CAM16RGB_TO_XYZ = null;
    static final float[][] SRGB_TO_XYZ = null;
    static final float[] WHITE_POINT_D65 = null;
    static final float[][] XYZ_TO_CAM16RGB = null;

    static float lerp(float r0, float r1, float r2) {
        return r0 + ((r1 - r0) * r2);
    }

    private CamUtils() {
    }

    static {
        XYZ_TO_CAM16RGB = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        CAM16RGB_TO_XYZ = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
        WHITE_POINT_D65 = new float[]{95.047f, 100.0f, 108.883f};
        SRGB_TO_XYZ = new float[][]{new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    }

    static int intFromLStar(float r15) {
        if (r15 >= 1.0f) goto L7;
        return -16777216;
    L7:
        if (r15 <= 99.0f) goto L10;
        return -1;
    L10:
        float r1 = (r15 + 16.0f) / 116.0f;
        if (r15 <= 8.0f) goto L13;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        float r16 = (r1 * r1) * r1;
    L18:
        float r4 = (r1 * r1) * r1;
        if (r4 <= 0.008856452f) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        float r8 = r4;
    L25:
        if (r7 == true) goto L28;
        r4 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
    L28:
        float[] r0 = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(r8 * r0[0], r16 * r0[1], r4 * r0[2]);
    L24:
        r8 = ((r1 * 116.0f) - 16.0f) / 903.2963f;
        goto L25
    L21:
        r7 = false;
        goto L22
    L17:
        r16 = r15 / 903.2963f;
        goto L18
    L13:
        r3 = false;
        goto L15
    }

    static float lStarFromInt(int r0) {
        return lStarFromY(yFromInt(r0));
    }

    static float lStarFromY(float r2) {
        float r3 = r2 / 100.0f;
        if (r3 > 0.008856452f) goto L7;
        return r3 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r3)) * 116.0f) - 16.0f;
    }

    static float yFromInt(int r5) {
        float r0 = linearized(Color.red(r5));
        float r1 = linearized(Color.green(r5));
        float r6 = linearized(Color.blue(r5));
        float[] r2 = SRGB_TO_XYZ[1];
        return ((r0 * r2[0]) + (r1 * r2[1])) + (r6 * r2[2]);
    }

    static float[] xyzFromInt(int r10) {
        float r0 = linearized(Color.red(r10));
        float r1 = linearized(Color.green(r10));
        float r11 = linearized(Color.blue(r10));
        float[][] r2 = SRGB_TO_XYZ;
        float[] r4 = r2[0];
        float r5 = ((r4[0] * r0) + (r4[1] * r1)) + (r4[2] * r11);
        float[] r6 = r2[1];
        float r8 = ((r6[0] * r0) + (r6[1] * r1)) + (r6[2] * r11);
        float[] r3 = r2[2];
        return new float[]{r5, r8, ((r0 * r3[0]) + (r1 * r3[1])) + (r11 * r3[2])};
    }

    static float yFromLStar(float r6) {
        if (r6 <= 8.0f) goto L7;
        float r7 = (float) Math.pow((((double) r6) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r7 * 100.0f;
    L7:
        r7 = r6 / 903.2963f;
        goto L6
    }

    static float linearized(int r6) {
        float r7 = r6 / 255.0f;
        if (r7 > 0.04045f) goto L7;
        float r8 = r7 / 12.92f;
    L6:
        return r8 * 100.0f;
    L7:
        r8 = (float) Math.pow((r7 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }
}
