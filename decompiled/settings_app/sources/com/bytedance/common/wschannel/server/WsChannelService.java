package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.MemTrimListener;
import com.bytedance.common.wschannel.WsChannelSdk;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.AbsMessengerService;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelService extends AbsMessengerService {

    static class Msg {
        final int channelId;
        final byte[] data;
        final WsChannelMsg message;
        final long ts;

        Msg(int r1, byte[] r2, long r3) {
            this.channelId = r1;
            this.data = r2;
            this.ts = r3;
            this.message = null;
        }

        Msg(int r1, WsChannelMsg r2, long r3) {
            this.channelId = r1;
            this.message = r2;
            this.ts = r3;
            this.data = null;
        }
    }

    static /* synthetic */ void access$000(WsChannelService r0, Intent r1) {
        r0.handleIntent(r1);
    }

    public WsChannelService() {
    }

    static int getClientKey(IWsApp r0) {
        if (r0 != null) goto L6;
        return Integer.MIN_VALUE;
    L6:
        return r0.getChannelId();
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent r1, int r2, int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        ThreadPlus.submitRunnable(new AnonymousClass1(this, r1));
        return 2;
    }

    private void handleIntent(Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r0) == false) goto L8;
        int r5 = r4.getIntExtra(WsConstants.KEY_APP_STATE, -1);
        Message r1 = new Message();
        r1.what = 2;
        r1.arg1 = r5;
        handleMsg(r1);
        return;
    L8:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r0) == false) goto L11;
        int r6 = r4.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        Message r2 = new Message();
        r2.what = 3;
        r2.arg1 = r6;
        handleMsg(r2);
        return;
    L11:
        if (WsConstants.MEM_TRIM_ACTION.equals(r0) == false) goto L18;
        int r3 = r4.getIntExtra(WsConstants.KEY_MEM_TRIM, -1);
        MemTrimListener r7 = WsChannelSdk.getMemTrimListener();
        if (r7 == null) goto L19;
        r7.onTrimMemory(r3);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r3) {
        super.handleMsg(r3);
        if (r3 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r3.what);
    L8:
        PushChannelManager.inst(this).handleMsg(r3);
    }
}
