package com.bytedance.ttnet;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a(String r2, JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        b(r2, r3, Integer.MAX_VALUE, null);
    }

    public static void b(String r3, JSONObject r4, int r5, String r6) {
        e r0 = TTNetInit.getTTNetDepend();     // Catch: Throwable -> L12
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L12
        r1.put("module_type", r3);     // Catch: Throwable -> L12
        if (r5 == Integer.MAX_VALUE) goto L6;
        r1.put("code", r5);     // Catch: Throwable -> L12
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L8;
        r1.put("message", r6);     // Catch: Throwable -> L12
    L8:
        if (r4 == null) goto L10;
        r1.put("detail_log", r4);     // Catch: Throwable -> L12
    L10:
        Logger.debug();     // Catch: Throwable -> L12
        r0.c("ttnet_all_log", r1);     // Catch: Throwable -> L12
        return;
    }
}
