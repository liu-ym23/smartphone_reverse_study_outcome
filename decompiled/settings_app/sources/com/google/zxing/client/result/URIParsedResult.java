package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class URIParsedResult extends ParsedResult {
    private static final Pattern USER_IN_HOST = null;
    private final String title;
    private final String uri;

    static {
        USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
    }

    public URIParsedResult(String r2, String r3) {
        super(ParsedResultType.URI);
        this.uri = massageURI(r2);
        this.title = r3;
    }

    public String getURI() {
        return this.uri;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isPossiblyMaliciousURI() {
        return USER_IN_HOST.matcher(this.uri).find();
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(30);
        maybeAppend(this.title, r0);
        maybeAppend(this.uri, r0);
        return r0.toString();
    }

    private static String massageURI(String r1) {
        String r2 = r1.trim();
        int r0 = r2.indexOf(58);
        if (r0 < 0) goto L7;
        if (isColonFollowedByPortNumber(r2, r0) == true) goto L7;
        return r2;
    L7:
        return "http://".concat(String.valueOf(r2));
    }

    private static boolean isColonFollowedByPortNumber(String r1, int r2) {
        int r3 = r2 + 1;
        int r0 = r1.indexOf(47, r3);
        if (r0 >= 0) goto L6;
        r0 = r1.length();
    L6:
        return ResultParser.isSubstringOfDigits(r1, r3, r0 - r3);
    }
}
