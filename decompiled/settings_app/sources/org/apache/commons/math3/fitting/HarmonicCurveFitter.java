package org.apache.commons.math3.fitting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresBuilder;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class HarmonicCurveFitter extends AbstractCurveFitter {
    private static final HarmonicOscillator.Parametric FUNCTION = null;
    private final double[] initialGuess;
    private final int maxIter;

    public static class ParameterGuesser {
        private final double a;
        private final double omega;
        private final double phi;

        public ParameterGuesser(Collection<WeightedObservedPoint> r6) {
            if (r6.size() < 4) goto L7;
            WeightedObservedPoint[] r7 = (WeightedObservedPoint[]) sortObservations(r6).toArray(new WeightedObservedPoint[0]);
            double[] r2 = guessAOmega(r7);
            this.a = r2[0];
            this.omega = r2[1];
            this.phi = guessPhi(r7);
            return;
        L7:
            throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(r6.size()), 4, true);
        }

        public double[] guess() {
            return new double[]{this.a, this.omega, this.phi};
        }

        private List<WeightedObservedPoint> sortObservations(Collection<WeightedObservedPoint> r9) {
            ArrayList r8 = new ArrayList(r9);
            WeightedObservedPoint r10 = (WeightedObservedPoint) r8.get(0);
            int r0 = r8.size();
            int r1 = 1;
        L3:
            if (r1 >= r0) goto L17;
            WeightedObservedPoint r2 = (WeightedObservedPoint) r8.get(r1);
            if (r2.getX() >= r10.getX()) goto L15;
            int r11 = r1 - 1;
            WeightedObservedPoint r3 = (WeightedObservedPoint) r8.get(r11);
        L7:
            if (r11 < 0) goto L14;
            if (r2.getX() >= r3.getX()) goto L14;
            r8.set(r11 + 1, r3);
            int r4 = r11 - 1;
            if (r11 == 0) goto L13;
            r3 = (WeightedObservedPoint) r8.get(r4);
        L13:
            r11 = r4;
        L14:
            r8.set(r11 + 1, r2);
            r10 = (WeightedObservedPoint) r8.get(r1);
        L16:
            r1 = r1 + 1;
            goto L3
        L15:
            r10 = r2;
            goto L16
        L17:
            return r8;
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

    static {
        FUNCTION = new HarmonicOscillator.Parametric();
    }

    private HarmonicCurveFitter(double[] r1, int r2) {
        this.initialGuess = r1;
        this.maxIter = r2;
    }

    public static HarmonicCurveFitter create() {
        return new HarmonicCurveFitter(null, Integer.MAX_VALUE);
    }

    public HarmonicCurveFitter withStartPoint(double[] r2) {
        return new HarmonicCurveFitter((double[]) r2.clone(), this.maxIter);
    }

    public HarmonicCurveFitter withMaxIterations(int r2) {
        return new HarmonicCurveFitter(this.initialGuess, r2);
    }

    @Override // org.apache.commons.math3.fitting.AbstractCurveFitter
    protected LeastSquaresProblem getProblem(Collection<WeightedObservedPoint> r8) {
        int r0 = r8.size();
        double[] r1 = new double[r0];
        double[] r2 = new double[r0];
        Iterator<WeightedObservedPoint> r3 = r8.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        WeightedObservedPoint r5 = r3.next();
        r1[r4] = r5.getY();
        r2[r4] = r5.getWeight();
        r4 = r4 + 1;
        goto L4
    L6:
        AbstractCurveFitter.TheoreticalValuesFunction r6 = new AbstractCurveFitter.TheoreticalValuesFunction(FUNCTION, r8);
        double[] r7 = this.initialGuess;
        if (r7 != null) goto L11;
        r7 = new ParameterGuesser(r8).guess();
    L11:
        return new LeastSquaresBuilder().maxEvaluations(Integer.MAX_VALUE).maxIterations(this.maxIter).start(r7).target(r1).weight(new DiagonalMatrix(r2)).model(r6.getModelFunction(), r6.getModelFunctionJacobian()).build();
    }
}
