package com.google.zxing.client.result;

import com.google.zxing.Result;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class BizcardResultParser extends AbstractDoCoMoResultParser {
    public BizcardResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result r22) {
        String r0 = getMassagedText(r22);
        if (r0.startsWith("BIZCARD:") == true) goto L6;
        return null;
    L6:
        String r1 = buildName(matchSingleDoCoMoPrefixedField("N:", r0, true), matchSingleDoCoMoPrefixedField("X:", r0, true));
        String r18 = matchSingleDoCoMoPrefixedField("T:", r0, true);
        String r16 = matchSingleDoCoMoPrefixedField("C:", r0, true);
        String[] r14 = matchDoCoMoPrefixedField("A:", r0, true);
        String r3 = matchSingleDoCoMoPrefixedField("B:", r0, true);
        String r8 = matchSingleDoCoMoPrefixedField("M:", r0, true);
        String r9 = matchSingleDoCoMoPrefixedField("F:", r0, true);
        String r2 = matchSingleDoCoMoPrefixedField("E:", r0, true);
        return new AddressBookParsedResult(maybeWrap(r1), null, null, buildPhoneNumbers(r3, r8, r9), null, maybeWrap(r2), null, null, null, r14, null, r16, null, r18, null, null);
    }

    private static String[] buildPhoneNumbers(String r2, String r3, String r4) {
        ArrayList r0 = new ArrayList(3);
        if (r2 == null) goto L5;
        r0.add(r2);
    L5:
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        if (r4 == null) goto L9;
        r0.add(r4);
    L9:
        int r5 = r0.size();
        if (r5 != 0) goto L14;
        return null;
    L14:
        return (String[]) r0.toArray(new String[r5]);
    }

    private static String buildName(String r1, String r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        if (r2 != null) goto L7;
        return r1;
    L7:
        return r1 + TokenParser.SP + r2;
    }
}
