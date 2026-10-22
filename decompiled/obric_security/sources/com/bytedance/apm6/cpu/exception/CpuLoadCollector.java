package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.monitor.collector.PerfMonitorManager;

/* JADX INFO: loaded from: classes.dex */
public class CpuLoadCollector {
    public CpuLoadCollector() {
    }

    public static double collectRate() {
        long r0 = CommonMonitorUtil.getTotalCPUTime();
        long r2 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        Thread.sleep(360);     // Catch: InterruptedException -> L9
    L4:
        long r4 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        long r6 = CommonMonitorUtil.getTotalCPUTime() - r0;
        if (r6 > 0) goto L12;
        return -1.0d;
    L12:
        return (r4 - r2) / r6;
    }

    public static double collectSpeed() {
        long r0 = System.currentTimeMillis();
        long r2 = PerfMonitorManager.getInstance().dumpAppCPUTime();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((PerfMonitorManager.getInstance().dumpAppCPUTime() - r2) * 1000.0d) / (System.currentTimeMillis() - r0)) / CommonMonitorUtil.getScClkTck(100);
    }
}
