package com.obric.oui.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes4.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private int mBoundaryMode;
    double mDamping;
    private boolean mInitialized;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r1, float r2) {
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    public SpringStopEngine() {
        this.mDamping = 0.5d;
        this.mInitialized = false;
        this.mBoundaryMode = 0;
    }

    void log(String r3) {
        StackTraceElement r2 = new Throwable().getStackTrace()[1];
        System.out.println((".(" + r2.getFileName() + ":" + r2.getLineNumber() + ") " + r2.getMethodName() + "() ") + r3);
    }

    public void springConfig(float r3, float r4, float r5, float r6, float r7, float r8, float r9, int r10) {
        this.mTargetPos = r4;
        this.mDamping = r8;
        this.mInitialized = false;
        this.mPos = r3;
        this.mLastVelocity = r5;
        this.mStiffness = r7;
        this.mMass = r6;
        this.mStopThreshold = r9;
        this.mBoundaryMode = r10;
        this.mLastTime = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r1) {
        return this.mV;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r3) {
        compute(r3 - this.mLastTime);
        this.mLastTime = r3;
        if (isStopped() == false) goto L6;
        this.mPos = (float) this.mTargetPos;
    L6:
        return this.mPos;
    }

    public float getAcceleration() {
        double r0 = this.mStiffness;
        double r2 = this.mDamping;
        double r1 = -r0;
        return ((float) ((r1 * (((double) this.mPos) - this.mTargetPos)) - (r2 * ((double) this.mV)))) / this.mMass;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double r0 = ((double) this.mPos) - this.mTargetPos;
        double r2 = this.mStiffness;
        double r4 = this.mV;
        if (Math.sqrt((((r4 * r4) * ((double) this.mMass)) + ((r2 * r0) * r0)) / r2) > this.mStopThreshold) goto L5;
        return true;
    L5:
        return false;
    }

    private void compute(double r25) {
        if (r25 > 0.0d) goto L5;
        return;
    L5:
        double r1 = this.mStiffness;
        double r3 = this.mDamping;
        int r5 = (int) ((9.0d / ((Math.sqrt(r1 / ((double) this.mMass)) * r25) * 4.0d)) + 1.0d);
        double r6 = r25 / ((double) r5);
        int r8 = 0;
    L6:
        if (r8 >= r5) goto L20;
        float r9 = this.mPos;
        double r12 = this.mTargetPos;
        double r14 = -r1;
        double r15 = r14 * (((double) r9) - r12);
        float r10 = this.mV;
        double r16 = r1;
        double r17 = r15 - (((double) r10) * r3);
        float r2 = this.mMass;
        double r18 = r3;
        double r19 = r17 / ((double) r2);
        double r4 = ((double) r10) + ((r19 * r6) / 2.0d);
        double r11 = ((((-((((double) r9) + ((r6 * r4) / 2.0d)) - r12)) * r16) - (r4 * r18)) / ((double) r2)) * r6;
        double r7 = ((double) r10) + (r11 / 2.0d);
        float r13 = r10 + ((float) r11);
        this.mV = r13;
        float r20 = r9 + ((float) (r7 * r6));
        this.mPos = r20;
        int r21 = this.mBoundaryMode;
        if (r21 <= 0) goto L19;
        if (r20 < 0.0f) goto L12;
    L14:
        float r22 = this.mPos;
        if (r22 <= 1.0f) goto L19;
        if ((r21 & 2) != 2) goto L19;
        this.mPos = 2.0f - r22;
        this.mV = -this.mV;
        goto L19
    L12:
        if ((r21 & 1) != 1) goto L14;
        this.mPos = -r20;
        this.mV = -r13;
    L19:
        r8 = r8 + 1;
        r1 = r16;
        r3 = r18;
        goto L6
    }
}
