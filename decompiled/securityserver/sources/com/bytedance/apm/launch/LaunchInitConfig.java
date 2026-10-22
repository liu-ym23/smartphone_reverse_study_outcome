package com.bytedance.apm.launch;

/* JADX INFO: loaded from: classes.dex */
public class LaunchInitConfig {
    private long maxCollectTimeMs;
    private boolean needCollectDeviceInfo;
    private boolean needCollectNetData;
    private boolean needCollectPerfData;
    private boolean needCollectSlowLaunchTrace;
    private boolean needCollectTimingTrace;
    private long slowLaunchThreshold;

    public static class Builder {
        private static final long DEFAULT_SLOW_LAUNCH_THRESHOLD_MS = 1000;
        private long maxCollectTimeMs;
        private boolean needCollectDeviceInfo;
        private boolean needCollectNetData;
        private boolean needCollectPerfData;
        private boolean needCollectSlowLaunchTrace;
        private boolean needCollectTimingTrace;
        private long slowLaunchThreshold;

        public Builder() {
            this.needCollectPerfData = false;
            this.needCollectNetData = false;
            this.needCollectTimingTrace = false;
            this.needCollectDeviceInfo = false;
            this.needCollectSlowLaunchTrace = false;
            this.maxCollectTimeMs = -1;
            this.slowLaunchThreshold = 1000;
        }

        public LaunchInitConfig build() {
            return new LaunchInitConfig(this.needCollectPerfData, this.needCollectNetData, this.needCollectTimingTrace, this.maxCollectTimeMs, this.needCollectDeviceInfo, this.slowLaunchThreshold, this.needCollectSlowLaunchTrace);
        }

        public Builder collectDeviceInfo() {
            this.needCollectDeviceInfo = true;
            return this;
        }

        public Builder collectNetData() {
            this.needCollectNetData = true;
            return this;
        }

        public Builder collectPerfData() {
            this.needCollectPerfData = true;
            return this;
        }

        public Builder collectSlowLaunchTrace() {
            this.needCollectSlowLaunchTrace = true;
            return this;
        }

        public Builder collectTimingTrace() {
            this.needCollectTimingTrace = true;
            return this;
        }

        public Builder setMaxCollectTimeMs(long r1) {
            this.maxCollectTimeMs = r1;
            return this;
        }

        public Builder setSlowLaunchThreshold(long r1) {
            this.slowLaunchThreshold = r1;
            return this;
        }
    }

    public LaunchInitConfig(boolean r1, boolean r2, boolean r3, long r4, boolean r6, long r7, boolean r9) {
        this.needCollectPerfData = r1;
        this.needCollectNetData = r2;
        this.needCollectTimingTrace = r3;
        this.maxCollectTimeMs = r4;
        this.needCollectDeviceInfo = r6;
        this.slowLaunchThreshold = r7;
        this.needCollectSlowLaunchTrace = r9;
    }

    public long getMaxCollectTimeMs() {
        return this.maxCollectTimeMs;
    }

    public long getSlowLaunchThreshold() {
        return this.slowLaunchThreshold;
    }

    public boolean isNeedCollectDeviceInfo() {
        return this.needCollectDeviceInfo;
    }

    public boolean isNeedCollectNetData() {
        return this.needCollectNetData;
    }

    public boolean isNeedCollectPerfData() {
        return this.needCollectPerfData;
    }

    public boolean isNeedCollectSlowLaunchTrace() {
        return this.needCollectSlowLaunchTrace;
    }

    public boolean isNeedCollectTimingTrace() {
        return this.needCollectTimingTrace;
    }
}
