package com.bytedance.common.utility.m;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f3292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f3293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ExecutorService f3294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ScheduledExecutorService f3295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ExecutorService f3296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ExecutorService f3297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3298g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3299h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3300i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3301j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3302k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f3303l = 0;
    private static final c m = null;
    private static final c n = null;
    private static final c o = null;
    private static final c p = null;
    private static final c q = null;
    private static final b r = null;
    private static final BlockingQueue<Runnable> s = null;
    private static final BlockingQueue<Runnable> t = null;
    private static final BlockingQueue<Runnable> u = null;
    private static final RejectedExecutionHandler v = null;

    /* JADX INFO: renamed from: com.bytedance.common.utility.m.a$a, reason: collision with other inner class name */
    static class RejectedExecutionHandlerC0090a implements RejectedExecutionHandler {
        RejectedExecutionHandlerC0090a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r1, ThreadPoolExecutor r2) {
            Executors.newCachedThreadPool().execute(r1);
        }
    }

    private static class b implements ThreadFactory {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicInteger f3304i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ThreadGroup f3305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f3306g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f3307h;

        /* JADX INFO: renamed from: com.bytedance.common.utility.m.a$b$a, reason: collision with other inner class name */
        class C0091a extends Thread {
            C0091a(b r7, ThreadGroup r8, Runnable r9, String r10, long r11) {
                super(r8, r9, r10, r11);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        static {
            f3304i = new AtomicInteger(1);
        }

        b(String r3) {
            this.f3306g = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.f3305f = r1;
            this.f3307h = r3 + "-" + f3304i.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r9) {
            C0091a r7 = new C0091a(this, this.f3305f, r9, this.f3307h + this.f3306g.getAndIncrement(), 0);
            if (r7.isDaemon() == false) goto L5;
            r7.setDaemon(false);
        L5:
            return r7;
        }
    }

    private static class c implements ThreadFactory {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicInteger f3308i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ThreadGroup f3309f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f3310g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f3311h;

        static {
            f3308i = new AtomicInteger(1);
        }

        c(String r3) {
            this.f3310g = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.f3309f = r1;
            this.f3311h = r3 + "-" + f3308i.getAndIncrement() + "-Thread-";
            return;
        L5:
            r1 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r8) {
            Thread r6 = new Thread(this.f3309f, r8, this.f3311h + this.f3310g.getAndIncrement(), 0);
            if (r6.isDaemon() == false) goto L6;
            r6.setDaemon(false);
        L6:
            if (r6.getPriority() == 5) goto L8;
            r6.setPriority(5);
        L8:
            return r6;
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        f3298g = r0;
        if (r0 > 0) goto L6;
        r0 = 1;
    L6:
        f3299h = r0;
        int r5 = Math.max(2, Math.min(r0 - 1, 6)) * 2;
        f3300i = r5;
        int r6 = (r5 * 2) + 1;
        f3301j = r6;
        int r15 = Math.max(2, Math.min(r0 - 1, 3));
        f3302k = r15;
        int r16 = (r0 * 2) + 1;
        f3303l = r16;
        c r11 = new c("TTDefaultExecutors");
        m = r11;
        c r1 = new c("TTCpuExecutors");
        n = r1;
        c r2 = new c("TTScheduledExecutors");
        o = r2;
        c r3 = new c("TTDownLoadExecutors");
        p = r3;
        c r14 = new c("TTSerialExecutors");
        q = r14;
        b r12 = new b("TTBackgroundExecutors");
        r = r12;
        LinkedBlockingQueue r10 = new LinkedBlockingQueue();
        s = r10;
        LinkedBlockingQueue r20 = new LinkedBlockingQueue();
        t = r20;
        LinkedBlockingQueue r23 = new LinkedBlockingQueue();
        u = r23;
        RejectedExecutionHandlerC0090a r25 = new RejectedExecutionHandlerC0090a();
        v = r25;
        TimeUnit r26 = TimeUnit.SECONDS;
        com.bytedance.common.utility.m.b r17 = new com.bytedance.common.utility.m.b(r5, r6, 30, r26, r10, r11, r25);
        f3292a = r17;
        r17.allowCoreThreadTimeOut(true);
        com.bytedance.common.utility.m.b r4 = new com.bytedance.common.utility.m.b(r15, r16, 30, r26, r20, r1, r25);
        f3293b = r4;
        r4.allowCoreThreadTimeOut(true);
        f3295d = Executors.newScheduledThreadPool(3, r2);
        com.bytedance.common.utility.m.b r7 = new com.bytedance.common.utility.m.b(2, 2, 30, r26, r23, r3, r25);
        f3294c = r7;
        r7.allowCoreThreadTimeOut(true);
        com.bytedance.common.utility.m.b r8 = new com.bytedance.common.utility.m.b(1, 1, 30, r26, new LinkedBlockingQueue(), r14);
        f3296e = r8;
        r8.allowCoreThreadTimeOut(true);
        com.bytedance.common.utility.m.b r9 = new com.bytedance.common.utility.m.b(0, 3, 30, r26, new LinkedBlockingQueue(), r12);
        f3297f = r9;
        r9.allowCoreThreadTimeOut(true);
    }

    public static ExecutorService a() {
        return f3293b;
    }

    public static ExecutorService b() {
        return f3294c;
    }

    public static ExecutorService c() {
        return f3292a;
    }

    public static ScheduledExecutorService d() {
        return f3295d;
    }
}
