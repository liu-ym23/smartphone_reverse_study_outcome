package com.google.gson.internal.bind.c;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f7024a = null;

    static {
        f7024a = TimeZone.getTimeZone("UTC");
    }

    private static boolean a(String r1, int r2, char r3) {
        if (r2 < r1.length()) goto L5;
    L7:
        return false;
    L5:
        if (r1.charAt(r2) != r3) goto L7;
        return true;
    }

    private static int b(String r2, int r3) {
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

    public static Date c(String r17, ParsePosition r18) {
        int r0 = r18.getIndex();     // Catch: Throwable -> L79
        int r3 = r0 + 4;     // Catch: Throwable -> L79
        int r1 = d(r17, r0, r3);     // Catch: Throwable -> L79
        if (a(r17, r3, '-') == false) goto L6;
        r3 = r3 + 1;     // Catch: Throwable -> L79
    L6:
        int r5 = r3 + 2;     // Catch: Throwable -> L79
        int r4 = d(r17, r3, r5);     // Catch: Throwable -> L79
        if (a(r17, r5, '-') == false) goto L9;
        r5 = r5 + 1;     // Catch: Throwable -> L79
    L9:
        int r6 = r5 + 2;     // Catch: Throwable -> L79
        int r7 = d(r17, r5, r6);     // Catch: Throwable -> L79
        boolean r8 = a(r17, r6, 'T');     // Catch: Throwable -> L79
        if (r8 == true) goto L16;
        if (r17.length() > r6) goto L16;
        GregorianCalendar r9 = new GregorianCalendar(r1, r4 - 1, r7);     // Catch: Throwable -> L79
        r9.setLenient(false);     // Catch: Throwable -> L79
        r18.setIndex(r6);     // Catch: Throwable -> L79
        return r9.getTime();
    L16:
        if (r8 == false) goto L45;
        int r10 = r6 + 1;     // Catch: Throwable -> L79
        int r11 = r10 + 2;     // Catch: Throwable -> L79
        int r12 = d(r17, r10, r11);     // Catch: Throwable -> L79
        if (a(r17, r11, ':') == false) goto L20;
        r11 = r11 + 1;     // Catch: Throwable -> L79
    L20:
        int r14 = r11 + 2;     // Catch: Throwable -> L79
        int r13 = d(r17, r11, r14);     // Catch: Throwable -> L79
        if (a(r17, r14, ':') == false) goto L24;
        r14 = r14 + 1;     // Catch: Throwable -> L79
    L24:
        if (r17.length() <= r14) goto L44;
        char r15 = r17.charAt(r14);     // Catch: Throwable -> L79
        if (r15 == 'Z') goto L44;
        if (r15 == '+') goto L44;
        if (r15 == '-') goto L44;
        int r16 = r14 + 2;     // Catch: Throwable -> L79
        int r19 = d(r17, r14, r16);     // Catch: Throwable -> L79
        if (r19 <= 59) goto L35;
        if (r19 >= 63) goto L35;
        r19 = 59;
    L35:
        if (a(r17, r16, '.') == false) goto L43;
        int r110 = r16 + 1;     // Catch: Throwable -> L79
        int r111 = b(r17, r110 + 1);     // Catch: Throwable -> L79
        int r20 = Math.min(r111, r110 + 3);     // Catch: Throwable -> L79
        int r112 = d(r17, r110, r20);     // Catch: Throwable -> L79
        int r21 = r20 - r110;     // Catch: Throwable -> L79
        if (r21 == 1) goto L41;
        if (r21 != 2) goto L42;
        r112 = r112 * 10;     // Catch: Throwable -> L79
    L42:
        int r22 = r13;
        int r113 = r112;
        int r23 = r12;
        r6 = r111;
    L48:
        if (r17.length() <= r6) goto L78;
        char r114 = r17.charAt(r6);     // Catch: Throwable -> L79
        if (r114 != 'Z') goto L52;
        TimeZone r24 = f7024a;     // Catch: Throwable -> L79
        int r25 = r6 + 1;     // Catch: Throwable -> L79
    L75:
        GregorianCalendar r115 = new GregorianCalendar(r24);     // Catch: Throwable -> L79
        r115.setLenient(false);     // Catch: Throwable -> L79
        r115.set(1, r1);     // Catch: Throwable -> L79
        r115.set(2, r4 - 1);     // Catch: Throwable -> L79
        r115.set(5, r7);     // Catch: Throwable -> L79
        r115.set(11, r23);     // Catch: Throwable -> L79
        r115.set(12, r22);     // Catch: Throwable -> L79
        r115.set(13, r19);     // Catch: Throwable -> L79
        r115.set(14, r113);     // Catch: Throwable -> L79
        r18.setIndex(r25);     // Catch: Throwable -> L79
        return r115.getTime();
    L52:
        if (r114 == '+') goto L57;
        if (r114 == '-') goto L57;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r114 + "'");     // Catch: Throwable -> L79
    L57:
        String r26 = r17.substring(r6);     // Catch: Throwable -> L79
        if (r26.length() >= 5) goto L61;
        r26 = r26 + "00";     // Catch: Throwable -> L79
    L61:
        r25 = r6 + r26.length();     // Catch: Throwable -> L79
        if ("+0000".equals(r26) == false) goto L64;
    L74:
        r24 = f7024a;     // Catch: Throwable -> L79
        goto L75
    L64:
        if ("+00:00".equals(r26) == true) goto L74;
        String r27 = "GMT" + r26;     // Catch: Throwable -> L79
        TimeZone r116 = TimeZone.getTimeZone(r27);     // Catch: Throwable -> L79
        String r117 = r116.getID();     // Catch: Throwable -> L79
        if (r117.equals(r27) == false) goto L69;
    L73:
        r24 = r116;
        goto L75
    L69:
        if (r117.replace(":", "").equals(r27) == true) goto L73;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r27 + " given, resolves to " + r116.getID());     // Catch: Throwable -> L79
    L78:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: Throwable -> L79
    L41:
        r112 = r112 * 100;     // Catch: Throwable -> L79
        goto L42
    L43:
        r22 = r13;
        r23 = r12;
        r6 = r16;
        r113 = 0;
    L44:
        r22 = r13;
        r113 = 0;
        r23 = r12;
        r6 = r14;
    L46:
        r19 = 0;
        goto L48
    L45:
        r23 = 0;
        r22 = 0;
        r113 = 0;
    L79:
        e = move-exception;
        if (r17 != null) goto L82;
        String r2 = null;
    L83:
        String r28 = e.getMessage();
        if (r28 != null) goto L86;
    L87:
        r28 = "(" + e.getClass().getName() + ")";
    L88:
        ParseException r29 = new ParseException("Failed to parse date [" + r2 + "]: " + r28, r18.getIndex());
        r29.initCause(e);
        throw r29;
    L86:
        if (r28.isEmpty() == false) goto L88;
    L82:
        r2 = '\"' + r17 + '\"';
        goto L83
    }

    private static int d(String r5, int r6, int r7) {
        if (r6 < 0) goto L23;
        if (r7 > r5.length()) goto L23;
        if (r6 > r7) goto L23;
        if (r6 >= r7) goto L13;
        int r0 = r6 + 1;
        int r3 = Character.digit(r5.charAt(r6), 10);
        if (r3 < 0) goto L12;
        int r4 = -r3;
    L14:
        if (r0 >= r7) goto L21;
        int r8 = r0 + 1;
        int r1 = Character.digit(r5.charAt(r0), 10);
        if (r1 < 0) goto L19;
        r4 = (r4 * 10) - r1;
        r0 = r8;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r5.substring(r6, r7));
    L21:
        return -r4;
    L12:
        throw new NumberFormatException("Invalid number: " + r5.substring(r6, r7));
    L13:
        r4 = 0;
        r0 = r6;
    L23:
        throw new NumberFormatException(r5);
    }
}
