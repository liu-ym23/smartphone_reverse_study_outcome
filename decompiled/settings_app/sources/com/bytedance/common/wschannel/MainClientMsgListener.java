package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MainClientMsgListener implements ClientMsgParser.ParserListener {
    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String r1, boolean r2) {
    }

    public MainClientMsgListener() {
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        WsChannelImpl r0 = WsChannelSdk2.getChannel(r1.getChannelId());
        if (r0 == null) goto L8;
        r0.onReceive(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveConnectEvent(ConnectEvent r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        WsChannelImpl r0 = WsChannelSdk2.getChannel(r1.mChannelId);
        if (r0 == null) goto L8;
        r0.onReceiveConnectEvent(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveServiceEvent(ServiceConnectEvent r1) {
        WsChannelImpl r0 = WsChannelSdk2.getChannel(r1.getChannelId());
        if (r0 == null) goto L6;
        r0.syncServiceState(r1);
        r0.onReceiveServiceConnectEvent(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void syncState(int r1, ConnectionState r2, boolean r3) {
        WsChannelImpl r0 = WsChannelSdk2.getChannel(r1);
        if (r0 == null) goto L6;
        r0.syncState(r2, r3);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void replySendMsgResult(WsChannelMsg r1, boolean r2) {
        WsChannelImpl r0 = WsChannelSdk2.getChannel(r1.getChannelId());
        if (r0 == null) goto L6;
        r0.replySendMsgResult(r1, r2);
        return;
    }
}
