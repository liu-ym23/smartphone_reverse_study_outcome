package com.obric.security.ssl;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyManager {
    private final ObricCertificateStoreManager mCertManager;

    public ObricKeyManager() {
        this.mCertManager = ObricCertificateStoreManager.getInstance();
    }

    public List<X509Certificate> getCertChain(String alias) {
        return this.mCertManager.exportCertChina(alias);
    }

    public PrivateKey getPrivateKey(String alias) {
        return this.mCertManager.loadPrivateKey(alias);
    }

    public long getDoSignAddress(String alias) {
        return this.mCertManager.getDoSignAddress(alias);
    }

    public long getAlgorithmAddress() {
        return this.mCertManager.getAlgorithmAddress();
    }

    public boolean isContainsKey(String alias) {
        return this.mCertManager.isContainsKey(alias);
    }
}
