package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;

/* JADX INFO: loaded from: classes3.dex */
public class ReceiveServiceActionParse extends BaseIntentParse {
    public ReceiveServiceActionParse(ClientMsgParser.ParserListener r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r1, ClientServiceTrace r2) {
        r1.setExtrasClassLoader(ServiceConnectEvent.class.getClassLoader());
        ServiceConnectEvent r3 = (ServiceConnectEvent) r1.getParcelableExtra("service");
        this.mListener.onReceiveServiceEvent(r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
