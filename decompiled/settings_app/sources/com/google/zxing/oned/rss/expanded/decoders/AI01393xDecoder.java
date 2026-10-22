package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
final class AI01393xDecoder extends AI01decoder {
    private static final int FIRST_THREE_DIGITS_SIZE = 10;
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    AI01393xDecoder(BitArray r1) {
        super(r1);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() < 48) goto L13;
        StringBuilder r0 = new StringBuilder();
        encodeCompressedGtin(r0, 8);
        int r2 = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
        r0.append("(393");
        r0.append(r2);
        r0.append(')');
        int r3 = getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
        if ((r3 / 100) != 0) goto L8;
        r0.append('0');
    L8:
        if ((r3 / 10) != 0) goto L10;
        r0.append('0');
    L10:
        r0.append(r3);
        r0.append(getGeneralDecoder().decodeGeneralPurposeField(60, null).getNewString());
        return r0.toString();
    L13:
        throw NotFoundException.getNotFoundInstance();
    }
}
