package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
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
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class HybridDecryptWrapper implements PrimitiveWrapper<HybridDecrypt, HybridDecrypt> {
    private static final PrimitiveConstructor<LegacyProtoKey, HybridDecrypt> LEGACY_PRIMITIVE_CONSTRUCTOR = null;
    private static final HybridDecryptWrapper WRAPPER = null;

    private static class WrappedHybridDecrypt implements HybridDecrypt {
        private final MonitoringClient.Logger decLogger;
        private final PrimitiveSet<HybridDecrypt> primitives;

        public WrappedHybridDecrypt(final PrimitiveSet<HybridDecrypt> primitives) {
            this.primitives = primitives;
            if (primitives.hasAnnotations() == false) goto L5;
            this.decLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitives), "hybrid_decrypt", "decrypt");
            return;
        L5:
            this.decLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }

        @Override // com.google.crypto.tink.HybridDecrypt
        public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
            if (ciphertext.length <= 5) goto L10;
            Iterator<PrimitiveSet.Entry<HybridDecrypt>> r0 = this.primitives.getPrimitive(Arrays.copyOfRange(ciphertext, 0, 5)).iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            PrimitiveSet.Entry<HybridDecrypt> r1 = r0.next();
            byte[] r2 = r1.getFullPrimitive().decrypt(ciphertext, contextInfo);     // Catch: GeneralSecurityException -> L18
            this.decLogger.log(r1.getKeyId(), ciphertext.length);     // Catch: GeneralSecurityException -> L18
            return r2;
        L10:
            Iterator<PrimitiveSet.Entry<HybridDecrypt>> r3 = this.primitives.getRawPrimitives().iterator();
        L12:
            if (r3.hasNext() == false) goto L16;
            PrimitiveSet.Entry<HybridDecrypt> r4 = r3.next();
            byte[] r5 = r4.getFullPrimitive().decrypt(ciphertext, contextInfo);     // Catch: GeneralSecurityException -> L19
            this.decLogger.log(r4.getKeyId(), ciphertext.length);     // Catch: GeneralSecurityException -> L19
            return r5;
        L16:
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ HybridDecrypt wrap(final PrimitiveSet<HybridDecrypt> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new HybridDecryptWrapper();
        LEGACY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new HybridDecryptWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, HybridDecrypt.class);
    }

    HybridDecryptWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public HybridDecrypt wrap(final PrimitiveSet<HybridDecrypt> primitives) {
        return new WrappedHybridDecrypt(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridDecrypt> getPrimitiveClass() {
        return HybridDecrypt.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridDecrypt> getInputPrimitiveClass() {
        return HybridDecrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
