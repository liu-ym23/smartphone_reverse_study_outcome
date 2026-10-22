package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class TriangularDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20120112;
    private final double a;
    private final double b;
    private final double c;
    private final double solverAbsoluteAccuracy;

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return true;
    }

    public TriangularDistribution(double r9, double r11, double r13) throws NumberIsTooLargeException, NumberIsTooSmallException {
        this(new Well19937c(), r9, r11, r13);
    }

    public TriangularDistribution(RandomGenerator r2, double r3, double r5, double r7) throws NumberIsTooLargeException, NumberIsTooSmallException {
        super(r2);
        if (r3 >= r7) goto L15;
        if (r5 < r3) goto L13;
        if (r5 > r7) goto L11;
        this.a = r3;
        this.c = r5;
        this.b = r7;
        this.solverAbsoluteAccuracy = FastMath.max(FastMath.ulp(r3), FastMath.ulp(r7));
        return;
    L11:
        throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_TOO_LARGE, Double.valueOf(r5), Double.valueOf(r7), true);
    L13:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_TOO_SMALL, Double.valueOf(r5), Double.valueOf(r3), true);
    L15:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(r3), Double.valueOf(r7), false);
    }

    public double getMode() {
        return this.c;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r12) {
        double r0 = this.a;
        if (r12 >= r0) goto L6;
        return 0.0d;
    L6:
        if (r0 > r12) goto L11;
        double r7 = this.c;
        if (r12 >= r7) goto L11;
        return ((r12 - r0) * 2.0d) / ((this.b - r0) * (r7 - r0));
    L11:
        double r8 = this.c;
        if (r12 != r8) goto L16;
        return 2.0d / (this.b - r0);
    L16:
        if (r8 >= r12) goto L21;
        double r9 = this.b;
        if (r12 > r9) goto L21;
        return ((r9 - r12) * 2.0d) / ((r9 - r0) * (r9 - r8));
    L21:
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r12) {
        double r0 = this.a;
        if (r12 >= r0) goto L7;
        return 0.0d;
    L7:
        if (r0 > r12) goto L12;
        double r2 = this.c;
        if (r12 >= r2) goto L12;
        return ((r12 - r0) * (r12 - r0)) / ((this.b - r0) * (r2 - r0));
    L12:
        double r3 = this.c;
        if (r12 != r3) goto L17;
        return (r3 - r0) / (this.b - r0);
    L17:
        if (r3 >= r12) goto L22;
        double r7 = this.b;
        if (r12 <= r7) goto L21;
        return 1.0d;
    L21:
        return 1.0d - (((r7 - r12) * (r7 - r12)) / ((r7 - r0) * (r7 - r3)));
    L22:
        return 1.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return ((this.a + this.b) + this.c) / 3.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.a;
        double r4 = this.b;
        double r2 = (r0 * r0) + (r4 * r4);
        double r6 = this.c;
        return ((((r2 + (r6 * r6)) - (r0 * r4)) - (r0 * r6)) - (r4 * r6)) / 18.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.a;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return this.b;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r13) throws OutOfRangeException {
        if (r13 < 0.0d) goto L20;
        if (r13 > 1.0d) goto L20;
        if (r13 == 0.0d) goto L9;
        if (r13 == 1.0d) goto L12;
        double r0 = this.c;
        double r4 = this.a;
        double r8 = this.b;
        if (r13 >= ((r0 - r4) / (r8 - r4))) goto L18;
        return r4 + FastMath.sqrt((r13 * (r8 - r4)) * (r0 - r4));
    L18:
        return r8 - FastMath.sqrt(((1.0d - r13) * (r8 - r4)) * (r8 - r0));
    L12:
        return this.b;
    L9:
        return this.a;
    L20:
        throw new OutOfRangeException(Double.valueOf(r13), 0, 1);
    }
}
