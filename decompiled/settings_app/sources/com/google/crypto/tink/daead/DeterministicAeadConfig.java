package com.google.crypto.tink.daead;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class DeterministicAeadConfig {
    public static final String AES_SIV_TYPE_URL = null;

    @Deprecated
    public static final RegistryConfig LATEST = null;

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = null;

    private static String initializeClassReturnInput(String s) {
        return s;
    }

    static {
        AES_SIV_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.AesSivKey");
        TINK_1_1_0 = RegistryConfig.getDefaultInstance();
        LATEST = RegistryConfig.getDefaultInstance();
        register();     // Catch: GeneralSecurityException -> L5
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
        DeterministicAeadWrapper.register();
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        AesSivKeyManager.register(true);
    }

    private DeterministicAeadConfig() {
    }
}
