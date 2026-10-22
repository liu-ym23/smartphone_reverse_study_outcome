package com.obric.oui.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes4.dex */
public class VelocityMatrix {
    private static String sTag = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    static {
    }

    public VelocityMatrix() {
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet r2, float r3) {
        if (r2 == null) goto L5;
        this.mDRotate = r2.getSlope(r3);
        this.mRotate = r2.get(r3);
        return;
    }

    public void setTranslationVelocity(SplineSet r1, SplineSet r2, float r3) {
        if (r1 == null) goto L4;
        this.mDTranslateX = r1.getSlope(r3);
    L4:
        if (r2 == null) goto L7;
        this.mDTranslateY = r2.getSlope(r3);
        return;
    }

    public void setScaleVelocity(SplineSet r1, SplineSet r2, float r3) {
        if (r1 == null) goto L4;
        this.mDScaleX = r1.getSlope(r3);
    L4:
        if (r2 == null) goto L7;
        this.mDScaleY = r2.getSlope(r3);
        return;
    }

    public void setRotationVelocity(KeyCycleOscillator r1, float r2) {
        if (r1 == null) goto L5;
        this.mDRotate = r1.getSlope(r2);
        return;
    }

    public void setTranslationVelocity(KeyCycleOscillator r1, KeyCycleOscillator r2, float r3) {
        if (r1 == null) goto L4;
        this.mDTranslateX = r1.getSlope(r3);
    L4:
        if (r2 == null) goto L7;
        this.mDTranslateY = r2.getSlope(r3);
        return;
    }

    public void setScaleVelocity(KeyCycleOscillator r1, KeyCycleOscillator r2, float r3) {
        if (r1 == null) goto L4;
        this.mDScaleX = r1.getSlope(r3);
    L4:
        if (r2 == null) goto L7;
        this.mDScaleY = r2.getSlope(r3);
        return;
    }

    public void applyTransform(float r18, float r19, int r20, int r21, float[] r22) {
        float r3 = r22[0];
        float r5 = r22[1];
        float r7 = (r18 - 0.5f) * 2.0f;
        float r6 = (r19 - 0.5f) * 2.0f;
        float r4 = r3 + this.mDTranslateX;
        float r8 = r5 + this.mDTranslateY;
        float r9 = r4 + (this.mDScaleX * r7);
        float r10 = r8 + (this.mDScaleY * r6);
        float r11 = (float) Math.toRadians(this.mRotate);
        float r0 = (float) Math.toRadians(this.mDRotate);
        double r12 = r11;
        double r13 = r21 * r6;
        float r14 = r9 + (((float) ((((double) ((-r20) * r7)) * Math.sin(r12)) - (Math.cos(r12) * r13))) * r0);
        float r15 = r10 + (r0 * ((float) ((((double) (r20 * r7)) * Math.cos(r12)) - (r13 * Math.sin(r12)))));
        r22[0] = r14;
        r22[1] = r15;
    }
}
