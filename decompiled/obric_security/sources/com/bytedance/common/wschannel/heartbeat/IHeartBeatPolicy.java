package com.bytedance.common.wschannel.heartbeat;

import com.bytedance.common.wschannel.heartbeat.model.AppState;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public interface IHeartBeatPolicy {
    void onAppStateUpdate(AppState r1);

    void onConnected(Response r1);

    void onDisconnected();

    void onPingSendSuccess();

    void onReceivePong();
}
