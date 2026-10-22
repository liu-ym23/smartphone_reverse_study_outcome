package com.ttnet.org.chromium.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
public final class CallbackController {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    @GuardedBy
    private ArrayList<WeakReference<Cancelable>> mCancelables;
    private final ReentrantLock mReentrantLock;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.CallbackController$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AutoCloseableLock implements AutoCloseable {
        private boolean mIsLocked;
        private final Lock mLock;

        private AutoCloseableLock(Lock r1, boolean r2) {
            this.mLock = r1;
            this.mIsLocked = r2;
        }

        public static AutoCloseableLock lock(Lock r2) {
            r2.lock();
            return new AutoCloseableLock(r2, true);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.mIsLocked == false) goto L7;
            this.mIsLocked = false;
            this.mLock.unlock();
            return;
        L7:
            throw new IllegalStateException("mLock isn't locked.");
        }
    }

    public interface Cancelable {
        void cancel();
    }

    public class CancelableCallback<T> implements Cancelable, Callback<T> {

        @GuardedBy
        private Callback<T> mCallback;
        final /* synthetic */ CallbackController this$0;

        public /* synthetic */ CancelableCallback(CallbackController r1, Callback r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mCallback = null;
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(T r2) {
            AutoCloseableLock r0 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Callback<T> r1 = this.mCallback;     // Catch: Throwable -> L7
            if (r1 == null) goto L9;
            r1.onResult(r2);     // Catch: Throwable -> L7
        L9:
            if (r0 == null) goto L22;
            r0.close();
            return;
        L22:
            return;
        L7:
            th = move-exception;
            if (r0 != null) goto L18;
        L17:
            throw th;
        L18:
            r0.close();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            th.addSuppressed(th);
            goto L17
        }

        private CancelableCallback(@NonNull CallbackController r1, Callback<T> r2) {
            this.this$0 = r1;
            this.mCallback = r2;
        }
    }

    public class CancelableRunnable implements Cancelable, Runnable {

        @GuardedBy
        private Runnable mRunnable;
        final /* synthetic */ CallbackController this$0;

        public /* synthetic */ CancelableRunnable(CallbackController r1, Runnable r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mRunnable = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoCloseableLock r0 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Runnable r1 = this.mRunnable;     // Catch: Throwable -> L7
            if (r1 == null) goto L9;
            r1.run();     // Catch: Throwable -> L7
        L9:
            if (r0 == null) goto L22;
            r0.close();
            return;
        L22:
            return;
        L7:
            th = move-exception;
            if (r0 != null) goto L18;
        L17:
            throw th;
        L18:
            r0.close();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            th.addSuppressed(th);
            goto L17
        }

        private CancelableRunnable(@NonNull CallbackController r1, Runnable r2) {
            this.this$0 = r1;
            this.mRunnable = r2;
        }
    }

    public CallbackController() {
        this.mCancelables = new ArrayList();
        this.mReentrantLock = new ReentrantLock(true);
    }

    public static /* synthetic */ ReentrantLock access$000(CallbackController r0) {
        return r0.mReentrantLock;
    }

    @GuardedBy
    private void checkNotCanceled() {
        if (this.mCancelables == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("This CallbackController has already been destroyed.");
    }

    public void destroy() {
        AutoCloseableLock r0 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        Iterator r1 = CollectionUtil.strengthen(this.mCancelables).iterator();     // Catch: Throwable -> L7
    L5:
        if (r1.hasNext() == false) goto L9;
        ((Cancelable) r1.next()).cancel();     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mCancelables = null;     // Catch: Throwable -> L7
        if (r0 == null) goto L24;
        r0.close();
        return;
    L24:
        return;
    L7:
        th = move-exception;
        if (r0 != null) goto L21;
    L18:
        throw th;
    L21:
        r0.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    public <T> Callback<T> makeCancelable(@NonNull Callback<T> r4) {
        AutoCloseableLock r0 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableCallback r1 = new CancelableCallback(this, r4, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r1));     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L14;
    L13:
        throw th;
    L14:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public Runnable makeCancelable(@NonNull Runnable r4) {
        AutoCloseableLock r0 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableRunnable r1 = new CancelableRunnable(this, r4, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r1));     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L14;
    L13:
        throw th;
    L14:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
