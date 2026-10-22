package com.bytedance.frameworks.baselib.network.asynctask;

import a.a;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class NetworkThreadFactory implements ThreadFactory {
    private static final String TAG = "NetworkThreadFactory";
    private final String mThreadName;

    public NetworkThreadFactory(String r2) {
        this.mThreadName = a.A("ttnet-", r2);
    }

    public static /* synthetic */ void a(NetworkThreadFactory r0, Runnable r1) {
        r0.lambda$newThread$0(r1);
    }

    private /* synthetic */ void lambda$newThread$0(Runnable r4) {
        Process.setThreadPriority(10);
        r4.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e(TAG, "NetworkThreadFactory error when running in thread " + this.mThreadName, th);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        return new Thread(new androidx.constraintlayout.motion.widget.a(2, this, r4), this.mThreadName);
    }
}
