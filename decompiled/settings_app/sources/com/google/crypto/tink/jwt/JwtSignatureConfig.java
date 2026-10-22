package com.google.crypto.tink.jwt;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class JwtSignatureConfig {
    public static final String JWT_ECDSA_PRIVATE_KEY_TYPE_URL = null;
    public static final String JWT_ECDSA_PUBLIC_KEY_TYPE_URL = null;
    public static final String JWT_RSA_PKCS1_PRIVATE_KEY_TYPE_URL = null;
    public static final String JWT_RSA_PKCS1_PUBLIC_KEY_TYPE_URL = null;
    public static final String JWT_RSA_PSS_PRIVATE_KEY_TYPE_URL = null;
    public static final String JWT_RSA_PSS_PUBLIC_KEY_TYPE_URL = null;
    public static final RegistryConfig LATEST = null;

    static {
        JWT_ECDSA_PUBLIC_KEY_TYPE_URL = JwtEcdsaVerifyKeyManager.getKeyType();
        JWT_ECDSA_PRIVATE_KEY_TYPE_URL = JwtEcdsaSignKeyManager.getKeyType();
        JWT_RSA_PKCS1_PRIVATE_KEY_TYPE_URL = JwtRsaSsaPkcs1SignKeyManager.getKeyType();
        JWT_RSA_PKCS1_PUBLIC_KEY_TYPE_URL = JwtRsaSsaPkcs1VerifyKeyManager.getKeyType();
        JWT_RSA_PSS_PRIVATE_KEY_TYPE_URL = JwtRsaSsaPssSignKeyManager.getKeyType();
        JWT_RSA_PSS_PUBLIC_KEY_TYPE_URL = JwtRsaSsaPssVerifyKeyManager.getKeyType();
        LATEST = RegistryConfig.getDefaultInstance();
    }

    public static void register() throws GeneralSecurityException {
        JwtPublicKeySignWrapper.register();
        JwtPublicKeyVerifyWrapper.register();
        JwtEcdsaSignKeyManager.registerPair(true);
        JwtRsaSsaPkcs1SignKeyManager.registerPair(true);
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        JwtRsaSsaPssSignKeyManager.registerPair(true);
    }

    private JwtSignatureConfig() {
    }
}
