package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamingAeadConfig {
    public static final String AES_CTR_HMAC_STREAMINGAEAD_TYPE_URL = null;
    public static final String AES_GCM_HKDF_STREAMINGAEAD_TYPE_URL = null;
    public static final RegistryConfig LATEST = null;

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = null;

    private static String initializeClassReturnInput(String s) {
        return s;
    }

    static {
        AES_CTR_HMAC_STREAMINGAEAD_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey");
        AES_GCM_HKDF_STREAMINGAEAD_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey");
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
        StreamingAeadWrapper.register();
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        AesCtrHmacStreamingKeyManager.register(true);
        AesGcmHkdfStreamingKeyManager.register(true);
    }

    private StreamingAeadConfig() {
    }
}
