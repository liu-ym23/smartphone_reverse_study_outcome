package org.apache.commons.math3.optim.linear;

import java.util.Collection;
import java.util.Collections;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LinearOptimizer extends MultivariateOptimizer {
    private LinearObjectiveFunction function;
    private Collection<LinearConstraint> linearConstraints;
    private boolean nonNegative;

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    protected LinearOptimizer() {
        super(null);
    }

    protected boolean isRestrictedToNonNegative() {
        return this.nonNegative;
    }

    protected LinearObjectiveFunction getFunction() {
        return this.function;
    }

    protected Collection<LinearConstraint> getConstraints() {
        return Collections.unmodifiableCollection(this.linearConstraints);
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... r1) throws TooManyIterationsException {
        return super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof LinearObjectiveFunction) == false) goto L8;
        this.function = (LinearObjectiveFunction) r2;
    L13:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof LinearConstraintSet) == false) goto L11;
        this.linearConstraints = ((LinearConstraintSet) r2).getConstraints();
        goto L13
    L11:
        if ((r2 instanceof NonNegativeConstraint) == false) goto L13;
        this.nonNegative = ((NonNegativeConstraint) r2).isRestrictedToNonNegative();
        goto L13
    }
}
