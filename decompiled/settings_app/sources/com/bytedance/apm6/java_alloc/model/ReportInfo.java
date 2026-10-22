package com.bytedance.apm6.java_alloc.model;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ReportInfo {
    private static final int MAX_TRACE_SIZE = 128;
    private static final String TAG = "APM-Alloc-ReportInfo";
    public int bytes;
    public String className;
    public int count;
    public int exceptionType;
    private String scene;
    public List<StackTraceElement> tracebacks;

    public ReportInfo(String r1, int r2, int r3, int r4, String r5, List<StackTraceElement> r6) {
        this.className = r1;
        this.count = r2;
        this.bytes = r3;
        this.exceptionType = r4;
        this.scene = r5;
        this.tracebacks = r6;
    }

    public JSONObject packJson(JSONObject r6) {
        JSONObject r1 = new JSONObject();
        r1.put("object_class", this.className);     // Catch: JSONException -> L8
        r1.put("count", this.count);     // Catch: JSONException -> L8
        r1.put(PerfConsts.PERF_DISK_FILE_SIZE, this.bytes);     // Catch: JSONException -> L8
        r1.put("exception_type", this.exceptionType);     // Catch: JSONException -> L8
        String r2 = combineStacks(this.tracebacks);     // Catch: JSONException -> L8
        r1.put("stack", r2);     // Catch: JSONException -> L8
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.i(TAG, "stacks: " + r2);     // Catch: JSONException -> L8
    L6:
        r6.put("alloc_scene", this.scene);     // Catch: JSONException -> L8
        r1.put("filters", r6);     // Catch: JSONException -> L8
        return r1;
    L8:
        return null;
    }

    private static String combineStacks(List<StackTraceElement> r9) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r9.size();
        int r2 = r1 / 2;
        if (r1 <= 128) goto L5;
        int r4 = (r1 - 128) / 2;
        int r5 = r2 - r4;
        int r6 = r2 + (r1 - r4);
        r2 = r5;
    L7:
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.i(TAG, "traceSize: " + r1);
    L9:
        int r7 = 0;
    L11:
        if (r7 >= r2) goto L13;
        r0.append("at ").append(r9.get(r7)).append("\n");
        r7 = r7 + 1;
        goto L11
    L13:
        if (r1 <= 128) goto L15;
        r0.append("... skip ").append(r1 - 128).append(" lines\n");
    L15:
        if (r6 >= r1) goto L18;
        r0.append("at ").append(r9.get(r6)).append("\n");
        r6 = r6 + 1;
        goto L15
    L18:
        return r0.toString();
    L5:
        r6 = r2;
        goto L7
    }
}
