package cz.msebera.android.httpclient.conn.socket;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public class PlainConnectionSocketFactory implements ConnectionSocketFactory {
    public static final PlainConnectionSocketFactory INSTANCE = null;

    static {
        INSTANCE = new PlainConnectionSocketFactory();
    }

    public static PlainConnectionSocketFactory getSocketFactory() {
        return INSTANCE;
    }

    public PlainConnectionSocketFactory() {
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket createSocket(HttpContext r1) throws IOException {
        return new Socket();
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket connectSocket(int r1, Socket r2, HttpHost r3, InetSocketAddress r4, InetSocketAddress r5, HttpContext r6) throws IOException {
        if (r2 != null) goto L5;
        r2 = createSocket(r6);
    L5:
        if (r5 == null) goto L15;
        r2.bind(r5);
    L15:
        r2.connect(r4, r1);     // Catch: IOException -> L9
        return r2;
    L9:
        e = move-exception;
        r2.close();     // Catch: IOException -> L12
    L11:
        throw e;
    }
}
