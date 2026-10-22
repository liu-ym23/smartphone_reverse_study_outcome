package org.apache.commons.math3.optimization.direct;

import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleValueChecker;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class SimplexOptimizer extends BaseAbstractMultivariateOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    private AbstractSimplex simplex;

    @Deprecated
    public SimplexOptimizer() {
        this(new SimpleValueChecker());
    }

    public SimplexOptimizer(ConvergenceChecker<PointValuePair> r1) {
        super(r1);
    }

    public SimplexOptimizer(double r2, double r4) {
        this(new SimpleValueChecker(r2, r4));
    }

    @Deprecated
    public void setSimplex(AbstractSimplex r3) {
        parseOptimizationData(new OptimizationData[]{r3});
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    protected PointValuePair optimizeInternal(int r1, MultivariateFunction r2, GoalType r3, OptimizationData... r4) {
        parseOptimizationData(r4);
        return super.optimizeInternal(r1, r2, r3, r4);
    }

    private void parseOptimizationData(OptimizationData... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof AbstractSimplex) == false) goto L7;
        this.simplex = (AbstractSimplex) r2;
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    protected PointValuePair doOptimize() {
        if (this.simplex == null) goto L25;
        MultivariateFunction r0 = new AnonymousClass1(this);
        if (getGoalType() != GoalType.MINIMIZE) goto L7;
        final boolean r1 = true;
    L8:
        Comparator<PointValuePair> r2 = new AnonymousClass2(this, r1);
        this.simplex.build(getStartPoint());
        this.simplex.evaluate(r0, r2);
        ConvergenceChecker<PointValuePair> r3 = getConvergenceChecker();
        PointValuePair[] r5 = null;
        int r6 = 0;
    L9:
        if (r6 <= 0) goto L23;
        boolean r8 = true;
        int r7 = 0;
    L12:
        if (r7 >= this.simplex.getSize()) goto L20;
        PointValuePair r9 = r5[r7];
        if (r8 == true) goto L16;
    L18:
        r8 = false;
    L19:
        r7 = r7 + 1;
        goto L12
    L16:
        if (r3.converged(r6, r9, this.simplex.getPoint(r7)) == false) goto L18;
        r8 = true;
        goto L19
    L20:
        if (r8 == false) goto L23;
        return this.simplex.getPoint(0);
    L23:
        r5 = this.simplex.getPoints();
        this.simplex.iterate(r0, r2);
        r6 = r6 + 1;
        goto L9
    L7:
        r1 = false;
        goto L8
    L25:
        throw new NullArgumentException();
    }
}
