package com.bytedance.bdturing.u;

import com.bytedance.bdturing.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f3172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f3173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b f3174d;

    c(b r2, String r3) {
        this.f3171a = null;
        this.f3172b = null;
        this.f3173c = null;
        this.f3174d = r2;
        a(r3);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        g.e(e);
    }

    private void a(String r2) {
        JSONObject r0 = new JSONObject(r2);
        r0.getInt("JSSDK");
        this.f3171a = r0.getString("func");
        this.f3172b = r0.getString("params");
        r0.getString("__msg_type");
        this.f3173c = r0.getString("__callback_id");
    }

    public static String b(int r2, String r3, String r4, JSONObject r5, String r6) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("code", r2);     // Catch: JSONException -> L4
        r0.put("func", r3);     // Catch: JSONException -> L4
        r0.put("__msg_type", r4);     // Catch: JSONException -> L4
        r0.put("data", r5);     // Catch: JSONException -> L4
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L4
        r7.put("__params", r0);     // Catch: JSONException -> L4
        r7.put("__callback_id", r6);     // Catch: JSONException -> L4
        return r7.toString();
    L4:
        e = move-exception;
        g.e(e);
        return null;
    }

    public static JSONObject c(int r2, String r3, JSONObject r4, c r5) {
        JSONObject r0 = new JSONObject();
        r0.put("code", r2);
        r0.put("func", r5.f3171a);
        r0.put("__msg_type", r3);
        Object r6 = r4;
        if (r4 != null) goto L5;
        r6 = "{}";
    L5:
        r0.put("data", r6);
        JSONObject r7 = new JSONObject();
        r7.put("__params", r0);
        r7.put("__callback_id", r5.f3173c);
        return r7;
    }

    public void d(int r3, JSONObject r4) {
        b r0 = this.f3174d;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.c(c(r3, "callback", r4, this).toString());     // Catch: JSONException -> L7
        return;
    }
}
