package com.android.settings.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class FaceEnrollProgressView extends View {
    private int mCircleRadius;
    private Paint mForegroundPaint;
    private int mMaxProgress;
    private int mProgress;
    private int mRadius;
    private RectF mRectFInside;

    public FaceEnrollProgressView(Context r1) {
        super(r1);
        this.mRadius = 0;
        this.mProgress = 0;
        this.mMaxProgress = 100;
    }

    public FaceEnrollProgressView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mRadius = 0;
        this.mProgress = 0;
        this.mMaxProgress = 100;
        this.mRadius = getResources().getDimensionPixelSize(R.dimen.face_enroll_progress_radius);
        this.mCircleRadius = getResources().getDimensionPixelSize(R.dimen.face_enroll_progress_view_circle_radius);
        Paint r4 = new Paint(1);
        this.mForegroundPaint = r4;
        r4.setColor(r2.getColor(R.color.face_enroll_progress));
        this.mForegroundPaint.setStyle(Paint.Style.STROKE);
        this.mForegroundPaint.setStrokeWidth(this.mRadius);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r9) {
        super.onDraw(r9);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        int r1 = this.mRadius / 2;
        if (this.mRectFInside != null) goto L5;
        int r4 = this.mCircleRadius;
        float r3 = r1;
        this.mRectFInside = new RectF((r0 - r4) + r3, (r2 - r4) + r3, (r0 + r4) - r3, (r2 + r4) - r3);
    L5:
        r9.drawArc(this.mRectFInside, -90.0f, (this.mProgress * 360) / this.mMaxProgress, false, this.mForegroundPaint);
    }

    public void setProgressWithAnimation(int r4) {
        ObjectAnimator r3 = ObjectAnimator.ofInt(this, "progress", new int[]{this.mProgress, r4});
        r3.setDuration(200);
        r3.start();
    }

    public void setProgress(int r1) {
        this.mProgress = r1;
        invalidate();
    }
}
