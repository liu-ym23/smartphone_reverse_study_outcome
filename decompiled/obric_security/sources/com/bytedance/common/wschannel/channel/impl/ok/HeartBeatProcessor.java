package com.bytedance.common.wschannel.channel.impl.ok;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
class HeartBeatProcessor {
    private long DEFAULT_PING_INTERVAL_MIN;
    private long mCurBackgroundHeart;
    private final Handler mHandler;
    private final HeartBeatListener mListener;
    private long mPongTimeout;
    private Runnable mSendHeartBeatRunnable;
    private long mSuccessHeart;
    private Runnable mTimeoutCheckRunnable;
    private AtomicBoolean mWaitingForPong;
    private CustomHeartBeatWebSocket mWebSocket;

    interface HeartBeatListener {
        void onHeartBeatTimeout();
    }

    void onAppStateChanged(boolean r1) {
    }

    static /* synthetic */ AtomicBoolean access$000(HeartBeatProcessor r0) {
        return r0.mWaitingForPong;
    }

    static /* synthetic */ HeartBeatListener access$100(HeartBeatProcessor r0) {
        return r0.mListener;
    }

    static /* synthetic */ void access$200(HeartBeatProcessor r0) {
        r0.sendPing();
    }

    static /* synthetic */ void access$300(HeartBeatProcessor r0) {
        r0.schedule();
    }

    HeartBeatProcessor(Handler r3, HeartBeatListener r4) {
        this.DEFAULT_PING_INTERVAL_MIN = NormalHeartBeatMeta.DEFAULT_PING_INTERVAL;
        this.mCurBackgroundHeart = NormalHeartBeatMeta.DEFAULT_PING_INTERVAL;
        this.mSuccessHeart = NormalHeartBeatMeta.DEFAULT_PING_INTERVAL;
        this.mWaitingForPong = new AtomicBoolean(false);
        this.mTimeoutCheckRunnable = new AnonymousClass1(this);
        this.mSendHeartBeatRunnable = new AnonymousClass2(this);
        this.mPongTimeout = 5000;
        this.mHandler = r3;
        this.mListener = r4;
    }

    private void schedule() {
        long r0 = this.DEFAULT_PING_INTERVAL_MIN;
        Logger.d(OkChannelImpl.TAG, "interval :" + r0 + " ms,the next heartbeat is: " + Utils.getTimeFormat(System.currentTimeMillis() + r0));
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mHandler.postDelayed(this.mSendHeartBeatRunnable, r0);
    }

    private void sendPing() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mWebSocket == null) goto L11;
        Logger.d(OkChannelImpl.TAG, "send ping");     // Catch: Exception -> L6
        this.mWebSocket.sendPing();     // Catch: Exception -> L6
        waitingForPong();     // Catch: Exception -> L6
        return;
    }

    private void waitingForPong() {
        this.mWaitingForPong.set(true);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.postDelayed(this.mTimeoutCheckRunnable, this.mPongTimeout);
    }

    void setPongTimeout(long r1) {
        this.mPongTimeout = r1;
    }

    void disConnect() {
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
        this.mHandler.removeCallbacks(this.mSendHeartBeatRunnable);
        this.mWaitingForPong.set(false);
    }

    void onReceivePong(CustomHeartBeatWebSocket r1, ByteString r2) {
        Logger.d(OkChannelImpl.TAG, "receive pong");
        this.mWaitingForPong.set(false);
        this.mHandler.removeCallbacks(this.mTimeoutCheckRunnable);
    }

    long getSuccessHeatBeatInterval() {
        return this.mSuccessHeart;
    }

    void onOpenSuccess(CustomHeartBeatWebSocket r1, Response r2) {
        this.mWebSocket = r1;
        updatePingInterval(r2);
        schedule();
    }

    private void updatePingInterval(Response r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r9 = r8.header("Handshake-Options");
        if (r9 == null) goto L16;
        String[] r10 = r9.split(";");
        int r0 = r10.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L24;
        String r3 = r10[r2];
        if (TextUtils.isEmpty(r3) == true) goto L15;
        String[] r4 = r3.split("=");
        if ("ping-interval".equals(r4[0]) == false) goto L15;
        this.DEFAULT_PING_INTERVAL_MIN = Long.parseLong(r4[1]) * 1000;     // Catch: NumberFormatException -> L17
        return;
    L15:
        r2 = r2 + 1;
        goto L7
    L24:
        return;
    }
}
