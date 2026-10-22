package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class CompensateHeartBeatManager {
    private static final long TIMEOUT = 5000;
    private AppState currentAppState;
    private Handler mHandler;
    private AtomicBoolean mIsWaitingPong;
    private Runnable mTimeoutCheckRunnable;
    private CustomHeartBeatWebSocket mWebSocket;
    private OnHeartBeatTimeoutListener timeoutListener;

    public interface OnHeartBeatTimeoutListener {
        void onTimeout();
    }

    public CompensateHeartBeatManager(OnHeartBeatTimeoutListener r3, Handler r4) {
        this.mIsWaitingPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.timeoutListener = r3;
        this.mHandler = r4;
    }

    public static /* synthetic */ AtomicBoolean access$000(CompensateHeartBeatManager r0) {
        return r0.mIsWaitingPong;
    }

    public static /* synthetic */ OnHeartBeatTimeoutListener access$100(CompensateHeartBeatManager r0) {
        return r0.timeoutListener;
    }

    private boolean isBackToFore(AppState r2) {
        if (this.currentAppState == AppState.STATE_BACKGROUND) goto L5;
    L7:
        return false;
    L5:
        if (r2 != AppState.STATE_FOREGROUND) goto L7;
        return true;
    }

    private void waitingForPong() {
        this.mIsWaitingPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, 5000);
    }

    public boolean isWaitingPong() {
        return this.mIsWaitingPong.get();
    }

    public void onReceivePong() {
        Logger.d(OkChannelImpl.TAG, "After compensating for ping, received pong");
        this.mIsWaitingPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    public void setWebSocket(CustomHeartBeatWebSocket r1) {
        this.mWebSocket = r1;
    }

    public void updateCurrentAppState(AppState r3) {
        if (this.mIsWaitingPong.get() == false) goto L5;
    L13:
        this.currentAppState = r3;
        return;
    L5:
        if (isBackToFore(r3) == false) goto L13;
        Logger.d(OkChannelImpl.TAG, "Switch the foreground in the background, send compensation ping");
        CustomHeartBeatWebSocket r0 = this.mWebSocket;     // Catch: Exception -> L11
        if (r0 == null) goto L13;
        r0.sendPing();     // Catch: Exception -> L11
        waitingForPong();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }
}
