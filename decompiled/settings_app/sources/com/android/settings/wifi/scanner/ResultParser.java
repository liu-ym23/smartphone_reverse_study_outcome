package com.android.settings.wifi.scanner;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResultParser {
    private static final Pattern AMPERSAND = null;
    private static final String BYTE_ORDER_MARK = "\ufeff";
    private static final Pattern DIGITS = null;
    static final String[] EMPTY_STR_ARRAY = null;
    private static final Pattern EQUALS = null;
    private static final ResultParser[] PARSERS = null;

    protected static String[] maybeWrap(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return new String[]{r2};
    }

    protected static int parseHexDigit(char r2) {
        if (r2 >= '0') goto L5;
    L8:
        char r0 = 'a';
        if (r2 >= 'a') goto L11;
    L14:
        r0 = 'A';
        if (r2 >= 'A') goto L17;
        return -1;
    L17:
        if (r2 <= 'F') goto L13;
        return -1;
    L13:
        return (r2 - r0) + 10;
    L11:
        if (r2 > 'f') goto L14;
    L5:
        if (r2 > '9') goto L8;
        return r2 - '0';
    }

    public abstract ParsedResult parse(String r1);

    public ResultParser() {
    }

    static {
        PARSERS = new ResultParser[]{new WifiResultParser()};
        DIGITS = Pattern.compile("\\d+");
        AMPERSAND = Pattern.compile("&");
        EQUALS = Pattern.compile("=");
        EMPTY_STR_ARRAY = new String[0];
    }

    protected static String getMassagedText(String r1) {
        if (r1.startsWith("\ufeff") == true) goto L5;
        return r1;
    L5:
        return r1.substring(1);
    }

    protected static void maybeAppend(String r1, StringBuilder r2) {
        if (r1 == null) goto L5;
        r2.append('\n');
        r2.append(r1);
        return;
    }

    protected static void maybeAppend(String[] r4, StringBuilder r5) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L8;
        String r2 = r4[r1];
        r5.append('\n');
        r5.append(r2);
        r1 = r1 + 1;
        goto L4
    L8:
        return;
    }

    protected static String unescapeBackslash(String r7) {
        int r1 = r7.indexOf(92);
        if (r1 >= 0) goto L5;
        return r7;
    L5:
        int r2 = r7.length();
        StringBuilder r3 = new StringBuilder(r2 - 1);
        r3.append(r7.toCharArray(), 0, r1);
        boolean r4 = false;
    L6:
        if (r1 >= r2) goto L15;
        char r6 = r7.charAt(r1);
        if (r4 == true) goto L12;
        if (r6 != '\\') goto L12;
        r4 = true;
    L13:
        r1 = r1 + 1;
    L12:
        r3.append(r6);
        r4 = false;
        goto L13
    L15:
        return r3.toString();
    }

    protected static boolean isStringOfDigits(CharSequence r1, int r2) {
        if (r1 == null) goto L9;
        if (r2 <= 0) goto L9;
        if (r2 != r1.length()) goto L9;
        if (DIGITS.matcher(r1).matches() == false) goto L9;
        return true;
    L9:
        return false;
    }

    protected static boolean isSubstringOfDigits(CharSequence r2, int r3, int r4) {
        if (r2 == null) goto L12;
        if (r4 <= 0) goto L15;
        int r5 = r4 + r3;
        if (r2.length() >= r5) goto L9;
        return false;
    L9:
        if (DIGITS.matcher(r2.subSequence(r3, r5)).matches() == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    L12:
        return false;
    }

    static Map<String, String> parseNameValuePairs(String r4) {
        int r0 = r4.indexOf(63);
        if (r0 >= 0) goto L6;
        return null;
    L6:
        HashMap r1 = new HashMap(3);
        String[] r5 = AMPERSAND.split(r4.substring(r0 + 1));
        int r2 = r5.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        appendKeyValue(r5[r3], r1);
        r3 = r3 + 1;
        goto L7
    L9:
        return r1;
    }

    private static void appendKeyValue(CharSequence r2, Map<String, String> r3) {
        String[] r4 = EQUALS.split(r2, 2);
        if (r4.length != 2) goto L10;
        String r0 = r4[0];
        r3.put(r0, urlDecode(r4[1]));     // Catch: IllegalArgumentException -> L7
        return;
    L11:
        return;
    }

    static String urlDecode(String r1) {
        return URLDecoder.decode(r1, "UTF-8");
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    static String[] matchPrefixedField(String r8, String r9, char r10, boolean r11) {
        int r0 = r9.length();
        ArrayList r4 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L26;
        int r5 = r9.indexOf(r8, r3);
        if (r5 < 0) goto L26;
        int r6 = r5 + r8.length();
        boolean r7 = true;
        ArrayList r12 = r4;
        int r13 = r6;
    L8:
        if (r7 == false) goto L25;
        int r14 = r9.indexOf(r10, r13);
        if (r14 < 0) goto L11;
        if ((countPrecedingBackslashes(r9, r14) % 2) == 0) goto L16;
        r13 = r14 + 1;
        goto L8
    L16:
        if (r12 != null) goto L18;
        r12 = new ArrayList(3);
    L18:
        String r15 = unescapeBackslash(r9.substring(r6, r14));
        if (r11 == false) goto L22;
        r15 = r15.trim();
    L22:
        if (r15.isEmpty() == true) goto L24;
        r12.add(r15);
    L24:
        r13 = r14 + 1;
    L12:
        r7 = false;
        goto L8
    L11:
        r13 = r9.length();
        goto L12
    L25:
        r3 = r13;
        r4 = r12;
    L26:
        if (r4 != null) goto L28;
    L32:
        return null;
    L28:
        if (r4.isEmpty() == true) goto L32;
        return (String[]) r4.toArray(EMPTY_STR_ARRAY);
    }

    private static int countPrecedingBackslashes(CharSequence r3, int r4) {
        int r5 = r4 - 1;
        int r0 = 0;
    L3:
        if (r5 < 0) goto L7;
        if (r3.charAt(r5) != '\\') goto L7;
        r0 = r0 + 1;
        r5 = r5 - 1;
    L7:
        return r0;
    }

    static String matchSinglePrefixedField(String r0, String r1, char r2, boolean r3) {
        String[] r4 = matchPrefixedField(r0, r1, r2, r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        return r4[0];
    }
}
