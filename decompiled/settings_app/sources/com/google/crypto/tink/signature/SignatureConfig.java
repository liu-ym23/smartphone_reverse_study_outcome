package com.google.crypto.tink.signature;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class SignatureConfig {
    public static final String ECDSA_PRIVATE_KEY_TYPE_URL = null;
    public static final String ECDSA_PUBLIC_KEY_TYPE_URL = null;
    public static final String ED25519_PRIVATE_KEY_TYPE_URL = null;
    public static final String ED25519_PUBLIC_KEY_TYPE_URL = null;

    @Deprecated
    public static final RegistryConfig LATEST = null;
    public static final String RSA_PKCS1_PRIVATE_KEY_TYPE_URL = null;
    public static final String RSA_PKCS1_PUBLIC_KEY_TYPE_URL = null;
    public static final String RSA_PSS_PRIVATE_KEY_TYPE_URL = null;
    public static final String RSA_PSS_PUBLIC_KEY_TYPE_URL = null;

    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = null;

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = null;

    private static String initializeClassReturnInput(String s) {
        return s;
    }

    static {
        ECDSA_PUBLIC_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.EcdsaPublicKey");
        ECDSA_PRIVATE_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
        ED25519_PUBLIC_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.Ed25519PublicKey");
        ED25519_PRIVATE_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey");
        RSA_PKCS1_PRIVATE_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey");
        RSA_PKCS1_PUBLIC_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey");
        RSA_PSS_PRIVATE_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey");
        RSA_PSS_PUBLIC_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey");
        TINK_1_0_0 = RegistryConfig.getDefaultInstance();
        TINK_1_1_0 = RegistryConfig.getDefaultInstance();
        LATEST = RegistryConfig.getDefaultInstance();
        init();     // Catch: GeneralSecurityException -> L5
        return;
    L5:
        e = move-exception;
        throw new ExceptionInInitializerError(e);
    }

    @Deprecated
    public static void init() throws GeneralSecurityException {
        register();
    }

    public static void register() throws GeneralSecurityException {
        PublicKeySignWrapper.register();
        PublicKeyVerifyWrapper.register();
        EcdsaSignKeyManager.registerPair(true);
        RsaSsaPkcs1SignKeyManager.registerPair(true);
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        RsaSsaPssSignKeyManager.registerPair(true);
        Ed25519PrivateKeyManager.registerPair(true);
    }

    private SignatureConfig() {
    }
}
