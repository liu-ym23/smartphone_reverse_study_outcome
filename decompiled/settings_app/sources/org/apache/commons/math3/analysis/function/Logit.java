package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Logit implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double hi;
    private final double lo;

    public static class Parametric implements ParametricUnivariateFunction {
        public Parametric() {
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double r7, double... r9) throws NullArgumentException, DimensionMismatchException {
            validateParameters(r9);
            return Logit.access$000(r7, r9[0], r9[1]);
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double r8, double... r10) throws NullArgumentException, DimensionMismatchException {
            validateParameters(r10);
            return new double[]{1.0d / (r10[0] - r8), 1.0d / (r10[1] - r8)};
        }

        private void validateParameters(double[] r2) throws NullArgumentException, DimensionMismatchException {
            if (r2 == null) goto L9;
            if (r2.length != 2) goto L7;
            return;
        L7:
            throw new DimensionMismatchException(r2.length, 2);
        L9:
            throw new NullArgumentException();
        }
    }

    static /* synthetic */ double access$000(double r0, double r2, double r4) throws OutOfRangeException {
        return value(r0, r2, r4);
    }

    public Logit() {
        this(0.0d, 1.0d);
    }

    public Logit(double r1, double r3) {
        this.lo = r1;
        this.hi = r3;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r7) throws OutOfRangeException {
        return value(r7, this.lo, this.hi);
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    private static double value(double r1, double r3, double r5) throws OutOfRangeException {
        if (r1 < r3) goto L9;
        if (r1 > r5) goto L9;
        return FastMath.log((r1 - r3) / (r5 - r1));
    L9:
        throw new OutOfRangeException(Double.valueOf(r1), Double.valueOf(r3), Double.valueOf(r5));
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r14) throws OutOfRangeException {
        double r0 = r14.getValue();
        if (r0 < this.lo) goto L19;
        if (r0 > this.hi) goto L19;
        int r3 = 1;
        int r2 = r14.getOrder() + 1;
        double[] r4 = new double[r2];
        double r5 = FastMath.log((r0 - this.lo) / (this.hi - r0));
        r4[0] = r5;
        if (Double.isInfinite(r5) == false) goto L13;
        if (r2 <= 1) goto L10;
        r4[1] = Double.POSITIVE_INFINITY;
    L10:
        int r13 = 2;
    L11:
        if (r13 >= r2) goto L17;
        r4[r13] = r4[r13 - 2];
        r13 = r13 + 1;
    L17:
        return r14.compose(r4);
    L13:
        double r6 = 1.0d / (r0 - this.lo);
        double r7 = 1.0d / (this.hi - r0);
        double r1 = r6;
        double r9 = r7;
    L14:
        if (r3 >= r2) goto L17;
        r4[r3] = r1 + r9;
        r1 = r1 * (((double) (-r3)) * r6);
        r9 = r9 * (((double) r3) * r7);
        r3 = r3 + 1;
    L19:
        throw new OutOfRangeException(Double.valueOf(r0), Double.valueOf(this.lo), Double.valueOf(this.hi));
    }
}
