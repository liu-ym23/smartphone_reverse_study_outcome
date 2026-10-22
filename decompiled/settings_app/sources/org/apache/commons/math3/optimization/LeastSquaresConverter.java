package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class LeastSquaresConverter implements MultivariateFunction {
    private final MultivariateVectorFunction function;
    private final double[] observations;
    private final RealMatrix scale;
    private final double[] weights;

    public LeastSquaresConverter(MultivariateVectorFunction r1, double[] r2) {
        this.function = r1;
        this.observations = (double[]) r2.clone();
        this.weights = null;
        this.scale = null;
    }

    public LeastSquaresConverter(MultivariateVectorFunction r3, double[] r4, double[] r5) {
        if (r4.length != r5.length) goto L7;
        this.function = r3;
        this.observations = (double[]) r4.clone();
        this.weights = (double[]) r5.clone();
        this.scale = null;
        return;
    L7:
        throw new DimensionMismatchException(r4.length, r5.length);
    }

    public LeastSquaresConverter(MultivariateVectorFunction r3, double[] r4, RealMatrix r5) {
        if (r4.length != r5.getColumnDimension()) goto L7;
        this.function = r3;
        this.observations = (double[]) r4.clone();
        this.weights = null;
        this.scale = r5.copy();
        return;
    L7:
        throw new DimensionMismatchException(r4.length, r5.getColumnDimension());
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] r9) {
        double[] r10 = this.function.value(r9);
        if (r10.length != this.observations.length) goto L23;
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r1 >= r10.length) goto L8;
        r10[r1] = r10[r1] - this.observations[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        double r2 = 0.0d;
        if (this.weights != null) goto L11;
        RealMatrix r8 = this.scale;
        if (r8 == null) goto L18;
        double[] r11 = r8.operate(r10);
        int r12 = r11.length;
    L16:
        if (r0 >= r12) goto L21;
        double r4 = r11[r0];
        r2 = r2 + (r4 * r4);
        r0 = r0 + 1;
    L21:
        return r2;
    L18:
        int r13 = r10.length;
    L19:
        if (r0 >= r13) goto L21;
        double r5 = r10[r0];
        r2 = r2 + (r5 * r5);
        r0 = r0 + 1;
    L11:
        if (r0 >= r10.length) goto L21;
        double r6 = r10[r0];
        r2 = r2 + ((this.weights[r0] * r6) * r6);
        r0 = r0 + 1;
        goto L11
    L23:
        throw new DimensionMismatchException(r10.length, this.observations.length);
    }
}
