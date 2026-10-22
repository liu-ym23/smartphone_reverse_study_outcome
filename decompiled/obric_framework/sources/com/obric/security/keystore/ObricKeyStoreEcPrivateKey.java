package com.obric.security.keystore;

import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyStoreEcPrivateKey extends ObricKeyStoreKey implements ECPrivateKey {
    private final BigInteger s;
    private final ECParameterSpec spec;

    public ObricKeyStoreEcPrivateKey(String alias, int uid, String algorithm, String format, byte[] encoded, BigInteger s, ECParameterSpec spec) {
        super(alias, uid, algorithm, encoded, format);
        this.s = s;
        this.spec = spec;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.s;
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.spec;
    }
}
