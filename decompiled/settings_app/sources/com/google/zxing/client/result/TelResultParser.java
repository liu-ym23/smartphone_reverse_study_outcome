package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes4.dex */
public final class TelResultParser extends ResultParser {
    public TelResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public TelParsedResult parse(Result r4) {
        String r3 = getMassagedText(r4);
        if (r3.startsWith("tel:") == true) goto L8;
        if (r3.startsWith("TEL:") == true) goto L8;
        return null;
    L8:
        if (r3.startsWith("TEL:") == false) goto L10;
        String r5 = "tel:" + r3.substring(4);
    L11:
        int r0 = r3.indexOf(63, 4);
        if (r0 >= 0) goto L14;
        String r6 = r3.substring(4);
    L16:
        return new TelParsedResult(r6, r5, null);
    L14:
        r6 = r3.substring(4, r0);
        goto L16
    L10:
        r5 = r3;
        goto L11
    }
}
