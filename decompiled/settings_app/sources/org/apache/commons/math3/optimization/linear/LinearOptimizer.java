package org.apache.commons.math3.optimization.linear;

import java.util.Collection;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface LinearOptimizer {
    int getIterations();

    int getMaxIterations();

    PointValuePair optimize(LinearObjectiveFunction r1, Collection<LinearConstraint> r2, GoalType r3, boolean r4) throws MathIllegalStateException;

    void setMaxIterations(int r1);
}
