package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class FillContentLayout extends FrameLayout {
    private int maxHeight;
    private int maxWidth;

    public FillContentLayout(Context r2) {
        this(r2, null);
    }

    public FillContentLayout(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.suwFillContentLayoutStyle);
    }

    public FillContentLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, r2, r3);
    }

    private void init(Context r3, AttributeSet r4, int r5) {
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.SuwFillContentLayout, r5, 0);
        this.maxHeight = r6.getDimensionPixelSize(R.styleable.SuwFillContentLayout_android_maxHeight, -1);
        this.maxWidth = r6.getDimensionPixelSize(R.styleable.SuwFillContentLayout_android_maxWidth, -1);
        r6.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r4, int r5) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), r4), getDefaultSize(getSuggestedMinimumHeight(), r5));
        int r6 = getChildCount();
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        measureIllustrationChild(getChildAt(r7), getMeasuredWidth(), getMeasuredHeight());
        r7 = r7 + 1;
        goto L3
    }

    private void measureIllustrationChild(View r4, int r5, int r6) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        r4.measure(getMaxSizeMeasureSpec(Math.min(this.maxWidth, r5), ((getPaddingLeft() + getPaddingRight()) + r0.leftMargin) + r0.rightMargin, r0.width), getMaxSizeMeasureSpec(Math.min(this.maxHeight, r6), ((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin, r0.height));
    }

    private static int getMaxSizeMeasureSpec(int r2, int r3, int r4) {
        int r5 = Math.max(0, r2 - r3);
        if (r4 < 0) goto L7;
        return View.MeasureSpec.makeMeasureSpec(r4, 1073741824);
    L7:
        if (r4 != (-1)) goto L11;
        return View.MeasureSpec.makeMeasureSpec(r5, 1073741824);
    L11:
        if (r4 == (-2)) goto L13;
        return 0;
    L13:
        return View.MeasureSpec.makeMeasureSpec(r5, Integer.MIN_VALUE);
    }
}
