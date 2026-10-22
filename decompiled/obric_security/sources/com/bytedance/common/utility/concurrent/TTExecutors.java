package com.bytedance.common.utility.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class TTExecutors {
    public static final int AVAILABLEPROCESSORS = 0;
    public static final int CORE_POOL_SIZE_CPU = 0;
    public static final int CORE_POOL_SIZE_NORMAL = 0;
    public static final int CORE_POOL_SIZE_SCHEDULED = 3;
    public static final int CPU_COUNT = 0;
    public static final int DOWNLOAD_THREAD_COUNT = 2;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE_CPU = 0;
    public static final int MAXIMUM_POOL_SIZE_NORMAL = 0;
    public static final int MAX_POOL_SIZE = 3;
    private static final BackgroundThreadFactory S_BACKGROUND_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_CPU_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_DEFAULT_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_DOWNLOAD_THREAD_FACTORY = null;
    private static final RejectedExecutionHandler S_HANDLER = null;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE = null;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE_CPU = null;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE_DOWNLOAD = null;
    private static final DefaultThreadFactory S_SCHEDULED_THREAD_FACTORY = null;
    private static final DefaultThreadFactory S_SERIAL_THREAD_FACTORY = null;
    private static ExecutorService sBackgroundThreadPool;
    private static ExecutorService sCPUThreadPool;
    private static ExecutorService sIOThreadPool;
    private static ExecutorService sNormalThreadPool;
    private static ScheduledExecutorService sScheduledThreadPool;
    private static ExecutorService sSerialThreadPool;

    private static class BackgroundThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = null;
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber;

        static {
            POOL_NUMBER = new AtomicInteger(1);
        }

        BackgroundThreadFactory(String r3) {
            this.threadNumber = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.group = r1;
            this.namePrefix = r3 + "-" + POOL_NUMBER.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r9) {
            final ThreadGroup r2 = this.group;
            final String r4 = this.namePrefix + this.threadNumber.getAndIncrement();
            final long r5 = 0;
            Thread r7 = new AnonymousClass1(this, r2, r9, r4, r5);
            if (r7.isDaemon() == false) goto L5;
            r7.setDaemon(false);
        L5:
            return r7;
        }
    }

    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = null;
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber;

        static {
            POOL_NUMBER = new AtomicInteger(1);
        }

        DefaultThreadFactory(String r3) {
            this.threadNumber = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.group = r1;
            this.namePrefix = r3 + "-" + POOL_NUMBER.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r8) {
            Thread r6 = new Thread(this.group, r8, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
            if (r6.isDaemon() == false) goto L6;
            r6.setDaemon(false);
        L6:
            if (r6.getPriority() == 5) goto L8;
            r6.setPriority(5);
        L8:
            return r6;
        }
    }

    public TTExecutors() {
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        AVAILABLEPROCESSORS = r0;
        if (r0 > 0) goto L6;
        r0 = 1;
    L6:
        CPU_COUNT = r0;
        int r5 = Math.max(2, Math.min(r0 - 1, 6)) * 2;
        CORE_POOL_SIZE_NORMAL = r5;
        int r6 = (r5 * 2) + 1;
        MAXIMUM_POOL_SIZE_NORMAL = r6;
        int r15 = Math.max(2, Math.min(r0 - 1, 3));
        CORE_POOL_SIZE_CPU = r15;
        int r16 = (r0 * 2) + 1;
        MAXIMUM_POOL_SIZE_CPU = r16;
        DefaultThreadFactory r11 = new DefaultThreadFactory("TTDefaultExecutors");
        S_DEFAULT_THREAD_FACTORY = r11;
        DefaultThreadFactory r1 = new DefaultThreadFactory("TTCpuExecutors");
        S_CPU_THREAD_FACTORY = r1;
        DefaultThreadFactory r2 = new DefaultThreadFactory("TTScheduledExecutors");
        S_SCHEDULED_THREAD_FACTORY = r2;
        DefaultThreadFactory r3 = new DefaultThreadFactory("TTDownLoadExecutors");
        S_DOWNLOAD_THREAD_FACTORY = r3;
        DefaultThreadFactory r14 = new DefaultThreadFactory("TTSerialExecutors");
        S_SERIAL_THREAD_FACTORY = r14;
        BackgroundThreadFactory r12 = new BackgroundThreadFactory("TTBackgroundExecutors");
        S_BACKGROUND_THREAD_FACTORY = r12;
        LinkedBlockingQueue r10 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE = r10;
        LinkedBlockingQueue r20 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE_CPU = r20;
        LinkedBlockingQueue r23 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE_DOWNLOAD = r23;
        RejectedExecutionHandler r25 = new AnonymousClass1();
        S_HANDLER = r25;
        TTThreadPoolExecutor r9 = new TTThreadPoolExecutor(r5, r6, 30, TimeUnit.SECONDS, r10, r11, r25);
        sNormalThreadPool = r9;
        r9.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor r4 = new TTThreadPoolExecutor(r15, r16, 30, TimeUnit.SECONDS, r20, r1, r25);
        sCPUThreadPool = r4;
        r4.allowCoreThreadTimeOut(true);
        sScheduledThreadPool = Executors.newScheduledThreadPool(3, r2);
        TTThreadPoolExecutor r7 = new TTThreadPoolExecutor(2, 2, 30, TimeUnit.SECONDS, r23, r3, r25);
        sIOThreadPool = r7;
        r7.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor r8 = new TTThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), r14);
        sSerialThreadPool = r8;
        r8.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor r13 = new TTThreadPoolExecutor(0, 3, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), r12);
        sBackgroundThreadPool = r13;
        r13.allowCoreThreadTimeOut(true);
    }

    public static ExecutorService getNormalExecutor() {
        return sNormalThreadPool;
    }

    @Deprecated
    public static ExecutorService getDownLoadThreadPool() {
        return sIOThreadPool;
    }

    public static ScheduledExecutorService getScheduledThreadPool() {
        return sScheduledThreadPool;
    }

    public static ExecutorService getCPUThreadPool() {
        return sCPUThreadPool;
    }

    public static ExecutorService getIOThreadPool() {
        return sIOThreadPool;
    }

    public static ExecutorService getSerialThreadPool() {
        return sSerialThreadPool;
    }

    public static ExecutorService getBackgroundThreadPool() {
        return sBackgroundThreadPool;
    }

    public static void setNormalThreadPool(ExecutorService r0) {
        sNormalThreadPool = r0;
    }

    public static void setCPUThreadPool(ExecutorService r0) {
        sCPUThreadPool = r0;
    }

    public static void setIOThreadPool(ExecutorService r0) {
        sIOThreadPool = r0;
    }

    public static void setScheduledThreadPool(ScheduledExecutorService r0) {
        sScheduledThreadPool = r0;
    }

    public static void setSerialThreadPool(ExecutorService r0) {
        sSerialThreadPool = r0;
    }

    public static void setBackgroundThreadPool(ExecutorService r0) {
        sBackgroundThreadPool = r0;
    }
}
