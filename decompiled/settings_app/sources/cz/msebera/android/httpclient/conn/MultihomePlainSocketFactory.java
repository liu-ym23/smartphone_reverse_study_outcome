package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class MultihomePlainSocketFactory implements SocketFactory {
    private static final MultihomePlainSocketFactory DEFAULT_FACTORY = null;

    static {
        DEFAULT_FACTORY = new MultihomePlainSocketFactory();
    }

    public static MultihomePlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    private MultihomePlainSocketFactory() {
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() {
        return new Socket();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket connectSocket(Socket r2, String r3, int r4, InetAddress r5, int r6, HttpParams r7) throws IOException {
        Args.notNull(r3, "Target host");
        Args.notNull(r7, "HTTP parameters");
        if (r2 != null) goto L5;
        r2 = createSocket();
    L5:
        if (r5 != null) goto L8;
        if (r6 > 0) goto L8;
    L12:
        int r1 = HttpConnectionParams.getConnectionTimeout(r7);
        InetAddress[] r8 = InetAddress.getAllByName(r3);
        ArrayList r9 = new ArrayList(r8.length);
        r9.addAll(Arrays.asList(r8));
        Collections.shuffle(r9);
        Iterator r10 = r9.iterator();
        IOException r11 = null;
    L14:
        if (r10.hasNext() == false) goto L22;
        InetAddress r12 = (InetAddress) r10.next();
        r2.connect(new InetSocketAddress(r12, r4), r1);     // Catch: IOException -> L18 SocketTimeoutException -> L20
    L18:
        e = move-exception;
        r11 = e;
        r2 = new Socket();
    L21:
        throw new ConnectTimeoutException("Connect to " + r12 + " timed out");
    L22:
        if (r11 != null) goto L24;
        return r2;
    L24:
        throw r11;
    L8:
        if (r6 > 0) goto L11;
        r6 = 0;
    L11:
        r2.bind(new InetSocketAddress(r5, r6));
        goto L12
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public final boolean isSecure(Socket r1) throws IllegalArgumentException {
        Args.notNull(r1, "Socket");
        Asserts.check(!r1.isClosed(), "Socket is closed");
        return false;
    }
}
