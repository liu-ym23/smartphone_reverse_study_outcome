package org.apache.commons.math3.optimization.univariate;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.optimization.BaseOptimizer;
import org.apache.commons.math3.optimization.GoalType;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface BaseUnivariateOptimizer<FUNC extends UnivariateFunction> extends BaseOptimizer<UnivariatePointValuePair> {
    UnivariatePointValuePair optimize(int r1, FUNC r2, GoalType r3, double r4, double r6);

    UnivariatePointValuePair optimize(int r1, FUNC r2, GoalType r3, double r4, double r6, double r8);
}
