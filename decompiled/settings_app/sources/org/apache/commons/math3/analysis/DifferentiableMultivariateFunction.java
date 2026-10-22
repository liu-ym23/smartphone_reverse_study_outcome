package org.apache.commons.math3.analysis;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface DifferentiableMultivariateFunction extends MultivariateFunction {
    MultivariateVectorFunction gradient();

    MultivariateFunction partialDerivative(int r1);
}
