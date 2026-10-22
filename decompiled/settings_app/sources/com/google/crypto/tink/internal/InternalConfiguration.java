package com.google.crypto.tink.internal;

import com.google.crypto.tink.Configuration;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.proto.KeyData;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InternalConfiguration extends Configuration {

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.InternalConfiguration$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class InternalConfigurationImpl extends InternalConfiguration {
        private final PrimitiveRegistry registry;

        /* synthetic */ InternalConfigurationImpl(PrimitiveRegistry r1, AnonymousClass1 r2) {
            this(r1);
        }

        private InternalConfigurationImpl(PrimitiveRegistry registry) {
            this.registry = registry;
        }

        @Override // com.google.crypto.tink.internal.InternalConfiguration
        public <P> P getLegacyPrimitive(KeyData keyData, Class<P> primitiveClass) throws GeneralSecurityException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.google.crypto.tink.internal.InternalConfiguration
        public <P> P getPrimitive(Key r1, Class<P> r2) throws GeneralSecurityException {
            return (P) this.registry.getPrimitive(r1, r2);
        }

        @Override // com.google.crypto.tink.internal.InternalConfiguration
        public Class<?> getInputPrimitiveClass(Class<?> wrapperClassObject) throws GeneralSecurityException {
            return this.registry.getInputPrimitiveClass(wrapperClassObject);
        }

        @Override // com.google.crypto.tink.internal.InternalConfiguration
        public <B, P> P wrap(PrimitiveSet<B> r1, Class<P> r2) throws GeneralSecurityException {
            return (P) this.registry.wrap(r1, r2);
        }
    }

    public abstract Class<?> getInputPrimitiveClass(Class<?> wrapperClassObject) throws GeneralSecurityException;

    public abstract <P> P getLegacyPrimitive(KeyData keyData, Class<P> primitiveClass) throws GeneralSecurityException;

    public abstract <P> P getPrimitive(Key key, Class<P> primitiveClass) throws GeneralSecurityException;

    public abstract <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> clazz) throws GeneralSecurityException;

    public InternalConfiguration() {
    }

    public static InternalConfiguration createFromPrimitiveRegistry(PrimitiveRegistry registry) {
        return new InternalConfigurationImpl(registry, null);
    }
}
