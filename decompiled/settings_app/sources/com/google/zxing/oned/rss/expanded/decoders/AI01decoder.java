package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
abstract class AI01decoder extends AbstractExpandedDecoder {
    static final int GTIN_SIZE = 40;

    AI01decoder(BitArray r1) {
        super(r1);
    }

    final void encodeCompressedGtin(StringBuilder r3, int r4) {
        r3.append("(01)");
        int r0 = r3.length();
        r3.append('9');
        encodeCompressedGtinWithoutAI(r3, r4, r0);
    }

    final void encodeCompressedGtinWithoutAI(StringBuilder r5, int r6, int r7) {
        int r0 = 0;
    L4:
        if (r0 >= 4) goto L12;
        int r1 = getGeneralDecoder().extractNumericValueFromBitArray((r0 * 10) + r6, 10);
        if ((r1 / 100) != 0) goto L9;
        r5.append('0');
    L9:
        if ((r1 / 10) != 0) goto L11;
        r5.append('0');
    L11:
        r5.append(r1);
        r0 = r0 + 1;
        goto L4
    L12:
        appendCheckDigit(r5, r7);
    }

    private static void appendCheckDigit(StringBuilder r5, int r6) {
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= 13) goto L9;
        int r3 = r5.charAt(r1 + r6) - '0';
        if ((r1 & 1) != 0) goto L8;
        r3 = r3 * 3;
    L8:
        r2 = r2 + r3;
        r1 = r1 + 1;
        goto L4
    L9:
        int r4 = 10 - (r2 % 10);
        if (r4 == 10) goto L13;
        r0 = r4;
    L13:
        r5.append(r0);
    }
}
