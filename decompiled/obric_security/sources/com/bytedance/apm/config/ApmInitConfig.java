package com.bytedance.apm.config;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.alog.DefaultAlogUploadStrategy;
import com.bytedance.apm.alog.IAlogUploadStrategy;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchInitConfig;
import com.bytedance.apm.trace.ITraceListener;

/* JADX INFO: loaded from: classes.dex */
public class ApmInitConfig {
    private boolean isReportCacheException;
    private boolean mActivityFps;
    private ActivityLeakDetectConfig mActivityLeakDetectConfig;
    private IAlogUploadStrategy mAlogUploadStrategy;
    private boolean mBinderMonitor;
    private int mCacheBufferCount;
    private boolean mChangeFpsLifeCycle;
    private boolean mDisableFpsTracer;
    private boolean mEnableCpuAllocOpt;
    private boolean mEnableDeviceInfoOnPerfData;
    private boolean mEnableLooperOpt;
    private boolean mEnableSliverDump;
    private long mEvilMethodThresholdMs;
    private boolean mFullFpsTracer;
    private String mIgnoreNetMonitorUserAgentLabel;
    private LaunchInitConfig mLaunchConfig;
    private boolean mLimitEvilMethodDepth;
    private long mMaxValidLaunchTimeMs;
    private long mMaxValidPageLoadTimeMs;
    private String mProcessName;
    private boolean mReportEvilMethodSwitch;
    private boolean mSupportMultiFrameRate;
    private long mTraceExtraCollectTimeMs;
    private int mTraceExtraFlag;
    private ITraceListener mTraceListener;
    private boolean mViewIdmonitorPageSwitch;

    /* JADX INFO: renamed from: com.bytedance.apm.config.ApmInitConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private boolean activityFps;
        private ActivityLeakDetectConfig activityLeakDetectConfig;
        private boolean binderMonitor;
        private int cacheBufferCount;
        private boolean changeFpsLifeCycle;
        private boolean debugMode;
        private boolean disableFpsTracer;
        private boolean enableCpuAllocOpt;
        private boolean enableDeviceInfoOnPerfData;
        private boolean enableLooperOpt;
        private boolean enableSliverDump;
        private long evilMethodThresholdMs;
        private boolean fullFpsTracer;
        private String ignoreNetMonitorUserAgentLabel;
        private boolean isInternalTest;
        private boolean isReportCacheException;
        private long launchExtraInfoCollectTimeMs;
        private int launchExtraInfoFlag;
        private boolean limitEvilMethodDepth;
        private IAlogUploadStrategy mAlogUploadStrategy;
        private LaunchInitConfig mLaunchConfig;
        private long maxLaunchTimeMs;
        private long maxPageLoadTimeMs;
        private String processName;
        private boolean reportEvilMethodSwitch;
        private boolean supportMultiFrameRate;
        private ITraceListener traceListener;
        private boolean viewIdMonitorPageSwitch;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ int access$100(Builder r0) {
            return r0.cacheBufferCount;
        }

        static /* synthetic */ boolean access$1000(Builder r0) {
            return r0.disableFpsTracer;
        }

        static /* synthetic */ boolean access$1100(Builder r0) {
            return r0.changeFpsLifeCycle;
        }

        static /* synthetic */ boolean access$1200(Builder r0) {
            return r0.activityFps;
        }

        static /* synthetic */ boolean access$1300(Builder r0) {
            return r0.binderMonitor;
        }

        static /* synthetic */ long access$1400(Builder r2) {
            return r2.launchExtraInfoCollectTimeMs;
        }

        static /* synthetic */ int access$1500(Builder r0) {
            return r0.launchExtraInfoFlag;
        }

        static /* synthetic */ String access$1600(Builder r0) {
            return r0.ignoreNetMonitorUserAgentLabel;
        }

        static /* synthetic */ String access$1700(Builder r0) {
            return r0.processName;
        }

        static /* synthetic */ ActivityLeakDetectConfig access$1800(Builder r0) {
            return r0.activityLeakDetectConfig;
        }

