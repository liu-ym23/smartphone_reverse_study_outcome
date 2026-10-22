package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultGridSampler extends GridSampler {
    public DefaultGridSampler() {
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix r6, int r7, int r8, float r9, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18, float r19, float r20, float r21, float r22, float r23, float r24) throws NotFoundException {
        return sampleGrid(r6, r7, r8, PerspectiveTransform.quadrilateralToQuadrilateral(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24));
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix r8, int r9, int r10, PerspectiveTransform r11) throws NotFoundException {
        if (r9 <= 0) goto L20;
        if (r10 <= 0) goto L20;
        BitMatrix r7 = new BitMatrix(r9, r10);
        int r12 = r9 * 2;
        float[] r0 = new float[r12];
        int r2 = 0;
    L5:
        if (r2 >= r10) goto L18;
        float r3 = r2 + 0.5f;
        int r5 = 0;
    L7:
        if (r5 >= r12) goto L9;
        r0[r5] = (r5 / 2) + 0.5f;
        r0[r5 + 1] = r3;
        r5 = r5 + 2;
        goto L7
    L9:
        r11.transformPoints(r0);
        checkAndNudgePoints(r8, r0);
        int r4 = 0;
    L10:
        if (r4 >= r12) goto L17;
        if (r8.get((int) r0[r4], (int) r0[r4 + 1]) == false) goto L14;
        r7.set(r4 / 2, r2);     // Catch: ArrayIndexOutOfBoundsException -> L15
    L14:
        r4 = r4 + 2;
    L16:
        throw NotFoundException.getNotFoundInstance();
    L17:
        r2 = r2 + 1;
        goto L5
    L18:
        return r7;
    L20:
        throw NotFoundException.getNotFoundInstance();
    }
}
