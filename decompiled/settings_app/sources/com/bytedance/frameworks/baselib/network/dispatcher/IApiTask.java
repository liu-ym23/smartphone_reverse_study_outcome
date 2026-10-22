package com.bytedance.frameworks.baselib.network.dispatcher;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IApiTask implements IRequest, Runnable, Comparable<IRequest> {
    protected final AtomicBoolean mCanceled;
    protected int mDelayTime;
    protected int mSequence;
    protected final AtomicBoolean mStarted;

    public boolean needTryLocal() {
        return false;
    }

    @Deprecated
    public boolean run4Local() {
        return false;
    }

    public IApiTask() {
        this.mStarted = new AtomicBoolean(false);
        this.mCanceled = new AtomicBoolean(false);
        this.mDelayTime = 0;
    }

    public void cancel() {
        this.mCanceled.compareAndSet(false, true);
    }

    public boolean isCanceled() {
        return this.mCanceled.get();
    }

    public IApiTask setSequence(int r1) {
        this.mSequence = r1;
        return this;
    }

    public int getDelayTime() {
        return this.mDelayTime;
    }
}
