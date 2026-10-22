package org.apache.commons.math3.util;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public class MedianOf3PivotingStrategy implements PivotingStrategyInterface, Serializable {
    private static final long serialVersionUID = 20140713;

    public MedianOf3PivotingStrategy() {
    }

    @Override // org.apache.commons.math3.util.PivotingStrategyInterface
    public int pivotIndex(double[] r7, int r8, int r9) throws MathIllegalArgumentException {
        MathArrays.verifyValues(r7, r8, r9 - r8);
        int r10 = r9 - 1;
        int r6 = ((r10 - r8) / 2) + r8;
        double r0 = r7[r8];
        double r2 = r7[r6];
        double r4 = r7[r10];
        if (r0 >= r2) goto L12;
        if (r2 >= r4) goto L8;
        return r6;
    L8:
        if (r0 < r4) goto L10;
        return r8;
    L10:
        return r10;
    L12:
        if (r0 >= r4) goto L15;
        return r8;
    L15:
        if (r2 >= r4) goto L18;
        return r10;
    L18:
        return r6;
    }
}
