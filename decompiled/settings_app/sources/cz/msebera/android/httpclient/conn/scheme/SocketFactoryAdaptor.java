package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class SocketFactoryAdaptor implements SocketFactory {
    private final SchemeSocketFactory factory;

    SocketFactoryAdaptor(SchemeSocketFactory r1) {
        this.factory = r1;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        BasicHttpParams r0 = new BasicHttpParams();
        return this.factory.createSocket(r0);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket connectSocket(Socket r2, String r3, int r4, InetAddress r5, int r6, HttpParams r7) throws IOException, UnknownHostException, ConnectTimeoutException {
        if (r5 != null) goto L7;
        if (r6 > 0) goto L7;
        InetSocketAddress r8 = null;
    L11:
        InetSocketAddress r9 = new InetSocketAddress(InetAddress.getByName(r3), r4);
        return this.factory.connectSocket(r2, r9, r8, r7);
    L7:
        if (r6 > 0) goto L10;
        r6 = 0;
    L10:
        r8 = new InetSocketAddress(r5, r6);
        goto L11
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public boolean isSecure(Socket r1) throws IllegalArgumentException {
        return this.factory.isSecure(r1);
    }

    public SchemeSocketFactory getFactory() {
        return this.factory;
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (this != r2) goto L9;
        return true;
    L9:
        if ((r2 instanceof SocketFactoryAdaptor) == false) goto L12;
        return this.factory.equals(((SocketFactoryAdaptor) r2).factory);
    L12:
        return this.factory.equals(r2);
    }

    public int hashCode() {
        return this.factory.hashCode();
    }
}
