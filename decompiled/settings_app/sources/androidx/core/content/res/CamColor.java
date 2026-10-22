package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    float getHue() {
        return this.mHue;
    }

    float getChroma() {
        return this.mChroma;
    }

    float getJ() {
        return this.mJ;
    }

    float getQ() {
        return this.mQ;
    }

    float getM() {
        return this.mM;
    }

    float getS() {
        return this.mS;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    CamColor(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        this.mHue = r1;
        this.mChroma = r2;
        this.mJ = r3;
        this.mQ = r4;
        this.mM = r5;
        this.mS = r6;
        this.mJstar = r7;
        this.mAstar = r8;
        this.mBstar = r9;
    }

    static int toColor(float r1, float r2, float r3) {
        return toColor(r1, r2, r3, ViewingConditions.DEFAULT);
    }

    static CamColor fromColor(int r1) {
        return fromColorInViewingConditions(r1, ViewingConditions.DEFAULT);
    }

    static CamColor fromColorInViewingConditions(int r23, ViewingConditions r24) {
        float[] r0 = CamUtils.xyzFromInt(r23);
        float[][] r1 = CamUtils.XYZ_TO_CAM16RGB;
        float r3 = r0[0];
        float[] r4 = r1[0];
        float r5 = r4[0] * r3;
        float r7 = r0[1];
        float r6 = r5 + (r4[1] * r7);
        float r2 = r0[2];
        float r8 = r6 + (r4[2] * r2);
        float[] r9 = r1[1];
        float r10 = ((r9[0] * r3) + (r9[1] * r7)) + (r9[2] * r2);
        float[] r11 = r1[2];
        float r12 = ((r3 * r11[0]) + (r7 * r11[1])) + (r2 * r11[2]);
        float r13 = r24.getRgbD()[0] * r8;
        float r14 = r24.getRgbD()[1] * r10;
        float r15 = r24.getRgbD()[2] * r12;
        float r16 = (float) Math.pow(((double) (r24.getFl() * Math.abs(r13))) / 100.0d, 0.42d);
        float r17 = (float) Math.pow(((double) (r24.getFl() * Math.abs(r14))) / 100.0d, 0.42d);
        float r18 = (float) Math.pow(((double) (r24.getFl() * Math.abs(r15))) / 100.0d, 0.42d);
        float r19 = ((Math.signum(r13) * 400.0f) * r16) / (r16 + 27.13f);
        float r20 = ((Math.signum(r14) * 400.0f) * r17) / (r17 + 27.13f);
        float r21 = ((Math.signum(r15) * 400.0f) * r18) / (r18 + 27.13f);
        double r22 = r21;
        float r25 = ((float) (((((double) r19) * 11.0d) + (((double) r20) * (-12.0d))) + r22)) / 11.0f;
        float r26 = ((float) (((double) (r19 + r20)) - (r22 * 2.0d))) / 9.0f;
        float r27 = r20 * 20.0f;
        float r28 = (((r19 * 20.0f) + r27) + (21.0f * r21)) / 20.0f;
        float r29 = (((r19 * 40.0f) + r27) + r21) / 20.0f;
        float r30 = (((float) Math.atan2(r26, r25)) * 180.0f) / 3.1415927f;
        if (r30 >= 0.0f) goto L7;
        r30 = r30 + 360.0f;
    L5:
        float r110 = r30;
        float r31 = (3.1415927f * r110) / 180.0f;
        float r32 = ((float) Math.pow((r29 * r24.getNbb()) / r24.getAw(), r24.getC() * r24.getZ())) * 100.0f;
        float r33 = r24.getFlRoot() * (((4.0f / r24.getC()) * ((float) Math.sqrt(r32 / 100.0f))) * (r24.getAw() + 4.0f));
        if (r110 >= 20.14d) goto L12;
        float r111 = 360.0f + r110;
    L13:
        float r34 = ((float) Math.pow(1.64d - Math.pow(0.29d, r24.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) r111) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r24.getNc()) * r24.getNcb()) * ((float) Math.sqrt((r25 * r25) + (r26 * r26)))) / (r28 + 0.305f), 0.9d));
        float r112 = r34 * ((float) Math.sqrt(((double) r32) / 100.0d));
        float r113 = r112 * r24.getFlRoot();
        float r114 = ((float) Math.sqrt((r34 * r24.getC()) / (r24.getAw() + 4.0f))) * 50.0f;
        float r210 = (1.7f * r32) / ((0.007f * r32) + 1.0f);
        float r35 = ((float) Math.log((0.0228f * r113) + 1.0f)) * 43.85965f;
        double r36 = r31;
        return new CamColor(r110, r112, r32, r33, r113, r114, r210, r35 * ((float) Math.cos(r36)), r35 * ((float) Math.sin(r36)));
    L12:
        r111 = r110;
        goto L13
    L7:
        if (r30 < 360.0f) goto L5;
        r30 = r30 - 360.0f;
        goto L5
    }

    private static CamColor fromJch(float r1, float r2, float r3) {
        return fromJchInFrame(r1, r2, r3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float r13, float r14, float r15, ViewingConditions r16) {
        double r4 = ((double) r13) / 100.0d;
        float r6 = (((4.0f / r16.getC()) * ((float) Math.sqrt(r4))) * (r16.getAw() + 4.0f)) * r16.getFlRoot();
        float r7 = r14 * r16.getFlRoot();
        float r8 = ((float) Math.sqrt(((r14 / ((float) Math.sqrt(r4))) * r16.getC()) / (r16.getAw() + 4.0f))) * 50.0f;
        float r9 = (1.7f * r13) / ((0.007f * r13) + 1.0f);
        float r1 = ((float) Math.log((((double) r7) * 0.0228d) + 1.0d)) * 43.85965f;
        double r5 = (3.1415927f * r15) / 180.0f;
        return new CamColor(r15, r14, r13, r6, r7, r8, r9, r1 * ((float) Math.cos(r5)), r1 * ((float) Math.sin(r5)));
    }

    float distance(CamColor r4) {
        float r0 = getJStar() - r4.getJStar();
        float r1 = getAStar() - r4.getAStar();
        float r3 = getBStar() - r4.getBStar();
        return (float) (Math.pow(Math.sqrt(((r0 * r0) + (r1 * r1)) + (r3 * r3)), 0.63d) * 1.41d);
    }

    int viewedInSrgb() {
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
        float[][] r23 = CamUtils.CAM16RGB_TO_XYZ;
        float[] r24 = r23[0];
        float r25 = ((r24[0] * r20) + (r24[1] * r21)) + (r24[2] * r22);
        float[] r26 = r23[1];
        float r27 = ((r26[0] * r20) + (r26[1] * r21)) + (r26[2] * r22);
        float[] r28 = r23[2];
        return ColorUtils.XYZToColor(r25, r27, ((r20 * r28[0]) + (r21 * r28[1])) + (r22 * r28[2]));
    L5:
        if (getJ() == 0.0d) goto L8;
        r0 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        goto L9
    }

    static int toColor(float r6, float r7, float r8, ViewingConditions r9) {
        if (r7 < 1.0d) goto L32;
        if (Math.round(r8) <= 0.0d) goto L32;
        if (Math.round(r8) >= 100.0d) goto L32;
        if (r6 >= 0.0f) goto L12;
        float r10 = 0.0f;
    L13:
        CamColor r3 = null;
        boolean r2 = true;
        float r1 = 0.0f;
        float r0 = r7;
    L15:
        if (Math.abs(r1 - r7) < 0.4f) goto L26;
        CamColor r4 = findCamByJ(r10, r0, r8);
        if (r2 == true) goto L18;
        if (r4 != null) goto L24;
        r7 = r0;
    L25:
        r0 = ((r7 - r1) / 2.0f) + r1;
        goto L15
    L24:
        r1 = r0;
        r3 = r4;
        goto L25
    L18:
        if (r4 != null) goto L20;
        r0 = ((r7 - r1) / 2.0f) + r1;
        r2 = false;
        goto L15
    L20:
        return r4.viewed(r9);
    L26:
        if (r3 != null) goto L30;
        return CamUtils.intFromLStar(r8);
    L30:
        return r3.viewed(r9);
    L12:
        r10 = Math.min(360.0f, r6);
    L32:
        return CamUtils.intFromLStar(r8);
    }

    private static CamColor findCamByJ(float r12, float r13, float r14) {
        float r1 = 100.0f;
        float r2 = 1000.0f;
        float r5 = 0.0f;
        CamColor r4 = null;
        float r3 = 1000.0f;
    L4:
        if (Math.abs(r5 - r1) <= 0.01f) goto L19;
        float r6 = ((r1 - r5) / 2.0f) + r5;
        int r7 = fromJch(r6, r13, r12).viewedInSrgb();
        float r8 = CamUtils.lStarFromInt(r7);
        float r9 = Math.abs(r14 - r8);
        if (r9 >= 0.2f) goto L11;
        CamColor r10 = fromColor(r7);
        float r11 = r10.distance(fromJch(r10.getJ(), r10.getChroma(), r12));
        if (r11 > 1.0f) goto L11;
        r4 = r10;
        r2 = r9;
        r3 = r11;
    L11:
        if (r2 != 0.0f) goto L16;
        if (r3 == 0.0f) goto L19;
    L16:
        if (r8 < r14) goto L17;
        r1 = r6;
        goto L4
    L17:
        r5 = r6;
    L19:
        return r4;
    }
}
