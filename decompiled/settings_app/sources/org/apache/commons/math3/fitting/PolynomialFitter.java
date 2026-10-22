package org.apache.commons.math3.fitting;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class PolynomialFitter extends CurveFitter<PolynomialFunction.Parametric> {
    public PolynomialFitter(MultivariateVectorOptimizer r1) {
        super(r1);
    }

    public double[] fit(int r2, double[] r3) {
        return fit(r2, new PolynomialFunction.Parametric(), r3);
    }

    public double[] fit(double[] r2) {
        return fit(new PolynomialFunction.Parametric(), r2);
    }
}
