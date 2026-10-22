package org.apache.commons.math3.ml.neuralnet.sofm;

/* JADX INFO: loaded from: classes6.dex */
public class NeighbourhoodSizeFunctionFactory {
    private NeighbourhoodSizeFunctionFactory() {
    }

    public static NeighbourhoodSizeFunction exponentialDecay(final double r8, final double r10, final long r12) {
        return new AnonymousClass1(r8, r10, r12);
    }

    public static NeighbourhoodSizeFunction quasiSigmoidDecay(final double r8, final double r10, final long r12) {
        return new AnonymousClass2(r8, r10, r12);
    }
}
