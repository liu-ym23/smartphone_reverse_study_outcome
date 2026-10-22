package org.apache.commons.math3.analysis.differentiation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;

/* JADX INFO: loaded from: classes6.dex */
public class JacobianFunction implements MultivariateMatrixFunction {
    private final MultivariateDifferentiableVectorFunction f;

    public JacobianFunction(MultivariateDifferentiableVectorFunction r1) {
        this.f = r1;
    }

    @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
    public double[][] value(double[] r11) {
        DerivativeStructure[] r0 = new DerivativeStructure[r11.length];
        int r8 = 0;
    L4:
        if (r8 >= r11.length) goto L6;
        r0[r8] = new DerivativeStructure(r11.length, 1, r8, r11[r8]);
        r8 = r8 + 1;
        goto L4
    L6:
        DerivativeStructure[] r10 = this.f.value(r0);
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10.length, r11.length});
        int[] r2 = new int[r11.length];
        int r3 = 0;
    L8:
        if (r3 >= r10.length) goto L14;
        int r5 = 0;
    L11:
        if (r5 >= r11.length) goto L13;
        r2[r5] = 1;
        r1[r3][r5] = r10[r3].getPartialDerivative(r2);
        r2[r5] = 0;
        r5 = r5 + 1;
        goto L11
    L13:
        r3 = r3 + 1;
        goto L8
    L14:
        return r1;
    }
}
