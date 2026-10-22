package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.DifferentiableMultivariateFunction;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class DifferentiableMultivariateMultiStartOptimizer extends BaseMultivariateMultiStartOptimizer<DifferentiableMultivariateFunction> implements DifferentiableMultivariateOptimizer {
    public DifferentiableMultivariateMultiStartOptimizer(DifferentiableMultivariateOptimizer r1, int r2, RandomVectorGenerator r3) {
        super(r1, r2, r3);
    }
}
