package com.bytedance.apm.block;

import android.view.FrameMetrics;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsLooperObserver {
    private boolean isDispatchBegin;

    public AbsLooperObserver() {
        this.isDispatchBegin = false;
    }

    @CallSuper
    public void dispatchBegin(String r1) {
        this.isDispatchBegin = true;
    }

    @CallSuper
    public void dispatchEnd(long r1, long r3, long r5, long r7, boolean r9) {
        this.isDispatchBegin = false;
    }

    public void doFrame(String r1, long r2, long r4) {
    }

    public boolean isDispatchBegin() {
        return this.isDispatchBegin;
    }

    public void onFrameMetricsAvailable(String r1, long r2, int r4) {
    }

    public void onFrameMetricsAvailable(String r1, FrameMetrics r2, int r3) {
    }
}
