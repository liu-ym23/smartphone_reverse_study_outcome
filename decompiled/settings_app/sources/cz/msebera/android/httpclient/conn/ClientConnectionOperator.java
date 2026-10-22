package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface ClientConnectionOperator {
    OperatedClientConnection createConnection();

    void openConnection(OperatedClientConnection r1, HttpHost r2, InetAddress r3, HttpContext r4, HttpParams r5) throws IOException;

    void updateSecureConnection(OperatedClientConnection r1, HttpHost r2, HttpContext r3, HttpParams r4) throws IOException;
}
