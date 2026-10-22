package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
class CutoutDrawable extends MaterialShapeDrawable {
    private final RectF cutoutBounds;
    private final Paint cutoutPaint;
    private int savedLayer;

    CutoutDrawable() {
        this(null);
    }

    CutoutDrawable(ShapeAppearanceModel r2) {
        if (r2 != null) goto L5;
        r2 = new ShapeAppearanceModel();
    L5:
        super(r2);
        this.cutoutPaint = new Paint(1);
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    void setCutout(float r2, float r3, float r4, float r5) {
        if (r2 == this.cutoutBounds.left) goto L5;
    L10:
        this.cutoutBounds.set(r2, r3, r4, r5);
        invalidateSelf();
        return;
    L5:
        if (r3 != this.cutoutBounds.top) goto L10;
        if (r4 != this.cutoutBounds.right) goto L10;
        if (r5 != this.cutoutBounds.bottom) goto L10;
    }

    void setCutout(RectF r4) {
        setCutout(r4.left, r4.top, r4.right, r4.bottom);
    }

    void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        preDraw(r3);
        super.draw(r3);
        r3.drawRect(this.cutoutBounds, this.cutoutPaint);
        postDraw(r3);
    }

    private void preDraw(Canvas r3) {
        Drawable.Callback r0 = getCallback();
        if (useHardwareLayer(r0) == false) goto L7;
        View r1 = (View) r0;
        if (r1.getLayerType() == 2) goto L9;
        r1.setLayerType(2, null);
        return;
    L9:
        return;
    L7:
        saveCanvasLayer(r3);
    }

    private void saveCanvasLayer(Canvas r7) {
        this.savedLayer = r7.saveLayer(0.0f, 0.0f, r7.getWidth(), r7.getHeight(), null);
    }

    private void postDraw(Canvas r2) {
        if (useHardwareLayer(getCallback()) == true) goto L6;
        r2.restoreToCount(this.savedLayer);
        return;
    }

    private boolean useHardwareLayer(Drawable.Callback r1) {
        return r1 instanceof View;
    }
}
