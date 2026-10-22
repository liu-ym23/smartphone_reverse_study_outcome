package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
final class AI013x0x1xDecoder extends AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final String dateCode;
    private final String firstAIdigits;

    AI013x0x1xDecoder(BitArray r1, String r2, String r3) {
        super(r1);
        this.dateCode = r3;
        this.firstAIdigits = r2;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() != 84) goto L7;
        StringBuilder r0 = new StringBuilder();
        encodeCompressedGtin(r0, 8);
        encodeCompressedWeight(r0, 48, 20);
        encodeCompressedDate(r0, 68);
        return r0.toString();
    L7:
        throw NotFoundException.getNotFoundInstance();
    }

    private void encodeCompressedDate(StringBuilder r4, int r5) {
        int r6 = getGeneralDecoder().extractNumericValueFromBitArray(r5, 16);
        if (r6 != 38400) goto L5;
        return;
    L5:
        r4.append('(');
        r4.append(this.dateCode);
        r4.append(')');
        int r3 = r6 % 32;
        int r7 = r6 / 32;
        int r0 = (r7 % 12) + 1;
        int r8 = r7 / 12;
        if ((r8 / 10) != 0) goto L8;
        r4.append('0');
    L8:
        r4.append(r8);
        if ((r0 / 10) != 0) goto L11;
        r4.append('0');
    L11:
        r4.append(r0);
        if ((r3 / 10) != 0) goto L14;
        r4.append('0');
    L14:
        r4.append(r3);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder r2, int r3) {
        r2.append('(');
        r2.append(this.firstAIdigits);
        r2.append(r3 / 100000);
        r2.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int r1) {
        return r1 % 100000;
    }
}
