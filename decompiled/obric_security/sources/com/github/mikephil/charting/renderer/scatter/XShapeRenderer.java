package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class XShapeRenderer implements IShapeRenderer {
    public XShapeRenderer() {
    }

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas r7, IScatterDataSet r8, ViewPortHandler r9, float r10, float r11, Paint r12) {
        float r6 = r8.getScatterShapeSize() / 2.0f;
        r12.setStyle(Paint.Style.STROKE);
        r12.setStrokeWidth(Utils.convertDpToPixel(1.0f));
        float r13 = r10 - r6;
        float r14 = r11 - r6;
        float r15 = r10 + r6;
        float r16 = r6 + r11;
        r7.drawLine(r13, r14, r15, r16, r12);
        r7.drawLine(r15, r14, r13, r16, r12);
    }
}
