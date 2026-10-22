package org.apache.commons.math3.optimization;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class InitialGuess implements OptimizationData {
    private final double[] init;

    public InitialGuess(double[] r1) {
        this.init = (double[]) r1.clone();
    }

    public double[] getInitialGuess() {
        return (double[]) this.init.clone();
    }
}
