package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes4.dex */
final class AI01320xDecoder extends AI013x0xDecoder {
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int r1) {
        if (r1 >= 10000) goto L6;
        return r1;
    L6:
        return r1 - 10000;
    }

    AI01320xDecoder(BitArray r1) {
        super(r1);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder r1, int r2) {
        if (r2 >= 10000) goto L6;
        r1.append("(3202)");
        return;
    L6:
        r1.append("(3203)");
    }
}
