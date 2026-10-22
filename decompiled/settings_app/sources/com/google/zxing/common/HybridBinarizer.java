package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes4.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    private static int cap(int r0, int r1, int r2) {
        if (r0 >= r1) goto L4;
        return r1;
    L4:
        if (r0 <= r2) goto L6;
        return r2;
    L6:
        return r0;
    }

    public HybridBinarizer(LuminanceSource r1) {
        super(r1);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix r0 = this.matrix;
        if (r0 == null) goto L5;
        return r0;
    L5:
        LuminanceSource r1 = getLuminanceSource();
        int r4 = r1.getWidth();
        int r5 = r1.getHeight();
        if (r4 < 40) goto L15;
        if (r5 < 40) goto L15;
        byte[] r2 = r1.getMatrix();
        int r3 = r4 >> 3;
        if ((r4 & 7) == 0) goto L11;
        r3 = r3 + 1;
    L11:
        int r6 = r3;
        int r7 = r5 >> 3;
        if ((r5 & 7) == 0) goto L14;
        r7 = r7 + 1;
    L14:
        int r8 = r7;
        int[][] r9 = calculateBlackPoints(r2, r6, r8, r4, r5);
        BitMatrix r10 = new BitMatrix(r4, r5);
        calculateThresholdForBlock(r2, r6, r8, r4, r5, r9, r10);
        this.matrix = r10;
    L17:
        return this.matrix;
    L15:
        this.matrix = super.getBlackMatrix();
        goto L17
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource r1) {
        return new HybridBinarizer(r1);
    }

    private static void calculateThresholdForBlock(byte[] r17, int r18, int r19, int r20, int r21, int[][] r22, BitMatrix r23) {
        int r2 = r21 - 8;
        int r9 = r20 - 8;
        int r11 = 0;
    L3:
        if (r11 >= r19) goto L19;
        int r3 = r11 << 3;
        if (r3 <= r2) goto L7;
        int r12 = r2;
    L8:
        int r14 = cap(r11, 2, r19 - 3);
        int r15 = 0;
    L9:
        if (r15 >= r18) goto L18;
        int r4 = r15 << 3;
        if (r4 <= r9) goto L13;
        int r5 = r9;
    L14:
        int r6 = cap(r15, 2, r18 - 3);
        int r7 = -2;
        int r8 = 0;
    L15:
        if (r7 > 2) goto L17;
        int[] r10 = r22[r14 + r7];
        r8 = r8 + ((((r10[r6 - 2] + r10[r6 - 1]) + r10[r6]) + r10[r6 + 1]) + r10[r6 + 2]);
        r7 = r7 + 1;
        goto L15
    L17:
        thresholdBlock(r17, r5, r12, r8 / 25, r20, r23);
        r15 = r15 + 1;
        goto L9
    L13:
        r5 = r4;
        goto L14
    L18:
        r11 = r11 + 1;
        goto L3
    L7:
        r12 = r3;
        goto L8
    }

    private static void thresholdBlock(byte[] r7, int r8, int r9, int r10, int r11, BitMatrix r12) {
        int r0 = (r9 * r11) + r8;
        int r2 = 0;
    L4:
        if (r2 >= 8) goto L12;
        int r4 = 0;
    L6:
        if (r4 >= 8) goto L11;
        if ((r7[r0 + r4] & 255) > r10) goto L10;
        r12.set(r8 + r4, r9 + r2);
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        r2 = r2 + 1;
        r0 = r0 + r11;
        goto L4
    }

    private static int[][] calculateBlackPoints(byte[] r17, int r18, int r19, int r20, int r21) {
        int r2 = 8;
        int r3 = r21 - 8;
        int r4 = r20 - 8;
        char r5 = 2;
        boolean r7 = true;
        int r8 = 0;
        int[][] r6 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r19, r18});
        int r9 = 0;
    L3:
        if (r9 >= r19) goto L41;
        int r10 = r9 << 3;
        if (r10 <= r3) goto L7;
        r10 = r3;
    L7:
        int r11 = r8;
    L8:
        if (r11 >= r18) goto L40;
        int r12 = r11 << 3;
        if (r12 <= r4) goto L12;
        r12 = r4;
    L12:
        int r13 = (r10 * r20) + r12;
        int r14 = r8;
        int r15 = r14;
        int r16 = r15;
        int r22 = 255;
    L13:
        if (r14 >= r2) goto L30;
        int r23 = r16;
        int r24 = 0;
    L15:
        if (r24 >= r2) goto L23;
        int r25 = r17[r13 + r24] & 255;
        r15 = r15 + r25;
        if (r25 >= r22) goto L19;
        r22 = r25;
    L19:
        if (r25 <= r23) goto L21;
        r23 = r25;
    L21:
        r24 = r24 + 1;
        r2 = 8;
        goto L15
    L23:
        if ((r23 - r22) <= 24) goto L29;
    L24:
        r14 = r14 + 1;
        r13 = r13 + r20;
        int r26 = 8;
        if (r14 >= 8) goto L29;
        int r27 = 0;
    L27:
        if (r27 >= r26) goto L24;
        r15 = r15 + (r17[r13 + r27] & 255);
        r27 = r27 + 1;
        r26 = 8;
    L29:
        r14 = r14 + 1;
        r13 = r13 + r20;
        r16 = r23;
        r7 = true;
        r2 = 8;
        goto L13
    L30:
        boolean r28 = r7;
        int r29 = r15 >> 6;
        if ((r16 - r22) > 24) goto L38;
        r29 = r22 / 2;
        if (r9 <= 0) goto L38;
        if (r11 <= 0) goto L38;
        int[] r30 = r6[r9 - 1];
        int r110 = r11 - 1;
        char r111 = 2;
        int r31 = ((r30[r11] + (r6[r9][r110] * 2)) + r30[r110]) / 4;
        if (r22 >= r31) goto L39;
        r29 = r31;
    L39:
        r6[r9][r11] = r29;
        r11 = r11 + 1;
        r7 = r28;
        r5 = r111;
        r2 = 8;
        r8 = 0;
    L38:
        r111 = 2;
        goto L39
    L40:
        r9 = r9 + 1;
        r2 = 8;
        r8 = 0;
        goto L3
    L41:
        return r6;
    }
}
