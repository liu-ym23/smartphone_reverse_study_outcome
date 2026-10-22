package com.bytedance.common.wschannel.client;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
class i extends b {
    public i(@NonNull c.a r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r3, com.bytedance.common.wschannel.model.a r4) {
        r3.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        String r5 = r3.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);
        boolean r6 = r3.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);
        if (Logger.debug() == false) goto L5;
        Logger.d("AbsWsClientService", "get payloadMd5 = " + r5 + " sendResult = " + r6);
    L5:
        this.f3500a.f(r5, r6);
    }
}
