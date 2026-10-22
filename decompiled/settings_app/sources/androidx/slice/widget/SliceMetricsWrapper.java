package androidx.slice.widget;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
class SliceMetricsWrapper extends SliceMetrics {
    private final android.app.slice.SliceMetrics mSliceMetrics;

    SliceMetricsWrapper(Context r2, Uri r3) {
        this.mSliceMetrics = new android.app.slice.SliceMetrics(r2, r3);
    }

    @Override // androidx.slice.widget.SliceMetrics
    protected void logVisible() {
        this.mSliceMetrics.logVisible();
    }

    @Override // androidx.slice.widget.SliceMetrics
    protected void logHidden() {
        this.mSliceMetrics.logHidden();
    }

    @Override // androidx.slice.widget.SliceMetrics
    protected void logTouch(int r1, Uri r2) {
        this.mSliceMetrics.logTouch(r1, r2);
    }
}
