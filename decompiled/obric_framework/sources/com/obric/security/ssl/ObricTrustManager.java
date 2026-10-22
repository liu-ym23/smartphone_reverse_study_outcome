package com.obric.security.ssl;

import android.util.Log;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class ObricTrustManager {
    private static final String TAG = "ObricTrustManager";
    private final ObricCertificateStoreManager mCertManager;

    public ObricTrustManager() {
        this.mCertManager = ObricCertificateStoreManager.getInstance();
    }

    public void verifyRootCertificate(X509Certificate x509Certificate, int type) throws CertificateException {
        if (x509Certificate == null) goto L6;
        this.mCertManager.verifyRootCertificate(x509Certificate, type);
        return;
    L6:
        throw new CertificateException("cert is null.");
    }

    public void verityCertificateChain(X509Certificate[] chain, int type) throws CertificateException {
        if (chain == null) goto L20;
        if (chain.length < 1) goto L20;
        int i = 1;
    L7:
        if (i >= chain.length) goto L17;
        if (chain[i].getSubjectDN().equals(chain[i - 1].getIssuerDN()) == false) goto L16;
        PublicKey publicKey = chain[i].getPublicKey();     // Catch: Throwable -> L12
        chain[i - 1].verify(publicKey);     // Catch: Throwable -> L12
        i = i + 1;
    L12:
        e = move-exception;
        throw new CertificateException("Cert chain verify failed, " + e.getMessage());
    L16:
        throw new CertificateException("cert issuer info error.");
    L17:
        int i2 = chain.length;
        verifyRootCertificate(chain[i2 - 1], type);
        return;
    L20:
        throw new CertificateException("certificate chain is null.");
    }

    public void verityCertificateChain(X509Certificate[] chain, String authType) throws CertificateException {
        if (chain == null) goto L19;
        if (chain.length < 1) goto L19;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: Throwable -> L15
        KeyStore r2 = (KeyStore) null;     // Catch: Throwable -> L15
        trustManagerFactory.init(null);     // Catch: Throwable -> L15
        TrustManager[] r1 = trustManagerFactory.getTrustManagers();
        int r3 = r1.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L14;
        TrustManager trustManager = r1[r4];
        if ((trustManager instanceof X509TrustManager) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        x509TrustManager.checkClientTrusted(chain, authType);
        Log.d(TAG, "check service success.");
        return;
    L14:
        return;
    L15:
        e = move-exception;
        throw new CertificateException(e);
    L19:
        throw new CertificateException("certificate chain is null.");
    }
}
