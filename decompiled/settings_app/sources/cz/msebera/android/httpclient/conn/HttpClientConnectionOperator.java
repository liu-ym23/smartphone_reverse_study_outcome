package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClientConnectionOperator {
    void connect(ManagedHttpClientConnection r1, HttpHost r2, InetSocketAddress r3, int r4, SocketConfig r5, HttpContext r6) throws IOException;

    void upgrade(ManagedHttpClientConnection r1, HttpHost r2, HttpContext r3) throws IOException;
}
