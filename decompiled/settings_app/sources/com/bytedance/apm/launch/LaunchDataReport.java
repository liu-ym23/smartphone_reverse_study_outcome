package com.bytedance.apm.launch;

import com.bytedance.apm.internal.FunctionSwitcher;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LaunchDataReport {
    private static boolean hasFetch = false;

    static {
    }

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
    L62:
        th = move-exception;
        th.printStackTrace();
        LaunchAnalysisContext.getInstance().logE(th.getLocalizedMessage());
        return null;
    L7:
        if (r11.getGcCount() == (-1)) goto L10;
        r2.put(LaunchCommon.LAUNCH_DATA_GC_COUNT, r11.getGcCount());     // Catch: Throwable -> L62
    L10:
        if (r11.getGcTime() == (-1)) goto L13;
        r2.put(LaunchCommon.LAUNCH_DATA_GC_TIME, r11.getGcTime());     // Catch: Throwable -> L62
    L13:
        if (r11.getBlockGcCount() == (-1)) goto L16;
        r2.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_COUNT, r11.getBlockGcCount());     // Catch: Throwable -> L62
    L16:
        if (r11.getBlockGcTime() == (-1)) goto L19;
        r2.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_TIME, r11.getBlockGcTime());     // Catch: Throwable -> L62
    L19:
        if (r11.getIowaitTime() == (-1.0d)) goto L22;
        r2.put(LaunchCommon.LAUNCH_DATA_IOWAIT_TIME, r11.getIowaitTime());     // Catch: Throwable -> L62
    L22:
        if (r11.getRunnableTime() == (-1.0d)) goto L25;
        r2.put(LaunchCommon.LAUNCH_DATA_RUNNABLE_TIME, r11.getRunnableTime());     // Catch: Throwable -> L62
    L25:
        if (r11.getSleepTime() == (-1.0d)) goto L28;
        r2.put(LaunchCommon.LAUNCH_DATA_SLEEP_TIME, r11.getSleepTime());     // Catch: Throwable -> L62
    L28:
        if (r11.getMinorFault() == (-1)) goto L31;
        r2.put(LaunchCommon.LAUNCH_DATA_MINOR_FAULT, r11.getMinorFault());     // Catch: Throwable -> L62
    L31:
        if (r11.getMajorFault() == (-1)) goto L34;
        r2.put(LaunchCommon.LAUNCH_DATA_MAJOR_FAULT, r11.getMajorFault());     // Catch: Throwable -> L62
    L34:
        if (r11.getCpuTime() == (-1.0d)) goto L37;
        r2.put(LaunchCommon.LAUNCH_DATA_CPU_TIME, r11.getCpuTime());     // Catch: Throwable -> L62
    L37:
        if (r11.getVoluntarySwitches() == (-1)) goto L40;
        r2.put(LaunchCommon.LAUNCH_DATA_VOLUNTARY_SWITCHES, r11.getVoluntarySwitches());     // Catch: Throwable -> L62
    L40:
        if (r11.getInVoluntarySwitches() == (-1)) goto L43;
        r2.put(LaunchCommon.LAUNCH_DATA_INVOLUNTARY_SWITCHES, r11.getInVoluntarySwitches());     // Catch: Throwable -> L62
    L43:
        if (r11.getAllThreadCount() == (-1)) goto L46;
        r2.put(LaunchCommon.LAUNCH_DATA_ALL_THREAD_COUNT, r11.getAllThreadCount());     // Catch: Throwable -> L62
    L46:
        if (r11.getLockTime() == (-1)) goto L49;
        r2.put(LaunchCommon.LAUNCH_DATA_LOCK_TIME, r11.getLockTime());     // Catch: Throwable -> L62
    L49:
        if (r11.getBinderTime() == (-1)) goto L51;
        r2.put(LaunchCommon.LAUNCH_DATA_BINDER_TIME, r11.getBinderTime());     // Catch: Throwable -> L62
    L51:
        r1.put(LaunchCommon.LAUNCH_DATA_LIST_DATA, r2);     // Catch: Throwable -> L62
        List<String> r12 = r11.getJavaThreadNameList();     // Catch: Throwable -> L62
        if (r12 != null) goto L54;
    L60:
        LaunchAnalysisContext.getInstance().logD("perf data: " + r1);     // Catch: Throwable -> L62
        return r1;
    L54:
        if (r12.isEmpty() == true) goto L60;
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L62
        Iterator<String> r13 = r12.iterator();     // Catch: Throwable -> L62
    L57:
        if (r13.hasNext() == false) goto L59;
        r3.put(r13.next());     // Catch: Throwable -> L62
        goto L57
    L59:
        r1.put(LaunchCommon.LAUNCH_DATA_JAVA_THREAD_NAME_LIST, r3);     // Catch: Throwable -> L62
        goto L60
    }
}
