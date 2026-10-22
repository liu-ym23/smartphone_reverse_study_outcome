package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IMessageReceiveListener {
    void onConnection(int r1, String r2, JSONObject r3);

    void onFeedBackLog(String r1);

    void onMessage(byte[] r1, int r2);
}
