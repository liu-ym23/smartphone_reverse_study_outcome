package com.obric.oui.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class PieProgressView extends View {
    private static final String TAG = "PieProgressView";
    private Paint mPaint;
    private RectF mRectF;
    private float progress;

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public void setFinalColor(int color) {
        this.mPaint.setColor(color);
    }

    public int getFinalColor() {
        return this.mPaint.getColor();
    }

    public PieProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.progress = 0.0f;
        this.mRectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mPaint = new Paint();
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        this.mRectF.right = getWidth();
        this.mRectF.bottom = getHeight();
        float r1 = 164;
        float r5 = ((((float) Math.ceil(this.progress * r1)) / r1) * 360.0f) + 0.0f;
        canvas.rotate(-91.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawArc(this.mRectF, 0.0f, r5, true, this.mPaint);
        canvas.restore();
    }
}
