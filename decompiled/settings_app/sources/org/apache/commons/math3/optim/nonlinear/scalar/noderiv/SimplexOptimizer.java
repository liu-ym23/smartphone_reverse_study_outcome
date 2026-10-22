package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.SimpleValueChecker;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;

/* JADX INFO: loaded from: classes6.dex */
public class SimplexOptimizer extends MultivariateOptimizer {
    private AbstractSimplex simplex;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected /* bridge */ /* synthetic */ Object doOptimize() {
        return doOptimize();
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    public SimplexOptimizer(ConvergenceChecker<PointValuePair> r1) {
        super(r1);
    }

    public SimplexOptimizer(double r2, double r4) {
        this(new SimpleValueChecker(r2, r4));
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... r1) {
        return super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected PointValuePair doOptimize() {
        checkParameters();
        MultivariateFunction r0 = new AnonymousClass1(this);
        if (getGoalType() != GoalType.MINIMIZE) goto L5;
        final boolean r1 = true;
    L6:
        Comparator<PointValuePair> r2 = new AnonymousClass2(this, r1);
        this.simplex.build(getStartPoint());
        this.simplex.evaluate(r0, r2);
        ConvergenceChecker<PointValuePair> r3 = getConvergenceChecker();
        PointValuePair[] r5 = null;
    L8:
        if (getIterations() <= 0) goto L22;
        boolean r7 = true;
        int r6 = 0;
    L11:
        if (r6 >= this.simplex.getSize()) goto L19;
        PointValuePair r8 = r5[r6];
        if (r7 == true) goto L15;
    L17:
        r7 = false;
    L18:
        r6 = r6 + 1;
        goto L11
    L15:
        if (r3.converged(0, r8, this.simplex.getPoint(r6)) == false) goto L17;
        r7 = true;
        goto L18
    L19:
        if (r7 == false) goto L22;
        return this.simplex.getPoint(0);
    L22:
        r5 = this.simplex.getPoints();
        this.simplex.iterate(r0, r2);
        incrementIterationCount();
        goto L8
    L5:
        r1 = false;
        goto L6
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof AbstractSimplex) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        this.simplex = (AbstractSimplex) r2;
        return;
    }

    private void checkParameters() {
        if (this.simplex == null) goto L12;
        if (getLowerBound() != null) goto L10;
        if (getUpperBound() != null) goto L10;
        return;
    L10:
        throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
    L12:
        throw new NullArgumentException();
    }
}
