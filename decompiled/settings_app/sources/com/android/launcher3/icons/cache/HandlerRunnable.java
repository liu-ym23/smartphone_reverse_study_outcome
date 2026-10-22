package com.android.launcher3.icons.cache;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class HandlerRunnable<T> implements Runnable {
    private final Consumer<T> mCallback;
    private final Executor mCallbackExecutor;
    private boolean mCanceled;
    private final Runnable mEndRunnable;
    private boolean mEnded;
    private final Supplier<T> mTask;
    private final Handler mWorkerHandler;

    public static /* synthetic */ void $r8$lambda$gb2m1InnAoayw7K3MvjK2Ysr6xA(HandlerRunnable r0) {
        r0.onEnd();
    }

    static /* synthetic */ void lambda$new$0() {
    }

    public HandlerRunnable(Handler r7, Supplier<T> r8, Executor r9, Consumer<T> r10) {
        this(r7, r8, r9, r10, new HandlerRunnable$$ExternalSyntheticLambda0());
    }

    public HandlerRunnable(Handler r2, Supplier<T> r3, Executor r4, Consumer<T> r5, Runnable r6) {
        this.mEnded = false;
        this.mCanceled = false;
        this.mWorkerHandler = r2;
        this.mTask = r3;
        this.mCallbackExecutor = r4;
        this.mCallback = r5;
        this.mEndRunnable = r6;
    }

    public void cancel() {
        this.mWorkerHandler.removeCallbacks(this);
        this.mCanceled = true;
        this.mCallbackExecutor.execute(new HandlerRunnable$$ExternalSyntheticLambda1(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        final T r0 = this.mTask.get();
        this.mCallbackExecutor.execute(new HandlerRunnable$$ExternalSyntheticLambda2(this, r0));
    }

    /* JADX INFO: renamed from: lambda$run$1$com-android-launcher3-icons-cache-HandlerRunnable, reason: not valid java name */
    /* synthetic */ void m72lambda$run$1$comandroidlauncher3iconscacheHandlerRunnable(Object r2) {
        if (this.mCanceled == true) goto L5;
        this.mCallback.accept(r2);
    L5:
        onEnd();
    }

    private void onEnd() {
        if (this.mEnded == true) goto L6;
        this.mEnded = true;
        this.mEndRunnable.run();
        return;
    }
}
