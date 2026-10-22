package com.obric.matrix.ws;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.ws_api.IWsDebug;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/matrix/ws/IWsDebugImpl;", "Lcom/obric/matrix/ws_api/IWsDebug;", "()V", "clearWsMsgSubscriberIPCCallback", "", "generateWsMsg", "service", "", "method", WsConstants.KEY_PAYLOAD, "", "getSubscriber", "", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IWsDebugImpl implements IWsDebug {
    public IWsDebugImpl() {
    }

    @Override // com.obric.matrix.ws_api.IWsDebug
    public void clearWsMsgSubscriberIPCCallback() {
        h.f10618a.k();
    }

    @Override // com.obric.matrix.ws_api.IWsDebug
    public void generateWsMsg(int r1, int r2, byte[] r3) {
        o.f(r3, WsConstants.KEY_PAYLOAD);
        h.f10618a.l(r1, r2, r3);
    }

    @Override // com.obric.matrix.ws_api.IWsDebug
    public String getSubscriber() {
        return h.f10618a.p();
    }
}
