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
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class EnumeratedIntegerDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20130308;
    protected final EnumeratedDistribution<Integer> innerDistribution;

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public EnumeratedIntegerDistribution(int[] r2, double[] r3) throws DimensionMismatchException, NotPositiveException, MathArithmeticException, NotFiniteNumberException, NotANumberException {
        this(new Well19937c(), r2, r3);
    }

    public EnumeratedIntegerDistribution(RandomGenerator r2, int[] r3, double[] r4) throws DimensionMismatchException, NotPositiveException, MathArithmeticException, NotFiniteNumberException, NotANumberException {
        super(r2);
        this.innerDistribution = new EnumeratedDistribution(r2, createDistribution(r3, r4));
    }

    public EnumeratedIntegerDistribution(RandomGenerator r8, int[] r9) {
        super(r8);
        HashMap r0 = new HashMap();
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        int r4 = r9[r3];
        Integer r5 = (Integer) r0.get(Integer.valueOf(r4));
        if (r5 != null) goto L7;
        r5 = 0;
    L7:
        r0.put(Integer.valueOf(r4), Integer.valueOf(r5.intValue() + 1));
        r3 = r3 + 1;
        goto L3
    L8:
        int r6 = r0.size();
        double r7 = r9.length;
        int[] r10 = new int[r6];
        double[] r11 = new double[r6];
        Iterator r12 = r0.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();
        r10[r2] = ((Integer) r13.getKey()).intValue();
        r11[r2] = ((double) ((Integer) r13.getValue()).intValue()) / r7;
        r2 = r2 + 1;
        goto L10
    L12:
        this.innerDistribution = new EnumeratedDistribution(r8, createDistribution(r10, r11));
    }

    public EnumeratedIntegerDistribution(int[] r2) {
        this(new Well19937c(), r2);
    }

    private static List<Pair<Integer, Double>> createDistribution(int[] r6, double[] r7) {
        if (r6.length != r7.length) goto L10;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L8;
        r0.add(new Pair(Integer.valueOf(r6[r1]), Double.valueOf(r7[r1])));
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        throw new DimensionMismatchException(r7.length, r6.length);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r1) {
        return this.innerDistribution.probability(Integer.valueOf(r1));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r5) {
        Iterator<Pair<Integer, Double>> r4 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r4.hasNext() == false) goto L8;
        Pair<Integer, Double> r2 = r4.next();
        if (r2.getKey().intValue() > r5) goto L4;
        r0 = r0 + r2.getValue().doubleValue();
        goto L4
    L8:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        Iterator<Pair<Integer, Double>> r7 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Pair<Integer, Double> r2 = r7.next();
        r0 = r0 + (r2.getValue().doubleValue() * ((double) r2.getKey().intValue()));
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        Iterator<Pair<Integer, Double>> r9 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
        double r2 = 0.0d;
    L4:
        if (r9.hasNext() == false) goto L7;
        Pair<Integer, Double> r4 = r9.next();
        r2 = r2 + (r4.getValue().doubleValue() * ((double) r4.getKey().intValue()));
        r0 = r0 + ((r4.getValue().doubleValue() * ((double) r4.getKey().intValue())) * ((double) r4.getKey().intValue()));
        goto L4
    L7:
        return r0 - (r2 * r2);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        Iterator<Pair<Integer, Double>> r6 = this.innerDistribution.getPmf().iterator();
        int r0 = Integer.MAX_VALUE;
    L4:
        if (r6.hasNext() == false) goto L10;
        Pair<Integer, Double> r1 = r6.next();
        if (r1.getKey().intValue() >= r0) goto L4;
        if (r1.getValue().doubleValue() <= 0.0d) goto L4;
        r0 = r1.getKey().intValue();
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        Iterator<Pair<Integer, Double>> r6 = this.innerDistribution.getPmf().iterator();
        int r0 = Integer.MIN_VALUE;
    L4:
        if (r6.hasNext() == false) goto L10;
        Pair<Integer, Double> r1 = r6.next();
        if (r1.getKey().intValue() <= r0) goto L4;
        if (r1.getValue().doubleValue() <= 0.0d) goto L4;
        r0 = r1.getKey().intValue();
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution, org.apache.commons.math3.distribution.IntegerDistribution
    public int sample() {
        return this.innerDistribution.sample().intValue();
    }
}
