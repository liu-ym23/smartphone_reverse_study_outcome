package org.apache.commons.math3.analysis.function;

import java.util.Arrays;
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
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class Gaussian implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double i2s2;
    private final double is;
    private final double mean;
    private final double norm;

    public static class Parametric implements ParametricUnivariateFunction {
        public Parametric() {
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double r9, double... r11) throws NullArgumentException, DimensionMismatchException, NotStrictlyPositiveException {
            validateParameters(r11);
            double r2 = r9 - r11[1];
            double r8 = r11[2];
            double r4 = r11[0];
            return Gaussian.access$000(r2, r4, 1.0d / ((2.0d * r8) * r8));
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double r21, double... r23) throws NullArgumentException, DimensionMismatchException, NotStrictlyPositiveException {
            validateParameters(r23);
            double r2 = r23[0];
            double r5 = r21 - r23[1];
            double r14 = r23[2];
            double r18 = 1.0d / ((r14 * 2.0d) * r14);
            double r7 = Gaussian.access$000(r5, 1.0d, r18);
            double r3 = (((r2 * r7) * 2.0d) * r18) * r5;
            return new double[]{r7, r3, (r5 * r3) / r14};
        }

        private void validateParameters(double[] r5) throws NullArgumentException, DimensionMismatchException, NotStrictlyPositiveException {
            if (r5 == null) goto L13;
            if (r5.length != 3) goto L11;
            if (r5[2] <= 0.0d) goto L9;
            return;
        L9:
            throw new NotStrictlyPositiveException(Double.valueOf(r5[2]));
        L11:
            throw new DimensionMismatchException(r5.length, 3);
        L13:
            throw new NullArgumentException();
        }
    }

    static /* synthetic */ double access$000(double r0, double r2, double r4) {
        return value(r0, r2, r4);
    }

    public Gaussian(double r3, double r5, double r7) throws NotStrictlyPositiveException {
        if (r7 <= 0.0d) goto L7;
        this.norm = r3;
        this.mean = r5;
        double r4 = 1.0d / r7;
        this.is = r4;
        this.i2s2 = (0.5d * r4) * r4;
        return;
    L7:
        throw new NotStrictlyPositiveException(Double.valueOf(r7));
    }

    public Gaussian(double r12, double r14) throws NotStrictlyPositiveException {
        this(1.0d / (FastMath.sqrt(6.283185307179586d) * r14), r12, r14);
    }

    public Gaussian() {
        this(0.0d, 1.0d);
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r9) {
        return value(r9 - this.mean, this.norm, this.i2s2);
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    private static double value(double r2, double r4, double r6) {
        return r4 * FastMath.exp(((-r2) * r2) * r6);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r23) throws DimensionMismatchException {
        double r1 = this.is * (r23.getValue() - this.mean);
        int r4 = 1;
        int r3 = r23.getOrder() + 1;
        double[] r5 = new double[r3];
        double[] r6 = new double[r3];
        r6[0] = 1.0d;
        double r7 = r1 * r1;
        double r10 = this.norm * FastMath.exp((-0.5d) * r7);
        if (r10 > Precision.SAFE_MIN) goto L6;
        Arrays.fill(r5, 0.0d);
    L23:
        return r23.compose(r5);
    L6:
        r5[0] = r10;
        int r12 = 1;
    L7:
        if (r12 >= r3) goto L23;
        r6[r12] = -r6[r12 - 1];
        int r13 = r12;
        double r14 = 0.0d;
    L9:
        if (r13 < 0) goto L18;
        r14 = (r14 * r7) + r6[r13];
        if (r13 <= 2) goto L13;
        int r8 = r13 - 1;
        double r18 = r7;
        r6[r13 - 2] = (((double) r8) * r6[r8]) - r6[r13 - 3];
        r4 = 1;
    L17:
        r13 = r13 - 2;
        r7 = r18;
        goto L9
    L13:
        r18 = r7;
        r4 = 1;
        if (r13 != 2) goto L17;
        r6[0] = r6[1];
        goto L17
    L18:
        double r19 = r7;
        if ((r12 & 1) != r4) goto L21;
        r14 = r14 * r1;
    L21:
        r10 = r10 * this.is;
        r5[r12] = r14 * r10;
        r12 = r12 + 1;
        r7 = r19;
        goto L7
    }
}
