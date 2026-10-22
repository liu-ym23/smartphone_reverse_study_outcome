package com.android.settings.utils;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public final class GeoTrustManager implements X509TrustManager {
    private static final String PREFIX_SYSTEM = "system";

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public GeoTrustManager() {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        checkTrusted(r1);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        checkTrusted(r1);
    }

    private void checkTrusted(X509Certificate[] r2) throws CertificateException {
        if (r2.length == 0) goto L17;
        r2[0].checkValidity();     // Catch: CertificateNotYetValidException -> L10 CertificateExpiredException -> L13
        if (verifySMCert(r2[r2.length - 1]) == false) goto L9;
        return;
    L9:
        throw new CertificateException("no trust root CA", null);     // Catch: CertificateNotYetValidException -> L10 CertificateExpiredException -> L13
    L13:
        e = move-exception;
        throw new CertificateException("ExtCertPathValidatorException0 CertificateExpiredException", e);
    L10:
        e = move-exception;
        throw new CertificateException("ExtCertPathValidatorException0 CertificateNotYetValidException", e);
    L17:
        throw new CertificateException("No entries in certificate-chain");
    }

    public static boolean verifySMCert(X509Certificate r5) {
        KeyStore r1 = KeyStore.getInstance("AndroidCAStore");     // Catch: Exception -> L13
        r1.load(null, null);     // Catch: Exception -> L13
        Enumeration<String> r2 = r1.aliases();     // Catch: Exception -> L13
    L5:
        if (r2.hasMoreElements() == false) goto L27;
        String r3 = r2.nextElement();     // Catch: Exception -> L13
        if (r3 == null) goto L5;
        if (r3.startsWith("system") == false) goto L5;
        if (((X509Certificate) r1.getCertificate(r3)).getPublicKey().equals(r5.getPublicKey()) == false) goto L5;
        return true;
    L27:
        return false;
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
