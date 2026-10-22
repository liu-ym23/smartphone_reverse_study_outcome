package com.obric.matrix.r.d;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends d {
    public c(@NonNull String r1) {
        super(r1);
    }

    @Override // com.obric.matrix.r.d.d
    protected void k(@NonNull Context r6) {
        JSONObject r1 = new JSONObject();
        r1.put("event_name", d());     // Catch: Exception -> L5
        r1.put("client_timestamp", c());     // Catch: Exception -> L5
        r1.put("log_type", "flexible");     // Catch: Exception -> L5
        r1.put("category", new JSONObject(b()));     // Catch: Exception -> L5
        r1.put("metrics", new JSONObject(f()));     // Catch: Exception -> L5
        r1.put(WsConstants.KEY_EXTRA, new JSONObject(e()));     // Catch: Exception -> L5
    L7:
        Intent r2 = new Intent("com.slardaros.metricevent.action");
        r2.setPackage("com.bytedance.os.mermaid");
        r2.putExtra("code", 0);
        r2.putExtra("event_name", d());
        r2.putExtra("json_string", r1.toString());
        r6.sendBroadcast(r2, "com.slardaros.METRIC_EVENT_PERMISSION");
        return;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.g("OApmCustomEvent", "realReportCustomEvent failed: ", e);
        goto L7
    }
}
