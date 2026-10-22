package org.apache.commons.math3.analysis.function;

import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Sigmoid implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double hi;
    private final double lo;

    public static class Parametric implements ParametricUnivariateFunction {
        public Parametric() {
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double r7, double... r9) throws NullArgumentException, DimensionMismatchException {
            validateParameters(r9);
            return Sigmoid.access$000(r7, r9[0], r9[1]);
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double r3, double... r5) throws NullArgumentException, DimensionMismatchException {
            validateParameters(r5);
            double r2 = 1.0d / (FastMath.exp(-r3) + 1.0d);
            return new double[]{1.0d - r2, r2};
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

    static /* synthetic */ double access$000(double r0, double r2, double r4) {
        return value(r0, r2, r4);
    }

    public Sigmoid() {
        this(0.0d, 1.0d);
    }

    public Sigmoid(double r1, double r3) {
        this.lo = r1;
        this.hi = r3;
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r7) {
        return value(r7, this.lo, this.hi);
    }

    private static double value(double r2, double r4, double r6) {
        return r4 + ((r6 - r4) / (FastMath.exp(-r2) + 1.0d));
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r25) throws DimensionMismatchException {
        int r2 = 1;
        int r1 = r25.getOrder() + 1;
        double[] r3 = new double[r1];
        double r4 = FastMath.exp(-r25.getValue());
        char r9 = 0;
        if (Double.isInfinite(r4) == false) goto L6;
        r3[0] = this.lo;
        Arrays.fill(r3, 1, r1, 0.0d);
    L18:
        return r25.compose(r3);
    L6:
        double[] r6 = new double[r1];
        double r10 = 1.0d;
        double r12 = 1.0d / (r4 + 1.0d);
        double r14 = this.hi - this.lo;
        int r7 = 0;
    L7:
        if (r7 >= r1) goto L16;
        r6[r7] = r10;
        int r8 = r7;
        double r16 = 0.0d;
    L9:
        if (r8 < 0) goto L15;
        r16 = (r16 * r4) + r6[r8];
        if (r8 <= r2) goto L13;
        int r5 = r8 - 1;
        r6[r5] = (((double) ((r7 - r8) + 2)) * r6[r8 - 2]) - (((double) r5) * r6[r5]);
        char r11 = 0;
    L14:
        r8 = r8 - 1;
        r9 = r11;
        r2 = 1;
        goto L9
    L13:
        r11 = r9;
        r6[r11] = 0.0d;
        goto L14
    L15:
        r14 = r14 * r12;
        r3[r7] = r16 * r14;
        r7 = r7 + 1;
        r9 = r9;
        r2 = 1;
        r10 = 1.0d;
        goto L7
    L16:
        char r13 = r9;
        r3[r13] = r3[r13] + this.lo;
        goto L18
    }
}
