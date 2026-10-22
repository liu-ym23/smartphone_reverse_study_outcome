package com.google.android.material.color;

/* JADX INFO: loaded from: classes2.dex */
final class ViewingConditions {
    public static final ViewingConditions DEFAULT = null;
    private final float aw;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f6845c;
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

    private ViewingConditions(float r1, float r2, float r3, float r4, float r5, float r6, float[] r7, float r8, float r9, float r10) {
        this.n = r1;
        this.aw = r2;
        this.nbb = r3;
        this.ncb = r4;
        this.f6845c = r5;
        this.nc = r6;
        this.rgbD = r7;
        this.fl = r8;
        this.flRoot = r9;
        this.z = r10;
    }

    static ViewingConditions make(float[] r21, float r22, float r23, float r24, boolean r25) {
        float[][] r1 = Cam16.XYZ_TO_CAM16RGB;
        float r3 = ((r21[0] * r1[0][0]) + (r21[1] * r1[0][1])) + (r21[2] * r1[0][2]);
        float r6 = ((r21[0] * r1[1][0]) + (r21[1] * r1[1][1])) + (r21[2] * r1[1][2]);
        float r7 = ((r21[0] * r1[2][0]) + (r21[1] * r1[2][1])) + (r21[2] * r1[2][2]);
        float r8 = (r24 / 10.0f) + 0.8f;
        if (r8 < 0.9d) goto L5;
        float r2 = MathUtils.lerp(0.59f, 0.69f, (r8 - 0.9f) * 10.0f);
    L6:
        float r15 = r2;
        if (r25 == false) goto L9;
        float r9 = 1.0f;
    L10:
        double r10 = r9;
        if (r10 <= 1.0d) goto L14;
        r9 = 1.0f;
    L16:
        float[] r14 = {(((100.0f / r3) * r9) + 1.0f) - r9, (((100.0f / r6) * r9) + 1.0f) - r9, (((100.0f / r7) * r9) + 1.0f) - r9};
        float r11 = 1.0f / ((5.0f * r22) + 1.0f);
        float r12 = ((r11 * r11) * r11) * r11;
        float r4 = 1.0f - r12;
        float r0 = (r12 * r22) + (((0.1f * r4) * r4) * ((float) Math.cbrt(((double) r22) * 5.0d)));
        float r13 = ColorUtils.yFromLstar(r23) / r21[1];
        double r16 = r13;
        float r20 = ((float) Math.sqrt(r16)) + 1.48f;
        float r5 = 0.725f / ((float) Math.pow(r16, 0.2d));
        float[] r17 = {(float) Math.pow(((double) ((r14[0] * r0) * r3)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r14[1] * r0) * r6)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r14[2] * r0) * r7)) / 100.0d, 0.42d)};
        float[] r18 = {(r17[0] * 400.0f) / (r17[0] + 27.13f), (r17[1] * 400.0f) / (r17[1] + 27.13f), (r17[2] * 400.0f) / (r17[2] + 27.13f)};
        return new ViewingConditions(r13, (((r18[0] * 2.0f) + r18[1]) + (r18[2] * 0.05f)) * r5, r5, r5, r15, r8, r14, r0, (float) Math.pow(r0, 0.25d), r20);
    L14:
        if (r10 >= 0.0d) goto L16;
        r9 = 0.0f;
        goto L16
    L9:
        r9 = (1.0f - (((float) Math.exp(((-r22) - 42.0f) / 92.0f)) * 0.2777778f)) * r8;
        goto L10
    L5:
        r2 = MathUtils.lerp(0.525f, 0.59f, (r8 - 0.8f) * 10.0f);
        goto L6
    }

    public float getAw() {
        return this.aw;
    }

    float getC() {
        return this.f6845c;
    }

    float getFl() {
        return this.fl;
    }

    public float getFlRoot() {
        return this.flRoot;
    }

    public float getN() {
        return this.n;
    }

    public float getNbb() {
        return this.nbb;
    }

    float getNc() {
        return this.nc;
    }

    float getNcb() {
        return this.ncb;
    }

    public float[] getRgbD() {
        return this.rgbD;
    }

    float getZ() {
        return this.z;
    }
}
