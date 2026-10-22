package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateFunction;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface BaseMultivariateOptimizer<FUNC extends MultivariateFunction> extends BaseOptimizer<PointValuePair> {
    @Deprecated
    PointValuePair optimize(int r1, FUNC r2, GoalType r3, double[] r4);
}
