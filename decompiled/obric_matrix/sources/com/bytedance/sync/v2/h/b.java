package com.bytedance.sync.v2.h;

import com.bytedance.common.wschannel.WsConstants;
import d.b.u.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f5949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5950f;

    public b(boolean r1, f.a r2) {
        this.f5949e = r1;
        if (r2 == null) goto L5;
        int r3 = r2.e();
    L6:
        this.f5950f = r3;
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.sync.v2.h.f
    public void a() {
        JSONObject r0 = new JSONObject();
        d.b.u.d0.a.a(r0, "send_method", this.f5965a);
        d.b.u.d0.a.a(r0, WsConstants.KEY_SEND_RESULT, this.f5966b);
        d.b.u.d0.a.d(r0, "is_foreground", this.f5949e);
        d.b.u.d0.a.a(r0, "strategy", this.f5950f);
        d.b.u.d0.a.a(r0, "send_msg_type", this.f5967c);
        d.b.u.d0.a.a(r0, "ws_connect", this.f5968d);
        r.c("sync_sdk_compensator_net_monitor", r0, null, null);
    }
}
