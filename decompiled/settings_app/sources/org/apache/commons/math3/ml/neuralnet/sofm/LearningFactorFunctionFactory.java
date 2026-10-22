package org.apache.commons.math3.ml.neuralnet.sofm;

import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public class LearningFactorFunctionFactory {
    private LearningFactorFunctionFactory() {
    }

    public static LearningFactorFunction exponentialDecay(final double r8, final double r10, final long r12) {
        if (r8 <= 0.0d) goto L9;
        if (r8 > 1.0d) goto L9;
        return new AnonymousClass1(r8, r10, r12);
    L9:
        throw new OutOfRangeException(Double.valueOf(r8), 0, 1);
    }

    public static LearningFactorFunction quasiSigmoidDecay(final double r8, final double r10, final long r12) {
        if (r8 <= 0.0d) goto L9;
        if (r8 > 1.0d) goto L9;
        return new AnonymousClass2(r8, r10, r12);
    L9:
        throw new OutOfRangeException(Double.valueOf(r8), 0, 1);
    }
}
