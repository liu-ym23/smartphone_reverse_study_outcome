package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object sLock = null;
    private static boolean sThreadAssertsDisabled;
    private static Handler sUiThreadHandler;
    private static boolean sWillOverride;

    public static class ThreadChecker {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final long mThreadId;

        public void assertOnValidThread() {
        }

        static {
        }

        public ThreadChecker() {
            this.mThreadId = Process.myTid();
        }
    }

    public static void assertOnBackgroundThread() {
    }

    public static void assertOnUiThread() {
    }

    public ThreadUtils() {
    }

    static /* synthetic */ boolean access$000() {
        return sThreadAssertsDisabled;
    }

    static {
        sLock = new Object();
    }

    public static void setWillOverrideUiThread(boolean r1) {
        Object r0 = sLock;
        monitor-enter(r0);
        sWillOverride = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setUiThread(Looper r4) {
        Object r1 = sLock;
        monitor-enter(r1);
        if (r4 == null) goto L6;
        Handler r2 = sUiThreadHandler;     // Catch: Throwable -> L20
        if (r2 != null) goto L12;
    L16:
        sUiThreadHandler = new Handler(r4);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        TraceEvent.onUiThreadReady();
        return;
    L12:
        if (r2.getLooper() == r4) goto L16;
        throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + r4);     // Catch: Throwable -> L20
    L6:
        sUiThreadHandler = null;     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static Handler getUiThreadHandler() {
        Object r0 = sLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sUiThreadHandler == null) goto L7;
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r1 == false) goto L16;
        TraceEvent.onUiThreadReady();
    L16:
        return sUiThreadHandler;
    L7:
        if (sWillOverride == true) goto L10;
        sUiThreadHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L17
        r1 = true;
        goto L12
    L10:
        throw new RuntimeException("Did not yet override the UI thread");     // Catch: Throwable -> L17
    }

    @Deprecated
    public static void runOnUiThreadBlocking(Runnable r2) {
        if (runningOnUiThread() == false) goto L5;
        r2.run();
        return;
    L5:
        FutureTask r0 = new FutureTask(r2, null);
        postOnUiThread(r0);
        r0.get();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Exception occurred while waiting for runnable", e);
    }

    @Deprecated
    public static <T> T runOnUiThreadBlockingNoException(Callable<T> r2) {
        return (T) runOnUiThreadBlocking(r2);
    L4:
        e = move-exception;
        throw new RuntimeException("Error occurred waiting for callable", e);
    }

    @Deprecated
    public static <T> T runOnUiThreadBlocking(Callable<T> r2) throws ExecutionException {
        FutureTask r0 = new FutureTask(r2);
        runOnUiThread(r0);
        return (T) r0.get();
    L5:
        e = move-exception;
        throw new RuntimeException("Interrupted waiting for callable", e);
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> r1) {
        if (runningOnUiThread() == false) goto L5;
        r1.run();
    L6:
        return r1;
    L5:
        postOnUiThread(r1);
        goto L6
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(Callable<T> r1) {
        return runOnUiThread(new FutureTask(r1));
    }

    @Deprecated
    public static void runOnUiThread(Runnable r1) {
        if (runningOnUiThread() == false) goto L5;
        r1.run();
        return;
    L5:
        getUiThreadHandler().post(r1);
    }

    @Deprecated
    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> r1) {
        getUiThreadHandler().post(r1);
        return r1;
    }

    @Deprecated
    public static void postOnUiThread(Runnable r1) {
        getUiThreadHandler().post(r1);
    }

    @Deprecated
    public static void postOnUiThreadDelayed(Runnable r1, long r2) {
        getUiThreadHandler().postDelayed(r1, r2);
    }

    public static void checkUiThread() {
        if (sThreadAssertsDisabled == false) goto L5;
        return;
    L5:
        if (runningOnUiThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on the UI thread.");
    }

    public static void setThreadAssertsDisabledForTesting(boolean r0) {
        sThreadAssertsDisabled = r0;
    }

    public static boolean runningOnUiThread() {
        if (getUiThreadHandler().getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    public static void setThreadPriorityAudio(int r1) {
        Process.setThreadPriority(r1, -16);
    }

    private static boolean isThreadPriorityAudio(int r1) {
        if (Process.getThreadPriority(r1) != (-16)) goto L5;
        return true;
    L5:
        return false;
    }
}
