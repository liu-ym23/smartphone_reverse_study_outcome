package com.ttnet.org.chromium.base.task;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE = 0;
    private static final int RUNNABLE_WARNING_COUNT = 32;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static final ThreadFactory sThreadFactory = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.task.ChromeThreadPoolExecutor$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger mCount;

        AnonymousClass1() {
            this.mCount = new AtomicInteger(1);
        }

        static /* synthetic */ void a(Runnable r1) {
            Process.setThreadPriority(10);
            r1.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r4) {
            return new Thread(new d(r4), "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r0;
        CORE_POOL_SIZE = Math.max(2, Math.min(r0 - 1, 4));
        MAXIMUM_POOL_SIZE = (r0 * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    @VisibleForTesting
    ChromeThreadPoolExecutor(int r1, int r2, long r3, TimeUnit r5, BlockingQueue<Runnable> r6, ThreadFactory r7) {
        super(r1, r2, r3, r5, r6, r7);
        allowCoreThreadTimeOut(true);
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> r4) {
        StringBuilder r3 = new StringBuilder();
        Iterator<Map.Entry<String, Integer>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r0 = r5.next();
        if (r0.getValue().intValue() <= 32) goto L4;
        r3.append(r0.getKey());
        r3.append(' ');
        goto L4
    L9:
        if (r3.length() != 0) goto L13;
        return "NO CLASSES FOUND";
    L13:
        return r3.toString();
    }

    private static String getClassName(Runnable r3) {
        Class r0 = r3.getClass();
        if (r0 != AsyncTask.NamedFutureTask.class) goto L8;
        Class r4 = ((AsyncTask.NamedFutureTask) r3).getBlamedClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L6:
        r0 = r4;
    L21:
        return r0.getName();
    L8:
        if (r0.getEnclosingClass() != android.os.AsyncTask.class) goto L21;
        Field r1 = r0.getDeclaredField("this$0");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r4 = r1.get(r3).getClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L11:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    }

    private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() {
        HashMap r0 = new HashMap();
        Runnable[] r6 = (Runnable[]) getQueue().toArray(new Runnable[0]);
        int r2 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        String r4 = getClassName(r6[r3]);
        if (r0.containsKey(r4) == false) goto L7;
        int r5 = ((Integer) r0.get(r4)).intValue();
    L8:
        r0.put(r4, Integer.valueOf(r5 + 1));
        r3 = r3 + 1;
        goto L3
    L7:
        r5 = 0;
        goto L8
    L9:
        return r0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r5) {
        super.execute(r5);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(getNumberOfClassNameOccurrencesInQueue()), e);
    }
}
