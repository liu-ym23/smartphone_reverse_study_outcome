package com.google.android.material.color;

/* JADX INFO: loaded from: classes3.dex */
final class Cam16 {
    static final float[][] CAM16RGB_TO_XYZ = null;
    static final float[][] XYZ_TO_CAM16RGB = null;
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;
    private final float j;
    private final float jstar;
    private final float m;
    private final float q;
    private final float s;

    static {
        XYZ_TO_CAM16RGB = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        CAM16RGB_TO_XYZ = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    }

    float distance(Cam16 r4) {
        float r0 = getJStar() - r4.getJStar();
        float r1 = getAStar() - r4.getAStar();
        float r3 = getBStar() - r4.getBStar();
        return (float) (Math.pow(Math.sqrt(((r0 * r0) + (r1 * r1)) + (r3 * r3)), 0.63d) * 1.41d);
    }

    public float getHue() {
        return this.hue;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getJ() {
        return this.j;
    }

    public float getQ() {
        return this.q;
    }

    public float getM() {
        return this.m;
    }

    public float getS() {
        return this.s;
    }

    public float getJStar() {
        return this.jstar;
    }

    public float getAStar() {
        return this.astar;
    }

    public float getBStar() {
        return this.bstar;
    }

    private Cam16(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        this.hue = r1;
        this.chroma = r2;
        this.j = r3;
        this.q = r4;
        this.m = r5;
        this.s = r6;
        this.jstar = r7;
        this.astar = r8;
        this.bstar = r9;
    }

    public static Cam16 fromInt(int r1) {
        return fromIntInViewingConditions(r1, ViewingConditions.DEFAULT);
    }

    static Cam16 fromIntInViewingConditions(int r26, ViewingConditions r27) {
        float r1 = ColorUtils.linearized(((16711680 & r26) >> 16) / 255.0f) * 100.0f;
        float r2 = ColorUtils.linearized(((65280 & r26) >> 8) / 255.0f) * 100.0f;
        float r0 = ColorUtils.linearized((r26 & 255) / 255.0f) * 100.0f;
        float r3 = ((0.41233894f * r1) + (0.35762063f * r2)) + (0.18051042f * r0);
        float r5 = ((0.2126f * r1) + (0.7152f * r2)) + (0.0722f * r0);
        float r4 = ((r1 * 0.01932141f) + (r2 * 0.11916382f)) + (r0 * 0.9503448f);
        float[][] r6 = XYZ_TO_CAM16RGB;
        float[] r7 = r6[0];
        float r8 = ((r7[0] * r3) + (r7[1] * r5)) + (r7[2] * r4);
        float[] r9 = r6[1];
        float r10 = ((r9[0] * r3) + (r9[1] * r5)) + (r9[2] * r4);
        float[] r11 = r6[2];
        float r12 = ((r3 * r11[0]) + (r5 * r11[1])) + (r4 * r11[2]);
        float r13 = r27.getRgbD()[0] * r8;
        float r14 = r27.getRgbD()[1] * r10;
        float r15 = r27.getRgbD()[2] * r12;
        float r16 = (float) Math.pow(((double) (r27.getFl() * Math.abs(r13))) / 100.0d, 0.42d);
        float r17 = (float) Math.pow(((double) (r27.getFl() * Math.abs(r14))) / 100.0d, 0.42d);
        float r18 = (float) Math.pow(((double) (r27.getFl() * Math.abs(r15))) / 100.0d, 0.42d);
        float r19 = ((Math.signum(r13) * 400.0f) * r16) / (r16 + 27.13f);
        float r20 = ((Math.signum(r14) * 400.0f) * r17) / (r17 + 27.13f);
        float r21 = ((Math.signum(r15) * 400.0f) * r18) / (r18 + 27.13f);
        double r22 = r21;
        float r23 = ((float) (((((double) r19) * 11.0d) + (((double) r20) * (-12.0d))) + r22)) / 11.0f;
        float r24 = ((float) (((double) (r19 + r20)) - (r22 * 2.0d))) / 9.0f;
        float r25 = r20 * 20.0f;
        float r28 = (((r19 * 20.0f) + r25) + (21.0f * r21)) / 20.0f;
        float r29 = (((r19 * 40.0f) + r25) + r21) / 20.0f;
        double r30 = r24;
        double r31 = r23;
        float r32 = (((float) Math.atan2(r30, r31)) * 180.0f) / 3.1415927f;
        if (r32 >= 0.0f) goto L6;
        r32 = r32 + 360.0f;
    L8:
        float r110 = (3.1415927f * r32) / 180.0f;
        float r33 = ((float) Math.pow((r29 * r27.getNbb()) / r27.getAw(), r27.getC() * r27.getZ())) * 100.0f;
        float r210 = (((4.0f / r27.getC()) * ((float) Math.sqrt(r33 / 100.0f))) * (r27.getAw() + 4.0f)) * r27.getFlRoot();
        if (r32 >= 20.14d) goto L11;
        float r111 = 360.0f + r32;
    L12:
        float r34 = ((float) Math.pow(1.64d - Math.pow(0.29d, r27.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(Math.toRadians(r111) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r27.getNc()) * r27.getNcb()) * ((float) Math.hypot(r31, r30))) / (r28 + 0.305f), 0.9d));
        float r112 = r34 * ((float) Math.sqrt(((double) r33) / 100.0d));
        float r211 = r112 * r27.getFlRoot();
        float r212 = ((float) Math.sqrt((r34 * r27.getC()) / (r27.getAw() + 4.0f))) * 50.0f;
        float r213 = (1.7f * r33) / ((0.007f * r33) + 1.0f);
        float r35 = ((float) Math.log1p(0.0228f * r211)) * 43.85965f;
        double r36 = r110;
        return new Cam16(r32, r112, r33, r210, r211, r212, r213, r35 * ((float) Math.cos(r36)), r35 * ((float) Math.sin(r36)));
    L11:
        r111 = r32;
        goto L12
    L6:
        if (r32 < 360.0f) goto L8;
        r32 = r32 - 360.0f;
        goto L8
    }

