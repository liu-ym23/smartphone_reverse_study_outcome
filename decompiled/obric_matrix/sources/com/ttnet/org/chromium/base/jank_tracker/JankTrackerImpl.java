package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class JankTrackerImpl implements JankTracker {
    private static final boolean IS_TRACKING_ENABLED = false;
    private final JankActivityTracker mActivityTracker;
    private final JankReportingScheduler mReportingScheduler;

    static {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r0 = true;
    L6:
        IS_TRACKING_ENABLED = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public JankTrackerImpl(Activity r4) {
        if (IS_TRACKING_ENABLED == true) goto L6;
        this.mActivityTracker = null;
        this.mReportingScheduler = null;
        return;
    L6:
        FrameMetricsStore r0 = new FrameMetricsStore();
        FrameMetricsListener r1 = new FrameMetricsListener(r0);
        JankReportingScheduler r2 = new JankReportingScheduler(r0);
        this.mReportingScheduler = r2;
        JankActivityTracker r3 = new JankActivityTracker(r4, r1, r2);
        this.mActivityTracker = r3;
        r3.initialize();
    }

    public void destroy() {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mActivityTracker.destroy();
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void finishTrackingScenario(int r2) {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mReportingScheduler.finishTrackingScenario(r2);
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void startTrackingScenario(int r2) {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mReportingScheduler.startTrackingScenario(r2);
    }
}
