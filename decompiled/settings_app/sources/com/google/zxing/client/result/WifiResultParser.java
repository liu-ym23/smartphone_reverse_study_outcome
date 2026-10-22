package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes4.dex */
public final class WifiResultParser extends ResultParser {
    public WifiResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result r13) {
        String r12 = getMassagedText(r13);
        if (r12.startsWith("WIFI:") == true) goto L5;
        return null;
    L5:
        String r14 = r12.substring(5);
        String r5 = matchSinglePrefixedField("S:", r14, ';', false);
        if (r5 != null) goto L8;
    L15:
        return null;
    L8:
        if (r5.isEmpty() == true) goto L15;
        String r6 = matchSinglePrefixedField("P:", r14, ';', false);
        String r15 = matchSinglePrefixedField("T:", r14, ';', false);
        if (r15 != null) goto L14;
        r15 = "nopass";
    L14:
        return new WifiParsedResult(r15, r5, r6, Boolean.parseBoolean(matchSinglePrefixedField("H:", r14, ';', false)), matchSinglePrefixedField("I:", r14, ';', false), matchSinglePrefixedField("A:", r14, ';', false), matchSinglePrefixedField("E:", r14, ';', false), matchSinglePrefixedField("H:", r14, ';', false));
    }
}
