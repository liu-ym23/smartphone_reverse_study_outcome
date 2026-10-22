package cz.msebera.android.httpclient.conn.socket;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionSocketFactory {
    Socket connectSocket(int r1, Socket r2, HttpHost r3, InetSocketAddress r4, InetSocketAddress r5, HttpContext r6) throws IOException;

    Socket createSocket(HttpContext r1) throws IOException;
}
