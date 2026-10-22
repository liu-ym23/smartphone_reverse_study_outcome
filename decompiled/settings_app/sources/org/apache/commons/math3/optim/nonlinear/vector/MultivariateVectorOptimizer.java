package org.apache.commons.math3.optim.nonlinear.vector;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.BaseMultivariateOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointVectorValuePair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class MultivariateVectorOptimizer extends BaseMultivariateOptimizer<PointVectorValuePair> {
    private MultivariateVectorFunction model;
    private double[] target;
    private RealMatrix weightMatrix;

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    protected MultivariateVectorOptimizer(ConvergenceChecker<PointVectorValuePair> r1) {
        super(r1);
    }

    protected double[] computeObjectiveValue(double[] r1) {
        super.incrementEvaluationCount();
        return this.model.value(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointVectorValuePair optimize(OptimizationData... r1) throws TooManyEvaluationsException, DimensionMismatchException {
        return (PointVectorValuePair) super.optimize(r1);
    }

    public RealMatrix getWeight() {
        return this.weightMatrix.copy();
    }

    public double[] getTarget() {
        return (double[]) this.target.clone();
    }

    public int getTargetSize() {
        return this.target.length;
    }

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof ModelFunction) == false) goto L8;
        this.model = ((ModelFunction) r2).getModelFunction();
    L13:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof Target) == false) goto L11;
        this.target = ((Target) r2).getTarget();
        goto L13
    L11:
        if ((r2 instanceof Weight) == false) goto L13;
        this.weightMatrix = ((Weight) r2).getWeight();
        goto L13
    L14:
        checkParameters();
    }

    private void checkParameters() {
        if (this.target.length != this.weightMatrix.getColumnDimension()) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(this.target.length, this.weightMatrix.getColumnDimension());
    }
}
