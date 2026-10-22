package com.obric.security.keystore;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyStorePrivateKey extends ObricKeyStoreKey implements PrivateKey {
    public ObricKeyStorePrivateKey(String alias, int uid, String algorithm, byte[] encoded, String format) {
        super(alias, uid, algorithm, encoded, format);
    }
}
