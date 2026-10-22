package org.apache.commons.math3.distribution;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class MixtureMultivariateNormalDistribution extends MixtureMultivariateRealDistribution<MultivariateNormalDistribution> {
    public MixtureMultivariateNormalDistribution(double[] r1, double[][] r2, double[][][] r3) {
        super(createComponents(r1, r2, r3));
    }

    public MixtureMultivariateNormalDistribution(List<Pair<Double, MultivariateNormalDistribution>> r1) {
        super(r1);
    }

    public MixtureMultivariateNormalDistribution(RandomGenerator r1, List<Pair<Double, MultivariateNormalDistribution>> r2) throws NotPositiveException, DimensionMismatchException {
        super(r1, r2);
    }

    private static List<Pair<Double, MultivariateNormalDistribution>> createComponents(double[] r6, double[][] r7, double[][][] r8) {
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        MultivariateNormalDistribution r2 = new MultivariateNormalDistribution(r7[r1], r8[r1]);
        r0.add(new Pair(Double.valueOf(r6[r1]), r2));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
