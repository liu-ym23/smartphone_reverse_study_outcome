package com.google.gson.internal;

import a.a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class PreJava9DateFormatProvider {
    public PreJava9DateFormatProvider() {
    }

    private static String getDateFormatPattern(int r2) {
        if (r2 != 0) goto L4;
        return "EEEE, MMMM d, y";
    L4:
        if (r2 != 1) goto L6;
        return "MMMM d, y";
    L6:
        if (r2 != 2) goto L8;
        return "MMM d, y";
    L8:
        if (r2 != 3) goto L12;
        return "M/d/yy";
    L12:
        throw new IllegalArgumentException(a.e(r2, "Unknown DateFormat style: "));
    }

    private static String getDatePartOfDateTimePattern(int r2) {
        if (r2 != 0) goto L4;
        return "EEEE, MMMM d, yyyy";
    L4:
        if (r2 != 1) goto L6;
        return "MMMM d, yyyy";
    L6:
        if (r2 != 2) goto L8;
        return "MMM d, yyyy";
    L8:
        if (r2 != 3) goto L12;
        return "M/d/yy";
    L12:
        throw new IllegalArgumentException(a.e(r2, "Unknown DateFormat style: "));
    }

    private static String getTimePartOfDateTimePattern(int r2) {
        if (r2 != 0) goto L4;
        return "h:mm:ss a z";
    L4:
        if (r2 != 1) goto L6;
        return "h:mm:ss a z";
    L6:
        if (r2 != 2) goto L8;
        return "h:mm:ss a";
    L8:
        if (r2 != 3) goto L12;
        return "h:mm a";
    L12:
        throw new IllegalArgumentException(a.e(r2, "Unknown DateFormat style: "));
    }

    public static DateFormat getUSDateFormat(int r2) {
        return new SimpleDateFormat(getDateFormatPattern(r2), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int r1, int r2) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(r1) + " " + getTimePartOfDateTimePattern(r2), Locale.US);
    }
}
