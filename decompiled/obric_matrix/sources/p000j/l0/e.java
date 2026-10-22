package p000j.l0;

import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static int a(IOException r2, int r3) {
        if (r2 != null) goto L21;
        return r3;
    L21:
        int r0 = b(r2.getMessage(), r3);     // Catch: Throwable -> L18
        if (r0 == r3) goto L19;
        return r0;
    L19:
        Throwable r4 = r2.getCause();     // Catch: Throwable -> L15
        if (r4 != null) goto L10;
        return r0;
    L10:
        String r5 = r4.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return r0;
    L13:
        return b(r5, r3);
    L15:
        r3 = r0;
    L17:
        return r3;
    }

    private static int b(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r2;
    L6:
        if (r1.contains("ECONNRESET") == false) goto L8;
    L39:
        return NetError.ERR_CONNECTION_RESET;
    L8:
        if (r1.contains("Connection reset") == true) goto L39;
        if (r1.contains("reset by peer") == true) goto L39;
        if (r1.contains("ECONNREFUSED") == false) goto L16;
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r1.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
    L18:
        if (r1.contains("connection abort") == true) goto L38;
        if (r1.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r1.contains("Network is unreachable") == true) goto L37;
        if (r1.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r1.contains("ENETUNREACH") == true) goto L36;
        if (r1.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r1.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r2;
    }

    public static int c(IOException r2) {
        if ((r2 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r2 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r2 instanceof SSLProtocolException) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if ((r2 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r2 instanceof UnknownHostException) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if ((r2 instanceof ConnectException) == false) goto L22;
        int r0 = NetError.ERR_CONNECTION_FAILED;
    L67:
        return a(r2, r0);
    L22:
        if ((r2 instanceof PortUnreachableException) == false) goto L25;
        return NetError.ERR_ADDRESS_INVALID;
    L25:
        if ((r2 instanceof NoRouteToHostException) == false) goto L28;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if ((r2 instanceof BindException) == false) goto L31;
        return NetError.ERR_ADDRESS_IN_USE;
    L31:
        if ((r2 instanceof SocketException) == false) goto L34;
        r0 = -15;
        goto L67
    L34:
        if ((r2 instanceof MalformedURLException) == false) goto L37;
        return NetError.ERR_INVALID_URL;
    L37:
        if ((r2 instanceof SocketTimeoutException) == false) goto L40;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L40:
        if ((r2 instanceof ProtocolException) == false) goto L43;
        return -901;
    L43:
        if ((r2 instanceof HttpRetryException) == false) goto L51;
        String r3 = r2.getMessage();
        if (TextUtils.isEmpty(r3) == true) goto L75;
        if (r3.contains("Too many follow-up requests") == false) goto L75;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L75:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L51:
        if ((r2 instanceof UnknownServiceException) == false) goto L53;
        return -902;
    L53:
        if (r2 == null) goto L58;
        if ("Canceled#Reason=-199".equals(r2.getMessage()) == false) goto L58;
        return f.f18163c;
    L58:
        if (d(r2) == true) goto L78;
        return -1;
    L78:
        return f.f18162b;
    }

    public static boolean d(IOException r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if ("Canceled#Reason=-192".equals(r4.getMessage()) == false) goto L9;
        return true;
    L9:
        if ((r4 instanceof InterruptedIOException) == false) goto L17;
        Throwable r5 = r4.getCause();
        if (r5 == null) goto L17;
        if (TextUtils.isEmpty(r5.getMessage()) == true) goto L17;
        if ("Canceled#Reason=-192".equals(r5.getMessage()) == false) goto L17;
        return true;
    L17:
        return false;
    }
}
