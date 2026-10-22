package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface OperatedClientConnection extends HttpClientConnection, HttpInetConnection {
    Socket getSocket();

    HttpHost getTargetHost();

    boolean isSecure();

    void openCompleted(boolean r1, HttpParams r2) throws IOException;

    void opening(Socket r1, HttpHost r2) throws IOException;

    void update(Socket r1, HttpHost r2, boolean r3, HttpParams r4) throws IOException;
}
