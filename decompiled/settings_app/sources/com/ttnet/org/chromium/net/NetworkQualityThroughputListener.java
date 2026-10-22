package com.ttnet.org.chromium.net;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NetworkQualityThroughputListener {
    private final Executor mExecutor;

    public abstract void onThroughputObservation(int r1, long r2, int r4);

    public NetworkQualityThroughputListener(Executor r1) {
        if (r1 == null) goto L7;
        this.mExecutor = r1;
        return;
    L7:
        throw new IllegalStateException("Executor must not be null");
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }
}
