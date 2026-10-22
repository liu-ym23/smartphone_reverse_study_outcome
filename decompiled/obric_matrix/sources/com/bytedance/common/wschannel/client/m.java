package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.o;

/* JADX INFO: loaded from: classes.dex */
public class m implements k {
    public m() {
    }

    private void h(Context r2, int r3) {
        if (r2 == null) goto L15;
        if (r3 > 0) goto L5;
        return;
    L5:
        if (r3 <= 3) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L11;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r3);
    L11:
        if (o.f(r2).g() == true) goto L13;
        return;
    L13:
        Message r1 = new Message();
        r1.what = 2;
        r1.arg1 = r3;
        com.bytedance.common.wschannel.server.h.b(r2).handleMsg(r1);
        return;
    }

    private void i(Context r3, k.a r4) {
        Message r2 = Message.obtain();
        r2.what = r4.f3504c;
        r2.getData().putParcelable(r4.f3502a, r4.f3503b);
        com.bytedance.common.wschannel.server.h.b(r3).handleMsg(r2);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void a(Context r3, SsWsApp r4) {
        k.a r0 = new k.a();
        r0.f3502a = WsConstants.KEY_WS_APP;
        r0.f3503b = r4;
        r0.f3504c = 0;
        i(r3, r0);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void b(Context r3, int r4) {
        k.a r0 = new k.a();
        r0.f3502a = WsConstants.KEY_WS_APP;
        r0.f3503b = new IntegerParcelable(r4);
        r0.f3504c = 1;
        i(r3, r0);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void c(Context r1, boolean r2, boolean r3) {
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void d(Context r2) {
        h(r2, 2);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void e(Context r2) {
        h(r2, 1);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void f(Context r3, WsChannelMsg r4) {
        k.a r0 = new k.a();
        r0.f3502a = WsConstants.KEY_PAYLOAD;
        r0.f3503b = r4;
        r0.f3504c = 5;
        i(r3, r0);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void g(Context r3, SsWsApp r4) {
        if (o.f(r3).g() == true) goto L5;
        return;
    L5:
        k.a r0 = new k.a();
        r0.f3502a = WsConstants.KEY_WS_APP;
        r0.f3503b = r4;
        r0.f3504c = 4;
        i(r3, r0);
    }
}
