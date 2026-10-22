package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes3.dex */
class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static final float FADE_THRESHOLD = 0.5f;

    FadeTabIndicatorInterpolator() {
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    void updateIndicatorForOffset(TabLayout r2, View r3, View r4, float r5, Drawable r6) {
        if (r5 < 0.5f) goto L6;
        r3 = r4;
    L6:
        RectF r7 = calculateIndicatorWidthForTab(r2, r3);
        if (r5 >= 0.5f) goto L9;
        float r1 = AnimationUtils.lerp(1.0f, 0.0f, 0.0f, 0.5f, r5);
    L10:
        r6.setBounds((int) r7.left, r6.getBounds().top, (int) r7.right, r6.getBounds().bottom);
        r6.setAlpha((int) (r1 * 255.0f));
        return;
    L9:
        r1 = AnimationUtils.lerp(0.0f, 1.0f, 0.5f, 1.0f, r5);
        goto L10
    }
}
