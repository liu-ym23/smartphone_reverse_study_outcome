package com.google.crypto.tink.daead;

import com.android.settings.quickphrases.QuickPhrasesHelper;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.monitoring.MonitoringKeysetInfo;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead, DeterministicAead> {
    private static final PrimitiveConstructor<LegacyProtoKey, DeterministicAead> LEGACY_FULL_DAEAD_PRIMITIVE_CONSTRUCTOR = null;
    private static final DeterministicAeadWrapper WRAPPER = null;

    private static class WrappedDeterministicAead implements DeterministicAead {
        private final MonitoringClient.Logger decLogger;
        private final MonitoringClient.Logger encLogger;
        private final PrimitiveSet<DeterministicAead> primitives;

        public WrappedDeterministicAead(PrimitiveSet<DeterministicAead> primitives) {
            this.primitives = primitives;
            if (primitives.hasAnnotations() == false) goto L5;
            MonitoringClient r0 = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            MonitoringKeysetInfo r4 = MonitoringUtil.getMonitoringKeysetInfo(primitives);
            this.encLogger = r0.createLogger(r4, "daead", QuickPhrasesHelper.TABLE_NAME_ENCRYPT);
            this.decLogger = r0.createLogger(r4, "daead", "decrypt");
            return;
        L5:
            this.encLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            this.decLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
            byte[] r6 = this.primitives.getPrimary().getFullPrimitive().encryptDeterministically(plaintext, associatedData);     // Catch: GeneralSecurityException -> L4
            this.encLogger.log(this.primitives.getPrimary().getKeyId(), plaintext.length);     // Catch: GeneralSecurityException -> L4
            return r6;
        L4:
            e = move-exception;
            this.encLogger.logFailure();
            throw e;
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
            if (ciphertext.length <= 5) goto L10;
            Iterator<PrimitiveSet.Entry<DeterministicAead>> r0 = this.primitives.getPrimitive(Arrays.copyOf(ciphertext, 5)).iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            PrimitiveSet.Entry<DeterministicAead> r1 = r0.next();
            byte[] r2 = r1.getFullPrimitive().decryptDeterministically(ciphertext, associatedData);     // Catch: GeneralSecurityException -> L18
            this.decLogger.log(r1.getKeyId(), ciphertext.length);     // Catch: GeneralSecurityException -> L18
            return r2;
        L10:
            Iterator<PrimitiveSet.Entry<DeterministicAead>> r3 = this.primitives.getRawPrimitives().iterator();
        L12:
            if (r3.hasNext() == false) goto L16;
            PrimitiveSet.Entry<DeterministicAead> r4 = r3.next();
            byte[] r5 = r4.getFullPrimitive().decryptDeterministically(ciphertext, associatedData);     // Catch: GeneralSecurityException -> L19
            this.decLogger.log(r4.getKeyId(), ciphertext.length);     // Catch: GeneralSecurityException -> L19
            return r5;
        L16:
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ DeterministicAead wrap(final PrimitiveSet<DeterministicAead> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new DeterministicAeadWrapper();
        LEGACY_FULL_DAEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new DeterministicAeadWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, DeterministicAead.class);
    }

    DeterministicAeadWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public DeterministicAead wrap(final PrimitiveSet<DeterministicAead> primitives) {
        return new WrappedDeterministicAead(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<DeterministicAead> getPrimitiveClass() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<DeterministicAead> getInputPrimitiveClass() {
        return DeterministicAead.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_FULL_DAEAD_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
