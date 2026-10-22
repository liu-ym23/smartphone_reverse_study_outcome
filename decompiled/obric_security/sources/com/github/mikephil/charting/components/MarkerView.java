package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class MarkerView extends RelativeLayout implements IMarker {
    private MPPointF mOffset;
    private MPPointF mOffset2;
    private WeakReference<Chart> mWeakChart;

    public MarkerView(Context r1, int r2) {
        super(r1);
        this.mOffset = new MPPointF();
        this.mOffset2 = new MPPointF();
        setupLayoutResource(r2);
    }

    private void setupLayoutResource(int r3) {
        View r2 = LayoutInflater.from(getContext()).inflate(r3, this);
        r2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r2.layout(0, 0, r2.getMeasuredWidth(), r2.getMeasuredHeight());
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
        float r2 = getWidth();
        float r3 = getHeight();
        if ((this.mOffset2.x + r7) >= 0.0f) goto L5;
        this.mOffset2.x = -r7;
    L10:
        if ((this.mOffset2.y + r8) >= 0.0f) goto L12;
        this.mOffset2.y = -r8;
    L17:
        return this.mOffset2;
    L12:
        if (r1 == null) goto L17;
        if (((r8 + r3) + this.mOffset2.y) <= r1.getHeight()) goto L17;
        this.mOffset2.y = (r1.getHeight() - r8) - r3;
        goto L17
    L5:
        if (r1 == null) goto L10;
        if (((r7 + r2) + this.mOffset2.x) <= r1.getWidth()) goto L10;
        this.mOffset2.x = (r1.getWidth() - r7) - r2;
        goto L10
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry r2, Highlight r3) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas r4, float r5, float r6) {
        MPPointF r0 = getOffsetForDrawingAtPoint(r5, r6);
        int r1 = r4.save();
        r4.translate(r5 + r0.x, r6 + r0.y);
        draw(r4);
        r4.restoreToCount(r1);
    }
}
