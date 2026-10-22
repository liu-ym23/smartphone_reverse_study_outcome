package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class TriangleShapeRenderer implements IShapeRenderer {
    protected Path mTrianglePathBuffer;

    public TriangleShapeRenderer() {
        this.mTrianglePathBuffer = new Path();
    }

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void renderShape(Canvas r9, IScatterDataSet r10, ViewPortHandler r11, float r12, float r13, Paint r14) {
        float r15 = r10.getScatterShapeSize();
        float r1 = r15 / 2.0f;
        float r2 = (r15 - (Utils.convertDpToPixel(r10.getScatterShapeHoleRadius()) * 2.0f)) / 2.0f;
        int r16 = r10.getScatterShapeHoleColor();
        r14.setStyle(Paint.Style.FILL);
        Path r8 = this.mTrianglePathBuffer;
        r8.reset();
        float r0 = r13 - r1;
        r8.moveTo(r12, r0);
        float r3 = r12 + r1;
        float r17 = r13 + r1;
        r8.lineTo(r3, r17);
        float r4 = r12 - r1;
        r8.lineTo(r4, r17);
        double r5 = r15;
        if (r5 <= 0.0d) goto L5;
        r8.lineTo(r12, r0);
        float r6 = r4 + r2;
        float r7 = r17 - r2;
        r8.moveTo(r6, r7);
        r8.lineTo(r3 - r2, r7);
        r8.lineTo(r12, r0 + r2);
        r8.lineTo(r6, r7);
    L5:
        r8.close();
        r9.drawPath(r8, r14);
        r8.reset();
        if (r5 > 0.0d) goto L8;
        return;
    L8:
        if (r16 == 1122867) goto L12;
        r14.setColor(r16);
        r8.moveTo(r12, r0 + r2);
        float r18 = r17 - r2;
        r8.lineTo(r3 - r2, r18);
        r8.lineTo(r4 + r2, r18);
        r8.close();
        r9.drawPath(r8, r14);
        r8.reset();
        return;
    }
}
