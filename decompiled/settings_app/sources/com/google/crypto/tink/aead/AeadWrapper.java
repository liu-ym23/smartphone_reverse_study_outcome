package com.google.crypto.tink.aead;

import com.android.settings.quickphrases.QuickPhrasesHelper;
import com.google.crypto.tink.Aead;
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
public class AeadWrapper implements PrimitiveWrapper<Aead, Aead> {
    private static final PrimitiveConstructor<LegacyProtoKey, Aead> LEGACY_FULL_AEAD_PRIMITIVE_CONSTRUCTOR = null;
    private static final AeadWrapper WRAPPER = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AeadWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class WrappedAead implements Aead {
        private final MonitoringClient.Logger decLogger;
        private final MonitoringClient.Logger encLogger;
        private final PrimitiveSet<Aead> pSet;

        /* synthetic */ WrappedAead(PrimitiveSet r1, AnonymousClass1 r2) {
            this(r1);
        }

        private WrappedAead(PrimitiveSet<Aead> pSet) {
            this.pSet = pSet;
            if (pSet.hasAnnotations() == false) goto L5;
            MonitoringClient r0 = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            MonitoringKeysetInfo r4 = MonitoringUtil.getMonitoringKeysetInfo(pSet);
            this.encLogger = r0.createLogger(r4, "aead", QuickPhrasesHelper.TABLE_NAME_ENCRYPT);
            this.decLogger = r0.createLogger(r4, "aead", "decrypt");
            return;
        L5:
            this.encLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            this.decLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }

        @Override // com.google.crypto.tink.Aead
        public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
            byte[] r6 = this.pSet.getPrimary().getFullPrimitive().encrypt(plaintext, associatedData);     // Catch: GeneralSecurityException -> L4
            this.encLogger.log(this.pSet.getPrimary().getKeyId(), plaintext.length);     // Catch: GeneralSecurityException -> L4
            return r6;
        L4:
            e = move-exception;
            this.encLogger.logFailure();
            throw e;
        }

        @Override // com.google.crypto.tink.Aead
        public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
            if (ciphertext.length <= 5) goto L10;
            Iterator<PrimitiveSet.Entry<Aead>> r0 = this.pSet.getPrimitive(Arrays.copyOf(ciphertext, 5)).iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            PrimitiveSet.Entry<Aead> r1 = r0.next();
            byte[] r2 = r1.getFullPrimitive().decrypt(ciphertext, associatedData);     // Catch: GeneralSecurityException -> L18
            this.decLogger.log(r1.getKeyId(), ciphertext.length);     // Catch: GeneralSecurityException -> L18
            return r2;
        L10:
            Iterator<PrimitiveSet.Entry<Aead>> r3 = this.pSet.getRawPrimitives().iterator();
        L12:
            if (r3.hasNext() == false) goto L16;
            PrimitiveSet.Entry<Aead> r4 = r3.next();
            byte[] r5 = r4.getFullPrimitive().decrypt(ciphertext, associatedData);     // Catch: GeneralSecurityException -> L19
            this.decLogger.log(r4.getKeyId(), ciphertext.length);     // Catch: GeneralSecurityException -> L19
            return r5;
        L16:
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ Aead wrap(final PrimitiveSet<Aead> pset) throws GeneralSecurityException {
        return wrap(pset);
    }

    static {
        WRAPPER = new AeadWrapper();
        LEGACY_FULL_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new AeadWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, Aead.class);
    }

    AeadWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Aead wrap(final PrimitiveSet<Aead> pset) throws GeneralSecurityException {
        return new WrappedAead(pset, null);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Aead> getPrimitiveClass() {
        return Aead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Aead> getInputPrimitiveClass() {
        return Aead.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_FULL_AEAD_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
