package com.obric.security.keystore;

/* JADX INFO: loaded from: classes.dex */
public class ObricAesCipherSpi extends ObricKeyStoreCipherSpiBase {
    private final String mAlgorithm;

    public static final class AES256_GCM_NoPadding extends ObricAesCipherSpi {
        public AES256_GCM_NoPadding() {
            super("AES_256/GCM/NoPadding");
        }
    }

    public ObricAesCipherSpi(String algorithm) {
        this.mAlgorithm = algorithm;
    }

    protected String getAlgorithm() {
        return this.mAlgorithm;
    }
}
