package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface BaseMultivariateVectorOptimizer<FUNC extends MultivariateVectorFunction> extends BaseOptimizer<PointVectorValuePair> {
    @Deprecated
    PointVectorValuePair optimize(int r1, FUNC r2, double[] r3, double[] r4, double[] r5);
}
