package com.obric.matrix.ws_api;

import com.obric.matrix.q.b.d;
import com.obric.matrix.w.b0;

/* JADX INFO: loaded from: classes2.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f10694a;

    public c() {
    }

    public static d b() {
        if (f10694a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f10694a != null) goto L9;
        f10694a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f10694a;
    }

    @Override // com.obric.matrix.q.b.d
    public f.a.a<com.obric.matrix.u.b> a(int r1, b0 r2, com.obric.matrix.platform.e.b r3) {
        switch(r1) {
            case 101001: goto L17;
            case 101002: goto L15;
            case 101003: goto L13;
            case 101004: goto L11;
            case 101005: goto L9;
            case 101006: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).subscribeWsMsgByBroadCast(r2, r3);
    L9:
        return ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).subscribeWsMsgByCallBack(r2, r3);
    L11:
        return ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).subscribeWsMsgByProvider(r2);
    L13:
        return ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).subscribeWsWsStatus(r2, r3);
    L15:
        return ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).subscribeWsMsg(r2, r3);
    L17:
        return ((IWs) com.bytedance.news.common.service.manager.d.a(IWs.class)).sendWsMessage(r2, r3);
    }
}
