package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public interface IShapeRenderer {
    void renderShape(Canvas r1, IScatterDataSet r2, ViewPortHandler r3, float r4, float r5, Paint r6);
}
