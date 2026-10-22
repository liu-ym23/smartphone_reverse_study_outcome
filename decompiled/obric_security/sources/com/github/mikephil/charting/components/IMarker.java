package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/* JADX INFO: loaded from: classes2.dex */
public interface IMarker {
    void draw(Canvas r1, float r2, float r3);

    MPPointF getOffset();

    MPPointF getOffsetForDrawingAtPoint(float r1, float r2);

    void refreshContent(Entry r1, Highlight r2);
}
