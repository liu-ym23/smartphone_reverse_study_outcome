package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class CrossShapeRenderer implements IShapeRenderer {
    public CrossShapeRenderer() {
    }

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas r8, IScatterDataSet r9, ViewPortHandler r10, float r11, float r12, Paint r13) {
        float r6 = r9.getScatterShapeSize() / 2.0f;
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeWidth(Utils.convertDpToPixel(1.0f));
        r8.drawLine(r11 - r6, r12, r11 + r6, r12, r13);
        r8.drawLine(r11, r12 - r6, r11, r12 + r6, r13);
    }
}
