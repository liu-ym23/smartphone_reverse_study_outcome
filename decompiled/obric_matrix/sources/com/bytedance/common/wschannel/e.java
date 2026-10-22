package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.bytedance.common.wschannel.client.c.a {
    public e() {
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(WsChannelMsg r1, boolean r2) {
        k r0 = n.f(r1.c());
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void b(com.bytedance.common.wschannel.r.b r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        k r0 = n.f(r1.f3662d);
        if (r0 == null) goto L8;
        r0.b(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void c(WsChannelMsg r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        k r0 = n.f(r1.c());
        if (r0 == null) goto L8;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void d(ServiceConnectEvent r1) {
        k r0 = n.f(r1.c());
        if (r0 == null) goto L6;
        r0.j(r1);
        r0.g(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void e(int r1, com.bytedance.common.wschannel.r.c r2, boolean r3) {
        k r0 = n.f(r1);
        if (r0 == null) goto L6;
        r0.k(r2, r3);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void f(String r1, boolean r2) {
    }
}
