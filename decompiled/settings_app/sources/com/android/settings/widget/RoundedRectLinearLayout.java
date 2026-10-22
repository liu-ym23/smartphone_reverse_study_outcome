package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class RoundedRectLinearLayout extends LinearLayout {
    private Path mClip;
    private float mRadius;

    public RoundedRectLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2);
    }

    public RoundedRectLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2);
    }

    private void init(AttributeSet r4) {
        if (r4 == null) goto L5;
        TypedArray r5 = getContext().obtainStyledAttributes(r4, R.styleable.RoundedRectLinearLayout, 0, 0);
        this.mRadius = r5.getDimensionPixelSize(0, 0);
        r5.recycle();
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.mRadius <= 0.0f) goto L6;
        this.mClip = new Path();
        RectF r5 = new RectF(0.0f, 0.0f, r1, r2);
        Path r6 = this.mClip;
        float r0 = this.mRadius;
        r6.addRoundRect(r5, r0, r0, Path.Direction.CW);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        int r0 = r4.save();
        if (this.mRadius <= 0.0f) goto L5;
        r4.clipPath(this.mClip);
    L5:
        super.dispatchDraw(r4);
        r4.restoreToCount(r0);
    }
}
