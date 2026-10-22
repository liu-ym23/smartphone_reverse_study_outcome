package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 24)
class JankActivityTracker implements ApplicationStatus.ActivityStateListener {
    private WeakReference<Activity> mActivityReference;
    private final DestroyChecker mDestroyChecker;
    private final FrameMetricsListener mFrameMetricsListener;
    private final JankReportingScheduler mReportingScheduler;
    private final ThreadUtils.ThreadChecker mThreadChecker;

    public JankActivityTracker(Activity r2, FrameMetricsListener r3, JankReportingScheduler r4) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mActivityReference = new WeakReference(r2);
        this.mFrameMetricsListener = r3;
        this.mReportingScheduler = r4;
    }

    private void assertValidState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }

    private void startMetricRecording() {
        assertValidState();
        this.mFrameMetricsListener.setIsListenerRecording(true);
    }

    private void startReportingTimer() {
        assertValidState();
        this.mReportingScheduler.startReportingPeriodicMetrics();
    }

    private void stopMetricRecording() {
        assertValidState();
        this.mFrameMetricsListener.setIsListenerRecording(false);
    }

    private void stopReportingTimer() {
        assertValidState();
        this.mReportingScheduler.stopReportingPeriodicMetrics();
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        ApplicationStatus.unregisterActivityStateListener(this);
        stopMetricRecording();
        stopReportingTimer();
        Activity r0 = this.mActivityReference.get();
        if (r0 == null) goto L5;
        r0.getWindow().removeOnFrameMetricsAvailableListener(this.mFrameMetricsListener);
    L5:
        this.mDestroyChecker.destroy();
    }

    public void initialize() {
        assertValidState();
        Activity r0 = this.mActivityReference.get();
        if (r0 == null) goto L6;
        ApplicationStatus.registerStateListenerForActivity(this, r0);
        onActivityStateChange(r0, ApplicationStatus.getStateForActivity(r0));
        r0.getWindow().addOnFrameMetricsAvailableListener(this.mFrameMetricsListener, this.mReportingScheduler.getOrCreateHandler());
        return;
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ActivityStateListener
    public void onActivityStateChange(Activity r1, int r2) {
        assertValidState();
        if (r2 != 2) goto L5;
    L13:
        startReportingTimer();
        startMetricRecording();
        return;
    L5:
        if (r2 == 3) goto L13;
        if (r2 != 4) goto L9;
        startReportingTimer();
        stopMetricRecording();
        return;
    L9:
        if (r2 != 5) goto L17;
        stopMetricRecording();
        stopReportingTimer();
        return;
    }
}
