package com.obric.security.keystore;

import java.security.Key;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyStoreKey implements Key {
    private final String algorithm;
    protected final String alias;
    private final byte[] encoded;
    private final String format;
    private final int uid;

    public ObricKeyStoreKey(String alias, int uid, String algorithm, byte[] encoded, String format) {
        this.algorithm = algorithm;
        this.alias = alias;
        this.uid = uid;
        this.format = format;
        this.encoded = encoded;
    }

    public int getUid() {
        return this.uid;
    }

    public String getAlias() {
        return this.alias;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.format;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.encoded;
    }
}
