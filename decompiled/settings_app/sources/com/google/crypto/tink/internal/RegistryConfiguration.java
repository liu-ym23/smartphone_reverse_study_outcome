package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyData;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RegistryConfiguration extends InternalConfiguration {
    private static final RegistryConfiguration CONFIG = null;

    public static RegistryConfiguration get() {
        return CONFIG;
    }

    static {
        CONFIG = new RegistryConfiguration();
    }

    private RegistryConfiguration() {
    }

    @Override // com.google.crypto.tink.internal.InternalConfiguration
    public <P> P getLegacyPrimitive(KeyData r1, Class<P> r2) throws GeneralSecurityException {
        return (P) Registry.getPrimitive(r1, r2);
    }

    @Override // com.google.crypto.tink.internal.InternalConfiguration
    public <P> P getPrimitive(Key r1, Class<P> r2) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(r1, r2);
    }

    @Override // com.google.crypto.tink.internal.InternalConfiguration
    public <B, P> P wrap(PrimitiveSet<B> r1, Class<P> r2) throws GeneralSecurityException {
        return (P) Registry.wrap(r1, r2);
    }

    @Override // com.google.crypto.tink.internal.InternalConfiguration
    @Nullable
    public Class<?> getInputPrimitiveClass(Class<?> wrapperClassObject) {
        return Registry.getInputPrimitive(wrapperClassObject);
    }

    public static InternalConfiguration createFromPrimitiveRegistry(PrimitiveRegistry registry) {
        throw new UnsupportedOperationException("Cannot create RegistryConfiguration from a PrimitiveRegistry");
    }
}
