package org.apache.commons.math3.optim.nonlinear.vector;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class ModelFunction implements OptimizationData {
    private final MultivariateVectorFunction model;

    public ModelFunction(MultivariateVectorFunction r1) {
        this.model = r1;
    }

    public MultivariateVectorFunction getModelFunction() {
        return this.model;
    }
}
