package com.bytedance.apm.perf;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PerfDataCenter {
    private static volatile PerfDataCenter singleton;

    private PerfDataCenter() {
    }

    public static PerfDataCenter getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(PerfDataCenter.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new PerfDataCenter();     // Catch: Throwable -> L9
    L11:
        monitor-exit(PerfDataCenter.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    public JSONObject getCpuInfo() {
        JSONObject r4 = new JSONObject();
        ICpuDataService r0 = (ICpuDataService) ServiceManager.getService(ICpuDataService.class);     // Catch: JSONException -> L5
        r4.put(PerfConsts.PERF_CPU_PROCESS_USAGE, r0.getCpuRate());     // Catch: JSONException -> L5
        r4.put(PerfConsts.PERF_CPU_STAT_SPEED, r0.getCpuSpeed());     // Catch: JSONException -> L5
        return r4;
    L6:
        return new JSONObject();
    }
}
