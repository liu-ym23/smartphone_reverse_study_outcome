package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes4.dex */
public final class URLTOResultParser extends ResultParser {
    public URLTOResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result r3) {
        String r2 = getMassagedText(r3);
        String r0 = null;
        if (r2.startsWith("urlto:") == false) goto L5;
    L7:
        int r4 = r2.indexOf(58, 6);
        if (r4 >= 0) goto L10;
        return null;
    L10:
        if (r4 <= 6) goto L14;
        r0 = r2.substring(6, r4);
    L14:
        return new URIParsedResult(r2.substring(r4 + 1), r0);
    L5:
        if (r2.startsWith("URLTO:") == true) goto L7;
        return null;
    }
}
