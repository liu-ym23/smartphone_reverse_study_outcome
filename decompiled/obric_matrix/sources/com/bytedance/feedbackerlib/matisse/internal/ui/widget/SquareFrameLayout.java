package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class SquareFrameLayout extends FrameLayout {
    public SquareFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r1);
    }
}
