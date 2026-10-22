package com.bytedance.article.common.monitor.stack;

import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class CacheExceptionLog {
    private static final int CACHE_EXCEPTION_LOG_LIMIT_SIZE = 40;
    private final LinkedList<StackInfo> mCacheLog;
    private volatile boolean mHandledCache;

    public CacheExceptionLog() {
        this.mCacheLog = new LinkedList();
        this.mHandledCache = false;
    }

    static /* synthetic */ LinkedList access$000(CacheExceptionLog r0) {
        return r0.mCacheLog;
    }

    void cacheLog(String r4, String r5) {
        if (this.mHandledCache == false) goto L5;
        return;
    L5:
        LinkedList<StackInfo> r0 = this.mCacheLog;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mCacheLog.size() <= 40) goto L10;
        this.mCacheLog.poll();     // Catch: Throwable -> L13
    L10:
        this.mCacheLog.add(new StackInfo(r4, r5));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    void handleCacheLog() {
        if (this.mHandledCache == false) goto L6;
        return;
    L6:
        if (ApmDelegate.getInstance().isConfigReady() == false) goto L8;
        this.mHandledCache = true;
    L8:
        AsyncEventManager.getInstance().submitTask(new AnonymousClass1(this));
    }
}