        static /* synthetic */ LaunchInitConfig access$1900(Builder r0) {
            return r0.mLaunchConfig;
        }

        static /* synthetic */ boolean access$200(Builder r0) {
            return r0.viewIdMonitorPageSwitch;
        }

        static /* synthetic */ boolean access$2000(Builder r0) {
            return r0.supportMultiFrameRate;
        }

        static /* synthetic */ boolean access$2100(Builder r0) {
            return r0.debugMode;
        }

        static /* synthetic */ boolean access$2200(Builder r0) {
            return r0.isInternalTest;
        }

        static /* synthetic */ boolean access$2300(Builder r0) {
            return r0.enableDeviceInfoOnPerfData;
        }

        static /* synthetic */ IAlogUploadStrategy access$2400(Builder r0) {
            return r0.mAlogUploadStrategy;
        }

        static /* synthetic */ boolean access$2500(Builder r0) {
            return r0.isReportCacheException;
        }

        static /* synthetic */ boolean access$2600(Builder r0) {
            return r0.enableSliverDump;
        }

        static /* synthetic */ boolean access$2700(Builder r0) {
            return r0.enableCpuAllocOpt;
        }

        static /* synthetic */ boolean access$2800(Builder r0) {
            return r0.enableLooperOpt;
        }

        static /* synthetic */ long access$300(Builder r2) {
            return r2.maxPageLoadTimeMs;
        }

        static /* synthetic */ long access$400(Builder r2) {
            return r2.maxLaunchTimeMs;
        }

        static /* synthetic */ ITraceListener access$500(Builder r0) {
            return r0.traceListener;
        }

        static /* synthetic */ boolean access$600(Builder r0) {
            return r0.reportEvilMethodSwitch;
        }

        static /* synthetic */ long access$700(Builder r2) {
            return r2.evilMethodThresholdMs;
        }

        static /* synthetic */ boolean access$800(Builder r0) {
            return r0.limitEvilMethodDepth;
        }

        static /* synthetic */ boolean access$900(Builder r0) {
            return r0.fullFpsTracer;
        }

        private Builder() {
            this.disableFpsTracer = false;
            this.changeFpsLifeCycle = false;
            this.activityFps = false;
            this.enableDeviceInfoOnPerfData = false;
            this.cacheBufferCount = 1000;
            this.viewIdMonitorPageSwitch = false;
            this.maxPageLoadTimeMs = TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS;
            this.maxLaunchTimeMs = 15000;
            this.reportEvilMethodSwitch = false;
            this.evilMethodThresholdMs = 1000;
            this.launchExtraInfoFlag = 0;
            this.launchExtraInfoCollectTimeMs = 30000;
            this.mAlogUploadStrategy = new DefaultAlogUploadStrategy();
        }

        public Builder launchInitConfig(LaunchInitConfig r1) {
            this.mLaunchConfig = r1;
            return this;
        }

        public Builder cacheBufferCount(int r1) {
            this.cacheBufferCount = r1;
            return this;
        }

        public Builder reportCacheExceptionEnable(boolean r1) {
            this.isReportCacheException = r1;
            return this;
        }

        public Builder viewIdMonitorPageSwitch(boolean r1) {
            this.viewIdMonitorPageSwitch = r1;
            return this;
        }

        public Builder detectActivityLeak(ActivityLeakDetectConfig r1) {
            this.activityLeakDetectConfig = r1;
            return this;
        }

        public Builder maxValidPageLoadTimeMs(long r1) {
            this.maxPageLoadTimeMs = r1;
            return this;
        }

        public Builder maxValidLaunchTimeMs(long r1) {
            this.maxLaunchTimeMs = r1;
            return this;
        }

        public Builder reportEvilMethodSwitch(boolean r1) {
            this.reportEvilMethodSwitch = r1;
            return this;
        }

        public Builder pageTraceListener(ITraceListener r1) {
            this.traceListener = r1;
            return this;
        }

        public Builder evilMethodThresholdMs(long r1) {
            this.evilMethodThresholdMs = r1;
            return this;
        }

