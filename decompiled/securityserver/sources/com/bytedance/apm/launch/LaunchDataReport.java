package com.bytedance.apm.launch;

import com.bytedance.apm.internal.FunctionSwitcher;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LaunchDataReport {
    private static boolean hasFetch = false;

    public LaunchDataReport() {
    }

    public static LaunchPerfDataFetcher.LaunchTraceData createPerfData() {
        if (hasFetch == false) goto L5;
        return null;
    L5:
        hasFetch = true;
        if (LaunchAnalysisContext.getInstance().getConfig().isNeedCollectPerfData() == true) goto L9;
        return null;
    L9:
        if (FunctionSwitcher.getSwitch(4) == true) goto L12;
        return null;
    L12:
        return LaunchPerfDataFetcher.getLaunchTraceData();
    }

    public static JSONObject packagePerfData(LaunchPerfDataFetcher.LaunchTraceData r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
    L9:
        th = move-exception;
        th.printStackTrace();
        LaunchAnalysisContext.getInstance().logE(th.getLocalizedMessage());
        return null;
    L7:
        if (r11.getGcCount() == (-1)) goto L12;
        r2.put(LaunchCommon.LAUNCH_DATA_GC_COUNT, r11.getGcCount());     // Catch: Throwable -> L9
    L12:
        if (r11.getGcTime() == (-1)) goto L15;
        r2.put(LaunchCommon.LAUNCH_DATA_GC_TIME, r11.getGcTime());     // Catch: Throwable -> L9
    L15:
        if (r11.getBlockGcCount() == (-1)) goto L18;
        r2.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_COUNT, r11.getBlockGcCount());     // Catch: Throwable -> L9
    L18:
        if (r11.getBlockGcTime() == (-1)) goto L21;
        r2.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_TIME, r11.getBlockGcTime());     // Catch: Throwable -> L9
    L21:
        if (r11.getIowaitTime() == (-1.0d)) goto L24;
        r2.put(LaunchCommon.LAUNCH_DATA_IOWAIT_TIME, r11.getIowaitTime());     // Catch: Throwable -> L9
    L24:
        if (r11.getRunnableTime() == (-1.0d)) goto L27;
        r2.put(LaunchCommon.LAUNCH_DATA_RUNNABLE_TIME, r11.getRunnableTime());     // Catch: Throwable -> L9
    L27:
        if (r11.getSleepTime() == (-1.0d)) goto L30;
        r2.put(LaunchCommon.LAUNCH_DATA_SLEEP_TIME, r11.getSleepTime());     // Catch: Throwable -> L9
    L30:
        if (r11.getMinorFault() == (-1)) goto L33;
        r2.put(LaunchCommon.LAUNCH_DATA_MINOR_FAULT, r11.getMinorFault());     // Catch: Throwable -> L9
    L33:
        if (r11.getMajorFault() == (-1)) goto L36;
        r2.put(LaunchCommon.LAUNCH_DATA_MAJOR_FAULT, r11.getMajorFault());     // Catch: Throwable -> L9
    L36:
        if (r11.getCpuTime() == (-1.0d)) goto L39;
        r2.put(LaunchCommon.LAUNCH_DATA_CPU_TIME, r11.getCpuTime());     // Catch: Throwable -> L9
    L39:
        if (r11.getVoluntarySwitches() == (-1)) goto L42;
        r2.put(LaunchCommon.LAUNCH_DATA_VOLUNTARY_SWITCHES, r11.getVoluntarySwitches());     // Catch: Throwable -> L9
    L42:
        if (r11.getInVoluntarySwitches() == (-1)) goto L45;
        r2.put(LaunchCommon.LAUNCH_DATA_INVOLUNTARY_SWITCHES, r11.getInVoluntarySwitches());     // Catch: Throwable -> L9
    L45:
        if (r11.getAllThreadCount() == (-1)) goto L48;
        r2.put(LaunchCommon.LAUNCH_DATA_ALL_THREAD_COUNT, r11.getAllThreadCount());     // Catch: Throwable -> L9
    L48:
        if (r11.getLockTime() == (-1)) goto L51;
        r2.put(LaunchCommon.LAUNCH_DATA_LOCK_TIME, r11.getLockTime());     // Catch: Throwable -> L9
    L51:
        if (r11.getBinderTime() == (-1)) goto L53;
        r2.put(LaunchCommon.LAUNCH_DATA_BINDER_TIME, r11.getBinderTime());     // Catch: Throwable -> L9
    L53:
        r1.put(LaunchCommon.LAUNCH_DATA_LIST_DATA, r2);     // Catch: Throwable -> L9
        List<String> r12 = r11.getJavaThreadNameList();     // Catch: Throwable -> L9
        if (r12 != null) goto L56;
    L62:
        LaunchAnalysisContext.getInstance().logD("perf data: " + r1);     // Catch: Throwable -> L9
        return r1;
    L56:
        if (r12.isEmpty() == true) goto L62;
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L9
        Iterator<String> r13 = r12.iterator();     // Catch: Throwable -> L9
    L59:
        if (r13.hasNext() == false) goto L61;
        r3.put(r13.next());     // Catch: Throwable -> L9
        goto L59
    L61:
        r1.put(LaunchCommon.LAUNCH_DATA_JAVA_THREAD_NAME_LIST, r3);     // Catch: Throwable -> L9
        goto L62
    }
}
