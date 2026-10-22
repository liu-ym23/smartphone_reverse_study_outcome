package com.android.settings.fuelgauge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryActiveView extends View {
    private final Paint mPaint;
    private BatteryActiveProvider mProvider;

    public interface BatteryActiveProvider {
        SparseIntArray getColorArray();

        long getPeriod();

        boolean hasData();
    }

    public BatteryActiveView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mPaint = new Paint();
    }

    public void setProvider(BatteryActiveProvider r1) {
        this.mProvider = r1;
        if (getWidth() == 0) goto L6;
        postInvalidate();
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (getWidth() == 0) goto L6;
        postInvalidate();
        return;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r11) {
        BatteryActiveProvider r0 = this.mProvider;
        if (r0 != null) goto L5;
        return;
    L5:
        SparseIntArray r1 = r0.getColorArray();
        float r2 = this.mProvider.getPeriod();
        int r3 = 0;
    L7:
        if (r3 >= (r1.size() - 1)) goto L9;
        int r9 = r3 + 1;
        drawColor(r11, r1.keyAt(r3), r1.keyAt(r9), r1.valueAt(r3), r2);
        r3 = r9;
        goto L7
    }

    private void drawColor(Canvas r7, int r8, int r9, int r10, float r11) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.mPaint.setColor(r10);
        r7.drawRect((r8 / r11) * getWidth(), 0.0f, (r9 / r11) * getWidth(), getHeight(), this.mPaint);
    }
}
