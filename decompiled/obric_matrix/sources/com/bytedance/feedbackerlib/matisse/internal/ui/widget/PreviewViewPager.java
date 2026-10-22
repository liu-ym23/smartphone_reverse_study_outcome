package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public class PreviewViewPager extends ViewPager {
    public PreviewViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected boolean canScroll(View r1, boolean r2, int r3, int r4, int r5) {
        return super.canScroll(r1, r2, r3, r4, r5);
    }
}
