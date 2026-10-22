package com.bytedance.apm.util;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MapUtils {
    public MapUtils() {
    }

    public static JSONObject mapToJson(Map<String, Object> r1) {
        JSONObject r0 = new JSONObject(r1);
        r0.put("", "");
        return r0;
    }
}
