package cz.msebera.android.httpclient.impl.cookie;

import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class DateUtils {
    public static final TimeZone GMT = null;
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static {
        GMT = TimeZone.getTimeZone("GMT");
    }

    public static Date parseDate(String r1) throws DateParseException {
        return parseDate(r1, null, null);
    }

    public static Date parseDate(String r1, String[] r2) throws DateParseException {
        return parseDate(r1, r2, null);
    }

    public static Date parseDate(String r1, String[] r2, Date r3) throws DateParseException {
        Date r4 = cz.msebera.android.httpclient.client.utils.DateUtils.parseDate(r1, r2, r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        throw new DateParseException("Unable to parse the date " + r1);
    }

    public static String formatDate(Date r0) {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(r0);
    }

    public static String formatDate(Date r0, String r1) {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(r0, r1);
    }

    private DateUtils() {
    }
}
