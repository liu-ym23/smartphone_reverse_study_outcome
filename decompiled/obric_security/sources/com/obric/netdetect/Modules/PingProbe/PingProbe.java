package com.obric.netdetect.Modules.PingProbe;

import android.os.SystemClock;
import com.obric.netdetect.Utils.NetDetectLog;

/* JADX INFO: loaded from: classes3.dex */
public class PingProbe {
    private static final String TAG = "PingProbe";
    private final PingNative mPingNative;
    private final PingProbeListener mPingProbeListener;
    private final int mProbeCount;
    private final int mTimeout;

    public interface PingProbeListener {
        void onPingPartialSuccess(int r1, int r2, int r3, int r4, int r5, int r6);

        void onPingProbeFailure(int r1, int r2);

        void onPingProbeSuccess(int r1, int r2, int r3, int r4, int r5);
    }

    public PingProbe(PingProbeListener r1, PingNative r2, int r3, int r4) {
        this.mPingProbeListener = r1;
        this.mPingNative = r2;
        this.mProbeCount = r3;
        this.mTimeout = r4;
    }

    public void executePingProbe(String r14) {
        int r0 = 0;
        int r5 = 0;
        int r6 = 0;
        int r8 = Integer.MAX_VALUE;
        int r9 = Integer.MIN_VALUE;
        int r10 = -9;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mProbeCount) goto L15;
        r5 = r5 + 1;
        int r3 = this.mPingNative.ping(r14, this.mTimeout);
        if (r3 <= 0) goto L13;
        r6 = r6 + 1;
        if (r3 >= r8) goto L10;
        r8 = r3;
    L10:
        if (r3 <= r9) goto L12;
        r9 = r3;
    L12:
        r2 = r2 + r3;
    L14:
        SystemClock.sleep(500);
        r1 = r1 + 1;
        goto L4
    L13:
        r10 = r3;
        goto L14
    L15:
        if (r6 <= 0) goto L17;
        r0 = r2 / r6;
    L17:
        int r7 = r0;
        if (r6 == 0) goto L22;
        if (r6 != r5) goto L22;
        NetDetectLog.d(TAG, "ping success, sendCount: " + r5 + ", receiveCount: " + r6 + ", avgRtt: " + r7 + ", minRtt: " + r8 + ", maxRtt: " + r9);
        this.mPingProbeListener.onPingProbeSuccess(r5, r6, r7, r8, r9);
        return;
    L22:
        if (r6 == 0) goto L25;
        if (r6 >= r5) goto L25;
        NetDetectLog.d(TAG, "ping partial success, sendCount: " + r5 + ", receiveCount: " + r6 + ", avgRtt: " + r7 + ", minRtt: " + r8 + ", maxRtt: " + r9 + ", errorCode: " + r10);
        this.mPingProbeListener.onPingPartialSuccess(r5, r6, r7, r8, r9, r10);
        return;
    L25:
        NetDetectLog.d(TAG, "ping failed, sendCount: " + r5 + ", receiveCount: " + r6 + ", errorCode: " + r10);
        this.mPingProbeListener.onPingProbeFailure(r5, r10);
    }
}
