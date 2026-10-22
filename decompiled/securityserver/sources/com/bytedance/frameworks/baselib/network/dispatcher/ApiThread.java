package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApiThread extends IApiTask {
    protected static RequestQueue sRequestQueue;
    private final String mName;
    protected final IRequest.Priority mPriority;

    public ApiThread(String r1, IRequest.Priority r2) {
        this.mPriority = r2;
        if (StringUtils.isEmpty(r1) == false) goto L5;
        r1 = getClass().getSimpleName();
    L5:
        this.mName = r1;
    }

    public static void setRequestQueue(RequestQueue r0) {
        sRequestQueue = r0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(IRequest r1) {
        return compareTo2(r1);
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public IRequest.Priority getPriority() {
        return this.mPriority;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public int getSequence() {
        return this.mSequence;
    }

    public boolean isDownload() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    public final void start() {
        if (this.mStarted.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (sRequestQueue != null) goto L8;
        sRequestQueue = RequestQueue.getDefaultRequestQueue();
    L8:
        if (isDownload() == false) goto L10;
        sRequestQueue.addDownload(this);
        return;
    L10:
        sRequestQueue.add(this);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(IRequest r3) {
        IRequest.Priority r0 = getPriority();
        IRequest.Priority r1 = r3.getPriority();
        if (r0 != null) goto L5;
        r0 = IRequest.Priority.NORMAL;
    L5:
        if (r1 != null) goto L7;
        r1 = IRequest.Priority.NORMAL;
    L7:
        if (r0 != r1) goto L10;
        int r2 = getSequence();
        int r4 = r3.getSequence();
    L11:
        return r2 - r4;
    L10:
        r2 = r1.ordinal();
        r4 = r0.ordinal();
        goto L11
    }
}
