package com.bytedance.tracing.internal;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatchTracingLogWrapUtils {
    private static final String WRAPPER_ARRAY_DATA = "wrapper_array_data";

    public BatchTracingLogWrapUtils() {
    }

    public static JSONArray stripData(JSONObject r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        JSONArray r3 = r2.optJSONArray("wrapper_array_data");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3;
    }

    public static JSONObject wrapData(JSONArray r2) {
        return new JSONObject().put("wrapper_array_data", r2);
    }
}
