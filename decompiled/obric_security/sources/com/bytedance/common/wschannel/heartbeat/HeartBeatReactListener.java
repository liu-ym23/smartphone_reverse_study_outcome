package com.bytedance.common.wschannel.heartbeat;

/* JADX INFO: loaded from: classes.dex */
public interface HeartBeatReactListener {
    void onHeartBeatTimeout();

    void onSendPing();
}
