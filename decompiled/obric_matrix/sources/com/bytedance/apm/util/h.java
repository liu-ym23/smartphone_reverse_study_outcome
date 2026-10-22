package com.bytedance.apm.util;

import androidx.annotation.Nullable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static void a(JSONObject r3, JSONObject r4) {
        if (r3 == null) goto L19;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() <= 0) goto L21;
        Iterator<String> r0 = r4.keys();     // Catch: JSONException -> L12
    L9:
        if (r0.hasNext() == false) goto L22;
        String r1 = r0.next();     // Catch: JSONException -> L12
        r3.put(r1, r4.get(r1));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    public static JSONObject b(JSONObject r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r2.toString());
    L7:
        return r2;
    }

    public static boolean c(JSONObject r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean d(JSONObject r0, String r1, String r2, boolean r3) {
        if (r0 != null) goto L4;
        return r3;
    L4:
        JSONObject r4 = r0.optJSONObject(r1);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4.optBoolean(r2, r3);
    }

    public static int e(JSONObject r0, String r1, String r2, String r3) {
        JSONObject r4 = f(r0, r1, r2);
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.optInt(r3, 0);
    }

    @Nullable
    public static JSONObject f(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }

    public static JSONObject g(JSONObject r4) {
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

    public static JSONArray h(JSONArray r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r0 = r5.length();
        if (r0 != 0) goto L21;
        return r5;
    L21:
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L20
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L19;
        Object r3 = r5.get(r2);     // Catch: Throwable -> L20
        if ((r3 instanceof JSONObject) == false) goto L15;
        r3 = i((JSONObject) r3);     // Catch: Throwable -> L20
    L13:
        r1.put(r3);     // Catch: Throwable -> L20
        r2 = r2 + 1;
        goto L9
    L15:
        if ((r3 instanceof JSONArray) == false) goto L13;
        r3 = h((JSONArray) r3);     // Catch: Throwable -> L20
    L19:
        return r5;
    }

    public static JSONObject i(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r0 = r5.keys();
        if (r0 != null) goto L21;
        return r5;
    L21:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L20
    L9:
        if (r0.hasNext() == false) goto L19;
        String r2 = r0.next();     // Catch: Throwable -> L20
        Object r3 = r5.opt(r2);     // Catch: Throwable -> L20
        if ((r3 instanceof JSONObject) == false) goto L16;
        r3 = i((JSONObject) r3);     // Catch: Throwable -> L20
    L14:
        r1.put(r2, r3);     // Catch: Throwable -> L20
        goto L9
    L16:
        if ((r3 instanceof JSONArray) == false) goto L14;
        r3 = h((JSONArray) r3);     // Catch: Throwable -> L20
        goto L14
    L19:
        return r1;
    L20:
        return r5;
    }
}
