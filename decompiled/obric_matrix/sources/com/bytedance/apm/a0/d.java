package com.bytedance.apm.a0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f1132a;

    private d() {
    }

    public static d b() {
        if (f1132a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1132a != null) goto L9;
        f1132a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f1132a;
    }

    public JSONObject a() {
        JSONObject r4 = new JSONObject();
        d.b.b.n.h.a r0 = (d.b.b.n.h.a) d.b.b.n.c.a(d.b.b.n.h.a.class);     // Catch: JSONException -> L5
        r4.put("process_usage", r0.a());     // Catch: JSONException -> L5
        r4.put("stat_speed", r0.b());     // Catch: JSONException -> L5
        return r4;
    L6:
        return new JSONObject();
    }
}
