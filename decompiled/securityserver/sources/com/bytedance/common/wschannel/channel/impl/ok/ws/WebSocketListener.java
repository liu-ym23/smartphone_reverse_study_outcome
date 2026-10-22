package com.bytedance.common.wschannel.channel.impl.ok.ws;

import androidx.annotation.Nullable;
import okhttp3.Response;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebSocketListener {
    public WebSocketListener() {
    }

    public void onClosed(CustomHeartBeatWebSocket r1, int r2, String r3) {
    }

    public void onClosing(CustomHeartBeatWebSocket r1, int r2, String r3) {
    }

    public void onFailure(CustomHeartBeatWebSocket r1, Throwable r2, @Nullable Response r3) {
    }

    public void onMessage(CustomHeartBeatWebSocket r1, String r2) {
    }

    public void onOpen(CustomHeartBeatWebSocket r1, Response r2) {
    }

    public void onPong(CustomHeartBeatWebSocket r1, ByteString r2) {
    }

    public void onMessage(CustomHeartBeatWebSocket r1, ByteString r2) {
    }
}
