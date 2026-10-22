package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpDate {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = null;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = null;
    public static final long MAX_DATE = 253402300799999L;
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = null;

    static {
        STANDARD_DATE_FORMAT = new AnonymousClass1();
        String[] r0 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = r0;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[r0.length];
    }

    public static Date parse(String r10) {
        if (r10.length() != 0) goto L5;
        return null;
    L5:
        ParsePosition r0 = new ParsePosition(0);
        Date r3 = STANDARD_DATE_FORMAT.get().parse(r10, r0);
        if (r0.getIndex() != r10.length()) goto L8;
        return r3;
    L8:
        String[] r4 = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        monitor-enter(r4);
        int r5 = r4.length;     // Catch: Throwable -> L22
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L20;
        DateFormat[] r7 = BROWSER_COMPATIBLE_DATE_FORMATS;     // Catch: Throwable -> L22
        DateFormat r8 = r7[r6];     // Catch: Throwable -> L22
        if (r8 != null) goto L15;
        r8 = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[r6], Locale.US);     // Catch: Throwable -> L22
        r8.setTimeZone(Util.UTC);     // Catch: Throwable -> L22
        r7[r6] = r8;     // Catch: Throwable -> L22
    L15:
        r0.setIndex(0);     // Catch: Throwable -> L22
        Date r9 = r8.parse(r10, r0);     // Catch: Throwable -> L22
        if (r0.getIndex() != 0) goto L17;
        r6 = r6 + 1;     // Catch: Throwable -> L22
        goto L11
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L22
        return r9;
    L20:
        monitor-exit(r4);     // Catch: Throwable -> L22
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public static String format(Date r1) {
        return STANDARD_DATE_FORMAT.get().format(r1);
    }

    private HttpDate() {
    }
}
