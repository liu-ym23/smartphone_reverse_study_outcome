package com.google.android.material.color;

/* JADX INFO: loaded from: classes3.dex */
final class ViewingConditions {
    public static final ViewingConditions DEFAULT = null;
    private final float aw;
    private final float c;
    private final float fl;
    private final float flRoot;
    private final float n;
    private final float nbb;
    private final float nc;
    private final float ncb;
    private final float[] rgbD;
    private final float z;

    static {
        DEFAULT = make(ColorUtils.whitePointD65(), (float) ((((double) ColorUtils.yFromLstar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    public float getAw() {
        return this.aw;
    }

    public float getN() {
        return this.n;
    }

    public float getNbb() {
        return this.nbb;
    }

    float getNcb() {
        return this.ncb;
    }

    float getC() {
        return this.c;
    }

    float getNc() {
        return this.nc;
    }

    public float[] getRgbD() {
        return this.rgbD;
    }

    float getFl() {
        return this.fl;
    }

    public float getFlRoot() {
        return this.flRoot;
    }

    float getZ() {
        return this.z;
    }

    static ViewingConditions make(float[] r22, float r23, float r24, float r25, boolean r26) {
        float[][] r1 = Cam16.XYZ_TO_CAM16RGB;
        float r3 = r22[0];
        float[] r4 = r1[0];
        float r5 = r4[0] * r3;
        float r7 = r22[1];
        float r6 = r5 + (r4[1] * r7);
        float r9 = r22[2];
        float r8 = r6 + (r4[2] * r9);
        float[] r10 = r1[1];
        float r11 = ((r10[0] * r3) + (r10[1] * r7)) + (r10[2] * r9);
        float[] r2 = r1[2];
        float r12 = ((r3 * r2[0]) + (r7 * r2[1])) + (r9 * r2[2]);
        float r13 = (r25 / 10.0f) + 0.8f;
        if (r13 < 0.9d) goto L5;
        float r14 = MathUtils.lerp(0.59f, 0.69f, (r13 - 0.9f) * 10.0f);
    L6:
        float r16 = r14;
        if (r26 == false) goto L9;
        float r15 = 1.0f;
    L10:
        double r17 = r15;
        if (r17 <= 1.0d) goto L14;
        r15 = 1.0f;
    L16:
        float[] r18 = {(((100.0f / r8) * r15) + 1.0f) - r15, (((100.0f / r11) * r15) + 1.0f) - r15, (((100.0f / r12) * r15) + 1.0f) - r15};
        float r19 = 1.0f / ((5.0f * r23) + 1.0f);
        float r110 = ((r19 * r19) * r19) * r19;
        float r20 = 1.0f - r110;
        float r0 = (r110 * r23) + (((0.1f * r20) * r20) * ((float) Math.cbrt(((double) r23) * 5.0d)));
        float r111 = ColorUtils.yFromLstar(r24) / r22[1];
        double r112 = r111;
        float r21 = ((float) Math.sqrt(r112)) + 1.48f;
        float r27 = 0.725f / ((float) Math.pow(r112, 0.2d));
        float r28 = (float) Math.pow(((double) ((r18[2] * r0) * r12)) / 100.0d, 0.42d);
        float[] r29 = {(float) Math.pow(((double) ((r18[0] * r0) * r8)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r18[1] * r0) * r11)) / 100.0d, 0.42d), r28};
        float r30 = r29[0];
        float r31 = r29[1];
        return new ViewingConditions(r111, (((((r30 * 400.0f) / (r30 + 27.13f)) * 2.0f) + ((r31 * 400.0f) / (r31 + 27.13f))) + (((400.0f * r28) / (r28 + 27.13f)) * 0.05f)) * r27, r27, r27, r16, r13, r18, r0, (float) Math.pow(r0, 0.25d), r21);
    L14:
        if (r17 >= 0.0d) goto L16;
        r15 = 0.0f;
        goto L16
    L9:
        r15 = (1.0f - (((float) Math.exp(((-r23) - 42.0f) / 92.0f)) * 0.2777778f)) * r13;
        goto L10
    L5:
        r14 = MathUtils.lerp(0.525f, 0.59f, (r13 - 0.8f) * 10.0f);
        goto L6
    }

    private ViewingConditions(float r1, float r2, float r3, float r4, float r5, float r6, float[] r7, float r8, float r9, float r10) {
        this.n = r1;
        this.aw = r2;
        this.nbb = r3;
        this.ncb = r4;
        this.c = r5;
        this.nc = r6;
        this.rgbD = r7;
        this.fl = r8;
        this.flRoot = r9;
        this.z = r10;
    }
}
