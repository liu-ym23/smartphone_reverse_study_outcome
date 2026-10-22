package com.android.launcher3.icons;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.util.Log;
import android.view.ViewDebug;

/* JADX INFO: loaded from: classes.dex */
public class DotRenderer {
    private static final int MIN_DOT_SIZE = 1;
    private static final float SIZE_PERCENTAGE = 0.228f;
    private static final String TAG = "DotRenderer";
    private final Bitmap mBackgroundWithShadow;
    private final float mBitmapOffset;
    private final Paint mCirclePaint;
    private final float mCircleRadius;
    private final float[] mLeftDotPosition;
    private final float[] mRightDotPosition;

    public static class DrawParams {

        @ViewDebug.ExportedProperty(category = "notification dot", formatToHexString = true)
        public int appColor;

        @ViewDebug.ExportedProperty(category = "notification dot", formatToHexString = true)
        public int dotColor;

        @ViewDebug.ExportedProperty(category = "notification dot")
        public Rect iconBounds;

        @ViewDebug.ExportedProperty(category = "notification dot")
        public boolean leftAlign;

        @ViewDebug.ExportedProperty(category = "notification dot")
        public float scale;

        public DrawParams() {
            this.iconBounds = new Rect();
        }
    }

    public DotRenderer(int r3, Path r4, int r5) {
        this.mCirclePaint = new Paint(3);
        int r6 = Math.round(r3 * SIZE_PERCENTAGE);
        if (r6 > 0) goto L5;
        r6 = 1;
    L5:
        ShadowGenerator.Builder r0 = new ShadowGenerator.Builder(0);
        r0.ambientShadowAlpha = 88;
        Bitmap r7 = r0.setupBlurForSize(r6).createPill(r6, r6);
        this.mBackgroundWithShadow = r7;
        this.mCircleRadius = r0.radius;
        this.mBitmapOffset = (-r7.getHeight()) * 0.5f;
        float r8 = r5;
        this.mLeftDotPosition = getPathPoint(r4, r8, -1.0f);
        this.mRightDotPosition = getPathPoint(r4, r8, 1.0f);
    }

    private static float[] getPathPoint(Path r3, float r4, float r5) {
        float r0 = r4 / 2.0f;
        float r1 = (r5 * r0) + r0;
        Path r2 = new Path();
        r2.moveTo(r0, r0);
        r2.lineTo((r5 * 1.0f) + r1, 0.0f);
        r2.lineTo(r1, -1.0f);
        r2.close();
        r2.op(r3, Path.Op.INTERSECT);
        float[] r6 = new float[2];
        new PathMeasure(r2, false).getPosTan(0.0f, r6, null);
        r6[0] = r6[0] / r4;
        r6[1] = r6[1] / r4;
        return r6;
    }

    public float[] getLeftDotPosition() {
        return this.mLeftDotPosition;
    }

    public float[] getRightDotPosition() {
        return this.mRightDotPosition;
    }

    public void draw(Canvas r7, DrawParams r8) {
        if (r8 != null) goto L5;
        Log.e(TAG, "Invalid null argument(s) passed in call to draw.");
        return;
    L5:
        r7.save();
        Rect r0 = r8.iconBounds;
        if (r8.leftAlign == false) goto L8;
        float[] r1 = this.mLeftDotPosition;
    L9:
        float r2 = r0.left + (r0.width() * r1[0]);
        float r3 = r0.top + (r0.height() * r1[1]);
        Rect r4 = r7.getClipBounds();
        if (r8.leftAlign == false) goto L12;
        float r5 = Math.max(0.0f, r4.left - (this.mBitmapOffset + r2));
    L13:
        r7.translate(r2 + r5, r3 + Math.max(0.0f, r4.top - (this.mBitmapOffset + r3)));
        r7.scale(r8.scale, r8.scale);
        this.mCirclePaint.setColor(-16777216);
        Bitmap r6 = this.mBackgroundWithShadow;
        float r9 = this.mBitmapOffset;
        r7.drawBitmap(r6, r9, r9, this.mCirclePaint);
        this.mCirclePaint.setColor(r8.dotColor);
        r7.drawCircle(0.0f, 0.0f, this.mCircleRadius, this.mCirclePaint);
        r7.restore();
        return;
    L12:
        r5 = Math.min(0.0f, r4.right - (r2 - this.mBitmapOffset));
        goto L13
    L8:
        r1 = this.mRightDotPosition;
        goto L9
    }
}
