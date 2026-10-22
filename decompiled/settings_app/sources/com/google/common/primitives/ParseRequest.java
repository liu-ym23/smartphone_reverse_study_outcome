package com.google.common.primitives;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ParseRequest {
    final int radix;
    final String rawValue;

    private ParseRequest(String r1, int r2) {
        this.rawValue = r1;
        this.radix = r2;
    }

    static ParseRequest fromString(String r4) {
        if (r4.length() == 0) goto L22;
        char r0 = r4.charAt(0);
        int r2 = 16;
        if (r4.startsWith("0x") == false) goto L7;
    L18:
        r4 = r4.substring(2);
    L20:
        return new ParseRequest(r4, r2);
    L7:
        if (r4.startsWith("0X") == true) goto L18;
        if (r0 != '#') goto L13;
        r4 = r4.substring(1);
        goto L20
    L13:
        if (r0 == '0') goto L15;
    L17:
        r2 = 10;
        goto L20
    L15:
        if (r4.length() <= 1) goto L17;
        r4 = r4.substring(1);
        r2 = 8;
        goto L20
    L22:
        throw new NumberFormatException("empty string");
    }
}
