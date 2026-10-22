package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public final class DateUtils {
    private static final String[] DEFAULT_PATTERNS = null;
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START = null;
    public static final TimeZone GMT = null;
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static final class DateFormatHolder {
        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = null;

        DateFormatHolder() {
        }

        static {
            THREADLOCAL_FORMATS = new ThreadLocal();
        }

        public static SimpleDateFormat formatFor(String r3) {
            ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> r0 = THREADLOCAL_FORMATS;
            SoftReference<Map<String, SimpleDateFormat>> r1 = r0.get();
            if (r1 != null) goto L5;
            Map<String, SimpleDateFormat> r2 = null;
        L6:
            if (r2 != null) goto L8;
            r2 = new HashMap();
            r0.set(new SoftReference(r2));
        L8:
            SimpleDateFormat r4 = r2.get(r3);
            if (r4 != null) goto L12;
            SimpleDateFormat r5 = new SimpleDateFormat(r3, Locale.US);
            r5.setTimeZone(TimeZone.getTimeZone("GMT"));
            r2.put(r3, r5);
            return r5;
        L12:
            return r4;
        L5:
            r2 = r1.get();
            goto L6
        }

        public static void clearThreadLocal() {
            THREADLOCAL_FORMATS.remove();
        }
    }

    static {
        DEFAULT_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
        TimeZone r0 = TimeZone.getTimeZone("GMT");
        GMT = r0;
        Calendar r8 = Calendar.getInstance();
        r8.setTimeZone(r0);
        r8.set(2000, 0, 1, 0, 0, 0);
        r8.set(14, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = r8.getTime();
    }

    public static Date parseDate(String r1) {
        return parseDate(r1, null, null);
    }

    public static Date parseDate(String r1, String[] r2) {
        return parseDate(r1, r2, null);
    }

    public static Date parseDate(String r5, String[] r6, Date r7) {
        Args.notNull(r5, "Date value");
        if (r6 != null) goto L6;
        r6 = DEFAULT_PATTERNS;
    L6:
        if (r7 != null) goto L10;
        r7 = DEFAULT_TWO_DIGIT_YEAR_START;
    L10:
        if (r5.length() > 1) goto L12;
    L16:
        int r0 = r6.length;
        int r2 = 0;
    L17:
        if (r2 >= r0) goto L22;
        SimpleDateFormat r3 = DateFormatHolder.formatFor(r6[r2]);
        r3.set2DigitYearStart(r7);
        ParsePosition r4 = new ParsePosition(0);
        Date r8 = r3.parse(r5, r4);
        if (r4.getIndex() != 0) goto L20;
        r2 = r2 + 1;
        goto L17
    L20:
        return r8;
    L22:
        return null;
    L12:
        if (r5.startsWith("'") == false) goto L16;
        if (r5.endsWith("'") == false) goto L16;
        r5 = r5.substring(1, r5.length() - 1);
        goto L16
    }

    public static String formatDate(Date r1) {
        return formatDate(r1, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static String formatDate(Date r1, String r2) {
        Args.notNull(r1, "Date");
        Args.notNull(r2, "Pattern");
        return DateFormatHolder.formatFor(r2).format(r1);
    }

    public static void clearThreadLocal() {
        DateFormatHolder.clearThreadLocal();
    }

    private DateUtils() {
    }
}
