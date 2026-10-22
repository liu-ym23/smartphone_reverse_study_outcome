package cz.msebera.android.httpclient.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes5.dex */
public class TrustAllStrategy implements TrustStrategy {
    public static final TrustAllStrategy INSTANCE = null;

    @Override // cz.msebera.android.httpclient.ssl.TrustStrategy
    public boolean isTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        return true;
    }

    public TrustAllStrategy() {
    }

    static {
        INSTANCE = new TrustAllStrategy();
    }
}
