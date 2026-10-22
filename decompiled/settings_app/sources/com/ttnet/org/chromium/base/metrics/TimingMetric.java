package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class TimingMetric implements AutoCloseable {
    private final String mMetricName;
    private long mStartTime;
    private final int mTimerType;

    @Retention(RetentionPolicy.SOURCE)
    private @interface TimerType {
        public static final int MEDIUM_UPTIME = 1;
        public static final int SHORT_THREAD_TIME = 2;
        public static final int SHORT_UPTIME = 0;
    }

    public static TimingMetric shortUptime(String r3) {
        TimingMetric r0 = new TimingMetric(r3, 0);
        r0.mStartTime = TimeUtils.uptimeMillis();
        return r0;
    }

    public static TimingMetric mediumUptime(String r3) {
        TimingMetric r0 = new TimingMetric(r3, 1);
        r0.mStartTime = TimeUtils.uptimeMillis();
        return r0;
    }

    public static TimingMetric shortThreadTime(String r3) {
        TimingMetric r0 = new TimingMetric(r3, 2);
        r0.mStartTime = TimeUtils.currentThreadTimeMillis();
        return r0;
    }

    private TimingMetric(String r1, int r2) {
        this.mMetricName = r1;
        this.mTimerType = r2;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        String r0 = this.mMetricName;
        long r1 = this.mStartTime;
        if (r1 != 0) goto L5;
        return;
    L5:
        this.mStartTime = 0;
        int r6 = this.mTimerType;
        if (r6 != 0) goto L8;
        RecordHistogram.recordTimesHistogram(r0, TimeUtils.uptimeMillis() - r1);
        return;
    L8:
        if (r6 != 1) goto L10;
        RecordHistogram.recordMediumTimesHistogram(r0, TimeUtils.uptimeMillis() - r1);
        return;
    L10:
        if (r6 != 2) goto L18;
        RecordHistogram.recordTimesHistogram(r0, TimeUtils.currentThreadTimeMillis() - r1);
        return;
    }
}
