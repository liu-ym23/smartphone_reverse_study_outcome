package com.bytedance.apm6.cpu.exception.normal;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm.perf.TemperatureDataManager;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CpuNormalExceptionEvent implements Monitorable {
    private static final String EVENT_CPU_EXCEPTION = "cpu_exception_trace";
    private static final String KEY_BATTERY_RECHARGE_STATE = "battery_recharge_state";
    private static final String KEY_BATTERY_TEMPERATURE = "battery_temperature";
    public static final String KEY_MAX_BACKGROUND = "apm_max_background";
    public static final String KEY_MAX_FOREGROUND = "apm_max_foreground";
    private static final String KEY_PROCESS_SPEED_AVG = "process_speed_avg";
    private static final String KEY_PROCESS_SPEED_MAX = "process_speed_max";
    private static final String KEY_THREAD_CPU_USAGE = "cpu_usage";
    private static final String KEY_THREAD_INFO = "threads_info";
    private static final String KEY_THREAD_NAME = "thread_name";
    private static final String KEY_THREAD_PRIORITY = "nice";
    private static final String KEY_THREAD_STACK = "thread_back_trace";
    private static final String KEY_THREAD_TID = "thread_id";
    private static final String KEY_THREAD_WEIGHT = "weight";
    private double avgLoad;
    private boolean isBackground;
    private List<ThreadExceptionItem> itemList;
    private double maxLoad;
    private String scene;

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "cpu_exception_trace";
    }

    public CpuNormalExceptionEvent(double r1, double r3, List<ThreadExceptionItem> r5, String r6, boolean r7) {
        this.avgLoad = r1;
        this.maxLoad = r3;
        this.scene = r6;
        this.isBackground = r7;
        this.itemList = new ArrayList(r5);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        List<ThreadExceptionItem> r0 = this.itemList;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L11;
        if (this.avgLoad <= 0.0d) goto L11;
        if (this.maxLoad <= 0.0d) goto L11;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r2 = new JSONObject();
        r2.put("event_type", "cpu_exception_trace");     // Catch: Throwable -> L24
        r2.put("log_type", "cpu_exception_trace");     // Catch: Throwable -> L24
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L24
        r2.put(CommonKey.KEY_CRASH_TIME, System.currentTimeMillis());     // Catch: Throwable -> L24
        r2.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L24
        r2.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L24
        if (this.isBackground == false) goto L7;
        r2.put(CpuReportEvent.PERF_DATA_TYPE, CpuReportEvent.VALUE_BACK);     // Catch: Throwable -> L24
    L8:
        r2.put("scene", this.scene);     // Catch: Throwable -> L24
        r2.put(CommonKey.KEY_REPORT_SCENE, this.scene);     // Catch: Throwable -> L24
        if (ApmContext.getAppLaunchStartTimestamp() <= ApmContext.getStartId()) goto L12;
    L14:
        r2.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getStartId());     // Catch: Throwable -> L24
    L15:
        r2.put(KEY_PROCESS_SPEED_AVG, this.avgLoad);     // Catch: Throwable -> L24
        r2.put(KEY_PROCESS_SPEED_MAX, this.maxLoad);     // Catch: Throwable -> L24
        r2.put("battery_temperature", TemperatureDataManager.getInstance().getTemperature());     // Catch: Throwable -> L24
        r2.put(KEY_BATTERY_RECHARGE_STATE, TemperatureDataManager.getInstance().getStatus());     // Catch: Throwable -> L24
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L24
        Iterator<ThreadExceptionItem> r8 = this.itemList.iterator();     // Catch: Throwable -> L24
    L17:
        if (r8.hasNext() == false) goto L22;
        ThreadExceptionItem r3 = r8.next();     // Catch: Throwable -> L24
        if (r3 == null) goto L17;
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L24
        r4.put(KEY_THREAD_PRIORITY, r3.getPriority());     // Catch: Throwable -> L24
        r4.put(KEY_THREAD_WEIGHT, Double.valueOf(r3.getWeight()));     // Catch: Throwable -> L24
        r4.put(KEY_THREAD_CPU_USAGE, r3.getCpuUsage());     // Catch: Throwable -> L24
        r4.put(KEY_THREAD_NAME, r3.getThreadName());     // Catch: Throwable -> L24
        r4.put(KEY_THREAD_STACK, r3.getStack());     // Catch: Throwable -> L24
        r4.put("thread_id", r3.getThreadId());     // Catch: Throwable -> L24
        r1.put(r4);     // Catch: Throwable -> L24
        goto L17
    L22:
        r2.put(KEY_THREAD_INFO, r1);     // Catch: Throwable -> L24
    L27:
        Log.i(Constants.TAG, "exception data: " + r2);
        return r2;
    L12:
        if (ApmContext.getAppLaunchStartTimestamp() == 0) goto L14;
        r2.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getAppLaunchStartTimestamp());     // Catch: Throwable -> L24
        goto L15
    L7:
        r2.put(CpuReportEvent.PERF_DATA_TYPE, "front");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Logger.e(Constants.TAG, "cpu_exception_data_assemble", th);
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L29
        r5.put("exception", th.getLocalizedMessage());     // Catch: Throwable -> L29
        CommonEventDeliverer.monitorDuration("cpu_exception_no_stack", r5, null);     // Catch: Throwable -> L29
        goto L27
    }
}
