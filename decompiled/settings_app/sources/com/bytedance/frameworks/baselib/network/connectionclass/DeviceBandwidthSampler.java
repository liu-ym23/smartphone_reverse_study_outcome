package com.bytedance.frameworks.baselib.network.connectionclass;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.thread.PlatformHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceBandwidthSampler {
    private static long sPreviousBytes = -1;
    private final ConnectionClassManager mConnectionClassManager;
    private SamplingHandler mHandler;
    private boolean mInvalid;
    private long mLastTimeReading;
    private AtomicInteger mSamplingCounter;
    private HandlerThread mThread;

    private static class DeviceBandwidthSamplerHolder {
        public static final DeviceBandwidthSampler instance = null;

        private DeviceBandwidthSamplerHolder() {
        }

        static {
            instance = new DeviceBandwidthSampler(ConnectionClassManager.getInstance());
        }
    }

    private class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;
        final /* synthetic */ DeviceBandwidthSampler this$0;

        public SamplingHandler(DeviceBandwidthSampler r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (r4.what != 1) goto L12;
            this.this$0.addSample();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }

    static {
    }

    public static DeviceBandwidthSampler getInstance() {
        return DeviceBandwidthSamplerHolder.instance;
    }

    protected DeviceBandwidthSampler(ConnectionClassManager r2) {
        this.mInvalid = false;
        this.mConnectionClassManager = r2;
        this.mSamplingCounter = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r3 = PlatformHandlerThread.getNewHandlerThread("ParseThread");     // Catch: Throwable -> L5
        this.mThread = r3;     // Catch: Throwable -> L5
        r3.start();     // Catch: Throwable -> L5
        this.mHandler = new SamplingHandler(this, this.mThread.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.mInvalid = true;
    }

    public void startSampling() {
        if (this.mInvalid == false) goto L6;
        return;
    L6:
        if (this.mSamplingCounter.getAndIncrement() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "startSampling");     // Catch: Throwable -> L12
    L10:
        this.mHandler.startSamplingThread();     // Catch: Throwable -> L12
        this.mLastTimeReading = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        return;
    }

    public void stopSampling() {
        if (this.mInvalid == false) goto L6;
        return;
    L6:
        if (this.mSamplingCounter.decrementAndGet() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "stopSampling");     // Catch: Throwable -> L12
    L10:
        this.mHandler.stopSamplingThread();     // Catch: Throwable -> L12
        addFinalSample();     // Catch: Throwable -> L12
        return;
    }

    protected void addSample() {
        long r0 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L13
        long r2 = sPreviousBytes;     // Catch: Throwable -> L13
        long r4 = r0 - r2;     // Catch: Throwable -> L13
        if (r2 < 0) goto L11;
        monitor-enter(this);     // Catch: Throwable -> L13
        long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.mConnectionClassManager.addBandwidth(r4, r3 - this.mLastTimeReading);     // Catch: Throwable -> L8
        this.mLastTimeReading = r3;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L11:
        sPreviousBytes = r0;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    protected void addFinalSample() {
        addSample();
        sPreviousBytes = -1;
    }

    public boolean isSampling() {
        if (this.mSamplingCounter.get() == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
