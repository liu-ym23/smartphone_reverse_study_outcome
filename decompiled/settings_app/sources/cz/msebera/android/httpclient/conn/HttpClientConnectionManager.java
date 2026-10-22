package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long r1, TimeUnit r3);

    void connect(HttpClientConnection r1, HttpRoute r2, int r3, HttpContext r4) throws IOException;

    void releaseConnection(HttpClientConnection r1, Object r2, long r3, TimeUnit r5);

    ConnectionRequest requestConnection(HttpRoute r1, Object r2);

    void routeComplete(HttpClientConnection r1, HttpRoute r2, HttpContext r3) throws IOException;

    void shutdown();

    void upgrade(HttpClientConnection r1, HttpRoute r2, HttpContext r3) throws IOException;
}
