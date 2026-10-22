package com.google.crypto.tink.hybrid;

import com.android.settings.quickphrases.QuickPhrasesHelper;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.monitoring.MonitoringClient;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public class HybridEncryptWrapper implements PrimitiveWrapper<HybridEncrypt, HybridEncrypt> {
    private static final PrimitiveConstructor<LegacyProtoKey, HybridEncrypt> LEGACY_PRIMITIVE_CONSTRUCTOR = null;
    private static final HybridEncryptWrapper WRAPPER = null;

    private static class WrappedHybridEncrypt implements HybridEncrypt {
        private final MonitoringClient.Logger encLogger;
        final PrimitiveSet<HybridEncrypt> primitives;

        public WrappedHybridEncrypt(final PrimitiveSet<HybridEncrypt> primitives) {
            this.primitives = primitives;
            if (primitives.hasAnnotations() == false) goto L5;
            this.encLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitives), "hybrid_encrypt", QuickPhrasesHelper.TABLE_NAME_ENCRYPT);
            return;
        L5:
            this.encLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }

        @Override // com.google.crypto.tink.HybridEncrypt
        public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
            if (this.primitives.getPrimary() != null) goto L11;
            this.encLogger.logFailure();
            throw new GeneralSecurityException("keyset without primary key");
        L11:
            byte[] r6 = this.primitives.getPrimary().getFullPrimitive().encrypt(plaintext, contextInfo);     // Catch: GeneralSecurityException -> L6
            this.encLogger.log(this.primitives.getPrimary().getKeyId(), plaintext.length);     // Catch: GeneralSecurityException -> L6
            return r6;
        L6:
            e = move-exception;
            this.encLogger.logFailure();
            throw e;
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ HybridEncrypt wrap(final PrimitiveSet<HybridEncrypt> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new HybridEncryptWrapper();
        LEGACY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new HybridEncryptWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, HybridEncrypt.class);
    }

    HybridEncryptWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public HybridEncrypt wrap(final PrimitiveSet<HybridEncrypt> primitives) {
        return new WrappedHybridEncrypt(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridEncrypt> getPrimitiveClass() {
        return HybridEncrypt.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridEncrypt> getInputPrimitiveClass() {
        return HybridEncrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
