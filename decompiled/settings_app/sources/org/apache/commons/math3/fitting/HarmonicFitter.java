package org.apache.commons.math3.fitting;

import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class HarmonicFitter extends CurveFitter<HarmonicOscillator.Parametric> {

    public static class ParameterGuesser {
        private final double a;
        private final double omega;
        private final double phi;

        public ParameterGuesser(WeightedObservedPoint[] r5) {
            if (r5.length < 4) goto L7;
            WeightedObservedPoint[] r6 = sortObservations(r5);
            double[] r0 = guessAOmega(r6);
            this.a = r0[0];
            this.omega = r0[1];
            this.phi = guessPhi(r6);
            return;
        L7:
            throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(r5.length), 4, true);
        }

        public double[] guess() {
            return new double[]{this.a, this.omega, this.phi};
        }

        private WeightedObservedPoint[] sortObservations(WeightedObservedPoint[] r8) {
            WeightedObservedPoint[] r7 = (WeightedObservedPoint[]) r8.clone();
            WeightedObservedPoint r9 = r7[0];
            int r0 = 1;
        L4:
            if (r0 >= r7.length) goto L18;
            WeightedObservedPoint r1 = r7[r0];
            if (r1.getX() >= r9.getX()) goto L16;
            int r10 = r0 - 1;
            WeightedObservedPoint r2 = r7[r10];
        L8:
            if (r10 < 0) goto L15;
            if (r1.getX() >= r2.getX()) goto L15;
            r7[r10 + 1] = r2;
            int r3 = r10 - 1;
            if (r10 == 0) goto L14;
            r2 = r7[r3];
        L14:
            r10 = r3;
        L15:
            r7[r10 + 1] = r1;
            r9 = r7[r0];
        L17:
            r0 = r0 + 1;
            goto L4
        L16:
            r9 = r1;
            goto L17
        L18:
            return r7;
        }

        private double[] guessAOmega(WeightedObservedPoint[] r36) {
            double[] r1 = new double[2];
            double r3 = r36[0].getX();
            double r5 = r36[0].getY();
            double r21 = r3;
            double r11 = 0.0d;
            double r13 = 0.0d;
            double r15 = 0.0d;
            double r17 = 0.0d;
            double r19 = 0.0d;
            double r23 = 0.0d;
            double r25 = 0.0d;
            int r10 = 1;
        L4:
            if (r10 >= r36.length) goto L6;
            double r27 = r36[r10].getX();
            double r29 = r36[r10].getY();
            double r22 = r27 - r21;
            double r31 = r29 - r5;
            double r33 = ((((r5 * r5) + (r5 * r29)) + (r29 * r29)) * r22) / 3.0d;
            double r6 = r27 - r3;
            r23 = r23 + r33;
            r25 = r25 + ((r31 * r31) / r22);
            r19 = r19 + (r6 * r6);
            r11 = r11 + (r23 * r23);
            r15 = r15 + (r6 * r23);
            r13 = r13 + (r6 * r25);
            r17 = r17 + (r23 * r25);
            r10 = r10 + 1;
            r21 = r27;
            r5 = r29;
            goto L4
        L6:
            double r4 = (r11 * r13) - (r15 * r17);
            double r14 = (r13 * r15) - (r17 * r19);
            double r110 = (r19 * r11) - (r15 * r15);
            double r7 = r4 / r14;
            if (r7 < 0.0d) goto L16;
            double r8 = r14 / r110;
            if (r8 < 0.0d) goto L16;
            if (r14 == 0.0d) goto L15;
            r1[0] = FastMath.sqrt(r7);
            r1[1] = FastMath.sqrt(r8);
        L29:
            return r1;
        L15:
            throw new MathIllegalStateException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
        L16:
            double r9 = r36[r36.length - 1].getX() - r36[0].getX();
            if (r9 == 0.0d) goto L31;
            r1[1] = 6.283185307179586d / r9;
            double r12 = Double.POSITIVE_INFINITY;
            double r16 = Double.NEGATIVE_INFINITY;
            int r18 = 1;
        L20:
            if (r18 >= r36.length) goto L28;
            double r20 = r36[r18].getY();
            if (r20 >= r12) goto L25;
            r12 = r20;
        L25:
            if (r20 <= r16) goto L27;
            r16 = r20;
        L27:
            r18 = r18 + 1;
            goto L20
        L28:
            r1[0] = (r16 - r12) * 0.5d;
            goto L29
        L31:
            throw new ZeroException();
        }

        private double guessPhi(WeightedObservedPoint[] r24) {
            double r3 = r24[0].getX();
            double r5 = r24[0].getY();
            double r7 = 0.0d;
            int r2 = 1;
            double r9 = 0.0d;
        L4:
            if (r2 >= r24.length) goto L7;
            double r11 = r24[r2].getX();
            double r13 = r24[r2].getY();
            double r6 = (r13 - r5) / (r11 - r3);
            double r4 = this.omega * r11;
            double r15 = FastMath.cos(r4);
            double r8 = FastMath.sin(r4);
            double r12 = this.omega;
            r9 = r9 + (((r12 * r13) * r15) - (r6 * r8));
            r7 = r7 + (((r12 * r13) * r8) + (r6 * r15));
            r2 = r2 + 1;
            r5 = r13;
            r3 = r11;
            goto L4
        L7:
            return FastMath.atan2(-r7, r9);
        }
    }

    public HarmonicFitter(MultivariateVectorOptimizer r1) {
        super(r1);
    }

    public double[] fit(double[] r2) {
        return fit(new HarmonicOscillator.Parametric(), r2);
    }

    public double[] fit() {
        return fit(new ParameterGuesser(getObservations()).guess());
    }
}