    static Cam16 fromJch(float r1, float r2, float r3) {
        return fromJchInViewingConditions(r1, r2, r3, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(float r13, float r14, float r15, ViewingConditions r16) {
        double r4 = ((double) r13) / 100.0d;
        float r6 = (((4.0f / r16.getC()) * ((float) Math.sqrt(r4))) * (r16.getAw() + 4.0f)) * r16.getFlRoot();
        float r7 = r14 * r16.getFlRoot();
        float r8 = ((float) Math.sqrt(((r14 / ((float) Math.sqrt(r4))) * r16.getC()) / (r16.getAw() + 4.0f))) * 50.0f;
        float r9 = (1.7f * r13) / ((0.007f * r13) + 1.0f);
        float r1 = ((float) Math.log1p(((double) r7) * 0.0228d)) * 43.85965f;
        double r5 = (3.1415927f * r15) / 180.0f;
        return new Cam16(r15, r14, r13, r6, r7, r8, r9, r1 * ((float) Math.cos(r5)), r1 * ((float) Math.sin(r5)));
    }

    public static Cam16 fromUcs(float r1, float r2, float r3) {
        return fromUcsInViewingConditions(r1, r2, r3, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(float r6, float r7, float r8, ViewingConditions r9) {
        double r0 = r7;
        double r10 = r8;
        double r2 = (Math.expm1(Math.hypot(r0, r10) * 0.02280000038444996d) / 0.02280000038444996d) / ((double) r9.getFlRoot());
        double r11 = Math.atan2(r10, r0) * 57.29577951308232d;
        if (r11 >= 0.0d) goto L6;
        r11 = r11 + 360.0d;
    L6:
        return fromJchInViewingConditions(r6 / (1.0f - ((r6 - 100.0f) * 0.007f)), (float) r2, (float) r11, r9);
    }

    public int getInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions r16) {
        if (getChroma() != 0.0d) goto L5;
    L8:
        float r0 = 0.0f;
    L9:
        float r1 = (float) Math.pow(((double) r0) / Math.pow(1.64d - Math.pow(0.29d, r16.getN()), 0.73d), 1.1111111111111112d);
        double r6 = (getHue() * 3.1415927f) / 180.0f;
        float r2 = ((float) (Math.cos(2.0d + r6) + 3.8d)) * 0.25f;
        float r8 = r16.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) r16.getC())) / ((double) r16.getZ())));
        float r3 = ((r2 * 3846.1538f) * r16.getNc()) * r16.getNcb();
        float r9 = r8 / r16.getNbb();
        float r4 = (float) Math.sin(r6);
        float r5 = (float) Math.cos(r6);
        float r7 = (((0.305f + r9) * 23.0f) * r1) / (((r3 * 23.0f) + ((11.0f * r1) * r5)) + ((r1 * 108.0f) * r4));
        float r10 = r5 * r7;
        float r11 = r7 * r4;
        float r12 = r9 * 460.0f;
        float r13 = (((451.0f * r10) + r12) + (288.0f * r11)) / 1403.0f;
        float r14 = ((r12 - (891.0f * r10)) - (261.0f * r11)) / 1403.0f;
        float r15 = ((r12 - (r10 * 220.0f)) - (r11 * 6300.0f)) / 1403.0f;
        float r17 = (Math.signum(r13) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r13)) * 27.13d) / (400.0d - ((double) Math.abs(r13)))), 2.380952380952381d));
        float r18 = (Math.signum(r14) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r14)) * 27.13d) / (400.0d - ((double) Math.abs(r14)))), 2.380952380952381d));
        float r19 = (Math.signum(r15) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r15)) * 27.13d) / (400.0d - ((double) Math.abs(r15)))), 2.380952380952381d));
        float r20 = r17 / r16.getRgbD()[0];
        float r21 = r18 / r16.getRgbD()[1];
        float r22 = r19 / r16.getRgbD()[2];
        float[][] r23 = CAM16RGB_TO_XYZ;
        float[] r24 = r23[0];
        float r25 = ((r24[0] * r20) + (r24[1] * r21)) + (r24[2] * r22);
        float[] r26 = r23[1];
        float r27 = ((r26[0] * r20) + (r26[1] * r21)) + (r26[2] * r22);
        float[] r28 = r23[2];
        return ColorUtils.intFromXyzComponents(r25, r27, ((r20 * r28[0]) + (r21 * r28[1])) + (r22 * r28[2]));
    L5:
        if (getJ() == 0.0d) goto L8;
        r0 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        goto L9
    }
}
