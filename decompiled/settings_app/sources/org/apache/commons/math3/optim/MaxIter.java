package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;

/* JADX INFO: loaded from: classes6.dex */
public class MaxIter implements OptimizationData {
    private final int maxIter;

    public MaxIter(int r1) {
        if (r1 <= 0) goto L7;
        this.maxIter = r1;
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r1));
    }

    public int getMaxIter() {
        return this.maxIter;
    }

    public static MaxIter unlimited() {
        return new MaxIter(Integer.MAX_VALUE);
    }
}
