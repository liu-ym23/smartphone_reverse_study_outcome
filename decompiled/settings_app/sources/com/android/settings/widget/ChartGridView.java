package com.android.settings.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.android.internal.util.Preconditions;
import com.android.settings.DataUsageSummary;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class ChartGridView extends View {
    private Drawable mBorder;
    private ChartAxis mHoriz;
    private int mLabelColor;
    private Layout mLabelEnd;
    private Layout mLabelMid;
    private int mLabelSize;
    private Layout mLabelStart;
    private Drawable mPrimary;
    private Drawable mSecondary;
    private ChartAxis mVert;

    public ChartGridView(Context r3) {
        this(r3, null, 0);
    }

    public ChartGridView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ChartGridView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        setWillNotDraw(false);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.ChartGridView, r5, 0);
        this.mPrimary = r6.getDrawable(3);
        this.mSecondary = r6.getDrawable(4);
        this.mBorder = r6.getDrawable(2);
        TypedArray r7 = r3.obtainStyledAttributes(r6.getResourceId(0, -1), com.android.internal.R.styleable.TextAppearance);
        this.mLabelSize = r7.getDimensionPixelSize(0, 0);
        r7.recycle();
        this.mLabelColor = r6.getColorStateList(1).getDefaultColor();
        r6.recycle();
    }

    void init(ChartAxis r2, ChartAxis r3) {
        this.mHoriz = (ChartAxis) Preconditions.checkNotNull(r2, "missing horiz");
        this.mVert = (ChartAxis) Preconditions.checkNotNull(r3, "missing vert");
    }

    void setBounds(long r6, long r8) {
        Context r0 = getContext();
        long r1 = (r6 + r8) / 2;
        this.mLabelStart = makeLabel(DataUsageSummary.formatDateRange(r0, r6, r6));
        this.mLabelMid = makeLabel(DataUsageSummary.formatDateRange(r0, r1, r1));
        this.mLabelEnd = makeLabel(DataUsageSummary.formatDateRange(r0, r8, r8));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r12) {
        int r0 = getWidth();
        int r1 = getHeight() - getPaddingBottom();
        Drawable r2 = this.mSecondary;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.getIntrinsicHeight();
        float[] r5 = this.mVert.getTickPoints();
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L7;
        float r8 = r5[r7];
        r2.setBounds(0, (int) r8, r0, (int) Math.min(r4 + r8, r1));
        r2.draw(r12);
        r7 = r7 + 1;
    L7:
        Drawable r9 = this.mPrimary;
        if (r9 == null) goto L12;
        int r10 = r9.getIntrinsicWidth();
        r9.getIntrinsicHeight();
        float[] r11 = this.mHoriz.getTickPoints();
        int r13 = r11.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L12;
        float r15 = r11[r14];
        r9.setBounds((int) r15, 0, (int) Math.min(r10 + r15, r0), r1);
        r9.draw(r12);
        r14 = r14 + 1;
    L12:
        this.mBorder.setBounds(0, 0, r0, r1);
        this.mBorder.draw(r12);
        Layout r16 = this.mLabelStart;
        if (r16 == null) goto L15;
        r3 = r16.getHeight() / 8;
    L15:
        Layout r17 = this.mLabelStart;
        if (r17 == null) goto L18;
        int r18 = r12.save();
        r12.translate(0.0f, r1 + r3);
        r17.draw(r12);
        r12.restoreToCount(r18);
    L18:
        Layout r19 = this.mLabelMid;
        if (r19 == null) goto L21;
        int r20 = r12.save();
        r12.translate((r0 - r19.getWidth()) / 2, r1 + r3);
        r19.draw(r12);
        r12.restoreToCount(r20);
    L21:
        Layout r110 = this.mLabelEnd;
        if (r110 == null) goto L27;
        int r21 = r12.save();
        r12.translate(r0 - r110.getWidth(), r1 + r3);
        r110.draw(r12);
        r12.restoreToCount(r21);
        return;
    }

    private Layout makeLabel(CharSequence r10) {
        Resources r0 = getResources();
        TextPaint r3 = new TextPaint(1);
        r3.density = r0.getDisplayMetrics().density;
        r3.setCompatibilityScaling(r0.getCompatibilityInfo().applicationScale);
        r3.setColor(this.mLabelColor);
        r3.setTextSize(this.mLabelSize);
        return new StaticLayout(r10, r3, (int) Math.ceil(Layout.getDesiredWidth(r10, r3)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }
}
