package org.apache.commons.math3.util;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public class CentralPivotingStrategy implements PivotingStrategyInterface, Serializable {
    private static final long serialVersionUID = 20140713;

    public CentralPivotingStrategy() {
    }

    @Override // org.apache.commons.math3.util.PivotingStrategyInterface
    public int pivotIndex(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        int r4 = r3 - r2;
        MathArrays.verifyValues(r1, r2, r4);
        return r2 + (r4 / 2);
    }
}
