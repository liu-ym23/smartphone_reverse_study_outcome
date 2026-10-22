package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface SocketFactory {
    Socket connectSocket(Socket r1, String r2, int r3, InetAddress r4, int r5, HttpParams r6) throws IOException, UnknownHostException, ConnectTimeoutException;

    Socket createSocket() throws IOException;

    boolean isSecure(Socket r1) throws IllegalArgumentException;
}
