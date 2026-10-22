package org.apache.commons.math3.optim.linear;

import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;

/* JADX INFO: loaded from: classes6.dex */
public class SolutionCallback implements OptimizationData {
    private SimplexTableau tableau;

    public SolutionCallback() {
    }

    void setTableau(SimplexTableau r1) {
        this.tableau = r1;
    }

    public PointValuePair getSolution() {
        SimplexTableau r0 = this.tableau;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSolution();
    }

    public boolean isSolutionOptimal() {
        SimplexTableau r0 = this.tableau;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOptimal();
    }
}
