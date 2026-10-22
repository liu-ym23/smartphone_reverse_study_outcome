package com.bytedance.common.wschannel.heartbeat.normal;

import a.a;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class NormalHeartBeatPolicy extends BaseHeartBeatPolicy<NormalHeartBeatMeta> {
    private Handler mHandler;
    private HeartBeatReactListener mReactListener;
    private Runnable mSendHeartBeatRunnable;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;

    public NormalHeartBeatPolicy(NormalHeartBeatMeta r2) {
        super(r2);
        this.mWaitingForPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.mSendHeartBeatRunnable = new AnonymousClass2(this);
    }

    public static /* synthetic */ AtomicBoolean access$000(NormalHeartBeatPolicy r0) {
        return r0.mWaitingForPong;
    }

    public static /* synthetic */ void access$100(NormalHeartBeatPolicy r0) {
        r0.disConnect();
    }

    public static /* synthetic */ HeartBeatReactListener access$200(NormalHeartBeatPolicy r0) {
        return r0.mReactListener;
    }

    public static /* synthetic */ void access$300(NormalHeartBeatPolicy r0) {
        r0.schedule();
    }

    private void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    private void schedule() {
        long r0 = ((NormalHeartBeatMeta) this.mMeta).getPingInterval();
        StringBuilder r2 = a.s("interval :", r0, " ms,the next time to send heartbeat is ");
        r2.append(Utils.getTimeFormat(System.currentTimeMillis() + r0));
        Logger.d(OkChannelImpl.TAG, r2.toString());
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, r0);
    }

    private void updatePingInterval(Response r13) {
        if (((NormalHeartBeatMeta) this.mMeta).getPingInterval() == (-1)) goto L6;
        return;
    L6:
        if (r13 != null) goto L9;
        ((NormalHeartBeatMeta) this.mMeta).setPingInterval(NormalHeartBeatMeta.DEFAULT_PING_INTERVAL);
        return;
    L9:
        String r14 = r13.header("Handshake-Options");
        if (r14 == null) goto L22;
        String[] r15 = r14.split(";");
        int r4 = r15.length;
        long r7 = -1;
        int r6 = 0;
    L12:
        if (r6 >= r4) goto L24;
        String r9 = r15[r6];
        if (TextUtils.isEmpty(r9) == true) goto L21;
        String[] r10 = r9.split("=");
        if ("ping-interval".equals(r10[0]) == false) goto L21;
        r7 = Long.parseLong(r10[1]) * 1000;
    L20:
        r7 = 270000;
    L21:
        r6 = r6 + 1;
    L24:
        if (r7 != (-1)) goto L26;
        ((NormalHeartBeatMeta) this.mMeta).setPingInterval(NormalHeartBeatMeta.DEFAULT_PING_INTERVAL);
        return;
    L26:
        ((NormalHeartBeatMeta) this.mMeta).setPingInterval(r7);
        return;
    L22:
        r7 = -1;
        goto L24
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, ((NormalHeartBeatMeta) this.mMeta).getTimeout());
    }

    @Override // com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy
    public void init(HeartBeatReactListener r1, Handler r2) {
        this.mReactListener = r1;
        this.mHandler = r2;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onAppStateUpdate(AppState r1) {
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onConnected(Response r3) {
        Logger.d(OkChannelImpl.TAG, "connect success，ready to send ping");
        updatePingInterval(r3);
        schedule();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onDisconnected() {
        Logger.d(OkChannelImpl.TAG, "disconnected，stop to send ping");
        disConnect();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onPingSendSuccess() {
        Logger.d(OkChannelImpl.TAG, "ping sent，waiting for pong");
        waitingForPong();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy
    public void onReceivePong() {
        Logger.d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        HeartBeatMonitor.getInstance().onPingSuccess();
    }
}
