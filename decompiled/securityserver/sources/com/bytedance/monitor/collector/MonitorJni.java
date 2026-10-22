package com.bytedance.monitor.collector;

import androidx.annotation.Keep;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;

/* JADX INFO: loaded from: classes.dex */
public class MonitorJni {
    public MonitorJni() {
    }

    @Keep
    public static native void disableBinderHook();

    @Keep
    public static native void disableLock();

    @Keep
    public static native void doCollect();

    @Keep
    public static native void doDestroy();

    @Keep
    public static native void doDisableAtrace();

    @Keep
    public static native String doDumpAtrace();

    @Keep
    public static native String doDumpAtraceRange(long r0, long r2);

    @Keep
    public static native void doDumpAtraceRangeToALog(long r0, long r2);

    @Keep
    public static native String doDumpNativeStack(int r0);

    @Keep
    public static native void doEnableAtrace(int r0, long r1);

    @Keep
    public static native long doGetAppCpuTime();

    @Keep
    public static native long doGetCpuTime(int r0);

    @Keep
    public static native String doGetSchedInfo(int r0);

    @Keep
    public static native void doInit();

    @Keep
    public static native void doSetDebugMode(boolean r0);

    @Keep
    public static native void doStart();

    @Keep
    public static native void doStop();

    @Keep
    public static native void dumpProcInfoTimeRangeToALog(long r0, long r2);

    @Keep
    public static native void enableBinderHook();

    @Keep
    public static native void enableLock(long r0);

    @Keep
    public static native void enableLockAll(long r0, boolean r2);

    @Keep
    public static native int getProcCGroup(int r0);

    @Keep
    public static native String getProcInfoTimeRange(long r0, long r2);

    @Keep
    public static native String getProcInfos();

    @Keep
    public static native ThreadStatInfo getThreadStatInfo(int r0, int r1);

    @Keep
    public static native long getTotalCPUTimeByTimeInStat(int r0);

    @Keep
    public static native void keepProcHyperOpen(boolean r0);

    @Keep
    public static native boolean readProcFile(String r0, int[] r1, Object[] r2, long[] r3, float[] r4);

    @Keep
    public static native void setAlogInstance(long r0);

    @Keep
    public static native void setBufferSize(int r0);

    @Keep
    public static native void startHyperMonitor();

    @Keep
    public static native void stopHyperMonitor();
}
