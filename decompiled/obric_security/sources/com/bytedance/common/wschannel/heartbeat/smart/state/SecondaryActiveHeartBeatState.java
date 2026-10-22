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
public class SecondaryActiveHeartBeatState implements ISmartHeartBeatState {
    private AppState currentAppState;
    private final Handler mHandler;
    private Runnable mSendHeartBeatRunnable;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;
    private SmartHeartBeatStateMachine machine;
    private SmartHeartBeatMeta meta;
    private HeartBeatReactListener reactListener;
    private int totalSuccessCount;

    static /* synthetic */ AtomicBoolean access$000(SecondaryActiveHeartBeatState r0) {
        return r0.mWaitingForPong;
    }

    static /* synthetic */ void access$100(SecondaryActiveHeartBeatState r0) {
        r0.disConnect();
    }

    static /* synthetic */ HeartBeatReactListener access$200(SecondaryActiveHeartBeatState r0) {
        return r0.reactListener;
    }

    static /* synthetic */ int access$302(SecondaryActiveHeartBeatState r0, int r1) {
        r0.totalSuccessCount = r1;
        return r1;
    }

    static /* synthetic */ void access$400(SecondaryActiveHeartBeatState r0) {
        r0.schedule();
    }

    public SecondaryActiveHeartBeatState(HeartBeatReactListener r3, SmartHeartBeatStateMachine r4, SmartHeartBeatMeta r5, Handler r6) {
        this.totalSuccessCount = 0;
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
        this.totalSuccessCount = 0;
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        int r0 = this.totalSuccessCount + 1;
        this.totalSuccessCount = r0;
        if (r0 >= this.meta.getNetStableTestCount()) goto L5;
    L16:
        Logger.d(OkChannelImpl.TAG, "receive pong, success times：" + this.totalSuccessCount + ", current appstate: " + this.currentAppState);
        return;
    L5:
        if (this.currentAppState != AppState.STATE_BACKGROUND) goto L11;
        if (this.meta.getPreviousState() != StateType.STABLE) goto L9;
        this.machine.onStableState();
    L13:
        disConnect();
        goto L16
    L9:
        this.machine.onPlumbState();
        goto L13
    L11:
        if (this.currentAppState != AppState.STATE_FOREGROUND) goto L15;
        this.machine.onActiveState();
        goto L13
    L15:
        throw new IllegalStateException("Error app state: " + this.currentAppState);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r1) {
        this.currentAppState = r1;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response r1) {
        this.totalSuccessCount = 0;
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        disConnect();
        this.machine.onIdleState();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState
    public StateType provideType() {
        return StateType.SECONDARY_ACTIVE;
    }

    private void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    private void schedule() {
        long r0 = this.meta.getMinPingInterval();
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
