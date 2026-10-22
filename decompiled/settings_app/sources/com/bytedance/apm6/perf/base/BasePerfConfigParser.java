package com.bytedance.apm6.perf.base;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BasePerfConfigParser {
    private static final String PERF_KEY = "performance_modules";

    public BasePerfConfigParser() {
    }

    public static JSONObject parseData(JSONObject r2, String r3) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.optJSONObject("performance_modules").optJSONObject(r3);
    L7:
        return null;
    }
}
