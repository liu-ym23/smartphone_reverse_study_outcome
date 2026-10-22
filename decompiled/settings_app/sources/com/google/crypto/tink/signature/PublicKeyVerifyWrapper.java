package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.monitoring.MonitoringClient;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyVerifyWrapper implements PrimitiveWrapper<PublicKeyVerify, PublicKeyVerify> {
    private static final PrimitiveConstructor<LegacyProtoKey, PublicKeyVerify> LEGACY_PRIMITIVE_CONSTRUCTOR = null;
    private static final PublicKeyVerifyWrapper WRAPPER = null;

    private static class WrappedPublicKeyVerify implements PublicKeyVerify {
        private final MonitoringClient.Logger monitoringLogger;
        private final PrimitiveSet<PublicKeyVerify> primitives;

        public WrappedPublicKeyVerify(PrimitiveSet<PublicKeyVerify> primitives) {
            this.primitives = primitives;
            if (primitives.hasAnnotations() == false) goto L5;
            this.monitoringLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitives), "public_key_verify", "verify");
            return;
        L5:
            this.monitoringLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }

        @Override // com.google.crypto.tink.PublicKeyVerify
        public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
            if (signature.length <= 5) goto L18;
            Iterator<PrimitiveSet.Entry<PublicKeyVerify>> r0 = this.primitives.getPrimitive(Arrays.copyOf(signature, 5)).iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            PrimitiveSet.Entry<PublicKeyVerify> r1 = r0.next();
            r1.getFullPrimitive().verify(signature, data);     // Catch: GeneralSecurityException -> L20
            this.monitoringLogger.log(r1.getKeyId(), data.length);     // Catch: GeneralSecurityException -> L20
            return;
        L10:
            Iterator<PrimitiveSet.Entry<PublicKeyVerify>> r2 = this.primitives.getRawPrimitives().iterator();
        L12:
            if (r2.hasNext() == false) goto L16;
            PrimitiveSet.Entry<PublicKeyVerify> r3 = r2.next();
            r3.getFullPrimitive().verify(signature, data);     // Catch: GeneralSecurityException -> L21
            this.monitoringLogger.log(r3.getKeyId(), data.length);     // Catch: GeneralSecurityException -> L21
            return;
        L16:
            this.monitoringLogger.logFailure();
            throw new GeneralSecurityException("invalid signature");
        L18:
            this.monitoringLogger.logFailure();
            throw new GeneralSecurityException("signature too short");
        }
    }

    public PublicKeyVerifyWrapper() {
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ PublicKeyVerify wrap(final PrimitiveSet<PublicKeyVerify> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new PublicKeyVerifyWrapper();
        LEGACY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PublicKeyVerifyWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, PublicKeyVerify.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public PublicKeyVerify wrap(final PrimitiveSet<PublicKeyVerify> primitives) {
        return new WrappedPublicKeyVerify(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<PublicKeyVerify> getPrimitiveClass() {
        return PublicKeyVerify.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<PublicKeyVerify> getInputPrimitiveClass() {
        return PublicKeyVerify.class;
    }

    static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
