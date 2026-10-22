package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.SocketState;

/* JADX INFO: loaded from: classes.dex */
class ReceiveConnectionActionParse extends BaseIntentParse {
    public ReceiveConnectionActionParse(ClientMsgParser.ParserListener r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r5, ClientServiceTrace r6) {
        r5.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState r7 = (SocketState) r5.getParcelableExtra(WsConstants.KEY_CONNECTION);
        ConnectionState r8 = syncConnectState(r7.getChannelId(), r7.getConnectionState(), r7.isPrivateProtocolEnabled());     // Catch: Throwable -> L5
        this.mListener.onReceiveConnectEvent(new ConnectEvent(r8, r7.getChannelType(), r7.getChannelId(), r7.getErrorCode()), r7.toJson());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
