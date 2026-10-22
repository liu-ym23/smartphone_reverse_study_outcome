package org.apache.commons.math3.stat.regression;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
public class GLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private RealMatrix Omega;
    private RealMatrix OmegaInverse;

    public GLSMultipleLinearRegression() {
    }

    public void newSampleData(double[] r1, double[][] r2, double[][] r3) {
        validateSampleData(r2, r1);
        newYSampleData(r1);
        newXSampleData(r2);
        validateCovarianceData(r2, r3);
        newCovarianceData(r3);
    }

    protected void newCovarianceData(double[][] r2) {
        this.Omega = new Array2DRowRealMatrix(r2);
        this.OmegaInverse = null;
    }

    protected RealMatrix getOmegaInverse() {
        if (this.OmegaInverse != null) goto L6;
        this.OmegaInverse = new LUDecomposition(this.Omega).getSolver().getInverse();
    L6:
        return this.OmegaInverse;
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    protected RealVector calculateBeta() {
        RealMatrix r0 = getOmegaInverse();
        RealMatrix r1 = getX().transpose();
        return new LUDecomposition(r1.multiply(r0).multiply(getX())).getSolver().getInverse().multiply(r1).multiply(r0).operate(getY());
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    protected RealMatrix calculateBetaVariance() {
        RealMatrix r0 = getOmegaInverse();
        return new LUDecomposition(getX().transpose().multiply(r0).multiply(getX())).getSolver().getInverse();
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    protected double calculateErrorVariance() {
        RealVector r0 = calculateResiduals();
        return r0.dotProduct(getOmegaInverse().operate(r0)) / ((double) (getX().getRowDimension() - getX().getColumnDimension()));
    }
}
