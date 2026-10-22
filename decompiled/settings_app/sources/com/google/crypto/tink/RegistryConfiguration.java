package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public class RegistryConfiguration {
    private RegistryConfiguration() {
    }

    public static Configuration get() throws GeneralSecurityException {
        return com.google.crypto.tink.internal.RegistryConfiguration.get();
    }
}
