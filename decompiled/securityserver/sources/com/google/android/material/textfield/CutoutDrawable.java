package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes.dex */
class CutoutDrawable extends MaterialShapeDrawable {

    @NonNull
    private final RectF cutoutBounds;

    @NonNull
    private final Paint cutoutPaint;
    private int savedLayer;

    public CutoutDrawable() {
        this(null);
    }

    private void postDraw(@NonNull Canvas r2) {
        if (useHardwareLayer(getCallback()) == true) goto L6;
        r2.restoreToCount(this.savedLayer);
        return;
    }

    private void preDraw(@NonNull Canvas r3) {
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

    private void saveCanvasLayer(@NonNull Canvas r8) {
        this.savedLayer = r8.saveLayer(0.0f, 0.0f, r8.getWidth(), r8.getHeight(), null);
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean useHardwareLayer(Drawable.Callback r1) {
        return r1 instanceof View;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r3) {
        preDraw(r3);
        super.draw(r3);
        r3.drawRect(this.cutoutBounds, this.cutoutPaint);
        postDraw(r3);
    }

    public boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float r3, float r4, float r5, float r6) {
        RectF r0 = this.cutoutBounds;
        if (r3 == r0.left) goto L5;
    L10:
        r0.set(r3, r4, r5, r6);
        invalidateSelf();
        return;
    L5:
        if (r4 != r0.top) goto L10;
        if (r5 != r0.right) goto L10;
        if (r6 != r0.bottom) goto L10;
    }

    public CutoutDrawable(@Nullable ShapeAppearanceModel r2) {
        if (r2 != null) goto L5;
        r2 = new ShapeAppearanceModel();
    L5:
        super(r2);
        this.cutoutPaint = new Paint(1);
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    public void setCutout(@NonNull RectF r4) {
        setCutout(r4.left, r4.top, r4.right, r4.bottom);
    }
}
