package com.bytedance.common.wschannel.channel.impl.ok.ws;

import okhttp3.WebSocket;

/* JADX INFO: loaded from: classes3.dex */
public interface CustomHeartBeatWebSocket extends WebSocket {
    void sendPing();
}
