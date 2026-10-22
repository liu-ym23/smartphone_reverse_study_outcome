package org.apache.commons.math3.analysis.interpolation;

import java.io.Serializable;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionNewtonForm;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

/* JADX INFO: loaded from: classes6.dex */
public class DividedDifferenceInterpolator implements UnivariateInterpolator, Serializable {
    private static final long serialVersionUID = 107049519551235069L;

    public DividedDifferenceInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public /* bridge */ /* synthetic */ UnivariateFunction interpolate(double[] r1, double[] r2) throws MathIllegalArgumentException, DimensionMismatchException {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialFunctionNewtonForm interpolate(double[] r3, double[] r4) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        PolynomialFunctionLagrangeForm.verifyInterpolationArray(r3, r4, true);
        int r0 = r3.length - 1;
        double[] r2 = new double[r0];
        System.arraycopy(r3, 0, r2, 0, r0);
        return new PolynomialFunctionNewtonForm(computeDividedDifference(r3, r4), r2);
    }

    protected static double[] computeDividedDifference(double[] r12, double[] r13) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        int r0 = 1;
        PolynomialFunctionLagrangeForm.verifyInterpolationArray(r12, r13, true);
        double[] r14 = (double[]) r13.clone();
        int r1 = r12.length;
        double[] r2 = new double[r1];
        r2[0] = r14[0];
    L3:
        if (r0 >= r1) goto L9;
        int r4 = 0;
    L6:
        if (r4 >= (r1 - r0)) goto L8;
        int r7 = r4 + 1;
        r14[r4] = (r14[r7] - r14[r4]) / (r12[r4 + r0] - r12[r4]);
        r4 = r7;
        goto L6
    L8:
        r2[r0] = r14[0];
        r0 = r0 + 1;
        goto L3
    L9:
        return r2;
    }
}
