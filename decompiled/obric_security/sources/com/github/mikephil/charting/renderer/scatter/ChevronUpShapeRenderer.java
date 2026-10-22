package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class ChevronUpShapeRenderer implements IShapeRenderer {
    public ChevronUpShapeRenderer() {
    }

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas r7, IScatterDataSet r8, ViewPortHandler r9, float r10, float r11, Paint r12) {
        float r6 = r8.getScatterShapeSize() / 2.0f;
        r12.setStyle(Paint.Style.STROKE);
        r12.setStrokeWidth(Utils.convertDpToPixel(1.0f));
        float r13 = r6 * 2.0f;
        float r14 = r11 - r13;
        r7.drawLine(r10, r14, r10 + r13, r11, r12);
        r7.drawLine(r10, r14, r10 - r13, r11, r12);
    }
}
