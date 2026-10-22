package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

/* JADX INFO: loaded from: classes6.dex */
public class Constant implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double c;

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public /* bridge */ /* synthetic */ UnivariateFunction derivative() {
        return derivative();
    }

    public Constant(double r1) {
        this.c = r1;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r1) {
        return this.c;
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public DifferentiableUnivariateFunction derivative() {
        return new Constant(0.0d);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r5) {
        return new DerivativeStructure(r5.getFreeParameters(), r5.getOrder(), this.c);
    }
}
