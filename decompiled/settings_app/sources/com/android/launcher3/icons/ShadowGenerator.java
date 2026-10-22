package com.android.launcher3.icons;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class ShadowGenerator {
    private static final int AMBIENT_SHADOW_ALPHA = 25;
    public static final float BLUR_FACTOR = 0.035f;
    public static final boolean ENABLE_SHADOWS = true;
    private static final float HALF_DISTANCE = 0.5f;
    private static final int KEY_SHADOW_ALPHA = 7;
    public static final float KEY_SHADOW_DISTANCE = 0.020833334f;
    private final Paint mBlurPaint;
    private final BlurMaskFilter mDefaultBlurMaskFilter;
    private final Paint mDrawPaint;
    private final int mIconSize;

    public static class Builder {
        public int ambientShadowAlpha;
        public final RectF bounds;
        public final int color;
        public int keyShadowAlpha;
        public float keyShadowDistance;
        public float radius;
        public float shadowBlur;

        public Builder(int r2) {
            this.bounds = new RectF();
            this.ambientShadowAlpha = 25;
            this.keyShadowAlpha = 7;
            this.color = r2;
        }

        public Builder setupBlurForSize(int r2) {
            float r3 = r2 * 1.0f;
            this.shadowBlur = r3 / 24.0f;
            this.keyShadowDistance = r3 / 16.0f;
            return this;
        }

        public Bitmap createPill(int r3, int r4) {
            return createPill(r3, r4, r4 / 2.0f);
        }

        public Bitmap createPill(int r5, int r6, float r7) {
            this.radius = r7;
            float r8 = r5;
            float r0 = r8 / 2.0f;
            int r1 = Math.max(Math.round(this.shadowBlur + r0), Math.round((this.radius + this.shadowBlur) + this.keyShadowDistance));
            float r9 = r6;
            this.bounds.set(0.0f, 0.0f, r8, r9);
            float r2 = r1;
            this.bounds.offsetTo(r2 - r0, r2 - (r9 / 2.0f));
            int r3 = r1 * 2;
            return BitmapRenderer.createHardwareBitmap(r3, r3, new ShadowGenerator$Builder$$ExternalSyntheticLambda0(this));
        }

        public void drawShadow(Canvas r7) {
            Paint r0 = new Paint(3);
            r0.setColor(this.color);
            r0.setShadowLayer(this.shadowBlur, 0.0f, this.keyShadowDistance, GraphicsUtils.setColorAlphaBound(-16777216, this.keyShadowAlpha));
            RectF r1 = this.bounds;
            float r2 = this.radius;
            r7.drawRoundRect(r1, r2, r2, r0);
            r0.setShadowLayer(this.shadowBlur, 0.0f, 0.0f, GraphicsUtils.setColorAlphaBound(-16777216, this.ambientShadowAlpha));
            RectF r3 = this.bounds;
            float r4 = this.radius;
            r7.drawRoundRect(r3, r4, r4, r0);
            if (Color.alpha(this.color) >= 255) goto L6;
            r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            r0.clearShadowLayer();
            r0.setColor(-16777216);
            RectF r5 = this.bounds;
            float r6 = this.radius;
            r7.drawRoundRect(r5, r6, r6, r0);
            r0.setXfermode(null);
            r0.setColor(this.color);
            RectF r8 = this.bounds;
            float r9 = this.radius;
            r7.drawRoundRect(r8, r9, r9, r0);
            return;
        }
    }

    public ShadowGenerator(int r3) {
        this.mIconSize = r3;
        this.mBlurPaint = new Paint(3);
        this.mDrawPaint = new Paint(3);
        this.mDefaultBlurMaskFilter = new BlurMaskFilter(r3 * 0.035f, BlurMaskFilter.Blur.NORMAL);
    }

    public synchronized void drawShadow(Bitmap r7, Canvas r8) {
        monitor-enter(this);
        int[] r0 = new int[2];     // Catch: Throwable -> L7
        this.mBlurPaint.setMaskFilter(this.mDefaultBlurMaskFilter);     // Catch: Throwable -> L7
        Bitmap r9 = r7.extractAlpha(this.mBlurPaint, r0);     // Catch: Throwable -> L7
        this.mDrawPaint.setAlpha(25);     // Catch: Throwable -> L7
        r8.drawBitmap(r9, r0[0], r0[1], this.mDrawPaint);     // Catch: Throwable -> L7
        this.mDrawPaint.setAlpha(7);     // Catch: Throwable -> L7
        r8.drawBitmap(r9, r0[0], r0[1] + (this.mIconSize * 0.020833334f), this.mDrawPaint);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addPathShadow(Path r4, Canvas r5) {
        this.mDrawPaint.setMaskFilter(this.mDefaultBlurMaskFilter);
        this.mDrawPaint.setAlpha(25);
        r5.drawPath(r4, this.mDrawPaint);
        int r0 = r5.save();
        this.mDrawPaint.setAlpha(7);
        r5.translate(0.0f, this.mIconSize * 0.020833334f);
        r5.drawPath(r4, this.mDrawPaint);
        r5.restoreToCount(r0);
        this.mDrawPaint.setMaskFilter(null);
    }

    public static float getScaleForBounds(RectF r5) {
        float r0 = Math.min(Math.min(r5.left, r5.right), r5.top);
        if (r0 >= 0.035f) goto L5;
        float r1 = 0.465f / (0.5f - r0);
    L7:
        if (r5.bottom < 0.035f) goto L9;
        return r1;
    L9:
        return Math.min(r1, 0.465f / (0.5f - r5.bottom));
    L5:
        r1 = 1.0f;
        goto L7
    }
}
