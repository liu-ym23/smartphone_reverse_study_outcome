package org.apache.commons.math3.stat.regression;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMultipleLinearRegression implements MultipleLinearRegression {
    private boolean noIntercept;
    private RealMatrix xMatrix;
    private RealVector yVector;

    protected abstract RealVector calculateBeta();

    protected abstract RealMatrix calculateBetaVariance();

    public AbstractMultipleLinearRegression() {
        this.noIntercept = false;
    }

    protected RealMatrix getX() {
        return this.xMatrix;
    }

    protected RealVector getY() {
        return this.yVector;
    }

    public boolean isNoIntercept() {
        return this.noIntercept;
    }

    public void setNoIntercept(boolean r1) {
        this.noIntercept = r1;
    }

    public void newSampleData(double[] r11, int r12, int r13) {
        if (r11 == null) goto L27;
        int r1 = r13 + 1;
        int r2 = r12 * r1;
        if (r11.length != r2) goto L25;
        if (r12 <= r13) goto L23;
        double[] r4 = new double[r12];
        if (this.noIntercept == true) goto L11;
        r13 = r1;
    L11:
        double[][] r0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r12, r13});
        int r3 = 0;
        int r5 = 0;
    L12:
        if (r3 >= r12) goto L20;
        int r6 = r5 + 1;
        r4[r3] = r11[r5];
        boolean r7 = this.noIntercept;
        if (r7 == true) goto L16;
        r0[r3][0] = 1.0d;
    L16:
        int r8 = !r7 ? 1 : 0;
    L17:
        if (r8 >= r13) goto L19;
        r0[r3][r8] = r11[r6];
        r8 = r8 + 1;
        r6 = r6 + 1;
        goto L17
    L19:
        r3 = r3 + 1;
        r5 = r6;
        goto L12
    L20:
        this.xMatrix = new Array2DRowRealMatrix(r0);
        this.yVector = new ArrayRealVector(r4);
        return;
    L23:
        throw new InsufficientDataException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, new Object[]{Integer.valueOf(r12), Integer.valueOf(r1)});
    L25:
        throw new DimensionMismatchException(r11.length, r2);
    L27:
        throw new NullArgumentException();
    }

    protected void newYSampleData(double[] r2) {
        if (r2 == null) goto L10;
        if (r2.length == 0) goto L8;
        this.yVector = new ArrayRealVector(r2);
        return;
    L8:
        throw new NoDataException();
    L10:
        throw new NullArgumentException();
    }

    protected void newXSampleData(double[][] r10) {
        if (r10 == null) goto L21;
        if (r10.length == 0) goto L19;
        if (this.noIntercept == false) goto L8;
        this.xMatrix = new Array2DRowRealMatrix(r10, true);
        return;
    L8:
        int r2 = r10[0].length;
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10.length, r2 + 1});
        int r4 = 0;
    L10:
        if (r4 >= r10.length) goto L16;
        double[] r5 = r10[r4];
        if (r5.length != r2) goto L15;
        double[] r6 = r3[r4];
        r6[0] = 1.0d;
        System.arraycopy(r5, 0, r6, 1, r2);
        r4 = r4 + 1;
        goto L10
    L15:
        throw new DimensionMismatchException(r10[r4].length, r2);
    L16:
        this.xMatrix = new Array2DRowRealMatrix(r3, false);
        return;
    L19:
        throw new NoDataException();
    L21:
        throw new NullArgumentException();
    }

    protected void validateSampleData(double[][] r5, double[] r6) throws MathIllegalArgumentException {
        if (r5 == null) goto L18;
        if (r6 == null) goto L18;
        if (r5.length != r6.length) goto L16;
        if (r5.length == 0) goto L14;
        if ((r5[0].length + 1) > r5.length) goto L12;
        return;
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[]{Integer.valueOf(r5.length), Integer.valueOf(r5[0].length)});
    L14:
        throw new NoDataException();
    L16:
        throw new DimensionMismatchException(r6.length, r5.length);
    L18:
        throw new NullArgumentException();
    }

    protected void validateCovarianceData(double[][] r2, double[][] r3) {
        if (r2.length != r3.length) goto L13;
        if (r3.length > 0) goto L7;
        return;
    L7:
        if (r3.length != r3[0].length) goto L10;
        return;
    L10:
        throw new NonSquareMatrixException(r3.length, r3[0].length);
    L13:
        throw new DimensionMismatchException(r2.length, r3.length);
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[] estimateRegressionParameters() {
        return calculateBeta().toArray();
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[] estimateResiduals() {
        RealVector r0 = calculateBeta();
        return this.yVector.subtract(this.xMatrix.operate(r0)).toArray();
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[][] estimateRegressionParametersVariance() {
        return calculateBetaVariance().getData();
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[] estimateRegressionParametersStandardErrors() {
        double[][] r0 = estimateRegressionParametersVariance();
        double r1 = calculateErrorVariance();
        int r7 = 0;
        int r3 = r0[0].length;
        double[] r4 = new double[r3];
    L3:
        if (r7 >= r3) goto L5;
        r4[r7] = FastMath.sqrt(r0[r7][r7] * r1);
        r7 = r7 + 1;
        goto L3
    L5:
        return r4;
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double estimateRegressandVariance() {
        return calculateYVariance();
    }

    public double estimateErrorVariance() {
        return calculateErrorVariance();
    }

    public double estimateRegressionStandardError() {
        return FastMath.sqrt(estimateErrorVariance());
    }

    protected double calculateYVariance() {
        return new Variance().evaluate(this.yVector.toArray());
    }

    protected double calculateErrorVariance() {
        RealVector r0 = calculateResiduals();
        return r0.dotProduct(r0) / ((double) (this.xMatrix.getRowDimension() - this.xMatrix.getColumnDimension()));
    }

    protected RealVector calculateResiduals() {
        RealVector r0 = calculateBeta();
        return this.yVector.subtract(this.xMatrix.operate(r0));
    }
}
