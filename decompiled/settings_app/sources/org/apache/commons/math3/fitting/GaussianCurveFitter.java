package org.apache.commons.math3.fitting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.analysis.function.Gaussian;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresBuilder;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class GaussianCurveFitter extends AbstractCurveFitter {
    private static final Gaussian.Parametric FUNCTION = null;
    private final double[] initialGuess;
    private final int maxIter;

    public static class ParameterGuesser {
        private final double mean;
        private final double norm;
        private final double sigma;

        private boolean isBetween(double r1, double r3, double r5) {
            if (r1 < r3) goto L7;
            if (r1 > r5) goto L7;
        L10:
            return true;
        L7:
            if (r1 >= r5) goto L9;
        L11:
            return false;
        L9:
            if (r1 > r3) goto L11;
            goto L10
        }

        public ParameterGuesser(Collection<WeightedObservedPoint> r5) {
            if (r5 == null) goto L11;
            if (r5.size() < 3) goto L9;
            double[] r6 = basicGuess((WeightedObservedPoint[]) sortObservations(r5).toArray(new WeightedObservedPoint[0]));
            this.norm = r6[0];
            this.mean = r6[1];
            this.sigma = r6[2];
            return;
        L9:
            throw new NumberIsTooSmallException(Integer.valueOf(r5.size()), 3, true);
        L11:
            throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
        }

        public double[] guess() {
            return new double[]{this.norm, this.mean, this.sigma};
        }

        private List<WeightedObservedPoint> sortObservations(Collection<WeightedObservedPoint> r2) {
            ArrayList r0 = new ArrayList(r2);
            Collections.sort(r0, new AnonymousClass1(this));
            return r0;
        }

        private double[] basicGuess(WeightedObservedPoint[] r21) {
            int r7 = findMaxY(r21);
            double r8 = r21[r7].getY();
            double r10 = r21[r7].getX();
            double r14 = r8 + ((r10 - r8) / 2.0d);
            double r0 = interpolateXAtY(r21, r7, 1, r14) - interpolateXAtY(r21, r7, -1, r14);
        L7:
            return new double[]{r8, r10, r0 / (FastMath.sqrt(FastMath.log(2.0d) * 2.0d) * 2.0d)};
        L5:
            r0 = r21[r21.length - 1].getX() - r21[0].getX();
            goto L7
        }

        private int findMaxY(WeightedObservedPoint[] r6) {
            int r5 = 0;
            int r0 = 1;
        L4:
            if (r0 >= r6.length) goto L9;
            if (r6[r0].getY() <= r6[r5].getY()) goto L8;
            r5 = r0;
        L8:
            r0 = r0 + 1;
            goto L4
        L9:
            return r5;
        }

        private double interpolateXAtY(WeightedObservedPoint[] r5, int r6, int r7, double r8) throws OutOfRangeException {
            if (r7 == 0) goto L14;
            WeightedObservedPoint[] r4 = getInterpolationPointsForY(r5, r6, r7, r8);
            WeightedObservedPoint r9 = r4[0];
            WeightedObservedPoint r10 = r4[1];
            if (r9.getY() != r8) goto L8;
            return r9.getX();
        L8:
            if (r10.getY() != r8) goto L12;
            return r10.getX();
        L12:
            return r9.getX() + (((r8 - r9.getY()) * (r10.getX() - r9.getX())) / (r10.getY() - r9.getY()));
        L14:
            throw new ZeroException();
        }

        private WeightedObservedPoint[] getInterpolationPointsForY(WeightedObservedPoint[] r10, int r11, int r12, double r13) throws OutOfRangeException {
            if (r12 == 0) goto L20;
        L3:
            int r0 = r11 + r12;
            if (r12 >= 0) goto L8;
            if (r0 < 0) goto L18;
        L9:
            WeightedObservedPoint r1 = r10[r11];
            r11 = r11 + r12;
            WeightedObservedPoint r2 = r10[r11];
            if (isBetween(r13, r1.getY(), r2.getY()) == false) goto L3;
            if (r12 >= 0) goto L16;
            return new WeightedObservedPoint[]{r2, r1};
        L16:
            return new WeightedObservedPoint[]{r1, r2};
        L18:
            throw new OutOfRangeException(Double.valueOf(r13), Double.valueOf(Double.NEGATIVE_INFINITY), Double.valueOf(Double.POSITIVE_INFINITY));
        L8:
            if (r0 >= r10.length) goto L18;
        L20:
            throw new ZeroException();
        }
    }

    static {
        FUNCTION = new AnonymousClass1();
    }

    private GaussianCurveFitter(double[] r1, int r2) {
        this.initialGuess = r1;
        this.maxIter = r2;
    }

    public static GaussianCurveFitter create() {
        return new GaussianCurveFitter(null, Integer.MAX_VALUE);
    }

    public GaussianCurveFitter withStartPoint(double[] r2) {
        return new GaussianCurveFitter((double[]) r2.clone(), this.maxIter);
    }

    public GaussianCurveFitter withMaxIterations(int r2) {
        return new GaussianCurveFitter(this.initialGuess, r2);
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
