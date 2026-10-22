package org.apache.commons.math3.optim.univariate;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
public class UnivariateObjectiveFunction implements OptimizationData {
    private final UnivariateFunction function;

    public UnivariateObjectiveFunction(UnivariateFunction r1) {
        this.function = r1;
    }

    public UnivariateFunction getObjectiveFunction() {
        return this.function;
    }
}
