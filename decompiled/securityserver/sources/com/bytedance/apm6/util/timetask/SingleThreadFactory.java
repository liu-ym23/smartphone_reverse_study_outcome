package com.bytedance.apm6.util.timetask;

import a.a;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadFactory implements ThreadFactory {
    private final String threadName;

    public SingleThreadFactory(String r2) {
        this.threadName = a.A("APM6-", r2);
    }

    public static /* synthetic */ String access$000(SingleThreadFactory r0) {
        return r0.threadName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r3) {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.d(Constant.TAG, "creating newThread " + this.threadName);
    L6:
        return new Thread(new AnonymousClass1(this, r3), this.threadName);
    }
}
