package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.monitoring.MonitoringKeysetInfo;
import com.google.crypto.tink.proto.KeyStatusType;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MonitoringUtil {
    public static final MonitoringClient.Logger DO_NOTHING_LOGGER = null;
    private static final String TYPE_URL_PREFIX = "type.googleapis.com/google.crypto.";

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.MonitoringUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = null;

        static {
            int[] r0 = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = r0;
            r0[KeyStatusType.ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class DoNothingLogger implements MonitoringClient.Logger {
        @Override // com.google.crypto.tink.monitoring.MonitoringClient.Logger
        public void log(int keyId, long numBytesAsInput) {
        }

        @Override // com.google.crypto.tink.monitoring.MonitoringClient.Logger
        public void logFailure() {
        }

        private DoNothingLogger() {
        }

        /* synthetic */ DoNothingLogger(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        DO_NOTHING_LOGGER = new DoNothingLogger(null);
    }

    private static KeyStatus parseStatus(KeyStatusType in) {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[in.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L11;
        return KeyStatus.DESTROYED;
    L11:
        throw new IllegalStateException("Unknown key status");
    L13:
        return KeyStatus.DISABLED;
    L15:
        return KeyStatus.ENABLED;
    }

    private static String parseKeyTypeUrl(String keyTypeUrl) {
        if (keyTypeUrl.startsWith(TYPE_URL_PREFIX) == true) goto L6;
        return keyTypeUrl;
    L6:
        return keyTypeUrl.substring(34);
    }

    public static <P> MonitoringKeysetInfo getMonitoringKeysetInfo(PrimitiveSet<P> primitiveSet) {
        MonitoringKeysetInfo.Builder r0 = MonitoringKeysetInfo.newBuilder();
        r0.setAnnotations(primitiveSet.getAnnotations());
        Iterator<List<PrimitiveSet.Entry<P>>> r1 = primitiveSet.getAll().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Iterator<PrimitiveSet.Entry<P>> r2 = r1.next().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        PrimitiveSet.Entry<P> r3 = r2.next();
        r0.addEntry(parseStatus(r3.getStatus()), r3.getKeyId(), parseKeyTypeUrl(r3.getKeyTypeUrl()), r3.getOutputPrefixType().name());
        goto L7
    L10:
        if (primitiveSet.getPrimary() == null) goto L17;
        r0.setPrimaryKeyId(primitiveSet.getPrimary().getKeyId());
    L17:
        return r0.build();
    L14:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private MonitoringUtil() {
    }
}
