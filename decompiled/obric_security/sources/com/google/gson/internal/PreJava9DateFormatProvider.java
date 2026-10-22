package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class PreJava9DateFormatProvider {
    public PreJava9DateFormatProvider() {
    }

    public static DateFormat getUSDateFormat(int r2) {
        return new SimpleDateFormat(getDateFormatPattern(r2), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int r1, int r2) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(r1) + " " + getTimePartOfDateTimePattern(r2), Locale.US);
    }

    private static String getDateFormatPattern(int r3) {
        if (r3 != 0) goto L4;
        return "EEEE, MMMM d, y";
    L4:
        if (r3 != 1) goto L6;
        return "MMMM d, y";
    L6:
        if (r3 != 2) goto L8;
        return "MMM d, y";
    L8:
        if (r3 != 3) goto L12;
        return "M/d/yy";
    L12:
        throw new IllegalArgumentException("Unknown DateFormat style: " + r3);
    }

    private static String getDatePartOfDateTimePattern(int r3) {
        if (r3 != 0) goto L4;
        return "EEEE, MMMM d, yyyy";
    L4:
        if (r3 != 1) goto L6;
        return "MMMM d, yyyy";
    L6:
        if (r3 != 2) goto L8;
        return "MMM d, yyyy";
    L8:
        if (r3 != 3) goto L12;
        return "M/d/yy";
    L12:
        throw new IllegalArgumentException("Unknown DateFormat style: " + r3);
    }

    private static String getTimePartOfDateTimePattern(int r3) {
        if (r3 != 0) goto L4;
        return "h:mm:ss a z";
    L4:
        if (r3 != 1) goto L6;
        return "h:mm:ss a z";
    L6:
        if (r3 != 2) goto L8;
        return "h:mm:ss a";
    L8:
        if (r3 != 3) goto L12;
        return "h:mm a";
    L12:
        throw new IllegalArgumentException("Unknown DateFormat style: " + r3);
    }
}
