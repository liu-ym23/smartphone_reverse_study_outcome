package com.bytedance.bdinstall.z0;

import com.bytedance.bdlocation.client.LocationInfoConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class o {
    o() {
    }

    void a(JSONObject r3) {
        boolean r2 = com.bytedance.bdinstall.d1.l.u();
        if (r2 == false) goto L6;
        Object r1 = "Harmony";
    L21:
        r3.put("os", r1);     // Catch: JSONException -> L9
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        JSONObject r4 = new JSONObject();
        r4.put("os_api", com.bytedance.bdinstall.d1.q.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L20
        r4.put("os_version", com.bytedance.bdinstall.d1.q.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L20
        r4.put("release_type", com.bytedance.bdinstall.d1.q.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L20
    L23:
        r3.put("harmony", r4);     // Catch: JSONException -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L6:
        r1 = LocationInfoConst.SYSTEM;
        goto L21
    }
}
