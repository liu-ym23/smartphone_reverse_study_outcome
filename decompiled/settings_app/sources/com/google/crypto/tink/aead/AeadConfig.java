package com.google.crypto.tink.aead;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class AeadConfig {
    public static final String AES_CTR_HMAC_AEAD_TYPE_URL = null;
    public static final String AES_EAX_TYPE_URL = null;
    public static final String AES_GCM_SIV_TYPE_URL = null;
    public static final String AES_GCM_TYPE_URL = null;
    public static final String CHACHA20_POLY1305_TYPE_URL = null;
    public static final String KMS_AEAD_TYPE_URL = null;
    public static final String KMS_ENVELOPE_AEAD_TYPE_URL = null;

    @Deprecated
    public static final RegistryConfig LATEST = null;

    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = null;

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = null;
    public static final String XCHACHA20_POLY1305_TYPE_URL = null;

    private static String initializeClassReturnInput(String s) {
        return s;
    }

    static {
        AES_CTR_HMAC_AEAD_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        AES_GCM_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.AesGcmKey");
        AES_GCM_SIV_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        AES_EAX_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.AesEaxKey");
        KMS_AEAD_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        KMS_ENVELOPE_AEAD_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        CHACHA20_POLY1305_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        XCHACHA20_POLY1305_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        RegistryConfig r0 = RegistryConfig.getDefaultInstance();
        TINK_1_0_0 = r0;
        TINK_1_1_0 = r0;
        LATEST = r0;
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
        AeadWrapper.register();
        MacConfig.register();
        AesCtrHmacAeadKeyManager.register(true);
        AesGcmKeyManager.register(true);
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        AesEaxKeyManager.register(true);
        AesGcmSivKeyManager.register(true);
        ChaCha20Poly1305KeyManager.register(true);
        KmsAeadKeyManager.register(true);
        KmsEnvelopeAeadKeyManager.register(true);
        XChaCha20Poly1305KeyManager.register(true);
    }

    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        register();
    }

    private AeadConfig() {
    }
}
