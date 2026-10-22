package com.google.zxing.client.result;

import com.android.vcard.VCardConstants;

/* JADX INFO: loaded from: classes4.dex */
public final enum ParsedResultType extends Enum<ParsedResultType> {
    private static final /* synthetic */ ParsedResultType[] $VALUES = null;
    public static final ParsedResultType ADDRESSBOOK = null;
    public static final ParsedResultType CALENDAR = null;
    public static final ParsedResultType EMAIL_ADDRESS = null;
    public static final ParsedResultType GEO = null;
    public static final ParsedResultType ISBN = null;
    public static final ParsedResultType PRODUCT = null;
    public static final ParsedResultType SMS = null;
    public static final ParsedResultType TEL = null;
    public static final ParsedResultType TEXT = null;
    public static final ParsedResultType URI = null;
    public static final ParsedResultType VIN = null;
    public static final ParsedResultType WIFI = null;

    private ParsedResultType(String r1, int r2) {
        super(r1, r2);
    }

    public static ParsedResultType valueOf(String r1) {
        return (ParsedResultType) Enum.valueOf(ParsedResultType.class, r1);
    }

    public static ParsedResultType[] values() {
        return (ParsedResultType[]) $VALUES.clone();
    }

    static {
        ParsedResultType r0 = new ParsedResultType("ADDRESSBOOK", 0);
        ADDRESSBOOK = r0;
        ParsedResultType r1 = new ParsedResultType("EMAIL_ADDRESS", 1);
        EMAIL_ADDRESS = r1;
        ParsedResultType r3 = new ParsedResultType("PRODUCT", 2);
        PRODUCT = r3;
        ParsedResultType r5 = new ParsedResultType("URI", 3);
        URI = r5;
        ParsedResultType r7 = new ParsedResultType("TEXT", 4);
        TEXT = r7;
        ParsedResultType r9 = new ParsedResultType("GEO", 5);
        GEO = r9;
        ParsedResultType r11 = new ParsedResultType(VCardConstants.PROPERTY_TEL, 6);
        TEL = r11;
        ParsedResultType r13 = new ParsedResultType("SMS", 7);
        SMS = r13;
        ParsedResultType r15 = new ParsedResultType("CALENDAR", 8);
        CALENDAR = r15;
        ParsedResultType r14 = new ParsedResultType("WIFI", 9);
        WIFI = r14;
        ParsedResultType r12 = new ParsedResultType("ISBN", 10);
        ISBN = r12;
        ParsedResultType r10 = new ParsedResultType("VIN", 11);
        VIN = r10;
        $VALUES = new ParsedResultType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
    }
}
