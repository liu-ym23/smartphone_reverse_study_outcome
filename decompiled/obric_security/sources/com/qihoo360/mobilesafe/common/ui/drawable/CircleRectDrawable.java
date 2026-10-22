package com.qihoo360.mobilesafe.common.ui.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class CircleRectDrawable extends Drawable {
    private int diffWH;
    private final Paint mPaint;
    private int mRadius;
    private RectF rectF;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public CircleRectDrawable(int r3, int r4) {
        Paint r0 = new Paint();
        this.mPaint = r0;
        r0.setAntiAlias(true);
        this.diffWH = r3;
        this.mRadius = r4;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r4, int r5, int r6, int r7) {
        super.setBounds(r4, r5, r6, r7);
        RectF r0 = this.rectF;
        if (r0 != null) goto L5;
        int r1 = this.diffWH;
        int r2 = this.mRadius;
        this.rectF = new RectF(r4 + r1, (r5 + r2) + 4, r6 - r1, (r7 - r2) - 4);
        return;
    L5:
        int r3 = this.diffWH;
        int r8 = this.mRadius;
        r0.set(r4 + r3, (r5 + r8) + 4, r6 - r3, (r7 - r8) - 4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        float r0 = (float) (((double) this.rectF.bottom) * 0.4d);
        if (this.rectF.right >= this.rectF.bottom) goto L5;
        r0 = (float) (((double) this.rectF.right) * 0.4d);
    L5:
        r6.drawRoundRect(this.rectF, r0, r0, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.mPaint.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.mPaint.setColorFilter(r1);
    }
}
