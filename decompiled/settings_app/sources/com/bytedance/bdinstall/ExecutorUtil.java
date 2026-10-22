package com.bytedance.bdinstall;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.bdinstall.util.Singleton;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ExecutorUtil {
    private static final Singleton<Handler> HANDLER = null;
    private static volatile ExecutorService sIOExecutor;
    private static volatile Looper sLooper;
    private static volatile Executor sNetExecutor;

    public ExecutorUtil() {
    }

    static {
        HANDLER = new AnonymousClass1();
    }

    private static Executor getNetExecutor() {
        if (sNetExecutor != null) goto L15;
        monitor-enter(ExecutorUtil.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sNetExecutor != null) goto L9;
        sNetExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExecutorUtil.class);     // Catch: Throwable -> L11
    L15:
        return sNetExecutor;
    }

    private static ExecutorService getIOExecutor() {
        if (sIOExecutor != null) goto L15;
        monitor-enter(ExecutorUtil.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sIOExecutor != null) goto L9;
        sIOExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new SynchronousQueue());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExecutorUtil.class);     // Catch: Throwable -> L11
    L15:
        return sIOExecutor;
    }

    public static Looper getLooper() {
        if (sLooper != null) goto L17;
        monitor-enter(ExecutorUtil.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sLooper == null) goto L18;
    L11:
        monitor-exit(ExecutorUtil.class);     // Catch: Throwable -> L13
        goto L17
    L18:
        HandlerThread r1 = new HandlerThread("bd_install");     // Catch: Exception -> L10 Throwable -> L13
        r1.start();     // Catch: Exception -> L10 Throwable -> L13
        sLooper = r1.getLooper();     // Catch: Exception -> L10 Throwable -> L13
    L10:
        sLooper = Looper.getMainLooper();     // Catch: Throwable -> L13
    L17:
        return sLooper;
    }

    public static void runOnNetExecutor(Runnable r1) {
        getNetExecutor().execute(r1);
    }

    public static void runOnIOExecutor(Runnable r1) {
        getIOExecutor().execute(r1);
    }

    public static <T> Future<T> submitToIOExecutor(Callable<T> r1) {
        return getIOExecutor().submit(r1);
    }

    public static void runOnHandlerThread(Runnable r2) {
        if (Looper.myLooper() != getLooper()) goto L5;
        r2.run();
        return;
    L5:
        HANDLER.get(new Object[0]).post(r2);
    }

    static void setExecutor(ExecutorOptions r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Executor r0 = r2.networkExecutor;
        if (sNetExecutor != null) goto L8;
        if (r0 == null) goto L8;
        sNetExecutor = r0;
    L8:
        ExecutorService r1 = r2.ioExecutor;
        if (sIOExecutor != null) goto L12;
        if (r1 == null) goto L12;
        sIOExecutor = r1;
    L12:
        Looper r3 = r2.workLooper;
        if (sLooper != null) goto L17;
        if (r3 == null) goto L18;
        sLooper = r3;
        return;
    L18:
        return;
    }

    public static Handler getHandler() {
        return HANDLER.get(new Object[0]);
    }
}
