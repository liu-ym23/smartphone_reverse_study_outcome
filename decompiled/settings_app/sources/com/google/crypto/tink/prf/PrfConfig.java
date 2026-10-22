package com.google.crypto.tink.prf;

import com.google.crypto.tink.config.TinkFips;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class PrfConfig {
    public static final String HMAC_PRF_TYPE_URL = null;
    public static final String PRF_TYPE_URL = null;

    static {
        PRF_TYPE_URL = HkdfPrfKeyManager.getKeyType();
        HMAC_PRF_TYPE_URL = HmacPrfKeyManager.getKeyType();
    }

    public static void register() throws GeneralSecurityException {
        PrfSetWrapper.register();
        HmacPrfKeyManager.register(true);
        if (TinkFips.useOnlyFips() == false) goto L5;
        return;
    L5:
        AesCmacPrfKeyManager.register(true);
        HkdfPrfKeyManager.register(true);
    }

    private PrfConfig() {
    }
}
