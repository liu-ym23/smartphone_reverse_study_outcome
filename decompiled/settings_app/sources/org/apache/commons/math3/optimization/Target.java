package org.apache.commons.math3.optimization;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Target implements OptimizationData {
    private final double[] target;

    public Target(double[] r1) {
        this.target = (double[]) r1.clone();
    }

    public double[] getTarget() {
        return (double[]) this.target.clone();
    }
}
