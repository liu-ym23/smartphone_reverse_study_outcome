package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes2.dex */
class TabIndicatorInterpolator {

    @Dimension(unit = 0)
    private static final int MIN_INDICATOR_WIDTH = 24;

    TabIndicatorInterpolator() {
    }

    static RectF calculateIndicatorWidthForTab(TabLayout r3, @Nullable View r4) {
        if (r4 != null) goto L6;
        return new RectF();
    L6:
        if (r3.isTabIndicatorFullWidth() == true) goto L12;
        if ((r4 instanceof TabLayout.TabView) == false) goto L12;
        return calculateTabViewContentBounds((TabLayout.TabView) r4, 24);
    L12:
        return new RectF(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    static RectF calculateTabViewContentBounds(@NonNull TabLayout.TabView r3, @Dimension(unit = 0) int r4) {
        int r0 = r3.getContentWidth();
        int r1 = r3.getContentHeight();
        int r5 = (int) ViewUtils.dpToPx(r3.getContext(), r4);
        if (r0 >= r5) goto L5;
        r0 = r5;
    L5:
        int r6 = (r3.getLeft() + r3.getRight()) / 2;
        int r2 = (r3.getTop() + r3.getBottom()) / 2;
        int r7 = r0 / 2;
        return new RectF(r6 - r7, r2 - (r1 / 2), r7 + r6, r2 + (r6 / 2));
    }

    void setIndicatorBoundsForOffset(TabLayout r1, View r2, View r3, @FloatRange(from = 0.0d, to = 1.0d) float r4, @NonNull Drawable r5) {
        RectF r0 = calculateIndicatorWidthForTab(r1, r2);
        RectF r6 = calculateIndicatorWidthForTab(r1, r3);
        r5.setBounds(AnimationUtils.lerp((int) r0.left, (int) r6.left, r4), r5.getBounds().top, AnimationUtils.lerp((int) r0.right, (int) r6.right, r4), r5.getBounds().bottom);
    }

    void setIndicatorBoundsForTab(TabLayout r2, View r3, @NonNull Drawable r4) {
        RectF r1 = calculateIndicatorWidthForTab(r2, r3);
        r4.setBounds((int) r1.left, r4.getBounds().top, (int) r1.right, r4.getBounds().bottom);
    }
}
