package cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public class NoopHostnameVerifier implements HostnameVerifier {
    public static final NoopHostnameVerifier INSTANCE = null;

    public final String toString() {
        return "NO_OP";
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r1, SSLSession r2) {
        return true;
    }

    public NoopHostnameVerifier() {
    }

    static {
        INSTANCE = new NoopHostnameVerifier();
    }
}
