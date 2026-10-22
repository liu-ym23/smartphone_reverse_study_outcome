package com.bytedance.apm6.util.timetask;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncTask implements Runnable {
    private long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;

    public AsyncTask() {
        this(0);
    }

    public AsyncTask(long r3) {
        this(r3, 0);
    }

    public AsyncTask(long r1, long r3) {
        this.mInitialDelay = r1;
        this.mLoopInterval = r3;
        if (r3 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public final boolean isLoop() {
        return this.mIsLoop;
    }

    public final long getLoopInterval() {
        return this.mLoopInterval;
    }

    public void refresh(long r1, long r3) {
        this.mInitialDelay = r1;
        this.mLoopInterval = r3;
        if (r3 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }
}
