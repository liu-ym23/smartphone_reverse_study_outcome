package com.google.crypto.tink.prf;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public class PrfSetWrapper implements PrimitiveWrapper<Prf, PrfSet> {
    private static final PrimitiveConstructor<LegacyProtoKey, Prf> LEGACY_FULL_PRF_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrfSetWrapper WRAPPER = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.PrfSetWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class WrappedPrfSet extends PrfSet {
        private final Map<Integer, Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        @Immutable
        private static class PrfWithMonitoring implements Prf {
            private final int keyId;
            private final MonitoringClient.Logger logger;
            private final Prf prf;

            @Override // com.google.crypto.tink.prf.Prf
            public byte[] compute(byte[] input, int outputLength) throws GeneralSecurityException {
                byte[] r6 = this.prf.compute(input, outputLength);     // Catch: GeneralSecurityException -> L4
                this.logger.log(this.keyId, input.length);     // Catch: GeneralSecurityException -> L4
                return r6;
            L4:
                e = move-exception;
                this.logger.logFailure();
                throw e;
            }

            public PrfWithMonitoring(Prf prf, int keyId, MonitoringClient.Logger logger) {
                this.prf = prf;
                this.keyId = keyId;
                this.logger = logger;
            }
        }

        /* synthetic */ WrappedPrfSet(PrimitiveSet r1, AnonymousClass1 r2) throws GeneralSecurityException {
            this(r1);
        }

        private WrappedPrfSet(PrimitiveSet<Prf> primitives) throws GeneralSecurityException {
            if (primitives.getRawPrimitives().isEmpty() == true) goto L19;
            if (primitives.getPrimary() == null) goto L17;
            if (primitives.hasAnnotations() == false) goto L9;
            MonitoringClient.Logger r0 = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitives), "prf", "compute");
        L10:
            this.primaryKeyId = primitives.getPrimary().getKeyId();
            List<PrimitiveSet.Entry<Prf>> r7 = primitives.getRawPrimitives();
            HashMap r1 = new HashMap();
            Iterator<PrimitiveSet.Entry<Prf>> r8 = r7.iterator();
        L12:
            if (r8.hasNext() == false) goto L14;
            PrimitiveSet.Entry<Prf> r2 = r8.next();
            r1.put(Integer.valueOf(r2.getKeyId()), new PrfWithMonitoring(r2.getFullPrimitive(), r2.getKeyId(), r0));
            goto L12
        L14:
            this.keyIdToPrfMap = Collections.unmodifiableMap(r1);
            return;
        L9:
            r0 = MonitoringUtil.DO_NOTHING_LOGGER;
            goto L10
        L17:
            throw new GeneralSecurityException("Primary key not set.");
        L19:
            throw new GeneralSecurityException("No primitives provided.");
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public int getPrimaryId() {
            return this.primaryKeyId;
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public Map<Integer, Prf> getPrfs() throws GeneralSecurityException {
            return this.keyIdToPrfMap;
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ PrfSet wrap(PrimitiveSet<Prf> set) throws GeneralSecurityException {
        return wrap(set);
    }

    public PrfSetWrapper() {
    }

    static {
        WRAPPER = new PrfSetWrapper();
        LEGACY_FULL_PRF_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrfSetWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, Prf.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public PrfSet wrap(PrimitiveSet<Prf> set) throws GeneralSecurityException {
        return new WrappedPrfSet(set, null);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<PrfSet> getPrimitiveClass() {
        return PrfSet.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Prf> getInputPrimitiveClass() {
        return Prf.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_FULL_PRF_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
