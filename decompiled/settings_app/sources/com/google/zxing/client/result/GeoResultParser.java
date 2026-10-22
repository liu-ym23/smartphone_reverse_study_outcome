package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class GeoResultParser extends ResultParser {
    private static final Pattern GEO_URL_PATTERN = null;

    public GeoResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    static {
        GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public GeoParsedResult parse(Result r10) {
        String r9 = getMassagedText(r10);
        Matcher r11 = GEO_URL_PATTERN.matcher(r9);
        if (r11.matches() == true) goto L5;
        return null;
    L5:
        String r8 = r11.group(4);
        double r2 = Double.parseDouble(r11.group(1));     // Catch: NumberFormatException -> L27
        if (r2 > 90.0d) goto L26;
        if (r2 < (-90.0d)) goto L26;
        double r4 = Double.parseDouble(r11.group(2));     // Catch: NumberFormatException -> L27
        if (r4 > 180.0d) goto L26;
        if (r4 < (-180.0d)) goto L26;
        double r6 = 0.0d;
        if (r11.group(3) == null) goto L25;
        double r12 = Double.parseDouble(r11.group(3));     // Catch: NumberFormatException -> L27
        if (r12 >= 0.0d) goto L23;
        return null;
    L23:
        r6 = r12;
    L25:
        return new GeoParsedResult(r2, r4, r6, r8);
    L26:
        return null;
    }
}
