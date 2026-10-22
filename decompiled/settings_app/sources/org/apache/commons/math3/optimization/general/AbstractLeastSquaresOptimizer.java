package org.apache.commons.math3.optimization.general;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractLeastSquaresOptimizer extends BaseAbstractMultivariateVectorOptimizer<DifferentiableMultivariateVectorFunction> implements DifferentiableMultivariateVectorOptimizer {

    @Deprecated
    private static final double DEFAULT_SINGULARITY_THRESHOLD = 1.0E-14d;

    @Deprecated
    protected int cols;

    @Deprecated
    protected double cost;
    private MultivariateDifferentiableVectorFunction jF;
    private int jacobianEvaluations;

    @Deprecated
    protected double[] objective;

    @Deprecated
    protected double[] point;

    @Deprecated
    protected int rows;
    private RealMatrix weightMatrixSqrt;

    @Deprecated
    protected double[][] weightedResidualJacobian;

    @Deprecated
    protected double[] weightedResiduals;

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer, org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer
    @Deprecated
    public /* bridge */ /* synthetic */ PointVectorValuePair optimize(int r1, MultivariateVectorFunction r2, double[] r3, double[] r4, double[] r5) {
        return optimize(r1, (DifferentiableMultivariateVectorFunction) r2, r3, r4, r5);
    }

    @Deprecated
    protected AbstractLeastSquaresOptimizer() {
    }

    protected AbstractLeastSquaresOptimizer(ConvergenceChecker<PointVectorValuePair> r1) {
        super(r1);
    }

    public int getJacobianEvaluations() {
        return this.jacobianEvaluations;
    }

    @Deprecated
    protected void updateJacobian() {
        this.weightedResidualJacobian = computeWeightedJacobian(this.point).scalarMultiply(-1.0d).getData();
    }

    protected RealMatrix computeWeightedJacobian(double[] r13) {
        this.jacobianEvaluations++;
        DerivativeStructure[] r0 = new DerivativeStructure[r13.length];
        int r8 = r13.length;
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L5;
        r0[r10] = new DerivativeStructure(r8, 1, r10, r13[r10]);
        r10 = r10 + 1;
        goto L3
    L5:
        DerivativeStructure[] r14 = this.jF.value(r0);
        int r1 = getTarget().length;
        if (r14.length != r1) goto L16;
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r8});
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L14;
        int[] r4 = new int[r8];
        int r5 = 0;
    L10:
        if (r5 >= r8) goto L12;
        r4[r5] = 1;
        r2[r3][r5] = r14[r3].getPartialDerivative(r4);
        r4[r5] = 0;
        r5 = r5 + 1;
        goto L10
    L12:
        r3 = r3 + 1;
        goto L8
    L14:
        return this.weightMatrixSqrt.multiply(MatrixUtils.createRealMatrix(r2));
    L16:
        throw new DimensionMismatchException(r14.length, r1);
    }

    @Deprecated
    protected void updateResidualsAndCost() {
        double[] r0 = computeObjectiveValue(this.point);
        this.objective = r0;
        double[] r1 = computeResiduals(r0);
        this.cost = computeCost(r1);
        ArrayRealVector r2 = new ArrayRealVector(r1);
        this.weightedResiduals = this.weightMatrixSqrt.operate(r2).toArray();
    }

    protected double computeCost(double[] r2) {
        ArrayRealVector r0 = new ArrayRealVector(r2);
        return FastMath.sqrt(r0.dotProduct(getWeight().operate(r0)));
    }

    public double getRMS() {
        return FastMath.sqrt(getChiSquare() / ((double) this.rows));
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

    @Deprecated
    public double[][] getCovariances() {
        return getCovariances(DEFAULT_SINGULARITY_THRESHOLD);
    }

    @Deprecated
    public double[][] getCovariances(double r2) {
        return computeCovariances(this.point, r2);
    }

    public double[][] computeCovariances(double[] r1, double r2) {
        RealMatrix r0 = computeWeightedJacobian(r1);
        return new QRDecomposition(r0.transpose().multiply(r0), r2).getSolver().getInverse().getData();
    }

    @Deprecated
    public double[] guessParametersErrors() {
        int r0 = this.rows;
        int r1 = this.cols;
        int r2 = 0;
        if (r0 <= r1) goto L9;
        double[] r3 = new double[r1];
        double r4 = FastMath.sqrt(getChiSquare() / ((double) (this.rows - this.cols)));
        double[][] r8 = computeCovariances(this.point, DEFAULT_SINGULARITY_THRESHOLD);
    L5:
        if (r2 >= r1) goto L7;
        r3[r2] = FastMath.sqrt(r8[r2][r2]) * r4;
        r2 = r2 + 1;
        goto L5
    L7:
        return r3;
    L9:
        throw new NumberIsTooSmallException(LocalizedFormats.NO_DEGREES_OF_FREEDOM, Integer.valueOf(this.rows), Integer.valueOf(this.cols), false);
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

    @Deprecated
    public PointVectorValuePair optimize(int r3, DifferentiableMultivariateVectorFunction r4, double[] r5, double[] r6, double[] r7) {
        return optimizeInternal(r3, FunctionUtils.toMultivariateDifferentiableVectorFunction(r4), new OptimizationData[]{new Target(r5), new Weight(r6), new InitialGuess(r7)});
    }

    @Deprecated
    public PointVectorValuePair optimize(int r3, MultivariateDifferentiableVectorFunction r4, double[] r5, double[] r6, double[] r7) {
        return optimizeInternal(r3, r4, new OptimizationData[]{new Target(r5), new Weight(r6), new InitialGuess(r7)});
    }

    @Deprecated
    protected PointVectorValuePair optimizeInternal(int r1, MultivariateDifferentiableVectorFunction r2, OptimizationData... r3) {
        return super.optimizeInternal(r1, FunctionUtils.toDifferentiableMultivariateVectorFunction(r2), r3);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer
    protected void setUp() {
        super.setUp();
        this.jacobianEvaluations = 0;
        this.weightMatrixSqrt = squareRoot(getWeight());
        this.jF = FunctionUtils.toMultivariateDifferentiableVectorFunction(getObjectiveFunction());
        this.point = getStartPoint();
        this.rows = getTarget().length;
        this.cols = this.point.length;
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
