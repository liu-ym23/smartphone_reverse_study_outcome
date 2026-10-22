package com.obric.matrix.account.l;

import com.obric.matrix.r.c.c;
import com.obric.matrix.r.c.e;
import d.b.s.a.l0.h;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements h {
    public a() {
    }

    @Override // d.b.s.a.l0.h
    public void a(long r1, String r3) {
        c.f("MonitorAdapter", "MonitorAdapter.setAppLogInfo");
    }

    @Override // d.b.s.a.l0.h
    public String getDeviceId() {
        return "";
    }

    @Override // d.b.s.a.l0.h
    public void onEvent(String r3, JSONObject r4) {
        c.b("onEvent", "MonitorAdapter.onEvent event=" + r3);
        if (Objects.equals(r3, "passport_net_err") == false) goto L5;
    L6:
        e.d("onEvent", "MonitorAdapter.onEvent event=" + r3 + " params=" + r4);
        com.obric.matrix.dataanalysis.h.f9059i.a().u(r3, r4);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        c.g("MonitorAdapter", "MonitorAdapter.onEvent reportEvent error", e);
        return;
    L5:
        if (Objects.equals(r3, "passport_net_request_result") == true) goto L6;
    }
}
