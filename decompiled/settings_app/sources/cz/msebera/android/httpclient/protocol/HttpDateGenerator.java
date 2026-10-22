package cz.msebera.android.httpclient.protocol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public class HttpDateGenerator {
    public static final TimeZone GMT = null;
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    private long dateAsLong;
    private String dateAsText;
    private final DateFormat dateformat;

    static {
        GMT = TimeZone.getTimeZone("GMT");
    }

    public HttpDateGenerator() {
        this.dateAsLong = 0;
        this.dateAsText = null;
        SimpleDateFormat r0 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        this.dateformat = r0;
        r0.setTimeZone(GMT);
    }

    public synchronized String getCurrentDate() {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L9
        if ((r0 - this.dateAsLong) <= 1000) goto L6;
        this.dateAsText = this.dateformat.format(new Date(r0));     // Catch: Throwable -> L9
        this.dateAsLong = r0;     // Catch: Throwable -> L9
    L6:
        String r1 = this.dateAsText;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    L9:
        th = move-exception;
        throw th;
    }
}
