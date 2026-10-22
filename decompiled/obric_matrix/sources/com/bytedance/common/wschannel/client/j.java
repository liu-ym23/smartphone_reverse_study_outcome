package com.bytedance.common.wschannel.client;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {
    public j(@NonNull c.a r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r3, com.bytedance.common.wschannel.model.a r4) {
        Logger.d("AbsWsClientService", "sync socket state");
        r3.setExtrasClassLoader(SocketState.class.getClassLoader());
        ArrayList r5 = r3.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);
        if (r5 == null) goto L10;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        SocketState r7 = (SocketState) r6.next();
        if (r7 == null) goto L6;
        b(r7.c(), r7.e(), r7.g());
        goto L6
    L16:
        return;
    }
}
