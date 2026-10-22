package com.bytedance.apm.perf;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.perf.entity.CpuInfo;
import com.bytedance.apm.perf.entity.MemoryInfo;
import com.bytedance.apm.util.CommonMonitorUtil;

/* JADX INFO: loaded from: classes3.dex */
public class PerfCollectUtils {
    public PerfCollectUtils() {
    }

    public static MemoryInfo getMemory(Context r8) {
        MemoryInfo r0 = new MemoryInfo();
        long r1 = Runtime.getRuntime().totalMemory();     // Catch: Exception -> L12
        long r3 = Runtime.getRuntime().freeMemory();     // Catch: Exception -> L12
        r0.javaTotalMemory = r1;     // Catch: Exception -> L12
        r0.javaFreeMemory = r3;     // Catch: Exception -> L12
        r0.javaUsedMemory = r1 - r3;     // Catch: Exception -> L12
        Debug.MemoryInfo r9 = CommonMonitorUtil.getPidMemoryInfo(Process.myPid(), r8);     // Catch: Exception -> L12
        if (r9 == null) goto L9;
        int r4 = r9.dalvikPss;     // Catch: Exception -> L12
        int r5 = r9.nativePss;     // Catch: Exception -> L12
        int r6 = r9.getTotalPss();     // Catch: Exception -> L12
        r0.graphics = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.GRAPHICS_MEM))) * 1024;     // Catch: Exception -> L11
        r0.javaHeap = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_JAVA_HEAP))) * 1024;     // Catch: Exception -> L11
        r0.nativeHeap = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_NATIVE_HEAP))) * 1024;     // Catch: Exception -> L11
        r0.code = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_CODE))) * 1024;     // Catch: Exception -> L11
        r0.stack = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_STACK))) * 1024;     // Catch: Exception -> L11
        r0.privateOther = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_PRIVATE_OTHER))) * 1024;     // Catch: Exception -> L11
        r0.system = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_SYSTEM))) * 1024;     // Catch: Exception -> L11
        r0.totalPss = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_TOTAL_PSS))) * 1024;     // Catch: Exception -> L11
        r0.totalSwap = ((long) Integer.parseInt(r9.getMemoryStat(PerfConsts.MEM_TOTAL_SWAP))) * 1024;     // Catch: Exception -> L11
    L8:
        r0.pssDalvik = ((long) r4) * 1024;     // Catch: Exception -> L12
        r0.pssNative = ((long) r5) * 1024;     // Catch: Exception -> L12
        r0.pssTotal = ((long) r6) * 1024;     // Catch: Exception -> L12
        r0.dalvikPrivateDirty = ((long) r9.dalvikPrivateDirty) * 1024;     // Catch: Exception -> L12
        r0.dalvikSharedDirty = ((long) r9.dalvikSharedDirty) * 1024;     // Catch: Exception -> L12
        r0.otherPss = ((long) r9.otherPss) * 1024;     // Catch: Exception -> L12
        r0.otherPrivateDirty = ((long) r9.otherPrivateDirty) * 1024;     // Catch: Exception -> L12
        r0.otherSharedDirty = ((long) r9.otherSharedDirty) * 1024;     // Catch: Exception -> L12
        r0.totalSwappablePss = ((long) r9.getTotalSwappablePss()) * 1024;     // Catch: Exception -> L12
        r0.totalPrivateDirty = ((long) r9.getTotalPrivateDirty()) * 1024;     // Catch: Exception -> L12
        r0.totalSharedClean = ((long) r9.getTotalSharedClean()) * 1024;     // Catch: Exception -> L12
    L9:
        r0.vmSize = CommonMonitorUtil.getVmSize() * 1024;     // Catch: Exception -> L12
    L10:
        return r0;
    }

    public static CpuInfo getCpuRate() {
        CpuInfo r0 = new CpuInfo();
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L19
        long r3 = CommonMonitorUtil.getAppCPUTime();     // Catch: Exception -> L19
        boolean r5 = CommonMonitorUtil.isProcStatCanRead();     // Catch: Exception -> L19
        if (r5 == false) goto L7;
        long r8 = CommonMonitorUtil.getTotalCPUTime();     // Catch: Exception -> L19
    L20:
        Thread.sleep(360);     // Catch: InterruptedException -> L18 Exception -> L19
    L10:
        long r10 = CommonMonitorUtil.getAppCPUTime();     // Catch: Exception -> L19
        if (r5 == false) goto L15;
        long r12 = CommonMonitorUtil.getTotalCPUTime() - r8;     // Catch: Exception -> L19
        if (r12 <= 0) goto L15;
        double r6 = (r10 - r3) / r12;     // Catch: Exception -> L19
    L16:
        double r7 = (((r10 - r3) * 1000.0d) / (System.currentTimeMillis() - r1)) / CommonMonitorUtil.getScClkTck(100);     // Catch: Exception -> L19
        r0.cpuAppRate = r6;     // Catch: Exception -> L19
        r0.cpuAppSpeed = r7;     // Catch: Exception -> L19
    L15:
        r6 = 0.0d;
        goto L16
    L7:
        r8 = 0;
    L17:
        return r0;
    }
}
