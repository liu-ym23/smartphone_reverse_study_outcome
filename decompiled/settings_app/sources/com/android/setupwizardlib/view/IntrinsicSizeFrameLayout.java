package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class IntrinsicSizeFrameLayout extends FrameLayout {
    private int intrinsicHeight;
    private int intrinsicWidth;

    public IntrinsicSizeFrameLayout(Context r3) {
        super(r3);
        this.intrinsicHeight = 0;
        this.intrinsicWidth = 0;
        init(r3, null, 0);
    }

    public IntrinsicSizeFrameLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.intrinsicHeight = 0;
        this.intrinsicWidth = 0;
        init(r2, r3, 0);
    }

    public IntrinsicSizeFrameLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.intrinsicHeight = 0;
        this.intrinsicWidth = 0;
        init(r2, r3, r4);
    }

    private void init(Context r3, AttributeSet r4, int r5) {
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.SuwIntrinsicSizeFrameLayout, r5, 0);
        this.intrinsicHeight = r6.getDimensionPixelSize(R.styleable.SuwIntrinsicSizeFrameLayout_android_height, 0);
        this.intrinsicWidth = r6.getDimensionPixelSize(R.styleable.SuwIntrinsicSizeFrameLayout_android_width, 0);
        r6.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(getIntrinsicMeasureSpec(r2, this.intrinsicWidth), getIntrinsicMeasureSpec(r3, this.intrinsicHeight));
    }

    private int getIntrinsicMeasureSpec(int r4, int r5) {
        if (r5 > 0) goto L4;
        return r4;
    L4:
        int r6 = View.MeasureSpec.getMode(r4);
        int r0 = View.MeasureSpec.getSize(r4);
        if (r6 != 0) goto L9;
        return View.MeasureSpec.makeMeasureSpec(this.intrinsicHeight, 1073741824);
    L9:
        if (r6 == Integer.MIN_VALUE) goto L11;
        return r4;
    L11:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r0, this.intrinsicHeight), 1073741824);
    }
}
