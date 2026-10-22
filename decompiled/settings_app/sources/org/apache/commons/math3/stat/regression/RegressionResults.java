package org.apache.commons.math3.stat.regression;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class RegressionResults implements Serializable {
    private static final int ADJRSQ_IDX = 4;
    private static final int MSE_IDX = 3;
    private static final int RSQ_IDX = 2;
    private static final int SSE_IDX = 0;
    private static final int SST_IDX = 1;
    private static final long serialVersionUID = 1;
    private final boolean containsConstant;
    private final double[] globalFitInfo;
    private final boolean isSymmetricVCD;
    private final long nobs;
    private final double[] parameters;
    private final int rank;
    private final double[][] varCovData;

    private RegressionResults() {
        this.parameters = null;
        double[][] r1 = (double[][]) null;
        this.varCovData = null;
        this.rank = -1;
        this.nobs = -1;
        this.containsConstant = false;
        this.isSymmetricVCD = false;
        this.globalFitInfo = null;
    }

    public RegressionResults(double[] r15, double[][] r16, boolean r17, long r18, int r20, double r21, double r23, double r25, boolean r27, boolean r28) {
        if (r28 == false) goto L8;
        this.parameters = MathArrays.copyOf(r15);
        this.varCovData = new double[r16.length][];
        int r7 = 0;
    L6:
        if (r7 >= r16.length) goto L9;
        this.varCovData[r7] = MathArrays.copyOf(r16[r7]);
        r7 = r7 + 1;
    L9:
        this.isSymmetricVCD = r17;
        this.nobs = r18;
        this.rank = r20;
        this.containsConstant = r27;
        double[] r1 = new double[5];
        this.globalFitInfo = r1;
        Arrays.fill(r1, Double.NaN);
        if (r20 <= 0) goto L15;
        if (r27 == false) goto L13;
        double r8 = r23 - ((r21 * r21) / r18);
    L14:
        r1[1] = r8;
        goto L15
    L13:
        r8 = r23;
    L15:
        r1[0] = r25;
        double r6 = r18 - ((long) r20);
        r1[3] = r25 / r6;
        double r9 = r1[1];
        double r10 = 1.0d - (r25 / r9);
        r1[2] = r10;
        if (r27 == true) goto L18;
        r1[4] = 1.0d - ((1.0d - r10) * (r18 / r6));
        return;
    L18:
        r1[4] = 1.0d - (((r18 - 1.0d) * r25) / (r9 * r6));
        return;
    L8:
        this.parameters = r15;
        this.varCovData = r16;
        goto L9
    }

    public double getParameterEstimate(int r3) throws OutOfRangeException {
        double[] r0 = this.parameters;
        if (r0 != null) goto L6;
        return Double.NaN;
    L6:
        if (r3 < 0) goto L12;
        if (r3 >= r0.length) goto L12;
        return r0[r3];
    L12:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(this.parameters.length - 1));
    }

    public double[] getParameterEstimates() {
        double[] r0 = this.parameters;
        if (r0 != null) goto L7;
        return null;
    L7:
        return MathArrays.copyOf(r0);
    }

    public double getStdErrorOfEstimate(int r6) throws OutOfRangeException {
        double[] r0 = this.parameters;
        if (r0 != null) goto L5;
        return Double.NaN;
    L5:
        if (r6 < 0) goto L16;
        if (r6 >= r0.length) goto L16;
        double r5 = getVcvElement(r6, r6);
        if (Double.isNaN(r5) == false) goto L11;
    L14:
        return Double.NaN;
    L11:
        if (r5 <= Double.MIN_VALUE) goto L14;
        return FastMath.sqrt(r5);
    L16:
        throw new OutOfRangeException(Integer.valueOf(r6), 0, Integer.valueOf(this.parameters.length - 1));
    }

    public double[] getStdErrorOfEstimates() {
        double[] r0 = this.parameters;
        if (r0 != null) goto L6;
        return null;
    L6:
        double[] r1 = new double[r0.length];
        int r2 = 0;
    L8:
        if (r2 >= this.parameters.length) goto L16;
        double r3 = getVcvElement(r2, r2);
        if (Double.isNaN(r3) == false) goto L12;
    L14:
        r1[r2] = Double.NaN;
    L15:
        r2 = r2 + 1;
        goto L8
    L12:
        if (r3 <= Double.MIN_VALUE) goto L14;
        r1[r2] = FastMath.sqrt(r3);
        goto L15
    L16:
        return r1;
    }

    public double getCovarianceOfParameters(int r4, int r5) throws OutOfRangeException {
        double[] r0 = this.parameters;
        if (r0 != null) goto L7;
        return Double.NaN;
    L7:
        if (r4 < 0) goto L18;
        if (r4 >= r0.length) goto L18;
        if (r5 < 0) goto L16;
        if (r5 >= r0.length) goto L16;
        return getVcvElement(r4, r5);
    L16:
        throw new OutOfRangeException(Integer.valueOf(r5), 0, Integer.valueOf(this.parameters.length - 1));
    L18:
        throw new OutOfRangeException(Integer.valueOf(r4), 0, Integer.valueOf(this.parameters.length - 1));
    }

    public int getNumberOfParameters() {
        double[] r0 = this.parameters;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.length;
    }

    public long getN() {
        return this.nobs;
    }

    public double getTotalSumSquares() {
        return this.globalFitInfo[1];
    }

    public double getRegressionSumSquares() {
        double[] r4 = this.globalFitInfo;
        return r4[1] - r4[0];
    }

    public double getErrorSumSquares() {
        return this.globalFitInfo[0];
    }

    public double getMeanSquareError() {
        return this.globalFitInfo[3];
    }

    public double getRSquared() {
        return this.globalFitInfo[2];
    }

    public double getAdjustedRSquared() {
        return this.globalFitInfo[4];
    }

    public boolean hasIntercept() {
        return this.containsConstant;
    }

    private double getVcvElement(int r3, int r4) {
        if (this.isSymmetricVCD == false) goto L22;
        double[][] r2 = this.varCovData;
        if (r2.length <= 1) goto L16;
        if (r3 == r4) goto L8;
        double[] r0 = r2[r4];
        if (r3 < r0.length) goto L14;
        return r2[r3][r4];
    L14:
        return r0[r3];
    L8:
        return r2[r3][r3];
    L16:
        if (r3 <= r4) goto L20;
        return r2[0][(((r3 + 1) * r3) / 2) + r4];
    L20:
        return r2[0][(((r4 + 1) * r4) / 2) + r3];
    L22:
        return this.varCovData[r3][r4];
    }
}
