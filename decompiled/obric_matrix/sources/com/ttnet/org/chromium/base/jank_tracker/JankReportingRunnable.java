package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes2.dex */
class JankReportingRunnable implements Runnable {
    private final boolean mIsStartingTracking;
    private final FrameMetricsStore mMetricsStore;
    private final int mScenario;

    JankReportingRunnable(FrameMetricsStore r1, int r2, boolean r3) {
        this.mMetricsStore = r1;
        this.mScenario = r2;
        this.mIsStartingTracking = r3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mIsStartingTracking == false) goto L5;
        this.mMetricsStore.startTrackingScenario(this.mScenario);
        return;
    L5:
        FrameMetrics r0 = this.mMetricsStore.stopTrackingScenario(this.mScenario);
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.timestampsNs.length == 0) goto L14;
        JankMetricUMARecorderJni.get();
        JankMetricUMARecorder.recordJankMetricsToUMA(JankMetricCalculator.calculateJankMetrics(r0), this.mScenario);
        return;
    }
}
