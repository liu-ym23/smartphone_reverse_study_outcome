package org.apache.commons.math3.optimization.linear;

import java.util.Collection;
import java.util.Collections;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractLinearOptimizer implements LinearOptimizer {
    public static final int DEFAULT_MAX_ITERATIONS = 100;
    private LinearObjectiveFunction function;
    private GoalType goal;
    private int iterations;
    private Collection<LinearConstraint> linearConstraints;
    private int maxIterations;
    private boolean nonNegative;

    protected abstract PointValuePair doOptimize() throws MathIllegalStateException;

    protected AbstractLinearOptimizer() {
        setMaxIterations(100);
    }

    protected boolean restrictToNonNegative() {
        return this.nonNegative;
    }

    protected GoalType getGoalType() {
        return this.goal;
    }

    protected LinearObjectiveFunction getFunction() {
        return this.function;
    }

    protected Collection<LinearConstraint> getConstraints() {
        return Collections.unmodifiableCollection(this.linearConstraints);
    }

    @Override // org.apache.commons.math3.optimization.linear.LinearOptimizer
    public void setMaxIterations(int r1) {
        this.maxIterations = r1;
    }

    @Override // org.apache.commons.math3.optimization.linear.LinearOptimizer
    public int getMaxIterations() {
        return this.maxIterations;
    }

    @Override // org.apache.commons.math3.optimization.linear.LinearOptimizer
    public int getIterations() {
        return this.iterations;
    }

    protected void incrementIterationsCounter() throws MaxCountExceededException {
        int r0 = this.iterations + 1;
        this.iterations = r0;
        if (r0 > this.maxIterations) goto L6;
        return;
    L6:
        throw new MaxCountExceededException(Integer.valueOf(this.maxIterations));
    }

    @Override // org.apache.commons.math3.optimization.linear.LinearOptimizer
    public PointValuePair optimize(LinearObjectiveFunction r1, Collection<LinearConstraint> r2, GoalType r3, boolean r4) throws MathIllegalStateException {
        this.function = r1;
        this.linearConstraints = r2;
        this.goal = r3;
        this.nonNegative = r4;
        this.iterations = 0;
        return doOptimize();
    }
}
