package org.apache.commons.math3.distribution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class EnumeratedRealDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20130308;
    protected final EnumeratedDistribution<Double> innerDistribution;

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

    public EnumeratedRealDistribution(double[] r2, double[] r3) throws DimensionMismatchException, NotPositiveException, MathArithmeticException, NotFiniteNumberException, NotANumberException {
        this(new Well19937c(), r2, r3);
    }

    public EnumeratedRealDistribution(RandomGenerator r2, double[] r3, double[] r4) throws DimensionMismatchException, NotPositiveException, MathArithmeticException, NotFiniteNumberException, NotANumberException {
        super(r2);
        this.innerDistribution = new EnumeratedDistribution(r2, createDistribution(r3, r4));
    }

    public EnumeratedRealDistribution(RandomGenerator r9, double[] r10) {
        super(r9);
        HashMap r0 = new HashMap();
        int r1 = r10.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        double r4 = r10[r3];
        Integer r6 = (Integer) r0.get(Double.valueOf(r4));
        if (r6 != null) goto L7;
        r6 = 0;
    L7:
        r0.put(Double.valueOf(r4), Integer.valueOf(r6.intValue() + 1));
        r3 = r3 + 1;
        goto L3
    L8:
        int r5 = r0.size();
        double r7 = r10.length;
        double[] r11 = new double[r5];
        double[] r8 = new double[r5];
        Iterator r12 = r0.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11[r2] = ((Double) r13.getKey()).doubleValue();
        r8[r2] = ((double) ((Integer) r13.getValue()).intValue()) / r7;
        r2 = r2 + 1;
        goto L10
    L12:
        this.innerDistribution = new EnumeratedDistribution(r9, createDistribution(r11, r8));
    }

    public EnumeratedRealDistribution(double[] r2) {
        this(new Well19937c(), r2);
    }

    private static List<Pair<Double, Double>> createDistribution(double[] r6, double[] r7) {
        if (r6.length != r7.length) goto L10;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L8;
        r0.add(new Pair(Double.valueOf(r6[r1]), Double.valueOf(r7[r1])));
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        throw new DimensionMismatchException(r7.length, r6.length);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double probability(double r1) {
        return this.innerDistribution.probability(Double.valueOf(r1));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r1) {
        return probability(r1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r6) {
        Iterator<Pair<Double, Double>> r5 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r5.hasNext() == false) goto L8;
        Pair<Double, Double> r2 = r5.next();
        if (r2.getKey().doubleValue() > r6) goto L4;
        r0 = r0 + r2.getValue().doubleValue();
        goto L4
    L8:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r10) throws OutOfRangeException {
        if (r10 < 0.0d) goto L16;
        if (r10 > 1.0d) goto L16;
        double r2 = getSupportLowerBound();
        Iterator<Pair<Double, Double>> r9 = this.innerDistribution.getPmf().iterator();
        double r4 = 0.0d;
    L8:
        if (r9.hasNext() == false) goto L14;
        Pair<Double, Double> r6 = r9.next();
        if (r6.getValue().doubleValue() == 0.0d) goto L8;
        r4 = r4 + r6.getValue().doubleValue();
        r2 = r6.getKey().doubleValue();
        if (r4 < r10) goto L8;
    L14:
        return r2;
    L16:
        throw new OutOfRangeException(Double.valueOf(r10), 0, 1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        Iterator<Pair<Double, Double>> r7 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Pair<Double, Double> r2 = r7.next();
        r0 = r0 + (r2.getValue().doubleValue() * r2.getKey().doubleValue());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        Iterator<Pair<Double, Double>> r9 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
        double r2 = 0.0d;
    L4:
        if (r9.hasNext() == false) goto L7;
        Pair<Double, Double> r4 = r9.next();
        r2 = r2 + (r4.getValue().doubleValue() * r4.getKey().doubleValue());
        r0 = r0 + ((r4.getValue().doubleValue() * r4.getKey().doubleValue()) * r4.getKey().doubleValue());
        goto L4
    L7:
        return r0 - (r2 * r2);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        Iterator<Pair<Double, Double>> r7 = this.innerDistribution.getPmf().iterator();
        double r0 = Double.POSITIVE_INFINITY;
    L4:
        if (r7.hasNext() == false) goto L10;
        Pair<Double, Double> r2 = r7.next();
        if (r2.getKey().doubleValue() >= r0) goto L4;
        if (r2.getValue().doubleValue() <= 0.0d) goto L4;
        r0 = r2.getKey().doubleValue();
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        Iterator<Pair<Double, Double>> r7 = this.innerDistribution.getPmf().iterator();
        double r0 = Double.NEGATIVE_INFINITY;
    L4:
        if (r7.hasNext() == false) goto L10;
        Pair<Double, Double> r2 = r7.next();
        if (r2.getKey().doubleValue() <= r0) goto L4;
        if (r2.getValue().doubleValue() <= 0.0d) goto L4;
        r0 = r2.getKey().doubleValue();
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        return this.innerDistribution.sample().doubleValue();
    }
}
