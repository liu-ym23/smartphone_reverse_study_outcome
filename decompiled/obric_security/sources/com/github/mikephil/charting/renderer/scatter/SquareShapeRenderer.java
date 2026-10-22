package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class SquareShapeRenderer implements IShapeRenderer {
    public SquareShapeRenderer() {
    }

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas r14, IScatterDataSet r15, ViewPortHandler r16, float r17, float r18, Paint r19) {
        float r0 = r15.getScatterShapeSize();
        float r2 = r0 / 2.0f;
        float r3 = Utils.convertDpToPixel(r15.getScatterShapeHoleRadius());
        float r4 = (r0 - (r3 * 2.0f)) / 2.0f;
        float r1 = r4 / 2.0f;
        int r7 = r15.getScatterShapeHoleColor();
        if (r0 <= 0.0d) goto L7;
        r19.setStyle(Paint.Style.STROKE);
        r19.setStrokeWidth(r4);
        float r8 = r17 - r3;
        float r9 = r18 - r3;
        float r10 = r17 + r3;
        float r11 = r18 + r3;
        r14.drawRect(r8 - r1, r9 - r1, r10 + r1, r11 + r1, r19);
        if (r7 == 1122867) goto L9;
        r19.setStyle(Paint.Style.FILL);
        r19.setColor(r7);
        r14.drawRect(r8, r9, r10, r11, r19);
        return;
    L9:
        return;
    L7:
        r19.setStyle(Paint.Style.FILL);
        r14.drawRect(r17 - r2, r18 - r2, r17 + r2, r18 + r2, r19);
    }
}
