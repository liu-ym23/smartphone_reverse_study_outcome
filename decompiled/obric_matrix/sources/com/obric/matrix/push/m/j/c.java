package com.obric.matrix.push.m.j;

import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/push/base/monitor/PushMonitorService;", "Lcom/obric/matrix/push/base/monitor/IPushMonitorService;", "()V", "monitorEvent", "", "service", "", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c implements a {
    public c() {
    }

    @Override // com.obric.matrix.push.m.j.a
    public void monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        o.f(r2, "service");
        com.obric.matrix.push.n.c.c.h("[monitor] service = " + r2 + ", category = " + r3);     // Catch: Throwable -> L5
        com.obric.matrix.q.f.a.f9854a.a(r2, r3, r4, r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d("PushMonitorService", "monitorEvent error:", th);
    }
}
