package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.SocketState;

/* JADX INFO: loaded from: classes3.dex */
class ReceiveConnectionActionParse extends BaseIntentParse {
    public ReceiveConnectionActionParse(ClientMsgParser.ParserListener r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r4, ClientServiceTrace r5) {
        r4.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState r6 = (SocketState) r4.getParcelableExtra(WsConstants.KEY_CONNECTION);
        ConnectionState r7 = syncConnectState(r6.getChannelId(), r6.getConnectionState(), r6.isPrivateProtocolEnabled());     // Catch: Throwable -> L5
        this.mListener.onReceiveConnectEvent(new ConnectEvent(r7, r6.getChannelType(), r6.getChannelId()), r6.toJson());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
