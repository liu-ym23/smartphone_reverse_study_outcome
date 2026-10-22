package com.github.moduth.blockcanary;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class BlockCanary {
    private static final String TAG = "BlockCanary-no-op";
    private static BlockCanary sInstance;

    static {
    }

    public boolean isMonitorDurationEnd() {
        return true;
    }

    private BlockCanary() {
    }

    public static BlockCanary install(Context r0, BlockCanaryContext r1) {
        BlockCanaryContext.init(r0, r1);
        return get();
    }

    public static BlockCanary get() {
        if (sInstance != null) goto L15;
        monitor-enter(BlockCanary.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BlockCanary();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BlockCanary.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void start() {
        Log.i(TAG, "start");
    }

    public void stop() {
        Log.i(TAG, "stop");
    }

    public void upload() {
        Log.i(TAG, "upload");
    }

    public void recordStartTime() {
        Log.i(TAG, "recordStartTime");
    }
}
