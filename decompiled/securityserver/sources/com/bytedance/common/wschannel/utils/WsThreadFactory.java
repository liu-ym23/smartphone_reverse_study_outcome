package com.bytedance.common.wschannel.utils;

import a.a;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class WsThreadFactory implements ThreadFactory {
    private static final String TAG = "WsThreadFactory";
    private final String mThreadName;

    public WsThreadFactory(String r2) {
        this.mThreadName = a.A("WsChannel-", r2);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ String access$100(WsThreadFactory r0) {
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
