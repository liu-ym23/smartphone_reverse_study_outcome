package com.bytedance.common.wschannel.client;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SocketState;

/* JADX INFO: loaded from: classes.dex */
class e extends b {
    public e(@NonNull c.a r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r5, com.bytedance.common.wschannel.model.a r6) {
        r5.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState r7 = (SocketState) r5.getParcelableExtra(WsConstants.KEY_CONNECTION);
        com.bytedance.common.wschannel.r.c r8 = b(r7.c(), r7.e(), r7.g());     // Catch: Throwable -> L5
        this.f3500a.b(new com.bytedance.common.wschannel.r.b(r8, r7.d(), r7.c(), r7.f()), r7.m());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
