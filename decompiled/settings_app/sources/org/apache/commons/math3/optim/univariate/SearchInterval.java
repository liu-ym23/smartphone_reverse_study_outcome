package org.apache.commons.math3.optim.univariate;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
public class SearchInterval implements OptimizationData {
    private final double lower;
    private final double start;
    private final double upper;

    public SearchInterval(double r2, double r4, double r6) {
        if (r2 >= r4) goto L13;
        if (r6 < r2) goto L11;
        if (r6 > r4) goto L11;
        this.lower = r2;
        this.upper = r4;
        this.start = r6;
        return;
    L11:
        throw new OutOfRangeException(Double.valueOf(r6), Double.valueOf(r2), Double.valueOf(r4));
    L13:
        throw new NumberIsTooLargeException(Double.valueOf(r2), Double.valueOf(r4), false);
    }

    public SearchInterval(double r12, double r14) {
        this(r12, r14, (r12 + r14) * 0.5d);
    }

    public double getMin() {
        return this.lower;
    }

    public double getMax() {
        return this.upper;
    }

    public double getStartValue() {
        return this.start;
    }
}
