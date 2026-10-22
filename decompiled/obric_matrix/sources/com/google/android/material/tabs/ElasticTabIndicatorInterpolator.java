package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes2.dex */
class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    ElasticTabIndicatorInterpolator() {
    }

    private static float accInterp(@FloatRange(from = 0.0d, to = 1.0d) float r4) {
        return (float) (1.0d - Math.cos((((double) r4) * 3.141592653589793d) / 2.0d));
    }

    private static float decInterp(@FloatRange(from = 0.0d, to = 1.0d) float r4) {
        return (float) Math.sin((((double) r4) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    void setIndicatorBoundsForOffset(TabLayout r2, View r3, View r4, float r5, @NonNull Drawable r6) {
        RectF r1 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(r2, r3);
        RectF r7 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(r2, r4);
        if (r1.left >= r7.left) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        float r9 = accInterp(r5);
        float r10 = decInterp(r5);
    L9:
        r6.setBounds(AnimationUtils.lerp((int) r1.left, (int) r7.left, r9), r6.getBounds().top, AnimationUtils.lerp((int) r1.right, (int) r7.right, r10), r6.getBounds().bottom);
        return;
    L8:
        r9 = decInterp(r5);
        r10 = accInterp(r5);
        goto L9
    L5:
        r8 = false;
        goto L6
    }
}
