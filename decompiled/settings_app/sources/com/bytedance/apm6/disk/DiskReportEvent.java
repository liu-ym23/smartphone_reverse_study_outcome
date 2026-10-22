package com.bytedance.apm6.disk;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DiskReportEvent extends PerfBaseEvent {
    private static final int MAX_DATA_SIZE = 262144;
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
    private int maxRoomOfJsonObject;
    private JSONArray outDateList;
    private long romFreeSpace;
    private JSONArray topUsage;
    private long totalCapacity;
    private long totalSize;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "disk";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public DiskReportEvent(long r4, long r6, long r8, long r10, long r12, long r14, long r16, double r18, JSONArray r20, JSONArray r21, JSONArray r22, JSONArray r23) {
        this.maxRoomOfJsonObject = 262144;
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
    protected JSONObject getExtraValues() {
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

    private static long getJsonSize(JSONArray r2) {
        return r2.toString().getBytes("UTF-8").length;
    L5:
        return 0;
    }

    private JSONArray tailorJsonObject(JSONArray r7) {
        if (r7 == null) goto L4;
        int r0 = 102400;
        int r1 = 0;
    L7:
        if (getJsonSize(r7) <= this.maxRoomOfJsonObject) goto L12;
        if (r1 > 10) goto L12;
        r7 = tailorDiskInfo(r7, r0);     // Catch: JSONException -> L13
    L11:
        r0 = r0 * 2;
        r1 = r1 + 1;
    L12:
        return r7;
    L4:
        return new JSONArray();
    }

    private JSONArray tailorDiskInfo(JSONArray r8, int r9) throws JSONException {
        JSONArray r0 = new JSONArray();
        int r1 = 0;
    L4:
        if (r1 >= r8.length()) goto L16;
        JSONObject r2 = r8.getJSONObject(r1);
        if (r2.getLong(PerfConsts.PERF_DISK_FILE_SIZE) < r9) goto L15;
        JSONArray r4 = r2.optJSONArray("next_disk");
        if (r4 == null) goto L14;
        JSONArray r5 = tailorDiskInfo(r4, r9);
        if (r5.length() <= 0) goto L13;
        r2.put("next_disk", r5);
        goto L14
    L13:
        r2.remove("next_disk");
    L14:
        r0.put(r2);
    L15:
        r1 = r1 + 1;
        goto L4
    L16:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject createRootJSONObject() {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = this.topUsage;     // Catch: Exception -> L20
        if (r1 == null) goto L6;
        r0.put("top_usage", r1);     // Catch: Exception -> L20
    L6:
        JSONArray r2 = this.exceptionFolder;     // Catch: Exception -> L20
        if (r2 == null) goto L9;
        r0.put("exception_folders", r2);     // Catch: Exception -> L20
    L9:
        JSONArray r3 = this.outDateList;     // Catch: Exception -> L20
        if (r3 == null) goto L13;
        r0.put("outdated_files", r3);     // Catch: Exception -> L20
    L13:
        if (this.diskInfo == null) goto L19;
        int r4 = r0.toString().getBytes("UTF-8").length;     // Catch: Exception -> L16
    L18:
        this.maxRoomOfJsonObject = (262144 - r4) - 12288;     // Catch: Exception -> L20
        JSONArray r5 = tailorJsonObject(this.diskInfo);     // Catch: Exception -> L20
        this.diskInfo = r5;     // Catch: Exception -> L20
        r0.put("disk_info", r5);     // Catch: Exception -> L20
    L16:
        r4 = 0;
    L19:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
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
    protected JSONObject getFilters() {
        JSONObject r1 = PerfFilterManager.getInstance().getPerfFiltersJson();
        JsonUtils.copyJson2(r1, PerfFilterManager.getInstance().getRealTimeMemInfo());     // Catch: Exception -> L5
    L4:
        return r1;
    }
}
