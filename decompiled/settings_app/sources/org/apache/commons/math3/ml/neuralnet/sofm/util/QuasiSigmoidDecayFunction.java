package org.apache.commons.math3.ml.neuralnet.sofm.util;

import org.apache.commons.math3.analysis.function.Logistic;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;

/* JADX INFO: loaded from: classes6.dex */
public class QuasiSigmoidDecayFunction {
    private final double scale;
    private final Logistic sigmoid;

    public QuasiSigmoidDecayFunction(double r19, double r21, long r23) {
        if (r19 <= 0.0d) goto L15;
        if (r21 >= 0.0d) goto L13;
        if (r23 <= 1) goto L11;
        Logistic r12 = new Logistic(r19, r23, (4.0d * r21) / r19, 1.0d, 0.0d, 1.0d);
        this.sigmoid = r12;
        this.scale = r19 / r12.value(0.0d);
        return;
    L11:
        throw new NotStrictlyPositiveException(Long.valueOf(r23));
    L13:
        throw new NumberIsTooLargeException(Double.valueOf(r21), 0, false);
    L15:
        throw new NotStrictlyPositiveException(Double.valueOf(r19));
    }

    public double value(long r3) {
        return this.scale * this.sigmoid.value(r3);
    }
}
