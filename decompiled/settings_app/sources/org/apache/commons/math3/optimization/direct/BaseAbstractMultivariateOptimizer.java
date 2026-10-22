package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.BaseMultivariateOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleBounds;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class BaseAbstractMultivariateOptimizer<FUNC extends MultivariateFunction> implements BaseMultivariateOptimizer<FUNC> {
    private ConvergenceChecker<PointValuePair> checker;
    protected final Incrementor evaluations;
    private MultivariateFunction function;
    private GoalType goal;
    private double[] lowerBound;
    private double[] start;
    private double[] upperBound;

    protected abstract PointValuePair doOptimize();

    @Deprecated
    protected BaseAbstractMultivariateOptimizer() {
        this(new SimpleValueChecker());
    }

    protected BaseAbstractMultivariateOptimizer(ConvergenceChecker<PointValuePair> r2) {
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
    public ConvergenceChecker<PointValuePair> getConvergenceChecker() {
        return this.checker;
    }

    protected double computeObjectiveValue(double[] r2) {
        this.evaluations.incrementCount();     // Catch: MaxCountExceededException -> L5
        return this.function.value(r2);
    L5:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateOptimizer
    @Deprecated
    public PointValuePair optimize(int r3, FUNC r4, GoalType r5, double[] r6) {
        return optimizeInternal(r3, r4, r5, new OptimizationData[]{new InitialGuess(r6)});
    }

    public PointValuePair optimize(int r1, FUNC r2, GoalType r3, OptimizationData... r4) {
        return optimizeInternal(r1, r2, r3, r4);
    }

    @Deprecated
    protected PointValuePair optimizeInternal(int r3, FUNC r4, GoalType r5, double[] r6) {
        return optimizeInternal(r3, r4, r5, new OptimizationData[]{new InitialGuess(r6)});
    }

    protected PointValuePair optimizeInternal(int r2, FUNC r3, GoalType r4, OptimizationData... r5) throws TooManyEvaluationsException {
        this.evaluations.setMaximalCount(r2);
        this.evaluations.resetCount();
        this.function = r3;
        this.goal = r4;
        parseOptimizationData(r5);
        checkParameters();
        return doOptimize();
    }

    private void parseOptimizationData(OptimizationData... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof InitialGuess) == false) goto L8;
        this.start = ((InitialGuess) r2).getInitialGuess();
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof SimpleBounds) == false) goto L10;
        SimpleBounds r3 = (SimpleBounds) r2;
        this.lowerBound = r3.getLower();
        this.upperBound = r3.getUpper();
        goto L10
    }

    public GoalType getGoalType() {
        return this.goal;
    }

    public double[] getStartPoint() {
        double[] r0 = this.start;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    public double[] getLowerBound() {
        double[] r0 = this.lowerBound;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    public double[] getUpperBound() {
        double[] r0 = this.upperBound;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    private void checkParameters() {
        double[] r0 = this.start;
        if (r0 == null) goto L40;
        int r1 = r0.length;
        double[] r2 = this.lowerBound;
        int r3 = 0;
        if (r2 != null) goto L7;
    L17:
        double[] r4 = this.upperBound;
        if (r4 == null) goto L31;
        if (r4.length != r1) goto L29;
        int r5 = 0;
    L22:
        if (r5 >= r1) goto L31;
        double r6 = this.start[r5];
        double r7 = this.upperBound[r5];
        if (r6 > r7) goto L27;
        r5 = r5 + 1;
        goto L22
    L27:
        throw new NumberIsTooLargeException(Double.valueOf(r6), Double.valueOf(r7), true);
    L29:
        throw new DimensionMismatchException(this.upperBound.length, r1);
    L31:
        if (this.lowerBound != null) goto L36;
        this.lowerBound = new double[r1];
        int r8 = 0;
    L33:
        if (r8 >= r1) goto L36;
        this.lowerBound[r8] = Double.NEGATIVE_INFINITY;
        r8 = r8 + 1;
    L36:
        if (this.upperBound != null) goto L47;
        this.upperBound = new double[r1];
    L38:
        if (r3 >= r1) goto L48;
        this.upperBound[r3] = Double.POSITIVE_INFINITY;
        r3 = r3 + 1;
        goto L38
    L48:
        return;
    L47:
        return;
    L7:
        if (r2.length != r1) goto L16;
        int r9 = 0;
    L9:
        if (r9 >= r1) goto L17;
        double r10 = this.start[r9];
        double r11 = this.lowerBound[r9];
        if (r10 < r11) goto L14;
        r9 = r9 + 1;
        goto L9
    L14:
        throw new NumberIsTooSmallException(Double.valueOf(r10), Double.valueOf(r11), true);
    L16:
        throw new DimensionMismatchException(this.lowerBound.length, r1);
    }
}
