package com.google.zxing.client.result;

import com.android.settings.utils.HanziToPinyin;
import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class URIResultParser extends ResultParser {
    private static final Pattern URL_WITHOUT_PROTOCOL_PATTERN = null;
    private static final Pattern URL_WITH_PROTOCOL_PATTERN = null;

    public URIResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    static {
        URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
        URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
    }

    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result r3) {
        String r2 = getMassagedText(r3);
        if (r2.startsWith("URL:") == true) goto L13;
        if (r2.startsWith("URI:") == true) goto L13;
        String r4 = r2.trim();
        if (isBasicallyValidURI(r4) == true) goto L10;
        return null;
    L10:
        return new URIParsedResult(r4, null);
    L13:
        return new URIParsedResult(r2.substring(4).trim(), null);
    }

    static boolean isBasicallyValidURI(String r4) {
        if (r4.contains(HanziToPinyin.Token.SEPARATOR) == false) goto L5;
        return false;
    L5:
        Matcher r0 = URL_WITH_PROTOCOL_PATTERN.matcher(r4);
        if (r0.find() == true) goto L8;
    L10:
        Matcher r5 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(r4);
        if (r5.find() == true) goto L13;
    L15:
        return false;
    L13:
        if (r5.start() != 0) goto L15;
        return true;
    L8:
        if (r0.start() != 0) goto L10;
        return true;
    }
}
