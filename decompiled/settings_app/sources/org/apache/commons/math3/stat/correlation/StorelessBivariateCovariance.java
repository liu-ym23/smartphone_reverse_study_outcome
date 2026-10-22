package org.apache.commons.math3.stat.correlation;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
class StorelessBivariateCovariance {
    private boolean biasCorrected;
    private double covarianceNumerator;
    private double meanX;
    private double meanY;
    private double n;

    StorelessBivariateCovariance() {
        this(true);
    }

    StorelessBivariateCovariance(boolean r3) {
        this.meanY = 0.0d;
        this.meanX = 0.0d;
        this.n = 0.0d;
        this.covarianceNumerator = 0.0d;
        this.biasCorrected = r3;
    }

    public void increment(double r11, double r13) {
        double r0 = this.n + 1.0d;
        this.n = r0;
        double r4 = this.meanX;
        double r12 = r11 - r4;
        double r6 = this.meanY;
        double r14 = r13 - r6;
        this.meanX = r4 + (r12 / r0);
        this.meanY = r6 + (r14 / r0);
        this.covarianceNumerator += (((r0 - 1.0d) / r0) * r12) * r14;
    }

    public void append(StorelessBivariateCovariance r19) {
        double r2 = this.n;
        double r4 = r19.n + r2;
        this.n = r4;
        double r6 = r19.meanX;
        double r8 = this.meanX;
        double r7 = r6 - r8;
        double r10 = r19.meanY;
        double r12 = this.meanY;
        double r11 = r10 - r12;
        double r14 = r19.n;
        this.meanX = r8 + ((r7 * r14) / r4);
        this.meanY = r12 + ((r11 * r14) / r4);
        this.covarianceNumerator += r19.covarianceNumerator + ((((r2 * r14) / r4) * r7) * r11);
    }

    public double getN() {
        return this.n;
    }

    public double getResult() throws NumberIsTooSmallException {
        double r0 = this.n;
        if (r0 < 2.0d) goto L11;
        if (this.biasCorrected == false) goto L9;
        double r2 = this.covarianceNumerator;
        r0 = r0 - 1.0d;
    L8:
        return r2 / r0;
    L9:
        r2 = this.covarianceNumerator;
        goto L8
    L11:
        throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_DIMENSION, Double.valueOf(this.n), 2, true);
    }
}
