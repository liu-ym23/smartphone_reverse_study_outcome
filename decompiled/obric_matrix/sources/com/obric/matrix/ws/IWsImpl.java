package com.obric.matrix.ws;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.obric.matrix.w.b0;
import com.obric.matrix.ws.k.n;
import com.obric.matrix.ws_api.IWs;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J-\u0010\u000f\u001a\u00020\u00042#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J-\u0010\u0018\u001a\u00020\u00042#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J.\u0010\u001c\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dH\u0016J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017J \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017J \u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017J \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0017J \u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017¨\u0006)"}, d2 = {"Lcom/obric/matrix/ws/IWsImpl;", "Lcom/obric/matrix/ws_api/IWs;", "()V", "init", "", "context", "Landroid/content/Context;", "isConnected", "", "onPondReceive", "heartbeatCount", "", "registerListener", "listener", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "registerWsMsgReceivedListener", "Lkotlin/Function1;", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "Lkotlin/ParameterName;", "name", "wsChannelMsg", "registerWsStatusChangeListener", "Lcom/obric/matrix/ws_api/IWsStatusChangeListener;", "removeListener", "removeWsMsgReceivedListener", "removeWsMsgReceivedListenerAll", "removeWsStatusChangeListener", "removeWsStatusChangeListenerAll", "sendWsMessage", "Lkotlin/Function2;", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "subscribeWsMsg", "subscribeWsMsgByBroadCast", "subscribeWsMsgByCallBack", "subscribeWsMsgByProvider", "subscribeWsWsStatus", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IWsImpl implements IWs {
    public IWsImpl() {
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void init(Context r1) {
        o.f(r1, "context");
        h.f10618a.r(r1);
        n.a().m(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public boolean isConnected() {
        return h.f10618a.t();
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void onPondReceive(long r1) {
        com.obric.matrix.ws.k.j.f10665a.l0(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void registerListener(com.obric.matrix.ws_api.a r1) {
        o.f(r1, "listener");
        n.a().registerListener(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void registerWsMsgReceivedListener(l<? super WsChannelMsg, f0> r1) {
        o.f(r1, "listener");
        h.f10618a.D(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void registerWsStatusChangeListener(com.obric.matrix.ws_api.b r1) {
        o.f(r1, "listener");
        h.f10618a.E(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void removeListener(com.obric.matrix.ws_api.a r1) {
        o.f(r1, "listener");
        n.a().n(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void removeWsMsgReceivedListener(l<? super WsChannelMsg, f0> r1) {
        o.f(r1, "listener");
        h.f10618a.F(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void removeWsMsgReceivedListenerAll() {
        h.f10618a.G();
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void removeWsStatusChangeListener(com.obric.matrix.ws_api.b r1) {
        o.f(r1, "listener");
        h.f10618a.H(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void removeWsStatusChangeListenerAll() {
        h.f10618a.I();
    }

    @Override // com.obric.matrix.ws_api.IWs
    public f.a.a<com.obric.matrix.u.b> sendWsMessage(b0 r1, com.obric.matrix.platform.e.b r2) {
        o.f(r1, "request");
        return h.f10618a.K(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public void sendWsMessage(WsChannelMsg r1, p<? super Boolean, ? super WsChannelMsg, f0> r2) {
        h.f10618a.B(r1, r2);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public f.a.a<com.obric.matrix.u.b> subscribeWsMsg(b0 r1, com.obric.matrix.platform.e.b r2) {
        o.f(r1, "request");
        return h.f10618a.N(r1, r2);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public f.a.a<com.obric.matrix.u.b> subscribeWsMsgByBroadCast(b0 r1, com.obric.matrix.platform.e.b r2) {
        o.f(r1, "request");
        return h.f10618a.P(r1, r2);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public f.a.a<com.obric.matrix.u.b> subscribeWsMsgByCallBack(b0 r1, com.obric.matrix.platform.e.b r2) {
        o.f(r1, "request");
        return h.f10618a.R(r1, r2);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public f.a.a<com.obric.matrix.u.b> subscribeWsMsgByProvider(b0 r1) {
        o.f(r1, "request");
        return h.f10618a.T(r1);
    }

    @Override // com.obric.matrix.ws_api.IWs
    public f.a.a<com.obric.matrix.u.b> subscribeWsWsStatus(b0 r1, com.obric.matrix.platform.e.b r2) {
        o.f(r1, "request");
        return h.f10618a.W(r1, r2);
    }
}
