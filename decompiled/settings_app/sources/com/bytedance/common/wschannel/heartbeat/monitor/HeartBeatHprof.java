package com.bytedance.common.wschannel.heartbeat.monitor;

import com.bytedance.common.wschannel.heartbeat.smart.state.StateType;

/* JADX INFO: loaded from: classes3.dex */
public class HeartBeatHprof {
    private long currentPingInterval;
    private StateType currentStateType;

    public HeartBeatHprof(StateType r1, long r2) {
        this.currentStateType = r1;
        this.currentPingInterval = r2;
    }

    public StateType getCurrentStateType() {
        return this.currentStateType;
    }

    public long getCurrentPingInterval() {
        return this.currentPingInterval;
    }

    public String toString() {
        return "HeartBeatHprof{currentStateType=" + this.currentStateType + ", currentPingInterval=" + this.currentPingInterval + '}';
    }
}
