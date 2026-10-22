package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ReedSolomonEncoder {
    private final List<GenericGFPoly> cachedGenerators;
    private final GenericGF field;

    public ReedSolomonEncoder(GenericGF r5) {
        this.field = r5;
        ArrayList r0 = new ArrayList();
        this.cachedGenerators = r0;
        r0.add(new GenericGFPoly(r5, new int[]{1}));
    }

    private GenericGFPoly buildGenerator(int r9) {
        if (r9 < this.cachedGenerators.size()) goto L8;
        List<GenericGFPoly> r0 = this.cachedGenerators;
        GenericGFPoly r1 = r0.get(r0.size() - 1);
        int r2 = this.cachedGenerators.size();
    L5:
        if (r2 > r9) goto L8;
        GenericGF r4 = this.field;
        r1 = r1.multiply(new GenericGFPoly(r4, new int[]{1, r4.exp((r2 - 1) + r4.getGeneratorBase())}));
        this.cachedGenerators.add(r1);
        r2 = r2 + 1;
    L8:
        return this.cachedGenerators.get(r9);
    }

    public void encode(int[] r6, int r7) {
        if (r7 == 0) goto L13;
        int r0 = r6.length - r7;
        if (r0 <= 0) goto L11;
        GenericGFPoly r1 = buildGenerator(r7);
        int[] r2 = new int[r0];
        System.arraycopy(r6, 0, r2, 0, r0);
        int[] r5 = new GenericGFPoly(this.field, r2).multiplyByMonomial(r7, 1).divide(r1)[1].getCoefficients();
        int r8 = r7 - r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r8) goto L8;
        r6[r0 + r3] = 0;
        r3 = r3 + 1;
        goto L6
    L8:
        System.arraycopy(r5, 0, r6, r0 + r8, r5.length);
        return;
    L11:
        throw new IllegalArgumentException("No data bytes provided");
    L13:
        throw new IllegalArgumentException("No error correction bytes");
    }
}
