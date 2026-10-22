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

/* JADX INFO: loaded from: classes.dex */
public class PlumbHeartBeatState implements ISmartHeartBeatState {
    private int currentIntervalFailCount;
    private long currentPingInterval;
    private Handler mHandler;
    private Runnable mSendHeartBeatRunnable;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private HeartBeatReactListener reactListener;

    public PlumbHeartBeatState(HeartBeatReactListener r3, SmartHeartBeatStateMachine r4, SmartHeartBeatMeta r5, Handler r6) {
        this.currentIntervalFailCount = 0;
        this.mWaitingForPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.mSendHeartBeatRunnable = new AnonymousClass2(this);
        this.reactListener = r3;
        this.machine = r4;
        this.meta = r5;
        this.mHandler = r6;
        long r7 = r5.getMinPingInterval();
        this.currentPingInterval = r5.getPingStep() + r7;
    }

    public static /* synthetic */ AtomicBoolean access$000(PlumbHeartBeatState r0) {
        return r0.mWaitingForPong;
    }

    public static /* synthetic */ void access$100(PlumbHeartBeatState r0) {
        r0.disConnect();
    }

    public static /* synthetic */ int access$200(PlumbHeartBeatState r0) {
        return r0.currentIntervalFailCount;
    }

    public static /* synthetic */ int access$208(PlumbHeartBeatState r2) {
        int r0 = r2.currentIntervalFailCount;
        r2.currentIntervalFailCount = r0 + 1;
        return r0;
    }

    public static /* synthetic */ SmartHeartBeatMeta access$300(PlumbHeartBeatState r0) {
        return r0.meta;
    }

    public static /* synthetic */ long access$400(PlumbHeartBeatState r2) {
        return r2.currentPingInterval;
    }

    public static /* synthetic */ long access$402(PlumbHeartBeatState r0, long r1) {
        r0.currentPingInterval = r1;
        return r1;
    }

    public static /* synthetic */ SmartHeartBeatStateMachine access$500(PlumbHeartBeatState r0) {
        return r0.machine;
    }

    public static /* synthetic */ HeartBeatReactListener access$600(PlumbHeartBeatState r0) {
        return r0.reactListener;
    }

    private void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    private void schedule() {
        long r0 = this.currentPingInterval;
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

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r5) {
        if (r5 != AppState.STATE_FOREGROUND) goto L6;
        disConnect();
        long r0 = this.meta.getMinPingInterval();
        this.currentPingInterval = this.meta.getPingStep() + r0;
        this.machine.onActiveState();
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
    public void onEnterThisState() {
        long r0 = this.meta.getMinPingInterval();
        this.currentPingInterval = this.meta.getPingStep() + r0;
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.currentIntervalFailCount = 0;
        if (this.currentPingInterval > (this.meta.getMaxPingInterval() - this.meta.getPingStep())) goto L5;
        this.currentPingInterval = this.meta.getPingStep() + this.currentPingInterval;
        schedule();
        Logger.d(OkChannelImpl.TAG, "receive pong，increate detect step " + this.meta.getPingStep());
        return;
    L5:
        this.currentPingInterval = this.meta.getMaxPingInterval();
        SmartHeartBeatMeta r0 = this.meta;
        r0.setPlumbPingInterval(r0.getMaxPingInterval());
        disConnect();
        this.machine.onStableState();
        Logger.d(OkChannelImpl.TAG, "The maximum heartbeat interval test can ping: " + this.currentPingInterval);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public StateType provideType() {
        return StateType.PLUMB;
    }
}
