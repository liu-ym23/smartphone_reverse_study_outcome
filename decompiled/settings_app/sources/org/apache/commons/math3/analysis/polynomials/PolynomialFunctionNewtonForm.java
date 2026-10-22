package org.apache.commons.math3.analysis.polynomials;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialFunctionNewtonForm implements UnivariateDifferentiableFunction {
    private final double[] a;
    private final double[] c;
    private double[] coefficients;
    private boolean coefficientsComputed;

    public PolynomialFunctionNewtonForm(double[] r5, double[] r6) throws NullArgumentException, NoDataException, DimensionMismatchException {
        verifyInputArray(r5, r6);
        double[] r0 = new double[r5.length];
        this.a = r0;
        double[] r1 = new double[r6.length];
        this.c = r1;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r6, 0, r1, 0, r6.length);
        this.coefficientsComputed = false;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r2) {
        return evaluate(this.a, this.c, r2);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r7) {
        verifyInputArray(this.a, this.c);
        int r0 = this.c.length;
        DerivativeStructure r1 = new DerivativeStructure(r7.getFreeParameters(), r7.getOrder(), this.a[r0]);
        int r2 = r0 - 1;
    L3:
        if (r2 < 0) goto L5;
        r1 = r7.subtract2(this.c[r2]).multiply(r1).add2(this.a[r2]);
        r2 = r2 - 1;
        goto L3
    L5:
        return r1;
    }

    public int degree() {
        return this.c.length;
    }

    public double[] getNewtonCoefficients() {
        double[] r3 = this.a;
        double[] r0 = new double[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public double[] getCenters() {
        double[] r3 = this.c;
        double[] r0 = new double[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public double[] getCoefficients() {
        if (this.coefficientsComputed == true) goto L5;
        computeCoefficients();
    L5:
        double[] r3 = this.coefficients;
        double[] r0 = new double[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public static double evaluate(double[] r7, double[] r8, double r9) throws NullArgumentException, DimensionMismatchException, NoDataException {
        verifyInputArray(r7, r8);
        int r0 = r8.length;
        double r1 = r7[r0];
        int r2 = r0 - 1;
    L3:
        if (r2 < 0) goto L5;
        r1 = r7[r2] + ((r9 - r8[r2]) * r1);
        r2 = r2 - 1;
        goto L3
    L5:
        return r1;
    }

    protected void computeCoefficients() {
        int r0 = degree();
        this.coefficients = new double[r0 + 1];
        int r2 = 0;
    L3:
        if (r2 > r0) goto L5;
        this.coefficients[r2] = 0.0d;
        r2 = r2 + 1;
        goto L3
    L5:
        this.coefficients[0] = this.a[r0];
        int r3 = r0 - 1;
    L6:
        if (r3 < 0) goto L11;
        int r4 = r0 - r3;
    L8:
        if (r4 <= 0) goto L10;
        double[] r5 = this.coefficients;
        r5[r4] = r5[r4 - 1] - (this.c[r3] * r5[r4]);
        r4 = r4 - 1;
        goto L8
    L10:
        double[] r6 = this.coefficients;
        r6[0] = this.a[r3] - (this.c[r3] * r6[0]);
        r3 = r3 - 1;
        goto L6
    L11:
        this.coefficientsComputed = true;
    }

    protected static void verifyInputArray(double[] r2, double[] r3) throws NullArgumentException, NoDataException, DimensionMismatchException {
        MathUtils.checkNotNull(r2);
        MathUtils.checkNotNull(r3);
        if (r2.length == 0) goto L12;
        if (r3.length == 0) goto L12;
        if (r2.length != (r3.length + 1)) goto L10;
        return;
    L10:
        throw new DimensionMismatchException(LocalizedFormats.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1, r2.length, r3.length);
    L12:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }
}
