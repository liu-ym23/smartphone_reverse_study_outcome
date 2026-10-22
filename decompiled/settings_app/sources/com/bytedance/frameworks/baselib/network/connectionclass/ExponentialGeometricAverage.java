package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes3.dex */
class ExponentialGeometricAverage {
    private int mCount;
    private final int mCutover;
    private final double mDecayConstant;
    private double mValue;

    public ExponentialGeometricAverage(double r3) {
        this.mValue = -1.0d;
        this.mDecayConstant = r3;
        if (r3 != 0.0d) goto L5;
        int r4 = Integer.MAX_VALUE;
    L6:
        this.mCutover = r4;
        return;
    L5:
        r4 = (int) Math.ceil(1.0d / r3);
        goto L6
    }

    public void addMeasurement(double r8) {
        double r0 = 1.0d - this.mDecayConstant;
        int r4 = this.mCount;
        if (r4 <= this.mCutover) goto L5;
        this.mValue = Math.exp((r0 * Math.log(this.mValue)) + (this.mDecayConstant * Math.log(r8)));
    L8:
        this.mCount++;
        return;
    L5:
        if (r4 <= 0) goto L7;
        double r1 = (r0 * ((double) r4)) / (((double) r4) + 1.0d);
        this.mValue = Math.exp((r1 * Math.log(this.mValue)) + ((1.0d - r1) * Math.log(r8)));
        goto L8
    L7:
        this.mValue = r8;
        goto L8
    }

    public double getAverage() {
        return this.mValue;
    }

    public void reset() {
        this.mValue = -1.0d;
        this.mCount = 0;
    }
}
