package com.bytedance.common.wschannel.heartbeat.smart;

import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.smart.state.StateType;

/* JADX INFO: loaded from: classes.dex */
public class SmartHeartBeatMeta implements IHeartBeatMeta<SmartHeartBeatMeta> {
    private long currentPingInterval;
    private int maxPingFailCount;
    private long maxPingInterval;
    private long minPingInterval;
    private int netStableTestCount;
    private long pingStep;
    private long pingTimeOut;
    private long plumbPingInterval;
    private StateType previousState;
    private long successStep;

    private static class DefaultSmartHeartBeatMeta extends SmartHeartBeatMeta {
        private static final int MAX_PING_FAIL_COUNT = 2;
        private static final long MAX_PING_INTERVAL = 600000;
        private static final long MIN_PING_INTERVAL = 210000;
        private static final int NET_STABLE_TEST_COUNT = 3;
        private static final long PING_STEP = 60000;
        private static final long PING_TIMEOUT = 5000;
        private static final long SUCCESS_STEP = 20000;

        @Override // com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatMeta, com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
        public /* bridge */ /* synthetic */ IHeartBeatMeta provideDefaultMeta() {
            return super.provideDefaultMeta();
        }

        public DefaultSmartHeartBeatMeta() {
            super(MIN_PING_INTERVAL, 600000, 2, 3, 60000, 20000, 5000);
        }
    }

    @Override // com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
    public /* bridge */ /* synthetic */ IHeartBeatMeta provideDefaultMeta() {
        return provideDefaultMeta();
    }

    public SmartHeartBeatMeta() {
    }

    public SmartHeartBeatMeta(long r1, long r3, int r5, int r6, long r7, long r9, long r11) {
        this.minPingInterval = r1;
        this.maxPingInterval = r3;
        this.maxPingFailCount = r5;
        this.netStableTestCount = r6;
        this.pingStep = r7;
        this.successStep = r9;
        this.pingTimeOut = r11;
        this.plumbPingInterval = r1;
        this.currentPingInterval = r1;
    }

    public long getMinPingInterval() {
        return this.minPingInterval;
    }

    public long getMaxPingInterval() {
        return this.maxPingInterval;
    }

    public int getMaxPingFailCount() {
        return this.maxPingFailCount;
    }

    public int getNetStableTestCount() {
        return this.netStableTestCount;
    }

    public long getPingStep() {
        return this.pingStep;
    }

    public long getSuccessStep() {
        return this.successStep;
    }

    public long getPingTimeOut() {
        return this.pingTimeOut;
    }

    public long getPlumbPingInterval() {
        return this.plumbPingInterval;
    }

    public void setPlumbPingInterval(long r1) {
        this.plumbPingInterval = r1;
    }

    public StateType getPreviousState() {
        return this.previousState;
    }

    public void setPreviousState(StateType r1) {
        this.previousState = r1;
    }

    public long getCurrentPingInterval() {
        return this.currentPingInterval;
    }

    public void setCurrentPingInterval(long r1) {
        this.currentPingInterval = r1;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
    public SmartHeartBeatMeta provideDefaultMeta() {
        return new DefaultSmartHeartBeatMeta();
    }
}
