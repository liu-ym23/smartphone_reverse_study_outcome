package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class HybridConfig {
    public static final String ECIES_AEAD_HKDF_PRIVATE_KEY_TYPE_URL = null;
    public static final String ECIES_AEAD_HKDF_PUBLIC_KEY_TYPE_URL = null;

    @Deprecated
    public static final RegistryConfig LATEST = null;

    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = null;

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = null;

    private static String initializeClassReturnInput(String s) {
        return s;
    }

    static {
        ECIES_AEAD_HKDF_PUBLIC_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        ECIES_AEAD_HKDF_PRIVATE_KEY_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
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
        HybridDecryptWrapper.register();
        HybridEncryptWrapper.register();
        AeadConfig.register();
        DeterministicAeadConfig.register();
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        EciesAeadHkdfPrivateKeyManager.registerPair(true);
        HpkePrivateKeyManager.registerPair(true);
    }

    private HybridConfig() {
    }
}
