package com.bytedance.common.utility;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonUtils {
    private JsonUtils() {
    }

    public static void optPut(JSONObject r1, String r2, Object r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static int queryInt(JSONObject r1, String r2, int r3) {
        if (r1 != null) goto L4;
    L10:
        return r3;
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L10;
        if (r1.has(r2) == false) goto L10;
        return r1.optInt(r2, r3);
    }

    public static String queryString(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
    L10:
        return r3;
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L10;
        if (r1.has(r2) == false) goto L10;
        return r1.optString(r2, r3);
    }

    public static long queryLong(JSONObject r1, String r2, long r3) {
        if (r1 != null) goto L4;
    L10:
        return r3;
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L10;
        if (r1.has(r2) == false) goto L10;
        return r1.optLong(r2, r3);
    }

    public static boolean queryBoolean(JSONObject r1, String r2, boolean r3) {
        if (r1 != null) goto L4;
    L10:
        return r3;
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L10;
        if (r1.has(r2) == false) goto L10;
        return r1.optBoolean(r2, r3);
    }
}
