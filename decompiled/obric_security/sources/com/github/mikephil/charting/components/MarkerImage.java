package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class MarkerImage implements IMarker {
    private Context mContext;
    private Drawable mDrawable;
    private Rect mDrawableBoundsCache;
    private MPPointF mOffset;
    private MPPointF mOffset2;
    private FSize mSize;
    private WeakReference<Chart> mWeakChart;

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry r1, Highlight r2) {
    }

    public MarkerImage(Context r2, int r3) {
        this.mOffset = new MPPointF();
        this.mOffset2 = new MPPointF();
        this.mSize = new FSize();
        this.mDrawableBoundsCache = new Rect();
        this.mContext = r2;
        this.mDrawable = this.mContext.getResources().getDrawable(r3, null);
    }

    public void setOffset(MPPointF r1) {
        this.mOffset = r1;
        if (r1 != null) goto L6;
        this.mOffset = new MPPointF();
        return;
    }

    public void setOffset(float r2, float r3) {
        this.mOffset.x = r2;
        this.mOffset.y = r3;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return this.mOffset;
    }

    public void setSize(FSize r1) {
        this.mSize = r1;
        if (r1 != null) goto L6;
        this.mSize = new FSize();
        return;
    }

    public FSize getSize() {
        return this.mSize;
    }

    public void setChartView(Chart r2) {
        this.mWeakChart = new WeakReference(r2);
    }

    public Chart getChartView() {
        WeakReference<Chart> r0 = this.mWeakChart;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffsetForDrawingAtPoint(float r7, float r8) {
        MPPointF r0 = getOffset();
        this.mOffset2.x = r0.x;
        this.mOffset2.y = r0.y;
        Chart r1 = getChartView();
        float r2 = this.mSize.width;
        float r3 = this.mSize.height;
        if (r2 != 0.0f) goto L8;
        Drawable r4 = this.mDrawable;
        if (r4 == null) goto L8;
        r2 = r4.getIntrinsicWidth();
    L8:
        if (r3 != 0.0f) goto L13;
        Drawable r5 = this.mDrawable;
        if (r5 == null) goto L13;
        r3 = r5.getIntrinsicHeight();
    L13:
        if ((this.mOffset2.x + r7) >= 0.0f) goto L15;
        this.mOffset2.x = -r7;
    L20:
        if ((this.mOffset2.y + r8) >= 0.0f) goto L22;
        this.mOffset2.y = -r8;
    L27:
        return this.mOffset2;
    L22:
        if (r1 == null) goto L27;
        if (((r8 + r3) + this.mOffset2.y) <= r1.getHeight()) goto L27;
        this.mOffset2.y = (r1.getHeight() - r8) - r3;
        goto L27
    L15:
        if (r1 == null) goto L20;
        if (((r7 + r2) + this.mOffset2.x) <= r1.getWidth()) goto L20;
        this.mOffset2.x = (r1.getWidth() - r7) - r2;
        goto L20
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas r8, float r9, float r10) {
        if (this.mDrawable != null) goto L5;
        return;
    L5:
        MPPointF r0 = getOffsetForDrawingAtPoint(r9, r10);
        float r1 = this.mSize.width;
        float r2 = this.mSize.height;
        if (r1 != 0.0f) goto L9;
        r1 = this.mDrawable.getIntrinsicWidth();
    L9:
        if (r2 != 0.0f) goto L11;
        r2 = this.mDrawable.getIntrinsicHeight();
    L11:
        this.mDrawable.copyBounds(this.mDrawableBoundsCache);
        this.mDrawable.setBounds(this.mDrawableBoundsCache.left, this.mDrawableBoundsCache.top, this.mDrawableBoundsCache.left + ((int) r1), this.mDrawableBoundsCache.top + ((int) r2));
        int r3 = r8.save();
        r8.translate(r9 + r0.x, r10 + r0.y);
        this.mDrawable.draw(r8);
        r8.restoreToCount(r3);
        this.mDrawable.setBounds(this.mDrawableBoundsCache);
    }
}
