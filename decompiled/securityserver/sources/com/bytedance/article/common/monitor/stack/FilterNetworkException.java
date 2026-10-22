package com.bytedance.article.common.monitor.stack;

import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class FilterNetworkException {
    public FilterNetworkException() {
    }

    public static boolean filterException(Throwable r3) {
        if (r3 != null) goto L47;
        return false;
    L47:
    L44:
        th = move-exception;
        th.printStackTrace();
    L46:
        return false;
    L6:
        if ((r3 instanceof ConnectTimeoutException) == false) goto L9;
        return true;
    L9:
        if ((r3 instanceof SocketTimeoutException) == false) goto L12;
        return true;
    L12:
        if ((r3 instanceof BindException) == false) goto L15;
        return true;
    L15:
        if ((r3 instanceof ConnectException) == false) goto L18;
        return true;
    L18:
        if ((r3 instanceof NoRouteToHostException) == false) goto L21;
        return true;
    L21:
        if ((r3 instanceof PortUnreachableException) == false) goto L24;
        return true;
    L24:
        if ((r3 instanceof SocketException) == false) goto L27;
        return true;
    L27:
        if ((r3 instanceof UnknownHostException) == false) goto L30;
        return true;
    L30:
        if ((r3 instanceof NoRouteToHostException) == false) goto L33;
        return true;
    L33:
        if ((r3 instanceof ProtocolException) == false) goto L36;
        return true;
    L36:
        if ((r3 instanceof SSLException) == false) goto L39;
        return true;
    L39:
        if ((r3 instanceof ConnectTimeoutException) == false) goto L41;
        return true;
    L41:
        if ((r3 instanceof SSLHandshakeException) == false) goto L46;
        return true;
    }
}
