package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes4.dex */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = null;
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets;
    private byte[] luminances;

    static {
        EMPTY = new byte[0];
    }

    public GlobalHistogramBinarizer(LuminanceSource r1) {
        super(r1);
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    @Override // com.google.zxing.Binarizer
    public BitArray getBlackRow(int r10, BitArray r11) throws NotFoundException {
        LuminanceSource r0 = getLuminanceSource();
        int r1 = r0.getWidth();
        if (r11 != null) goto L5;
    L8:
        r11 = new BitArray(r1);
    L9:
        initArrays(r1);
        byte[] r12 = r0.getRow(r10, this.luminances);
        int[] r9 = this.buckets;
        int r2 = 0;
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L13;
        int r4 = (r12[r3] & 255) >> 3;
        r9[r4] = r9[r4] + 1;
        r3 = r3 + 1;
        goto L11
    L13:
        int r13 = estimateBlackPoint(r9);
        if (r1 >= 3) goto L20;
    L15:
        if (r2 >= r1) goto L27;
        if ((r12[r2] & 255) >= r13) goto L19;
        r11.set(r2);
    L19:
        r2 = r2 + 1;
    L27:
        return r11;
    L20:
        int r5 = r12[0] & 255;
        int r6 = 1;
        int r7 = r5;
        int r8 = r12[1] & 255;
    L22:
        if (r6 >= (r1 - 1)) goto L27;
        int r14 = r6 + 1;
        int r15 = r12[r14] & 255;
        if (((((r8 << 2) - r7) - r15) / 2) >= r13) goto L26;
        r11.set(r6);
    L26:
        r7 = r8;
        r6 = r14;
        r8 = r15;
        goto L22
    L5:
        if (r11.getSize() < r1) goto L8;
        r11.clear();
        goto L9
    }

    @Override // com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource r0 = getLuminanceSource();
        int r1 = r0.getWidth();
        int r2 = r0.getHeight();
        BitMatrix r3 = new BitMatrix(r1, r2);
        initArrays(r1);
        int[] r4 = this.buckets;
        int r6 = 1;
    L4:
        if (r6 >= 5) goto L9;
        byte[] r8 = r0.getRow((r2 * r6) / 5, this.luminances);
        int r9 = (r1 << 2) / 5;
        int r7 = r1 / 5;
    L6:
        if (r7 >= r9) goto L8;
        int r10 = (r8[r7] & 255) >> 3;
        r4[r10] = r4[r10] + 1;
        r7 = r7 + 1;
        goto L6
    L8:
        r6 = r6 + 1;
        goto L4
    L9:
        int r12 = estimateBlackPoint(r4);
        byte[] r5 = r0.getMatrix();
        int r11 = 0;
    L10:
        if (r11 >= r2) goto L18;
        int r13 = r11 * r1;
        int r14 = 0;
    L12:
        if (r14 >= r1) goto L17;
        if ((r5[r13 + r14] & 255) >= r12) goto L16;
        r3.set(r14, r11);
    L16:
        r14 = r14 + 1;
        goto L12
    L17:
        r11 = r11 + 1;
        goto L10
    L18:
        return r3;
    }

    @Override // com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource r1) {
        return new GlobalHistogramBinarizer(r1);
    }

    private void initArrays(int r3) {
        if (this.luminances.length >= r3) goto L5;
        this.luminances = new byte[r3];
    L5:
        int r0 = 0;
    L7:
        if (r0 >= 32) goto L9;
        this.buckets[r0] = 0;
        r0 = r0 + 1;
        goto L7
    }

    private static int estimateBlackPoint(int[] r9) throws NotFoundException {
        int r0 = r9.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r2 >= r0) goto L10;
        int r6 = r9[r2];
        if (r6 <= r3) goto L7;
        r5 = r2;
        r3 = r6;
    L7:
        if (r6 <= r4) goto L9;
        r4 = r6;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        int r7 = 0;
        int r8 = 0;
    L11:
        if (r1 >= r0) goto L16;
        int r10 = r1 - r5;
        int r11 = (r9[r1] * r10) * r10;
        if (r11 <= r8) goto L15;
        r7 = r1;
        r8 = r11;
    L15:
        r1 = r1 + 1;
        goto L11
    L16:
        if (r5 > r7) goto L20;
        int r12 = r5;
        r5 = r7;
        r7 = r12;
    L20:
        if ((r5 - r7) <= (r0 / 16)) goto L30;
        int r13 = r5 - 1;
        int r14 = -1;
        int r15 = r13;
    L22:
        if (r13 <= r7) goto L28;
        int r16 = r13 - r7;
        int r17 = ((r16 * r16) * (r5 - r13)) * (r4 - r9[r13]);
        if (r17 <= r14) goto L26;
        r15 = r13;
        r14 = r17;
    L26:
        r13 = r13 - 1;
        goto L22
    L28:
        return r15 << 3;
    L30:
        throw NotFoundException.getNotFoundInstance();
    }
}
