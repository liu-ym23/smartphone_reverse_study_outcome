package org.apache.commons.math3.analysis.function;

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
public class HarmonicOscillator implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double amplitude;
    private final double omega;
    private final double phase;

    public static class Parametric implements ParametricUnivariateFunction {
        public Parametric() {
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double r3, double... r5) throws NullArgumentException, DimensionMismatchException {
            validateParameters(r5);
            return HarmonicOscillator.access$000((r3 * r5[1]) + r5[2], r5[0]);
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double r9, double... r11) throws NullArgumentException, DimensionMismatchException {
            validateParameters(r11);
            double r0 = r11[0];
            double r3 = (r11[1] * r9) + r11[2];
            double r6 = HarmonicOscillator.access$000(r3, 1.0d);
            double r1 = (-r0) * FastMath.sin(r3);
            return new double[]{r6, r9 * r1, r1};
        }

        private void validateParameters(double[] r2) throws NullArgumentException, DimensionMismatchException {
            if (r2 == null) goto L9;
            if (r2.length != 3) goto L7;
            return;
        L7:
            throw new DimensionMismatchException(r2.length, 3);
        L9:
            throw new NullArgumentException();
        }
    }

    static /* synthetic */ double access$000(double r0, double r2) {
        return value(r0, r2);
    }

    public HarmonicOscillator(double r1, double r3, double r5) {
        this.amplitude = r1;
        this.omega = r3;
        this.phase = r5;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r3) {
        return value((this.omega * r3) + this.phase, this.amplitude);
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    private static double value(double r0, double r2) {
        return r2 * FastMath.cos(r0);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r10) throws DimensionMismatchException {
        double r0 = r10.getValue();
        int r2 = r10.getOrder() + 1;
        double[] r4 = new double[r2];
        double r5 = (this.omega * r0) + this.phase;
        r4[0] = this.amplitude * FastMath.cos(r5);
        if (r2 <= 1) goto L8;
        r4[1] = ((-this.amplitude) * this.omega) * FastMath.sin(r5);
        double r1 = this.omega;
        double r6 = (-r1) * r1;
        int r9 = 2;
    L5:
        if (r9 >= r2) goto L8;
        r4[r9] = r4[r9 - 2] * r6;
        r9 = r9 + 1;
    L8:
        return r10.compose(r4);
    }
}
