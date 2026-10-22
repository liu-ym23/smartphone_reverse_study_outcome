package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsClientService extends a {
    public WsClientService() {
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(WsChannelMsg r1, boolean r2) {
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void b(com.bytedance.common.wschannel.r.b r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        com.bytedance.common.wschannel.app.d r0 = WsConstants.getListener(r1.f3662d);
        if (r0 == null) goto L8;
        r0.b(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void c(WsChannelMsg r8) {
        if (r8 == null) goto L21;
        com.bytedance.common.wschannel.app.d r7 = WsConstants.getListener(r8.c());     // Catch: Throwable -> L14
        if (r7 != null) goto L6;
    L8:
        com.bytedance.common.wschannel.app.c r9 = WsConstants.getMessageAckListener();     // Catch: Throwable -> L14
        if (r9 != null) goto L11;
    L17:
        return;
    L11:
        if (r8.x() == false) goto L17;
        com.bytedance.common.wschannel.r.d r0 = new com.bytedance.common.wschannel.r.d(r8.w(), r8.c(), r8.s(), r8.f(), r8.e());     // Catch: Throwable -> L14
        r0.a(r8.v());     // Catch: Throwable -> L14
        r9.a(r0);     // Catch: Throwable -> L14
        goto L17
    L6:
        if (r8.x() == true) goto L8;
        r7.c(r8);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Logger.e(th.toString());
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void d(ServiceConnectEvent r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        WsConstants.setServiceState(r1);
        com.bytedance.common.wschannel.app.e r0 = WsConstants.getServiceConnectListener();
        if (r0 == null) goto L8;
        r0.b(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void e(int r1, com.bytedance.common.wschannel.r.c r2, boolean r3) {
        WsConstants.setConnectionState(r1, r2, r3);
    }

    @Override // com.bytedance.common.wschannel.client.a, com.bytedance.common.wschannel.client.c.a
    public void f(String r1, boolean r2) {
        super.f(r1, r2);
    }
}
