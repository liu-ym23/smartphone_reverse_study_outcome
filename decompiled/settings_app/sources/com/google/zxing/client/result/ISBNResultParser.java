package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

/* JADX INFO: loaded from: classes4.dex */
public final class ISBNResultParser extends ResultParser {
    public ISBNResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public ISBNParsedResult parse(Result r3) {
        if (r3.getBarcodeFormat() == BarcodeFormat.EAN_13) goto L5;
        return null;
    L5:
        String r2 = getMassagedText(r3);
        if (r2.length() == 13) goto L9;
        return null;
    L9:
        if (r2.startsWith("978") == true) goto L14;
        if (r2.startsWith("979") == true) goto L14;
        return null;
    L14:
        return new ISBNParsedResult(r2);
    }
}
