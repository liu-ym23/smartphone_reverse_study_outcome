package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec r1) {
        super(r1);
        this.arcDirectionFactor = 1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(Canvas r5, float r6) {
        float r0 = (((CircularProgressIndicatorSpec) this.spec).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
        r5.translate(r0, r0);
        r5.rotate(-90.0f);
        float r2 = -r0;
        r5.clipRect(r2, r2, r0, r0);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) goto L5;
        int r7 = 1;
    L6:
        this.arcDirectionFactor = r7;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) this.spec).trackThickness * r6;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) this.spec).trackCornerRadius * r6;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) this.spec).indicatorSize - ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        if (this.drawable.isShowing() == false) goto L11;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 2) goto L11;
    L14:
        this.adjustedRadius += ((1.0f - r6) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        return;
    L11:
        if (this.drawable.isHiding() == false) goto L16;
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1) goto L14;
    L16:
        if (this.drawable.isShowing() == false) goto L20;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 1) goto L20;
    L23:
        this.adjustedRadius -= ((1.0f - r6) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        return;
    L20:
        if (this.drawable.isHiding() == true) goto L22;
        return;
    L22:
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2) goto L23;
        return;
    L5:
        r7 = -1;
        goto L6
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(Canvas r14, Paint r15, float r16, float r17, int r18) {
        if (r16 != r17) goto L5;
        return;
    L5:
        r15.setStyle(Paint.Style.STROKE);
        r15.setStrokeCap(Paint.Cap.BUTT);
        r15.setAntiAlias(true);
        r15.setColor(r18);
        r15.setStrokeWidth(this.displayedTrackThickness);
        int r1 = this.arcDirectionFactor;
        float r10 = (r16 * 360.0f) * r1;
        if (r17 < r16) goto L8;
        float r0 = r17 - r16;
    L9:
        float r2 = (r0 * 360.0f) * r1;
        float r3 = this.adjustedRadius;
        r14.drawArc(new RectF(-r3, -r3, r3, r3), r10, r2, false, r15);
        if (this.displayedCornerRadius > 0.0f) goto L12;
        return;
    L12:
        if (Math.abs(r2) >= 360.0f) goto L16;
        r15.setStyle(Paint.Style.FILL);
        float r4 = this.displayedCornerRadius;
        RectF r12 = new RectF(-r4, -r4, r4, r4);
        drawRoundedEnd(r14, r15, this.displayedTrackThickness, this.displayedCornerRadius, r10, true, r12);
        drawRoundedEnd(r14, r15, this.displayedTrackThickness, this.displayedCornerRadius, r10 + r2, false, r12);
        return;
    L16:
        return;
    L8:
        r0 = (r17 + 1.0f) - r16;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas r8, Paint r9) {
        int r0 = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeCap(Paint.Cap.BUTT);
        r9.setAntiAlias(true);
        r9.setColor(r0);
        r9.setStrokeWidth(this.displayedTrackThickness);
        float r7 = this.adjustedRadius;
        r8.drawArc(new RectF(-r7, -r7, r7, r7), 0.0f, 360.0f, false, r9);
    }

    private int getSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize + (((CircularProgressIndicatorSpec) this.spec).indicatorInset * 2);
    }

    private void drawRoundedEnd(Canvas r13, Paint r14, float r15, float r16, float r17, boolean r18, RectF r19) {
        if (r18 == false) goto L5;
        float r1 = -1.0f;
    L6:
        float r8 = r1;
        r13.save();
        r13.rotate(r17);
        float r10 = r15 / 2.0f;
        float r2 = r8 * r16;
        r13.drawRect((this.adjustedRadius - r10) + r16, Math.min(0.0f, this.arcDirectionFactor * r2), (this.adjustedRadius + r10) - r16, Math.max(0.0f, r2 * this.arcDirectionFactor), r14);
        r13.translate((this.adjustedRadius - r10) + r16, 0.0f);
        r13.drawArc(r19, 180.0f, ((-r8) * 90.0f) * this.arcDirectionFactor, true, r14);
        r13.translate(r15 - (r16 * 2.0f), 0.0f);
        r13.drawArc(r19, 0.0f, (r8 * 90.0f) * this.arcDirectionFactor, true, r14);
        r13.restore();
        return;
    L5:
        r1 = 1.0f;
        goto L6
    }
}
