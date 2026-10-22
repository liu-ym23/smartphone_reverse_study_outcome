package com.bytedance.common.wschannel.utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class WsAsyncTask implements Runnable {
    private final long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;

    public WsAsyncTask() {
        this(0);
    }

    public final long getInitialDelay() {
        return this.mInitialDelay;
    }

    public final long getLoopInterval() {
        return this.mLoopInterval;
    }

    public final boolean isLoop() {
        return this.mIsLoop;
    }

    public WsAsyncTask(long r3) {
        this(r3, 0);
    }

    public WsAsyncTask(long r1, long r3) {
        this.mInitialDelay = r1;
        this.mLoopInterval = r3;
        if (r3 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }
}
