package com.bytedance.apm6.cpu.collect;

import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class InitiativeCpuCollectManager {
    private static volatile boolean isConfigReady;
    private static Map<String, CacheDataItem> sCacheCollectData;
    private static List<CpuReportEvent> sCacheReportData;

    private static class CacheDataItem {
        public long appCpuTime;
        public long startTime;
        public long totalCpuTime;

        private CacheDataItem() {
        }

        /* synthetic */ CacheDataItem(AnonymousClass1 r1) {
            this();
        }
    }

    public InitiativeCpuCollectManager() {
    }

    static /* synthetic */ boolean access$100() {
        return isConfigReady;
    }

    static /* synthetic */ List access$200() {
        return sCacheReportData;
    }

    static {
        sCacheCollectData = new HashMap();
        sCacheReportData = new LinkedList();
        isConfigReady = false;
    }

    public static synchronized void onConfigReady() {
        monitor-enter(InitiativeCpuCollectManager.class);
        isConfigReady = true;     // Catch: Throwable -> L14
        if (sCacheReportData.isEmpty() == true) goto L12;
        Iterator<CpuReportEvent> r1 = sCacheReportData.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L11;
        Monitor.record(r1.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        sCacheReportData.clear();     // Catch: Throwable -> L14
    L12:
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized void startCollect(String r4) {
        monitor-enter(InitiativeCpuCollectManager.class);
        CacheDataItem r1 = new CacheDataItem(null);     // Catch: Throwable -> L7
        r1.startTime = System.currentTimeMillis();     // Catch: Throwable -> L7
        r1.appCpuTime = PerfMonitorManager.getInstance().dumpAppCPUTime();     // Catch: Throwable -> L7
        r1.totalCpuTime = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(CommonMonitorUtil.getCpuCoreNum());     // Catch: Throwable -> L7
        sCacheCollectData.put(r4, r1);     // Catch: Throwable -> L7
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void stopCollect(String r12, boolean r13) {
        monitor-enter(InitiativeCpuCollectManager.class);
        CacheDataItem r1 = sCacheCollectData.get(r12);     // Catch: Throwable -> L22
        if (r1 != null) goto L9;
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L9:
        if (r1.appCpuTime < 0) goto L12;
    L15:
        long r2 = PerfMonitorManager.getInstance().dumpAppCPUTime();     // Catch: Throwable -> L22
        long r6 = PerfMonitorManager.getInstance().dumpTotalCPUTimeByTimeInStat(CommonMonitorUtil.getCpuCoreNum());     // Catch: Throwable -> L22
        if ((r6 - r1.totalCpuTime) <= 0) goto L18;
        double r4 = (r2 - r1.appCpuTime) / (r6 - r1.totalCpuTime);     // Catch: Throwable -> L22
    L19:
        double r9 = (((r2 - r1.appCpuTime) * 1000.0d) / (System.currentTimeMillis() - r1.startTime)) / CommonMonitorUtil.getScClkTck(100);     // Catch: Throwable -> L22
        sCacheCollectData.remove(r12);     // Catch: Throwable -> L22
        sendData(r12, r4, r9, r13);     // Catch: Throwable -> L22
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L18:
        r4 = -1.0d;
        goto L19
    L12:
        if (r1.totalCpuTime >= 0) goto L15;
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    private static void sendData(final String r9, final double r10, final double r12, final boolean r14) {
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(new AnonymousClass1(r14, r9, r10, r12));
    }
}
