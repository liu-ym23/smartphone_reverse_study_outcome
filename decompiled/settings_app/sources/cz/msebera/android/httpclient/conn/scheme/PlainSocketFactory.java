package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class PlainSocketFactory implements SocketFactory, SchemeSocketFactory {
    private final HostNameResolver nameResolver;

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public final boolean isSecure(Socket r1) {
        return false;
    }

    public static PlainSocketFactory getSocketFactory() {
        return new PlainSocketFactory();
    }

    @Deprecated
    public PlainSocketFactory(HostNameResolver r1) {
        this.nameResolver = r1;
    }

    public PlainSocketFactory() {
        this.nameResolver = null;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams r1) {
        return new Socket();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() {
        return new Socket();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket r2, InetSocketAddress r3, InetSocketAddress r4, HttpParams r5) throws IOException, ConnectTimeoutException {
        Args.notNull(r3, "Remote address");
        Args.notNull(r5, "HTTP parameters");
        if (r2 != null) goto L5;
        r2 = createSocket();
    L5:
        if (r4 == null) goto L7;
        r2.setReuseAddress(HttpConnectionParams.getSoReuseaddr(r5));
        r2.bind(r4);
    L7:
        int r1 = HttpConnectionParams.getConnectionTimeout(r5);
        r2.setSoTimeout(HttpConnectionParams.getSoTimeout(r5));     // Catch: SocketTimeoutException -> L10
        r2.connect(r3, r1);     // Catch: SocketTimeoutException -> L10
        return r2;
    L11:
        throw new ConnectTimeoutException("Connect to " + r3 + " timed out");
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    @Deprecated
    public Socket connectSocket(Socket r2, String r3, int r4, InetAddress r5, int r6, HttpParams r7) throws IOException, UnknownHostException, ConnectTimeoutException {
        if (r5 != null) goto L7;
        if (r6 > 0) goto L7;
        InetSocketAddress r8 = null;
    L11:
        HostNameResolver r9 = this.nameResolver;
        if (r9 == null) goto L14;
        InetAddress r10 = r9.resolve(r3);
    L16:
        return connectSocket(r2, new InetSocketAddress(r10, r4), r8, r7);
    L14:
        r10 = InetAddress.getByName(r3);
    L7:
        if (r6 > 0) goto L10;
        r6 = 0;
    L10:
        r8 = new InetSocketAddress(r5, r6);
        goto L11
    }
}
