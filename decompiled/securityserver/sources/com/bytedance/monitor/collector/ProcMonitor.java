package com.bytedance.monitor.collector;

import android.util.Pair;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;

/* JADX INFO: loaded from: classes.dex */
public class ProcMonitor extends AbsMonitor {
    private int bufferSize;
    private boolean mALogCollectMode;
    TaskRunnable mCollectTask;
    private int mInterval;

    public ProcMonitor(int r2) {
        super(r2, MonitorType.PROC_MONITOR);
        this.bufferSize = 200;
        this.mInterval = 1000;
        this.mALogCollectMode = true;
        this.mCollectTask = AsyncTaskUtil.wrapLightWeightTask("collect-proc", new AnonymousClass1(this));
    }

    public static long getCpuTime(int r4) {
    L9:
        return -1;
    L4:
        if (PerfMonitorManager.soLoaded == true) goto L6;
        return -1;
    L6:
        return MonitorJni.doGetCpuTime(r4) * Sysconf.getJiffyMills();
    }

    public static String getThreadSchedInfo(int r1) {
        if (PerfMonitorManager.soLoaded == true) goto L7;
        return "";
    L7:
        return MonitorJni.doGetSchedInfo(r1);
    }

    public static void init() {
        if (PerfMonitorManager.soLoaded == true) goto L5;
        return;
    L5:
        MonitorJni.doInit();     // Catch: Throwable -> L7
        return;
    }

    public synchronized void collect() {
        monitor-enter(this);
        if (PerfMonitorManager.soLoaded == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MonitorJni.doCollect();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void destroy() {
        super.destroy();
        if (PerfMonitorManager.soLoaded == true) goto L6;
        return;
    L6:
        MonitorJni.doDestroy();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public synchronized Pair<String, String> dumpInfo() {
        monitor-enter(this);
        if (PerfMonitorManager.soLoaded == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.mCollectorType, MonitorJni.getProcInfos());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public synchronized Pair<String, String> dumpInfosRange(long r4, long r6) {
        monitor-enter(this);
        if (PerfMonitorManager.soLoaded == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.mCollectorType, MonitorJni.getProcInfoTimeRange(r4, r6));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void dumpInfosToALog(long r2, long r4, long r6) {
        if (PerfMonitorManager.soLoaded == true) goto L5;
        return;
    L5:
        if (this.mALogCollectMode == true) goto L13;
        MonitorJni.dumpProcInfoTimeRangeToALog(r2 - r6, r4);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public void setALogCollectMode(boolean r2) {
        if (r2 != this.mALogCollectMode) goto L5;
        return;
    L5:
        this.mALogCollectMode = r2;
        start();
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void start() {
        super.start();
        if (PerfMonitorManager.soLoaded == true) goto L6;
        return;
    L6:
        if (this.mRunMode == 0) goto L20;
        boolean r0 = this.mALogCollectMode;     // Catch: Throwable -> L16
        if (r0 == false) goto L11;
        this.mInterval = 5000;     // Catch: Throwable -> L16
    L12:
        MonitorJni.keepProcHyperOpen(r0);     // Catch: Throwable -> L16
        MonitorJni.doStart();     // Catch: Throwable -> L16
        IAsyncTaskManager r2 = this.mAsyncTaskManager;     // Catch: Throwable -> L16
        if (r2 == null) goto L21;
        r2.scheduleWithFixedDelay(this.mCollectTask, 0, this.mInterval);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L11:
        this.mInterval = 1000;     // Catch: Throwable -> L16
        goto L12
    L20:
        return;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void stop() {
        super.stop();
        if (PerfMonitorManager.soLoaded == true) goto L6;
        return;
    L6:
        IAsyncTaskManager r0 = this.mAsyncTaskManager;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.removeTask(this.mCollectTask);     // Catch: Throwable -> L11
    L9:
        MonitorJni.doStop();     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void updateConfig(int r3) {
        if (PerfMonitorManager.soLoaded == true) goto L5;
        return;
    L5:
        stop();     // Catch: Throwable -> L18
        if (r3 != 0) goto L8;
        return;
    L8:
        if (r3 != 1) goto L10;
        this.bufferSize = 200;     // Catch: Throwable -> L18
        this.mInterval = 1000;     // Catch: Throwable -> L18
        MonitorJni.setBufferSize(200);     // Catch: Throwable -> L18
    L16:
        start();     // Catch: Throwable -> L18
        return;
    L10:
        if (r3 != 2) goto L12;
    L14:
        this.bufferSize = 400;     // Catch: Throwable -> L18
        this.mInterval = 1000;     // Catch: Throwable -> L18
        MonitorJni.setBufferSize(400);     // Catch: Throwable -> L18
        goto L16
    L12:
        if (r3 == 3) goto L14;
    }
}
