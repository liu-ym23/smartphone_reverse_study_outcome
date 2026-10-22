package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CronetLoggerFactory {
    private static final String CRONET_LOGGER_IMPL_CLASS = "com.google.net.cronet.telemetry.CronetLoggerImpl";
    private static final int SAMPLE_RATE_PER_SECOND = 1;
    private static final CronetLogger sDefaultLogger = null;
    private static CronetLogger sTestingLogger;

    public static class SwapLoggerForTesting implements AutoCloseable {
        public SwapLoggerForTesting(CronetLogger r1) {
            CronetLoggerFactory.access$000(r1);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            CronetLoggerFactory.access$000(null);
        }
    }

    static {
        sDefaultLogger = new NoOpLogger();
    }

    private CronetLoggerFactory() {
    }

    public static /* synthetic */ void access$000(CronetLogger r0) {
        setLoggerForTesting(r0);
    }

    public static CronetLogger createLogger(Context r1, CronetLogger.CronetSource r2) {
        CronetLogger r0 = sTestingLogger;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (CronetManifest.isAppOptedInForTelemetry(r1, r2) == false) goto L16;
        Class<? extends CronetLogger> r3 = fetchLoggerImplClass();
        if (r3 == null) goto L10;
        return r3.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{1});
    L14:
        return sDefaultLogger;
    L10:
        return sDefaultLogger;
    L16:
        return sDefaultLogger;
    }

    public static CronetLogger createNoOpLogger() {
        return sDefaultLogger;
    }

    private static Class<? extends CronetLogger> fetchLoggerImplClass() {
        return CronetLoggerFactory.class.getClassLoader().loadClass(CRONET_LOGGER_IMPL_CLASS).asSubclass(CronetLogger.class);
    L5:
        return null;
    }

    private static void setLoggerForTesting(@Nullable CronetLogger r0) {
        sTestingLogger = r0;
    }
}
