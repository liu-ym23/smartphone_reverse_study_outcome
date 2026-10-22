package com.bytedance.common.wschannel.heartbeat.smart;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.StateType;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class SmartHeartBeatPolicy extends BaseHeartBeatPolicy<SmartHeartBeatMeta> {
    private AppState currentAppState;
    private AtomicBoolean mWaitingForPong;
    private ISmartHeartBeatState state;

    public SmartHeartBeatPolicy(SmartHeartBeatMeta r2) {
        super(r2);
        this.mWaitingForPong = new AtomicBoolean(false);
    }

    public StateType getCurrentStateType() {
        ISmartHeartBeatState r0 = this.state;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provideType();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy
    public void init(final HeartBeatReactListener r3, Handler r4) {
        new SmartHeartBeatStateMachine().init(new AnonymousClass1(this, r3), this, (SmartHeartBeatMeta) this.mMeta, r4);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r4) {
        Logger.d(OkChannelImpl.TAG, "update current appstate: " + r4 + " " + this.state + " " + Thread.currentThread().getName());
        this.currentAppState = r4;
        this.state.onAppStateUpdate(r4);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response r1) {
        this.state.onConnected(r1);
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        this.state.onDisconnected();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        this.mWaitingForPong.set(true);
        this.state.onPingSendSuccess();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        this.state.onReceivePong();
        HeartBeatMonitor.getInstance().onPingSuccess();
    }

    public void setState(ISmartHeartBeatState r3) {
        ISmartHeartBeatState r0 = this.state;
        if (r0 != null) goto L5;
    L7:
        this.state = r3;
        AppState r1 = this.currentAppState;
        if (r1 == null) goto L10;
        r3.onAppStateUpdate(r1);
    L11:
        this.state.onEnterThisState();
        return;
    L10:
        r3.onAppStateUpdate(AppState.STATE_BACKGROUND);
        goto L11
    L5:
        if (r0.provideType() == StateType.IDLE) goto L7;
        ((SmartHeartBeatMeta) this.mMeta).setPreviousState(this.state.provideType());
        goto L7
    }
}
