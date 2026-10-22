package com.bytedance.common.graphics;

import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicsMonitor {
    private static final long COLLECT_WINDOWS = 100;
    private static final String MTK = "mt";
    private static final long POLL_INTERVAL = 15000;
    private static ScheduledFuture<?> gpuFuture = null;
    private static double gpuLoadDataOnce = -1.0d;
    private static ScheduledExecutorService gpuScheduleService = null;
    private static boolean isInit = false;
    private static boolean isInitGraphicsLoad = false;
    private static volatile boolean isPause = false;
    private static ActivityLifecycleService lifecycleService;
    private static long sCollectInterval;
    private static long sCollectWindow;
    private static int startTime;

    static {
    }

    private static native void closeStatistical();

    private static native double getStatisticOnceData();

    private static native void openStatistical();

    private static native boolean startHook();

    public GraphicsMonitor() {
    }

    static /* synthetic */ boolean access$000() {
        return isPause;
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        isPause = r0;
        return r0;
    }

    static /* synthetic */ void access$100() {
        openStatistical();
    }

    static /* synthetic */ long access$200() {
        return sCollectWindow;
    }

    static /* synthetic */ void access$300() {
        closeStatistical();
    }

    static /* synthetic */ double access$400() {
        return gpuLoadDataOnce;
    }

    static /* synthetic */ double access$402(double r0) {
        gpuLoadDataOnce = r0;
        return r0;
    }

    static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    public static synchronized double getByteGpu() {
        monitor-enter(GraphicsMonitor.class);
        double r1 = gpuLoadDataOnce;     // Catch: Throwable -> L7
        monitor-exit(GraphicsMonitor.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean isStart() {
        monitor-enter(GraphicsMonitor.class);
        if (startTime <= 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(GraphicsMonitor.class);
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized void init() {
        monitor-enter(GraphicsMonitor.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L14
        sCollectInterval = 15000;     // Catch: Throwable -> L14
        sCollectWindow = 100;     // Catch: Throwable -> L14
        ActivityLifecycleService r1 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L14
        lifecycleService = r1;     // Catch: Throwable -> L14
        r1.register(new AnonymousClass1());     // Catch: Throwable -> L14
        if (lifecycleService.isForeground() == false) goto L12;
        isPause = false;     // Catch: Throwable -> L14
    L12:
        monitor-exit(GraphicsMonitor.class);
    }

    public static synchronized void start() {
        monitor-enter(GraphicsMonitor.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        if (isInitGraphicsLoad == true) goto L11;
        initGraphicsLoad();     // Catch: Throwable -> L22
    L11:
        ScheduledExecutorService r2 = gpuScheduleService;     // Catch: Throwable -> L22
        if (r2 != null) goto L15;
        monitor-exit(GraphicsMonitor.class);
        return;
    L15:
        int r1 = startTime + 1;     // Catch: Throwable -> L22
        startTime = r1;     // Catch: Throwable -> L22
        if (r1 <= 1) goto L19;
        monitor-exit(GraphicsMonitor.class);
        return;
    L19:
        Runnable r3 = new AnonymousClass2();     // Catch: Throwable -> L22
        long r6 = sCollectInterval;     // Catch: Throwable -> L22
        gpuFuture = r2.scheduleWithFixedDelay(r3, r6, r6, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        monitor-exit(GraphicsMonitor.class);
    }

    public static synchronized void stop() {
        monitor-enter(GraphicsMonitor.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L7;
    L19:
        monitor-exit(GraphicsMonitor.class);
        return;
    L7:
        if (isStart() == false) goto L19;
        int r1 = startTime - 1;     // Catch: Throwable -> L21
        startTime = r1;     // Catch: Throwable -> L21
        if (r1 <= 0) goto L13;
        monitor-exit(GraphicsMonitor.class);
        return;
    L13:
        ScheduledFuture<?> r2 = gpuFuture;     // Catch: Throwable -> L21
        if (r2 == null) goto L16;
        r2.cancel(true);     // Catch: Throwable -> L21
    L16:
        gpuLoadDataOnce = -1.0d;     // Catch: Throwable -> L21
        monitor-exit(GraphicsMonitor.class);
    }

    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        PerfMonitorManager.loadLibrary(ApmBaseContext.getContext());     // Catch: Throwable -> L5
        startHook();     // Catch: Throwable -> L5
        gpuScheduleService = Executors.newScheduledThreadPool(0);     // Catch: Throwable -> L5
        return;
    L5:
        isInitGraphicsLoad = false;
    }
}
