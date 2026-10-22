package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpLogger extends CronetLogger {
    @Override // com.ttnet.org.chromium.net.impl.CronetLogger
    public void logCronetEngineCreation(int r1, CronetLogger.CronetEngineBuilderInfo r2, CronetLogger.CronetVersion r3, CronetLogger.CronetSource r4) {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLogger
    public void logCronetTrafficInfo(int r1, CronetLogger.CronetTrafficInfo r2) {
    }

    public NoOpLogger() {
    }
}
