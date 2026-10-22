package com.ttnet.org.chromium.base.jank_tracker;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.TraceEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
class JankReportingScheduler {
    private static final long PERIODIC_METRIC_DELAY_MS = 30000;
    private static final long TRACE_EVENT_TRACK_ID = 84186319646187624L;
    private final FrameMetricsStore mFrameMetricsStore;

    @Nullable
    private Handler mHandler;

    @Nullable
    protected HandlerThread mHandlerThread;
    private final AtomicBoolean mIsPeriodicReporterLooping;
    private final Runnable mPeriodicMetricReporter;

    public JankReportingScheduler(FrameMetricsStore r3) {
        this.mPeriodicMetricReporter = new AnonymousClass1(this);
        this.mIsPeriodicReporterLooping = new AtomicBoolean(false);
        this.mFrameMetricsStore = r3;
    }

    public static /* synthetic */ AtomicBoolean access$000(JankReportingScheduler r0) {
        return r0.mIsPeriodicReporterLooping;
    }

    public static /* synthetic */ Runnable access$100(JankReportingScheduler r0) {
        return r0.mPeriodicMetricReporter;
    }

    public void finishTrackingScenario(int r6) {
        TraceEvent.finishAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(r6), ((long) r6) + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, r6, false));
    }

    public Handler getOrCreateHandler() {
        if (this.mHandler != null) goto L6;
        HandlerThread r0 = new HandlerThread("Jank-Tracker");
        this.mHandlerThread = r0;
        r0.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    L6:
        return this.mHandler;
    }

    public void startReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(true) == false) goto L5;
        return;
    L5:
        startTrackingScenario(1);
        getOrCreateHandler().postDelayed(this.mPeriodicMetricReporter, 30000);
    }

    public void startTrackingScenario(int r6) {
        TraceEvent.startAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(r6), ((long) r6) + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, r6, true));
    }

    public void stopReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(false) == true) goto L5;
        return;
    L5:
        getOrCreateHandler().removeCallbacks(this.mPeriodicMetricReporter);
        getOrCreateHandler().post(this.mPeriodicMetricReporter);
    }
}
