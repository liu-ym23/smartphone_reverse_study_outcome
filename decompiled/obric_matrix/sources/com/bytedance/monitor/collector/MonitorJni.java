package com.bytedance.monitor.collector;

import androidx.annotation.Keep;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class MonitorJni {
    public MonitorJni() {
    }

    @Keep
    public static native void clearAllocateInfo();

    @Keep
    static native void disableBinderHook();

    @Keep
    static native void disableLock();

    @Keep
    static native void doCollect();

    @Keep
    static native void doDestroy();

    @Keep
    static native void doDisableAtrace();

    @Keep
    static native String doDumpAtrace();

    @Keep
    static native String doDumpAtraceRange(long r0, long r2);

    @Keep
    static native void doDumpAtraceRangeToALog(long r0, long r2);

    @Keep
    static native String doDumpNativeStack(int r0);

    @Keep
    static native void doEnableAtrace(int r0, long r1);

    @Keep
    public static native long doGetAppCpuTime();

    @Keep
    static native long doGetCpuTime(int r0);

    @Keep
    static native String doGetSchedInfo(int r0);

    @Keep
    static native void doInit();

    @Keep
    static native void doSetDebugMode(boolean r0);

    @Keep
    static native void doStart();

    @Keep
    static native void doStop();

    @Keep
    static native void dumpProcInfoTimeRangeToALog(long r0, long r2);

    @Keep
    static native void enableBinderHook();

    @Keep
    static native void enableLock(long r0);

    @Keep
    static native void enableLockAll(long r0, boolean r2);

    @Keep
    public static native ByteBuffer getAllocReportInfo();

    @Keep
    public static native long getBlockGCCount();

    @Keep
    public static native long getBlockGCTime();

    @Keep
    public static native long getBytesAllocatedEver();

    @Keep
    public static native long getGCCount();

    @Keep
    public static native long getGCTime();

    @Keep
    public static native long getMajorFaults();

    @Keep
    public static native long getMinorFaults();

    @Keep
    public static native long getObjectsAllocatedEver();

    @Keep
    static native int getProcCGroup(int r0);

    @Keep
    static native String getProcInfoTimeRange(long r0, long r2);

    @Keep
    static native String getProcInfos();

    @Keep
    static native ThreadStatInfo getThreadStatInfo(int r0, int r1);

    @Keep
    static native long getTotalCPUTimeByTimeInStat(int r0);

    @Keep
    public static native boolean initJavaMem();

    @Keep
    static native void keepProcHyperOpen(boolean r0);

    @Keep
    static native boolean readProcFile(String r0, int[] r1, Object[] r2, long[] r3, float[] r4);

    @Keep
    public static native void releaseByteBuffer(long r0);

    @Keep
    static native void setAlogInstance(long r0);

    @Keep
    static native void setBufferSize(int r0);

    @Keep
    public static native boolean setEnableAllocatedMonitor(boolean r0, int r1, int r2, int r3, long r4, ClassLoader r6);

    @Keep
    static native void startHyperMonitor();

    @Keep
    public static native boolean startOrStopAllocatedMonitor(boolean r0, String r1);

    @Keep
    static native void stopHyperMonitor();
}
