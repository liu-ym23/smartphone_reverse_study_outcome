package com.google.crypto.tink.mac;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class MacConfig {
    public static final String HMAC_TYPE_URL = null;

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
        HMAC_TYPE_URL = initializeClassReturnInput("type.googleapis.com/google.crypto.tink.HmacKey");
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
        MacWrapper.register();
        ChunkedMacWrapper.register();
        HmacKeyManager.register(true);
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        AesCmacKeyManager.register(true);
    }

    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        register();
    }

    private MacConfig() {
    }
}
