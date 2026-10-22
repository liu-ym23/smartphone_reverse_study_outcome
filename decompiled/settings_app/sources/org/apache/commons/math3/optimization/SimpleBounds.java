package org.apache.commons.math3.optimization;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
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
}
