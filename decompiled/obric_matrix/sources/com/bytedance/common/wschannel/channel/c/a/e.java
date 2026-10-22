package com.bytedance.common.wschannel.channel.c.a;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import java.io.UnsupportedEncodingException;
import k.h;
import org.json.JSONObject;
import p000j.f0;

/* JADX INFO: loaded from: classes.dex */
class e implements c.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IWsChannelClient f3436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3437b;

    e(Context r1, c r2, IWsChannelClient r3) {
        this.f3436a = r3;
        this.f3437b = r1;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.c.k
    public void a(String r4) {
        if (this.f3436a == null) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CONNECTION_STATE, 1);     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CONNECTION_URL, r4);     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f3436a.onConnection(r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.c.k
    public void b(String r2, int r3, String r4) {
        Logger.d("WsChannelSdk_ok", "onClosed() : " + r4);
        if (this.f3436a == null) goto L12;
        JSONObject r5 = new JSONObject();
        r5.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Exception -> L7
        r5.put(WsConstants.KEY_CONNECTION_STATE, 3);     // Catch: Exception -> L7
        r5.put(WsConstants.KEY_CONNECTION_URL, r2);     // Catch: Exception -> L7
        r5.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f3436a.onConnection(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.c.k
    public void c(f0 r4) {
        Logger.d("WsChannelSdk_ok", "onOpen(): " + r4.toString());
        if (this.f3436a == null) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.KEY_CONNECTION_TYPE, 1);     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CONNECTION_STATE, 4);     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CONNECTION_URL, r4.Y().k().toString());     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f3436a.onConnection(r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.c.k
    public void d(String r7, int r8, String r9) {
        Logger.d("WsChannelSdk_ok", "onFailure() : " + r9);
        Bundle r0 = new Bundle();
        r0.putString(WsConstants.KEY_CONNECTION_URL, r7);
        r0.putInt(WsConstants.ERROR_CODE, r8);
        r0.putString("error_msg", r9);
        r0.putString("method", "onFailure");
        com.bytedance.common.wschannel.t.a.a(this.f3437b, "WsChannelSdk_ok", r0);
        if (this.f3436a == null) goto L12;
        JSONObject r1 = new JSONObject();
        r1.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Exception -> L7
        r1.put(WsConstants.KEY_CONNECTION_STATE, 2);     // Catch: Exception -> L7
        r1.put(WsConstants.KEY_CONNECTION_URL, r7);     // Catch: Exception -> L7
        r1.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r1.put(WsConstants.KEY_CONNECTION_ERROR, r9);     // Catch: Exception -> L7
        r1.put(WsConstants.ERROR_CODE, r8);     // Catch: Exception -> L7
        this.f3436a.onConnection(r1);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.c.k
    public void e(h r3) {
        Logger.d("WsChannelSdk_ok", "onMessage() : " + r3.toString());
        IWsChannelClient r2 = this.f3436a;
        if (r2 == null) goto L6;
        r2.onMessage(r3.E());
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.c.k
    public void f(String r3) {
        Logger.d("WsChannelSdk_ok", "onMessage():" + r3);
        IWsChannelClient r2 = this.f3436a;
        if (r2 == null) goto L11;
        r2.onMessage(r3.getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
