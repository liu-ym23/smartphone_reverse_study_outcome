package org.apache.commons.math3.distribution;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.MultivariateRealDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class MixtureMultivariateRealDistribution<T extends MultivariateRealDistribution> extends AbstractMultivariateRealDistribution {
    private final List<T> distribution;
    private final double[] weight;

    public MixtureMultivariateRealDistribution(List<Pair<Double, T>> r2) {
        this(new Well19937c(), r2);
    }

    public MixtureMultivariateRealDistribution(RandomGenerator r11, List<Pair<Double, T>> r12) {
        int r0 = 0;
        super(r11, r12.get(0).getSecond().getDimension());
        int r13 = r12.size();
        int r1 = getDimension();
        int r4 = 0;
        double r5 = 0.0d;
    L3:
        if (r4 >= r13) goto L14;
        Pair<Double, T> r7 = r12.get(r4);
        if (r7.getSecond().getDimension() != r1) goto L12;
        if (r7.getFirst().doubleValue() < 0.0d) goto L10;
        r5 = r5 + r7.getFirst().doubleValue();
        r4 = r4 + 1;
        goto L3
    L10:
        throw new NotPositiveException(r7.getFirst());
    L12:
        throw new DimensionMismatchException(r7.getSecond().getDimension(), r1);
    L14:
        if (Double.isInfinite(r5) == true) goto L20;
        this.distribution = new ArrayList();
        this.weight = new double[r13];
    L16:
        if (r0 >= r13) goto L18;
        Pair<Double, T> r2 = r12.get(r0);
        this.weight[r0] = r2.getFirst().doubleValue() / r5;
        this.distribution.add(r2.getSecond());
        r0 = r0 + 1;
        goto L16
    L18:
        return;
    L20:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double density(double[] r8) {
        double r0 = 0.0d;
        int r2 = 0;
    L3:
        double[] r3 = this.weight;
        if (r2 >= r3.length) goto L6;
        r0 = r0 + (r3[r2] * this.distribution.get(r2).density(r8));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.AbstractMultivariateRealDistribution, org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double[] sample() {
        double r0 = this.random.nextDouble();
        double r2 = 0.0d;
        int r4 = 0;
    L3:
        double[] r5 = this.weight;
        if (r4 >= r5.length) goto L9;
        r2 = r2 + r5[r4];
        if (r0 <= r2) goto L7;
        r4 = r4 + 1;
        goto L3
    L7:
        double[] r1 = this.distribution.get(r4).sample();
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return this.distribution.get(this.weight.length - 1).sample();
    L9:
        r1 = null;
        goto L10
    }

    @Override // org.apache.commons.math3.distribution.AbstractMultivariateRealDistribution, org.apache.commons.math3.distribution.MultivariateRealDistribution
    public void reseedRandomGenerator(long r5) {
        super.reseedRandomGenerator(r5);
        int r0 = 0;
    L4:
        if (r0 >= this.distribution.size()) goto L6;
        T r1 = this.distribution.get(r0);
        r0 = r0 + 1;
        r1.reseedRandomGenerator(((long) r0) + r5);
        goto L4
    }

    public List<Pair<Double, T>> getComponents() {
        ArrayList r0 = new ArrayList(this.weight.length);
        int r1 = 0;
    L4:
        if (r1 >= this.weight.length) goto L6;
        r0.add(new Pair(Double.valueOf(this.weight[r1]), this.distribution.get(r1)));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
