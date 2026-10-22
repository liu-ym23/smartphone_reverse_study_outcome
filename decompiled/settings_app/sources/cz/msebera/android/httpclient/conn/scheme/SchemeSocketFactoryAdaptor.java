package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class SchemeSocketFactoryAdaptor implements SchemeSocketFactory {
    private final SocketFactory factory;

    SchemeSocketFactoryAdaptor(SocketFactory r1) {
        this.factory = r1;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket r8, InetSocketAddress r9, InetSocketAddress r10, HttpParams r11) throws IOException, UnknownHostException, ConnectTimeoutException {
        String r2 = r9.getHostName();
        int r3 = r9.getPort();
        if (r10 == null) goto L5;
        InetAddress r12 = r10.getAddress();
        int r13 = r10.getPort();
    L6:
        SocketFactory r0 = this.factory;
        return r0.connectSocket(r8, r2, r3, r12, r13, r11);
    L5:
        r12 = null;
        r13 = 0;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams r1) throws IOException {
        return this.factory.createSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public boolean isSecure(Socket r1) throws IllegalArgumentException {
        return this.factory.isSecure(r1);
    }

    public SocketFactory getFactory() {
        return this.factory;
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (this != r2) goto L9;
        return true;
    L9:
        if ((r2 instanceof SchemeSocketFactoryAdaptor) == false) goto L12;
        return this.factory.equals(((SchemeSocketFactoryAdaptor) r2).factory);
    L12:
        return this.factory.equals(r2);
    }

    public int hashCode() {
        return this.factory.hashCode();
    }
}
