package org.apache.commons.math3.optim;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleBounds implements OptimizationData {
    private final double[] lower;
    private final double[] upper;

    public SimpleBounds(double[] r1, double[] r2) {
        this.lower = (double[]) r1.clone();
        this.upper = (double[]) r2.clone();
    }

    public double[] getLower() {
        return (double[]) this.lower.clone();
    }

    public double[] getUpper() {
        return (double[]) this.upper.clone();
    }

    public static SimpleBounds unbounded(int r3) {
        double[] r0 = new double[r3];
        Arrays.fill(r0, Double.NEGATIVE_INFINITY);
        double[] r4 = new double[r3];
        Arrays.fill(r4, Double.POSITIVE_INFINITY);
        return new SimpleBounds(r0, r4);
    }
}
