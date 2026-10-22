package org.apache.commons.math3.analysis.differentiation;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;

/* JADX INFO: loaded from: classes6.dex */
public class GradientFunction implements MultivariateVectorFunction {
    private final MultivariateDifferentiableFunction f;

    public GradientFunction(MultivariateDifferentiableFunction r1) {
        this.f = r1;
    }

    @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
    public double[] value(double[] r11) {
        DerivativeStructure[] r0 = new DerivativeStructure[r11.length];
        int r8 = 0;
    L4:
        if (r8 >= r11.length) goto L6;
        r0[r8] = new DerivativeStructure(r11.length, 1, r8, r11[r8]);
        r8 = r8 + 1;
        goto L4
    L6:
        DerivativeStructure r10 = this.f.value(r0);
        double[] r1 = new double[r11.length];
        int[] r2 = new int[r11.length];
        int r3 = 0;
    L8:
        if (r3 >= r11.length) goto L10;
        r2[r3] = 1;
        r1[r3] = r10.getPartialDerivative(r2);
        r2[r3] = 0;
        r3 = r3 + 1;
        goto L8
    L10:
        return r1;
    }
}
