package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsClientService extends AbsWsClientService {
    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void replySendMsgResult(WsChannelMsg r1, boolean r2) {
    }

    public WsClientService() {
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg r8) {
        if (r8 == null) goto L21;
        OnMessageReceiveListener r7 = WsConstants.getListener(r8.getChannelId());     // Catch: Throwable -> L14
        if (r7 != null) goto L6;
    L8:
        OnMessageAckListener r9 = WsConstants.getMessageAckListener();     // Catch: Throwable -> L14
        if (r9 != null) goto L11;
    L17:
        return;
    L11:
        if (r8.isAckMsg() == false) goto L17;
        MessageAckEvent r0 = new MessageAckEvent(r8.getUUID(), r8.getChannelId(), r8.getService(), r8.getMethod(), r8.getLogInfo());     // Catch: Throwable -> L14
        r0.setState(r8.getState());     // Catch: Throwable -> L14
        r9.onReceiveMsgAck(r0);     // Catch: Throwable -> L14
        goto L17
    L6:
        if (r8.isAckMsg() == true) goto L8;
        r7.onReceiveMsg(r8);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Logger.e(th.toString());
        return;
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String r1, boolean r2) {
        super.onSendResult(r1, r2);
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveConnectEvent(ConnectEvent r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        OnMessageReceiveListener r0 = WsConstants.getListener(r1.mChannelId);
        if (r0 == null) goto L8;
        r0.onReceiveConnectEvent(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceiveServiceEvent(ServiceConnectEvent r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        WsConstants.setServiceState(r1);
        OnServiceConnectListener r0 = WsConstants.getServiceConnectListener();
        if (r0 == null) goto L8;
        r0.onServiceConnectEvent(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void syncState(int r1, ConnectionState r2, boolean r3) {
        WsConstants.setConnectionState(r1, r2, r3);
    }
}
