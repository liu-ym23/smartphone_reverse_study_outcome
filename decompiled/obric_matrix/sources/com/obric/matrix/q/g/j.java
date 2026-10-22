package com.obric.matrix.q.g;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static byte[] a(boolean r2, String r3, String r4, String r5, byte[] r6) {
        Log.d("TTNetSignInterceptorForNative", "getSignHeaders() called with: is_get = [" + r2 + "], app_id = [" + r3 + "], access_token = [" + r4 + "], url = [" + r5 + "], body_bytes = [" + r6 + "]");
        if (r2 == false) goto L5;
        r6 = r5.substring(r5.indexOf(63) + 1).getBytes();
    L5:
        i r7 = new i();
        String r8 = com.obric.matrix.base.settings.iconfig.a.b().c();
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        List<d.b.r.h0.b> r9 = r7.d(new ArrayList(), r7.m("auth-v2", r3, r8, r6), r4);
        final JSONObject r10 = new JSONObject();
        if (r9 != null) goto L14;
        String r11 = "headers == null";
    L12:
        Log.d("TTNetSignInterceptorForNative", r11);
        return null;
    L14:
        r9.forEach(new d(r10));
        Log.d("TTNetSignInterceptorForNative", "return headers: " + r10);
        return r10.get("Agw-Auth").toString().getBytes();
    L17:
        e = move-exception;
        r11 = "getSignHeaders JSONException: " + e;
        goto L12
    }

    static /* synthetic */ void b(JSONObject r1, d.b.r.h0.b r2) {
        r1.put(r2.a(), r2.b());     // Catch: JSONException -> L4
        return;
    }
}
