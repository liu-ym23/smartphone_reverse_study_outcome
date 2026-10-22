package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes.dex */
public class GridViewForScrollView extends GridView {
    public GridViewForScrollView(Context r1) {
        super(r1);
    }

    public GridViewForScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public GridViewForScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
