package cz.msebera.android.httpclient.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes5.dex */
public interface TrustStrategy {
    boolean isTrusted(X509Certificate[] r1, String r2) throws CertificateException;
}
