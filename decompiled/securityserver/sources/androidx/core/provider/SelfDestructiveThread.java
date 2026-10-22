package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;

    @GuardedBy("mLock")
    private int mGeneration;

    @GuardedBy("mLock")
    private Handler mHandler;
    private final Object mLock;
    private final int mPriority;

    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final String mThreadName;

    public interface ReplyCallback<T> {
        void onReply(T r1);
    }

    public SelfDestructiveThread(String r2, int r3, int r4) {
        this.mLock = new Object();
        this.mCallback = new AnonymousClass1(this);
        this.mThreadName = r2;
        this.mPriority = r3;
        this.mDestructAfterMillisec = r4;
        this.mGeneration = 0;
    }

    private void post(Runnable r6) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread != null) goto L9;
        HandlerThread r1 = new HandlerThread(this.mThreadName, this.mPriority);     // Catch: Throwable -> L7
        this.mThread = r1;     // Catch: Throwable -> L7
        r1.start();     // Catch: Throwable -> L7
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);     // Catch: Throwable -> L7
        this.mGeneration++;     // Catch: Throwable -> L7
    L9:
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L7
        Handler r5 = this.mHandler;     // Catch: Throwable -> L7
        r5.sendMessage(r5.obtainMessage(1, r6));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @VisibleForTesting
    public int getGeneration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mGeneration;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public boolean isRunning() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void onDestruction() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandler.hasMessages(1) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mThread.quit();     // Catch: Throwable -> L8
        this.mThread = null;     // Catch: Throwable -> L8
        this.mHandler = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void onInvokeRunnable(Runnable r5) {
        r5.run();
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L7
        Handler r0 = this.mHandler;     // Catch: Throwable -> L7
        r0.sendMessageDelayed(r0.obtainMessage(0), this.mDestructAfterMillisec);     // Catch: Throwable -> L7
        monitor-exit(r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> void postAndReply(final Callable<T> r3, final ReplyCallback<T> r4) {
        final Handler r0 = new Handler();
        post(new AnonymousClass2(this, r3, r0, r4));
    }

    public <T> T postAndWait(final Callable<T> r13, int r14) {
        final ReentrantLock r7 = new ReentrantLock();
        final Condition r8 = r7.newCondition();
        final AtomicReference r9 = new AtomicReference();
        final AtomicBoolean r10 = new AtomicBoolean(true);
        post(new AnonymousClass3(this, r9, r13, r7, r10, r8));
        r7.lock();
    L8:
        th = move-exception;
        r7.unlock();
        throw th;
    L4:
        if (r10.get() == true) goto L10;
        T r12 = (T) r9.get();
        r7.unlock();
        return r12;
    L10:
        long r15 = TimeUnit.MILLISECONDS.toNanos(r14);     // Catch: Throwable -> L8
    L26:
        r15 = r8.awaitNanos(r15);     // Catch: Throwable -> L8 InterruptedException -> L24
    L13:
        if (r10.get() == false) goto L14;
        if (r15 > 0) goto L26;
        throw new InterruptedException("timeout");     // Catch: Throwable -> L8
    L14:
        T r16 = (T) r9.get();
        r7.unlock();
        return r16;
    }
}