        public Builder limitEvilMethodDepth(boolean r1) {
            this.limitEvilMethodDepth = r1;
            return this;
        }

        public Builder fullFpsTracer(boolean r1) {
            this.fullFpsTracer = r1;
            return this;
        }

        public Builder diableFpsTracer(boolean r1) {
            this.disableFpsTracer = r1;
            return this;
        }

        public Builder changeFpsLifeCycle(boolean r1) {
            this.changeFpsLifeCycle = r1;
            return this;
        }

        public Builder enableCpuAllocOpt(boolean r1) {
            this.enableCpuAllocOpt = r1;
            return this;
        }

        public Builder enableLooperOpt(boolean r1) {
            this.enableLooperOpt = r1;
            return this;
        }

        public Builder enableActivityFps(boolean r1) {
            this.activityFps = r1;
            return this;
        }

        public Builder binderMonitor(boolean r1) {
            this.binderMonitor = r1;
            return this;
        }

        @Deprecated
        public Builder traceExtraFlag(int r1) {
            this.launchExtraInfoFlag = r1;
            return this;
        }

        @Deprecated
        public Builder traceExtraCollectTimeMs(long r1) {
            this.launchExtraInfoCollectTimeMs = r1;
            return this;
        }

        public Builder ignoreNetMonitorUserAgentLabel(String r1) {
            this.ignoreNetMonitorUserAgentLabel = r1;
            return this;
        }

        public Builder processName(String r1) {
            this.processName = r1;
            return this;
        }

        public Builder debugMode(boolean r1) {
            this.debugMode = r1;
            return this;
        }

        public boolean isInternalTest() {
            return this.isInternalTest;
        }

        public Builder setInternalTest(boolean r1) {
            this.isInternalTest = r1;
            return this;
        }

        public Builder enableDeviceInfoOnPerfData(boolean r1) {
            this.enableDeviceInfoOnPerfData = r1;
            return this;
        }

        public Builder supportMultiFrameRate(boolean r1) {
            this.supportMultiFrameRate = r1;
            return this;
        }

        public Builder setAlogUploadStrategy(IAlogUploadStrategy r1) {
            this.mAlogUploadStrategy = r1;
            return this;
        }

        public Builder enableSliverDump(boolean r1) {
            this.enableSliverDump = r1;
            return this;
        }

        public ApmInitConfig build() {
            return new ApmInitConfig(this);
        }

        public boolean isEnableCpuAllocOpt() {
            return this.enableCpuAllocOpt;
        }

