package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.optim.nonlinear.vector.JacobianMultivariateVectorOptimizer;
import org.apache.commons.math3.optim.nonlinear.vector.Weight;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractLeastSquaresOptimizer extends JacobianMultivariateVectorOptimizer {
    private double cost;
    private RealMatrix weightMatrixSqrt;

    @Override // org.apache.commons.math3.optim.nonlinear.vector.JacobianMultivariateVectorOptimizer, org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    protected AbstractLeastSquaresOptimizer(ConvergenceChecker<PointVectorValuePair> r1) {
        super(r1);
    }

    protected RealMatrix computeWeightedJacobian(double[] r2) {
        return this.weightMatrixSqrt.multiply(MatrixUtils.createRealMatrix(computeJacobian(r2)));
    }

    protected double computeCost(double[] r2) {
        ArrayRealVector r0 = new ArrayRealVector(r2);
        return FastMath.sqrt(r0.dotProduct(getWeight().operate(r0)));
    }

    public double getRMS() {
        return FastMath.sqrt(getChiSquare() / ((double) getTargetSize()));
    }

    public double getChiSquare() {
        double r0 = this.cost;
        return r0 * r0;
    }

    public RealMatrix getWeightSquareRoot() {
        return this.weightMatrixSqrt.copy();
    }

    protected void setCost(double r1) {
        this.cost = r1;
    }

    public double[][] computeCovariances(double[] r1, double r2) {
        RealMatrix r0 = computeWeightedJacobian(r1);
        return new QRDecomposition(r0.transpose().multiply(r0), r2).getSolver().getInverse().getData();
    }

    public double[] computeSigma(double[] r3, double r4) {
        int r0 = r3.length;
        double[] r1 = new double[r0];
        double[][] r2 = computeCovariances(r3, r4);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L5;
        r1[r5] = FastMath.sqrt(r2[r5][r5]);
        r5 = r5 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.optim.nonlinear.vector.JacobianMultivariateVectorOptimizer, org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointVectorValuePair optimize(OptimizationData... r1) throws TooManyEvaluationsException {
        return super.optimize(r1);
    }

    protected double[] computeResiduals(double[] r7) {
        double[] r6 = getTarget();
        if (r7.length != r6.length) goto L10;
        double[] r0 = new double[r6.length];
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L8;
        r0[r1] = r6[r1] - r7[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        throw new DimensionMismatchException(r6.length, r7.length);
    }

    @Override // org.apache.commons.math3.optim.nonlinear.vector.JacobianMultivariateVectorOptimizer, org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof Weight) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        this.weightMatrixSqrt = squareRoot(((Weight) r2).getWeight());
        return;
    }

    private RealMatrix squareRoot(RealMatrix r5) {
        if ((r5 instanceof DiagonalMatrix) == false) goto L9;
        int r4 = r5.getRowDimension();
        DiagonalMatrix r0 = new DiagonalMatrix(r4);
        int r1 = 0;
    L5:
        if (r1 >= r4) goto L7;
        r0.setEntry(r1, r1, FastMath.sqrt(r5.getEntry(r1, r1)));
        r1 = r1 + 1;
        goto L5
    L7:
        return r0;
    L9:
        return new EigenDecomposition(r5).getSquareRoot();
    }
}
