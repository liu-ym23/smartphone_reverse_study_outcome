package com.bytedance.security.trust;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public class TrustManager {
    private TrustManager() {
    }

    public static TrustManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public void checkClientTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        throw new RuntimeException("Stub!!");
    }

    public void checkServerTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        throw new RuntimeException("Stub!!");
    }
}
