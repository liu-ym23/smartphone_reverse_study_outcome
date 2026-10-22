package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    public DrawingDelegate(S r1) {
        this.spec = r1;
    }

    abstract void adjustCanvas(@NonNull Canvas r1, @FloatRange(from = 0.0d, to = 1.0d) float r2);

    abstract void fillIndicator(@NonNull Canvas r1, @NonNull Paint r2, @FloatRange(from = 0.0d, to = 1.0d) float r3, @FloatRange(from = 0.0d, to = 1.0d) float r4, @ColorInt int r5);

    abstract void fillTrack(@NonNull Canvas r1, @NonNull Paint r2);

    abstract int getPreferredHeight();

    abstract int getPreferredWidth();

    protected void registerDrawable(@NonNull DrawableWithAnimatedVisibilityChange r1) {
        this.drawable = r1;
    }

    void validateSpecAndAdjustCanvas(@NonNull Canvas r2, @FloatRange(from = 0.0d, to = 1.0d) float r3) {
        this.spec.validateSpec();
        adjustCanvas(r2, r3);
    }
}
