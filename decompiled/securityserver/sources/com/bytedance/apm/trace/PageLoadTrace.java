package com.bytedance.apm.trace;

/* JADX INFO: loaded from: classes.dex */
public final class PageLoadTrace {
    private static final String TAG = "PageLoadTrace";
    private String mPageName;
    private int mPageType;
    private TraceStats mTraceStats;

    public PageLoadTrace(String r2) {
        this(r2, 1);
    }

    public void cancelTrace() {
        TraceStats r0 = this.mTraceStats;
        if (r0 == null) goto L6;
        r0.cancelTrace();
        this.mTraceStats = null;
        return;
    }

    public void endSpan(String r2) {
        TraceStats r1 = this.mTraceStats;
        if (r1 == null) goto L6;
        r1.endSpan("", r2);
        return;
    }

    public void endTrace(int r2, long r3) {
        TraceStats r0 = this.mTraceStats;
        if (r0 == null) goto L6;
        r0.endTrace(r2, this.mPageName, r3);
        return;
    }

    public void startSpan(String r2) {
        TraceStats r1 = this.mTraceStats;
        if (r1 == null) goto L6;
        r1.startSpan("", r2);
        return;
    }

    public void startTrace() {
        if (this.mPageType != 1) goto L5;
        String r1 = "activity";
    L6:
        TraceStats r0 = new TraceStats("page_load_trace", r1);
        this.mTraceStats = r0;
        r0.startTrace();
        return;
    L5:
        r1 = "fragment";
        goto L6
    }

    public PageLoadTrace(String r1, int r2) {
        this.mPageName = r1;
        this.mPageType = r2;
    }
}