        public void setEnableCpuAllocOpt(boolean r1) {
            this.enableCpuAllocOpt = r1;
        }
    }

    public int getCacheBufferCount() {
        return this.mCacheBufferCount;
    }

    public boolean isViewIdmonitorPageSwitch() {
        return this.mViewIdmonitorPageSwitch;
    }

    public long getMaxValidPageLoadTimeMs() {
        return this.mMaxValidPageLoadTimeMs;
    }

    public ITraceListener getTraceListener() {
        return this.mTraceListener;
    }

    public boolean isReportEvilMethodSwitch() {
        return this.mReportEvilMethodSwitch;
    }

    public long getEvilMethodThresholdMs() {
        return this.mEvilMethodThresholdMs;
    }

    public boolean isLimitEvilMethodDepth() {
        return this.mLimitEvilMethodDepth;
    }

    public boolean isFullFpsTracer() {
        return this.mFullFpsTracer;
    }

    public boolean isDisableFpsTracer() {
        return this.mDisableFpsTracer;
    }

    public boolean isChangeFpsLifeCyclesTracer() {
        return this.mChangeFpsLifeCycle;
    }

    public boolean isEnableCpuAllocOpt() {
        return this.mEnableCpuAllocOpt;
    }

    public boolean isEnableLooperOpt() {
        return this.mEnableLooperOpt;
    }

    public boolean isActivityFps() {
        return this.mActivityFps;
    }

    public boolean isEnableBinderMonitor() {
        return this.mBinderMonitor;
    }

    public ActivityLeakDetectConfig getActivityLeakDetectConfig() {
        return this.mActivityLeakDetectConfig;
    }

    public void setCacheBufferCount(int r1) {
        this.mCacheBufferCount = r1;
    }

    public void setViewIdmonitorPageSwitch(boolean r1) {
        this.mViewIdmonitorPageSwitch = r1;
    }

    public void setMaxValidPageLoadTimeMs(long r1) {
        this.mMaxValidPageLoadTimeMs = r1;
    }

    public long getMaxValidLaunchTimeMs() {
        return this.mMaxValidLaunchTimeMs;
    }

    public void setTraceListener(ITraceListener r1) {
        this.mTraceListener = r1;
    }

    public void setReportEvilMethodSwitch(boolean r1) {
        this.mReportEvilMethodSwitch = r1;
    }

    public void setEvilMethodThresholdMs(long r1) {
        this.mEvilMethodThresholdMs = r1;
    }

    public String getIgnoreNetMonitorUserAgentLabel() {
        return this.mIgnoreNetMonitorUserAgentLabel;
    }

    public int getTraceExtraFlag() {
        return this.mTraceExtraFlag;
    }

    public long getTraceExtraCollectTimeMs() {
        long r0 = LaunchAnalysisContext.getInstance().getConfig().getMaxCollectTimeMs();
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return this.mTraceExtraCollectTimeMs;
    }

    public boolean isReportCacheException() {
        return this.isReportCacheException;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public LaunchInitConfig getLaunchConfig() {
        if (this.mLaunchConfig != null) goto L6;
        this.mLaunchConfig = new LaunchInitConfig.Builder().build();
    L6:
        return this.mLaunchConfig;
    }

    public IAlogUploadStrategy getAlogUploadStrategy() {
        return this.mAlogUploadStrategy;
    }

    public boolean supportMultiFrameRate() {
        return this.mSupportMultiFrameRate;
    }

    public boolean isDeviceInfoOnPerfDataEnabled() {
        return this.mEnableDeviceInfoOnPerfData;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public ApmInitConfig(Builder r3) {
        this.mCacheBufferCount = Builder.access$100(r3);
        this.mViewIdmonitorPageSwitch = Builder.access$200(r3);
        this.mMaxValidPageLoadTimeMs = Builder.access$300(r3);
        this.mMaxValidLaunchTimeMs = Builder.access$400(r3);
        this.mTraceListener = Builder.access$500(r3);
        this.mReportEvilMethodSwitch = Builder.access$600(r3);
        this.mEvilMethodThresholdMs = Builder.access$700(r3);
        this.mLimitEvilMethodDepth = Builder.access$800(r3);
        this.mFullFpsTracer = Builder.access$900(r3);
        this.mDisableFpsTracer = Builder.access$1000(r3);
        this.mChangeFpsLifeCycle = Builder.access$1100(r3);
        this.mActivityFps = Builder.access$1200(r3);
        this.mBinderMonitor = Builder.access$1300(r3);
        this.mTraceExtraCollectTimeMs = Builder.access$1400(r3);
        this.mTraceExtraFlag = Builder.access$1500(r3);
        this.mIgnoreNetMonitorUserAgentLabel = Builder.access$1600(r3);
        this.mProcessName = Builder.access$1700(r3);
        this.mActivityLeakDetectConfig = Builder.access$1800(r3);
        this.mLaunchConfig = Builder.access$1900(r3);
        this.mSupportMultiFrameRate = Builder.access$2000(r3);
        ApmContext.setDebugMode(Builder.access$2100(r3));
        ApmContext.setInternalTest(Builder.access$2200(r3));
        this.mEnableDeviceInfoOnPerfData = Builder.access$2300(r3);
        this.mAlogUploadStrategy = Builder.access$2400(r3);
        this.isReportCacheException = Builder.access$2500(r3);
        this.mEnableSliverDump = Builder.access$2600(r3);
        this.mEnableCpuAllocOpt = Builder.access$2700(r3);
        this.mEnableLooperOpt = Builder.access$2800(r3);
    }

    public boolean isEnableSliverDump() {
        return this.mEnableSliverDump;
    }
}
