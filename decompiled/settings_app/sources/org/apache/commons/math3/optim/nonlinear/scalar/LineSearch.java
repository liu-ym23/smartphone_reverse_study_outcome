package org.apache.commons.math3.optim.nonlinear.scalar;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.univariate.BracketFinder;
import org.apache.commons.math3.optim.univariate.BrentOptimizer;
import org.apache.commons.math3.optim.univariate.SearchInterval;
import org.apache.commons.math3.optim.univariate.SimpleUnivariateValueChecker;
import org.apache.commons.math3.optim.univariate.UnivariateObjectiveFunction;
import org.apache.commons.math3.optim.univariate.UnivariateOptimizer;
import org.apache.commons.math3.optim.univariate.UnivariatePointValuePair;

/* JADX INFO: loaded from: classes6.dex */
public class LineSearch {
    private static final double ABS_TOL_UNUSED = Double.MIN_VALUE;
    private static final double REL_TOL_UNUSED = 1.0E-15d;
    private final BracketFinder bracket;
    private final double initialBracketingRange;
    private final UnivariateOptimizer lineOptimizer;
    private final MultivariateOptimizer mainOptimizer;

    static /* synthetic */ MultivariateOptimizer access$000(LineSearch r0) {
        return r0.mainOptimizer;
    }

    public LineSearch(MultivariateOptimizer r8, double r9, double r11, double r13) {
        this.bracket = new BracketFinder();
        this.mainOptimizer = r8;
        this.lineOptimizer = new BrentOptimizer(1.0E-15d, Double.MIN_VALUE, new SimpleUnivariateValueChecker(r9, r11));
        this.initialBracketingRange = r13;
    }

    public UnivariatePointValuePair search(final double[] r10, final double[] r11) {
        final int r0 = r10.length;
        UnivariateFunction r8 = new AnonymousClass1(this, r0, r10, r11);
        GoalType r12 = this.mainOptimizer.getGoalType();
        this.bracket.search(r8, r12, 0.0d, this.initialBracketingRange);
        return this.lineOptimizer.optimize(new OptimizationData[]{new MaxEval(Integer.MAX_VALUE), new UnivariateObjectiveFunction(r8), r12, new SearchInterval(this.bracket.getLo(), this.bracket.getHi(), this.bracket.getMid())});
    }
}
