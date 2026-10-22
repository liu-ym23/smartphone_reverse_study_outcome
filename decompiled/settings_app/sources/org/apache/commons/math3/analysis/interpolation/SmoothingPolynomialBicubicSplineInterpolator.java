package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.fitting.PolynomialFitter;
import org.apache.commons.math3.optim.SimpleVectorValueChecker;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.GaussNewtonOptimizer;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class SmoothingPolynomialBicubicSplineInterpolator extends BicubicSplineInterpolator {
    private final int xDegree;
    private final PolynomialFitter xFitter;
    private final int yDegree;
    private final PolynomialFitter yFitter;

    @Override // org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolator, org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public /* bridge */ /* synthetic */ BivariateFunction interpolate(double[] r1, double[] r2, double[][] r3) throws NoDataException, DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        return interpolate(r1, r2, r3);
    }

    public SmoothingPolynomialBicubicSplineInterpolator() {
        this(3);
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int r1) throws NotPositiveException {
        this(r1, r1);
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int r7, int r8) throws NotPositiveException {
        if (r7 < 0) goto L10;
        if (r8 < 0) goto L8;
        this.xDegree = r7;
        this.yDegree = r8;
        SimpleVectorValueChecker r9 = new SimpleVectorValueChecker(Precision.EPSILON * 100.0d, Precision.SAFE_MIN * 100.0d);
        this.xFitter = new PolynomialFitter(new GaussNewtonOptimizer(false, r9));
        this.yFitter = new PolynomialFitter(new GaussNewtonOptimizer(false, r9));
        return;
    L8:
        throw new NotPositiveException(Integer.valueOf(r8));
    L10:
        throw new NotPositiveException(Integer.valueOf(r7));
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolator, org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public BicubicSplineInterpolatingFunction interpolate(double[] r20, double[] r21, double[][] r22) throws NoDataException, NullArgumentException, DimensionMismatchException, NonMonotonicSequenceException {
        if (r20.length == 0) goto L47;
        if (r21.length == 0) goto L47;
        if (r22.length == 0) goto L47;
        if (r20.length != r22.length) goto L45;
        int r4 = r20.length;
        int r5 = r21.length;
        int r7 = 0;
    L11:
        if (r7 >= r4) goto L17;
        if (r22[r7].length != r5) goto L16;
        r7 = r7 + 1;
        goto L11
    L16:
        throw new DimensionMismatchException(r22[r7].length, r5);
    L17:
        MathArrays.checkOrder(r20);
        MathArrays.checkOrder(r21);
        PolynomialFunction[] r8 = new PolynomialFunction[r5];
        int r9 = 0;
    L19:
        if (r9 >= r5) goto L24;
        this.xFitter.clearObservations();
        int r10 = 0;
    L21:
        if (r10 >= r4) goto L23;
        this.xFitter.addObservedPoint(1.0d, r20[r10], r22[r10][r9]);
        r10 = r10 + 1;
        goto L21
    L23:
        r8[r9] = new PolynomialFunction(this.xFitter.fit(new double[this.xDegree + 1]));
        r9 = r9 + 1;
        goto L19
    L24:
        double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r4, r5});
        int r12 = 0;
    L25:
        if (r12 >= r5) goto L30;
        PolynomialFunction r13 = r8[r12];
        int r14 = 0;
    L27:
        if (r14 >= r4) goto L29;
        r11[r14][r12] = r13.value(r20[r14]);
        r14 = r14 + 1;
        goto L27
    L29:
        r12 = r12 + 1;
        goto L25
    L30:
        PolynomialFunction[] r15 = new PolynomialFunction[r4];
        int r16 = 0;
    L31:
        if (r16 >= r4) goto L36;
        this.yFitter.clearObservations();
        int r17 = 0;
    L33:
        if (r17 >= r5) goto L35;
        this.yFitter.addObservedPoint(1.0d, r21[r17], r11[r16][r17]);
        r17 = r17 + 1;
        goto L33
    L35:
        r15[r16] = new PolynomialFunction(this.yFitter.fit(new double[this.yDegree + 1]));
        r16 = r16 + 1;
        goto L31
    L36:
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r4, r5});
        int r18 = 0;
    L37:
        if (r18 >= r4) goto L43;
        PolynomialFunction r19 = r15[r18];
        int r110 = 0;
    L39:
        if (r110 >= r5) goto L41;
        r3[r18][r110] = r19.value(r21[r110]);
        r110 = r110 + 1;
        goto L39
    L41:
        r18 = r18 + 1;
        goto L37
    L43:
        return super.interpolate(r20, r21, r3);
    L45:
        throw new DimensionMismatchException(r20.length, r22.length);
    L47:
        throw new NoDataException();
    }
}
