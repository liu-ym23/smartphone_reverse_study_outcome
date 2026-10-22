package cz.msebera.android.httpclient.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes5.dex */
public class TrustSelfSignedStrategy implements TrustStrategy {
    public static final TrustSelfSignedStrategy INSTANCE = null;

    public TrustSelfSignedStrategy() {
    }

    static {
        INSTANCE = new TrustSelfSignedStrategy();
    }

    @Override // cz.msebera.android.httpclient.ssl.TrustStrategy
    public boolean isTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        if (r1.length == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
