package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
public final class EAN13Reader extends UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = null;
    private final int[] decodeMiddleCounters;

    static {
        FIRST_DIGIT_ENCODINGS = new int[]{0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    }

    public EAN13Reader() {
        this.decodeMiddleCounters = new int[4];
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(BitArray r10, int[] r11, StringBuilder r12) throws NotFoundException {
        int[] r9 = this.decodeMiddleCounters;
        r9[0] = 0;
        r9[1] = 0;
        r9[2] = 0;
        r9[3] = 0;
        int r2 = r10.getSize();
        int r13 = r11[1];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= 6) goto L13;
        if (r13 >= r2) goto L13;
        int r5 = decodeDigit(r10, r9, r13, L_AND_G_PATTERNS);
        r12.append((char) ((r5 % 10) + 48));
        int r6 = r9.length;
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L10;
        r13 = r13 + r9[r7];
        r7 = r7 + 1;
        goto L7
    L10:
        if (r5 < 10) goto L12;
        r4 = r4 | (1 << (5 - r3));
    L12:
        r3 = r3 + 1;
    L13:
        determineFirstDigit(r12, r4);
        int r14 = findGuardPattern(r10, r13, true, MIDDLE_PATTERN)[1];
        int r1 = 0;
    L14:
        if (r1 >= 6) goto L20;
        if (r14 >= r2) goto L20;
        r12.append((char) (decodeDigit(r10, r9, r14, L_PATTERNS) + 48));
        int r8 = r9.length;
        int r15 = 0;
    L17:
        if (r15 >= r8) goto L19;
        r14 = r14 + r9[r15];
        r15 = r15 + 1;
        goto L17
    L19:
        r1 = r1 + 1;
    L20:
        return r14;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }

    private static void determineFirstDigit(StringBuilder r3, int r4) throws NotFoundException {
        int r1 = 0;
    L4:
        if (r1 >= 10) goto L11;
        if (r4 == FIRST_DIGIT_ENCODINGS[r1]) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        r3.insert(0, (char) (r1 + 48));
        return;
    L11:
        throw NotFoundException.getNotFoundInstance();
    }
}
