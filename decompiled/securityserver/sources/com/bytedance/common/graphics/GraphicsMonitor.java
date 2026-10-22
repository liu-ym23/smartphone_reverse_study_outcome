package com.bytedance.common.graphics;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Keep
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

    public GraphicsMonitor() {
    }

    public static /* synthetic */ boolean access$000() {
        return isPause;
    }

    public static /* synthetic */ boolean access$002(boolean r0) {
        isPause = r0;
        return r0;
    }

    public static /* synthetic */ void access$100() {
        openStatistical();
    }

    public static /* synthetic */ long access$200() {
        return sCollectWindow;
    }

    public static /* synthetic */ void access$300() {
        closeStatistical();
    }

    public static /* synthetic */ double access$400() {
        return gpuLoadDataOnce;
    }

    public static /* synthetic */ double access$402(double r0) {
        gpuLoadDataOnce = r0;
        return r0;
    }

    public static /* synthetic */ double access$500() {
        return getStatisticOnceData();
    }

    @Keep
    private static native void closeStatistical();

    public static synchronized double getByteGpu() {
        monitor-enter(GraphicsMonitor.class);
        double r1 = gpuLoadDataOnce;     // Catch: Throwable -> L7
        monitor-exit(GraphicsMonitor.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Keep
    private static native double getStatisticOnceData();

    public static synchronized void init() {
        monitor-enter(GraphicsMonitor.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isInit == false) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        isInit = true;     // Catch: Throwable -> L13
        sCollectInterval = 15000;     // Catch: Throwable -> L13
        sCollectWindow = 100;     // Catch: Throwable -> L13
        ActivityLifecycleService r1 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L13
        lifecycleService = r1;     // Catch: Throwable -> L13
        r1.register(new AnonymousClass1());     // Catch: Throwable -> L13
        if (lifecycleService.isForeground() == false) goto L15;
        isPause = false;     // Catch: Throwable -> L13
    L15:
        monitor-exit(GraphicsMonitor.class);
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static void initGraphicsLoad() {
        isInitGraphicsLoad = true;
        PerfMonitorManager.loadLibrary(ApmBaseContext.getContext());     // Catch: Throwable -> L5
        startHook();     // Catch: Throwable -> L5
        gpuScheduleService = Executors.newScheduledThreadPool(0);     // Catch: Throwable -> L5
        return;
    L5:
        isInitGraphicsLoad = false;
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

    @Keep
    private static native void openStatistical();

    public static synchronized void start() {
        monitor-enter(GraphicsMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        monitor-exit(GraphicsMonitor.class);
        return;
    L9:
        if (isInitGraphicsLoad == true) goto L13;
        initGraphicsLoad();     // Catch: Throwable -> L11
    L13:
        ScheduledExecutorService r2 = gpuScheduleService;     // Catch: Throwable -> L11
        if (r2 != null) goto L17;
        monitor-exit(GraphicsMonitor.class);
        return;
    L17:
        int r1 = startTime + 1;     // Catch: Throwable -> L11
        startTime = r1;     // Catch: Throwable -> L11
        if (r1 <= 1) goto L21;
        monitor-exit(GraphicsMonitor.class);
        return;
    L21:
        Runnable r3 = new AnonymousClass2();     // Catch: Throwable -> L11
        long r6 = sCollectInterval;     // Catch: Throwable -> L11
        gpuFuture = r2.scheduleWithFixedDelay(r3, r6, r6, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        monitor-exit(GraphicsMonitor.class);
    }

    @Keep
    private static native boolean startHook();

    public static synchronized void stop() {
        monitor-enter(GraphicsMonitor.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L7;
    L21:
        monitor-exit(GraphicsMonitor.class);
        return;
    L7:
        if (isStart() == false) goto L21;
        int r1 = startTime - 1;     // Catch: Throwable -> L16
        startTime = r1;     // Catch: Throwable -> L16
        if (r1 <= 0) goto L13;
        monitor-exit(GraphicsMonitor.class);
        return;
    L13:
        ScheduledFuture<?> r2 = gpuFuture;     // Catch: Throwable -> L16
        if (r2 == null) goto L18;
        r2.cancel(true);     // Catch: Throwable -> L16
    L18:
        gpuLoadDataOnce = -1.0d;     // Catch: Throwable -> L16
        monitor-exit(GraphicsMonitor.class);
    }
}
