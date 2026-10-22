package com.android.vcard;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class VCardParserImpl_V40 extends VCardParserImpl_V30 {
    @Override // com.android.vcard.VCardParserImpl_V30, com.android.vcard.VCardParserImpl_V21
    protected int getVersion() {
        return 2;
    }

    @Override // com.android.vcard.VCardParserImpl_V30, com.android.vcard.VCardParserImpl_V21
    protected String getVersionString() {
        return VCardConstants.VERSION_V40;
    }

    public VCardParserImpl_V40() {
    }

    public VCardParserImpl_V40(int r1) {
        super(r1);
    }

    @Override // com.android.vcard.VCardParserImpl_V30, com.android.vcard.VCardParserImpl_V21
    protected String maybeUnescapeText(String r1) {
        return unescapeText(r1);
    }

    public static String unescapeText(String r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        char r3 = r5.charAt(r2);
        if (r3 == '\\') goto L7;
    L15:
        r0.append(r3);
    L16:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r2 >= (r1 - 1)) goto L15;
        r2 = r2 + 1;
        char r4 = r5.charAt(r2);
        if (r4 != 'n') goto L11;
    L14:
        r0.append("\n");
        goto L16
    L11:
        if (r4 == 'N') goto L14;
        r0.append(r4);
        goto L16
    L18:
        return r0.toString();
    }

    public static String unescapeCharacter(char r1) {
        if (r1 != 'n') goto L5;
        return "\n";
    L5:
        if (r1 != 'N') goto L8;
        return "\n";
    L8:
        return String.valueOf(r1);
    }

    @Override // com.android.vcard.VCardParserImpl_V30, com.android.vcard.VCardParserImpl_V21
    protected Set<String> getKnownPropertyNameSet() {
        return VCardParser_V40.sKnownPropertyNameSet;
    }
}
