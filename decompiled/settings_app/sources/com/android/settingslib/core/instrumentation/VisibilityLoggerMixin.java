package com.android.settingslib.core.instrumentation;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnAttach;

/* JADX INFO: loaded from: classes.dex */
public class VisibilityLoggerMixin implements LifecycleObserver, OnAttach {
    private static final String TAG = "VisibilityLoggerMixin";
    private long mCreationTimestamp;
    private final int mMetricsCategory;
    private MetricsFeatureProvider mMetricsFeature;
    private int mSourceMetricsCategory;
    private long mVisibleTimestamp;

    public VisibilityLoggerMixin(int r2, MetricsFeatureProvider r3) {
        this.mSourceMetricsCategory = 0;
        this.mMetricsCategory = r2;
        this.mMetricsFeature = r3;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnAttach
    public void onAttach() {
        this.mCreationTimestamp = SystemClock.elapsedRealtime();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        if (this.mMetricsFeature != null) goto L5;
        return;
    L5:
        if (this.mMetricsCategory == 0) goto L14;
        long r0 = SystemClock.elapsedRealtime();
        this.mVisibleTimestamp = r0;
        long r2 = this.mCreationTimestamp;
        if (r2 == 0) goto L10;
        int r1 = (int) (r0 - r2);
        this.mMetricsFeature.visible(null, this.mSourceMetricsCategory, this.mMetricsCategory, r1);
        return;
    L10:
        this.mMetricsFeature.visible(null, this.mSourceMetricsCategory, this.mMetricsCategory, 0);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.mCreationTimestamp = 0;
        if (this.mMetricsFeature != null) goto L5;
        return;
    L5:
        if (this.mMetricsCategory == 0) goto L9;
        int r0 = (int) (SystemClock.elapsedRealtime() - this.mVisibleTimestamp);
        this.mMetricsFeature.hidden(null, this.mMetricsCategory, r0);
        return;
    }

    public void writeElapsedTimeMetric(int r9, String r10) {
        if (this.mMetricsFeature != null) goto L5;
        return;
    L5:
        if (this.mMetricsCategory != 0) goto L8;
        return;
    L8:
        if (this.mCreationTimestamp == 0) goto L12;
        int r7 = (int) (SystemClock.elapsedRealtime() - this.mCreationTimestamp);
        this.mMetricsFeature.action(0, r9, this.mMetricsCategory, r10, r7);
        return;
    }

    public void setSourceMetricsCategory(Activity r3) {
        if (this.mSourceMetricsCategory != 0) goto L11;
        if (r3 == null) goto L12;
        Intent r4 = r3.getIntent();
        if (r4 != null) goto L9;
        return;
    L9:
        this.mSourceMetricsCategory = r4.getIntExtra(MetricsFeatureProvider.EXTRA_SOURCE_METRICS_CATEGORY, 0);
        return;
    L12:
        return;
    }
}
