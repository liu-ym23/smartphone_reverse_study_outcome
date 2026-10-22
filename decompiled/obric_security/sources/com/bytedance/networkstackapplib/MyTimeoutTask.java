package com.bytedance.networkstackapplib;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MyTimeoutTask {
    public static final int ERROR_HAVE_EXCEPTION = -2;
    public static final int ERROR_TOO_MANY_THREAD = -1;
    private static final int MAX_THREAD_COUNT = 5;
    private static int threadConnt;
    private boolean haveException;

    static {
    }

    public MyTimeoutTask() {
        this.haveException = false;
    }

    static /* synthetic */ int access$008() {
        int r0 = threadConnt;
        threadConnt = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$010() {
        int r0 = threadConnt;
        threadConnt = r0 - 1;
        return r0;
    }

    static /* synthetic */ boolean access$102(MyTimeoutTask r0, boolean r1) {
        r0.haveException = r1;
        return r1;
    }

    public long startTask(int r6, final Runnable r7) {
        if (threadConnt <= 5) goto L6;
        return -1;
    L6:
        this.haveException = false;
        final CountDownLatch r0 = new CountDownLatch(1);
        long r1 = System.currentTimeMillis();
        new Thread(new AnonymousClass1(this, r7, r0)).start();
        r0.await(r6, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9
    L12:
        if (this.haveException == false) goto L16;
        return -2;
    L16:
        return System.currentTimeMillis() - r1;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public long startTwoTasksNeedOneFinished(int r6, final Runnable r7, final Runnable r8) {
        if (threadConnt <= 10) goto L6;
        return -1;
    L6:
        this.haveException = false;
        final CountDownLatch r0 = new CountDownLatch(1);
        long r1 = System.currentTimeMillis();
        new Thread(new AnonymousClass2(this, r7, r0)).start();
        new Thread(new AnonymousClass3(this, r8, r0)).start();
        r0.await(r6, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9
    L12:
        if (this.haveException == false) goto L16;
        return -2;
    L16:
        return System.currentTimeMillis() - r1;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
