package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class ThreadFactory implements java.util.concurrent.ThreadFactory {
    private static final String TAG = "ThreadFactory";
    private final String mThreadName;

    public ThreadFactory(String r1) {
        this.mThreadName = r1;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ String access$100(ThreadFactory r0) {
        return r0.mThreadName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "creating newThread " + this.mThreadName);
    L6:
        return new Thread(new AnonymousClass1(this, r4), this.mThreadName);
    }
}
