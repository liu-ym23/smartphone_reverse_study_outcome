package com.bytedance.apm6.util;

import com.bytedance.apm6.util.log.Logger;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public JsonUtils() {
    }

    public static JSONObject copyJson2(JSONObject r3, JSONObject r4) throws JSONException {
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L10;
        return null;
    L10:
        if (r1.hasNext() == false) goto L14;
        String r0 = r1.next();
        if (r4.isNull(r0) == true) goto L10;
        r3.put(r0, r4.opt(r0));
        goto L10
    L14:
        return r3;
    L15:
        return null;
    }

    public static boolean isEmpty(JSONObject r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean hasData(JSONObject r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static boolean hasData(JSONArray r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static JSONObject optJSONObject(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }

    public static JSONObject optJSONObject(JSONObject r0, String r1, String r2, String r3) {
        JSONObject r4 = optJSONObject(r0, r1, r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.optJSONObject(r3);
    }

    public static int optInt(JSONObject r0, String r1, String r2, String r3) {
        JSONObject r4 = optJSONObject(r0, r1, r2);
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.optInt(r3, 0);
    }

    public static int optInt(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.optInt(r3, 0);
    }

    public static boolean optBoolean(JSONObject r0, String r1, String r2, boolean r3) {
        if (r0 != null) goto L4;
        return r3;
    L4:
        JSONObject r4 = r0.optJSONObject(r1);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4.optBoolean(r2, r3);
    }

    public static String removeString(JSONObject r2, String r3) {
    L8:
        e = move-exception;
        Logger.e(TAG, "removeString", e);
        return null;
    L4:
        if (r2.has(r3) == true) goto L6;
        return null;
    L6:
        String r1 = r2.getString(r3);     // Catch: Exception -> L8
        r2.remove(r3);     // Catch: Exception -> L8
        return r1;
    }

    public static int removeInt(JSONObject r2, String r3) {
    L8:
        e = move-exception;
        Logger.e(TAG, "removeInt", e);
        return 0;
    L4:
        if (r2.has(r3) == true) goto L6;
        return 0;
    L6:
        int r1 = r2.getInt(r3);     // Catch: Exception -> L8
        r2.remove(r3);     // Catch: Exception -> L8
        return r1;
    }

    public static long removeLong(JSONObject r4, String r5) {
    L8:
        e = move-exception;
        Logger.e(TAG, "removeLong", e);
        return 0;
    L4:
        if (r4.has(r5) == true) goto L6;
        return 0;
    L6:
        long r2 = r4.getLong(r5);     // Catch: Exception -> L8
        r4.remove(r5);     // Catch: Exception -> L8
        return r2;
    }

    public static JSONObject safeCopyJson(JSONObject r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r7.keys();
        if (r1 != null) goto L27;
        return null;
    L27:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L26
    L9:
        if (r1.hasNext() == false) goto L25;
        String r2 = r1.next();     // Catch: Exception -> L26
        Object r3 = r7.opt(r2);     // Catch: Exception -> L26
        if ((r3 instanceof JSONObject) == true) goto L13;
        if ((r3 instanceof JSONArray) == true) goto L18;
        r0.put(r2, r3);     // Catch: Exception -> L26
        goto L9
    L18:
        JSONArray r4 = (JSONArray) r3;     // Catch: Exception -> L26
        JSONArray r5 = new JSONArray();     // Catch: Exception -> L26
        int r6 = 0;
    L20:
        if (r6 >= r4.length()) goto L22;
        r5.put(r4.get(r6));     // Catch: Exception -> L26
        r6 = r6 + 1;     // Catch: Exception -> L26
        goto L20
    L22:
        r0.put(r2, r5);     // Catch: Exception -> L26
        goto L9
    L13:
        JSONObject r8 = safeCopyJson2((JSONObject) r3);     // Catch: Exception -> L26
        if (r8 == null) goto L9;
        r0.put(r2, r8);     // Catch: Exception -> L26
        goto L9
    L25:
        return r0;
    L26:
        return r7;
    }

    private static JSONObject safeCopyJson2(JSONObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L15;
        return null;
    L15:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L14
    L10:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();     // Catch: Exception -> L14
        r0.put(r2, r4.opt(r2));     // Catch: Exception -> L14
        goto L10
    L13:
        return r0;
    L14:
        return r4;
    }
}
