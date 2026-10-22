package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.log.WsChannelLog;
import java.io.UnsupportedEncodingException;
import okhttp3.Response;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class WsStatusChangedListener implements WsOkClient.WsStatusListener {
    private final Context mContext;
    private final IWsChannelClient mWsChannelClient;
    private final WsOkClient mWsClient;

    WsStatusChangedListener(Context r1, WsOkClient r2, IWsChannelClient r3) {
        this.mWsClient = r2;
        this.mWsChannelClient = r3;
        this.mContext = r1;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onConnecting(String r4) {
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put("type", 1);     // Catch: Exception -> L7
        r0.put("state", 1);     // Catch: Exception -> L7
        r0.put("url", r4);     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onMessage(ByteString r3) {
        Logger.d(OkChannelImpl.TAG, "onMessage() : " + r3.toString());
        IWsChannelClient r2 = this.mWsChannelClient;
        if (r2 == null) goto L6;
        r2.onMessage(r3.toByteArray());
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onFailure(String r7, int r8, String r9) {
        Logger.d(OkChannelImpl.TAG, "onFailure() : " + r9);
        Bundle r0 = new Bundle();
        r0.putString("url", r7);
        r0.putInt("error_code", r8);
        r0.putString("error_msg", r9);
        r0.putString("method", "onFailure");
        WsChannelLog.onEventV3Bundle(this.mContext, OkChannelImpl.TAG, r0);
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r1 = new JSONObject();
        r1.put("type", 0);     // Catch: Exception -> L7
        r1.put("state", 2);     // Catch: Exception -> L7
        r1.put("url", r7);     // Catch: Exception -> L7
        r1.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r1.put("error", r9);     // Catch: Exception -> L7
        r1.put("error_code", r8);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r1);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onClosed(String r2, int r3, String r4) {
        Logger.d(OkChannelImpl.TAG, "onClosed() : " + r4);
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r5 = new JSONObject();
        r5.put("type", 0);     // Catch: Exception -> L7
        r5.put("state", 3);     // Catch: Exception -> L7
        r5.put("url", r2);     // Catch: Exception -> L7
        r5.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onMessage(String r3) {
        Logger.d(OkChannelImpl.TAG, "onMessage():" + r3);
        IWsChannelClient r2 = this.mWsChannelClient;
        if (r2 == null) goto L11;
        r2.onMessage(r3.getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onOpen(Response r4) {
        Logger.d(OkChannelImpl.TAG, "onOpen(): " + r4.toString());
        if (this.mWsChannelClient == null) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put("type", 1);     // Catch: Exception -> L7
        r0.put("state", 4);     // Catch: Exception -> L7
        r0.put("url", r4.request().url().toString());     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.mWsChannelClient.onConnection(r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
