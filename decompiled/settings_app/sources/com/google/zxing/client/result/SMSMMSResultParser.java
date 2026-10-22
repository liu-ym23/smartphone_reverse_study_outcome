package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class SMSMMSResultParser extends ResultParser {
    public SMSMMSResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public SMSParsedResult parse(Result r7) {
        String r6 = getMassagedText(r7);
        String r0 = null;
        if (r6.startsWith("sms:") == false) goto L5;
    L11:
        Map<String, String> r8 = parseNameValuePairs(r6);
        if (r8 != null) goto L14;
    L16:
        boolean r9 = false;
        String r2 = null;
    L17:
        int r3 = r6.indexOf(63, 4);
        if (r3 < 0) goto L22;
        if (r9 == false) goto L22;
        String r10 = r6.substring(4, r3);
    L23:
        ArrayList r11 = new ArrayList(1);
        ArrayList r4 = new ArrayList(1);
        int r1 = -1;
    L24:
        int r5 = r1 + 1;
        int r12 = r10.indexOf(44, r5);
        if (r12 <= r1) goto L27;
        addNumberVia(r11, r4, r10.substring(r5, r12));
        r1 = r12;
        goto L24
    L27:
        addNumberVia(r11, r4, r10.substring(r5));
        return new SMSParsedResult((String[]) r11.toArray(new String[r11.size()]), (String[]) r4.toArray(new String[r4.size()]), r0, r2);
    L22:
        r10 = r6.substring(4);
        goto L23
    L14:
        if (r8.isEmpty() == true) goto L16;
        r0 = r8.get("subject");
        r2 = r8.get("body");
        r9 = true;
        goto L17
    L5:
        if (r6.startsWith("SMS:") == true) goto L11;
        if (r6.startsWith("mms:") == true) goto L11;
        if (r6.startsWith("MMS:") == true) goto L11;
        return null;
    }

    private static void addNumberVia(Collection<String> r3, Collection<String> r4, String r5) {
        int r0 = r5.indexOf(59);
        String r1 = null;
        if (r0 >= 0) goto L6;
        r3.add(r5);
        r4.add(null);
        return;
    L6:
        r3.add(r5.substring(0, r0));
        String r6 = r5.substring(r0 + 1);
        if (r6.startsWith("via=") == false) goto L9;
        r1 = r6.substring(4);
    L9:
        r4.add(r1);
    }
}
