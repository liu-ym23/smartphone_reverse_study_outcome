package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.SimpleVectorValueChecker;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class BaseAbstractMultivariateVectorOptimizer<FUNC extends MultivariateVectorFunction> implements BaseMultivariateVectorOptimizer<FUNC> {
    private ConvergenceChecker<PointVectorValuePair> checker;
    protected final Incrementor evaluations;
    private FUNC function;
    private double[] start;
    private double[] target;

    @Deprecated
    private double[] weight;
    private RealMatrix weightMatrix;

    protected abstract PointVectorValuePair doOptimize();

    @Deprecated
    protected BaseAbstractMultivariateVectorOptimizer() {
        this(new SimpleVectorValueChecker());
    }

    protected BaseAbstractMultivariateVectorOptimizer(ConvergenceChecker<PointVectorValuePair> r2) {
        this.evaluations = new Incrementor();
        this.checker = r2;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<PointVectorValuePair> getConvergenceChecker() {
        return this.checker;
    }

    protected double[] computeObjectiveValue(double[] r2) {
        this.evaluations.incrementCount();     // Catch: MaxCountExceededException -> L5
        return this.function.value(r2);
    L5:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer
    @Deprecated
    public PointVectorValuePair optimize(int r1, FUNC r2, double[] r3, double[] r4, double[] r5) {
        return optimizeInternal(r1, r2, r3, r4, r5);
    }

    protected PointVectorValuePair optimize(int r1, FUNC r2, OptimizationData... r3) throws TooManyEvaluationsException, DimensionMismatchException {
        return optimizeInternal(r1, r2, r3);
    }

    @Deprecated
    protected PointVectorValuePair optimizeInternal(int r3, FUNC r4, double[] r5, double[] r6, double[] r7) {
        if (r4 == null) goto L19;
        if (r5 == null) goto L17;
        if (r6 == null) goto L15;
        if (r7 == null) goto L13;
        if (r5.length != r6.length) goto L11;
        return optimizeInternal(r3, r4, new OptimizationData[]{new Target(r5), new Weight(r6), new InitialGuess(r7)});
    L11:
        throw new DimensionMismatchException(r5.length, r6.length);
    L13:
        throw new NullArgumentException();
    L15:
        throw new NullArgumentException();
    L17:
        throw new NullArgumentException();
    L19:
        throw new NullArgumentException();
    }

    protected PointVectorValuePair optimizeInternal(int r2, FUNC r3, OptimizationData... r4) throws TooManyEvaluationsException, DimensionMismatchException {
        this.evaluations.setMaximalCount(r2);
        this.evaluations.resetCount();
        this.function = r3;
        parseOptimizationData(r4);
        checkParameters();
        setUp();
        return doOptimize();
    }

    public double[] getStartPoint() {
        return (double[]) this.start.clone();
    }

    public RealMatrix getWeight() {
        return this.weightMatrix.copy();
    }

    public double[] getTarget() {
        return (double[]) this.target.clone();
    }

    protected FUNC getObjectiveFunction() {
        return this.function;
    }

    @Deprecated
    protected double[] getTargetRef() {
        return this.target;
    }

    @Deprecated
    protected double[] getWeightRef() {
        return this.weight;
    }

    protected void setUp() {
        int r0 = this.target.length;
        this.weight = new double[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.weight[r1] = this.weightMatrix.getEntry(r1, r1);
        r1 = r1 + 1;
        goto L3
    }

    private void parseOptimizationData(OptimizationData... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof Target) == false) goto L8;
        this.target = ((Target) r2).getTarget();
    L13:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof Weight) == false) goto L11;
        this.weightMatrix = ((Weight) r2).getWeight();
        goto L13
    L11:
        if ((r2 instanceof InitialGuess) == false) goto L13;
        this.start = ((InitialGuess) r2).getInitialGuess();
        goto L13
    }

    private void checkParameters() {
        if (this.target.length != this.weightMatrix.getColumnDimension()) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(this.target.length, this.weightMatrix.getColumnDimension());
    }
}
