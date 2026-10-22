package org.apache.commons.math3.genetics;

import org.apache.commons.math3.exception.NumberIsTooSmallException;

/* JADX INFO: loaded from: classes6.dex */
public class FixedGenerationCount implements StoppingCondition {
    private final int maxGenerations;
    private int numGenerations;

    public FixedGenerationCount(int r3) throws NumberIsTooSmallException {
        this.numGenerations = 0;
        if (r3 <= 0) goto L7;
        this.maxGenerations = r3;
        return;
    L7:
        throw new NumberIsTooSmallException(Integer.valueOf(r3), 1, true);
    }

    @Override // org.apache.commons.math3.genetics.StoppingCondition
    public boolean isSatisfied(Population r3) {
        int r4 = this.numGenerations;
        if (r4 >= this.maxGenerations) goto L6;
        this.numGenerations = r4 + 1;
        return false;
    L6:
        return true;
    }

    public int getNumGenerations() {
        return this.numGenerations;
    }
}
