package com.bytedance.apm6.disk;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DiskReportEvent extends PerfBaseEvent {
    private static final String PERF_DISK_APP_USAGE = "app_usage";
    private static final String PERF_DISK_CACHE = "cache";
    private static final String PERF_DISK_DATA = "data";
    private static final String PERF_DISK_DISK_INFO = "disk_info";
    private static final String PERF_DISK_EXCEPTION_FOLDERS = "exception_folders";
    private static final String PERF_DISK_FREE_CAPACITY = "free_capacity";
    private static final String PERF_DISK_OCCUPIED_RATE = "app_occupied_rate";
    private static final String PERF_DISK_OUTDATED_FILES = "outdated_files";
    private static final String PERF_DISK_ROM_FREE = "rom_free";
    private static final String PERF_DISK_TOP_USAGE = "top_usage";
    private static final String PERF_DISK_TOTAL = "total";
    private static final String PERF_DISK_TOTAL_CAPACITY = "total_capacity";
    private static final String SERVICE_NAME = "disk";
    private double appOccupiedRate;
    private long appUsage;
    private long cacheUsed;
    private long dataUsed;
    private JSONArray diskInfo;
    private JSONArray exceptionFolder;
    private long freeCapacity;
    private JSONArray outDateList;
    private long romFreeSpace;
    private JSONArray topUsage;
    private long totalCapacity;
    private long totalSize;

    public DiskReportEvent(long r4, long r6, long r8, long r10, long r12, long r14, long r16, double r18, JSONArray r20, JSONArray r21, JSONArray r22, JSONArray r23) {
        this.dataUsed = r4;
        this.cacheUsed = r6;
        this.totalSize = r8;
        this.romFreeSpace = r10;
        this.appUsage = r12;
        this.totalCapacity = r14;
        this.freeCapacity = r16;
        this.appOccupiedRate = r18;
        this.topUsage = r20;
        this.exceptionFolder = r21;
        this.outDateList = r22;
        this.diskInfo = r23;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject createRootJSONObject() {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = this.diskInfo;     // Catch: Exception -> L16
        if (r1 == null) goto L6;
        r0.put("disk_info", r1);     // Catch: Exception -> L16
    L6:
        JSONArray r2 = this.topUsage;     // Catch: Exception -> L16
        if (r2 == null) goto L9;
        r0.put("top_usage", r2);     // Catch: Exception -> L16
    L9:
        JSONArray r3 = this.exceptionFolder;     // Catch: Exception -> L16
        if (r3 == null) goto L12;
        r0.put("exception_folders", r3);     // Catch: Exception -> L16
    L12:
        JSONArray r4 = this.outDateList;     // Catch: Exception -> L16
        if (r4 == null) goto L15;
        r0.put("outdated_files", r4);     // Catch: Exception -> L16
    L15:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L4
        r2.put("scene", PerfFilterManager.getInstance().getSceneString());     // Catch: Throwable -> L4
        r2.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L4
        r2.put(CommonKey.KEY_IS_FRONT, false);     // Catch: Throwable -> L4
        r2.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraValues() {
        JSONObject r0 = new JSONObject();
        long r1 = this.dataUsed;     // Catch: Exception -> L28
        if (r1 <= 0) goto L6;
        r0.put("data", r1);     // Catch: Exception -> L28
    L6:
        long r2 = this.cacheUsed;     // Catch: Exception -> L28
        if (r2 <= 0) goto L9;
        r0.put("cache", r2);     // Catch: Exception -> L28
    L9:
        long r3 = this.totalSize;     // Catch: Exception -> L28
        if (r3 <= 0) goto L12;
        r0.put("total", r3);     // Catch: Exception -> L28
    L12:
        long r4 = this.romFreeSpace;     // Catch: Exception -> L28
        if (r4 <= 0) goto L15;
        r0.put("rom_free", r4);     // Catch: Exception -> L28
    L15:
        long r5 = this.appUsage;     // Catch: Exception -> L28
        if (r5 <= 0) goto L18;
        r0.put(PERF_DISK_APP_USAGE, r5);     // Catch: Exception -> L28
    L18:
        long r6 = this.totalCapacity;     // Catch: Exception -> L28
        if (r6 <= 0) goto L21;
        r0.put(PERF_DISK_TOTAL_CAPACITY, r6);     // Catch: Exception -> L28
    L21:
        long r7 = this.freeCapacity;     // Catch: Exception -> L28
        if (r7 <= 0) goto L24;
        r0.put(PERF_DISK_FREE_CAPACITY, r7);     // Catch: Exception -> L28
    L24:
        double r8 = this.appOccupiedRate;     // Catch: Exception -> L28
        if (r8 <= 0.0d) goto L27;
        r0.put(PERF_DISK_OCCUPIED_RATE, r8);     // Catch: Exception -> L28
    L27:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        JSONObject r1 = PerfFilterManager.getInstance().getPerfFiltersJson();
        JsonUtils.copyJson2(r1, PerfFilterManager.getInstance().getRealTimeMemInfo());     // Catch: Exception -> L5
    L4:
        return r1;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public String getServiceName() {
        return "disk";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }
}
