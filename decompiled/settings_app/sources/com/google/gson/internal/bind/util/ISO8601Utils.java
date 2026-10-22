package com.google.gson.internal.bind.util;

import com.android.settingslib.accessibility.AccessibilityUtils;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = null;
    private static final String UTC_ID = "UTC";

    public ISO8601Utils() {
    }

    static {
        TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    }

    public static String format(Date r2) {
        return format(r2, false, TIMEZONE_UTC);
    }

    public static String format(Date r1, boolean r2) {
        return format(r1, r2, TIMEZONE_UTC);
    }

    public static String format(Date r6, boolean r7, TimeZone r8) {
        GregorianCalendar r0 = new GregorianCalendar(r8, Locale.US);
        r0.setTime(r6);
        if (r7 == false) goto L5;
        int r1 = 4;
    L6:
        int r2 = 19 + r1;
        if (r8.getRawOffset() != 0) goto L9;
        int r3 = 1;
    L10:
        StringBuilder r4 = new StringBuilder(r2 + r3);
        padInt(r4, r0.get(1), 4);
        char r9 = '-';
        r4.append('-');
        padInt(r4, r0.get(2) + 1, 2);
        r4.append('-');
        padInt(r4, r0.get(5), 2);
        r4.append('T');
        padInt(r4, r0.get(11), 2);
        r4.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        padInt(r4, r0.get(12), 2);
        r4.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        padInt(r4, r0.get(13), 2);
        if (r7 == false) goto L13;
        r4.append('.');
        padInt(r4, r0.get(14), 3);
    L13:
        int r10 = r8.getOffset(r0.getTimeInMillis());
        if (r10 == 0) goto L20;
        int r11 = r10 / 60000;
        int r5 = Math.abs(r11 / 60);
        int r12 = Math.abs(r11 % 60);
        if (r10 < 0) goto L19;
        r9 = '+';
    L19:
        r4.append(r9);
        padInt(r4, r5, 2);
        r4.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        padInt(r4, r12, 2);
    L22:
        return r4.toString();
    L20:
        r4.append('Z');
        goto L22
    L9:
        r3 = 6;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public static Date parse(String r19, ParsePosition r20) throws ParseException {
        int r5 = r20.getIndex();     // Catch: Throwable -> L82
        int r6 = r5 + 4;     // Catch: Throwable -> L82
        int r7 = parseInt(r19, r5, r6);     // Catch: Throwable -> L82
        if (checkOffset(r19, r6, '-') == false) goto L6;
        r6 = r6 + 1;     // Catch: Throwable -> L82
    L6:
        int r8 = r6 + 2;     // Catch: Throwable -> L82
        int r9 = parseInt(r19, r6, r8);     // Catch: Throwable -> L82
        if (checkOffset(r19, r8, '-') == false) goto L9;
        r8 = r8 + 1;     // Catch: Throwable -> L82
    L9:
        int r10 = r8 + 2;     // Catch: Throwable -> L82
        int r11 = parseInt(r19, r8, r10);     // Catch: Throwable -> L82
        boolean r12 = checkOffset(r19, r10, 'T');     // Catch: Throwable -> L82
        if (r12 == true) goto L16;
        if (r19.length() > r10) goto L16;
        GregorianCalendar r0 = new GregorianCalendar(r7, r9 - 1, r11);     // Catch: Throwable -> L82
        r0.setLenient(false);     // Catch: Throwable -> L82
        r20.setIndex(r10);     // Catch: Throwable -> L82
        return r0.getTime();
    L16:
        if (r12 == false) goto L46;
        int r13 = r10 + 1;     // Catch: Throwable -> L82
        int r14 = r13 + 2;     // Catch: Throwable -> L82
        int r15 = parseInt(r19, r13, r14);     // Catch: Throwable -> L82
        if (checkOffset(r19, r14, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR) == false) goto L20;
        r14 = r14 + 1;     // Catch: Throwable -> L82
    L20:
        int r16 = r14 + 2;     // Catch: Throwable -> L82
        int r17 = parseInt(r19, r14, r16);     // Catch: Throwable -> L82
        if (checkOffset(r19, r16, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR) == false) goto L24;
        r16 = r16 + 1;     // Catch: Throwable -> L82
    L24:
        if (r19.length() <= r16) goto L45;
        char r18 = r19.charAt(r16);     // Catch: Throwable -> L82
        if (r18 == 'Z') goto L45;
        if (r18 == '+') goto L45;
        if (r18 == '-') goto L45;
        int r110 = r16 + 2;     // Catch: Throwable -> L82
        int r111 = parseInt(r19, r16, r110);     // Catch: Throwable -> L82
        if (r111 <= 59) goto L35;
        if (r111 >= 63) goto L35;
        r111 = 59;
    L35:
        if (checkOffset(r19, r110, '.') == false) goto L44;
        int r112 = r110 + 1;     // Catch: Throwable -> L82
        int r21 = indexOfNonDigit(r19, r112 + 1);     // Catch: Throwable -> L82
        int r113 = Math.min(r21, r112 + 3);     // Catch: Throwable -> L82
        int r114 = parseInt(r19, r112, r113);     // Catch: Throwable -> L82
        int r115 = r113 - r112;     // Catch: Throwable -> L82
        if (r115 != 1) goto L39;
        r114 = r114 * 100;     // Catch: Throwable -> L82
    L43:
        int r116 = r114;
        r10 = r21;
        int r22 = r15;
    L49:
        if (r19.length() <= r10) goto L81;
        char r117 = r19.charAt(r10);     // Catch: Throwable -> L82
        if (r117 != 'Z') goto L54;
        TimeZone r1 = TIMEZONE_UTC;     // Catch: Throwable -> L82
        int r23 = r10 + 1;     // Catch: Throwable -> L82
    L78:
        GregorianCalendar r3 = new GregorianCalendar(r1);     // Catch: Throwable -> L82
        r3.setLenient(false);     // Catch: Throwable -> L82
        r3.set(1, r7);     // Catch: Throwable -> L82
        r3.set(2, r9 - 1);     // Catch: Throwable -> L82
        r3.set(5, r11);     // Catch: Throwable -> L82
        r3.set(11, r22);     // Catch: Throwable -> L82
        r3.set(12, r17);     // Catch: Throwable -> L82
        r3.set(13, r111);     // Catch: Throwable -> L82
        r3.set(14, r116);     // Catch: Throwable -> L82
        r20.setIndex(r23);     // Catch: Throwable -> L82
        return r3.getTime();
    L54:
        if (r117 != '+') goto L56;
    L60:
        String r4 = r19.substring(r10);     // Catch: Throwable -> L82
        if (r4.length() >= 5) goto L64;
        r4 = r4 + "00";     // Catch: Throwable -> L82
    L64:
        r23 = r10 + r4.length();     // Catch: Throwable -> L82
        if ("+0000".equals(r4) == false) goto L67;
    L77:
        r1 = TIMEZONE_UTC;     // Catch: Throwable -> L82
        goto L78
    L67:
        if ("+00:00".equals(r4) == true) goto L77;
        String r24 = "GMT" + r4;     // Catch: Throwable -> L82
        TimeZone r25 = TimeZone.getTimeZone(r24);     // Catch: Throwable -> L82
        String r118 = r25.getID();     // Catch: Throwable -> L82
        if (r118.equals(r24) == false) goto L72;
    L76:
        r1 = r25;
        goto L78
    L72:
        if (r118.replace(":", "").equals(r24) == true) goto L76;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r24 + " given, resolves to " + r25.getID());     // Catch: Throwable -> L82
    L56:
        if (r117 == '-') goto L60;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r117 + "'");     // Catch: Throwable -> L82
    L81:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: Throwable -> L82
    L39:
        if (r115 != 2) goto L43;
        r114 = r114 * 10;     // Catch: Throwable -> L82
        goto L43
    L44:
        r22 = r15;
        r10 = r110;
        r116 = 0;
    L45:
        r22 = r15;
        r10 = r16;
    L47:
        r116 = 0;
        r111 = 0;
        goto L49
    L46:
        r22 = 0;
        r17 = 0;
    L82:
        e = move-exception;
        if (r19 != null) goto L85;
        String r2 = null;
    L86:
        String r26 = e.getMessage();
        if (r26 != null) goto L89;
    L90:
        r26 = "(" + e.getClass().getName() + ")";
    L91:
        ParseException r27 = new ParseException("Failed to parse date [" + r2 + "]: " + r26, r20.getIndex());
        r27.initCause(e);
        throw r27;
    L89:
        if (r26.isEmpty() == false) goto L91;
    L85:
        r2 = "\"" + r19 + '\"';
        goto L86
    }

    private static boolean checkOffset(String r1, int r2, char r3) {
        if (r2 < r1.length()) goto L5;
    L7:
        return false;
    L5:
        if (r1.charAt(r2) != r3) goto L7;
        return true;
    }

    private static int parseInt(String r5, int r6, int r7) throws NumberFormatException {
        if (r6 < 0) goto L23;
        if (r7 > r5.length()) goto L23;
        if (r6 > r7) goto L23;
        if (r6 >= r7) goto L13;
        int r2 = r6 + 1;
        int r3 = Character.digit(r5.charAt(r6), 10);
        if (r3 < 0) goto L12;
        int r4 = -r3;
    L14:
        if (r2 >= r7) goto L21;
        int r8 = r2 + 1;
        int r9 = Character.digit(r5.charAt(r2), 10);
        if (r9 < 0) goto L19;
        r4 = (r4 * 10) - r9;
        r2 = r8;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r5.substring(r6, r7));
    L21:
        return -r4;
    L12:
        throw new NumberFormatException("Invalid number: " + r5.substring(r6, r7));
    L13:
        r4 = 0;
        r2 = r6;
    L23:
        throw new NumberFormatException(r5);
    }

    private static void padInt(StringBuilder r1, int r2, int r3) {
        String r4 = Integer.toString(r2);
        int r5 = r3 - r4.length();
    L3:
        if (r5 <= 0) goto L5;
        r1.append('0');
        r5 = r5 - 1;
        goto L3
    L5:
        r1.append(r4);
    }

    private static int indexOfNonDigit(String r2, int r3) {
    L3:
        if (r3 >= r2.length()) goto L12;
        char r0 = r2.charAt(r3);
        if (r0 < '0') goto L10;
        if (r0 > '9') goto L10;
        r3 = r3 + 1;
    L10:
        return r3;
    L12:
        return r2.length();
    }
}
