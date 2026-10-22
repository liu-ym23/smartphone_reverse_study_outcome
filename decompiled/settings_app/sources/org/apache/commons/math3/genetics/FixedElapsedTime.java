package org.apache.commons.math3.genetics;

import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

/* JADX INFO: loaded from: classes6.dex */
public class FixedElapsedTime implements StoppingCondition {
    private long endTime;
    private final long maxTimePeriod;

    public FixedElapsedTime(long r2) throws NumberIsTooSmallException {
        this(r2, TimeUnit.SECONDS);
    }

    public FixedElapsedTime(long r3, TimeUnit r5) throws NumberIsTooSmallException {
        this.endTime = -1;
        if (r3 < 0) goto L7;
        this.maxTimePeriod = r5.toNanos(r3);
        return;
    L7:
        throw new NumberIsTooSmallException(Long.valueOf(r3), 0, true);
    }

    @Override // org.apache.commons.math3.genetics.StoppingCondition
    public boolean isSatisfied(Population r5) {
        if (this.endTime >= 0) goto L6;
        this.endTime = System.nanoTime() + this.maxTimePeriod;
    L6:
        if (System.nanoTime() < this.endTime) goto L8;
        return true;
    L8:
        return false;
    }
}
