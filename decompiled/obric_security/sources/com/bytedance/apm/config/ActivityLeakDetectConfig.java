package com.bytedance.apm.config;

import com.bytedance.apm.perf.memory.IActivityLeakListener;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLeakDetectConfig {
    private IActivityLeakListener mActivityLeakListener;
    private boolean mIsGcDetect;
    private boolean mReportActivityLeakEvent;
    private boolean mUnbindActivityLeakSwitch;
    private long mWaitDetectActivityTimeMs;

    /* JADX INFO: renamed from: com.bytedance.apm.config.ActivityLeakDetectConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private IActivityLeakListener activityLeakListener;
        private boolean gcDetectActivityLeak;
        private boolean reportActivityLeakEvent;
        private boolean unbindActivityLeakSwitch;
        private long waitDetectActivityTimeMs;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean access$100(Builder r0) {
            return r0.gcDetectActivityLeak;
        }

        static /* synthetic */ long access$200(Builder r2) {
            return r2.waitDetectActivityTimeMs;
        }

        static /* synthetic */ boolean access$300(Builder r0) {
            return r0.reportActivityLeakEvent;
        }

        static /* synthetic */ boolean access$400(Builder r0) {
            return r0.unbindActivityLeakSwitch;
        }

        static /* synthetic */ IActivityLeakListener access$500(Builder r0) {
            return r0.activityLeakListener;
        }

        private Builder() {
            this.gcDetectActivityLeak = false;
            this.waitDetectActivityTimeMs = 60000;
            this.reportActivityLeakEvent = false;
            this.unbindActivityLeakSwitch = true;
        }

        public Builder gcDetectActivityLeak(boolean r1) {
            this.gcDetectActivityLeak = r1;
            return this;
        }

        public Builder waitDetectActivityTimeMs(long r1) {
            this.waitDetectActivityTimeMs = r1;
            return this;
        }

        public Builder reportActivityLeakEvent(boolean r1) {
            this.reportActivityLeakEvent = r1;
            return this;
        }

        public Builder unbindActivityLeakSwitch(boolean r1) {
            this.unbindActivityLeakSwitch = r1;
            return this;
        }

        public Builder activityLeakListener(IActivityLeakListener r1) {
            this.activityLeakListener = r1;
            return this;
        }

        public ActivityLeakDetectConfig build() {
            return new ActivityLeakDetectConfig(this);
        }
    }

    public boolean isGcDetect() {
        return this.mIsGcDetect;
    }

    public long getWaitDetectActivityTimeMs() {
        return this.mWaitDetectActivityTimeMs;
    }

    public boolean isReportActivityLeakEvent() {
        return this.mReportActivityLeakEvent;
    }

    public boolean isUnbindActivityLeak() {
        return this.mUnbindActivityLeakSwitch;
    }

    public IActivityLeakListener getActivityLeakListener() {
        return this.mActivityLeakListener;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public ActivityLeakDetectConfig(Builder r3) {
        this.mIsGcDetect = Builder.access$100(r3);
        this.mWaitDetectActivityTimeMs = Builder.access$200(r3);
        this.mReportActivityLeakEvent = Builder.access$300(r3);
        this.mUnbindActivityLeakSwitch = Builder.access$400(r3);
        this.mActivityLeakListener = Builder.access$500(r3);
    }
}
