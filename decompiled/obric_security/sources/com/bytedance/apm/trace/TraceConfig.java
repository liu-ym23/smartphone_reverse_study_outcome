package com.bytedance.apm.trace;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class TraceConfig {
    public static final String KEY_FRAGMENT_CREATE_TO_VIEW_SHOW_TIME = "fragmentOnCreateToViewShow";
    public static final String KEY_FRAGMENT_HIDECHANGED_TO_VIEW_SHOW_TIME = "fragmentOnHiddenChangedToViewShow";
    public static final String KEY_FRAGMENT_VISIBLEHINT_TO_VIEW_SHOW_TIME = "fragmentUserVisibleToViewShow";
    public static final String KEY_PAGE_LOAD_TO_VIEW_SHOW_TIME = "activityOnCreateToViewShow";
    private boolean mDropFrameReportEvilMethodSwitch;
    private int mEvilMethodThresholdMs;
    private boolean mPageAnnotationTraceTimeSwitch;
    private long maxWaitViewShowTimeMs;

    public TraceConfig() {
        this.maxWaitViewShowTimeMs = 30000;
        this.mEvilMethodThresholdMs = 1000;
    }

    public TraceConfig setAnnotationPageTimeTraceSwitch(boolean r1) {
        this.mPageAnnotationTraceTimeSwitch = r1;
        return this;
    }

    public TraceConfig setMaxWaitViewShowTime(long r1) {
        this.maxWaitViewShowTimeMs = r1;
        return this;
    }

    public TraceConfig setBlockThresholdMs(int r1) {
        this.mEvilMethodThresholdMs = r1;
        return this;
    }

    public TraceConfig setDropFrameReportStackSwitch(boolean r1) {
        this.mDropFrameReportEvilMethodSwitch = r1;
        return this;
    }

    public boolean isDropFrameReportEvilMethodSwitch() {
        return this.mDropFrameReportEvilMethodSwitch;
    }

    @Deprecated
    public TraceConfig setSwitch(boolean r1) {
        return setAnnotationPageTimeTraceSwitch(r1);
    }

    public long getMaxWaitViewShowTimeMs() {
        return this.maxWaitViewShowTimeMs;
    }

    public boolean isPageAnnotationTraceTimeSwitchOn() {
        return this.mPageAnnotationTraceTimeSwitch;
    }

    public int getEvilMethodThresholdMs() {
        return this.mEvilMethodThresholdMs;
    }
}
