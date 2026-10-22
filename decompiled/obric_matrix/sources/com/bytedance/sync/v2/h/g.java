package com.bytedance.sync.v2.h;

import com.bytedance.common.wschannel.WsConstants;
import d.b.u.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {
    public g() {
    }

    @Override // com.bytedance.sync.v2.h.f
    public void a() {
        JSONObject r0 = new JSONObject();
        d.b.u.d0.a.a(r0, "send_method", this.f5965a);
        d.b.u.d0.a.a(r0, WsConstants.KEY_SEND_RESULT, this.f5966b);
        d.b.u.d0.a.a(r0, "send_msg_type", this.f5967c);
        d.b.u.d0.a.a(r0, "ws_connect", this.f5968d);
        r.c("sync_sdk_ws_poll", r0, null, null);
    }
}
