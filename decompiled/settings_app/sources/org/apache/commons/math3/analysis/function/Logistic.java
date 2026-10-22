package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Logistic implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double a;
    private final double b;
    private final double k;
    private final double m;
    private final double oneOverN;
    private final double q;

    public static class Parametric implements ParametricUnivariateFunction {
        public Parametric() {
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double r17, double... r19) throws NullArgumentException, DimensionMismatchException, NotStrictlyPositiveException {
            validateParameters(r19);
            return Logistic.access$000(r19[1] - r17, r19[0], r19[2], r19[3], r19[4], 1.0d / r19[5]);
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double r41, double... r43) throws NullArgumentException, DimensionMismatchException, NotStrictlyPositiveException {
            validateParameters(r43);
            double r13 = r43[2];
            double r16 = r43[3];
            double r19 = r43[1] - r41;
            double r11 = 1.0d / r43[5];
            double r22 = FastMath.exp(r13 * r19);
            double r24 = r16 * r22;
            double r9 = r24 + 1.0d;
            double r7 = ((r43[0] - r43[4]) * r11) / FastMath.pow(r9, r11);
            double r28 = (-r7) / r9;
            return new double[]{Logistic.access$000(r19, 1.0d, r13, r16, 0.0d, r11), (r28 * r13) * r24, r24 * (r28 * r19), r28 * r22, Logistic.access$000(r19, 0.0d, r13, r16, 1.0d, r11), (r7 * FastMath.log(r9)) * r11};
        }

        private void validateParameters(double[] r5) throws NullArgumentException, DimensionMismatchException, NotStrictlyPositiveException {
            if (r5 == null) goto L13;
            if (r5.length != 6) goto L11;
            if (r5[5] <= 0.0d) goto L9;
            return;
        L9:
            throw new NotStrictlyPositiveException(Double.valueOf(r5[5]));
        L11:
            throw new DimensionMismatchException(r5.length, 6);
        L13:
            throw new NullArgumentException();
        }
    }

    static /* synthetic */ double access$000(double r0, double r2, double r4, double r6, double r8, double r10) {
        return value(r0, r2, r4, r6, r8, r10);
    }

    public Logistic(double r3, double r5, double r7, double r9, double r11, double r13) throws NotStrictlyPositiveException {
        if (r13 <= 0.0d) goto L7;
        this.k = r3;
        this.m = r5;
        this.b = r7;
        this.q = r9;
        this.a = r11;
        this.oneOverN = 1.0d / r13;
        return;
    L7:
        throw new NotStrictlyPositiveException(Double.valueOf(r13));
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r16) {
        return value(this.m - r16, this.k, this.b, this.q, this.a, this.oneOverN);
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    private static double value(double r0, double r2, double r4, double r6, double r8, double r10) {
        return r8 + ((r2 - r8) / FastMath.pow((r6 * FastMath.exp(r4 * r0)) + 1.0d, r10));
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r5) {
        return r5.negate().add2(this.m).multiply2(this.b).exp2().multiply2(this.q).add2(1.0d).pow2(this.oneOverN).reciprocal().multiply2(this.k - this.a).add2(this.a);
    }
}
