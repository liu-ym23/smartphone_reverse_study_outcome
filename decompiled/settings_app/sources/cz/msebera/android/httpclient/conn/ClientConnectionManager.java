package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface ClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long r1, TimeUnit r3);

    SchemeRegistry getSchemeRegistry();

    void releaseConnection(ManagedClientConnection r1, long r2, TimeUnit r4);

    ClientConnectionRequest requestConnection(HttpRoute r1, Object r2);

    void shutdown();
}
