package com.obric.matrix.ws_api;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.news.common.service.manager.IService;
import com.obric.matrix.w.b0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J-\u0010\u000e\u001a\u00020\u00032#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J-\u0010\u0017\u001a\u00020\u00032#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u000fH&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0015H&J\b\u0010\u001a\u001a\u00020\u0003H&J.\u0010\u001b\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001cH&J \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H&J \u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H&J \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H&J \u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H&J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H&J \u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H&¨\u0006("}, d2 = {"Lcom/obric/matrix/ws_api/IWs;", "Lcom/bytedance/news/common/service/manager/IService;", "init", "", "context", "Landroid/content/Context;", "isConnected", "", "onPondReceive", "heartbeatCount", "", "registerListener", "listener", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "registerWsMsgReceivedListener", "Lkotlin/Function1;", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "Lkotlin/ParameterName;", "name", "wsChannelMsg", "registerWsStatusChangeListener", "Lcom/obric/matrix/ws_api/IWsStatusChangeListener;", "removeListener", "removeWsMsgReceivedListener", "removeWsMsgReceivedListenerAll", "removeWsStatusChangeListener", "removeWsStatusChangeListenerAll", "sendWsMessage", "Lkotlin/Function2;", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "subscribeWsMsg", "subscribeWsMsgByBroadCast", "subscribeWsMsgByCallBack", "subscribeWsMsgByProvider", "subscribeWsWsStatus", "ws_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWs extends IService {
    void init(Context r1);

    boolean isConnected();

    void onPondReceive(long r1);

    void registerListener(a r1);

    void registerWsMsgReceivedListener(l<? super WsChannelMsg, f0> r1);

    void registerWsStatusChangeListener(b r1);

    void removeListener(a r1);

    void removeWsMsgReceivedListener(l<? super WsChannelMsg, f0> r1);

    void removeWsMsgReceivedListenerAll();

    void removeWsStatusChangeListener(b r1);

    void removeWsStatusChangeListenerAll();

    f.a.a<com.obric.matrix.u.b> sendWsMessage(b0 r1, com.obric.matrix.platform.e.b r2);

    void sendWsMessage(WsChannelMsg r1, p<? super Boolean, ? super WsChannelMsg, f0> r2);

    f.a.a<com.obric.matrix.u.b> subscribeWsMsg(b0 r1, com.obric.matrix.platform.e.b r2);

    f.a.a<com.obric.matrix.u.b> subscribeWsMsgByBroadCast(b0 r1, com.obric.matrix.platform.e.b r2);

    f.a.a<com.obric.matrix.u.b> subscribeWsMsgByCallBack(b0 r1, com.obric.matrix.platform.e.b r2);

    f.a.a<com.obric.matrix.u.b> subscribeWsMsgByProvider(b0 r1);

    f.a.a<com.obric.matrix.u.b> subscribeWsWsStatus(b0 r1, com.obric.matrix.platform.e.b r2);
}
