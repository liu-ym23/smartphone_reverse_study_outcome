package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class IdleConnectionHandler {
    private final Map<HttpConnection, TimeValues> connectionToTimes;
    public HttpClientAndroidLog log;

    private static class TimeValues {
        private final long timeAdded;
        private final long timeExpires;

        static /* synthetic */ long access$000(TimeValues r2) {
            return r2.timeExpires;
        }

        static /* synthetic */ long access$100(TimeValues r2) {
            return r2.timeAdded;
        }

        TimeValues(long r3, long r5, TimeUnit r7) {
            this.timeAdded = r3;
            if (r5 <= 0) goto L5;
            this.timeExpires = r3 + r7.toMillis(r5);
            return;
        L5:
            this.timeExpires = Long.MAX_VALUE;
        }
    }

    public IdleConnectionHandler() {
        this.log = new HttpClientAndroidLog(getClass());
        this.connectionToTimes = new HashMap();
    }

    public void add(HttpConnection r8, long r9, TimeUnit r11) {
        long r1 = System.currentTimeMillis();
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Adding connection at: " + r1);
    L5:
        this.connectionToTimes.put(r8, new TimeValues(r1, r9, r11));
    }

    public boolean remove(HttpConnection r4) {
        TimeValues r5 = this.connectionToTimes.remove(r4);
        if (r5 != null) goto L7;
        this.log.warn("Removing a connection that never existed!");
        return true;
    L7:
        if (System.currentTimeMillis() <= TimeValues.access$000(r5)) goto L11;
        return false;
    L11:
        return true;
    }

    public void removeAll() {
        this.connectionToTimes.clear();
    }

    public void closeIdleConnections(long r8) {
        long r0 = System.currentTimeMillis() - r8;
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Checking for connections, idle timeout: " + r0);
    L5:
        Iterator<Map.Entry<HttpConnection, TimeValues>> r9 = this.connectionToTimes.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L17;
        Map.Entry<HttpConnection, TimeValues> r10 = r9.next();
        HttpConnection r2 = r10.getKey();
        long r3 = TimeValues.access$100(r10.getValue());
        if (r3 > r0) goto L7;
        if (this.log.isDebugEnabled() == false) goto L18;
        this.log.debug("Closing idle connection, connection time: " + r3);
    L18:
        r2.close();     // Catch: IOException -> L15
    L15:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
        goto L7
    }

    public void closeExpiredConnections() {
        long r0 = System.currentTimeMillis();
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Checking for expired connections, now: " + r0);
    L5:
        Iterator<Map.Entry<HttpConnection, TimeValues>> r2 = this.connectionToTimes.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<HttpConnection, TimeValues> r3 = r2.next();
        HttpConnection r4 = r3.getKey();
        TimeValues r5 = r3.getValue();
        if (TimeValues.access$000(r5) > r0) goto L7;
        if (this.log.isDebugEnabled() == false) goto L18;
        this.log.debug("Closing connection, expired @: " + TimeValues.access$000(r5));
    L18:
        r4.close();     // Catch: IOException -> L15
    L15:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
        goto L7
    }
}
