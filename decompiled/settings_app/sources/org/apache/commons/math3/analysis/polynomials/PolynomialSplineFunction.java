package org.apache.commons.math3.analysis.polynomials;

import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialSplineFunction implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double[] knots;
    private final int n;
    private final PolynomialFunction[] polynomials;

    public PolynomialSplineFunction(double[] r5, PolynomialFunction[] r6) throws NullArgumentException, NumberIsTooSmallException, DimensionMismatchException, NonMonotonicSequenceException {
        if (r5 == null) goto L16;
        if (r6 == null) goto L16;
        if (r5.length < 2) goto L14;
        if ((r5.length - 1) != r6.length) goto L12;
        MathArrays.checkOrder(r5);
        int r0 = r5.length - 1;
        this.n = r0;
        double[] r1 = new double[r0 + 1];
        this.knots = r1;
        System.arraycopy(r5, 0, r1, 0, r0 + 1);
        PolynomialFunction[] r7 = new PolynomialFunction[r0];
        this.polynomials = r7;
        System.arraycopy(r6, 0, r7, 0, r0);
        return;
    L12:
        throw new DimensionMismatchException(r6.length, r5.length);
    L14:
        throw new NumberIsTooSmallException(LocalizedFormats.NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION, 2, Integer.valueOf(r5.length), false);
    L16:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r5) {
        double[] r0 = this.knots;
        if (r5 < r0[0]) goto L15;
        if (r5 > r0[this.n]) goto L15;
        int r1 = Arrays.binarySearch(r0, r5);
        if (r1 >= 0) goto L9;
        r1 = (-r1) - 2;
    L9:
        PolynomialFunction[] r2 = this.polynomials;
        if (r1 < r2.length) goto L13;
        r1 = r1 - 1;
    L13:
        return r2[r1].value(r5 - this.knots[r1]);
    L15:
        throw new OutOfRangeException(Double.valueOf(r5), Double.valueOf(this.knots[0]), Double.valueOf(this.knots[this.n]));
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    public UnivariateFunction derivative() {
        return polynomialSplineDerivative();
    }

    public PolynomialSplineFunction polynomialSplineDerivative() {
        PolynomialFunction[] r0 = new PolynomialFunction[this.n];
        int r1 = 0;
    L4:
        if (r1 >= this.n) goto L7;
        r0[r1] = this.polynomials[r1].polynomialDerivative();
        r1 = r1 + 1;
        goto L4
    L7:
        return new PolynomialSplineFunction(this.knots, r0);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r7) {
        double r0 = r7.getValue();
        double[] r2 = this.knots;
        if (r0 < r2[0]) goto L15;
        if (r0 > r2[this.n]) goto L15;
        int r1 = Arrays.binarySearch(r2, r0);
        if (r1 >= 0) goto L9;
        r1 = (-r1) - 2;
    L9:
        PolynomialFunction[] r3 = this.polynomials;
        if (r1 < r3.length) goto L13;
        r1 = r1 - 1;
    L13:
        return r3[r1].value(r7.subtract2(this.knots[r1]));
    L15:
        throw new OutOfRangeException(Double.valueOf(r0), Double.valueOf(this.knots[0]), Double.valueOf(this.knots[this.n]));
    }

    public int getN() {
        return this.n;
    }

    public PolynomialFunction[] getPolynomials() {
        int r0 = this.n;
        PolynomialFunction[] r1 = new PolynomialFunction[r0];
        System.arraycopy(this.polynomials, 0, r1, 0, r0);
        return r1;
    }

    public double[] getKnots() {
        int r0 = this.n;
        double[] r1 = new double[r0 + 1];
        System.arraycopy(this.knots, 0, r1, 0, r0 + 1);
        return r1;
    }

    public boolean isValidPoint(double r5) {
        double[] r0 = this.knots;
        if (r5 >= r0[0]) goto L5;
    L9:
        return false;
    L5:
        if (r5 > r0[this.n]) goto L9;
        return true;
    }
}
