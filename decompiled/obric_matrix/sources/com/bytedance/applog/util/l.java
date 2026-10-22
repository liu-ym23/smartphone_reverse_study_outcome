package com.bytedance.applog.util;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static JSONObject a(JSONObject r4) {
        if (r4 == null) goto L17;
        JSONObject r2 = new JSONObject();
        p.c(r2, r4);
        JSONObject r5 = r2.optJSONObject("oaid");     // Catch: Exception -> L11
        if (r5 == null) goto L14;
        String r6 = r5.optString("id", null);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r2.put("oaid", r6);     // Catch: Exception -> L11
    L14:
        return r2;
    L11:
        e = move-exception;
        n.i(e);
        goto L14
    L17:
        return null;
    }
}
