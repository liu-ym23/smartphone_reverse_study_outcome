package com.bytedance.common.wschannel.heartbeat.monitor;

import com.bytedance.common.wschannel.heartbeat.smart.state.StateType;

/* JADX INFO: loaded from: classes.dex */
public class HeartBeatHprof {
    private long currentPingInterval;
    private StateType currentStateType;

    public HeartBeatHprof(StateType r1, long r2) {
        this.currentStateType = r1;
        this.currentPingInterval = r2;
    }

    public long getCurrentPingInterval() {
        return this.currentPingInterval;
    }

    public StateType getCurrentStateType() {
        return this.currentStateType;
    }

    public String toString() {
        return "HeartBeatHprof{currentStateType=" + this.currentStateType + ", currentPingInterval=" + this.currentPingInterval + '}';
    }
}
