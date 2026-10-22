package com.bytedance.common.wschannel.heartbeat.smart.state;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatStateMachine;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class StableHeartBeatState implements ISmartHeartBeatState {
    private final Handler mHandler;
    private Runnable mSendHeartBeatRunnable;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private long plumbPingInterval;
    private HeartBeatReactListener reactListener;
    private int totalFailCount;

    static /* synthetic */ AtomicBoolean access$000(StableHeartBeatState r0) {
        return r0.mWaitingForPong;
    }

    static /* synthetic */ void access$100(StableHeartBeatState r0) {
        r0.disConnect();
    }

    static /* synthetic */ int access$200(StableHeartBeatState r0) {
        return r0.totalFailCount;
    }

    static /* synthetic */ int access$208(StableHeartBeatState r2) {
        int r0 = r2.totalFailCount;
        r2.totalFailCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ SmartHeartBeatMeta access$300(StableHeartBeatState r0) {
        return r0.meta;
    }

    static /* synthetic */ HeartBeatReactListener access$400(StableHeartBeatState r0) {
        return r0.reactListener;
    }

    static /* synthetic */ void access$500(StableHeartBeatState r0) {
        r0.schedule();
    }

    public StableHeartBeatState(HeartBeatReactListener r3, SmartHeartBeatStateMachine r4, SmartHeartBeatMeta r5, Handler r6) {
        this.totalFailCount = 0;
        this.mWaitingForPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.mSendHeartBeatRunnable = new AnonymousClass2(this);
        this.reactListener = r3;
        this.machine = r4;
        this.meta = r5;
        this.mHandler = r6;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public void onEnterThisState() {
        if (this.totalFailCount < this.meta.getMaxPingFailCount()) goto L5;
        this.totalFailCount = 0;
        this.machine.onPlumbState();
        return;
    L5:
        this.plumbPingInterval = this.meta.getPlumbPingInterval() - this.meta.getSuccessStep();
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.totalFailCount = 0;
        Logger.d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r2) {
        if (r2 != AppState.STATE_FOREGROUND) goto L6;
        this.machine.onActiveState();
        disConnect();
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response r1) {
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        disConnect();
        this.machine.onIdleState();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public StateType provideType() {
        return StateType.STABLE;
    }

    private void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    private void schedule() {
        long r0 = this.plumbPingInterval;
        this.meta.setCurrentPingInterval(r0);
        Logger.d(OkChannelImpl.TAG, "interval :" + r0 + " ms,the next time to send heartbeat is " + Utils.getTimeFormat(System.currentTimeMillis() + r0));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, r0);
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, this.meta.getPingTimeOut());
    }
}
