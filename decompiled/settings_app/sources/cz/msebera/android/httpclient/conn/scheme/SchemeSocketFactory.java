package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface SchemeSocketFactory {
    Socket connectSocket(Socket r1, InetSocketAddress r2, InetSocketAddress r3, HttpParams r4) throws IOException, UnknownHostException, ConnectTimeoutException;

    Socket createSocket(HttpParams r1) throws IOException;

    boolean isSecure(Socket r1) throws IllegalArgumentException;
}
