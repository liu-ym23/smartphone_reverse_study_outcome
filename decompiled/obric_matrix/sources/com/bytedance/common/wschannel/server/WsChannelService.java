package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelService extends com.bytedance.common.wschannel.app.a {

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f3705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ WsChannelService f3706g;

        a(WsChannelService r1, Intent r2) {
            this.f3706g = r1;
            this.f3705f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            WsChannelService.c(this.f3706g, this.f3705f);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f3708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f3709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final WsChannelMsg f3710d;

        b(int r1, WsChannelMsg r2, long r3) {
            this.f3707a = r1;
            this.f3710d = r2;
            this.f3709c = r3;
            this.f3708b = null;
        }

        b(int r1, byte[] r2, long r3) {
            this.f3707a = r1;
            this.f3708b = r2;
            this.f3709c = r3;
            this.f3710d = null;
        }
    }

    public WsChannelService() {
    }

    static /* synthetic */ void c(WsChannelService r0, Intent r1) {
        r0.e(r1);
    }

    static int d(IWsApp r0) {
        if (r0 != null) goto L6;
        return Integer.MIN_VALUE;
    L6:
        return r0.c();
    }

    private void e(Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r0) == false) goto L9;
        int r5 = r4.getIntExtra(WsConstants.KEY_APP_STATE, -1);
        Message r1 = new Message();
        int r2 = 2;
    L7:
        r1.what = r2;
        r1.arg1 = r5;
        handleMsg(r1);
        return;
    L9:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r0) == false) goto L12;
        r5 = r4.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        r1 = new Message();
        r2 = 3;
        goto L7
    L12:
        if (WsConstants.MEM_TRIM_ACTION.equals(r0) == false) goto L18;
        int r3 = r4.getIntExtra(WsConstants.KEY_MEM_TRIM, -1);
        com.bytedance.common.wschannel.f r6 = com.bytedance.common.wschannel.m.i();
        if (r6 == null) goto L19;
        r6.onTrimMemory(r3);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.common.wschannel.app.a, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r3) {
        super.handleMsg(r3);
        if (r3 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r3.what);
    L8:
        k.b(this).handleMsg(r3);
    }

    @Override // com.bytedance.common.wschannel.app.a, android.app.Service
    public void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
    }

    @Override // com.bytedance.common.wschannel.app.a, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        com.bytedance.common.utility.m.c.c(new a(this, r1));
        return 2;
    }
}
