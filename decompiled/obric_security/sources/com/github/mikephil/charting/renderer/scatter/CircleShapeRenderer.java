package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class CircleShapeRenderer implements IShapeRenderer {
    public CircleShapeRenderer() {
    }

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas r8, IScatterDataSet r9, ViewPortHandler r10, float r11, float r12, Paint r13) {
        float r7 = r9.getScatterShapeSize();
        float r0 = r7 / 2.0f;
        float r1 = Utils.convertDpToPixel(r9.getScatterShapeHoleRadius());
        float r2 = (r7 - (r1 * 2.0f)) / 2.0f;
        float r14 = r2 / 2.0f;
        int r15 = r9.getScatterShapeHoleColor();
        if (r7 <= 0.0d) goto L7;
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeWidth(r2);
        r8.drawCircle(r11, r12, r14 + r1, r13);
        if (r15 == 1122867) goto L9;
        r13.setStyle(Paint.Style.FILL);
        r13.setColor(r15);
        r8.drawCircle(r11, r12, r1, r13);
        return;
    L9:
        return;
    L7:
        r13.setStyle(Paint.Style.FILL);
        r8.drawCircle(r11, r12, r0, r13);
    }
}
