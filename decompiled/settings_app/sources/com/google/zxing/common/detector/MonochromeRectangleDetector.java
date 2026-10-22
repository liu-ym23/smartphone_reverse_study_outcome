package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix r1) {
        this.image = r1;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int r11 = this.image.getHeight();
        int r12 = this.image.getWidth();
        int r13 = r11 / 2;
        int r14 = r12 / 2;
        int r9 = Math.max(1, r11 / 256);
        int r8 = Math.max(1, r12 / 256);
        int r7 = -r9;
        int r17 = r14 / 2;
        int r20 = ((int) findCornerFromCenter(r14, 0, 0, r12, r13, r7, 0, r11, r17).getY()) - 1;
        int r19 = r13 / 2;
        ResultPoint r22 = findCornerFromCenter(r14, -r8, 0, r12, r13, 0, r20, r11, r19);
        int r23 = ((int) r22.getX()) - 1;
        ResultPoint r15 = findCornerFromCenter(r14, r8, r23, r12, r13, 0, r20, r11, r19);
        int r110 = ((int) r15.getX()) + 1;
        ResultPoint r16 = findCornerFromCenter(r14, 0, r23, r110, r13, r9, r20, r11, r17);
        return new ResultPoint[]{findCornerFromCenter(r14, 0, r23, r110, r13, r7, r20, ((int) r16.getY()) + 1, r14 / 4), r22, r15, r16};
    }

    private ResultPoint findCornerFromCenter(int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24) throws NotFoundException {
        int[] r2 = null;
        int r11 = r16;
        int r10 = r20;
    L3:
        if (r10 >= r23) goto L47;
        if (r10 < r22) goto L47;
        if (r11 >= r19) goto L47;
        if (r11 < r18) goto L47;
        if (r17 != 0) goto L12;
        int[] r3 = blackWhiteRange(r10, r24, r18, r19, true);
    L13:
        if (r3 == null) goto L14;
        r10 = r10 + r21;
        r11 = r11 + r17;
        r2 = r3;
        goto L3
    L14:
        if (r2 == null) goto L44;
        char r4 = 1;
        if (r17 != 0) goto L30;
        int r12 = r10 - r21;
        if (r2[0] >= r16) goto L29;
        if (r2[1] <= r16) goto L27;
        if (r21 <= 0) goto L25;
        r4 = 0;
    L25:
        return new ResultPoint(r2[r4], r12);
    L27:
        return new ResultPoint(r2[0], r12);
    L29:
        return new ResultPoint(r2[1], r12);
    L30:
        int r13 = r11 - r17;
        if (r2[0] >= r20) goto L42;
        if (r2[1] <= r20) goto L40;
        float r1 = r13;
        if (r17 >= 0) goto L38;
        r4 = 0;
    L38:
        return new ResultPoint(r1, r2[r4]);
    L40:
        return new ResultPoint(r13, r2[0]);
    L42:
        return new ResultPoint(r13, r2[1]);
    L44:
        throw NotFoundException.getNotFoundInstance();
    L12:
        r3 = blackWhiteRange(r11, r24, r22, r23, false);
    L47:
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] blackWhiteRange(int r6, int r7, int r8, int r9, boolean r10) {
        int r0 = (r8 + r9) / 2;
        int r2 = r0;
    L3:
        if (r2 < r8) goto L27;
        BitMatrix r3 = this.image;
        if (r10 == false) goto L10;
        if (r3.get(r2, r6) == false) goto L12;
    L11:
        r2 = r2 - 1;
    L12:
        int r4 = r2;
    L13:
        r4 = r4 - 1;
        if (r4 < r8) goto L22;
        BitMatrix r5 = this.image;
        if (r10 == true) goto L18;
        if (r5.get(r6, r4) == false) goto L13;
    L18:
        if (r5.get(r4, r6) == false) goto L13;
    L22:
        int r11 = r2 - r4;
        if (r4 < r8) goto L27;
        if (r11 > r7) goto L27;
        r2 = r4;
        goto L3
    L10:
        if (r3.get(r6, r2) == false) goto L12;
    L27:
        int r12 = r2 + 1;
    L28:
        if (r0 >= r9) goto L52;
        BitMatrix r13 = this.image;
        if (r10 == false) goto L35;
        if (r13.get(r0, r6) == false) goto L37;
    L36:
        r0 = r0 + 1;
    L37:
        int r14 = r0;
    L38:
        r14 = r14 + 1;
        if (r14 >= r9) goto L47;
        BitMatrix r15 = this.image;
        if (r10 == true) goto L43;
        if (r15.get(r6, r14) == false) goto L38;
    L43:
        if (r15.get(r14, r6) == false) goto L38;
    L47:
        int r16 = r14 - r0;
        if (r14 >= r9) goto L52;
        if (r16 > r7) goto L52;
        r0 = r14;
        goto L28
    L35:
        if (r13.get(r6, r0) == false) goto L37;
    L52:
        int r1 = r0 - 1;
        if (r1 > r12) goto L55;
        return null;
    L55:
        return new int[]{r12, r1};
    }
}
