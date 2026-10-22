package com.bytedance.android.standard.tools.json;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JSONUtils {
    private JSONUtils() {
    }

    public static long optLong(JSONObject r2, String r3) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        Object r4 = r2.opt(r3);
        if ((r4 instanceof Long) == false) goto L10;
        return ((Long) r4).longValue();
    L10:
        if ((r4 instanceof Number) == false) goto L14;
        return ((Number) r4).longValue();
    L14:
        if ((r4 instanceof String) == true) goto L20;
    L19:
        return 0;
    L20:
        return Long.parseLong((String) r4);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static boolean optBoolean(JSONObject r2, String r3, boolean r4) {
        if (r2 != null) goto L4;
    L14:
        return r4;
    L4:
        if (r2.isNull(r3) == true) goto L14;
        int r0 = r2.optInt(r3, -1);
        if (r0 < 1) goto L9;
        return true;
    L9:
        if (r0 != 0) goto L13;
        return false;
    L13:
        return r2.optBoolean(r3, r4);
    }

    public static JSONObject mergeJsonObject(JSONObject r5, JSONObject r6) {
        if (r5 != null) goto L6;
        if (r6 != null) goto L6;
        return null;
    L6:
        JSONObject r1 = new JSONObject();
        if (r5 != null) goto L26;
    L15:
        if (r6 == null) goto L25;
        Iterator<String> r7 = r6.keys();     // Catch: Exception -> L24
    L17:
        if (r7 == null) goto L25;
        if (r7.hasNext() == false) goto L25;
        String r2 = r7.next();     // Catch: Exception -> L24
        if (r1.has(r2) == true) goto L17;
        r1.put(r2, r6.opt(r2));     // Catch: Exception -> L24
    L24:
        return null;
    L25:
        return r1;
    L26:
        Iterator<String> r3 = r5.keys();     // Catch: Exception -> L24
    L9:
        if (r3 == null) goto L15;
        if (r3.hasNext() == false) goto L15;
        String r4 = r3.next();     // Catch: Exception -> L24
        if (r1.has(r4) == true) goto L9;
        r1.put(r4, r5.opt(r4));     // Catch: Exception -> L24
        goto L9
    }

    public static JSONArray parseJsonArray(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return null;
    L10:
        return new JSONArray(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static JSONObject parseJsonObject(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
