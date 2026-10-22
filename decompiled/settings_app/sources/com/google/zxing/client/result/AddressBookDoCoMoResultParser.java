package com.google.zxing.client.result;

import com.google.zxing.Result;
import cz.msebera.android.httpclient.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class AddressBookDoCoMoResultParser extends AbstractDoCoMoResultParser {
    public AddressBookDoCoMoResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result r24) {
        String r0 = getMassagedText(r24);
        if (r0.startsWith("MECARD:") == true) goto L5;
        return null;
    L5:
        String[] r1 = matchDoCoMoPrefixedField("N:", r0, true);
        if (r1 != null) goto L8;
        return null;
    L8:
        String r2 = parseName(r1[0]);
        String r9 = matchSingleDoCoMoPrefixedField("SOUND:", r0, true);
        String[] r10 = matchDoCoMoPrefixedField("TEL:", r0, true);
        String[] r12 = matchDoCoMoPrefixedField("EMAIL:", r0, true);
        String r15 = matchSingleDoCoMoPrefixedField("NOTE:", r0, false);
        String[] r16 = matchDoCoMoPrefixedField("ADR:", r0, true);
        String r4 = matchSingleDoCoMoPrefixedField("BDAY:", r0, true);
        if (isStringOfDigits(r4, 8) == true) goto L11;
        String r19 = null;
    L12:
        String[] r21 = matchDoCoMoPrefixedField("URL:", r0, true);
        return new AddressBookParsedResult(maybeWrap(r2), null, r9, r10, null, r12, null, null, r15, r16, null, matchSingleDoCoMoPrefixedField("ORG:", r0, true), r19, null, r21, null);
    L11:
        r19 = r4;
        goto L12
    }

    private static String parseName(String r3) {
        int r0 = r3.indexOf(44);
        if (r0 >= 0) goto L5;
        return r3;
    L5:
        return r3.substring(r0 + 1) + TokenParser.SP + r3.substring(0, r0);
    }
}
