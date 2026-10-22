package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;

/* JADX INFO: loaded from: classes.dex */
public class ApiTask extends IApiTask {
    private final boolean mIsDownload;
    private final String mName;
    private final IRequest.Priority mPriority;
    private final Runnable mRunnable;

    public ApiTask(String r1, IRequest.Priority r2, int r3, Runnable r4, boolean r5) {
        this.mPriority = r2;
        if (StringUtils.isEmpty(r1) == false) goto L5;
        r1 = getClass().getSimpleName();
    L5:
        this.mDelayTime = r3;
        this.mName = r1;
        this.mRunnable = r4;
        this.mIsDownload = r5;
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
        return this.mIsDownload;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mRunnable != null) goto L5;
        return;
    L5:
        if (isCanceled() == true) goto L9;
        this.mRunnable.run();
        return;
    }

    public void setBlockingQueueSize(int r2) {
        Runnable r1 = this.mRunnable;
        if ((r1 instanceof SsRunnable) == false) goto L8;
        RetrofitMetrics r3 = ((SsRunnable) r1).getRetrofitMetrics();
        if (r3 == null) goto L9;
        r3.blockingQueueSize = r2;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IApiTask
    public /* bridge */ /* synthetic */ IApiTask setSequence(int r1) {
        return setSequence(r1);
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

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IApiTask
    public ApiTask setSequence(int r1) {
        this.mSequence = r1;
        return this;
    }
}
