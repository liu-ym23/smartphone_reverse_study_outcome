package com.bytedance.common.wschannel.client;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    public f(@NonNull c.a r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r4, @Nullable com.bytedance.common.wschannel.model.a r5) {
        r4.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        WsChannelMsg r6 = (WsChannelMsg) r4.getParcelableExtra(WsConstants.KEY_PAYLOAD);
        if (WsConstants.getOptLogic().get().booleanValue() == true) goto L9;
        Message r1 = new Message();
        r1.getData().putParcelable(WsConstants.KEY_PAYLOAD, r6);
        r1.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
        Parcelable r7 = r1.getData().getParcelable(WsConstants.KEY_PAYLOAD);
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
        Logger.d("AbsWsClientService", "get wsChannelMsg = " + r6.toString());
    L13:
        if (r5 == null) goto L15;
        r6.q = r5.f3630a;
    L15:
        this.f3500a.c(r6);
    }
}
