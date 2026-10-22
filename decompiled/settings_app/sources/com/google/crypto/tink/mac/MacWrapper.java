package com.google.crypto.tink.mac;

import com.google.crypto.tink.Mac;
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
public class MacWrapper implements PrimitiveWrapper<Mac, Mac> {
    private static final PrimitiveConstructor<LegacyProtoKey, Mac> LEGACY_FULL_MAC_PRIMITIVE_CONSTRUCTOR = null;
    private static final MacWrapper WRAPPER = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.MacWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class WrappedMac implements Mac {
        private final MonitoringClient.Logger computeLogger;
        private final PrimitiveSet<Mac> primitives;
        private final MonitoringClient.Logger verifyLogger;

        /* synthetic */ WrappedMac(PrimitiveSet r1, AnonymousClass1 r2) {
            this(r1);
        }

        private WrappedMac(PrimitiveSet<Mac> primitives) {
            this.primitives = primitives;
            if (primitives.hasAnnotations() == false) goto L5;
            MonitoringClient r0 = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            MonitoringKeysetInfo r4 = MonitoringUtil.getMonitoringKeysetInfo(primitives);
            this.computeLogger = r0.createLogger(r4, "mac", "compute");
            this.verifyLogger = r0.createLogger(r4, "mac", "verify");
            return;
        L5:
            this.computeLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            this.verifyLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }

        @Override // com.google.crypto.tink.Mac
        public byte[] computeMac(final byte[] data) throws GeneralSecurityException {
            byte[] r0 = this.primitives.getPrimary().getFullPrimitive().computeMac(data);     // Catch: GeneralSecurityException -> L4
            this.computeLogger.log(this.primitives.getPrimary().getKeyId(), data.length);     // Catch: GeneralSecurityException -> L4
            return r0;
        L4:
            e = move-exception;
            this.computeLogger.logFailure();
            throw e;
        }

        @Override // com.google.crypto.tink.Mac
        public void verifyMac(final byte[] mac, final byte[] data) throws GeneralSecurityException {
            if (mac.length <= 5) goto L18;
            Iterator<PrimitiveSet.Entry<Mac>> r0 = this.primitives.getPrimitive(Arrays.copyOf(mac, 5)).iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            PrimitiveSet.Entry<Mac> r1 = r0.next();
            r1.getFullPrimitive().verifyMac(mac, data);     // Catch: GeneralSecurityException -> L20
            this.verifyLogger.log(r1.getKeyId(), data.length);     // Catch: GeneralSecurityException -> L20
            return;
        L10:
            Iterator<PrimitiveSet.Entry<Mac>> r2 = this.primitives.getRawPrimitives().iterator();
        L12:
            if (r2.hasNext() == false) goto L16;
            PrimitiveSet.Entry<Mac> r3 = r2.next();
            r3.getFullPrimitive().verifyMac(mac, data);     // Catch: GeneralSecurityException -> L21
            this.verifyLogger.log(r3.getKeyId(), data.length);     // Catch: GeneralSecurityException -> L21
            return;
        L16:
            this.verifyLogger.logFailure();
            throw new GeneralSecurityException("invalid MAC");
        L18:
            this.verifyLogger.logFailure();
            throw new GeneralSecurityException("tag too short");
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ Mac wrap(final PrimitiveSet<Mac> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new MacWrapper();
        LEGACY_FULL_MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new MacWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, Mac.class);
    }

    MacWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Mac wrap(final PrimitiveSet<Mac> primitives) throws GeneralSecurityException {
        return new WrappedMac(primitives, null);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Mac> getPrimitiveClass() {
        return Mac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Mac> getInputPrimitiveClass() {
        return Mac.class;
    }

    static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_FULL_MAC_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
