package com.bytedance.common.wschannel.client;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public class ReceivePayloadParse extends BaseIntentParse {
    public ReceivePayloadParse(@NonNull ClientMsgParser.ParserListener r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r5, @Nullable ClientServiceTrace r6) {
        r5.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        WsChannelMsg r7 = (WsChannelMsg) r5.getParcelableExtra(WsConstants.KEY_PAYLOAD);
        if (WsConstants.getOptLogic().get().booleanValue() == true) goto L9;
        Message r2 = new Message();
        r2.getData().putParcelable(WsConstants.KEY_PAYLOAD, r7);
        r2.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
        Parcelable r8 = r2.getData().getParcelable(WsConstants.KEY_PAYLOAD);
        if ((r8 instanceof WsChannelMsg) == false) goto L8;
        r7 = (WsChannelMsg) r8;
        goto L9
    L8:
        r7 = null;
    L9:
        if (r7 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(AbsWsClientService.TAG, "get wsChannelMsg = " + r7.toString());
    L13:
        if (r6 == null) goto L15;
        r7.receiveDataFromIpcTs = r6.onReceiveDataFromIpcTs;
    L15:
        this.mListener.onReceive(r7);
    }
}
