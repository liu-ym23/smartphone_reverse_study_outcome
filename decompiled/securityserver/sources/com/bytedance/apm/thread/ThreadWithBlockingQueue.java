package com.bytedance.apm.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class ThreadWithBlockingQueue {
    private final BlockingQueue<Runnable> mQueue;
    private final Thread mThread;

    public ThreadWithBlockingQueue(String r3) {
        this.mQueue = new LinkedTransferQueue();
        this.mThread = new Thread(new AnonymousClass1(this), r3);
    }

    public static /* synthetic */ BlockingQueue access$000(ThreadWithBlockingQueue r0) {
        return r0.mQueue;
    }

    public final boolean post(Runnable r1) {
        return this.mQueue.offer(r1);
    }

    public void start() {
        this.mThread.start();
    }
}
