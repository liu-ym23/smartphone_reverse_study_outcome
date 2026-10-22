package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public class KthSelector implements Serializable {
    private static final int MIN_SELECT_SIZE = 15;
    private static final long serialVersionUID = 20140713;
    private final PivotingStrategyInterface pivotingStrategy;

    public KthSelector() {
        this.pivotingStrategy = new MedianOf3PivotingStrategy();
    }

    public KthSelector(PivotingStrategyInterface r1) throws NullArgumentException {
        MathUtils.checkNotNull(r1);
        this.pivotingStrategy = r1;
    }

    public PivotingStrategyInterface getPivotingStrategy() {
        return this.pivotingStrategy;
    }

    public double select(double[] r8, int[] r9, int r10) {
        int r0 = r8.length;
        int r2 = 0;
        if (r9 == null) goto L5;
        boolean r3 = true;
    L6:
        int r4 = 0;
    L8:
        if ((r0 - r2) <= 15) goto L34;
        if (r3 == true) goto L11;
    L15:
        int r5 = partition(r8, r2, r0, this.pivotingStrategy.pivotIndex(r8, r2, r0));
        if (r3 == true) goto L18;
    L20:
        if (r10 == r5) goto L22;
        if (r10 < r5) goto L24;
        int r6 = r5 + 1;
        int r7 = (r4 * 2) + 2;
        if (r3 == false) goto L32;
        int r11 = r9.length;
    L33:
        r4 = FastMath.min(r7, r11);
        r2 = r6;
        goto L8
    L32:
        r11 = r0;
        goto L33
    L24:
        int r12 = (r4 * 2) + 1;
        if (r3 == false) goto L27;
        int r1 = r9.length;
    L28:
        r4 = FastMath.min(r12, r1);
        r0 = r5;
        goto L8
    L27:
        r1 = r5;
        goto L28
    L22:
        return r8[r10];
    L18:
        if (r4 >= r9.length) goto L20;
        r9[r4] = r5;
        goto L20
    L11:
        if (r4 >= r9.length) goto L15;
        r5 = r9[r4];
        if (r5 < 0) goto L15;
    L34:
        Arrays.sort(r8, r2, r0);
        return r8[r10];
    L5:
        r3 = false;
        goto L6
    }

    private int partition(double[] r8, int r9, int r10, int r11) {
        double r0 = r8[r11];
        r8[r11] = r8[r9];
        int r7 = r9 + 1;
        int r12 = r10 - 1;
    L3:
        if (r7 >= r12) goto L14;
    L4:
        if (r7 >= r12) goto L8;
        if (r8[r12] <= r0) goto L8;
        r12 = r12 - 1;
    L8:
        if (r7 >= r12) goto L12;
        if (r8[r7] >= r0) goto L12;
        r7 = r7 + 1;
    L12:
        if (r7 >= r12) goto L3;
        double r2 = r8[r7];
        r8[r7] = r8[r12];
        r8[r12] = r2;
        r12 = r12 - 1;
        r7 = r7 + 1;
        goto L3
    L14:
        if (r7 < r10) goto L16;
    L17:
        r7 = r7 - 1;
    L18:
        r8[r9] = r8[r7];
        r8[r7] = r0;
        return r7;
    L16:
        if (r8[r7] <= r0) goto L18;
        goto L17
    }
}
