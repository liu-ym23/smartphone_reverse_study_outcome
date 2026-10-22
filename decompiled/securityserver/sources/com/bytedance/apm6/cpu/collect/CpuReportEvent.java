package com.bytedance.apm6.cpu.collect;

import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.Pair;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CpuReportEvent extends PerfBaseEvent {
    private static final String FILTERS_BATTERY_CURRENT = "battery_current";
    private static final String FILTERS_BATTERY_LEVEL = "battery_level";
    private static final String FILTERS_BATTERY_THERMAL = "battery_thermal";
    private static final String FILTERS_CPU_HARDWARE = "cpu_hardware";
    private static final String FILTERS_IS_CHARGING = "is_charging";
    private static final String FILTERS_NETWORK_TYPE = "network_type";
    private static final String FILTERS_POWER_SAVE_MODE = "power_save_mode";
    private static final String FILTERS_THERMAL_STATUS = "thermal_status";
    private static final String FILTER_IS_AUTO_SAMPLE = "is_auto_sample";
    private static final String FILTER_IS_NORMAL_SAMPLE_STATE = "is_normal_sample_state";
    private static final String PERF_APP_MAX_STAT_SPEED = "app_max_stat_speed";
    private static final String PERF_APP_STAT_SPEED = "app_stat_speed";
    private static final String PERF_CPU_APP_MAX_USAGE_RATE = "app_max_usage_rate";
    private static final String PERF_CPU_APP_USAGE_RATE = "app_usage_rate";
    public static final String PERF_DATA_TYPE = "data_type";
    private static final String PERF_THREAD_CPU_USAGE = "thread_cpu_usage";
    private static final String SERVICE_NAME = "cpu";
    private static final String SERVICE_NAME_THREAD = "cpu_thread";
    public static final String VALUE_BACK = "back";
    public static final String VALUE_FRONT = "front";
    public static final String VALUE_MIX = "mix";
    private float batteryCurrent;
    private CpuCacheItem.CpuDataType dataType;
    private IAssistStat.CpuFactorTag factorTag;
    private boolean isAutoSample;
    private boolean isNormalSampleState;
    private double metricCpuSpeed;
    private double metricMaxCpuSpeed;
    private double metricMaxRate;
    private double metricRate;
    private String sceneString;
    private List<Pair<String, Double>> threadUsageList;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.collect.CpuReportEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = null;

        static {
            int[] r0 = new int[CpuCacheItem.CpuDataType.values().length];
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = r0;
            r0[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType r2, String r3, double r4, double r6, double r8, double r10, @Nullable IAssistStat.CpuFactorTag r12) {
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.dataType = r2;
        this.sceneString = r3;
        this.metricRate = r4;
        this.metricMaxRate = r6;
        this.metricCpuSpeed = r8;
        this.metricMaxCpuSpeed = r10;
        this.factorTag = r12;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L11
        r0.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L11
        r0.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L11
        r0.put("scene", this.sceneString);     // Catch: Throwable -> L11
        int r3 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[this.dataType.ordinal()];     // Catch: Throwable -> L11
        if (r3 != 1) goto L6;
        r0.put(PERF_DATA_TYPE, VALUE_MIX);     // Catch: Throwable -> L11
    L15:
        return r0;
    L6:
        if (r3 != 2) goto L8;
        r0.put(PERF_DATA_TYPE, VALUE_BACK);     // Catch: Throwable -> L11
        goto L15
    L8:
        if (r3 != 3) goto L15;
        r0.put(PERF_DATA_TYPE, "front");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraValues() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L19
        if (hasThreadUsageData() == false) goto L21;
        Iterator<Pair<String, Double>> r7 = this.threadUsageList.iterator();     // Catch: Throwable -> L19
    L6:
        if (r7.hasNext() == false) goto L31;
        Pair<String, Double> r1 = r7.next();     // Catch: Throwable -> L19
        if (r1 == null) goto L6;
        String r2 = r1.first;     // Catch: Throwable -> L19
        if (r2 == null) goto L6;
        if (r2.isEmpty() == true) goto L6;
        Double r3 = r1.second;     // Catch: Throwable -> L19
        if (r3 == null) goto L6;
        if (r3.doubleValue() == 0.0d) goto L6;
        r0.put(r1.first, r1.second);     // Catch: Throwable -> L19
    L31:
        return r0;
    L21:
        double r4 = this.metricRate;     // Catch: Throwable -> L19
        if (r4 > (-1.0d)) goto L24;
    L26:
        double r5 = this.metricCpuSpeed;     // Catch: Throwable -> L19
        if (r5 <= (-1.0d)) goto L31;
        if (this.metricMaxCpuSpeed <= (-1.0d)) goto L31;
        r0.put("app_stat_speed", r5);     // Catch: Throwable -> L19
        r0.put("app_max_stat_speed", this.metricMaxCpuSpeed);     // Catch: Throwable -> L19
        goto L31
    L24:
        if (this.metricMaxRate <= (-1.0d)) goto L26;
        r0.put("app_usage_rate", r4);     // Catch: Throwable -> L19
        r0.put("app_max_usage_rate", this.metricMaxRate);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L5
        r0.put(FILTER_IS_AUTO_SAMPLE, this.isAutoSample);     // Catch: Throwable -> L5
        if (this.factorTag == null) goto L7;
        r0.put("network_type", NetworkUtils.getNetworkTypeFast(ApmContext.getContext()));     // Catch: Throwable -> L5
        r0.put(FILTERS_BATTERY_LEVEL, this.factorTag.batteryLevel);     // Catch: Throwable -> L5
        r0.put(FILTERS_CPU_HARDWARE, this.factorTag.cpuHardware);     // Catch: Throwable -> L5
        r0.put("is_charging", this.factorTag.isCharging);     // Catch: Throwable -> L5
        r0.put(FILTERS_POWER_SAVE_MODE, this.factorTag.powerSaveMode);     // Catch: Throwable -> L5
        r0.put(FILTERS_THERMAL_STATUS, this.factorTag.thermalStatus);     // Catch: Throwable -> L5
        r0.put(FILTERS_BATTERY_THERMAL, this.factorTag.batteryThermal);     // Catch: Throwable -> L5
        r0.put(FILTER_IS_NORMAL_SAMPLE_STATE, this.isNormalSampleState);     // Catch: Throwable -> L5
    L7:
        float r4 = this.batteryCurrent;     // Catch: Throwable -> L5
        if (r4 <= 0.0f) goto L10;
        r0.put(FILTERS_BATTERY_CURRENT, r4);     // Catch: Throwable -> L5
    L10:
        return r0;
    L5:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public String getServiceName() {
        if (hasThreadUsageData() == false) goto L6;
        return SERVICE_NAME_THREAD;
    L6:
        return "cpu";
    }

    public boolean hasThreadUsageData() {
        List<Pair<String, Double>> r0 = this.threadUsageList;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public void setBatteryCurrent(float r1) {
        this.batteryCurrent = r1;
    }

    public void setIsAutoSample(boolean r1) {
        this.isAutoSample = r1;
    }

    public void setNormalSampleState(boolean r1) {
        this.isNormalSampleState = r1;
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType r3, String r4, List<Pair<String, Double>> r5, IAssistStat.CpuFactorTag r6) {
        this.metricRate = -1.0d;
        this.metricMaxRate = -1.0d;
        this.metricCpuSpeed = -1.0d;
        this.metricMaxCpuSpeed = -1.0d;
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.threadUsageList = new ArrayList(r5);
        this.dataType = r3;
        this.sceneString = r4;
        this.factorTag = r6;
    }
}
