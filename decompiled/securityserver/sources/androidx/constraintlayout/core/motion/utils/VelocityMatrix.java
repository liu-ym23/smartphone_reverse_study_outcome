package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public VelocityMatrix() {
    }

    public void applyTransform(float r16, float r17, int r18, int r19, float[] r20) {
        float r3 = r20[0];
        float r5 = r20[1];
        float r7 = (r16 - 0.5f) * 2.0f;
        float r6 = (r17 - 0.5f) * 2.0f;
        float r4 = r3 + this.mDTranslateX;
        float r8 = r5 + this.mDTranslateY;
        float r9 = (this.mDScaleX * r7) + r4;
        float r10 = (this.mDScaleY * r6) + r8;
        float r11 = (float) Math.toRadians(this.mRotate);
        float r0 = (float) Math.toRadians(this.mDRotate);
        double r12 = r11;
        double r13 = r19 * r6;
        float r14 = (((float) ((Math.sin(r12) * ((double) ((-r18) * r7))) - (Math.cos(r12) * r13))) * r0) + r9;
        float r1 = (r0 * ((float) ((Math.cos(r12) * ((double) (r18 * r7))) - (Math.sin(r12) * r13)))) + r10;
        r20[0] = r14;
        r20[1] = r1;
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

    public void setScaleVelocity(SplineSet r1, SplineSet r2, float r3) {
        if (r1 == null) goto L4;
        this.mDScaleX = r1.getSlope(r3);
    L4:
        if (r2 == null) goto L7;
        this.mDScaleY = r2.getSlope(r3);
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

    public void setRotationVelocity(KeyCycleOscillator r1, float r2) {
        if (r1 == null) goto L5;
        this.mDRotate = r1.getSlope(r2);
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

    public void setTranslationVelocity(KeyCycleOscillator r1, KeyCycleOscillator r2, float r3) {
        if (r1 == null) goto L4;
        this.mDTranslateX = r1.getSlope(r3);
    L4:
        if (r2 == null) goto L7;
        this.mDTranslateY = r2.getSlope(r3);
        return;
    }
}
