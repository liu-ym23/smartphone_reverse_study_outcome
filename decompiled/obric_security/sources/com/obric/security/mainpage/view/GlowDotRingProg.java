package com.obric.security.mainpage.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.obric.security.R;

/* JADX INFO: loaded from: classes4.dex */
public class GlowDotRingProg extends View {
    public int bg;
    public Bitmap bitmap;
    public Canvas canvas;
    public float centerPostion;
    public int centerX;
    public int centerY;
    public Xfermode clearCanvasXfermode;
    public int currentPercent;
    public int dotBgColor;
    public int dotColor;
    float mDotRadius;
    public int mProgressmax;
    public Paint paint;
    public Path path;
    public int percentThinPadding;
    public Xfermode percentThinXfermode;
    public int progress;
    public RectF rectF;
    boolean scaleAnimationState;
    public int totalCount;

    public GlowDotRingProg(Context context) {
        this(context, null);
    }

    public GlowDotRingProg(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GlowDotRingProg(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.totalCount = 0;
        this.mProgressmax = 100;
        this.dotColor = -1;
        this.dotBgColor = -1;
        this.bg = -526345;
        this.centerPostion = 10.5f;
        this.mDotRadius = 10.5f;
        this.scaleAnimationState = false;
        this.bg = getResources().getColor(R.color.oui_bg_base_1);
        Paint r1 = new Paint();
        this.paint = r1;
        r1.setAntiAlias(true);
        this.path = new Path();
        this.rectF = new RectF();
        this.clearCanvasXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        if (this.percentThinPadding == 0) goto L6;
        this.percentThinXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap r0 = this.bitmap;
        if (r0 != null) goto L5;
    L6:
        ensureBitmap();
    L7:
        Bitmap r1 = this.bitmap;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isRecycled() == true) goto L15;
        drawCircleDot(this.canvas);
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, null);
        return;
    L15:
        return;
    L5:
        if (r0.isRecycled() == false) goto L7;
        goto L6
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ensureBitmap();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap r0 = this.bitmap;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L9;
        this.bitmap.recycle();
        this.bitmap = null;
        return;
    }

    private void ensureBitmap() {
        int r0 = getWidth();
        int r1 = getHeight();
        if (r0 <= 0) goto L12;
        if (r1 <= 0) goto L14;
        Bitmap r2 = this.bitmap;
        if (r2 != null) goto L9;
    L10:
        this.bitmap = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        postInvalidate();
        return;
    L9:
        if (r2.isRecycled() == true) goto L10;
        return;
    L14:
        return;
    }

    private void drawCircleDot(Canvas canvas) {
        this.paint.setXfermode(this.clearCanvasXfermode);
        this.canvas.drawPaint(this.paint);
        this.paint.setXfermode(null);
        this.paint.setStyle(Paint.Style.FILL);
        if (getWidth() >= getHeight()) goto L5;
        int r10 = getWidth();
    L6:
        float r11 = r10 / 2.0f;
        int r0 = (int) r11;
        this.centerX = r0;
        this.centerY = r0;
        this.paint.setColor(this.bg);
        Canvas r1 = this.canvas;
        int r2 = this.centerX;
        r1.drawCircle(r2, this.centerY, r2, this.paint);
        int r3 = 1;
        if (this.scaleAnimationState == false) goto L12;
        this.paint.setXfermode(this.clearCanvasXfermode);
        this.paint.setColor(this.dotBgColor);
        this.paint.setStyle(Paint.Style.FILL);
        int r4 = 1;
    L9:
        if (r4 > 72) goto L11;
        r4 = r4 + 1;
        Canvas r5 = this.canvas;
        float r6 = this.centerX;
        float r7 = this.centerY - r11;
        float r8 = this.centerPostion;
        r5.drawCircle(r6, r7 + r8, r8, this.paint);
        this.canvas.rotate(5.0f, this.centerX, this.centerY);
        goto L9
    L11:
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
    L12:
        this.paint.setColor(this.dotColor);
        this.paint.setStyle(Paint.Style.FILL);
    L14:
        if (r3 > this.totalCount) goto L16;
        r3 = r3 + 1;
        this.canvas.drawCircle(this.centerX, (this.centerY - r11) + this.centerPostion, this.mDotRadius, this.paint);
        this.canvas.rotate(5.0f, this.centerX, this.centerY);
        goto L14
    L16:
        this.paint.setXfermode(this.clearCanvasXfermode);
        this.paint.setColor(this.dotBgColor);
    L17:
        if (r3 > 72) goto L19;
        r3 = r3 + 1;
        Canvas r9 = this.canvas;
        float r12 = this.centerX;
        float r13 = this.centerY - r11;
        float r14 = this.centerPostion;
        r9.drawCircle(r12, r13 + r14, r14, this.paint);
        this.canvas.rotate(5.0f, this.centerX, this.centerY);
        goto L17
    L19:
        return;
    L5:
        r10 = getHeight();
        goto L6
    }

    public synchronized int getmProgressmax() {
        monitor-enter(this);
        int r0 = this.mProgressmax;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setmProgressmax(int mProgressmax) {
        monitor-enter(this);
        if (mProgressmax >= 0) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.mProgressmax = mProgressmax;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized int getProgress() {
        monitor-enter(this);
        int r0 = this.progress;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setProgress(int progress) {
        monitor-enter(this);
        this.progress = progress;     // Catch: Throwable -> L6
        int r2 = (progress * 100) / this.mProgressmax;     // Catch: Throwable -> L6
        this.currentPercent = r2;     // Catch: Throwable -> L6
        this.totalCount = (r2 * 72) / 100;     // Catch: Throwable -> L6
        postInvalidate();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setDotRadius(float mDotRadius) {
        monitor-enter(this);
        this.mDotRadius = (int) (mDotRadius * this.centerPostion);     // Catch: Throwable -> L6
        postInvalidate();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setScaleAnimationState(boolean state) {
        this.scaleAnimationState = state;
    }

    public void setDotColor(int color) {
        this.dotColor = color;
        postInvalidate();
    }

    public void setDotBgColor(int color) {
        this.dotBgColor = color;
        postInvalidate();
    }
}
