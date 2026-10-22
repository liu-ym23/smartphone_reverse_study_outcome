package com.bytedance.common.utility.m;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final RejectedExecutionHandler f3312f = null;

    static {
        f3312f = new ThreadPoolExecutor.AbortPolicy();
    }

    public b(int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15, ThreadFactory r16) {
        super(r10, r11, r12, r14, r15, r16, f3312f);
    }

    public b(int r1, int r2, long r3, TimeUnit r5, BlockingQueue<Runnable> r6, ThreadFactory r7, RejectedExecutionHandler r8) {
        super(r1, r2, r3, r5, r6, r7, r8);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return new ArrayList();
    }
}
