package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
public final class EAN8Reader extends UPCEANReader {
    private final int[] decodeMiddleCounters;

    public EAN8Reader() {
        this.decodeMiddleCounters = new int[4];
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(BitArray r8, int[] r9, StringBuilder r10) throws NotFoundException {
        int[] r7 = this.decodeMiddleCounters;
        r7[0] = 0;
        r7[1] = 0;
        r7[2] = 0;
        r7[3] = 0;
        int r2 = r8.getSize();
        int r11 = r9[1];
        int r3 = 0;
    L4:
        if (r3 >= 4) goto L10;
        if (r11 >= r2) goto L10;
        r10.append((char) (decodeDigit(r8, r7, r11, L_PATTERNS) + 48));
        int r4 = r7.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L9;
        r11 = r11 + r7[r5];
        r5 = r5 + 1;
        goto L7
    L9:
        r3 = r3 + 1;
    L10:
        int r12 = findGuardPattern(r8, r11, true, MIDDLE_PATTERN)[1];
        int r1 = 0;
    L11:
        if (r1 >= 4) goto L17;
        if (r12 >= r2) goto L17;
        r10.append((char) (decodeDigit(r8, r7, r12, L_PATTERNS) + 48));
        int r6 = r7.length;
        int r13 = 0;
    L14:
        if (r13 >= r6) goto L16;
        r12 = r12 + r7[r13];
        r13 = r13 + 1;
        goto L14
    L16:
        r1 = r1 + 1;
    L17:
        return r12;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
