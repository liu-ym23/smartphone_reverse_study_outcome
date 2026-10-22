package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class VINResultParser extends ResultParser {
    private static final Pattern AZ09 = null;
    private static final Pattern IOQ = null;

    public VINResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    static {
        IOQ = Pattern.compile("[IOQ]");
        AZ09 = Pattern.compile("[A-Z0-9]{17}");
    }

    @Override // com.google.zxing.client.result.ResultParser
    public VINParsedResult parse(Result r13) {
        if (r13.getBarcodeFormat() == BarcodeFormat.CODE_39) goto L5;
        return null;
    L5:
        String r12 = r13.getText();
        String r3 = IOQ.matcher(r12).replaceAll("").trim();
        if (AZ09.matcher(r3).matches() == true) goto L14;
        return null;
    L14:
    L13:
        return null;
    L9:
        if (checkChecksum(r3) == true) goto L11;
        return null;
    L11:
        String r4 = r3.substring(0, 3);     // Catch: IllegalArgumentException -> L13
        return new VINParsedResult(r3, r4, r3.substring(3, 9), r3.substring(9, 17), countryCode(r4), r3.substring(3, 8), modelYear(r3.charAt(9)), r3.charAt(10), r3.substring(11));
    }

    private static boolean checkChecksum(CharSequence r5) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r5.length()) goto L7;
        int r3 = r1 + 1;
        r2 = r2 + (vinPositionWeight(r3) * vinCharValue(r5.charAt(r1)));
        r1 = r3;
        goto L4
    L7:
        if (r5.charAt(8) != checkChar(r2 % 11)) goto L10;
        return true;
    L10:
        return false;
    }

    private static int vinCharValue(char r2) {
        if (r2 < 'A') goto L9;
        if (r2 > 'I') goto L9;
        return (r2 - 'A') + 1;
    L9:
        if (r2 < 'J') goto L15;
        if (r2 > 'R') goto L15;
        return (r2 - 'J') + 1;
    L15:
        if (r2 < 'S') goto L21;
        if (r2 > 'Z') goto L21;
        return (r2 - 'S') + 2;
    L21:
        if (r2 < '0') goto L27;
        if (r2 > '9') goto L27;
        return r2 - '0';
    L27:
        throw new IllegalArgumentException();
    }

    private static int vinPositionWeight(int r3) {
        if (r3 <= 0) goto L9;
        if (r3 > 7) goto L9;
        return 9 - r3;
    L9:
        if (r3 != 8) goto L11;
        return 10;
    L11:
        if (r3 != 9) goto L14;
        return 0;
    L14:
        if (r3 < 10) goto L20;
        if (r3 > 17) goto L20;
        return 19 - r3;
    L20:
        throw new IllegalArgumentException();
    }

    private static char checkChar(int r1) {
        if (r1 < 10) goto L5;
        if (r1 != 10) goto L10;
        return 'X';
    L10:
        throw new IllegalArgumentException();
    L5:
        return (char) (r1 + 48);
    }

    private static int modelYear(char r2) {
        if (r2 < 'E') goto L9;
        if (r2 > 'H') goto L9;
        return (r2 - 'E') + 1984;
    L9:
        if (r2 < 'J') goto L15;
        if (r2 > 'N') goto L15;
        return (r2 - 'J') + 1988;
    L15:
        if (r2 != 'P') goto L19;
        return 1993;
    L19:
        if (r2 < 'R') goto L25;
        if (r2 > 'T') goto L25;
        return (r2 - 'R') + 1994;
    L25:
        if (r2 < 'V') goto L31;
        if (r2 > 'Y') goto L31;
        return (r2 - 'V') + 1997;
    L31:
        if (r2 < '1') goto L37;
        if (r2 > '9') goto L37;
        return (r2 - '1') + 2001;
    L37:
        if (r2 < 'A') goto L43;
        if (r2 > 'D') goto L43;
        return (r2 - 'A') + 2010;
    L43:
        throw new IllegalArgumentException();
    }

    private static String countryCode(CharSequence r10) {
        char r0 = r10.charAt(0);
        char r11 = r10.charAt(1);
        if (r0 != '9') goto L5;
        if (r11 < 'A') goto L67;
        if (r11 > 'E') goto L67;
        return "BR";
    L67:
        if (r11 < '3') goto L90;
        if (r11 > '9') goto L91;
        return "BR";
    L91:
        return null;
    L90:
        return null;
    L5:
        if (r0 != 'S') goto L7;
        if (r11 < 'A') goto L62;
        if (r11 > 'M') goto L62;
        return "UK";
    L62:
        if (r11 < 'N') goto L88;
        if (r11 > 'T') goto L89;
        return "DE";
    L89:
        return null;
    L88:
        return null;
    L7:
        if (r0 != 'Z') goto L9;
        if (r11 < 'A') goto L86;
        if (r11 > 'R') goto L87;
        return "IT";
    L87:
        return null;
    L86:
        return null;
    L9:
        switch(r0) {
            case 49: goto L50;
            case 50: goto L48;
            case 51: goto L44;
            case 52: goto L50;
            case 53: goto L50;
            default: goto L10;
        };
    L10:
        switch(r0) {
            case 74: goto L40;
            case 75: goto L36;
            case 76: goto L33;
            case 77: goto L29;
            default: goto L11;
        };
    L11:
        switch(r0) {
            case 86: goto L21;
            case 87: goto L19;
            case 88: goto L14;
            default: goto L92;
        };
    L19:
        return "DE";
    L92:
        return null;
    L14:
        if (r11 == '0') goto L17;
        if (r11 < '3') goto L71;
        if (r11 > '9') goto L75;
        return "RU";
    L75:
        return null;
    L71:
        return null;
    L17:
        return "RU";
    L21:
        if (r11 < 'F') goto L25;
        if (r11 > 'R') goto L25;
        return "FR";
    L25:
        if (r11 < 'S') goto L76;
        if (r11 > 'W') goto L77;
        return "ES";
    L77:
        return null;
    L76:
        return null;
    L29:
        if (r11 < 'A') goto L78;
        if (r11 > 'E') goto L79;
        return "IN";
    L79:
        return null;
    L78:
        return null;
    L33:
        return "CN";
    L40:
        if (r11 < 'A') goto L82;
        if (r11 > 'T') goto L83;
        return "JP";
    L83:
        return null;
    L82:
        return null;
    L36:
        if (r11 < 'L') goto L80;
        if (r11 > 'R') goto L81;
        return "KO";
    L81:
        return null;
    L80:
        return null;
    L44:
        if (r11 < 'A') goto L84;
        if (r11 > 'W') goto L85;
        return "MX";
    L85:
        return null;
    L84:
        return null;
    L48:
        return "CA";
    L50:
        return "US";
    }
}
