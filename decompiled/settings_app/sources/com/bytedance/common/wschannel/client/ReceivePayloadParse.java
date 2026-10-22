package com.bytedance.common.wschannel.client;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
public class ReceivePayloadParse extends BaseIntentParse {
    public ReceivePayloadParse(ClientMsgParser.ParserListener r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r4, ClientServiceTrace r5) {
        r4.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        WsChannelMsg r6 = (WsChannelMsg) r4.getParcelableExtra("payload");
        if (WsConstants.getOptLogic().get().booleanValue() == true) goto L9;
        Message r1 = new Message();
        r1.getData().putParcelable("payload", r6);
        r1.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
        Parcelable r7 = r1.getData().getParcelable("payload");
        if ((r7 instanceof WsChannelMsg) == false) goto L8;
        r6 = (WsChannelMsg) r7;
        goto L9
    L8:
        r6 = null;
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(AbsWsClientService.TAG, "get wsChannelMsg = " + r6.toString());
    L13:
        if (r5 == null) goto L15;
        r6.receiveDataFromIpcTs = r5.onReceiveDataFromIpcTs;
    L15:
        this.mListener.onReceive(r6);
    }
}
