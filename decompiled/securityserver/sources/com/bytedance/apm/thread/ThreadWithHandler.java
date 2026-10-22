package com.bytedance.apm.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.util.ListUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class ThreadWithHandler {
    private static final long EXECUTE_TICK = 1000;
    static final ListUtils.ComparableDiffType<MessageEntity, Runnable> compareEntityRunnable = null;
    static final ListUtils.ComparableDiffType<Message, Runnable> compareMessageRunnable = null;
    private final Object lock;
    private final Queue<MessageEntity> mCacheQueue;
    private final Queue<Message> mFrontCacheQueue;
    private long mNextTickTime;
    public volatile Handler mRealHandler;
    private final HandlerThread mThread;
    private boolean mWaitReady;

    public class CheckCacheRunnable implements Runnable {
        final /* synthetic */ ThreadWithHandler this$0;

        public CheckCacheRunnable(ThreadWithHandler r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            solveFrontCacheQueue();
            solveNormalCacheQueue();
        }

        public void solveFrontCacheQueue() {
        L3:
            if (ThreadWithHandler.access$200(this.this$0).isEmpty() == true) goto L15;
            Object r0 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r0);
            if (this.this$0.mRealHandler == null) goto L11;
            this.this$0.mRealHandler.sendMessageAtFrontOfQueue((Message) ThreadWithHandler.access$200(this.this$0).poll());     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void solveNormalCacheQueue() {
        L3:
            if (ThreadWithHandler.access$100(this.this$0).isEmpty() == true) goto L15;
            Object r0 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r0);
            MessageEntity r1 = (MessageEntity) ThreadWithHandler.access$100(this.this$0).poll();     // Catch: Throwable -> L9
            if (this.this$0.mRealHandler == null) goto L11;
            this.this$0.mRealHandler.sendMessageAtTime(r1.msg, r1.time);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    public class InnerThread extends HandlerThread {
        final /* synthetic */ ThreadWithHandler this$0;

        public InnerThread(ThreadWithHandler r1, String r2) {
            this.this$0 = r1;
            super(r2);
        }

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r0);
            ThreadWithHandler r1 = this.this$0;     // Catch: Throwable -> L11
            r1.mRealHandler = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.this$0.mRealHandler.post(new CheckCacheRunnable(this.this$0));
        L16:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            MonitorCoreExceptionManager.getInstance().directReportError(th, "apm_error");
        L11:
            th = move-exception;
            throw th;
        }

        public InnerThread(ThreadWithHandler r1, String r2, int r3) {
            this.this$0 = r1;
            super(r2, r3);
        }
    }

    public static class MessageEntity {
        Message msg;
        long time;

        public MessageEntity(Message r1, long r2) {
            this.msg = r1;
            this.time = r2;
        }
    }

    static {
        compareEntityRunnable = new AnonymousClass1();
        compareMessageRunnable = new AnonymousClass2();
    }

    public ThreadWithHandler(String r3, int r4) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.mNextTickTime = 0;
        this.lock = new Object();
        this.mThread = new InnerThread(this, r3, r4);
    }

    public static /* synthetic */ Object access$000(ThreadWithHandler r0) {
        return r0.lock;
    }

    public static /* synthetic */ Queue access$100(ThreadWithHandler r0) {
        return r0.mCacheQueue;
    }

    public static /* synthetic */ Queue access$200(ThreadWithHandler r0) {
        return r0.mFrontCacheQueue;
    }

    public Looper getLooper() {
        HandlerThread r0 = this.mThread;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLooper();
    }

    public Message getPostMessage(Runnable r1) {
        return Message.obtain(this.mRealHandler, r1);
    }

    public boolean isReady() {
        if (this.mRealHandler == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean post(Runnable r3) {
        return sendMessageDelayed(getPostMessage(r3), 0);
    }

    public final boolean postAtFrontOfQueue(Runnable r1) {
        return sendMessageAtFrontOfQueue(getPostMessage(r1));
    }

    public final boolean postAtTime(Runnable r1, long r2) {
        return sendMessageAtTime(getPostMessage(r1), r2);
    }

    public final boolean postDelayed(Runnable r1, long r2) {
        return sendMessageDelayed(getPostMessage(r1), r2);
    }

    public final boolean postSequence(Runnable r3) {
        return postSequence(r3, SystemClock.uptimeMillis());
    }

    public void quit() {
        this.mThread.quit();
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

    public void removeCallbacksAndMessages() {
        if (this.mRealHandler == null) goto L6;
        this.mRealHandler.removeCallbacksAndMessages(null);
        return;
    L6:
        if (this.mCacheQueue.isEmpty() == true) goto L8;
    L9:
        Object r0 = this.lock;
        monitor-enter(r0);
        this.mCacheQueue.clear();     // Catch: Throwable -> L13 Exception -> L15
        this.mFrontCacheQueue.clear();     // Catch: Throwable -> L13 Exception -> L15
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mFrontCacheQueue.isEmpty() == false) goto L9;
    }

    public final boolean sendEmptyMessage(int r3) {
        return sendEmptyMessageDelayed(r3, 0);
    }

    public final boolean sendEmptyMessageAtTime(int r2, long r3) {
        Message r0 = Message.obtain();
        r0.what = r2;
        return sendMessageAtTime(r0, r3);
    }

    public final boolean sendEmptyMessageDelayed(int r2, long r3) {
        Message r0 = Message.obtain();
        r0.what = r2;
        return sendMessageDelayed(r0, r3);
    }

    public final boolean sendMessage(Message r3) {
        return sendMessageDelayed(r3, 0);
    }

    public final boolean sendMessageAtFrontOfQueue(Message r3) {
        if (this.mRealHandler != null) goto L19;
        Object r0 = this.lock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L14;
        this.mFrontCacheQueue.add(r3);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
    L19:
        return this.mRealHandler.sendMessageAtFrontOfQueue(r3);
    }

    public final boolean sendMessageAtTime(Message r3, long r4) {
        if (this.mRealHandler != null) goto L19;
        Object r0 = this.lock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L14;
        this.mCacheQueue.add(new MessageEntity(r3, r4));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
    L19:
        return this.mRealHandler.sendMessageAtTime(r3, r4);
    }

    public final boolean sendMessageDelayed(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return sendMessageAtTime(r4, SystemClock.uptimeMillis() + r5);
    }

    public void start() {
        this.mThread.start();
    }

    private Message getPostMessage(Runnable r1, Object r2) {
        Message r0 = Message.obtain(this.mRealHandler, r1);
        r0.obj = r2;
        return r0;
    }

    public final boolean postAtTime(Runnable r1, Object r2, long r3) {
        return sendMessageAtTime(getPostMessage(r1, r2), r3);
    }

    public final boolean postDelayed(Runnable r1, Object r2, long r3) {
        return sendMessageDelayed(getPostMessage(r1, r2), r3);
    }

    public final boolean postSequence(Runnable r3, long r4) {
        if (this.mNextTickTime >= r4) goto L6;
        this.mNextTickTime = r4 + 1000;
    L6:
        return postAtTime(r3, this.mNextTickTime);
    }

    public ThreadWithHandler(String r3, int r4, boolean r5) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.mNextTickTime = 0;
        this.lock = new Object();
        this.mThread = new InnerThread(this, r3, r4);
        this.mWaitReady = r5;
    }

    public ThreadWithHandler(String r3) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.mNextTickTime = 0;
        this.lock = new Object();
        this.mThread = new InnerThread(this, r3);
    }
}
