package com.bytedance.apm.block;

import android.view.FrameMetrics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsLooperObserver {
    private boolean isDispatchBegin;

    public void doFrame(String r1, long r2, long r4) {
    }

    public void onFrameMetricsAvailable(String r1, long r2, int r4) {
    }

    public void onFrameMetricsAvailable(String r1, FrameMetrics r2, int r3) {
    }

    public AbsLooperObserver() {
        this.isDispatchBegin = false;
    }

    public void dispatchBegin(String r1) {
        this.isDispatchBegin = true;
    }

    public void dispatchEnd(long r1, long r3, long r5, long r7, boolean r9) {
        this.isDispatchBegin = false;
    }

    public boolean isDispatchBegin() {
        return this.isDispatchBegin;
    }
}
