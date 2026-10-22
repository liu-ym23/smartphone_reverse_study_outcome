package org.apache.commons.math3.optimization.fitting;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class PolynomialFitter extends CurveFitter<PolynomialFunction.Parametric> {

    @Deprecated
    private final int degree;

    @Deprecated
    public PolynomialFitter(int r1, DifferentiableMultivariateVectorOptimizer r2) {
        super(r2);
        this.degree = r1;
    }

    public PolynomialFitter(DifferentiableMultivariateVectorOptimizer r1) {
        super(r1);
        this.degree = -1;
    }

    @Deprecated
    public double[] fit() {
        return fit(new PolynomialFunction.Parametric(), new double[this.degree + 1]);
    }

    public double[] fit(int r2, double[] r3) {
        return fit(r2, new PolynomialFunction.Parametric(), r3);
    }

    public double[] fit(double[] r2) {
        return fit(new PolynomialFunction.Parametric(), r2);
    }
}
