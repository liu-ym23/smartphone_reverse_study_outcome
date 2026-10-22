package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.widget.FrameLayout;
import com.android.internal.util.Preconditions;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;

/* JADX INFO: loaded from: classes.dex */
public class ChartView extends FrameLayout {
    private static final int SWEEP_GRAVITY = 8388659;
    private Rect mContent;
    ChartAxis mHoriz;

    @ViewDebug.ExportedProperty
    private int mOptimalWidth;
    private float mOptimalWidthWeight;
    ChartAxis mVert;

    public ChartView(Context r3) {
        this(r3, null, 0);
    }

    public ChartView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ChartView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.mOptimalWidth = -1;
        this.mOptimalWidthWeight = 0.0f;
        this.mContent = new Rect();
        TypedArray r8 = r5.obtainStyledAttributes(r6, R.styleable.ChartView, r7, 0);
        setOptimalWidth(r8.getDimensionPixelSize(0, -1), r8.getFloat(1, 0.0f));
        r8.recycle();
        setClipToPadding(false);
        setClipChildren(false);
    }

    void init(ChartAxis r2, ChartAxis r3) {
        this.mHoriz = (ChartAxis) Preconditions.checkNotNull(r2, "missing horiz");
        this.mVert = (ChartAxis) Preconditions.checkNotNull(r3, "missing vert");
    }

    public void setOptimalWidth(int r1, float r2) {
        this.mOptimalWidth = r1;
        this.mOptimalWidthWeight = r2;
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = getMeasuredWidth();
        int r0 = this.mOptimalWidth;
        int r6 = r5 - r0;
        if (r0 <= 0) goto L7;
        if (r6 <= 0) goto L8;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (r0 + (r6 * this.mOptimalWidthWeight)), 1073741824), r4);
        return;
    L8:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        this.mContent.set(getPaddingLeft(), getPaddingTop(), (r10 - r8) - getPaddingRight(), (r11 - r9) - getPaddingBottom());
        int r12 = this.mContent.width();
        int r13 = this.mContent.height();
        this.mHoriz.setSize(r12);
        this.mVert.setSize(r13);
        Rect r14 = new Rect();
        Rect r15 = new Rect();
        int r16 = 0;
    L4:
        if (r16 >= getChildCount()) goto L15;
        View r0 = NullSafe.nonNull(getChildAt(r16));
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        r14.set(this.mContent);
        if ((r0 instanceof ChartNetworkSeriesView) == false) goto L9;
        Gravity.apply(r1.gravity, r12, r13, r14, r15);
        r0.layout(r15.left, r15.top, r15.right, r15.bottom);
    L14:
        r16 = r16 + 1;
        goto L4
    L9:
        if ((r0 instanceof ChartGridView) == false) goto L12;
        Gravity.apply(r1.gravity, r12, r13, r14, r15);
        r0.layout(r15.left, r15.top, r15.right, r15.bottom + r0.getPaddingBottom());
        goto L14
    L12:
        if ((r0 instanceof ChartSweepView) == false) goto L14;
        layoutSweep((ChartSweepView) r0, r14, r15);
        r0.layout(r15.left, r15.top, r15.right, r15.bottom);
        goto L14
    }

    protected void layoutSweep(ChartSweepView r4) {
        Rect r0 = new Rect(this.mContent);
        Rect r1 = new Rect();
        layoutSweep(r4, r0, r1);
        r4.layout(r1.left, r1.top, r1.right, r1.bottom);
    }

    protected void layoutSweep(ChartSweepView r5, Rect r6, Rect r7) {
        Rect r4 = r5.getMargins();
        if (r5.getFollowAxis() != 1) goto L5;
        r6.top += r4.top + ((int) r5.getPoint());
        r6.bottom = r6.top;
        r6.left += r4.left;
        r6.right += r4.right;
        Gravity.apply(8388659, r6.width(), r5.getMeasuredHeight(), r6, r7);
        return;
    L5:
        r6.left += r4.left + ((int) r5.getPoint());
        r6.right = r6.left;
        r6.top += r4.top;
        r6.bottom += r4.bottom;
        Gravity.apply(8388659, r5.getMeasuredWidth(), r6.height(), r6, r7);
    }
}
