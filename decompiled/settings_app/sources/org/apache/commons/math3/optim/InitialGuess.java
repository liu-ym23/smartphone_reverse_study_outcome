package org.apache.commons.math3.optim;

/* JADX INFO: loaded from: classes6.dex */
public class InitialGuess implements OptimizationData {
    private final double[] init;

    public InitialGuess(double[] r1) {
        this.init = (double[]) r1.clone();
    }

    public double[] getInitialGuess() {
        return (double[]) this.init.clone();
    }
}
