package cz.msebera.android.httpclient.conn.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SSLContexts {
    public SSLContexts() {
    }

    public static SSLContext createDefault() throws SSLInitializationException {
        SSLContext r0 = SSLContext.getInstance("TLS");     // Catch: KeyManagementException -> L4 NoSuchAlgorithmException -> L7
        r0.init(null, null, null);     // Catch: KeyManagementException -> L4 NoSuchAlgorithmException -> L7
        return r0;
    L4:
        e = move-exception;
        throw new SSLInitializationException(e.getMessage(), e);
    L7:
        e = move-exception;
        throw new SSLInitializationException(e.getMessage(), e);
    }

    public static SSLContext createSystemDefault() throws SSLInitializationException {
        return SSLContext.getDefault();
    L5:
        return createDefault();
    }

    public static SSLContextBuilder custom() {
        return new SSLContextBuilder();
    }
}
