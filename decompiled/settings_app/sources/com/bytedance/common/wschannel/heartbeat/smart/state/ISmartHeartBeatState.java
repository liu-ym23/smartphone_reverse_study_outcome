package com.bytedance.common.wschannel.heartbeat.smart.state;

import com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy;

/* JADX INFO: loaded from: classes3.dex */
public interface ISmartHeartBeatState extends IHeartBeatPolicy {
    void onEnterThisState();

    StateType provideType();
}
