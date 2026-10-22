package org.apache.commons.math3.ml.neuralnet.sofm.util;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ExponentialDecayFunction {
    private final double a;
    private final double oneOverB;

    public ExponentialDecayFunction(double r4, double r6, long r8) {
        if (r4 <= 0.0d) goto L19;
        if (r6 <= 0.0d) goto L17;
        if (r6 >= r4) goto L15;
        if (r8 <= 0) goto L13;
        this.a = r4;
        this.oneOverB = (-FastMath.log(r6 / r4)) / r8;
        return;
    L13:
        throw new NotStrictlyPositiveException(Long.valueOf(r8));
    L15:
        throw new NumberIsTooLargeException(Double.valueOf(r6), Double.valueOf(r4), false);
    L17:
        throw new NotStrictlyPositiveException(Double.valueOf(r6));
    L19:
        throw new NotStrictlyPositiveException(Double.valueOf(r4));
    }

    public double value(long r5) {
        return this.a * FastMath.exp((-r5) * this.oneOverB);
    }
}
