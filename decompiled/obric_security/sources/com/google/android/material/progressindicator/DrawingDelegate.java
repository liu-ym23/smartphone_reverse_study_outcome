package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    abstract void adjustCanvas(Canvas r1, float r2);

    abstract void fillIndicator(Canvas r1, Paint r2, float r3, float r4, int r5);

    abstract void fillTrack(Canvas r1, Paint r2);

    abstract int getPreferredHeight();

    abstract int getPreferredWidth();

    public DrawingDelegate(S r1) {
        this.spec = r1;
    }

    protected void registerDrawable(DrawableWithAnimatedVisibilityChange r1) {
        this.drawable = r1;
    }

    void validateSpecAndAdjustCanvas(Canvas r2, float r3) {
        this.spec.validateSpec();
        adjustCanvas(r2, r3);
    }
}
