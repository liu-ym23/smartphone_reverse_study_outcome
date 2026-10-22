package com.bytedance.common.wschannel.channel;

import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    void a(WsChannelMsg r1, boolean r2);

    void b(ServiceConnectEvent r1);

    void c();

    void d(IWsChannelClient r1, int r2, JSONObject r3);

    void e();

    void f(int r1, byte[] r2);

    void g(int r1, WsChannelMsg r2);

    void h(IWsChannelClient r1, SocketState r2);
}
