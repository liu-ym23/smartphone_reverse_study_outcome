package com.bytedance.framwork.core.sdklib.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadWithHandler {
    static final ListUtils.ComparableDiffType<MessageEntity, Runnable> compareEntityRunnable = null;
    static final ListUtils.ComparableDiffType<Message, Runnable> compareMessageRunnable = null;
    private final Object lock;
    private final Queue<MessageEntity> mCacheQueue;
    private final Queue<Message> mFrontCacheQueue;
    private volatile Handler mRealHandler;
    private final HandlerThread mThread;

    class CheckCacheRunnable implements Runnable {
        final /* synthetic */ ThreadWithHandler this$0;

        CheckCacheRunnable(ThreadWithHandler r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            solveFrontCacheQueue();
            solveNormalCacheQueue();
        }

        void solveNormalCacheQueue() {
        L3:
            if (ThreadWithHandler.access$200(this.this$0).isEmpty() == true) goto L7;
            MessageEntity r0 = (MessageEntity) ThreadWithHandler.access$200(this.this$0).poll();
            if (ThreadWithHandler.access$100(this.this$0) == null) goto L3;
            ThreadWithHandler.access$100(this.this$0).sendMessageAtTime(r0.msg, r0.time);
            goto L3
        }

        void solveFrontCacheQueue() {
        L3:
            if (ThreadWithHandler.access$300(this.this$0).isEmpty() == true) goto L7;
            if (ThreadWithHandler.access$100(this.this$0) == null) goto L3;
            ThreadWithHandler.access$100(this.this$0).sendMessageAtFrontOfQueue((Message) ThreadWithHandler.access$300(this.this$0).poll());
            goto L3
        }
    }

    class InnerThread extends HandlerThread {
        final /* synthetic */ ThreadWithHandler this$0;

        InnerThread(ThreadWithHandler r1, String r2) {
            this.this$0 = r1;
            super(r2);
        }

        InnerThread(ThreadWithHandler r1, String r2, int r3) {
            this.this$0 = r1;
            super(r2, r3);
        }

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r0);
            ThreadWithHandler.access$102(this.this$0, new Handler());     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            ThreadWithHandler.access$100(this.this$0).post(new CheckCacheRunnable(this.this$0));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }
    }

    static class MessageEntity {
        Message msg;
        long time;

        MessageEntity(Message r1, long r2) {
            this.msg = r1;
            this.time = r2;
        }
    }

    static /* synthetic */ Object access$000(ThreadWithHandler r0) {
        return r0.lock;
    }

    static /* synthetic */ Handler access$100(ThreadWithHandler r0) {
        return r0.mRealHandler;
    }

    static /* synthetic */ Handler access$102(ThreadWithHandler r0, Handler r1) {
        r0.mRealHandler = r1;
        return r1;
    }

    static /* synthetic */ Queue access$200(ThreadWithHandler r0) {
        return r0.mCacheQueue;
    }

    static /* synthetic */ Queue access$300(ThreadWithHandler r0) {
        return r0.mFrontCacheQueue;
    }

    public ThreadWithHandler(String r2, int r3) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.lock = new Object();
        this.mThread = new InnerThread(this, r2, r3);
    }

    public ThreadWithHandler(String r2) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.lock = new Object();
        this.mThread = new InnerThread(this, r2);
    }

    public void start() {
        this.mThread.start();
    }

    private Message getPostMessage(Runnable r1) {
        return Message.obtain(this.mRealHandler, r1);
    }

    private Message getPostMessage(Runnable r1, Object r2) {
        Message r0 = Message.obtain(this.mRealHandler, r1);
        r0.obj = r2;
        return r0;
    }

    public final boolean post(Runnable r3) {
        return sendMessageDelayed(getPostMessage(r3), 0);
    }

    public final boolean postAtTime(Runnable r1, long r2) {
        return sendMessageAtTime(getPostMessage(r1), r2);
    }

    public final boolean postAtTime(Runnable r1, Object r2, long r3) {
        return sendMessageAtTime(getPostMessage(r1, r2), r3);
    }

    public final boolean postDelayed(Runnable r1, long r2) {
        return sendMessageDelayed(getPostMessage(r1), r2);
    }

    public final boolean postDelayed(Runnable r1, Object r2, long r3) {
        return sendMessageDelayed(getPostMessage(r1, r2), r3);
    }

    public final boolean postAtFrontOfQueue(Runnable r1) {
        return sendMessageAtFrontOfQueue(getPostMessage(r1));
    }

    static {
        compareEntityRunnable = new AnonymousClass1();
        compareMessageRunnable = new AnonymousClass2();
    }

    public final void removeCallbacks(Runnable r3) {
        if (this.mCacheQueue.isEmpty() == true) goto L5;
    L6:
        ListUtils.removeAll(this.mCacheQueue, r3, compareEntityRunnable);
        ListUtils.removeAll(this.mFrontCacheQueue, r3, compareMessageRunnable);
    L8:
        if (this.mRealHandler == null) goto L11;
        this.mRealHandler.removeCallbacks(r3);
        return;
    L11:
        return;
    L5:
        if (this.mFrontCacheQueue.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean sendMessage(Message r3) {
        return sendMessageDelayed(r3, 0);
    }

    public final boolean sendEmptyMessage(int r3) {
        return sendEmptyMessageDelayed(r3, 0);
    }

    public final boolean sendEmptyMessageDelayed(int r2, long r3) {
        Message r0 = Message.obtain();
        r0.what = r2;
        return sendMessageDelayed(r0, r3);
    }

    public final boolean sendEmptyMessageAtTime(int r2, long r3) {
        Message r0 = Message.obtain();
        r0.what = r2;
        return sendMessageAtTime(r0, r3);
    }

    public final boolean sendMessageDelayed(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return sendMessageAtTime(r4, SystemClock.uptimeMillis() + r5);
    }

    public final boolean sendMessageAtTime(Message r3, long r4) {
        if (this.mRealHandler != null) goto L18;
        Object r0 = this.lock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L12;
        this.mCacheQueue.add(new MessageEntity(r3, r4));     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    L18:
        return this.mRealHandler.sendMessageAtTime(r3, r4);
    }

    public final boolean sendMessageAtFrontOfQueue(Message r3) {
        if (this.mRealHandler != null) goto L18;
        Object r0 = this.lock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L12;
        this.mFrontCacheQueue.add(r3);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    L18:
        return this.mRealHandler.sendMessageAtFrontOfQueue(r3);
    }
}
