package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NonBlockingThread;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingHelper {
    private BlockingHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static void awaitForComplete(CountDownLatch r4, Disposable r5) {
        if (r4.getCount() != 0) goto L10;
        return;
    L10:
        verifyNonBlocking();     // Catch: InterruptedException -> L7
        r4.await();     // Catch: InterruptedException -> L7
        return;
    L7:
        e = move-exception;
        r5.dispose();
        Thread.currentThread().interrupt();
        throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
    }

    public static void verifyNonBlocking() {
        if (RxJavaPlugins.isFailOnNonBlockingScheduler() == true) goto L5;
        return;
    L5:
        if ((Thread.currentThread() instanceof NonBlockingThread) == true) goto L10;
        if (RxJavaPlugins.onBeforeBlocking() == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
    }
}
