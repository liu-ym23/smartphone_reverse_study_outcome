package com.monitor.cloudmessage.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    public StringUtils() {
    }

    public static JSONObject getJsonFromMap(Map<String, List<String>> r3) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L16;
    L15:
        return r0;
    L16:
        Iterator<Map.Entry<String, List<String>>> r4 = r3.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r4.hasNext() == false) goto L15;
        Map.Entry<String, List<String>> r1 = r4.next();     // Catch: JSONException -> L10
        if (r1.getKey() == null) goto L9;
        r0.put(r1.getKey().toString(), r1.getValue());     // Catch: JSONException -> L10
        goto L5
    L9:
        r0.put("Response", r1.getValue());     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static String getJsonString(HashMap<String, String> r4) {
        JSONObject r0 = new JSONObject();
        if (r4 == null) goto L12;
        Iterator<String> r1 = r4.keySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();     // Catch: JSONException -> L9
        r0.put(r2, r4.get(r2));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r0.toString();
    }
}
