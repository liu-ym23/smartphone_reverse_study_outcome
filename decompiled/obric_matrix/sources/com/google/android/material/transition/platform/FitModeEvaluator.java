package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
interface FitModeEvaluator {
    void applyMask(RectF r1, float r2, FitModeResult r3);

    FitModeResult evaluate(float r1, float r2, float r3, float r4, float r5, float r6, float r7);

    boolean shouldMaskStartBounds(FitModeResult r1);
}
