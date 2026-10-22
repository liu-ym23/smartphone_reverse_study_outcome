package com.android.settingslib.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class CircleFramedDrawable extends Drawable {
    private final Bitmap mBitmap;
    private RectF mDstRect;
    private Paint mIconPaint;
    private float mScale;
    private final int mSize;
    private Rect mSrcRect;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    public static CircleFramedDrawable getInstance(Context r1, Bitmap r2) {
        return new CircleFramedDrawable(r2, r1.getResources().getDimensionPixelSize(17106429));
    }

    public CircleFramedDrawable(Bitmap r9, int r10) {
        this.mSize = r10;
        Bitmap r0 = Bitmap.createBitmap(r10, r10, Bitmap.Config.ARGB_8888);
        this.mBitmap = r0;
        Canvas r1 = new Canvas(r0);
        int r2 = r9.getWidth();
        int r3 = r9.getHeight();
        int r4 = Math.min(r2, r3);
        Rect r5 = new Rect((r2 - r4) / 2, (r3 - r4) / 2, r4, r4);
        RectF r6 = new RectF(0.0f, 0.0f, r10, r10);
        Path r7 = new Path();
        r7.addArc(r6, 0.0f, 360.0f);
        r1.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint r8 = new Paint();
        r8.setAntiAlias(true);
        r8.setColor(-16777216);
        r8.setStyle(Paint.Style.FILL);
        r1.drawPath(r7, r8);
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r1.drawBitmap(r9, r5, r6, r8);
        r8.setXfermode(null);
        this.mScale = 1.0f;
        this.mSrcRect = new Rect(0, 0, r10, r10);
        this.mDstRect = new RectF(0.0f, 0.0f, r10, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        float r0 = this.mScale;
        int r1 = this.mSize;
        float r2 = (r1 - (r0 * r1)) / 2.0f;
        this.mDstRect.set(r2, r2, r1 - r2, r1 - r2);
        r5.drawBitmap(this.mBitmap, this.mSrcRect, this.mDstRect, this.mIconPaint);
    }

    public void setScale(float r1) {
        this.mScale = r1;
    }

    public float getScale() {
        return this.mScale;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        if (this.mIconPaint != null) goto L5;
        this.mIconPaint = new Paint();
    L5:
        this.mIconPaint.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }
}
