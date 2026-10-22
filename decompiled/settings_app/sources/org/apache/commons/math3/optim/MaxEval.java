package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;

/* JADX INFO: loaded from: classes6.dex */
public class MaxEval implements OptimizationData {
    private final int maxEval;

    public MaxEval(int r1) {
        if (r1 <= 0) goto L7;
        this.maxEval = r1;
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r1));
    }

    public int getMaxEval() {
        return this.maxEval;
    }

    public static MaxEval unlimited() {
        return new MaxEval(Integer.MAX_VALUE);
    }
}
