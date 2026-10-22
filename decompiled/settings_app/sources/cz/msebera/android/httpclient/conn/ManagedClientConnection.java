package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface ManagedClientConnection extends HttpRoutedConnection, ManagedHttpClientConnection, ConnectionReleaseTrigger {
    @Override // cz.msebera.android.httpclient.conn.HttpRoutedConnection
    HttpRoute getRoute();

    @Override // cz.msebera.android.httpclient.conn.HttpRoutedConnection, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    SSLSession getSSLSession();

    Object getState();

    boolean isMarkedReusable();

    @Override // cz.msebera.android.httpclient.conn.HttpRoutedConnection
    boolean isSecure();

    void layerProtocol(HttpContext r1, HttpParams r2) throws IOException;

    void markReusable();

    void open(HttpRoute r1, HttpContext r2, HttpParams r3) throws IOException;

    void setIdleDuration(long r1, TimeUnit r3);

    void setState(Object r1);

    void tunnelProxy(HttpHost r1, boolean r2, HttpParams r3) throws IOException;

    void tunnelTarget(boolean r1, HttpParams r2) throws IOException;

    void unmarkReusable();
}
