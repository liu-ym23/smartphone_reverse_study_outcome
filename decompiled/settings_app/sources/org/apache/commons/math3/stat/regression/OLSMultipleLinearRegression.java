package org.apache.commons.math3.stat.regression;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;

/* JADX INFO: loaded from: classes6.dex */
public class OLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private QRDecomposition qr;
    private final double threshold;

    public OLSMultipleLinearRegression() {
        this(0.0d);
    }

    public OLSMultipleLinearRegression(double r2) {
        this.qr = null;
        this.threshold = r2;
    }

    public void newSampleData(double[] r1, double[][] r2) throws MathIllegalArgumentException {
        validateSampleData(r2, r1);
        newYSampleData(r1);
        newXSampleData(r2);
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public void newSampleData(double[] r3, int r4, int r5) {
        super.newSampleData(r3, r4, r5);
        this.qr = new QRDecomposition(getX(), this.threshold);
    }

    public RealMatrix calculateHat() {
        RealMatrix r0 = this.qr.getQ();
        int r10 = this.qr.getR().getColumnDimension();
        int r1 = r0.getColumnDimension();
        Array2DRowRealMatrix r2 = new Array2DRowRealMatrix(r1, r1);
        double[][] r3 = r2.getDataRef();
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L13;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L11;
        if (r5 != r6) goto L9;
        if (r5 >= r10) goto L9;
        r3[r5][r6] = 1.0d;
    L10:
        r6 = r6 + 1;
    L9:
        r3[r5][r6] = 0.0d;
        goto L10
    L11:
        r5 = r5 + 1;
        goto L3
    L13:
        return r0.multiply(r2).multiply(r0.transpose());
    }

    public double calculateTotalSumOfSquares() {
        if (isNoIntercept() == false) goto L7;
        return StatUtils.sumSq(getY().toArray());
    L7:
        return new SecondMoment().evaluate(getY().toArray());
    }

    public double calculateResidualSumOfSquares() {
        RealVector r2 = calculateResiduals();
        return r2.dotProduct(r2);
    }

    public double calculateRSquared() {
        return 1.0d - (calculateResidualSumOfSquares() / calculateTotalSumOfSquares());
    }

    public double calculateAdjustedRSquared() {
        double r0 = getX().getRowDimension();
        if (isNoIntercept() == false) goto L7;
        double r5 = (1.0d - calculateRSquared()) * (r0 / (r0 - ((double) getX().getColumnDimension())));
    L6:
        return 1.0d - r5;
    L7:
        r5 = (calculateResidualSumOfSquares() * (r0 - 1.0d)) / (calculateTotalSumOfSquares() * (r0 - ((double) getX().getColumnDimension())));
        goto L6
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    protected void newXSampleData(double[][] r4) {
        super.newXSampleData(r4);
        this.qr = new QRDecomposition(getX(), this.threshold);
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    protected RealVector calculateBeta() {
        return this.qr.getSolver().solve(getY());
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    protected RealMatrix calculateBetaVariance() {
        int r0 = getX().getColumnDimension() - 1;
        RealMatrix r2 = new LUDecomposition(this.qr.getR().getSubMatrix(0, r0, 0, r0)).getSolver().getInverse();
        return r2.multiply(r2.transpose());
    }
}
