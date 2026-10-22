package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class PiecewiseBicubicSplineInterpolator implements BivariateGridInterpolator {
    public PiecewiseBicubicSplineInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public /* bridge */ /* synthetic */ BivariateFunction interpolate(double[] r1, double[] r2, double[][] r3) throws NoDataException, DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        return interpolate(r1, r2, r3);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public PiecewiseBicubicSplineInterpolatingFunction interpolate(double[] r1, double[] r2, double[][] r3) throws DimensionMismatchException, NullArgumentException, NoDataException, NonMonotonicSequenceException {
        if (r1 == null) goto L18;
        if (r2 == null) goto L18;
        if (r3 == null) goto L18;
        if (r3[0] == null) goto L18;
        if (r1.length == 0) goto L16;
        if (r2.length == 0) goto L16;
        if (r3.length == 0) goto L16;
        MathArrays.checkOrder(r1);
        MathArrays.checkOrder(r2);
        return new PiecewiseBicubicSplineInterpolatingFunction(r1, r2, r3);
    L16:
        throw new NoDataException();
    L18:
        throw new NullArgumentException();
    }
}
