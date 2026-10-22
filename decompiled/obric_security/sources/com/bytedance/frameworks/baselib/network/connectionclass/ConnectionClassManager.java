package com.bytedance.frameworks.baselib.network.connectionclass;

import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionClassManager {
    static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    static final int DEFAULT_GOOD_BANDWIDTH = 560;
    static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    static final int DEFAULT_MODERATE_BANDWIDTH = 112;
    static final int DEFAULT_POOR_BANDWIDTH = 28;
    static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private AtomicReference<ConnectionQuality> mCurrentBandwidthConnectionQuality;
    private ExponentialGeometricAverage mDownloadBandwidth;
    private volatile boolean mInitiateStateChange;
    private ArrayList<ConnectionClassStateChangeListener> mListenerList;
    private AtomicReference<ConnectionQuality> mNextBandwidthConnectionQuality;
    private int mSampleCounter;

    private static class ConnectionClassManagerHolder {
        public static final ConnectionClassManager instance = null;

        private ConnectionClassManagerHolder() {
        }

        static {
            instance = new ConnectionClassManager();
        }
    }

    public interface ConnectionClassStateChangeListener {
        void onBandwidthStateChange(ConnectionQuality r1);
    }

    public static ConnectionClassManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    protected ConnectionClassManager() {
        this.mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.mInitiateStateChange = false;
        this.mCurrentBandwidthConnectionQuality = new AtomicReference(ConnectionQuality.UNKNOWN);
        this.mListenerList = new ArrayList();
    }

    public synchronized void addBandwidth(long r6, long r8) {
        monitor-enter(this);
        double r1 = ((r6 * 1.0d) / r8) * 8.0d;
        if (r8 != 0) goto L7;
    L29:
        monitor-exit(this);
        return;
    L7:
        if (r1 < 3.0d) goto L29;
        if (Logger.debug() == false) goto L12;
        Logger.d("ConnectionClassManager", "bytes = " + r6 + " timeInMs = " + r8 + " bandwidth = " + r1);     // Catch: Throwable -> L31
    L12:
        this.mDownloadBandwidth.addMeasurement(r1);     // Catch: Throwable -> L31
        if (this.mInitiateStateChange == false) goto L25;
        this.mSampleCounter++;     // Catch: Throwable -> L31
        if (getCurrentBandwidthQuality() == this.mNextBandwidthConnectionQuality.get()) goto L18;
        this.mInitiateStateChange = false;     // Catch: Throwable -> L31
        this.mSampleCounter = 1;     // Catch: Throwable -> L31
    L18:
        if (this.mSampleCounter >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE) goto L20;
    L22:
        monitor-exit(this);
        return;
    L20:
        if (significantlyOutsideCurrentBand() == false) goto L22;
        this.mInitiateStateChange = false;     // Catch: Throwable -> L31
        this.mSampleCounter = 1;     // Catch: Throwable -> L31
        this.mCurrentBandwidthConnectionQuality.set(this.mNextBandwidthConnectionQuality.get());     // Catch: Throwable -> L31
        notifyListeners();     // Catch: Throwable -> L31
        goto L22
    L25:
        if (this.mCurrentBandwidthConnectionQuality.get() == getCurrentBandwidthQuality()) goto L27;
        this.mInitiateStateChange = true;     // Catch: Throwable -> L31
        this.mNextBandwidthConnectionQuality = new AtomicReference(getCurrentBandwidthQuality());     // Catch: Throwable -> L31
    L27:
        monitor-exit(this);
    }

    private boolean significantlyOutsideCurrentBand() {
        if (this.mDownloadBandwidth != null) goto L29;
        return false;
    L29:
        ConnectionQuality r0 = this.mCurrentBandwidthConnectionQuality.get();     // Catch: Throwable -> L26
        double r3 = 28.0d;
        if (ConnectionQuality.POOR != r0) goto L8;
        double r6 = 0.0d;
    L17:
        double r8 = this.mDownloadBandwidth.getAverage();     // Catch: Throwable -> L26
        if (r8 <= r3) goto L24;
        if (r8 <= (r3 * HYSTERESIS_TOP_MULTIPLIER)) goto L28;
        return true;
    L28:
        return false;
    L24:
        if (r8 >= (r6 * 0.8d)) goto L28;
    L25:
        return true;
    L8:
        r6 = 112.0d;
        if (ConnectionQuality.MODERATE != r0) goto L11;
    L10:
        double r10 = r3;
        r3 = r6;
        r6 = r10;
        goto L17
    L11:
        r3 = 560.0d;
        if (ConnectionQuality.GOOD == r0) goto L17;
        if (ConnectionQuality.EXCELLENT != r0) goto L25;
        r6 = 3.4028234663852886E38d;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    public void reset() {
        ExponentialGeometricAverage r0 = this.mDownloadBandwidth;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.reset();     // Catch: Throwable -> L7
    L5:
        this.mCurrentBandwidthConnectionQuality.set(ConnectionQuality.UNKNOWN);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public synchronized ConnectionQuality getCurrentBandwidthQuality() {
        monitor-enter(this);
        ExponentialGeometricAverage r0 = this.mDownloadBandwidth;     // Catch: Throwable -> L15
        if (r0 != null) goto L18;
        ConnectionQuality r1 = ConnectionQuality.UNKNOWN;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L18:
        ConnectionQuality r2 = mapBandwidthQuality(r0.getAverage());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return ConnectionQuality.UNKNOWN;
    L15:
        th = move-exception;
        throw th;
    }

    private ConnectionQuality mapBandwidthQuality(double r3) {
        if (r3 >= 0.0d) goto L7;
        return ConnectionQuality.UNKNOWN;
    L7:
        if (r3 >= 28.0d) goto L11;
        return ConnectionQuality.POOR;
    L11:
        if (r3 >= 112.0d) goto L15;
        return ConnectionQuality.MODERATE;
    L15:
        if (r3 >= 560.0d) goto L19;
        return ConnectionQuality.GOOD;
    L19:
        return ConnectionQuality.EXCELLENT;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        monitor-enter(this);
        ExponentialGeometricAverage r0 = this.mDownloadBandwidth;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        double r1 = -1.0d;
    L7:
        monitor-exit(this);
        return r1;
    L6:
        r1 = r0.getAverage();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public ConnectionQuality register(ConnectionClassStateChangeListener r2) {
        if (r2 == null) goto L5;
        this.mListenerList.add(r2);
    L5:
        return this.mCurrentBandwidthConnectionQuality.get();
    }

    public void remove(ConnectionClassStateChangeListener r1) {
        if (r1 == null) goto L5;
        this.mListenerList.remove(r1);
        return;
    }

    private void notifyListeners() {
        int r0 = this.mListenerList.size();     // Catch: Throwable -> L6
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        this.mListenerList.get(r1).onBandwidthStateChange(this.mCurrentBandwidthConnectionQuality.get());     // Catch: Throwable -> L6
        r1 = r1 + 1;
        goto L3
    L12:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }
}
