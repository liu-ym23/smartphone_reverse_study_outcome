package com.obric.security.keystore;

import com.obric.security.tls.TLSConst;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyStoreECDSASignatureSpi extends ObricKeyStoreSignatureSpiBase {
    private final String algorithm;

    public static final class NONE extends ObricKeyStoreECDSASignatureSpi {
        public NONE() {
            super(TLSConst.NONEwithECDSA);
        }
    }

    public static final class SHA1 extends ObricKeyStoreECDSASignatureSpi {
        public SHA1() {
            super(TLSConst.SHA1withECDSA);
        }
    }

    public static final class SHA256 extends ObricKeyStoreECDSASignatureSpi {
        public SHA256() {
            super(TLSConst.SHA256withECDSA);
        }
    }

    public static final class SHA384 extends ObricKeyStoreECDSASignatureSpi {
        public SHA384() {
            super(TLSConst.SHA384withECDSA);
        }
    }

    public static final class SHA512 extends ObricKeyStoreECDSASignatureSpi {
        public SHA512() {
            super(TLSConst.SHA512withECDSA);
        }
    }

    public ObricKeyStoreECDSASignatureSpi(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override // com.obric.security.keystore.ObricKeyStoreSignatureSpiBase
    public String getAlgorithm() {
        return this.algorithm;
    }
}
