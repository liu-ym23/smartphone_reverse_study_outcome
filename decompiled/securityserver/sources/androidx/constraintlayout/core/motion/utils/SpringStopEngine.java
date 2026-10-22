package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
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

    public SpringStopEngine() {
        this.mDamping = 0.5d;
        this.mInitialized = false;
        this.mBoundaryMode = 0;
    }

    private void compute(double r25) {
        double r1 = this.mStiffness;
        double r3 = this.mDamping;
        int r5 = (int) ((9.0d / ((Math.sqrt(r1 / ((double) this.mMass)) * r25) * 4.0d)) + 1.0d);
        double r6 = r25 / ((double) r5);
        int r8 = 0;
    L3:
        if (r8 >= r5) goto L17;
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
        double r110 = (r19 * r6) / 2.0d;
        double r111 = r110 + ((double) r10);
        double r22 = (r6 * r111) / 2.0d;
        double r4 = ((((-((r22 + ((double) r9)) - r12)) * r16) - (r111 * r18)) / ((double) r2)) * r6;
        double r13 = r4 / 2.0d;
        double r112 = r13 + ((double) r10);
        float r7 = (float) (((double) r10) + r4);
        this.mV = r7;
        double r113 = r112 * r6;
        float r11 = (float) (r113 + ((double) r9));
        this.mPos = r11;
        int r20 = this.mBoundaryMode;
        if (r20 <= 0) goto L16;
        if (r11 < 0.0f) goto L9;
    L11:
        float r21 = this.mPos;
        if (r21 <= 1.0f) goto L16;
        if ((r20 & 2) != 2) goto L16;
        this.mPos = 2.0f - r21;
        this.mV = -this.mV;
        goto L16
    L9:
        if ((r20 & 1) != 1) goto L11;
        this.mPos = -r11;
        this.mV = -r7;
    L16:
        r8 = r8 + 1;
        r1 = r16;
        r3 = r18;
        goto L3
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r1, float r2) {
        return null;
    }

    public float getAcceleration() {
        double r0 = this.mStiffness;
        double r2 = this.mDamping;
        double r1 = -r0;
        return ((float) ((r1 * (((double) this.mPos) - this.mTargetPos)) - (r2 * ((double) this.mV)))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r3) {
        compute(r3 - this.mLastTime);
        this.mLastTime = r3;
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double r0 = ((double) this.mPos) - this.mTargetPos;
        double r2 = this.mStiffness;
        double r4 = this.mV;
        if (Math.sqrt((((r2 * r0) * r0) + ((r4 * r4) * ((double) this.mMass))) / r2) > this.mStopThreshold) goto L5;
        return true;
    L5:
        return false;
    }

    public void log(String r3) {
        StackTraceElement r2 = new Throwable().getStackTrace()[1];
        String r4 = ".(" + r2.getFileName() + ":" + r2.getLineNumber() + ") " + r2.getMethodName() + "() ";
        System.out.println(r4 + r3);
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

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r1) {
        return this.mV;
    }
}
