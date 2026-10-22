package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class SchemeLayeredSocketFactoryAdaptor2 implements SchemeLayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    SchemeLayeredSocketFactoryAdaptor2(LayeredSchemeSocketFactory r1) {
        this.factory = r1;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams r1) throws IOException {
        return this.factory.createSocket(r1);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket r1, InetSocketAddress r2, InetSocketAddress r3, HttpParams r4) throws IOException, UnknownHostException, ConnectTimeoutException {
        return this.factory.connectSocket(r1, r2, r3, r4);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public boolean isSecure(Socket r1) throws IllegalArgumentException {
        return this.factory.isSecure(r1);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory
    public Socket createLayeredSocket(Socket r1, String r2, int r3, HttpParams r4) throws IOException, UnknownHostException {
        return this.factory.createLayeredSocket(r1, r2, r3, true);
    }
}
